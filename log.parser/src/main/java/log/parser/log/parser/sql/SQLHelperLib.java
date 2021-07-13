package log.parser.log.parser.sql;

import log.parser.log.parser.blizzard.events.BlizzardEvents;

public class SQLHelperLib {

	private SQLHelperLib() {}

	public static String buildTableVariables() {
		int columns = BlizzardEvents.maxFields();
		StringBuilder stb = new StringBuilder();
		stb.append(" (");
	
		for(int i = 0; i < (columns-1); i++) {
			stb.append("var");
			stb.append(i);
			stb.append(" text,");
		}
		
		stb.append("var");
		stb.append(columns-1);
		stb.append(" text);");
		

		return stb.toString();
	}
	
	public static String preparedInsert(String table) {
		int columns = BlizzardEvents.maxFields();
		StringBuilder stb = new StringBuilder();
		stb.append("insert into ");
		stb.append(table);
		stb.append(" values(");
		
		for(int i = 0; i < (columns-1); i++) {
			stb.append("?,");
		}
		
		stb.append("?);");		
		
		return stb.toString();
	}
}
