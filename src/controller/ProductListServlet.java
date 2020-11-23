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

 
@WebServlet(urlPatterns = { "/productList" })
public class ProductListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public ProductListServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        HttpSession session = request.getSession();
        
//        // Check User has logged on
//        UserAccount loginedUser = MyUtils.getLoginedUser(session);
// 
//        // Not logged in
//        if (loginedUser == null) {
//            // Redirect to login page.
//            response.sendRedirect(request.getContextPath() + "/login");
//            return;
//        }
       

        String errorString = null;
        List<Product> list = null;

        try {
        	String action = request.getParameter("action");
        	String infoSearch = request.getParameter("infoSearch");
        	//System.out.print(infoSearch);
        	if(infoSearch == null) {
        		infoSearch = "";
        	}
        	session.setAttribute("searchValue", infoSearch);
        	if(action !=null && infoSearch !=""){
            list = DBUtils.searchProduct(conn, infoSearch);
            if(list.isEmpty()) {
            	errorString = "Sản phẩm không tồn tại!";
            }
            } else {
            list = DBUtils.queryProduct(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        
        
        // Store info in request attribute, before forward to views
        request.setAttribute("errorString", errorString);
        request.setAttribute("productList", list);
         
        // Forward to /WEB-INF/views/productListView.jsp
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/productListView.jsp");
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}