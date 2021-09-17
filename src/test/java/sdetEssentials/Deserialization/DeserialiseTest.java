package sdetEssentials.Deserialization;


import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.List;

public class DeserialiseTest {
    @Test
    public void DesereTest(){
        RestAssured.baseURI = "https://reqres.in/api/users?page=2";
        /*ListUsersPojo pojo = new ListUsersPojo();
        This will create another object and if we use this object this will be different then the actual response
        It will result in null for each and every variable and list.
        So, no need to create an object
        */

        ListUsersPojo pojo = RestAssured.given().when().get().as(ListUsersPojo.class);
        System.out.println(pojo.toString());
        System.out.println(pojo.getData());

        List<DataPojo> list = pojo.getData();
        for (int i = 0; i < list.size(); i++){
            System.out.println("This is my " + i + " element " + list.get(i));
        }

    }
}
