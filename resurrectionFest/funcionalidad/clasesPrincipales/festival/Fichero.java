
package resurrectionFest.funcionalidad.clasesPrincipales.festival;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Clase para tratar con los ficheros.
 * 
 * @author Rafael Mellado Jiménez
 * @version 1.0
 *
 */
public class Fichero {

	public static Festival abrir(String ruta) throws ClassNotFoundException, FileNotFoundException, IOException {
		Festival festival = null;
		Object obj = null;
		try (ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(ruta)))) {
			obj = input.readObject();
		}

		if (obj instanceof Festival)
			festival = (Festival) obj;
		return festival;
	}

	public static void guardar(Festival festival, String ruta) throws FileNotFoundException, IOException {

		try (ObjectOutputStream output = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(asignarExtension(ruta))))) {
			output.writeObject(festival);
		}
	}

	private static String asignarExtension(String ruta) {
		if (ruta.substring(ruta.length() - 4, ruta.length()).equals(".fes"))
			return ruta;
		return ruta + ".fes";
	}

}
