package log.parser.log.parser.blizzard.events.generic;

import java.util.List;

public class SpellEvent extends TargetToDestinationEvent {

	public static final String SPELL_ID = "spellID";
	public static final String SPELL_NAME = "spellName";
	public static final String SPELL_SCHOOL = "spellSchool";
	
	public SpellEvent() {
		addFields(SPELL_ID, SPELL_NAME, SPELL_SCHOOL);
	}
	
	public List<String> massageData(List<String> allData) {
		List<String> toReturn = super.massageData(allData);
		
		toReturn.add(allData.get(getFieldLocation(SPELL_ID)));
		toReturn.add(allData.get(getFieldLocation(SPELL_NAME)));
		toReturn.add(allData.get(getFieldLocation(SPELL_SCHOOL)));
		
		return toReturn;
	}
}
