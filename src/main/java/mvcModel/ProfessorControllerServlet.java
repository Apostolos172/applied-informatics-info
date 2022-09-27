package mvcModel;

import architecture.*;
import util.Useful;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ProfessorControllerServlet
 */
//@WebServlet("/ProfessorControllerServlet")
public class ProfessorControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/ep_professors-courses")
	private DataSource dataSource;
	
	private ProfessorDBUtil databaseAccesserObject;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			this.databaseAccesserObject = new ProfessorDBUtil(dataSource);
		} catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessorControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String command = null;
		if(request.getParameter("command")==null)
			command = "list";
		else
			command = request.getParameter("command");		
		
		switch(command) {
		  case "add":
		    // code block
			  addProfessor(request, response);
		    break;
		  case "remove":
		    // code block
			  removeProfessor(request, response);
		    break;
		  case "load":
			  updateProfessorGet(request, response);
			  break;
		  default:
			  listProfessors(request, response);
		    // code block
		}	
		
	}

	private void updateProfessorGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String profEmail = request.getParameter("professorEmail");
		NormalProfessor prof = this.databaseAccesserObject.loadProfessor(profEmail);
		request.setAttribute("professor", prof);
		System.out.println(prof.toString());
		RequestDispatcher disp = request.getRequestDispatcher("/update-professor.jsp");
		disp.forward(request, response);
	}

	private void removeProfessor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String emailOfProfessorForRemoving = request.getParameter("email");
		databaseAccesserObject.removeProfessor(emailOfProfessorForRemoving);
		//listProfessors(request, response);
		response.sendRedirect(request.getContextPath() + "/ProfessorControllerServlet"+"?command=list");
		//System.out.println(request.getContextPath());

	}

	private void addProfessor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//byte[] bytes;
		String fname = request.getParameter("fname");
//		System.out.println(fname);
//		bytes = fname.getBytes(StandardCharsets.UTF_8);
//		fname = new String(bytes, StandardCharsets.UTF_8);
//		System.out.println(new String(bytes, StandardCharsets.UTF_8));
		String lname = request.getParameter("lname");
//		bytes = lname.getBytes(StandardCharsets.UTF_8);
//		lname = new String(bytes, StandardCharsets.UTF_8);
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String cat = request.getParameter("cat");
		
		Professor newProf = Useful.getAppropriateProfessorObj(cat, fname, lname, phone, email);
		this.databaseAccesserObject.addProfessor(newProf);
		
		//listProfessors(request, response);
		response.sendRedirect(request.getContextPath() + "/ProfessorControllerServlet"+"?command=list");
		System.out.println(getServletName());
		System.out.println(request.getContextPath() + "/ProfessorControllerServlet");
	}

	private void listProfessors(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<Professor> professors = this.databaseAccesserObject.getProfessors(request);
		request.setAttribute("professors", professors);
		
		// RequestDispatcher dispatcher = request.getRequestDispatcher("/test.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-professors.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
        request.setCharacterEncoding("UTF-8");
		
		String command = null;
		if(request.getParameter("command")==null)
			command = "list";
		else
			command = request.getParameter("command");		
		
		switch(command) {
		  case "add":
		    // code block
			  addProfessor(request, response);
		    break;
		  case "update":
			  updateProfessor(request, response);
			  // to do update professor
			  break;
		  default:
			  listProfessors(request, response);
		    // code block
		}	
	}

	private void updateProfessor(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String previousEmail = request.getParameter("previousEmail");
		NormalProfessor prof = new NormalProfessor(fname, lname, phone, email);
		this.databaseAccesserObject.updateProfessor(prof, previousEmail);
		//System.out.println("getContextPath: " + this.getServletContext().getContextPath());
		response.sendRedirect(this.getServletContext().getContextPath() + "/ProfessorControllerServlet"+"?command=list");
		
	}

}
