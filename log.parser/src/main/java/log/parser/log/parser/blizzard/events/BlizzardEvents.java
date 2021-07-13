package log.parser.log.parser.blizzard.events;

import log.parser.log.parser.blizzard.events.generic.BlizzardEvent;
import log.parser.log.parser.blizzard.events.specific.ARENA_MATCH_END;
import log.parser.log.parser.blizzard.events.specific.ARENA_MATCH_START;
import log.parser.log.parser.blizzard.events.specific.CHALLENGE_MODE_END;
import log.parser.log.parser.blizzard.events.specific.CHALLENGE_MODE_START;
import log.parser.log.parser.blizzard.events.specific.COMBATANT_INFO;
import log.parser.log.parser.blizzard.events.specific.COMBAT_LOG_VERSION;
import log.parser.log.parser.blizzard.events.specific.DAMAGE_SHIELD;
import log.parser.log.parser.blizzard.events.specific.DAMAGE_SHIELD_MISSED;
import log.parser.log.parser.blizzard.events.specific.DAMAGE_SPLIT;
import log.parser.log.parser.blizzard.events.specific.EMOTE;
import log.parser.log.parser.blizzard.events.specific.ENCHANT_APPLIED;
import log.parser.log.parser.blizzard.events.specific.ENCHANT_REMOVED;
import log.parser.log.parser.blizzard.events.specific.ENCOUNTER_END;
import log.parser.log.parser.blizzard.events.specific.ENCOUNTER_START;
import log.parser.log.parser.blizzard.events.specific.ENVIRONMENTAL_DAMAGE;
import log.parser.log.parser.blizzard.events.specific.MAP_CHANGE;
import log.parser.log.parser.blizzard.events.specific.PARTY_KILL;
import log.parser.log.parser.blizzard.events.specific.RANGE_DAMAGE;
import log.parser.log.parser.blizzard.events.specific.RANGE_MISSED;
import log.parser.log.parser.blizzard.events.specific.SPELL_ABSORBED;
import log.parser.log.parser.blizzard.events.specific.SPELL_AURA_APPLIED;
import log.parser.log.parser.blizzard.events.specific.SPELL_AURA_APPLIED_DOSE;
import log.parser.log.parser.blizzard.events.specific.SPELL_AURA_BROKEN;
import log.parser.log.parser.blizzard.events.specific.SPELL_AURA_BROKEN_SPELL;
import log.parser.log.parser.blizzard.events.specific.SPELL_AURA_REFRESH;
import log.parser.log.parser.blizzard.events.specific.SPELL_AURA_REMOVED;
import log.parser.log.parser.blizzard.events.specific.SPELL_AURA_REMOVED_DOSE;
import log.parser.log.parser.blizzard.events.specific.SPELL_BUILDING_DAMAGE;
import log.parser.log.parser.blizzard.events.specific.SPELL_BUILDING_HEAL;
import log.parser.log.parser.blizzard.events.specific.SPELL_CAST_FAILED;
import log.parser.log.parser.blizzard.events.specific.SPELL_CAST_START;
import log.parser.log.parser.blizzard.events.specific.SPELL_CAST_SUCCESS;
import log.parser.log.parser.blizzard.events.specific.SPELL_CREATE;
import log.parser.log.parser.blizzard.events.specific.SPELL_DAMAGE;
import log.parser.log.parser.blizzard.events.specific.SPELL_DISPEL;
import log.parser.log.parser.blizzard.events.specific.SPELL_DISPEL_FAILED;
import log.parser.log.parser.blizzard.events.specific.SPELL_DRAIN;
import log.parser.log.parser.blizzard.events.specific.SPELL_DURABILITY_DAMAGE;
import log.parser.log.parser.blizzard.events.specific.SPELL_DURABILITY_DAMAGE_ALL;
import log.parser.log.parser.blizzard.events.specific.SPELL_ENERGIZE;
import log.parser.log.parser.blizzard.events.specific.SPELL_EXTRA_ATTACKS;
import log.parser.log.parser.blizzard.events.specific.SPELL_HEAL;
import log.parser.log.parser.blizzard.events.specific.SPELL_HEAL_ABSORBED;
import log.parser.log.parser.blizzard.events.specific.SPELL_INSTAKILL;
import log.parser.log.parser.blizzard.events.specific.SPELL_INTERRUPT;
import log.parser.log.parser.blizzard.events.specific.SPELL_LEECH;
import log.parser.log.parser.blizzard.events.specific.SPELL_MISSED;
import log.parser.log.parser.blizzard.events.specific.SPELL_PERIODIC_DAMAGE;
import log.parser.log.parser.blizzard.events.specific.SPELL_PERIODIC_DRAIN;
import log.parser.log.parser.blizzard.events.specific.SPELL_PERIODIC_ENERGIZE;
import log.parser.log.parser.blizzard.events.specific.SPELL_PERIODIC_HEAL;
import log.parser.log.parser.blizzard.events.specific.SPELL_PERIODIC_LEECH;
import log.parser.log.parser.blizzard.events.specific.SPELL_PERIODIC_MISSED;
import log.parser.log.parser.blizzard.events.specific.SPELL_RESURRECT;
import log.parser.log.parser.blizzard.events.specific.SPELL_STOLEN;
import log.parser.log.parser.blizzard.events.specific.SPELL_SUMMON;
import log.parser.log.parser.blizzard.events.specific.SWING_DAMAGE;
import log.parser.log.parser.blizzard.events.specific.SWING_DAMAGE_LANDED;
import log.parser.log.parser.blizzard.events.specific.SWING_MISSED;
import log.parser.log.parser.blizzard.events.specific.UNIT_DESTROYED;
import log.parser.log.parser.blizzard.events.specific.UNIT_DIED;
import log.parser.log.parser.blizzard.events.specific.UNIT_DISSIPATES;
import log.parser.log.parser.blizzard.events.specific.WORLD_MARKER_PLACED;
import log.parser.log.parser.blizzard.events.specific.WORLD_MARKER_REMOVED;
import log.parser.log.parser.blizzard.events.specific.ZONE_CHANGE;

