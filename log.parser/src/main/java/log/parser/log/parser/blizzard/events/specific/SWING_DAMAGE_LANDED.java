package log.parser.log.parser.blizzard.events.specific;

import java.util.ArrayList;
import java.util.List;

import log.parser.log.parser.blizzard.events.generic.DamageEvent;

public class SWING_DAMAGE_LANDED extends DamageEvent {

	private List<String> swingSpellInfo;
	
	public SWING_DAMAGE_LANDED() {
		swingSpellInfo = new ArrayList<>();
		swingSpellInfo.add("1");
		swingSpellInfo.add("Melee");
		swingSpellInfo.add("0x1");
	}
	
	public List<String> massageData(List<String> allData) {
		List<String> ourData = new ArrayList<>(allData);
		ourData.addAll(getFieldLocation(DESTINATION_RAID_FLAGS), swingSpellInfo);
		List<String> toReturn = super.massageData(ourData);
		
		return toReturn;
	}
}
