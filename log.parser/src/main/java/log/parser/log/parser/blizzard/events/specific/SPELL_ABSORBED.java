package log.parser.log.parser.blizzard.events.specific;

import java.util.List;

import log.parser.log.parser.blizzard.events.generic.SpellEvent;

//TODO Check if this is all done correct :)


public class SPELL_ABSORBED extends SpellEvent {
	
	public static final String SPELL_ID = "spellID";
	public static final String SPELL_NAME = "spellName";
	public static final String SPELL_SCHOOL = "spellSchool";
	
	public SPELL_ABSORBED() {
		//@addFields(SPELL_ID, SPELL_NAME, SPELL_SCHOOL);
	}
	
	public List<String> massageData(List<String> allData) {
		List<String> toReturn = super.massageData(allData);
		return toReturn;
	}


}
