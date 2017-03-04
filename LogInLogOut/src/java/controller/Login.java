/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nguyen Euler
 */
@WebServlet ("/login")
public class Login extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        
        HttpSession session = req.getSession();
        session.setAttribute("username",username);
        session.setAttribute("password",password);
        session.setAttribute("remember",remember);
        
        if(session.getAttribute("remember")!=null)
        {
          
            getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);
        }
        else if((session.getAttribute("username")!=null) && (session.getAttribute("password")!=null))
        {
            if(Count.count==0){

                  getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);
                  Count.count+=1;
            }
            else{
            
                  getServletContext().getRequestDispatcher("/LogOut").forward(req, resp);
            }
        
        }
        else
        {
           getServletContext().getRequestDispatcher("/LogOut").forward(req, resp);
        
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        HttpSession session = req.getSession();
        
        if(session!=null)
        { 
            if(session.getAttribute("remember")!=null){
                
                     getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);
                
            }
            else{
                getServletContext().getRequestDispatcher("/LogOut").forward(req, resp);
                
            }
        }
       
        else
        {
           getServletContext().getRequestDispatcher("/LogOut").forward(req, resp);
        
        }
    }
    
}
