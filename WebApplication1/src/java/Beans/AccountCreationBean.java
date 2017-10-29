package Beans;

import POJOS.DBConnection;
import static com.sun.faces.facelets.util.Path.context;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import static jdk.nashorn.tools.ShellFunctions.input;

@Named(value = "accountCreationBean")
@RequestScoped
public class AccountCreationBean extends DBConnection
{
    private String
            firstName,
            lastName,
            email,
            phone,
            title,
            userName,
            password,
            major;
    
    public AccountCreationBean()
    {
        firstName = "";
        lastName = "";
        email = "";
        phone = "";
        title = "";
        userName = "";
        password = "";
        major = "";
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getMajor()
    {
        return major;
    }

    public void setMajor(String major)
    {
        this.major = major;
    }
    
    public void createAccount()
    {
         FacesContext facesContext = FacesContext.getCurrentInstance();
        if(super.addMember(userName, password, title, phone, email, firstName, lastName, major))
        {
            FacesMessage success = new FacesMessage("Congradulations! Your sign up was successfull!");
             clear();
            facesContext.addMessage(null,success);
        }
        else
            facesContext.addMessage(null, userexists);
    }
    private void clear()
    {
        firstName = "";
        lastName = "";
        email = "";
        phone = "";
        title = "";
        userName = "";
        password = "";
        major = "";
    };
   
}
