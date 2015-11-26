/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Validator.UserValidator;
import static com.sun.org.apache.xalan.internal.lib.ExsltMath.random;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.math.BigInteger;
import java.security.SecureRandom;
import javax.validation.Valid;
import model.*;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


/**
 *
 * @author hp
 */
@Controller
@RequestMapping(value="user")
public class userController {
    // For the secure random generation of tokens
    private SecureRandom random = new SecureRandom();
    
//Display login page
    @RequestMapping(value="/register",method=RequestMethod.GET)
    public String register(ModelMap modelMap)
    {
        modelMap.put("us", new User());
        return "register";}
    
    //Traitmenent of the login page 
    @RequestMapping(value="/register",method=RequestMethod.POST)
    public String register(@ModelAttribute(value="us") @Valid User us,BindingResult bindingResult, ModelMap modelMap)
    {
        UserValidator usv= new UserValidator();
        usv.validate(us, bindingResult);
        
    //There are error
        if(bindingResult.hasErrors())
        {
            return "register";
        }
        
        else{   
 String code = new BigInteger(130, random).toString(32);
        us.setConfirmpwd(code);
        
            try{
                 Session session = HibernateUtil.getSessionFactory().openSession();
                 session.beginTransaction();
                 session.save(us);
                 session.getTransaction().commit();
                }
            catch(Exception e)
                {e.printStackTrace();}
            
            
           
            
            
         ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
    	 
    	HTMLMail mm = (HTMLMail) context.getBean("htmlMail");
       String URL= "http://localhost:8080/Tinza/user/ConfirmRegistr.htm?modelMap="+us;
        String html="<p>Hi "+us.getNom()+" "+us.getPrenom()+" "+"!</p><a href="+URL+">Link text</a>";
	mm.sendMail("tinzaa100@gmail.com",
			us.getEmail(),
			"Registration Tinza",
			html);
    return "ConfirmRegistr";
            
            
            
            
            
    }

    }
    
}
