package Task3;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task3 {
    @Test
    public void printToConsole(){
        RestAssured.when().get("https://jsonplaceholder.typicode.com/posts/1").prettyPrint();
    }
    @Test
    public void albumTitleLength() {
        Response res=RestAssured.when().get("https://jsonplaceholder.typicode.com/users/1/albums");
        JsonPath json = new JsonPath(res.asString());
        for(int i=0;i<json.getInt("size()");i++)
            Assert.assertTrue(json.getString("["+i+"].title").length()<300);
    }
    @Test
    public void checkResponse() {
        RestAssured.given().contentType(ContentType.JSON).body(new User(1,"blabla"))
                .when().post("https://jsonplaceholder.typicode.com/albums").then().statusCode(201);
    }
    @Test
    public void printNotCompletedTodos() {
        Response res=RestAssured.when().get("https://jsonplaceholder.typicode.com/users/1/todos");
        JsonPath json = new JsonPath(res.asString());
        for(int i=0;i<json.getInt("size()");i++)
        {
            if (!json.getBoolean("["+i+"].completed"))
            {
                System.out.println(json.getString("["+i+"].title"));
            }
        }
    }

}
