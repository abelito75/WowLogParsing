package log.parser.log.parser.blizzard.events.generic;

import java.util.List;

public class AuraAppliedRemoveEvent extends TargetToDestinationEvent {

	public final static String AURA_ID = "auraID";
	public final static String AURA_NAME = "auraName";
	public final static String AURA_SCHOOL = "auraSchool";
	public final static String AURA_TYPE = "auraType";
	
	public AuraAppliedRemoveEvent() {
		addFields(AURA_ID, AURA_NAME, AURA_SCHOOL, AURA_TYPE);
	}
	
	public List<String> massageData(List<String> allData) {
		List<String> toReturn = super.massageData(allData);
		toReturn.add(allData.get(getFieldLocation(AURA_ID)));
		toReturn.add(allData.get(getFieldLocation(AURA_NAME)));
		toReturn.add(allData.get(getFieldLocation(AURA_SCHOOL)));
		toReturn.add(allData.get(getFieldLocation(AURA_TYPE)));
		return toReturn;
	}

}
