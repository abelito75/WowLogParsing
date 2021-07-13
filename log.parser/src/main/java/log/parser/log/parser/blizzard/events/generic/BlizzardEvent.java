package log.parser.log.parser.blizzard.events.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BlizzardEvent {
	
	private List<String> fieldsInOrder;
	
	public static final String HUMAN_DATE = "date";
	public static final String ADJUSTED_TIME = "time";
	public static final String EVENT = "event";
			
	
	public BlizzardEvent() {
		fieldsInOrder = new ArrayList<>();
		addFields(HUMAN_DATE, ADJUSTED_TIME, EVENT);
	}

	public void addField(String field) {
		fieldsInOrder.add(field);
	}
	
	public void addFields(String...fields){
		for(String field : fields) {
			addField(field);
		}
	}
	
	public void AddFields(Collection<String> fields) {
		for(String field : fields) {
			addField(field);
		}
	}
	
	public List<String> getFields(){
		return fieldsInOrder;
	}
	
	public int getFieldCount() {
		return fieldsInOrder.size();
	}
	
	public int getFieldLocation(String event) {
		return fieldsInOrder.indexOf(event);
	}
	
	public List<String> massageData(List<String> allData) {
		List<String> toReturn = new ArrayList<>();
		toReturn.add(allData.get(getFieldLocation(HUMAN_DATE)));
		toReturn.add(allData.get(getFieldLocation(ADJUSTED_TIME)));
		toReturn.add(allData.get(getFieldLocation(EVENT)));
		return toReturn;
	}
}
