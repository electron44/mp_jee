package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Administrateur;
import dao.AdminDAO;

/**
 * Servlet implementation class accueilServlet
 */
@WebServlet("")
public class accueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public accueilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =request.getRequestURI();
		if(action.endsWith("/")) {
			getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requested =request.getRequestURI();
		String username= request.getParameter("username");
		String password = request.getParameter("password");
		
		Administrateur admin = new Administrateur();
		admin.setUsername(username);
		admin.setPassword(password);
		AdminDAO admin_dao = new AdminDAO();
		boolean exist = false;
		if(admin.getUsername()!=null)
			exist =  admin_dao.connectAdmin(admin);
		
		if(exist) {
			HttpSession session=request.getSession();
			session.setAttribute("admin", admin);
			getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		}else {
			
		}
	}

}
