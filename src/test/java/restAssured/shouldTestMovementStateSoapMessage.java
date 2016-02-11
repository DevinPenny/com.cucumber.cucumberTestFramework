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
import com.jayway.restassured.matcher.RestAssuredMatchers.*;
import com.jayway.restassured.module.jsv.JsonSchemaValidator.*;
import static com.jayway.restassured.path.xml.XmlPath.with;
import java.util.HashMap;
import java.util.Map;


//Begin Main
public class shouldTestMovementStateSoapMessage {

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

//start test with @Test annotation

    @Test
    public void validateSoapMessage() {
   
     String soapMessage = 
        "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
            "xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
            "<SOAP-ENV:Header/>" +
                "<S:Body xmlns:ns2=\"http://service.location.external.com/\">" +
                    "<ns2:ProcessMovementState>" +
                       "<ProcessMovementStateRequest>" +
                            "<AuditInformation>" +
                                "<TransactionId>SOAPTEST</TransactionId>" +
                                "<ProcessingTime>2015-09-08T16:37:37.684-04:00</ProcessingTime>" +
                                "<VendorTimeStamp>2015-09-08T16:37:37.684-04:00</VendorTimeStamp>" +
                                "<ProcessedTimeStamp>2015-09-08T16:37:37.684-04:00</ProcessedTimeStamp>" +
                                "<UserName>John Doe</UserName>" +
                            "</AuditInformation>" +
                            "<MovementStates>" +
                                "<Vehicle>" +
                                    "<Vin>VINID1</Vin>" +
                                    "<State>Active</State>" +
                                "</Vehicle>" +
                            "</MovementStates>" +
                        "</ProcessMovementStateRequest>" +
                    "</ns2:ProcessMovementState>" +
                "</S:Body>" +
            "</S:Envelope>";

    //send the soap message with required data and verify correct response
    
    Map<String, String> authHeader = new HashMap<String, String>();
    authHeader.put("name", "ProcessMovementState");
    
    //send the message and get a response
    String xml = given()
                    .request()
                    .headers(authHeader)
                    .contentType("application/soap+xml; charset=UTF-8;")
                    .body(soapMessage)
                .when()
                    .post("http://website.com:9090/service/external/service")
                    .andReturn()
                    .asString();
   
    //take the string output and display results
        String prettyXML = with(xml).prettyPrint();	    
        System.out.println(prettyXML);
    }    
}