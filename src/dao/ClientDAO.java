package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import beans.Client;

public class ClientDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public ClientDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     
    public boolean insertClient(Client client) throws SQLException {
        String sql = "INSERT INTO client (nom, prenom, job_title,login,password) VALUES (?,?,?,?,?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, client.getLast_name());
        statement.setString(2, client.getFirst_name());
        statement.setString(3, client.getJob_title());
        statement.setString(4, client.getLogin());
        statement.setString(5, client.getPassword());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    public List<Client> listAllClients() throws SQLException {
        List<Client> listClient = new ArrayList<>();
        Client client = null;
        String sql = "SELECT * FROM Client";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String login = resultSet.getString("login");
            String job_title = resultSet.getString("job_title");
            String nom = resultSet.getString("nom");
            String prenom = resultSet.getString("prenom");
            String password = resultSet.getString("password");
             
            client = new Client(nom, prenom, job_title,login,password);
            listClient.add(client);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listClient;
    }
     
    public boolean deleteClient(Client Client) throws SQLException {
        String sql = "DELETE FROM Client where login = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, Client.getLogin());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateClient(Client client) throws SQLException {
        String sql = "UPDATE client SET job_title = ?, prenom = ?, nom = ? , password = ?";
        sql += " WHERE login = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, client.getJob_title());
        statement.setString(2, client.getFirst_name());
        statement.setString(3, client.getLast_name());
        statement.setString(4, client.getPassword());
        statement.setString(5, client.getLogin());
       
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public Client getClient(String login) throws SQLException {
        Client Client = null;
        String sql = "SELECT * FROM client WHERE login = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, login);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String nom = resultSet.getString("nom");
            String prenom = resultSet.getString("prenom");
            String password = resultSet.getString("password");
            String job_title = resultSet.getString("job_title");
            Client = new Client(nom, prenom, job_title,login, password);
        }
         
        resultSet.close();
        statement.close();
        disconnect();
        return Client;
    }
}