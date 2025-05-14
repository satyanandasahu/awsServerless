package com.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.util.ArrayList;

public class MyFirstFunction implements RequestHandler<Object, String> {
	
    public String handleRequest(final Object input, final Context context) {
	
		String returnString = "{ 'id': '1001', 'type': 'Regular' }";
		DynamoService dynamoService = new DynamoService();
		ArrayList<String> listData = dynamoService.doInBackground("dataStore");

													
        System.out.println(input + " " + returnString + " data " + listData);
        return listData.toString();
    }
}
