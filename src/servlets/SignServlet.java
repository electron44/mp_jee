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
 * Servlet implementation class SignServlet
 */
@WebServlet(urlPatterns= {"/login","/logout"})
public class SignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestedUrl = request.getServletPath();

		if (requestedUrl.equals("/login"))
		{
			getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request,response);
		}
		else
		{
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect(request.getContextPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username= request.getParameter("username");
		String password = request.getParameter("password");
		Administrateur admin = new Administrateur();
		admin.setPassword(password);
		admin.setPassword(password);
		AdminDAO admindao = new AdminDAO();
		boolean exist = admindao.connectAdmin(admin);
		
		if(exist) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp");
		}
	}

}
