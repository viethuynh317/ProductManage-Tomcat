package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO.DBUtils;
import model.DAO.MyUtils;
import model.beans.UserAccount;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/register")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/registerAccount.jsp");
        dispatcher.forward(request, response);
    }
 
    // When the user enters the product information, and click Submit.
    // This method will be called.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String userName = (String) request.getParameter("userName");
        String password = (String) request.getParameter("password");
        String name = (String) request.getParameter("name");
        String gender = (String) request.getParameter("gender");
        String ageStr = (String) request.getParameter("age");
        String email = (String) request.getParameter("email");
        int age = 0;
        
        try {
            
            age = Integer.parseInt(ageStr);
        } catch (Exception e) {
        }
        UserAccount userAccount = new UserAccount(userName, password, name, gender, age, email);
 
        String errorString = null;
 
        // Product ID is the string literal [a-zA-Z_0-9]
        // with at least 1 character
        String regex = "\\w+";
 
        if (userName == null || !userName.matches(regex)) {
            errorString = "Tài khoản không hợp lệ không hợp lệ!";
        }
 
        if (errorString == null) {
            try {
                DBUtils.insertUser(conn, userAccount);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = "Tài khoản đã tồn tại, Vui lòng đăng ký với tài khoản khác!";
                
            }
        }
 
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("userAccount", userAccount);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/registerAccount.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the product listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

}
