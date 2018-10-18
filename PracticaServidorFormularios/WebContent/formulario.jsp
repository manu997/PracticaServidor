<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body {
		line-height: 2;
	}
</style>
</head>
<body>
<form action="EnviaYrecibe" method="post">
	<%
	String campo_nombre = (String) request.getAttribute("campo_nombre");
	if(campo_nombre == null) {
		campo_nombre = "";
	}
	String campo_fecha = (String) request.getAttribute("campo_fecha");
	if(campo_fecha == null) {
		campo_fecha = "";
	}
	String campo_nota = (String) request.getAttribute("campo_nota");
	if(campo_nota == null) {
		campo_nota = "";
	}
	String campo_comentarios = (String) request.getAttribute("campo_comentarios");
	if(campo_comentarios == null) {
		campo_comentarios = "";
	}
	
	String nombre_error = (String) request.getAttribute("nombre_error");
	String clave_error = (String) request.getAttribute("clave_error");
	String genero_error = (String) request.getAttribute("genero_error");
	String fecha_nac_error = (String) request.getAttribute("fecha_nac_error");
	String pais_error = (String) request.getAttribute("pais_error");
	String nota_media_error = (String) request.getAttribute("nota_media_error");
	String acepto_error = (String) request.getAttribute("acepto_error");
	
	String errores[] = new String[7];
	
	errores[0] = nombre_error;
	errores[1] = clave_error;
	errores[2] = genero_error;
	errores[3] = fecha_nac_error;
	errores[4] = pais_error;
	errores[5] = nota_media_error;
	errores[6] = acepto_error;
	
	String salida_errores = "";
	
	for(int i = 0; i < errores.length; i++) {
		if(errores[i] == null) {
			errores[i] = "";
		}
		salida_errores += errores[i];
	}

	String nombre_chequeado = (String) request.getAttribute("nombre");
	String genero_chequeado = (String) request.getAttribute("genero");
	String fecha_nac_chequeado = (String) request.getAttribute("fecha_nac");
	String pais_chequeado = (String) request.getAttribute("pais");
	String nota_media_chequeado = (String) request.getAttribute("nota_media");
	String comentarios_chequeado = (String) request.getAttribute("comentarios");
	
	String aciertos[] = new String[6];
	
	aciertos[0] = nombre_chequeado;
	aciertos[1] = genero_chequeado;
	aciertos[2] = fecha_nac_chequeado;
	aciertos[3] = pais_chequeado;
	aciertos[4] = nota_media_chequeado;
	aciertos[5] = comentarios_chequeado;
	
	String salida_aciertos = "";
	
	for(int i = 0; i < aciertos.length; i++) {
		if(aciertos[i] == null) {
			aciertos[i] = "";
		}
		salida_aciertos += aciertos[i];
	}
	%>
	<%--//////////////// Eco de los errores--%>
	<div style="color: red;"><%=salida_errores %></div>
	<%--////////////////--%>
	Nombre: <input type="text" name="nombre" value="<%=campo_nombre %>"/>
	<br>
	Clave: <input type="password" name="clave"/><br>
	Género: <input type="radio" name="genero" value="Hombre"/>Hombre
	<input type="radio" name="genero" value="Mujer"/>Mujer<br>
	Fecha de nacimiento: <input type="text" name="fecha_nac" value="<%=campo_fecha%>"/><br>
	País: <select name="pais">
			<option value=""/>
 			<option value="España">España</option>
 			<option value="Italia">Italia</option>
 			<option value="Francia">Francia</option>
	</select><br>
	Nota media: <input type="text" name="nota_media" value="<%=campo_nota %>"/><br>
	<input type="checkbox" name="acepto" value="ok"/> Acepto<br>
	<label>Comentarios: </label>
	<textarea cols="20" rows="10" name="comentarios"><%= campo_comentarios %></textarea><br>
	Foto: <input type="file" name="foto"/><br>
	<input type="submit" value="Enviar"/><br>
	<%=salida_aciertos %>
</form>
</body>
</html>