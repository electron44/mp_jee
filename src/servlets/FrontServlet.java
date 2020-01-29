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
 

@WebServlet(urlPatterns= {"/clients/*"})
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
		String action =request.getRequestURI();

    	if(action.endsWith("/clients/insert")) {
			request.setCharacterEncoding("UTF-8");
    		try {
				insertClient(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(action.endsWith("/clients/update")) {
			request.setCharacterEncoding("UTF-8");
			    try {
					updateClient(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    		String action =request.getRequestURI();
    		//System.out.println(action);
    		try {
    			
    			if(action.endsWith("/clients/list")) {
	    			request.setCharacterEncoding("UTF-8");
	    			listClient(request, response);
	    		}
	    		else if(action.endsWith("/clients/new")) {
	    			request.setCharacterEncoding("UTF-8");
	    			  RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/AjoutClient.jsp");
	    		      dispatcher.forward(request, response);
	    		}
	    		else if(action.endsWith("/clients/delete")) {
	                deleteClient(request, response);
	    		}
	    		else if(action.endsWith("/clients/edit")) {
	    			request.setCharacterEncoding("UTF-8");
	    			 showEditForm(request, response);
	    		}
	    		
	    		
    		}catch(SQLException sqlex) {
                System.out.println("Probléme au nibeau du SQL");
    		}
    		
    		
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
        request.setAttribute("client", existingClient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/AjoutClient.jsp");
        dispatcher.forward(request, response);
    }
 
    private void insertClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException,ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String password  = request.getParameter("password");
        String login = request.getParameter("login");
        String job_title = request.getParameter("job_title");
 
        Client newClient = new Client();
        newClient.setLast_name(nom);
        newClient.setFirst_name(prenom);
        newClient.setJob_title(job_title);
        newClient.setLogin(login);
        newClient.setPassword(password);
        clientDAO.insertClient(newClient);
        response.sendRedirect("list");
    }
 
    private void updateClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String login = request.getParameter("login");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String job_title = request.getParameter("job_title");
        String password = request.getParameter("password");
 
        Client client = new Client(nom, prenom,job_title,login,password);
        clientDAO.updateClient(client);
        response.sendRedirect("list");
    }
 
    private void deleteClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String login = request.getParameter("login");
 
        Client client = new Client(login);
        clientDAO.deleteClient(client);
        response.sendRedirect("list");
 
    }
    
}