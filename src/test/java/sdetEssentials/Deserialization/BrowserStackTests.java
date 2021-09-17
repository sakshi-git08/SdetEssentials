package sdetEssentials.Deserialization;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.List;

public class BrowserStackTests {
    @Test
    public void testBrowserStackApi() {
        RestAssured.baseURI = "https://www.browserstack.com/list-of-browsers-and-platforms.json?product=automate";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Content-Type", "text/html; charset=utf-8");
        RootPojo pojo = requestSpecification.get().as(RootPojo.class);
        System.out.println(pojo.toString());
        System.out.println(pojo.getDesktopPojoList());
        System.out.println(pojo.getMobilePojoList());

        List<DesktopPojo> desktopPojoList = pojo.getDesktopPojoList();
        for (int i = 0; i < desktopPojoList.size(); i++){
            System.out.println("This is my BrowserList according to devices " + i + " " + desktopPojoList.get(i).getBrowserPojoList().get(i).getBrowser());
        }

    }
}
