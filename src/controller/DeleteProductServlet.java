package controller;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO.DBUtils;
import model.DAO.MyUtils;
import model.beans.Product;
import model.beans.UserAccount;
 
@WebServlet(urlPatterns = { "/deleteProduct" })
public class DeleteProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public DeleteProductServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        
        String errorString = null;
    	HttpSession session = request.getSession();
        
        // Check User has logged on
        UserAccount loginedUser = MyUtils.getLoginedUser(session);
        List<Product> list = null;
       
        try {
        	String infoSearch = (String) session.getAttribute("searchValue");
        	if(infoSearch != "") {
        		list = DBUtils.searchProduct(conn, infoSearch);
        	} else {
			 list = DBUtils.queryProduct(conn);
        	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // Not logged in
        if (loginedUser == null) {
            // Redirect to login page.
        	errorString = "Bạn phải đăng nhập trước khi Xóa sản phẩm!";
        	request.setAttribute("errorString", errorString);
        	request.setAttribute("productList", list);
//        	response.sendRedirect(request.getContextPath() + "/productList");
         	RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/productListView.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        
        String code = (String) request.getParameter("code");
 

 
        try {
            DBUtils.deleteProduct(conn, code);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        } 
         
        // If has an error, redirecte to the error page.
        if (errorString != null) {
            // Store the information in the request attribute, before forward to views.
            request.setAttribute("errorString", errorString);
            // 
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/deleteProductErrorView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the product listing page.        
        else {
            response.sendRedirect(request.getContextPath() + "/productList");
        }
 
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}