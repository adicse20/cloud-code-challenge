package com.function.codechallenge;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

import java.util.*;

import java.util.Optional;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {
    /**
     * This function listens at endpoint "/api/HttpExample". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/HttpExample
     * 2. curl "{your host}/api/HttpExample?name=HTTP%20Query"
     */
    @FunctionName("HttpExample")
    public HttpResponseMessage run(
            @HttpTrigger(
                name = "req",
                methods = {HttpMethod.GET, HttpMethod.POST},
                authLevel = AuthorizationLevel.ANONYMOUS)
                HttpRequestMessage<Optional<String>> request,
               // @BindingName("queryValue") String queryValue,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

        // Parse query parameter
        final String query = request.getQueryParameters().get("name");
        final String query2 = request.getQueryParameters().get("surname");
        
        final String name = request.getBody().orElse(query);
        final String surname = request.getBody().orElse(query2);


        if (name == null) {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("Please pass a name on the query string or in the request body").build();
        } else {
            return request.createResponseBuilder(HttpStatus.OK).body("Hello, " + name+surname).build();
        }
    }

    @FunctionName("Challenge3")
    public HttpResponseMessage challenge3(
            @HttpTrigger(
                name = "req",
                methods = {HttpMethod.GET, HttpMethod.POST},
                authLevel = AuthorizationLevel.ANONYMOUS)
                HttpRequestMessage<Optional<String>> request,
                
               // @BindingName("queryValue") String queryValue,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

        // Parse query parameter
        final String query = request.getQueryParameters().get("name");
        
        final String name = request.getBody().orElse(query);

        context.getLogger().info("value of input keys is::sssssss");
        final String query3 = request.getQueryParameters().get("fourthCharacter");
        final String fourthCharacter = request.getBody().orElse(query3);


        final String query4 = request.getQueryParameters().get("thirdCharacter");
        final String thirdCharacter = request.getBody().orElse(query4);
        
        final String query5 = request.getQueryParameters().get("secondCharacter");
        final String secondCharacter = request.getBody().orElse(query5);

        final String query6 = request.getQueryParameters().get("firstCharacter");
        final String firstCharacter = request.getBody().orElse(query6);

        final String query7 = request.getQueryParameters().get("inputkeys");
       final String inputkeys = request.getBody().orElse(query7);
    
        Map<String, Object> u = new HashMap<>();

		Map<String, Object> a = new HashMap<>();
		Map<String, Object> b = new HashMap<>();
		b.put(thirdCharacter,fourthCharacter);
		a.put(secondCharacter, b);
		u.put(firstCharacter, a);

        

        String[] keys = inputkeys.split("/");
        Object value = u;
        for (String k : keys) {
            value = ((Map<String, Object>) value).get(k);
        }	

        if (name == null) {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("Please pass a name on the query string or in the request body").build();
        } else {
            //return request.createResponseBuilder(HttpStatus.OK).body("Hello, " + name+"|"+fourthCharacter+thirdCharacter+secondCharacter+firstCharacter+inputkeys+"|||"+value).build();
           return request.createResponseBuilder(HttpStatus.OK).body("Value return is:::" + value).build();
        }
    }


    




}
