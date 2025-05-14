package com.example;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.Page;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
//import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.*;
import java.util.*;

public class DynamoService {


	
	protected ArrayList<String> doInBackground(String... params) {
		String tableName = "dataStore";//params[0];

		ArrayList<String> tempList = new ArrayList<String>();

		/*AmazonDynamoDBClient dynamoDBClient = new AmazonDynamoDBClient (
				new BasicAWSCredentials(Constants.ACCESS_KEY_ID,
						Constants.SECRET_KEY));

*/
		AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder.standard().build();
		//DynamoDB dynamoDBClient = new DynamoDB(client);

		ScanRequest scanRequest = new ScanRequest()
			.withTableName(tableName);
			//.withAttributesToGet("name");
		ScanResult result = dynamoDBClient.scan(scanRequest);


		for (Map<String, AttributeValue> item : result.getItems()) {
			tempList.add(item.toString());
			//analizeItem(tempList, item);
		}

		return tempList;
	}

}