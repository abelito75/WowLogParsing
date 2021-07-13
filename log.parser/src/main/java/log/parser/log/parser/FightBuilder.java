package log.parser.log.parser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import log.parser.log.parser.blizzard.events.BlizzardEvents;
import log.parser.log.parser.blizzard.events.generic.BlizzardEvent;
import log.parser.log.parser.blizzard.events.specific.ENCOUNTER_END;
import log.parser.log.parser.blizzard.events.specific.ENCOUNTER_START;
import log.parser.log.parser.sql.SQLHelperLib;

public class FightBuilder {

	private String bossName;
	private String tableName;
	private long offSet;
	
	private Connection conn;
	private PreparedStatement prep;
	private int queuedInserts;
	
	private boolean oneFightTableCreated;
	
	private String oneFightTableVars;
	
	private List<String> startEvent;
	private List<String> endEvent;

	public FightBuilder() {
		oneFightTableCreated = false;
		oneFightTableVars = SQLHelperLib.buildTableVariables();
	}
	
	public FightBuilder(String bossName) {
		this();
		this.bossName = bossName;
	}

	public void insertIntoFight(String[] toAdd) throws SQLException  {
		
		if(conn == null) {
			conn = DriverManager.getConnection("jdbc:sqlite:test.db");
			conn.getMetaData();
		}
		
		if(!oneFightTableCreated) {
			Statement stmt = conn.createStatement();
			stmt.execute(createOneFightTable());
			oneFightTableCreated = true;
			conn.setAutoCommit(false);
		}
		
		if(prep == null) {
			prep = conn.prepareStatement(SQLHelperLib.preparedInsert(tableName));
		}
		
		int i = 1;
		for(String item : toAdd) {
			prep.setString(i, item);
			i++;
		}
		
		prep.addBatch();
		
		queuedInserts++;
		
		if(queuedInserts == 50000) {
			prep.executeBatch();
			conn.commit();
			queuedInserts = 0;
		}
	}
	
	public void flush() {
		try {
			prep.executeBatch();
		}catch(SQLException e) {
			
		}
		try {
			conn.commit();
		}catch(SQLException e) {
			
		}
	}
	
	public void close() {
		flush();//MAKE SURE WE FLUSH
		try {
			conn.close();
		}catch(SQLException e) {
			
		}
	}
	
	public void lastDamageEvent(List<String> damageEvent) {
		// determine if its to player or to boss(es)
		
		// add correct boss
		
	}
	
	public void updateFightIndexTable(){
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(createFightIndexTable());
			conn.commit();

			
			String bossName = startEvent.get(BlizzardEvents.ENCOUNTER_START.getEvent().getFieldLocation(ENCOUNTER_START.BOSS));
			String time = startEvent.get(BlizzardEvents.ENCOUNTER_START.getEvent().getFieldLocation(ENCOUNTER_START.HUMAN_DATE));
			String kill = endEvent.get(BlizzardEvents.ENCOUNTER_END.getEvent().getFieldLocation(ENCOUNTER_END.SUCCESS));
			
			// TODO: Update table to include last % on boss if not a kill
			
			String insert = "INSERT INTO fightIndex VALUES (?, ?, ?);";
			
			PreparedStatement prepper = conn.prepareStatement(insert);
			
			prepper.setString(1, bossName);
			prepper.setString(2, time);
			prepper.setString(3, kill);
			
			prepper.execute();
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public String createFightIndexTable() {
		return "CREATE TABLE IF NOT EXISTS fightIndex (boss text, date text, kill text)";
	}
	
	public String createOneFightTable() {
		return "CREATE TABLE IF NOT EXISTS " + tableName + oneFightTableVars;
	}

	public void setOffSet(long offSet) {
		this.offSet = offSet;
	}

	public long getOffSet() {
		return offSet;
	}
	
	public void setBossName(String bossName) {
		this.bossName = bossName.replace(" ", "_").replace(",", "").replace("'", "").replace("\"", "");
	}
	
	public void setStartEvent(List<String> startEvent) {
		this.startEvent = startEvent;
	}
	
	public void setEndEvent(List<String> endEvent) {
		this.endEvent = endEvent;
	}
	
	/**
	 * Uniquely generates table name from given list of data
	 * @param fightStartEvent
	 */
	public void generateTableName() {
		tableName = bossName + "_" + offSet;
	}
	
	public String getTableName() {
		return tableName;
	}
}
