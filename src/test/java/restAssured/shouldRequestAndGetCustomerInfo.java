package restAssured;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/ 

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ValidatableResponse;
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
import com.jayway.restassured.http.ContentType;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONArray;
import org.json.JSONObject;

//added afterwords
import org.hamcrest.Matchers.*;
import com.jayway.restassured.matcher.RestAssuredMatchers.*;
import com.jayway.restassured.module.jsv.JsonSchemaValidator.*;
import static com.jayway.restassured.path.xml.XmlPath.with;
import static java.lang.System.console;
import java.util.HashMap;
import java.util.Map;


//Begin Main
public class shouldRequestAndGetCustomerInfo {

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        RestAssured.port = 9090;
        RestAssured.baseURI = "http://192.168.66.66";
    }

    @After
    public void tearDown() {
    }

//***** The methods must be annotated with annotation @Test.
    
    @Test
    public void validateGoodRestMessage() {
       RestAssured.registerParser("application/json", Parser.JSON);
        
            given()
                .header("Accept-Encoding", "application/json")
                .cookie("PLAY_SESSION=\"53f8538dfc207b4d%22%7D\"")

            .when()        
                .get("service/customers/7")
                    
            .then()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .body("customerName", equalTo("customerName"))
                    .body("someLength", equalTo(17))
                    .body("numOfContacts", equalTo(1))
                    .body("accountingCode", equalTo("someCode"));
          
    } 
       
     @Test
    public void validateBadRestMessageIncorrectCustomer() {
       RestAssured.registerParser("application/json", Parser.JSON);
         
            given()
                .header("Accept-Encoding", "application/json")
                .cookie("PLAY_SESSION=\"53f8538dfc207b4d%22%7D\"")

            .when()        
                .get("service/customers/1")

            .then()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .body("customerName", equalTo("customerName"));
               
    }
    
      @Test
    public void validateBadRestMessageMissingCookie() {
       RestAssured.registerParser("application/json", Parser.JSON);
         
            given()
                .header("Accept-Encoding", "application/json")
                 //   .cookie("PLAY_SESSION=\"53f8538dfc207b4d%22%7D\"")
            .when()        
                .get("service/customers/1")

            .then()
                    .statusCode(400);
                         
    }
    
      @Test
    public void validateBadRestMessageIncorrectContentType() {
       RestAssured.registerParser("application/json", Parser.JSON);
         
            given()
                .header("Accept-Encoding", "application/json")
                .cookie("PLAY_SESSION=\"53f8538dfc207b4d%22%7D\"")

            .when()        
                .get("service/customers/1")

            .then()
                  
                    .contentType("application/soap+xml; charset=UTF-8;")
                    .body("customerName", equalTo("BMW"));
               
    }
    
      @Test
    public void validateSoapMessage() {
    
     String soapMessage = 
        "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
        "<S:Envelope xmlns:S<\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
        "<SOAP-ENV:Header/>" +
        "<S:Body xmlns:ns2=\"http://service.place.com/\">" +
        "<ns2:ProcessBatch>" + 
        "<ProcessBatchRequest>" + 
            "<AuditInformation>" +
                "<Count>1</Count>" + 
                "<ProcessingTime>2006-05-04T18:13:51.0</ProcessingTime>" + 
                "<MessageSource>ns</MessageSource>" +
                "<VendorTimeStamp>2006-05-04T18:13:51.0</VendorTimeStamp>" + 
                "<ProcessedTimeStamp>2006-05-04T18:13:51.0</ProcessedTimeStamp>" + 
                "<UserName>john doe</UserName>" +
            "</AuditInformation>" +
        "</ProcessBatchRequest>" +
        "</ns2:ProcessBatch>" + 
        "</S:Body>" + 
        "</S:Envelope>";

    //send the soap message with required data and verify correct response
    
    Map<String, String> authHeader = new HashMap<String, String>();
    authHeader.put("SOAPAction", "Define");
    
    //send the message and get a response
    String xml = given()
                    .request()
                    .headers(authHeader)
                    .contentType("application/soap+xml; charset=UTF-8;")
                    .body(soapMessage)
                .when()
                    .post("http://192.168.66.66:9090/service/external/someService")
                    .andReturn()
                    .asString();
                
    
    //take the string output and display results
        String prettyXML = with(xml).prettyPrint();	    
        System.out.println(prettyXML);
          
    }    
}

