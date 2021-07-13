package log.parser.log.parser.blizzard.events.specific;

import java.util.List;

import log.parser.log.parser.blizzard.events.generic.SpellEvent;

public class SPELL_HEAL_ABSORBED extends SpellEvent {
	
	public static final String ABSORBED = "absorbed";
	public static final String RAW_HEAL = "rawHeal";
	
	public SPELL_HEAL_ABSORBED() {
		addFields(ABSORBED, RAW_HEAL);
	}
	
	public List<String> massageData(List<String> allData) {
		List<String> toReturn = super.massageData(allData);
		
		toReturn.add(allData.get(getFieldLocation(ABSORBED)));
		toReturn.add(allData.get(getFieldLocation(RAW_HEAL)));
		
		return toReturn;
	}
}
