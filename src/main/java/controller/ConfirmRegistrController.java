/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Validator.UserValidator;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import javax.validation.Valid;
import model.HibernateUtil;
import model.User;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author hp
 */
@Controller
@RequestMapping(value="user")
public class ConfirmRegistrController {
  //Display login page
    @RequestMapping(value="/ConfirmRegistr",method=RequestMethod.GET)
    public String ConfirmRegister(ModelMap modelMap,@RequestParam("modelMap") String mp)
    {
        
        modelMap.put("mp", new User());
        return "ConfirmRegistr";
    }
    
    //Traitmenent of the login page 
    @RequestMapping(value="/ConfirmRegistr",method=RequestMethod.POST)
    public String ConfirmRegister(@ModelAttribute(value="us") @Valid User us,BindingResult bindingResult, ModelMap modelMap)
    {
       
   
        //user = us.getUserFromSignupToken(us.getConfirmpwd());
    if (us.getStatut()==0) {
        // has not been confirmed yet:
        us.setStatut(1);
        
       Session session = HibernateUtil.getSessionFactory().openSession();
                 session.beginTransaction();
                 session.update(us);
                 session.getTransaction().commit();
       return "ConfirmRegistr"; 
    } 
   
    
 return "ConfirmRegistr";   
}
}

