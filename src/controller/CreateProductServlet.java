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
 
@WebServlet(urlPatterns = { "/createProduct" })
public class CreateProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public CreateProductServlet() {
        super();
    }
 
    // Show product creation page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String errorString = null;
    	HttpSession session = request.getSession();
        
        // Check User has logged on
        UserAccount loginedUser = MyUtils.getLoginedUser(session);
        List<Product> list = null;
        Connection conn = MyUtils.getStoredConnection(request);
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
        	errorString = "Bạn phải đăng nhập trước khi Thêm sản phẩm!";
        	request.setAttribute("errorString", errorString);
        	request.setAttribute("productList", list);
//        	response.sendRedirect(request.getContextPath() + "/productList");
         	RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/productListView.jsp");
            dispatcher.forward(request, response);
        } else {

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
        dispatcher.forward(request, response);
        }
    }
 
    // When the user enters the product information, and click Submit.
    // This method will be called.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String code = (String) request.getParameter("code");
        String name = (String) request.getParameter("name");
        String priceStr = (String) request.getParameter("price");
        String countStr = (String) request.getParameter("count");
        String state = (String) request.getParameter("state");
        int count = 0;
        float price = 0;
        try {
            price = Float.parseFloat(priceStr);
            count = Integer.parseInt(countStr);
        } catch (Exception e) {
        }
        Product product = new Product(code, name, price, count, state);
 
        String errorString = null;
 
        // Product ID is the string literal [a-zA-Z_0-9]
        // with at least 1 character
        String regex = "\\w+";
 
        if (code == null || !code.matches(regex)) {
            errorString = "Mã sản phẩm không hợp lệ!";
        }
 
        if (errorString == null) {
            try {
                DBUtils.insertProduct(conn, product);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = "Mã sản phẩm đã tồn tại, Vui lòng nhập lại mã sản phẩm!";
            }
        }
 
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", product);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the product listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/productList");
        }
    }
 
}