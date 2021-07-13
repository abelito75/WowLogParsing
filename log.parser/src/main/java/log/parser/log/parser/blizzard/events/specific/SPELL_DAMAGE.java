package log.parser.log.parser.blizzard.events.specific;

import java.util.List;

import log.parser.log.parser.blizzard.events.generic.DamageEvent;
//TODO Check if this is all done correct :)

public class SPELL_DAMAGE extends DamageEvent {

	
	
	public List<String> massageData(List<String> allData) {
		List<String> toReturn = super.massageData(allData);
		
		
		
		return toReturn;
	}
}
