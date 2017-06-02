package resurrectionFest.funcionalidad.clasesPrincipales.festival;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Pattern;

import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.FechaNoValidaException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.FechaPosteriorException;
import resurrectionFest.funcionalidad.clasesPrincipales.festival.excepciones.FormatoHoraNoValidoException;

public class Fecha implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * locale
	 */
	private static Locale es = Locale.getDefault();
	/**
	 * Fecha Inicio
	 */
	private LocalDate fechaInicio = LocalDate.now();
	/**
	 * Fecha final
	 */
	private LocalDate fechaFinal = LocalDate.now();

	/**
	 * Patrón para comprobar que la hora introducida sea válida
	 */
	private static final Pattern PATRON_HORA = Pattern.compile("2[0-3]\\:[0-5]\\d|1\\d\\:[0-5]\\d|0\\d\\:[0-5]\\d");

	/**
	 * Comprueba la fecha del festival
	 * 
	 * @param fecha
	 * @return
	 * @throws FechaNoValidaException
	 * @throws FechaPosteriorException
	 */
	boolean testFechaInicio(int dia, int mes, int anno) throws FechaNoValidaException, FechaPosteriorException {
		try {
			String fecha = "" + anno + "-" + String.format("%02d", mes) + "-" + String.format("%02d", dia);
			LocalDate fechaFestival = LocalDate.parse(fecha);
			if (LocalDate.now().isAfter(fechaFestival))
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
	boolean testFechaFinal(int dia, int mes, int anno) throws FechaNoValidaException, FechaPosteriorException {
		try {
			String fecha = "" + anno + "-" + String.format("%02d", mes) + "-" + String.format("%02d", dia);
			LocalDate fechaFestival = LocalDate.parse(fecha);
			if (LocalDate.now().isAfter(fechaFestival) || fechaInicio.isAfter(fechaFestival))
				throw new FechaPosteriorException("La fecha introducida es anterior a la fecha de inicio del festival");
		} catch (DateTimeParseException e) {
			throw new FechaNoValidaException("El formato no es válido (dd-mm-yyyy)");
		}
		return true;
	}

	/**
	 * Devuelve los días restantes para el inicio del festival
	 * 
	 * @param fechaInicio
	 * @return long
	 */
	long getDiasRestantes() {
		return ChronoUnit.DAYS.between(LocalDate.now(), getFechaInicio());
	}

	/**
	 * Devuelve la fecha en español
	 * 
	 * @param fecha
	 * @return
	 */
	String getFechaEspanola(LocalDate fecha) {
		return fecha.getDayOfMonth() + "/" + getMesCastellano(fecha) + "/" + fecha.getYear();
	}

	/**
	 * Devuelve el mes en castellano
	 * 
	 * @param fecha
	 * @return cadena
	 */
	public static String getMesCastellano(LocalDate fecha) {
		return fecha.getMonth().getDisplayName(TextStyle.FULL, es);
	}

	/**
	 * Devuelve un array de cadenas con los meses del año en castellano
	 * 
	 * @return meses
	 */
	public static String[] getMeses() {
		String[] meses = new String[Month.values().length];
		for (int i = 0; i < meses.length; i++) {
			switch (i) {
			default:
				meses[i] = Month.values()[i].getDisplayName(TextStyle.FULL, es);
			}
		}
		return meses;
	}
	
	/**
	 * Devuelve las fechas disponibles
	 * @return fechas
	 */
	LocalDate[] getFechas() {
		ArrayList<LocalDate> arrayList = new ArrayList<LocalDate>();
		LocalDate fechaStart = getFechaInicio();
		LocalDate fechaEnd = getFechaFinal();
		int i = 0;
		arrayList.add(fechaStart);
		while (fechaStart.plusDays(i++).compareTo(fechaEnd) != 0) {
			arrayList.add(fechaStart.plusDays(i));
		}
		LocalDate[] array = new LocalDate[arrayList.size()];
		int j = 0;
		for (LocalDate localDate : arrayList) {
			array[j++] = localDate;
		}

		return array;
	}
	
	/**
	 * Devuelve las fechas disponibles en formato string
	 * @return array de cadenas
	 */
	String[] getFechasString() {
		
		String[] fechas = new String[getFechas().length];
		int i = 0;
		for (LocalDate fecha : getFechas()) {
			fechas[i++] = fecha.format(formatoEspanol());
		}
		return fechas;
	}

	public static DateTimeFormatter formatoEspanol(){
		return DateTimeFormatter.ofPattern("EEEE , dd MMMM yyyy", es);
	}
	/**
	 * Devuelve los proximo 50 años partiendo del actual
	 * 
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
	 * 
	 * @param mes
	 * @param anno
	 * @return dias
	 */
	public static Integer[] getDias(Month mes, int anno) {
		ArrayList<Integer> dias = new ArrayList<Integer>();
		GregorianCalendar a = new GregorianCalendar();
		if (a.isLeapYear(anno)) {
			for (int i = 0; i < mes.maxLength(); i++) {
				dias.add((i + 1));
			}
		} else {
			for (int i = 0; i < mes.maxLength() - 1; i++) {
				dias.add((i + 1));
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
	 * Convierte una localDate a Date
	 * @param fecha
	 * @param hora
	 * @return Date
	 * @throws FormatoHoraNoValidoException
	 */
	@SuppressWarnings("deprecation")
	static Date localDateHourToDate(LocalDate fecha, String hora) throws FormatoHoraNoValidoException {
		if (!comprobarHora(hora))
			throw new FormatoHoraNoValidoException("El formato de la hora no es correcto (hh:mm)");
		return new Date(fecha.getYear()-1900, fecha.getMonthValue()-1, fecha.getDayOfMonth(),
				Integer.valueOf(hora.substring(0, 2)), Integer.valueOf(hora.substring(3, 5)));
		
	}

	/**
	 * Asigna una nueva fecha de inicio de festival
	 * @param dia
	 * @param mes
	 * @param anno
	 * @throws FechaNoValidaException
	 * @throws FechaPosteriorException
	 */
	void setFechaInicio(int dia, int mes, int anno) throws FechaNoValidaException, FechaPosteriorException {
		if (testFechaInicio(dia, mes, anno))
			fechaInicio = LocalDate.of(anno, mes, dia);
	}
	
	/**
	 * Asigna una nueva fecha de final de festival
	 * @param dia
	 * @param mes
	 * @param anno
	 * @throws FechaNoValidaException
	 * @throws FechaPosteriorException
	 */
	void setFechaFinal(int dia, int mes, int anno) throws FechaNoValidaException, FechaPosteriorException {
		if (testFechaFinal(dia, mes, anno))
			fechaFinal = LocalDate.of(anno, mes, dia);
	}

	/**
	 * Comprueba la hora
	 * 
	 * @param hora
	 * @return boolean
	 */
	public static boolean comprobarHora(String hora) {
		return PATRON_HORA.matcher(hora).matches();
	}

	LocalDate getFechaFinal() {
		return fechaFinal;
	}

	LocalDate getFechaInicio() {
		return fechaInicio;
	}
}
