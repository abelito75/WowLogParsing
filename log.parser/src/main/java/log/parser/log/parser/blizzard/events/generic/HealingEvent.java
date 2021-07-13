package log.parser.log.parser.blizzard.events.generic;

import java.util.List;

public class HealingEvent extends TargetInformation {

	public static final String TOTAL_HEAL = "totalHeal";
	public static final String RAW_HEAL = "rawHeal";
	public static final String OVERHEAL = "overheal";
	public static final String ABSORBED = "absorbed";
	public static final String CRITICAL = "crit";
	public static final String EFFECTIVE_HEAL = "effectiveHeal";
	
	public HealingEvent() {
		addFields(TOTAL_HEAL, RAW_HEAL, OVERHEAL, ABSORBED, CRITICAL, EFFECTIVE_HEAL);
	}
	
	public List<String> massageData(List<String> allData) {
		List<String> toReturn = super.massageData(allData);
		
		String totalHeal = allData.get(getFieldLocation(TOTAL_HEAL));
		String rawHeal = allData.get(getFieldLocation(RAW_HEAL));
		String overheal = allData.get(getFieldLocation(OVERHEAL));
		String absorbed = allData.get(getFieldLocation(ABSORBED));
		
		toReturn.add(totalHeal);
		toReturn.add(rawHeal);
		toReturn.add(overheal);
		toReturn.add(absorbed);
		toReturn.add(allData.get(getFieldLocation(CRITICAL)));
		
		// time to math out effective heal
		// idea is 
		// effective heal = totalHeal - overheal - absorbed
		
		// Step One convert Strings to numbers
		int totalHealInt = Integer.parseInt(totalHeal);
		int overhealInt = Integer.parseInt(overheal);
		int absorbedInt = Integer.parseInt(absorbed);
				
		// Step Two do math
		int effectiveHeal = totalHealInt - overhealInt - absorbedInt;
		
		
		toReturn.add(Integer.toString(effectiveHeal));
		
		return toReturn;
	}
	
}
