import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ValidadorNulo {

	public List<String> getAtributosNulos(Object obj) throws Exception {
		List<String> lista = new ArrayList<String>();
		Class<?> clazz = obj.getClass();
		for (Field field : clazz.getFields()) {
			Object value = field.get(obj);
			if (value == null)
				lista.add(field.getName());
		}
		return lista;
	}
	
}
