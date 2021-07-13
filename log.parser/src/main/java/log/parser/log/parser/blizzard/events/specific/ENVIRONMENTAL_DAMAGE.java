package log.parser.log.parser.blizzard.events.specific;

import java.util.ArrayList;
import java.util.List;

import log.parser.log.parser.blizzard.events.generic.DamageEvent;

public class ENVIRONMENTAL_DAMAGE extends DamageEvent {
	
	
	public List<String> massageData(List<String> allData) {
		List<String> ourData = new ArrayList<>(allData);
		
		List<String> environmental_Info = new ArrayList<>();
		environmental_Info.add("-10");
		environmental_Info.add(ourData.get(28));
		environmental_Info.add("0x1");
		
		ourData.remove(28);//Randomly says Falling... thanks blizzard great to know
		
		ourData.addAll(getFieldLocation(DESTINATION_RAID_FLAGS), environmental_Info);
		List<String> toReturn = super.massageData(ourData);
		
		return toReturn;
	}
}
