//TODO Check if this is all done correct :)
package log.parser.log.parser.blizzard.events.specific;

import java.util.List;

import log.parser.log.parser.blizzard.events.generic.TargetToDestinationEvent;

public class SWING_MISSED extends TargetToDestinationEvent {
	
	public static final String MISS_REASON = "missReason";
	public static final String IDK = "IDK";
	
	public SWING_MISSED() {
		addFields(MISS_REASON, IDK);
	}
	
	public List<String> massageData(List<String> allData) {
		List<String> toReturn = super.massageData(allData);
		toReturn.add(allData.get(getFieldLocation(MISS_REASON)));
		toReturn.add(allData.get(getFieldLocation(IDK)));
		return toReturn;
	}

}
