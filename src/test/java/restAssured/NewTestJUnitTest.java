package restAssured;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jayway.restassured.RestAssured;
import static com.jayway.restassured.RestAssured.expect;
import com.jayway.restassured.parsing.Parser;
import com.jayway.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.jayway.restassured.RestAssured.get; 
import static com.jayway.restassured.RestAssured.given;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONArray;
import org.json.JSONObject;



public class exampleRestTest {

    public exampleRestTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
       RestAssured.registerParser("application/json", Parser.JSON);
         
        try {
            
        //****** create the outgoing message for the web service, this requires the play session cookie to be passed along with the URI
        //****** depending on the type of service and the data passed into it will determine if the response will be as a single object, or an array of objects
            
        //*** this returns an array and requires JSONArray(commented out)
        //Response resp =given().cookie("PLAY_SESSION=\"53f%22%7D\"").get("http://192.168.66.66:9090/service/terminals/typeaheadorigin/buf/customer/2");

        //***this returns a single object not an array and requires JSONObject
            
            
            //need to send the play session as part of the request
            Response resp =given()
                                    .cookie("PLAY_SESSION=\"53f8536%22%7D\"")
                                    .get("http://192.168.66.66:9090/service/terminals/typeaheadorigin/buf/customer/7");
           
            //using an assert to verify the expected response was returned
            assertEquals(200, resp.getStatusCode());

            //JSONArray jsonResponse = new JSONArray(resp.asString()); 
            System.out.println("--------------->"+resp.contentType());
            JSONObject jsonObject=null;
            String value = jsonResponse.getJSONObject(0).getString("primary"); 
            
            System.out.println("0------->"+value);
            }
        
        
        
                    
//****** after you send the message, verify the response code before assigning the return message into an object or array
            
        //*** verify the expected response code 
          // assertEquals(200, resp.getStatusCode());
           
//******* the expected response from the web service needs to be assigned as either an object, or array of objects depending on the details in the outgoing message
//******* assign the response to an object or array, depending on the type of expected response in order to perform asserts against the return message, multiple items in a return requires an array  
           
        //***use JSONObject for a single object in the return message
           JSONObject jsonResponse = new JSONObject(resp.asString()); 
           
        //***use JSONArray for multiple objects in the return message
            //JSONArray jsonResponse = new JSONArray(resp.asString()); 
           
//****** assert statements against the response message go here, this is the same sintax as Jasmine
           //to verify response message
           //assertEquals(expectedReturn, resp.asString());
           
        
            //account for errors and display stack in console.
                catch(Exception e)
                     {
                     e.printStackTrace();
                     }
               
            }
}
