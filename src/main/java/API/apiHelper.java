package API;

import java.io.IOException;

import commonUtils.propertyFileUtil;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class apiHelper {

	public static int rest_status;
	public static String rest_response;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//rest_get("https://www.google.com/",false);
		//rest_post("https://jsonplaceholder.typicode.com/posts",false,"{\"title\": \"Vala\",\"body\": \"bodyvalue\",\"userId\": 9999}"); 
		rest_post("http://dummy.restapiexample.com/api/v1/create",false,"{\"name\":\"test Vala\",\"salary\":\"123\",\"age\":\"23\",\"id\":\"4321\"}"); 

		System.out.println("Rest status after Post ==> " + rest_status);
		System.out.println("Rest Response after Post ==> " + rest_response);

		rest_update("http://dummy.restapiexample.com/api/v1/update/4321",false,"{\"name\":\"ValaVala\",\"salary\":\"123456\",\"age\":\"23\",\"id\":\"4321\"}"); 
		
		System.out.println("Rest status after UPDATE ==> " + rest_status);
		System.out.println("Rest Response after UPDATE ==> " + rest_response);
		
		rest_get("http://dummy.restapiexample.com/api/v1/employee/4321",false);
		
		System.out.println("Rest status after GET ==> " + rest_status);
		System.out.println("Rest Response after GET==> " + rest_response);
		
		rest_delete("http://dummy.restapiexample.com/api/v1/delete/4321",false); 
		
		System.out.println("Rest status after DELETE==> " + rest_status);
		System.out.println("Rest Response after DELETE==> " + rest_response);

		//rest_update("http://dummy.restapiexample.com/api/v1/employees",false); 
		


	}
	
	public static void rest_get(String url,boolean flagauth) throws IOException {
		rest_status=0;
		rest_response="";
		
		new RestAssured();
		//System.out.println(System.getProperty("user.dir"));
		RequestSpecification httpReq=RestAssured.given();
		//httpReq.header("Context-Type","application/json");
		if (flagauth) {
			//Basic authentication code
			httpReq.auth().basic(propertyFileUtil.getInstance().getProperty("rest.uname"), propertyFileUtil.getInstance().getProperty("rest.pwd"));
		}
		
		Response res= httpReq.request(Method.GET,url);

		rest_status=res.getStatusCode();
		rest_response=res.toString();
	}

	public static void rest_post(String url,boolean flagauth,String json) throws IOException {
		rest_status=0;
		rest_response="";
		
		new RestAssured();
		//System.out.println(System.getProperty("user.dir"));
		RequestSpecification httpReq=RestAssured.given();
		//httpReq.header("Content-Type","application/json");
		httpReq.header("Content-type","application/json; charset=UTF-8");
		httpReq.body(json);
		
		if (flagauth) 
			httpReq.auth().basic(propertyFileUtil.getInstance().getProperty("rest.uname"), propertyFileUtil.getInstance().getProperty("rest.pwd"));
		
		
		Response res= httpReq.request(Method.POST,url);

		rest_status=res.getStatusCode();
		rest_response=res.toString();


	}


	public static void rest_update(String url,boolean flagauth,String json) throws IOException {
		rest_status=0;
		rest_response="";
		
		new RestAssured();
		//System.out.println(System.getProperty("user.dir"));
		RequestSpecification httpReq=RestAssured.given();
		//httpReq.header("Content-Type","application/json");
		httpReq.header("Content-type","application/json; charset=UTF-8");
		httpReq.body(json);
		
		if (flagauth) 
			httpReq.auth().basic(propertyFileUtil.getInstance().getProperty("rest.uname"), propertyFileUtil.getInstance().getProperty("rest.pwd"));
		
		
		Response res= httpReq.request(Method.PUT
				,url);

		rest_status=res.getStatusCode();
		rest_response=res.toString();


	}

	public static void rest_delete(String url,boolean flagauth) throws IOException {
		rest_status=0;
		rest_response="";
		
		//System.out.println(System.getProperty("user.dir"));
		RequestSpecification httpReq=RestAssured.given();
		//httpReq.header("Content-Type","application/json");
		httpReq.header("Content-type","application/json; charset=UTF-8");

		if (flagauth) 
			httpReq.auth().basic(propertyFileUtil.getInstance().getProperty("rest.uname"), propertyFileUtil.getInstance().getProperty("rest.pwd"));
		
		Response res= httpReq.request(Method.DELETE,url);

		rest_status=res.getStatusCode();
		rest_response=res.toString();


	}


	
}




/*
 * REFERECE WEBSITE FOR FREE REST WEBSITE
 * **************************************************************
 * https://reqres.in/
 * http://dummy.restapiexample.com/
 * https://reqres.in/
 * 
 * GOOD ARTICLES TO READ
 * **************************************************************
 * https://stackoverflow.com/questions/19884295/soap-vs-rest-differences
 * https://testautomationresources.com/api-testing/differences-web-services-api/
 * 
 * 
*******************************
Why REST?
*******************************
Since REST uses standard HTTP it is much simpler in just about ever way.
REST is easier to implement, requires less bandwidth and resources.
REST permits many different data formats where as SOAP only permits XML.
REST allows better support for browser clients due to its support for JSON.
REST has better performance and scalability. REST reads can be cached, SOAP based reads cannot be cached.
If security is not a major concern and we have limited resources. Or we want to create an API that will be easily used by other developers publicly then we should go with REST.
If we need Stateless CRUD operations then go with REST.
REST is commonly used in social media, web chat, mobile services and Public APIs like Google Maps.
RESTful service return various MediaTypes for the same resource, depending on the request header parameter "Accept" as application/xml or application/json for POST and /user/1234.json or GET /user/1234.xml for GET.
REST services are meant to be called by the client-side application and not the end user directly.
ST in REST comes from State Transfer. You transfer the state around instead of having the server store it, this makes REST services scalable.

*******************************
Why SOAP?
*******************************
SOAP is not very easy to implement and requires more bandwidth and resources.
SOAP message request is processed slower as compared to REST and it does not use web caching mechanism.
WS-Security: While SOAP supports SSL (just like REST) it also supports WS-Security which adds some enterprise security features.
WS-AtomicTransaction: Need ACID Transactions over a service, you’re going to need SOAP.
WS-ReliableMessaging: If your application needs Asynchronous processing and a guaranteed level of reliability and security. Rest doesn’t have a standard messaging system and expects clients to deal with communication failures by retrying.
If the security is a major concern and the resources are not limited then we should use SOAP web services. Like if we are creating a web service for payment gateways, financial and telecommunication related work then we should go with SOAP as here high security is needed.

 */
