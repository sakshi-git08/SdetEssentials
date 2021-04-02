package sdetEssentials;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class ConvertDBResults_MultipleJavaObject_MultipleJsonFiles {
    public static final Logger log = Logger.getLogger(String.valueOf(ConvertDBResults_MultipleJavaObject_MultipleJsonFiles.class));

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
        String sq = "Select * from customerInfo";
        ResultSet rs = stmt.executeQuery(sq);

        ArrayList<CustomerDetails>customerDetailsArrayList = new ArrayList<CustomerDetails>();

        //creating an object of POJO Class in order to use its variables and methods defined.

        while(rs.next()) {
            String bookName = rs.getString("BookName");
            String purchasedDate = rs.getString("PurchasedDate");
            int amount = rs.getInt("Amount");
            String location = rs.getString("Location");

            //creating an object of POJO Class in order to use its variables and methods defined.
            CustomerDetails customerDetails = new CustomerDetails();
            //In order to create multiple objects we will introduce CustomerDetails Object inside While loop.

            //using setter methods to set the values of all the variables defined in CustomerDetails POJO Class

            customerDetails.setBookName(bookName);
            customerDetails.setPurchaseDate(purchasedDate);
            customerDetails.setAmount(amount);
            customerDetails.setLocation(location);

            customerDetailsArrayList.add(customerDetails);

            /*Using Jackson API, convert java object into JSON File
            Maven Dependencies Required :
            Jackson Core, Jackson Databind, Jackson Annotations*/

            for(int i = 0; i<customerDetailsArrayList.size(); i++) {
                //In order to create multiple json files we did customerInfo"+i+"+.json name the file this way
                //which will ensure that multiple files will be created number of i times else only one file would have created.
                File jsonFile = new File("D:\\SdetEssentials\\src\\test\\java\\JsonFiles\\customerInfo"+i+".json");
                ObjectMapper objectMapper = new ObjectMapper();
                //writeValue that can be used to serialize any Java value as JSON output, using Writer provided.
                objectMapper.writeValue(jsonFile, customerDetailsArrayList.get(i));//this will convert our object to json file
                //This will fetch the values according to the value of i and store it in jsonFile.
            }

//            log.info(customerDetails.getBookName());
            //string valueOf() method converts different types of values into string.
//            log.info(String.valueOf(customerDetails.getAmount()));
        }

           /* log.info("bookname ::" + bookName);
            log.info("purchasedDate ::" + purchasedDate);
            log.info("amount ::" + amount);
            log.info("location ::" + location);*/

        /*is it necessary to close statement object in db code
        No you are not required to close anything BUT the connection. As Per JDBC specs
        closing any higher object will automatically close lower objects. Closing Connection
         will close any Statement s that connection has created
         */
//            stmt.close();
        con.close();
        log.info("Done!!");


    }
}

