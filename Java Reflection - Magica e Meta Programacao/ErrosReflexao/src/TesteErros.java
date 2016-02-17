import java.lang.reflect.Method;


public class TesteErros {

	public static void main(String[] args) throws Exception {
		TesteErros obj = new TesteErros();
		Class clazz = obj.getClass();
		Method method = clazz.getMethod("metodo", String.class);
		method.invoke(obj);
	}
	
	public void metodo(String s) {
		
	}
	
}
