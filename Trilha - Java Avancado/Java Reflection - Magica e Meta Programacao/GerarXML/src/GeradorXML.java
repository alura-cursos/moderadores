import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


public class GeradorXML {

	public String getXML(Object obj) throws Exception {
		StringBuilder xml = new StringBuilder();
		Class<?> clazz = obj.getClass();
		xml.append("<" + clazz.getSimpleName() + "> \n");
		for(Field field : clazz.getDeclaredFields()) {
			xml.append("\t <" + field.getName() + ">");
			field.setAccessible(true);
			xml.append(field.get(obj));
			xml.append("</" + field.getName() + "> \n");
		}
		xml.append("</" + clazz.getSimpleName() + ">");
		return xml.toString();
	}
	
	public HashMap<String,Object> getMap(Object obj) throws Exception {
		HashMap<String, Object> fields = new HashMap<String, Object>();		
		for(Field field : obj.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			fields.put(field.getName(), field.get(obj));
		}
		return fields;
	}
	
}
