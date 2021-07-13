package log.parser.log.parser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;
import log.parser.log.parser.blizzard.events.BlizzardEvents;
import log.parser.log.parser.blizzard.events.specific.ENCOUNTER_START;

public class BlizzardParser {
	
	private File toParse;
	private FightBuilder currentFight;
	private int maxEvents;
	private Set<String> unmappedEvents;
	
	public BlizzardParser(File file) {
		toParse = file;
		unmappedEvents = new HashSet<>();
	}
	
	public void start() throws IOException {
		maxEvents = BlizzardEvents.maxFields();
		try (CsvReader csv = CsvReader.builder().build(Paths.get(toParse.getAbsolutePath()), Charset.defaultCharset())) {
		    csv.forEach(line -> parseLine(line));
		}
	}

	private void parseLine(CsvRow line) {
		// Lets convert into something we can manipulate
		List<String> editableLine = new ArrayList<>(line.getFields());
				
		// Step one is to handle the bullshit they do at the start with spaces instead of commas 
		String dateTimeEvent = editableLine.get(0);
		String date = dateTimeEvent.substring(0,dateTimeEvent.indexOf(" "));
		String time = dateTimeEvent.substring(dateTimeEvent.indexOf(" ") + 1, dateTimeEvent.lastIndexOf(" ") - 1);
		String event = dateTimeEvent.substring(dateTimeEvent.lastIndexOf(" ") + 1);
		
		// Step two is to determine if we are in a fight or not
		// if we are in a fight add to the fight object
		BlizzardEvents ourEvent = BlizzardEvents.blizzardNameToOurName(event);
		// Make sure we know the event in general
		if(ourEvent == null) {
			if(!unmappedEvents.contains(event)) {
				System.out.println(event);
				unmappedEvents.add(event);
			}
			return;
		}
		
		if(BlizzardEvents.ENCOUNTER_START.getBlizzardName().equals(event)) {
			currentFight = new FightBuilder();
			currentFight.setStartEvent(editableLine);
		}
		
		if(currentFight == null) {
			return;
		}
		
		// Step Four Data massaging
		
		// Since date doesn't have year we are gonna massage that out here so we can then conver to Epoch time
		long fileModifiedTime = toParse.lastModified();
	    Calendar cal = Calendar.getInstance();
	    cal.setTimeZone(TimeZone.getTimeZone("UTC"));
	    cal.setTimeInMillis(fileModifiedTime);
	    // Grab the current year
	    int currentYear = cal.get(Calendar.YEAR);
	    date = date + "/" + currentYear;
	    
	    
		String dateTime = date + " " + time;
		
		// fix date and event stuffs
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
		long adjustedTime;
		try {
		    Date d = f.parse(dateTime);
		    long currentTime = d.getTime();
		    
		    if(currentFight.getOffSet() == 0) {
		    	currentFight.setOffSet(currentTime);
		    }
		    
		    adjustedTime = currentTime - currentFight.getOffSet();
		} catch (ParseException e) {
			//TODO Add logging library and make it handle this shit
		    e.printStackTrace();
		    return;
		}
		
		editableLine.set(0, dateTime);
		editableLine.add(1, Long.toString(adjustedTime));
		editableLine.add(2, event);
		
		// This will only fire off on ENCOUNTER_START events
		if(currentFight.getTableName() == null) {
			int bossNameIndex = BlizzardEvents.ENCOUNTER_START.getEvent().getFieldLocation(ENCOUNTER_START.BOSS);
			String bossName = editableLine.get(bossNameIndex);
			currentFight.setBossName(bossName);
			currentFight.generateTableName();
		}
		
		List<String> toAdd = ourEvent.getEvent().massageData(editableLine);
		
		
		
		try {
			currentFight.insertIntoFight(toAdd.toArray(new String[maxEvents]));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(BlizzardEvents.ENCOUNTER_START.getBlizzardName().equals(event)) {
			currentFight.setStartEvent(toAdd);
		}
		
		if(BlizzardEvents.ENCOUNTER_END.getBlizzardName().equals(event)) {
			currentFight.setEndEvent(toAdd);
			currentFight.flush();
			currentFight.updateFightIndexTable();
			currentFight.close();
			currentFight = null;
		}
	}
	
	public static void main(String[] args) throws IOException {		
		System.out.println("Starting");
		long startTime = System.currentTimeMillis();
		new BlizzardParser(new File("C:\\Users\\the man\\Desktop\\data\\WoWCombatLogModernParsing.txt")).start();
		System.out.println("Done");
		System.out.println((System.currentTimeMillis() - startTime) / 1000);
	}
	
}
