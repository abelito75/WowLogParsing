package log.parser.log.parser.blizzard.events.generic;

import java.util.List;

public class AuraStackChangeEvent extends AuraAppliedRemoveEvent {

	public static final String STACKS = "stacks";
	
	public AuraStackChangeEvent() {
		addField(STACKS);
	}

	public List<String> massageData(List<String> allData) {
		List<String> toReturn = super.massageData(allData);
		toReturn.add(allData.get(getFieldLocation(STACKS)));
		return toReturn;
	}
	
}
