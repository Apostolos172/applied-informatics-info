package mvcModel;

import architecture.*;

import java.io.IOException;
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
@WebServlet("/ProfessorControllerServlet")
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
		
		ArrayList<Professor> professors = listProfessors();
		request.setAttribute("professors", professors);
		
		// RequestDispatcher dispatcher = request.getRequestDispatcher("/test.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-professors.jsp");
		dispatcher.forward(request, response);
		
	}

	private ArrayList<Professor> listProfessors() {
		// TODO Auto-generated method stub
		
		return this.databaseAccesserObject.getProfessors(); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
