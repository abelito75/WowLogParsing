package log.parser.log.parser.blizzard.events.generic;

import java.util.List;

public class TargetToDestinationEvent extends BlizzardEvent {

	public static final String SOURCE_GUID = "souceGUID";
	public static final String SOURCE_NAME = "sourceName";
	public static final String SOURCE_FLAGS = "sourceFlags";
	public static final String SOURCE_RAID_FLAGS = "sourceRaidFlags";
	public static final String DESTINATION_GUID = "destinationGUID";
	public static final String DESTINATION_NAME = "destinationName";
	public static final String DESTINATION_FLAGS = "destinationFlags";
	public static final String DESTINATION_RAID_FLAGS = "destinationRaidFlags";
	
	public TargetToDestinationEvent() {
		addFields(SOURCE_GUID, SOURCE_NAME, SOURCE_FLAGS, SOURCE_RAID_FLAGS, DESTINATION_GUID, DESTINATION_NAME, DESTINATION_FLAGS, DESTINATION_RAID_FLAGS);
	}
	
	public List<String> massageData(List<String> allData) {
		List<String> toReturn = super.massageData(allData);
		toReturn.add(allData.get(getFieldLocation(SOURCE_GUID)));
		toReturn.add(allData.get(getFieldLocation(SOURCE_NAME)));
		toReturn.add(allData.get(getFieldLocation(SOURCE_FLAGS)));
		toReturn.add(allData.get(getFieldLocation(SOURCE_RAID_FLAGS)));
		toReturn.add(allData.get(getFieldLocation(DESTINATION_GUID)));
		toReturn.add(allData.get(getFieldLocation(DESTINATION_NAME)));
		toReturn.add(allData.get(getFieldLocation(DESTINATION_FLAGS)));
		toReturn.add(allData.get(getFieldLocation(DESTINATION_RAID_FLAGS)));
		return toReturn;
	}
}
