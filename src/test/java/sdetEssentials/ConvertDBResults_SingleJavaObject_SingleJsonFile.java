package sdetEssentials;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Logger;

public class ConvertDBResults_SingleJavaObject_SingleJsonFile {
    public static final Logger log = Logger.getLogger(String.valueOf(ConvertDBResults_SingleJavaObject_SingleJsonFile.class));

    /*
    1. Create a Connection
    2. create a statement/query
    3. Execute query then store the results
    4. Print the results
     */
    public static void main(String s[]) throws SQLException, IOException {
        Connection con = DriverManager.
                getConnection("jdbc:mysql://localhost:3306/classicmodels", "root","password");
        Statement stmt = con.createStatement();
        String sq = "Select * from customerInfo limit 2";
        ResultSet rs = stmt.executeQuery(sq);

        //creating an object of POJO Class in order to use its variables and methods defined.
        CustomerDetails customerDetails = new CustomerDetails();

        while(rs.next()) {
            String bookName = rs.getString("BookName");
            String purchasedDate = rs.getString("PurchasedDate");
            int amount = rs.getInt("Amount");
            String location = rs.getString("Location");


            //using setter methods to set the values of all the variables defined in CustomerDetails POJO Class

            customerDetails.setBookName(bookName);
            customerDetails.setPurchaseDate(purchasedDate);
            customerDetails.setAmount(amount);
            customerDetails.setLocation(location);

            /*Using Jackson API, convert java object into JSON File
            Maven Dependencies Required :
            Jackson Core, Jackson Databind, Jackson Annotations*/

            File jsonFile = new File("D:\\SdetEssentials\\src\\test\\java\\JsonFiles\\customerInfo.json");
            ObjectMapper objectMapper = new ObjectMapper();
            //writeValue that can be used to serialize any Java value as JSON output, using Writer provided.
            objectMapper.writeValue(jsonFile, customerDetails);//this will convert our object to json file


            log.info(customerDetails.getBookName());
            //string valueOf() method converts different types of values into string.
            log.info(String.valueOf(customerDetails.getAmount()));
        }

           /* log.info("bookname ::" + bookName);
            log.info("purchasedDate ::" + purchasedDate);
            log.info("amount ::" + amount);
            log.info("location ::" + location);*/

        /*is it necessary to close statement object in db code?
        No you are not required to close anything BUT the connection. As Per JDBC specs
        closing any higher object will automatically close lower objects. Closing Connection
         will close any Statement s that connection has created
         */
//            stmt.close();
            con.close();
            log.info("Done!!");


    }
}
