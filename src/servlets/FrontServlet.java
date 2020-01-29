package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Administrateur;
import beans.Client;
import dao.AdminDAO;
import dao.ClientDAO;
 

@WebServlet(urlPatterns= {"","clients/list","clients/new","clients/delete","clients/update"})
public class FrontServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClientDAO clientDAO;
 
    public void init() {
        String jdbcURL = "jdbc:mysql://localhost:3306/test";
        String jdbcUsername = "root";
        String jdbcPassword = "";
 
        clientDAO = new ClientDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String requested =request.getRequestURI();
		String username= request.getParameter("login");
		String password = request.getParameter("password");
		
		Administrateur admin = new Administrateur();
		admin.setUsername(username);
		admin.setPassword(password);
		AdminDAO admin_dao = new AdminDAO();
		boolean exist =  admin_dao.connectAdmin(admin);
		
		if(exist) {
			HttpSession session=request.getSession();
			session.setAttribute("admin", admin);
			getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		}else {
			
		}
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    		String action = request.getRequestURI();
    		System.out.println(action);
    		
    		
    }
 
    private void listClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Client> listClient = clientDAO.listAllClients();
        request.setAttribute("listClient", listClient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Listings.jsp");
        dispatcher.forward(request, response);
    }
 
 
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String login = request.getParameter("login");
        Client existingClient = clientDAO.getClient(login);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/AjoutClient.jsp");
        request.setAttribute("Client", existingClient);
        dispatcher.forward(request, response);
 
    }
 
    private void insertClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String password  = request.getParameter("password");
        String login = request.getParameter("login");
        String job_title = request.getParameter("job_title");
 
        Client newClient = new Client(nom,prenom,login,job_title,password);
        clientDAO.insertClient(newClient);
        response.sendRedirect("clients/list");
    }
 
    private void updateClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String login = request.getParameter("login");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String job_title = request.getParameter("job_title");
        String password = request.getParameter("password");
 
        Client client = new Client(nom, prenom, login,job_title,password);
        clientDAO.updateClient(client);
        response.sendRedirect("list");
    }
 
    private void deleteClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String login = request.getParameter("login");
 
        Client client = new Client();
        clientDAO.deleteClient(client);
        response.sendRedirect("list");
 
    }
    
}