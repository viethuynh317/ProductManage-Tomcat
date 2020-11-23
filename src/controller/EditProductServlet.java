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
 
@WebServlet(urlPatterns = { "/editProduct" })
public class EditProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public EditProductServlet() {
        super();
    }
 
    // Show product edit page.
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
        	errorString = "Bạn phải đăng nhập trước khi Cập nhật sản phẩm!";
        	request.setAttribute("errorString", errorString);
        	request.setAttribute("productList", list);
//        	response.sendRedirect(request.getContextPath() + "/productList");
         	RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/productListView.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        
        String code = (String) request.getParameter("code");
//        System.out.println(code);
        Product product = null;
 
        try {
            product = DBUtils.findProduct(conn, code);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        // If no error.
        // The product does not exist to edit.
        // Redirect to productList page.
        if (errorString != null && product == null) {
            response.sendRedirect(request.getServletPath() + "/productList");
            return;
        }
 
        // Store errorString in request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", product);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
        dispatcher.forward(request, response);
 
    }
 
    // After the user modifies the product information, and click Submit.
    // This method will be executed.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String code = (String) request.getParameter("code");
        String name = (String) request.getParameter("name");
        String priceStr = (String) request.getParameter("price");
        String countStr = (String) request.getParameter("count");
        String state = (String) request.getParameter("state");
        float price = 0;
        int count = 0;
        try {
        	count = Integer.parseInt(countStr);
            price = Float.parseFloat(priceStr);
        } catch (Exception e) {
        }
        Product product = new Product(code, name, price, count, state);
 
        String errorString = null;
 
        try {
            DBUtils.updateProduct(conn, product);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", product);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the product listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/productList");
        }
    }
 
}