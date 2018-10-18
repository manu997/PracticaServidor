import java.io.IOException;  
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RecibeParametros")
public class RecibeParametros extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RecibeParametros() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String nombre = request.getParameter("nombre");
		String genero = request.getParameter("genero");
		String fecha_nac = request.getParameter("fecha_nac");
		String pais = request.getParameter("pais");
		String nota_media = request.getParameter("nota_media");
		String comentarios = request.getParameter("comentarios");
		String clave = request.getParameter("clave");
		
		out.println("Nombre: "+nombre+"<br>");
		out.println("Clave: "+clave+"<br>");
		out.println("Género: "+genero+"<br>");
		out.println("Fecha de nacimiento: "+fecha_nac+"><br>");
		out.println("País: "+pais+"<br>");
		out.println("Nota media: "+nota_media+"<br>");
		out.println("Comentarios: "+comentarios+"<br>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
