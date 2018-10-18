package Utilidades;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class ChequeoLogicaNegocio {
	public int errores = 0;
	public void chequearNombre(String nombre, HttpServletRequest request) {
		if(nombre == "") {
			request.setAttribute("nombre_error", "ERROR: El campo NOMBRE es OBLIGATORIO<br />");
			errores++;
		}
	}
	public void chequearClave(String clave, HttpServletRequest request) {
		if(clave.length() < 6 || clave.length() > 12) {
			request.setAttribute("clave_error", "ERROR: La clave debe tener entre 6 y 12 caracteres<br />");
			errores++;
		}
	}
	public void chequearGenero(String genero, HttpServletRequest request) {
		if(genero == null) {
			request.setAttribute("genero_error", "ERROR: El campo GÉNERO es OBLIGATORIO<br />");
			errores++;
		}
	}
	public void chequearFecha(String fecha, HttpServletRequest request) {
		try {
			String dateFormat = "dd/MM/yyyy";
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			Date date = sdf.parse(fecha); // Si no es capaz de crear la variable 'date' quiere decir que se ha introducido mal la fecha.
		} catch(ParseException e) {
			request.setAttribute("fecha_nac_error", "ERROR: El campo FECHA DE NACIMIENTO tiene que tener formato dd/mm/aaaa<br />");
			errores++;
		}
	}
	public void chequearPais(String pais, HttpServletRequest request) {
		if(pais == "") {
			request.setAttribute("pais_error", "ERROR: El campo PAÍS es OBLIGATORIO<br />");
			errores++;
		}
	}
	public void chequearNota(String nota, HttpServletRequest request) {
		try {
			float nota_media = Float.parseFloat(nota);
			if(nota_media < 0 || nota_media > 10) {
				request.setAttribute("nota_media_error", "ERROR: La nota media debe ser un numero entre 0 y 10<br />");
				errores++;
			}
		} catch(NumberFormatException e) {
			request.setAttribute("nota_media_error", "ERROR: La nota media debe ser un numero entre 0 y 10<br />");
			errores++;
		}
	}
	public void chequearAcepto(boolean acepto, HttpServletRequest request) {
		if(!acepto) {
			request.setAttribute("acepto_error", "ERROR: El campo ACEPTO es OBLIGATORIO<br />");
			errores++;
		}
	}
}