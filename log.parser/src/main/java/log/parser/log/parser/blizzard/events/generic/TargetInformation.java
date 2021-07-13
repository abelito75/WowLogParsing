package log.parser.log.parser.blizzard.events.generic;

import java.util.List;

public class TargetInformation extends SpellEvent {

	public static final String TARGET_GUID = "targetGUID";
	public static final String ENVIRONMENT = "environment";
	public static final String AFTER_EVENT_HP = "afterEventHP";
	public static final String MAX_HP = "maxHP";
	public static final String AP = "ap";
	public static final String SP = "sp";
	public static final String ARMOR = "armor";
	public static final String ABSORB = "absorb";
	public static final String RESOURCE_TYPE = "resourceType";
	public static final String RESOURCE_AMOUNT = "resourceAmount";
	public static final String RESOURCE_MAX = "resourceMax";
	public static final String IDK = "idk";
	public static final String X = "x";
	public static final String Y = "y";
	public static final String Z = "z";
	public static final String HEADING = "heading";
	public static final String ILVL = "ilvl";
	
	public TargetInformation() {
		addFields(TARGET_GUID, ENVIRONMENT, AFTER_EVENT_HP, MAX_HP, AP, SP, ARMOR, ABSORB, RESOURCE_TYPE, RESOURCE_AMOUNT, RESOURCE_MAX, IDK, X, Y, Z, HEADING, ILVL);
	}
	
	public List<String> massageData(List<String> allData) {
		List<String> toReturn = super.massageData(allData);
		
		toReturn.add(allData.get(getFieldLocation(TARGET_GUID)));
		toReturn.add(allData.get(getFieldLocation(ENVIRONMENT)));
		toReturn.add(allData.get(getFieldLocation(AFTER_EVENT_HP)));
		toReturn.add(allData.get(getFieldLocation(MAX_HP)));
		toReturn.add(allData.get(getFieldLocation(AP)));
		toReturn.add(allData.get(getFieldLocation(SP)));
		toReturn.add(allData.get(getFieldLocation(ARMOR)));
		toReturn.add(allData.get(getFieldLocation(ABSORB)));
		toReturn.add(allData.get(getFieldLocation(RESOURCE_TYPE)));
		toReturn.add(allData.get(getFieldLocation(RESOURCE_AMOUNT)));
		toReturn.add(allData.get(getFieldLocation(RESOURCE_MAX)));
		toReturn.add(allData.get(getFieldLocation(IDK)));
		toReturn.add(allData.get(getFieldLocation(X)));
		toReturn.add(allData.get(getFieldLocation(Y)));
		toReturn.add(allData.get(getFieldLocation(Z)));
		toReturn.add(allData.get(getFieldLocation(HEADING)));
		toReturn.add(allData.get(getFieldLocation(ILVL)));
		
		return toReturn;
	}
}
