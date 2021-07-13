package log.parser.log.parser.blizzard.events.specific;

import java.util.List;

import log.parser.log.parser.blizzard.events.generic.AuraStackChangeEvent;

public class SPELL_AURA_REFRESH extends AuraStackChangeEvent {

	
	public List<String> massageData(List<String> allData) {
		// Blizzard made refresh events not have the stack amount of its refreshing a buff
		// But if its refreshing a shield or something with stacks then it does have a stack amount
		if(allData.size()==15) {
			allData.add("1");
		}
		List<String> toReturn = super.massageData(allData);
		toReturn.add(allData.get(getFieldLocation(STACKS)));
		return toReturn;
	}
}
