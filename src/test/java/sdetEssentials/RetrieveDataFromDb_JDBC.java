package sdetEssentials;

import java.sql.*;
import java.util.logging.Logger;

public class RetrieveDataFromDb_JDBC {
    public static final Logger log = Logger.getLogger(String.valueOf(RetrieveDataFromDb_JDBC.class));
    /*
    1. Create a Connection
    2. create a statement/query
    3. Execute query then store the results
    4. Print the results
     */
    public static void main(String s[]) throws SQLException {
        Connection con = DriverManager.
                getConnection("jdbc:mysql://localhost:3306/classicmodels", "root","password");
        Statement stmt = con.createStatement();
        String sq = "Select * from customerInfo limit 1";
        ResultSet rs = stmt.executeQuery(sq);

        while(rs.next()){
            String bookName = rs.getString("BookName");
            String purchasedDate = rs.getString("PurchasedDate");
            int amount = rs.getInt("Amount");
            String location = rs.getString("Location");

            log.info("bookname ::" + bookName);
            log.info("purchasedDate ::" + purchasedDate);
            log.info("amount ::" + amount);
            log.info("location ::" + location);
        }

        con.close();
    }
}
