package cat.proven.statementultimo.persist;

import cat.proven.statementultimo.model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Leynor
 */
public class ProductDao {

    Connection connection;
    Statement stmt;
    ResultSet rs;
    String sql = "SELECT * FROM products";

    public ProductDao() {

        try {
            DbConnect.loadDriver();
            connection = DbConnect.getConnection();
            if (connection != null) {
                stmt = connection.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery(sql);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertRow(Product product) {
        int result =0;
       
        try {
            rs.moveToInsertRow();
            rs.updateString("code", product.getCode());
            rs.updateString("description", product.getDescription());
            rs.updateDouble("price", product.getPrice());
            rs.updateDouble("stock", product.getStock());
            //insert row
             rs.insertRow();
            rs.moveToCurrentRow();
            
        } catch (SQLException ex) {
           
            
        }catch (Exception ex) {
            
        }
      
    }

    public int deleteRow() {
        int result = 0;
        try {

            rs.deleteRow();

            result = 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = 0;
        }
        return result;
    }

    public void closeConnection() {
        try {
            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Product next() {
        Product result = null;
        try {

            rs.next();
            result = resultsetToProduct();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Product first() {
        Product result = null;
        try {

            rs.first();
            result = resultsetToProduct();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;

    }
    public void firstStart() {
        
        try {
            rs.first();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    public Product last() {
        Product result = null;
        try {
            rs.last();
            result = resultsetToProduct();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;

    }

    public Product previus() {
        Product result = null;
        try {

            rs.previous();
            result = resultsetToProduct();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;

    }

    public Product updateRow(Product product) {
        Product result = null;

        try {

            //modify fields.
            rs.moveToCurrentRow();
            rs.updateString("code", product.getCode());
            rs.updateString("description", product.getDescription());
            rs.updateDouble("price", product.getPrice());
            rs.updateInt("stock", product.getStock());
            //submit the changes.
            rs.updateRow();
            result = resultsetToProduct();
            //position cursor in current row.

        } catch (SQLException ex) {
            ex.printStackTrace();
            result = null;
        }catch(Exception e){
             result = null;
        }
        return result;
    }

    /**
     * convers data from current row of result into a product.
     *
     * @param rs the resultset to extract data from.
     * @return product with extracted data.
     * @throws SQLException in case of error.
     */
    private Product resultsetToProduct() throws SQLException {
        String code = "";
        String description = "";
        double price = 0;
        int stock = 0;
        Product p = null;
        try {
            code = rs.getString("code");
            description = rs.getString("description");
            price = rs.getDouble("price");
            stock = rs.getInt("stock");
            p = new Product(code, description, price, stock);

        } catch (SQLException ex) {
            p = null;
        }

        return p;
    }

}
