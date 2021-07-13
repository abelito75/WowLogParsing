package log.parser.log.parser.blizzard.events.generic;

import java.util.List;

public class DamageEvent extends TargetInformation {

	public static final String TOTAL_DAMAGE = "totalDamage";
	public static final String RAW_DAMAGE = "rawDamage";
	public static final String OVERKILL = "overkill";
	public static final String DAMAGE_SCHOOL = "damageSchool";
	public static final String RESISTED_DAMAGE = "resistedDamage";
	public static final String BLOCKED_DAMAGE = "blockedDamage";
	public static final String ABSORBED_DAMAGE = "absorbedDamage";
	public static final String CRITICAL = "crit";
	public static final String GLANCING = "glancing";
	public static final String CRUSHING = "crushing";
	public static final String EFFECTIVE_DAMAGE = "effectiveDamage";
	
	public DamageEvent() {
		addFields(TOTAL_DAMAGE, RAW_DAMAGE, OVERKILL, DAMAGE_SCHOOL, RESISTED_DAMAGE, BLOCKED_DAMAGE, ABSORBED_DAMAGE, CRITICAL, GLANCING, CRUSHING, EFFECTIVE_DAMAGE);
	}
	
	public List<String> massageData(List<String> allData) {
		List<String> toReturn = super.massageData(allData);
		
		String totalDamage = allData.get(getFieldLocation(TOTAL_DAMAGE));
		String rawDamage = allData.get(getFieldLocation(RAW_DAMAGE));
		String overkill = allData.get(getFieldLocation(OVERKILL));
		String resistedDamage = allData.get(getFieldLocation(RESISTED_DAMAGE));
		String blockedDamage = allData.get(getFieldLocation(BLOCKED_DAMAGE));
		String absorbedDamage = allData.get(getFieldLocation(ABSORBED_DAMAGE));
		
		toReturn.add(totalDamage);
		toReturn.add(rawDamage);
		toReturn.add(overkill);
		toReturn.add(allData.get(getFieldLocation(DAMAGE_SCHOOL)));
		toReturn.add(resistedDamage);
		toReturn.add(blockedDamage);
		toReturn.add(absorbedDamage);
		toReturn.add(allData.get(getFieldLocation(CRITICAL)));
		toReturn.add(allData.get(getFieldLocation(GLANCING)));
		toReturn.add(allData.get(getFieldLocation(CRUSHING)));
		
		// time to math out effective damage
		// idea is 
		// effective damage = totalDamage - resistedDamage - blockedDamage - overkill - absorbedDamage
		
		// Step One convert Strings to numbers
		int totalDamageInt = Integer.parseInt(totalDamage);
		int overkillInt = Integer.parseInt(overkill);
		int resistedDamageInt = Integer.parseInt(resistedDamage);
		int blockedDamageInt = Integer.parseInt(blockedDamage);
		int absorbedDamageInt = Integer.parseInt(absorbedDamage);
		
		overkillInt += overkillInt == -1 ? 1 : 0;
		
		// Step Two do math
		int effectiveDamage = totalDamageInt - overkillInt - resistedDamageInt - blockedDamageInt - absorbedDamageInt;
		
		
		toReturn.add(Integer.toString(effectiveDamage));
		
		return toReturn;
	}
}
