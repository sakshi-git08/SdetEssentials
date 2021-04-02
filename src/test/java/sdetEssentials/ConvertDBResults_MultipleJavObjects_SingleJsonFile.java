package sdetEssentials;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class ConvertDBResults_MultipleJavObjects_SingleJsonFile {
    public static final Logger log = Logger.getLogger(String.valueOf(ConvertDBResults_MultipleJavObjects_SingleJsonFile.class));

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

        ArrayList<CustomerDetails> customerDetailsArrayList = new ArrayList<CustomerDetails>();

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
        }

            /*
            Maven Dependencies Required : gson, json simple
            */

            JSONArray jsonArray = new JSONArray();

            for(int i = 0; i<customerDetailsArrayList.size(); i++) {

                //converting java object into JSON String
                Gson gson = new Gson();
                String jsonString = gson.toJson(customerDetailsArrayList.get(i)); // toJson is used to convert into Json String
                jsonArray.add(jsonString); // This will add Json Strings into JsonArray.
            }

            JSONObject jsonObject = new JSONObject(); // JSONObject is HAshMap types
            jsonObject.put("data", jsonArray);
            log.info(jsonObject.toJSONString());// Will print all the content of jsonObject into Json String

        String jsonFormattedString = jsonObject.toJSONString().replace("\\\"","\""); // removed escape characters
        String finalJson = jsonFormattedString.replace("\"{","{").replace("}\"","}");
        // removed double quotes from both sides
        log.info(finalJson);

        /*
        INFO: {"data":["{\"bookName\":\"selenium\",\"purchaseDate\":\"2021-03-30\",\"amount\":350,\"location\":\"Africa\"}",
        "{\"bookName\":\"Java\",\"purchaseDate\":\"2021-03-30\",\"amount\":200,\"location\":\"Africa\"}",
        "{\"bookName\":\"Python\",\"purchaseDate\":\"2021-03-30\",\"amount\":250,\"location\":\"Asia\"}",
        "{\"bookName\":\"Jmeter\",\"purchaseDate\":\"2021-03-30\",\"amount\":150,\"location\":\"Asia\"}",
        "{\"bookName\":\"C#\",\"purchaseDate\":\"2021-03-30\",\"amount\":300,\"location\":\"Asia\"}"]}
        This was the json got created.
        We need to remove slashes and " quotes where unwanted quotes are present.
         */

        con.close();
        log.info("Done!!");


    }
}
