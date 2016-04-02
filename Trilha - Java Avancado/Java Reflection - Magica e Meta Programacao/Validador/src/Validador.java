import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Validador {

	public boolean validarObjeto(Object obj) throws Exception {
		boolean resultado = true;
		for(Method method : obj.getClass().getMethods()) {
			if (method.getName().startsWith("validar") && method.getParameterTypes().length == 0 &&
					method.getReturnType() == boolean.class) {
				Boolean retorno = (Boolean) method.invoke(obj);
				resultado = resultado && retorno.booleanValue();
			}
		}
		return resultado;
	}
	
}
