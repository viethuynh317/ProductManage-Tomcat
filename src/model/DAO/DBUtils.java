package model.DAO;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.beans.Product;
import model.beans.UserAccount;
 
public class DBUtils {
 
    public static UserAccount findUser(Connection conn,
            String userName, String password) throws SQLException {
 
        String sql = "Select User_Name, Password, Gender, Name, Age, Email from User_Account" + " where User_Name = ? and password= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String gender = rs.getString("Gender");
            String name = rs.getString("Name");
            int age = rs.getInt("Age");
            String email = rs.getString("Email");
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            user.setGender(gender);
            user.setName(name);
            user.setAge(age);
            user.setEmail(email);
            return user;
        }
        return null;
    }
 
    
    public static void insertUser(Connection conn, UserAccount userAccount) throws SQLException {
        String sql = "Insert into user_account(User_Name, Password, Name, Gender, Age, Email) values (?,?,?,?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, userAccount.getUserName());
        pstm.setString(2, userAccount.getPassword());
        pstm.setString(3, userAccount.getName());
        pstm.setString(4, userAccount.getGender());
        pstm.setInt(5, userAccount.getAge());
        pstm.setString(6, userAccount.getEmail());
        pstm.executeUpdate();
    }
    
    public static UserAccount findUser(Connection conn, String userName) throws SQLException {
 
        String sql = "Select User_Name, Password, Gender, Name, Age, Email from User_Account" + " where User_Name = ? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
 
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String password = rs.getString("Password");
            String gender = rs.getString("Gender");
            String name = rs.getString("Name");
            int age = rs.getInt("Age");
            String email = rs.getString("Email");
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            user.setGender(gender);
            user.setName(name);
            user.setAge(age);
            user.setEmail(email);
            return user;
        }
        return null;
    }
 
    public static List<Product> queryProduct(Connection conn) throws SQLException {
        String sql = "Select Code, Name, Price, Count, State from Product";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Product> list = new ArrayList<Product>();
        while (rs.next()) {
            String code = rs.getString("Code");
            String name = rs.getString("Name");
            float price = rs.getFloat("Price");
            int count = rs.getInt("Count");
            String state = rs.getString("State");
            Product product = new Product();
            product.setCode(code);
            product.setName(name);
            product.setPrice(price);
            product.setCount(count);
            product.setState(state);
            list.add(product);
        }
        return list;
    }
    
    
    public static List<Product> searchProduct(Connection conn, String infoSearch) throws SQLException {
        String sql = "Select Code, Name, Price, Count, State from Product where Code LIKE ? or Name LIKE ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        pstm.setString(1, "%" + infoSearch + "%");
        pstm.setString(2, "%" + infoSearch + "%");
        ResultSet rs = pstm.executeQuery();
        List<Product> list = new ArrayList<Product>();
        while (rs.next()) {
        	String code = rs.getString("Code");
            String name = rs.getString("Name");
            float price = rs.getFloat("Price");
            int count = rs.getInt("Count");
            String state = rs.getString("State");
            Product product = new Product();
            product.setCode(code);
            product.setName(name);
            product.setPrice(price);
            product.setCount(count);
            product.setState(state);
            list.add(product);
        }
        return list;
    }
    
 
    public static Product findProduct(Connection conn, String code) throws SQLException {
        String sql = "Select Code, Name, Price, Count, State from Product where Code=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, code);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
            String name = rs.getString("Name");
            float price = rs.getFloat("Price");
            int count = rs.getInt("Count");
            String state = rs.getString("State");
            Product product = new Product(code, name, price, count, state);
            return product;
        }
        return null;
    }
    
    

 
    public static void updateProduct(Connection conn, Product product) throws SQLException {
        String sql = "Update Product set Name =?, Price=?, Count=?, State=? where Code=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
    
        pstm.setString(5, product.getCode());
        pstm.setString(1, product.getName());
        pstm.setFloat(2, product.getPrice());
        pstm.setInt(3, product.getCount());
        pstm.setString(4, product.getState());
        pstm.executeUpdate();
    }
 
    public static void insertProduct(Connection conn, Product product) throws SQLException {
        String sql = "Insert into Product(Code, Name,Price, Count, State) values (?,?,?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, product.getCode());
        pstm.setString(2, product.getName());
        pstm.setFloat(3, product.getPrice());
        pstm.setInt(4, product.getCount());
        pstm.setString(5, product.getState());
        pstm.executeUpdate();
    }
 
    public static void deleteProduct(Connection conn, String code) throws SQLException {
        String sql = "Delete From Product where Code= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, code);
 
        pstm.executeUpdate();
    }
 
}