package POJOS;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;

/**
 *
 * @author Warlok
 */
public class DBConnection
{
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    protected FacesMessage userexists;

    public DBConnection()
    {
        try
        {
            ConnectToDB();
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void ConnectToDB() throws ClassNotFoundException, SQLException
    {
        String
                driver = "com.mysql.jdbc.Driver",
                url = "jdbc:mysql://clubdatabase.ddns.net:3306/programmingclub",
                userName = "root",
                password= " ";
        
        Class.forName(driver);
        connection = (Connection) DriverManager.getConnection(url,userName,password);
        System.out.println("Connection Succsessfull!");
    }
    public boolean addMember(String userName, String password, String title, String Phone, String email, String firstName, String lastName, String major)
    {
        String addQuery = "INSERT INTO member(First_Name, Last_Name, Phone, Email, Title, UserName, Password, Major) VALUES " + 
                "('" + firstName + "', '" + lastName + "', '" + Phone + "', '" + email + "', '" + title + "', '" + userName + "', '" + password + "', '" + major + "')";
        if(!doesExist(userName, email))
        {
            try
            {
                PreparedStatement addMember = connection.prepareStatement(addQuery);
                addMember.executeUpdate();
                return true;   
            } 
            catch (SQLException ex)
            {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
            userexists = new FacesMessage("Sorry, but " + userName + " and/or " + email + " is already registered!");
       
        return false; 
    }
    private boolean doesExist(String userName, String email)
    {
        try
        {
            String query = "SELECT UserName, Email FROM Member";
            statement = (Statement) connection.createStatement();
            resultSet = statement.executeQuery(query);
            
            while(resultSet.next())
            {
                if (resultSet.getString("UserName").equals(userName) || resultSet.getString("Email").equals(email))
                {
                    
                    return true;
                }
            }
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public void login(String userName, String password)
    {
        
    }
    
    public static void main(String[] args)
    {
        DBConnection dBConnection = new DBConnection();
    }
}
