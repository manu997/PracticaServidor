import java.io.IOException;
import Utilidades.ChequeoLogicaNegocio;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EnviaYrecibe")
public class EnviaYrecibe extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EnviaYrecibe() {
        super();
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vista = "/formulario.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		ChequeoLogicaNegocio chequeo = new ChequeoLogicaNegocio();
		
		String nombre = (String) request.getParameter("nombre");
		chequeo.chequearNombre(nombre, request);
		
		String clave = (String) request.getParameter("clave");
		chequeo.chequearClave(clave, request);
		
		String genero = (String) request.getParameter("genero");
		chequeo.chequearGenero(genero, request);
		
		String fecha_nac = (String) request.getParameter("fecha_nac");
		chequeo.chequearFecha(fecha_nac, request);
		
		String pais = (String) request.getParameter("pais");
		chequeo.chequearPais(pais, request);
		
		String comentarios = (String) request.getParameter("comentarios");
		
		String nota = (String) request.getParameter("nota_media");
		chequeo.chequearNota(nota, request);
		
		boolean acepto = request.getParameter("acepto") != null;
		chequeo.chequearAcepto(acepto, request);
		
		if(chequeo.errores == 0) {
			request.setAttribute("nombre", "Nombre: "+ nombre + "<br />");
			request.setAttribute("genero", "Género: " + genero + "<br />");
			request.setAttribute("fecha_nac", "Fecha de nacimiento: " + fecha_nac + "<br />");
			request.setAttribute("pais", "País: " + pais + "<br />");
			request.setAttribute("nota_media", "Nota media: " + nota + "<br />");
			request.setAttribute("comentarios", "Comentarios: " + comentarios + "<br />");
		} else {
			request.setAttribute("campo_nombre", nombre);
			request.setAttribute("campo_fecha", fecha_nac);
			request.setAttribute("campo_nota", nota);
			request.setAttribute("campo_comentarios", comentarios);
		}
		doGet(request, response);
	}
}
