package resurrectionFest.funcionalidad.clasesPrincipales.festival;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.FechaNoValidaException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.FechaPosteriorException;

public class Fecha {

	/**
	 * Comprueba la fecha del festival
	 * 
	 * @param fecha
	 * @return
	 * @throws FechaNoValidaException
	 * @throws FechaPosteriorException
	 */
	static boolean testFechaInicio(String fecha)
			throws FechaNoValidaException, FechaPosteriorException {
		try {
			LocalDate fechaFestival = LocalDate.parse(fecha);
			if (LocalDate.now().isAfter(fechaFestival) )
				throw new FechaPosteriorException("La fecha introducida ya ha pasado");

		} catch (DateTimeParseException e) {
			throw new FechaNoValidaException("El formato no es válido (dd-mm-yyyy)");
		}
		return true;
	}

	/**
	 * Comprueba la fecha del festival
	 * 
	 * @param fecha
	 * @return
	 * @throws FechaNoValidaException
	 * @throws FechaPosteriorException
	 */
	static boolean testFechaFinal(String fecha, LocalDate fechaInicio)
			throws FechaNoValidaException, FechaPosteriorException {
		try {
			LocalDate fechaFestival = LocalDate.parse(fecha);
			if (LocalDate.now().isAfter(fechaFestival) || fechaInicio.isAfter(fechaFestival) )
				throw new FechaPosteriorException("La fecha introducida es anterior a la fecha de inicio del festival");

		} catch (DateTimeParseException e) {
			throw new FechaNoValidaException("El formato no es válido (dd-mm-yyyy)");
		}
		return true;
	}

	static long getDiasRestantes(LocalDate fechaInicio) {
		return ChronoUnit.DAYS.between(LocalDate.now(), fechaInicio);
	}

	static String getFechaEspanola(LocalDate fecha) {
		return fecha.getDayOfMonth() + "/" + getMesCastellano(fecha) + "/" + fecha.getYear();
	}

	public static String getMesCastellano(LocalDate fecha) {
		String mes = "";
		switch (fecha.getMonth().getValue()) {
		case 1:
			mes = "Enero";
			break;
		case 2:
			mes = "Febrero";
			break;
		case 3:
			mes = "Marzo";
			break;
		case 4:
			mes = "Abril";
			break;
		case 5:
			mes = "Mayo";
			break;
		case 6:
			mes = "Junio";
			break;
		case 7:
			mes = "Julio";
			break;
		case 8:
			mes = "Agosto";
			break;
		case 9:
			mes = "Septiembre";
			break;
		case 10:
			mes = "Octubre";
			break;
		case 11:
			mes = "Noviembre";
			break;
		default:
			mes = "Diciembre";
			break;
		}
		return mes;
	}

	/**
	 * Devuelve un array de cadenas con los meses del año en castellano
	 * 
	 * @return meses
	 */
	public static String[] getMeses() {
		String[] meses = new String[12];
		for (int i = 0; i < meses.length; i++) {
			switch (i) {
			case 0:
				meses[i] = "Enero";
				break;
			case 1:
				meses[i] = "Febrero";
				break;
			case 2:
				meses[i] = "Marzo";
				break;
			case 3:
				meses[i] = "Abril";
				break;
			case 4:
				meses[i] = "Mayo";
				break;
			case 5:
				meses[i] = "Junio";
				break;
			case 6:
				meses[i] = "Julio";
				break;
			case 7:
				meses[i] = "Agosto";
				break;
			case 8:
				meses[i] = "Septiembre";
				break;
			case 9:
				meses[i] = "Octubre";
				break;
			case 10:
				meses[i] = "Noviembre";
				break;
			default:
				meses[i] = "Diciembre";
				break;
			}
		}
		return meses;
	}

	
	/**
	 * Devuelve los proximo 50 años partiendo del actual
	 * @return años
	 */
	public static Integer[] getAnnos() {
		ArrayList<Integer> annos = new ArrayList<Integer>();
		for (int i = LocalDate.now().getYear(); i < LocalDate.now().getYear() + 50; i++) {
			annos.add(i);
		}
		Integer[] anyos = new Integer[annos.size()];
		int i = 0;
		for (Integer integer : annos) {
			anyos[i++] = integer;
		}

		return anyos;
	}

	/**
	 * Devuelve los días del mes en funcion del año y mes que sea
	 * @param mes
	 * @param anno
	 * @return dias
	 */
	public static Integer[] getDias(Month mes, int anno) {
		ArrayList<Integer> dias = new ArrayList<Integer>();
		if (comprobarBisiesto(anno)) {
			for (int i = 0; i < mes.maxLength(); i++) {
				dias.add((i+1));
			}
		} else {
			for (int i = 0; i < mes.maxLength()-1; i++) {
				dias.add((i+1));
			}
		}
		Integer[] dia = new Integer[dias.size()];
		int i = 0;
		for (Integer integer : dias) {
			dia[i++] = integer;
		}
		return dia;
	}

	/**
	 * Comprueba si es bisiesto
	 * @param anno
	 * @return boolean
	 */
	private static boolean comprobarBisiesto(int anno) {
		if ((anno % 4 == 0) && ((anno % 100 != 0) || (anno % 400 == 0)))
			return true;
		return false;
	}

}
