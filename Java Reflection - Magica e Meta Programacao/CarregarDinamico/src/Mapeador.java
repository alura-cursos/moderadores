import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class Mapeador {

	private Map<Class<?>, Class<?>> mapa = new HashMap<>();
	
	public void load(String arquivo) throws Exception {
		Properties p = new Properties();
		p.load(new FileInputStream(arquivo));
		for (Object key : p.keySet()) {
			Class<?> interf = Class.forName(key.toString());
			Class<?> impl = Class.forName(p.get(key).toString());
			if (!interf.isInterface())
				throw new RuntimeException("A classe " + interf.getName() + " não é uma interface");
			if (!interf.isAssignableFrom(impl))
				throw new RuntimeException("A classe " + impl.getName() + " não implementa " + interf.getName());
			mapa.put(interf, impl);
		}
	}
	
	public Class<?> getImplementacao(Class<?> interf) {
		return mapa.get(interf);
	}
	
	public <E> E getInstancia(Class<E> interf) throws Exception {
		return (E) mapa.get(interf).newInstance();
	}
	
	public <E> E getInstancia(Class<E> interf, Object... params) throws Exception {
		Class<?>[] tiposContrutor = new Class<?>[params.length];
		for (int i = 0; i < tiposContrutor.length; i++) {
			tiposContrutor[i] = params[i].getClass();
		}
		Constructor<?> constructor = mapa.get(interf).getConstructor(tiposContrutor);
		return (E) constructor.newInstance(params);
	}
}