public enum BlizzardEvents {

	DAMAGE_SHIELD("DAMAGE_SHIELD","damage",new DAMAGE_SHIELD()),
	DAMAGE_SHIELD_MISSED("DAMAGE_SHIELD_MISSED","damage",new DAMAGE_SHIELD_MISSED()),
	DAMAGE_SPLIT("DAMAGE_SPLIT","damage",new DAMAGE_SPLIT()),
	ENCHANT_APPLIED("ENCHANT_APPLIED","damage",new ENCHANT_APPLIED()),
	ENCHANT_REMOVED("ENCHANT_REMOVED","damage",new ENCHANT_REMOVED()),
	ENVIRONMENTAL_DAMAGE("ENVIRONMENTAL_DAMAGE","damage",new ENVIRONMENTAL_DAMAGE()),
	PARTY_KILL("PARTY_KILL","damage",new PARTY_KILL()),
	RANGE_DAMAGE("RANGE_DAMAGE","damage",new RANGE_DAMAGE()),
	RANGE_MISSED("RANGE_MISSED","damage",new RANGE_MISSED()),
	SPELL_AURA_APPLIED("SPELL_AURA_APPLIED","damage",new SPELL_AURA_APPLIED()),
	SPELL_AURA_APPLIED_DOSE("SPELL_AURA_APPLIED_DOSE","damage",new SPELL_AURA_APPLIED_DOSE()),
	SPELL_AURA_BROKEN("SPELL_AURA_BROKEN","damage",new SPELL_AURA_BROKEN()),
	SPELL_AURA_BROKEN_SPELL("SPELL_AURA_BROKEN_SPELL","damage",new SPELL_AURA_BROKEN_SPELL()),
	SPELL_AURA_REFRESH("SPELL_AURA_REFRESH","damage",new SPELL_AURA_REFRESH()),
	SPELL_AURA_REMOVED("SPELL_AURA_REMOVED","damage",new SPELL_AURA_REMOVED()),
	SPELL_AURA_REMOVED_DOSE("SPELL_AURA_REMOVED_DOSE","damage",new SPELL_AURA_REMOVED_DOSE()),
	SPELL_BUILDING_DAMAGE("SPELL_BUILDING_DAMAGE","damage",new SPELL_BUILDING_DAMAGE()),
	SPELL_BUILDING_HEAL("SPELL_BUILDING_HEAL","damage",new SPELL_BUILDING_HEAL()),
	SPELL_CAST_FAILED("SPELL_CAST_FAILED","damage",new SPELL_CAST_FAILED()),
	SPELL_CAST_START("SPELL_CAST_START","damage",new SPELL_CAST_START()),
	SPELL_CAST_SUCCESS("SPELL_CAST_SUCCESS","damage",new SPELL_CAST_SUCCESS()),
	SPELL_CREATE("SPELL_CREATE","damage",new SPELL_CREATE()),
	SPELL_DAMAGE("SPELL_DAMAGE","damage",new SPELL_DAMAGE()),
	SPELL_DISPEL("SPELL_DISPEL","damage",new SPELL_DISPEL()),
	SPELL_DISPEL_FAILED("SPELL_DISPEL_FAILED","damage",new SPELL_DISPEL_FAILED()),
	SPELL_DRAIN("SPELL_DRAIN","damage",new SPELL_DRAIN()),
	SPELL_DURABILITY_DAMAGE("SPELL_DURABILITY_DAMAGE","damage",new SPELL_DURABILITY_DAMAGE()),
	SPELL_DURABILITY_DAMAGE_ALL("SPELL_DURABILITY_DAMAGE_ALL","damage",new SPELL_DURABILITY_DAMAGE_ALL()),
	SPELL_ENERGIZE("SPELL_ENERGIZE","damage",new SPELL_ENERGIZE()),
	SPELL_EXTRA_ATTACKS("SPELL_EXTRA_ATTACKS","damage",new SPELL_EXTRA_ATTACKS()),
	SPELL_HEAL("SPELL_HEAL","damage",new SPELL_HEAL()),
	SPELL_INSTAKILL("SPELL_INSTAKILL","damage",new SPELL_INSTAKILL()),
	SPELL_INTERRUPT("SPELL_INTERRUPT","damage",new SPELL_INTERRUPT()),
	SPELL_LEECH("SPELL_LEECH","damage",new SPELL_LEECH()),
	SPELL_MISSED("SPELL_MISSED","damage",new SPELL_MISSED()),
	SPELL_PERIODIC_DAMAGE("SPELL_PERIODIC_DAMAGE","damage",new SPELL_PERIODIC_DAMAGE()),
	SPELL_PERIODIC_DRAIN("SPELL_PERIODIC_DRAIN","damage",new SPELL_PERIODIC_DRAIN()),
	SPELL_PERIODIC_ENERGIZE("SPELL_PERIODIC_ENERGIZE","damage",new SPELL_PERIODIC_ENERGIZE()),
	SPELL_PERIODIC_HEAL("SPELL_PERIODIC_HEAL","damage",new SPELL_PERIODIC_HEAL()),
	SPELL_PERIODIC_LEECH("SPELL_PERIODIC_LEECH","damage",new SPELL_PERIODIC_LEECH()),
	SPELL_PERIODIC_MISSED("SPELL_PERIODIC_MISSED","damage",new SPELL_PERIODIC_MISSED()),
	SPELL_RESURRECT("SPELL_RESURRECT","damage",new SPELL_RESURRECT()),
	SPELL_STOLEN("SPELL_STOLEN","damage",new SPELL_STOLEN()),
	SPELL_SUMMON("SPELL_SUMMON","damage",new SPELL_SUMMON()),
	SWING_DAMAGE("SWING_DAMAGE","damage",new SWING_DAMAGE()),
	SWING_MISSED("SWING_MISSED","damage",new SWING_MISSED()),
	UNIT_DESTROYED("UNIT_DESTROYED","damage",new UNIT_DESTROYED()),
	UNIT_DIED("UNIT_DIED","damage",new UNIT_DIED()),
	UNIT_DISSIPATES("UNIT_DISSIPATES","damage",new UNIT_DISSIPATES()),
	ARENA_MATCH_START("ARENA_MATCH_START","damage",new ARENA_MATCH_START()),
	ARENA_MATCH_END("ARENA_MATCH_END","damage",new ARENA_MATCH_END()),
	ZONE_CHANGE("ZONE_CHANGE","damage",new ZONE_CHANGE()),
	COMBATANT_INFO("COMBATANT_INFO","damage",new COMBATANT_INFO()),
	COMBAT_LOG_VERSION("COMBAT_LOG_VERSION","damage",new COMBAT_LOG_VERSION()),
	ENCOUNTER_START("ENCOUNTER_START","damage",new ENCOUNTER_START()),
	ENCOUNTER_END("ENCOUNTER_END","damage",new ENCOUNTER_END()),
	MAP_CHANGE("MAP_CHANGE","damage",new MAP_CHANGE()),
	CHALLENGE_MODE_END("CHALLENGE_MODE_END","damage",new CHALLENGE_MODE_END()),
	CHALLENGE_MODE_START("CHALLENGE_MODE_START","damage",new CHALLENGE_MODE_START()),
	SPELL_ABSORBED("SPELL_ABSORBED","damage",new SPELL_ABSORBED()),
	SWING_DAMAGE_LANDED("SWING_DAMAGE_LANDED","damage",new SWING_DAMAGE_LANDED()),
	SPELL_HEAL_ABSORBED("SPELL_HEAL_ABSORBED","damage",new SPELL_HEAL_ABSORBED()),
	EMOTE("EMOTE","damage",new EMOTE()),
	WORLD_MARKER_PLACED("WORLD_MARKER_PLACED","damage",new WORLD_MARKER_PLACED()),
	WORLD_MARKER_REMOVED("WORLD_MARKER_REMOVED","damage",new WORLD_MARKER_REMOVED());
	
	private String blizzardName;
	private String ourName;
	private BlizzardEvent event;
	
	private BlizzardEvents(String blizzardName, String ourName, BlizzardEvent event) {
		this.blizzardName = blizzardName;
		this.ourName = ourName;
		this.event = event;
	}

	public String getBlizzardName() {
		return blizzardName;
	}

	public String getOurName() {
		return ourName;
	}
	
	public BlizzardEvent getEvent() {
		return event;
	}
	
	public static BlizzardEvents blizzardNameToOurName(String blizzardName) {
		for(BlizzardEvents event : BlizzardEvents.values()) {
			if(blizzardName.equals(event.getBlizzardName())){
				return event;
			}
		}
		return null;
	}

	// In the grand scheme of things this will determine the size of the table
	public static int maxFields() {
		int max = 0;
		
		for(BlizzardEvents event : BlizzardEvents.values()) {
			max = Math.max(max, event.getEvent().getFieldCount());
		}
		
		return max;
	}
	
}
