package edu.itesm.mx.xochimilco.services;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.itesm.mx.xochimilco.dao.CultureDAO;

@SuppressWarnings("serial")
public class InsertCultureServicesServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String nombre= (String) req.getParameter("nombre");
		String descripcion= (String) req.getParameter("descripcion");
		CultureDAO.getInstance().agrega(nombre, descripcion);
	}

}
