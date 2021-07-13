package log.parser.log.parser.blizzard.events.specific;

import java.util.List;

import log.parser.log.parser.blizzard.events.generic.SpellEvent;

public class SPELL_CAST_FAILED extends SpellEvent {
	
	public static final String FAILED_REASON = "failedReason";
	
	public SPELL_CAST_FAILED() {
		addField(FAILED_REASON);
	}
	
	public List<String> massageData(List<String> allData) {
		List<String> toReturn = super.massageData(allData);
		toReturn.add(allData.get(getFieldLocation(FAILED_REASON)));
		return toReturn;
	}
	
}
