package Beans;

import POJOS.DBConnection;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Warlok
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean extends DBConnection implements Serializable 
{
    private String userName, passWord;
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() 
    {
        userName = "";
        passWord = "";
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassWord()
    {
        return passWord;
    }

    public void setPassWord(String passWord)
    {
        this.passWord = passWord;
    }
    public void login()
    {
        
    }
    
}
