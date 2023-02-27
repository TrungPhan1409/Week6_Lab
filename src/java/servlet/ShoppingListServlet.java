/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author darkn
 */
public class ShoppingListServlet extends HttpServlet {

  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String username = null;
        
        if (session != null){
            username = (String)session.getAttribute("username");
        }
        
        if(username != null){
            String action = request.getParameter("action");
            
            if(action.equals("logout")){ 
                session.invalidate();
            }
            else {
                request.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp" )
                    .forward(request, response); 
                return;
            }
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp" )
            .forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        HttpSession session = request.getSession(false);
        
        switch (action){
            case "register":
                session = request.getSession();
                String username = request.getParameter("username");
                ArrayList<String> items = new ArrayList<>();
                session.setAttribute("username", username);
                session.setAttribute("items", items);
                break;
                
            case "add":
                String item = request.getParameter("item");
                items = (ArrayList<String>)session.getAttribute("items"); 
                items.add(item);
                session.setAttribute("items", items);
                break;  
                
            case "delete":
                items = (ArrayList<String>)session.getAttribute("items");
                
                for (int i = 0; i < items.size(); i++) {
                    String elem = items.get(i);
                    String checked = request.getParameter(elem);
                    
                    if(elem.equals(checked)) {
                        items.remove(i--);
                    }
                }
                session.setAttribute("items", items);
                break;   
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp" )
                    .forward(request, response); 
    }

    
}