package log.parser.log.parser;

import java.util.List;

public class Fight {

	private String bossName;
	private String tableName;
	private int pull;
	private boolean kill;
	private int endingPercent;
		
	public Fight() {
	}
	
	public Fight(String bossName) {
		this.bossName = bossName;
	}
	
	public Fight(String bossName, String tableName, int pull, boolean kill, int endingPercent) {
		this.bossName = bossName;
		this.tableName = tableName;
		this.pull = pull;
		this.kill = kill;
		this.endingPercent = endingPercent;
	}

	public void insertIntoFight(List<String> toAdd)  {

	}
	
	public void queryFight(String orSomething) {
		
	}
	
	
	public String getBossName() {
		return bossName;
	}

	public void setBossName(String bossName) {
		this.bossName = bossName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getPull() {
		return pull;
	}

	public void setPull(int pull) {
		this.pull = pull;
	}

	public boolean isKill() {
		return kill;
	}

	public void setKill(boolean kill) {
		this.kill = kill;
	}

	public int getEndingPercent() {
		return endingPercent;
	}

	public void setEndingPercent(int endingPercent) {
		this.endingPercent = endingPercent;
	}
}
