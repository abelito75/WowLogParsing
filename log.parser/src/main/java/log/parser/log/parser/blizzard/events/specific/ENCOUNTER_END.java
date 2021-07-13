package log.parser.log.parser.blizzard.events.specific;

import java.util.List;

import log.parser.log.parser.blizzard.events.generic.BlizzardEvent;

public class ENCOUNTER_END extends BlizzardEvent {
	
	public static final String ENCOUNTER_ID = "encounterID";
	public static final String BOSS = "bossName";
	public static final String DIFFICULTY_ID = "difficultyID";
	public static final String GROUP_SIZE = "groupSize";
	public static final String SUCCESS = "success";
	
	public ENCOUNTER_END() {
		addFields(ENCOUNTER_ID, BOSS, DIFFICULTY_ID, GROUP_SIZE, SUCCESS);
	}
	
	public List<String> massageData(List<String> allData) {
		List<String> toReturn = super.massageData(allData);
		toReturn.add(allData.get(getFieldLocation(ENCOUNTER_ID)));
		toReturn.add(allData.get(getFieldLocation(BOSS)));
		toReturn.add(allData.get(getFieldLocation(DIFFICULTY_ID)));
		toReturn.add(allData.get(getFieldLocation(GROUP_SIZE)));
		toReturn.add(allData.get(getFieldLocation(SUCCESS)));
		return toReturn;
	}
}
