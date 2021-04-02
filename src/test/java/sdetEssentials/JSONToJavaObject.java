package sdetEssentials;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class JSONToJavaObject {
    public static final Logger log = Logger.getLogger(String.valueOf(JSONToJavaObject.class));

    public  static void main(String t[]) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        File jsonFile = new File("D:\\SdetEssentials\\src\\test\\java\\customerInfo.json");

         CustomerDetails customerDetails = objectMapper.readValue(jsonFile, CustomerDetails.class);
        // This will read the content from customerInfo and convert it back into JAVA Object of type CustomerDetails
        log.info(customerDetails.getBookName());
        log.info(customerDetails.getPurchaseDate());
        log.info(String.valueOf(customerDetails.getAmount()));
        log.info(customerDetails.getLocation());
    }
}
