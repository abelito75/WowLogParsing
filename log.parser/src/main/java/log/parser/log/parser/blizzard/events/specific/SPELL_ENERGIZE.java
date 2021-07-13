package log.parser.log.parser.blizzard.events.specific;

import java.util.List;

import log.parser.log.parser.blizzard.events.generic.TargetInformation;

public class SPELL_ENERGIZE extends TargetInformation {

	public static final String AMOUNT = "amount";
	public static final String OVERCAP = "overcap";
	public static final String TYPE = "type";
	public static final String MAX = "max";
	
	public SPELL_ENERGIZE() {
		addFields(AMOUNT, OVERCAP, TYPE, MAX);
	}
	
	
	public List<String> massageData(List<String> allData) {
		List<String> toReturn = super.massageData(allData);
		toReturn.add(allData.get(getFieldLocation(AMOUNT)));
		toReturn.add(allData.get(getFieldLocation(OVERCAP)));
		toReturn.add(allData.get(getFieldLocation(TYPE)));
		toReturn.add(allData.get(getFieldLocation(MAX)));
		return toReturn;
	}
}
