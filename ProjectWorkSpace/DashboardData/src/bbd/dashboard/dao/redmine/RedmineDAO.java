package bbd.dashboard.dao.redmine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONObject;

import bbd.dashboard.Log;

public class RedmineDAO {
	private static RedmineDAO instance;
	
	private RedmineDAO() {
	}
	
	public static RedmineDAO getInstance() {
		if(instance == null)
			instance = new RedmineDAO();
		
		return instance;
	}
	
	
	/*Gets a list of Redmine Query IDs from text file.
	 *If the file does not exist, it is created but not populated with 
	 *a default query number, but does throw an exception notifying that 
	 *file has been created but is still empty.
	 */
	public List<String> getRedmineId(){
		List<String> id = new ArrayList<String>();
		
		try {
			File file = new File("QueryId.txt");
			if (!file.exists()){
				file.createNewFile();
				throw new FileNotFoundException("File (QueryId.txt) has been created but is still empty");
			}
			Scanner scan = new Scanner(file);
		    while(scan.hasNextLine()){
		    	id.add(scan.nextLine());		    	
		    } 		    
		    scan.close();			
		}
		catch (Exception e){
			Log.error(e);
		}
		return id;
				
	}
	
	/* Retrieves a list of Redmine queries as JSON objects using the 
	 * list of IDs retrieved from the getRedmineId() method as an input parameter
	 */
	/*public List<JSONObject> GetRedmineQuery(List<String> id){
		
		String URL = "https://redmine.acturis.com//projects/yellow-application-development-r6-0-l/issues.json?query_id=";
		String Authentication ="&key=04c263c64e89b13424e67b5da2bcac4f82c1a8f8";
		
		List<JSONObject> results = new ArrayList<JSONObject>();
		try {
			/*for (int i = 0; i < id.size(); i++){
				HttpResponse<JsonNode> response = Unirest.get(URL + id.get(i) + Authentication)					  
						  .asJson();
				
				JSONObject convert = new JSONObject(response);
				
				results.add(convert);
			}*/
		/*	JSONObject convert = new JSONObject(JSON);
			results.add(convert);
			return results;
			
		} catch (Exception e) {
			Log.error(e);
			return null;
		}
	}*/
	
	public String GetRedmineQuery(List<String> id) {
		return JSON;
	}
	
	private String JSON = "{\r\n" + 
			"  \"issues\": [\r\n" + 
			"    {\r\n" + 
			"      \"id\": 248783,\r\n" + 
			"      \"project\": {\r\n" + 
			"        \"id\": 342,\r\n" + 
			"        \"name\": \"Yellow Application Development R6.0 (L)\"\r\n" + 
			"      },\r\n" + 
			"      \"tracker\": {\r\n" + 
			"        \"id\": 131,\r\n" + 
			"        \"name\": \"Defect\"\r\n" + 
			"      },\r\n" + 
			"      \"status\": {\r\n" + 
			"        \"id\": 115,\r\n" + 
			"        \"name\": \"[Trunk] Awaiting drop \"\r\n" + 
			"      },\r\n" + 
			"      \"priority\": {\r\n" + 
			"        \"id\": 6,\r\n" + 
			"        \"name\": \"Medium\"\r\n" + 
			"      },\r\n" + 
			"      \"author\": {\r\n" + 
			"        \"id\": 563,\r\n" + 
			"        \"name\": \"Beata Sadek\"\r\n" + 
			"      },\r\n" + 
			"      \"assigned_to\": {\r\n" + 
			"        \"id\": 25,\r\n" + 
			"        \"name\": \"-BBD Defects\"\r\n" + 
			"      },\r\n" + 
			"      \"parent\": {\r\n" + 
			"        \"id\": 229483\r\n" + 
			"      },\r\n" + 
			"      \"subject\": \"CR865 A1 - 3.1.1 - AccountLocate Component - LocateEntityClientLedgerPendingTransaction - No filtering for BusinessEvent \",\r\n" + 
			"      \"description\": \"1. Run:\\r\\n<LocateEntityClientLedgerPendingTransaction>\\r\\n    <Message>\\r\\n        <EntityRef Value=\\\"0101\\\" />\\r\\n        <ProductTarget Value=\\\"80\\\" />\\r\\n        <Insurer Value=\\\"201\\\" />\\r\\n        <BusinessEvent Value=\\\"10\\\" />\\r\\n        <EffectiveDateFrom Value=\\\"20150808\\\" />\\r\\n        <EffectiveDateTo Value=\\\"20160809\\\" />\\r\\n        <FirstResult Value=\\\"1\\\" />\\r\\n        <LastResult Value=\\\"50\\\" />\\r\\n    </Message>\\r\\n</LocateEntityClientLedgerPendingTransaction>\\r\\n\\r\\n:: It gives responses with BusinessEvent <>10\",\r\n" + 
			"      \"start_date\": \"2016-08-09\",\r\n" + 
			"      \"done_ratio\": 0,\r\n" + 
			"      \"custom_fields\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 83,\r\n" + 
			"          \"name\": \"How Found'\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 844,\r\n" + 
			"          \"name\": \"Affected code versions\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Trunk\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 87,\r\n" + 
			"          \"name\": \"Module'\",\r\n" + 
			"          \"value\": \"N/A\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 6,\r\n" + 
			"          \"name\": \"Resolution Code\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 181,\r\n" + 
			"          \"name\": \"Trunk Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 782,\r\n" + 
			"          \"name\": \"Pre-Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 684,\r\n" + 
			"          \"name\": \"Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 8,\r\n" + 
			"          \"name\": \"Steps to reproduce\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 9,\r\n" + 
			"          \"name\": \"Expected results\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 10,\r\n" + 
			"          \"name\": \"Additional Info\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 88,\r\n" + 
			"          \"name\": \"Footprint No'\",\r\n" + 
			"          \"value\": \"N/A\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 20,\r\n" + 
			"          \"name\": \"Release version No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 650,\r\n" + 
			"          \"name\": \"Internal release notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 869,\r\n" + 
			"          \"name\": \"Needed in Rel Notes/Func Guide\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 850,\r\n" + 
			"          \"name\": \"Include in Client Notes?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 89,\r\n" + 
			"          \"name\": \"Release notes Desc'\",\r\n" + 
			"          \"value\": \"N/A\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 27,\r\n" + 
			"          \"name\": \"Resolution\",\r\n" + 
			"          \"value\": \"VW 10/08/2016 Fixed in prod patch v1129.0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 47,\r\n" + 
			"          \"name\": \"Act Finish Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 97,\r\n" + 
			"          \"name\": \"Analyst Assigned To\",\r\n" + 
			"          \"value\": \"Beata Sadek\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 102,\r\n" + 
			"          \"name\": \"Priority Defect\",\r\n" + 
			"          \"value\": \"No\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 113,\r\n" + 
			"          \"name\": \"Deferred reason\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 115,\r\n" + 
			"          \"name\": \"Developer\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Wojciech Minko\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 146,\r\n" + 
			"          \"name\": \"Back End Components\",\r\n" + 
			"          \"value\": \"AccountLocate\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 147,\r\n" + 
			"          \"name\": \"Front End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 148,\r\n" + 
			"          \"name\": \"XSI Files\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 177,\r\n" + 
			"          \"name\": \"Scripts\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 178,\r\n" + 
			"          \"name\": \"Applications or Client Tools\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 230,\r\n" + 
			"          \"name\": \"Exclude from Regression Tests\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 247,\r\n" + 
			"          \"name\": \"Completed Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 287,\r\n" + 
			"          \"name\": \"Crucible Reviewers\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 288,\r\n" + 
			"          \"name\": \"Crucible No.\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 292,\r\n" + 
			"          \"name\": \"Trunk - pre-prod merge\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 843,\r\n" + 
			"          \"name\": \"Scope Change?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 771,\r\n" + 
			"          \"name\": \"App Functional Area\",\r\n" + 
			"          \"value\": \"Back-end processing issue\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 773,\r\n" + 
			"          \"name\": \"App Module\",\r\n" + 
			"          \"value\": \"N/A\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 774,\r\n" + 
			"          \"name\": \"WS Function\",\r\n" + 
			"          \"value\": \"LocateEntityClientLedgerPendingTransaction\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 775,\r\n" + 
			"          \"name\": \"[Merge Review] Trunk > PreProd\",\r\n" + 
			"          \"value\": \"0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 784,\r\n" + 
			"          \"name\": \"[Merge Review] Pre-Prod > Prod\",\r\n" + 
			"          \"value\": \"0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 823,\r\n" + 
			"          \"name\": \"Production Defect?\",\r\n" + 
			"          \"value\": \"0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 854,\r\n" + 
			"          \"name\": \"Old Project\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 903,\r\n" + 
			"          \"name\": \"Needed in R6.0.6++?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 906,\r\n" + 
			"          \"name\": \"Regression Scope (Developers)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 939,\r\n" + 
			"          \"name\": \"Code Review Status\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 938,\r\n" + 
			"          \"name\": \"Code Reviewed by (BB&D)\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 935,\r\n" + 
			"          \"name\": \"Code Reviewed on Branch\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 936,\r\n" + 
			"          \"name\": \"Code Review Notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        }\r\n" + 
			"      ],\r\n" + 
			"      \"created_on\": \"2016-08-09T13:44:07Z\",\r\n" + 
			"      \"updated_on\": \"2016-08-10T07:55:19Z\"\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 248761,\r\n" + 
			"      \"project\": {\r\n" + 
			"        \"id\": 342,\r\n" + 
			"        \"name\": \"Yellow Application Development R6.0 (L)\"\r\n" + 
			"      },\r\n" + 
			"      \"tracker\": {\r\n" + 
			"        \"id\": 131,\r\n" + 
			"        \"name\": \"Defect\"\r\n" + 
			"      },\r\n" + 
			"      \"status\": {\r\n" + 
			"        \"id\": 115,\r\n" + 
			"        \"name\": \"[Trunk] Awaiting drop \"\r\n" + 
			"      },\r\n" + 
			"      \"priority\": {\r\n" + 
			"        \"id\": 6,\r\n" + 
			"        \"name\": \"Medium\"\r\n" + 
			"      },\r\n" + 
			"      \"author\": {\r\n" + 
			"        \"id\": 880,\r\n" + 
			"        \"name\": \"Jonathan Reichl\"\r\n" + 
			"      },\r\n" + 
			"      \"assigned_to\": {\r\n" + 
			"        \"id\": 25,\r\n" + 
			"        \"name\": \"-BBD Defects\"\r\n" + 
			"      },\r\n" + 
			"      \"parent\": {\r\n" + 
			"        \"id\": 227400\r\n" + 
			"      },\r\n" + 
			"      \"subject\": \"CR988 A6 - LocateEntityAgentLedgerPendingReceipt - Cash_Batch_Status update \",\r\n" + 
			"      \"description\": \"Hi,\\r\\n\\r\\nPlease can we Update the Cash_Batch_Status filter from this:\\r\\nAND ARCB.CASH_BATCH_STATUS in (1 , 2) ------PENDING \\r\\n\\r\\n\\r\\nto the following:\\r\\nAND ARCB.CASH_BATCH_STATUS in (0 , 1 , 2) ------PENDING \\r\\n\\r\\n\\r\\nRegards \\r\\nJonny\\r\\n\",\r\n" + 
			"      \"start_date\": \"2016-08-09\",\r\n" + 
			"      \"done_ratio\": 0,\r\n" + 
			"      \"custom_fields\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 83,\r\n" + 
			"          \"name\": \"How Found'\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 844,\r\n" + 
			"          \"name\": \"Affected code versions\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Trunk\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 87,\r\n" + 
			"          \"name\": \"Module'\",\r\n" + 
			"          \"value\": \"Accounting - Client Ledger\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 6,\r\n" + 
			"          \"name\": \"Resolution Code\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 181,\r\n" + 
			"          \"name\": \"Trunk Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 782,\r\n" + 
			"          \"name\": \"Pre-Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 684,\r\n" + 
			"          \"name\": \"Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 8,\r\n" + 
			"          \"name\": \"Steps to reproduce\",\r\n" + 
			"          \"value\": \"\\r\\n\\r\\n1) Call AddClientReceipt (for and agent)\\r\\n2) call LocateEntityClientLedgerPendingReceipt \\r\\n:: Receipts now returned \\r\\n\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 9,\r\n" + 
			"          \"name\": \"Expected results\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 10,\r\n" + 
			"          \"name\": \"Additional Info\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 88,\r\n" + 
			"          \"name\": \"Footprint No'\",\r\n" + 
			"          \"value\": \"N/A\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 20,\r\n" + 
			"          \"name\": \"Release version No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 650,\r\n" + 
			"          \"name\": \"Internal release notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 869,\r\n" + 
			"          \"name\": \"Needed in Rel Notes/Func Guide\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 850,\r\n" + 
			"          \"name\": \"Include in Client Notes?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 89,\r\n" + 
			"          \"name\": \"Release notes Desc'\",\r\n" + 
			"          \"value\": \"N/A\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 27,\r\n" + 
			"          \"name\": \"Resolution\",\r\n" + 
			"          \"value\": \"VW 10/08/2016 Fixed in prod patch v1129.0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 47,\r\n" + 
			"          \"name\": \"Act Finish Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 97,\r\n" + 
			"          \"name\": \"Analyst Assigned To\",\r\n" + 
			"          \"value\": \"Beata Sadek\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 102,\r\n" + 
			"          \"name\": \"Priority Defect\",\r\n" + 
			"          \"value\": \"No\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 113,\r\n" + 
			"          \"name\": \"Deferred reason\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 115,\r\n" + 
			"          \"name\": \"Developer\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Ewa Mazur\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 146,\r\n" + 
			"          \"name\": \"Back End Components\",\r\n" + 
			"          \"value\": \"AccountLocate\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 147,\r\n" + 
			"          \"name\": \"Front End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 148,\r\n" + 
			"          \"name\": \"XSI Files\",\r\n" + 
			"          \"value\": \"AccountLocateTX.xsi\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 177,\r\n" + 
			"          \"name\": \"Scripts\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 178,\r\n" + 
			"          \"name\": \"Applications or Client Tools\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 230,\r\n" + 
			"          \"name\": \"Exclude from Regression Tests\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 247,\r\n" + 
			"          \"name\": \"Completed Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 287,\r\n" + 
			"          \"name\": \"Crucible Reviewers\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 288,\r\n" + 
			"          \"name\": \"Crucible No.\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 292,\r\n" + 
			"          \"name\": \"Trunk - pre-prod merge\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 843,\r\n" + 
			"          \"name\": \"Scope Change?\",\r\n" + 
			"          \"value\": \"1\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 771,\r\n" + 
			"          \"name\": \"App Functional Area\",\r\n" + 
			"          \"value\": \"XSI query change\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 773,\r\n" + 
			"          \"name\": \"App Module\",\r\n" + 
			"          \"value\": \"Accounting - Client Ledger\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 774,\r\n" + 
			"          \"name\": \"WS Function\",\r\n" + 
			"          \"value\": \"N/A\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 775,\r\n" + 
			"          \"name\": \"[Merge Review] Trunk > PreProd\",\r\n" + 
			"          \"value\": \"0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 784,\r\n" + 
			"          \"name\": \"[Merge Review] Pre-Prod > Prod\",\r\n" + 
			"          \"value\": \"0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 823,\r\n" + 
			"          \"name\": \"Production Defect?\",\r\n" + 
			"          \"value\": \"0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 854,\r\n" + 
			"          \"name\": \"Old Project\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 903,\r\n" + 
			"          \"name\": \"Needed in R6.0.6++?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 906,\r\n" + 
			"          \"name\": \"Regression Scope (Developers)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 939,\r\n" + 
			"          \"name\": \"Code Review Status\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 938,\r\n" + 
			"          \"name\": \"Code Reviewed by (BB&D)\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 935,\r\n" + 
			"          \"name\": \"Code Reviewed on Branch\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 936,\r\n" + 
			"          \"name\": \"Code Review Notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        }\r\n" + 
			"      ],\r\n" + 
			"      \"created_on\": \"2016-08-09T11:23:24Z\",\r\n" + 
			"      \"updated_on\": \"2016-08-10T08:12:43Z\"\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 248758,\r\n" + 
			"      \"project\": {\r\n" + 
			"        \"id\": 342,\r\n" + 
			"        \"name\": \"Yellow Application Development R6.0 (L)\"\r\n" + 
			"      },\r\n" + 
			"      \"tracker\": {\r\n" + 
			"        \"id\": 131,\r\n" + 
			"        \"name\": \"Defect\"\r\n" + 
			"      },\r\n" + 
			"      \"status\": {\r\n" + 
			"        \"id\": 115,\r\n" + 
			"        \"name\": \"[Trunk] Awaiting drop \"\r\n" + 
			"      },\r\n" + 
			"      \"priority\": {\r\n" + 
			"        \"id\": 6,\r\n" + 
			"        \"name\": \"Medium\"\r\n" + 
			"      },\r\n" + 
			"      \"author\": {\r\n" + 
			"        \"id\": 880,\r\n" + 
			"        \"name\": \"Jonathan Reichl\"\r\n" + 
			"      },\r\n" + 
			"      \"assigned_to\": {\r\n" + 
			"        \"id\": 25,\r\n" + 
			"        \"name\": \"-BBD Defects\"\r\n" + 
			"      },\r\n" + 
			"      \"parent\": {\r\n" + 
			"        \"id\": 227398\r\n" + 
			"      },\r\n" + 
			"      \"subject\": \"CR988 A6 - LocateEntityClientLedgerPendingReceipt - Cash_Batch_Status update \",\r\n" + 
			"      \"description\": \"Hi, \\r\\n\\r\\nPlease can we Update the Cash_Batch_Status filter from this: \\r\\n\\r\\n<pre>\\r\\nAND ARCB.CASH_BATCH_STATUS in (1 , 2) ------PENDING \\r\\n</pre>\\r\\n\\r\\nto the following: \\r\\n\\r\\n<pre>\\r\\nAND ARCB.CASH_BATCH_STATUS in (0 , 1 , 2) ------PENDING \\r\\n</pre>\\r\\n\\r\\nRegards \\r\\nJonny \",\r\n" + 
			"      \"start_date\": \"2016-08-09\",\r\n" + 
			"      \"done_ratio\": 0,\r\n" + 
			"      \"custom_fields\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 83,\r\n" + 
			"          \"name\": \"How Found'\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 844,\r\n" + 
			"          \"name\": \"Affected code versions\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Trunk\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 87,\r\n" + 
			"          \"name\": \"Module'\",\r\n" + 
			"          \"value\": \"Accounting - Client Ledger\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 6,\r\n" + 
			"          \"name\": \"Resolution Code\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 181,\r\n" + 
			"          \"name\": \"Trunk Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 782,\r\n" + 
			"          \"name\": \"Pre-Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 684,\r\n" + 
			"          \"name\": \"Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 8,\r\n" + 
			"          \"name\": \"Steps to reproduce\",\r\n" + 
			"          \"value\": \"1) Call AddClientReceipt (For a Client) \\r\\n2) call LocateEntityClientLedgerPendingReceipt \\r\\n:: Receipts now returned \"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 9,\r\n" + 
			"          \"name\": \"Expected results\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 10,\r\n" + 
			"          \"name\": \"Additional Info\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 88,\r\n" + 
			"          \"name\": \"Footprint No'\",\r\n" + 
			"          \"value\": \"N/A\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 20,\r\n" + 
			"          \"name\": \"Release version No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 650,\r\n" + 
			"          \"name\": \"Internal release notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 869,\r\n" + 
			"          \"name\": \"Needed in Rel Notes/Func Guide\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 850,\r\n" + 
			"          \"name\": \"Include in Client Notes?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 89,\r\n" + 
			"          \"name\": \"Release notes Desc'\",\r\n" + 
			"          \"value\": \"N/A\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 27,\r\n" + 
			"          \"name\": \"Resolution\",\r\n" + 
			"          \"value\": \"VW 10/08/2016 Fixed in prod patch v1129.0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 47,\r\n" + 
			"          \"name\": \"Act Finish Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 97,\r\n" + 
			"          \"name\": \"Analyst Assigned To\",\r\n" + 
			"          \"value\": \"Beata Sadek\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 102,\r\n" + 
			"          \"name\": \"Priority Defect\",\r\n" + 
			"          \"value\": \"No\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 113,\r\n" + 
			"          \"name\": \"Deferred reason\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 115,\r\n" + 
			"          \"name\": \"Developer\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Ewa Mazur\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 146,\r\n" + 
			"          \"name\": \"Back End Components\",\r\n" + 
			"          \"value\": \"AccountLocate\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 147,\r\n" + 
			"          \"name\": \"Front End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 148,\r\n" + 
			"          \"name\": \"XSI Files\",\r\n" + 
			"          \"value\": \"AccountLocateTX.xsi\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 177,\r\n" + 
			"          \"name\": \"Scripts\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 178,\r\n" + 
			"          \"name\": \"Applications or Client Tools\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 230,\r\n" + 
			"          \"name\": \"Exclude from Regression Tests\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 247,\r\n" + 
			"          \"name\": \"Completed Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 287,\r\n" + 
			"          \"name\": \"Crucible Reviewers\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 288,\r\n" + 
			"          \"name\": \"Crucible No.\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 292,\r\n" + 
			"          \"name\": \"Trunk - pre-prod merge\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 843,\r\n" + 
			"          \"name\": \"Scope Change?\",\r\n" + 
			"          \"value\": \"1\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 771,\r\n" + 
			"          \"name\": \"App Functional Area\",\r\n" + 
			"          \"value\": \"XSI query change\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 773,\r\n" + 
			"          \"name\": \"App Module\",\r\n" + 
			"          \"value\": \"Accounting - Client Ledger\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 774,\r\n" + 
			"          \"name\": \"WS Function\",\r\n" + 
			"          \"value\": \"N/A\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 775,\r\n" + 
			"          \"name\": \"[Merge Review] Trunk > PreProd\",\r\n" + 
			"          \"value\": \"0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 784,\r\n" + 
			"          \"name\": \"[Merge Review] Pre-Prod > Prod\",\r\n" + 
			"          \"value\": \"0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 823,\r\n" + 
			"          \"name\": \"Production Defect?\",\r\n" + 
			"          \"value\": \"0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 854,\r\n" + 
			"          \"name\": \"Old Project\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 903,\r\n" + 
			"          \"name\": \"Needed in R6.0.6++?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 906,\r\n" + 
			"          \"name\": \"Regression Scope (Developers)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 939,\r\n" + 
			"          \"name\": \"Code Review Status\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 938,\r\n" + 
			"          \"name\": \"Code Reviewed by (BB&D)\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 935,\r\n" + 
			"          \"name\": \"Code Reviewed on Branch\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 936,\r\n" + 
			"          \"name\": \"Code Review Notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        }\r\n" + 
			"      ],\r\n" + 
			"      \"created_on\": \"2016-08-09T11:19:09Z\",\r\n" + 
			"      \"updated_on\": \"2016-08-10T08:13:22Z\"\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 248748,\r\n" + 
			"      \"project\": {\r\n" + 
			"        \"id\": 342,\r\n" + 
			"        \"name\": \"Yellow Application Development R6.0 (L)\"\r\n" + 
			"      },\r\n" + 
			"      \"tracker\": {\r\n" + 
			"        \"id\": 131,\r\n" + 
			"        \"name\": \"Defect\"\r\n" + 
			"      },\r\n" + 
			"      \"status\": {\r\n" + 
			"        \"id\": 115,\r\n" + 
			"        \"name\": \"[Trunk] Awaiting drop \"\r\n" + 
			"      },\r\n" + 
			"      \"priority\": {\r\n" + 
			"        \"id\": 6,\r\n" + 
			"        \"name\": \"Medium\"\r\n" + 
			"      },\r\n" + 
			"      \"author\": {\r\n" + 
			"        \"id\": 563,\r\n" + 
			"        \"name\": \"Beata Sadek\"\r\n" + 
			"      },\r\n" + 
			"      \"assigned_to\": {\r\n" + 
			"        \"id\": 25,\r\n" + 
			"        \"name\": \"-BBD Defects\"\r\n" + 
			"      },\r\n" + 
			"      \"parent\": {\r\n" + 
			"        \"id\": 229483\r\n" + 
			"      },\r\n" + 
			"      \"subject\": \"CR865 A1 - 3.1.1 - AccountLocate Component - LocateEntityClientLedgerPendingAllocation\",\r\n" + 
			"      \"description\": \"1. Run:\\r\\n<LocateEntityClientLedgerPendingAllocation>\\r\\n    <Message>\\r\\n        <EntityRef Value=\\\"0101\\\" />\\r\\n        <IncludeCompleteAllocationsOnlyIndicator Value=\\\"5/6\\\" />\\r\\n        <LocateEntityClientLedgerPendingAllocationSearchOn Value=\\\"1\\\" />\\r\\n        <LocateEntityClientLedgerPendingAllocSearchOnValue Value=\\\"81706\\\" />\\r\\n        <FirstResult Value=\\\"1\\\" />\\r\\n        <LastResult Value=\\\"50\\\" />\\r\\n    </Message>\\r\\n</LocateEntityClientLedgerPendingAllocation>\\r\\n\\r\\n:: <Result Value=\\\"206\\\" Desc=\\\"0 results returned in the message.\\\" Code=\\\"5510\\\" Type=\\\"Information\\\" /> \\r\\nThere is a row in the DB\\r\\nSELECT D.Comp_Code As EntityRef\\r\\n     , D.Account_Ref As ClientRef\\r\\n     , C.Cust_Name   As ClientName\\r\\n     , SUBSTR(D.Account_Ref,1 ,LENGTH(D.Account_ref) -1) As ContactRef\\r\\n     , D.Allocation_Ref As AllocationRef\\r\\n     , To_Char(D.Movement_Date, 'YYYYMMDD') As AllocationDate\\r\\n     , D.Allocation_Desc As AllocationDescription\\r\\n     , D.ALLOC_STATUS As AllocationStatus\\r\\n     , D.Created_By   As AccountingCreatedBy\\r\\n     , To_Char (Created_Date, 'YYYYMMDD') As AccountingCreatedByDate\\r\\n     , To_Char (Created_Date, 'HH24MISS') As AccountingCreatedByTime\\r\\n   FROM ACT_ALHD@Flexi D\\r\\n   JOIN ARCS@FLEXI C\\r\\n   ON   D.Flx_Prs_Owner = C.Flx_Prs_Owner\\r\\n   AND  D.Account_Ref = C.Cust_Id\\r\\n   WHERE D.Flx_Prs_Owner = :FlexiProcSet\\r\\n   AND D.COMP_CODE = :EntityRef\\r\\n   AND D.ACC_LEDGER_TYPE = '3'\\r\\n   AND D.Alloc_status IN (1, 2, 3, 6) \\r\\n   AND D.REVERSAL_STATUS = 0;\\r\\n   $IncludeCompleteAllcoationsOnlyIndicatorSQL   \\r\\n    $SearchOnSQL;\\r\\n\",\r\n" + 
			"      \"start_date\": \"2016-08-09\",\r\n" + 
			"      \"done_ratio\": 0,\r\n" + 
			"      \"custom_fields\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 83,\r\n" + 
			"          \"name\": \"How Found'\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 844,\r\n" + 
			"          \"name\": \"Affected code versions\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Trunk\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 87,\r\n" + 
			"          \"name\": \"Module'\",\r\n" + 
			"          \"value\": \"N/A\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 6,\r\n" + 
			"          \"name\": \"Resolution Code\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 181,\r\n" + 
			"          \"name\": \"Trunk Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 782,\r\n" + 
			"          \"name\": \"Pre-Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 684,\r\n" + 
			"          \"name\": \"Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 8,\r\n" + 
			"          \"name\": \"Steps to reproduce\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 9,\r\n" + 
			"          \"name\": \"Expected results\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 10,\r\n" + 
			"          \"name\": \"Additional Info\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 88,\r\n" + 
			"          \"name\": \"Footprint No'\",\r\n" + 
			"          \"value\": \"N/A\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 20,\r\n" + 
			"          \"name\": \"Release version No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 650,\r\n" + 
			"          \"name\": \"Internal release notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 869,\r\n" + 
			"          \"name\": \"Needed in Rel Notes/Func Guide\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 850,\r\n" + 
			"          \"name\": \"Include in Client Notes?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 89,\r\n" + 
			"          \"name\": \"Release notes Desc'\",\r\n" + 
			"          \"value\": \"N/A\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 27,\r\n" + 
			"          \"name\": \"Resolution\",\r\n" + 
			"          \"value\": \"VW 10/08/2016 Fixed in prod patch v1129.0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 47,\r\n" + 
			"          \"name\": \"Act Finish Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 97,\r\n" + 
			"          \"name\": \"Analyst Assigned To\",\r\n" + 
			"          \"value\": \"Beata Sadek\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 102,\r\n" + 
			"          \"name\": \"Priority Defect\",\r\n" + 
			"          \"value\": \"No\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 113,\r\n" + 
			"          \"name\": \"Deferred reason\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 115,\r\n" + 
			"          \"name\": \"Developer\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Elzbieta Makiej-Drzazga\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 146,\r\n" + 
			"          \"name\": \"Back End Components\",\r\n" + 
			"          \"value\": \"AccountLocate\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 147,\r\n" + 
			"          \"name\": \"Front End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 148,\r\n" + 
			"          \"name\": \"XSI Files\",\r\n" + 
			"          \"value\": \"AccountLocateTX.xsi\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 177,\r\n" + 
			"          \"name\": \"Scripts\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 178,\r\n" + 
			"          \"name\": \"Applications or Client Tools\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 230,\r\n" + 
			"          \"name\": \"Exclude from Regression Tests\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 247,\r\n" + 
			"          \"name\": \"Completed Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 287,\r\n" + 
			"          \"name\": \"Crucible Reviewers\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 288,\r\n" + 
			"          \"name\": \"Crucible No.\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 292,\r\n" + 
			"          \"name\": \"Trunk - pre-prod merge\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 843,\r\n" + 
			"          \"name\": \"Scope Change?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 771,\r\n" + 
			"          \"name\": \"App Functional Area\",\r\n" + 
			"          \"value\": \"Back-end processing issue\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 773,\r\n" + 
			"          \"name\": \"App Module\",\r\n" + 
			"          \"value\": \"N/A\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 774,\r\n" + 
			"          \"name\": \"WS Function\",\r\n" + 
			"          \"value\": \"LocateEntityClientLedgerPendingRemittance\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 775,\r\n" + 
			"          \"name\": \"[Merge Review] Trunk > PreProd\",\r\n" + 
			"          \"value\": \"0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 784,\r\n" + 
			"          \"name\": \"[Merge Review] Pre-Prod > Prod\",\r\n" + 
			"          \"value\": \"0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 823,\r\n" + 
			"          \"name\": \"Production Defect?\",\r\n" + 
			"          \"value\": \"0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 854,\r\n" + 
			"          \"name\": \"Old Project\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 903,\r\n" + 
			"          \"name\": \"Needed in R6.0.6++?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 906,\r\n" + 
			"          \"name\": \"Regression Scope (Developers)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 939,\r\n" + 
			"          \"name\": \"Code Review Status\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 938,\r\n" + 
			"          \"name\": \"Code Reviewed by (BB&D)\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 935,\r\n" + 
			"          \"name\": \"Code Reviewed on Branch\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 936,\r\n" + 
			"          \"name\": \"Code Review Notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        }\r\n" + 
			"      ],\r\n" + 
			"      \"created_on\": \"2016-08-09T10:46:42Z\",\r\n" + 
			"      \"updated_on\": \"2016-08-10T08:13:59Z\"\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 248698,\r\n" + 
			"      \"project\": {\r\n" + 
			"        \"id\": 342,\r\n" + 
			"        \"name\": \"Yellow Application Development R6.0 (L)\"\r\n" + 
			"      },\r\n" + 
			"      \"tracker\": {\r\n" + 
			"        \"id\": 131,\r\n" + 
			"        \"name\": \"Defect\"\r\n" + 
			"      },\r\n" + 
			"      \"status\": {\r\n" + 
			"        \"id\": 115,\r\n" + 
			"        \"name\": \"[Trunk] Awaiting drop \"\r\n" + 
			"      },\r\n" + 
			"      \"priority\": {\r\n" + 
			"        \"id\": 6,\r\n" + 
			"        \"name\": \"Medium\"\r\n" + 
			"      },\r\n" + 
			"      \"author\": {\r\n" + 
			"        \"id\": 563,\r\n" + 
			"        \"name\": \"Beata Sadek\"\r\n" + 
			"      },\r\n" + 
			"      \"assigned_to\": {\r\n" + 
			"        \"id\": 25,\r\n" + 
			"        \"name\": \"-BBD Defects\"\r\n" + 
			"      },\r\n" + 
			"      \"parent\": {\r\n" + 
			"        \"id\": 229484\r\n" + 
			"      },\r\n" + 
			"      \"subject\": \"CR865 A1 - 3.1.2 - AccountNavigation Component - GetEntitySelectedAgentAllocations - not working\",\r\n" + 
			"      \"description\": \"1. Run:\\r\\n<GetEntitySelectedAgentAllocations>\\r\\n    <Message>\\r\\n        <EntityRef Value=\\\"0101\\\" />\\r\\n        <AgentRef Value=\\\"2267646A\\\" />\\r\\n        <AllocationRef Value=\\\"9539\\\" />\\r\\n    </Message>\\r\\n</GetEntitySelectedAgentAllocations>\\r\\n\\r\\n::Critical Error\\r\\n\\r\\nSELECT HD.Comp_Code As EntityRef\\r\\n     , HD.Account_Ref As AgentRef\\r\\n     , CS.Cust_Name  AS AgentName\\r\\n     , SUBSTR(HD.Account_ref, 1, length(account_ref) -1) AS ContactRef\\r\\n     , HD.Allocation_Ref As AllocationRef\\r\\n     , To_Char(HD.Movement_Date,'YYYYMMDD')  As AllocationDate\\r\\n     , HD.Allocation_Desc As AllocationDescription\\r\\n     , HD.Alloc_Status As AllocationStatus\\r\\n     , HD.Created_By As CreatedBy\\r\\n     , To_Char(HD.Created_Date,'YYYYMMDD') As CreatedDate\\r\\n     , To_Char(HD.Created_Date,'HH24MISS') As CreatedTime\\r\\n  FROM ACT_ALHD@Flexi HD\\r\\n  JOIN ARCS@FLEXI CS \\r\\n  ON   HD.Flx_Prs_Owner = CS.Flx_Prs_Owner\\r\\n  AND  HD.Account_Ref   = CS.Cust_Id \\r\\n WHERE HD.Flx_Prs_Owner = :FlexiProcSet\\r\\n   AND HD.COMP_CODE = :EntityRef\\r\\n   AND HD.Acc_Ledger_type = 4\\r\\n--AND HD.ALLOCATION_REF IN (:AllocationRef1);\\r\\nThere is a row for this data in the DB.\",\r\n" + 
			"      \"start_date\": \"2016-08-09\",\r\n" + 
			"      \"done_ratio\": 0,\r\n" + 
			"      \"custom_fields\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 83,\r\n" + 
			"          \"name\": \"How Found'\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 844,\r\n" + 
			"          \"name\": \"Affected code versions\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Trunk\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 87,\r\n" + 
			"          \"name\": \"Module'\",\r\n" + 
			"          \"value\": \"N/A\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 6,\r\n" + 
			"          \"name\": \"Resolution Code\",\r\n" + 
			"          \"value\": \"Fixed\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 181,\r\n" + 
			"          \"name\": \"Trunk Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 782,\r\n" + 
			"          \"name\": \"Pre-Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 684,\r\n" + 
			"          \"name\": \"Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 8,\r\n" + 
			"          \"name\": \"Steps to reproduce\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 9,\r\n" + 
			"          \"name\": \"Expected results\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 10,\r\n" + 
			"          \"name\": \"Additional Info\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 88,\r\n" + 
			"          \"name\": \"Footprint No'\",\r\n" + 
			"          \"value\": \"N/A\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 20,\r\n" + 
			"          \"name\": \"Release version No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 650,\r\n" + 
			"          \"name\": \"Internal release notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 869,\r\n" + 
			"          \"name\": \"Needed in Rel Notes/Func Guide\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 850,\r\n" + 
			"          \"name\": \"Include in Client Notes?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 89,\r\n" + 
			"          \"name\": \"Release notes Desc'\",\r\n" + 
			"          \"value\": \"N/A\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 27,\r\n" + 
			"          \"name\": \"Resolution\",\r\n" + 
			"          \"value\": \"VW 10/08/2016 Fixed in prod patch v1129.0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 47,\r\n" + 
			"          \"name\": \"Act Finish Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 97,\r\n" + 
			"          \"name\": \"Analyst Assigned To\",\r\n" + 
			"          \"value\": \"Beata Sadek\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 102,\r\n" + 
			"          \"name\": \"Priority Defect\",\r\n" + 
			"          \"value\": \"No\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 113,\r\n" + 
			"          \"name\": \"Deferred reason\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 115,\r\n" + 
			"          \"name\": \"Developer\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Szymon Zielonka\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 146,\r\n" + 
			"          \"name\": \"Back End Components\",\r\n" + 
			"          \"value\": \"AccountNavigation\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 147,\r\n" + 
			"          \"name\": \"Front End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 148,\r\n" + 
			"          \"name\": \"XSI Files\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 177,\r\n" + 
			"          \"name\": \"Scripts\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 178,\r\n" + 
			"          \"name\": \"Applications or Client Tools\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 230,\r\n" + 
			"          \"name\": \"Exclude from Regression Tests\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 247,\r\n" + 
			"          \"name\": \"Completed Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 287,\r\n" + 
			"          \"name\": \"Crucible Reviewers\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 288,\r\n" + 
			"          \"name\": \"Crucible No.\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 292,\r\n" + 
			"          \"name\": \"Trunk - pre-prod merge\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 843,\r\n" + 
			"          \"name\": \"Scope Change?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 771,\r\n" + 
			"          \"name\": \"App Functional Area\",\r\n" + 
			"          \"value\": \"Back-end processing issue\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 773,\r\n" + 
			"          \"name\": \"App Module\",\r\n" + 
			"          \"value\": \"N/A\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 774,\r\n" + 
			"          \"name\": \"WS Function\",\r\n" + 
			"          \"value\": \"GetEntitySelectedAgentRemittances\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 775,\r\n" + 
			"          \"name\": \"[Merge Review] Trunk > PreProd\",\r\n" + 
			"          \"value\": \"0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 784,\r\n" + 
			"          \"name\": \"[Merge Review] Pre-Prod > Prod\",\r\n" + 
			"          \"value\": \"0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 823,\r\n" + 
			"          \"name\": \"Production Defect?\",\r\n" + 
			"          \"value\": \"0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 854,\r\n" + 
			"          \"name\": \"Old Project\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 903,\r\n" + 
			"          \"name\": \"Needed in R6.0.6++?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 906,\r\n" + 
			"          \"name\": \"Regression Scope (Developers)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 939,\r\n" + 
			"          \"name\": \"Code Review Status\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 938,\r\n" + 
			"          \"name\": \"Code Reviewed by (BB&D)\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 935,\r\n" + 
			"          \"name\": \"Code Reviewed on Branch\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 936,\r\n" + 
			"          \"name\": \"Code Review Notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        }\r\n" + 
			"      ],\r\n" + 
			"      \"created_on\": \"2016-08-09T07:10:17Z\",\r\n" + 
			"      \"updated_on\": \"2016-08-10T07:56:05Z\"\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 248519,\r\n" + 
			"      \"project\": {\r\n" + 
			"        \"id\": 342,\r\n" + 
			"        \"name\": \"Yellow Application Development R6.0 (L)\"\r\n" + 
			"      },\r\n" + 
			"      \"tracker\": {\r\n" + 
			"        \"id\": 131,\r\n" + 
			"        \"name\": \"Defect\"\r\n" + 
			"      },\r\n" + 
			"      \"status\": {\r\n" + 
			"        \"id\": 115,\r\n" + 
			"        \"name\": \"[Trunk] Awaiting drop \"\r\n" + 
			"      },\r\n" + 
			"      \"priority\": {\r\n" + 
			"        \"id\": 6,\r\n" + 
			"        \"name\": \"Medium\"\r\n" + 
			"      },\r\n" + 
			"      \"author\": {\r\n" + 
			"        \"id\": 965,\r\n" + 
			"        \"name\": \"Karl Naylor\"\r\n" + 
			"      },\r\n" + 
			"      \"assigned_to\": {\r\n" + 
			"        \"id\": 25,\r\n" + 
			"        \"name\": \"-BBD Defects\"\r\n" + 
			"      },\r\n" + 
			"      \"subject\": \"REG - LocateContactRFQ WS ignores business rule and returns critical error.\",\r\n" + 
			"      \"description\": \"The LocateContactRFQ ignores a new business rule and returns a critical error.\\r\\n\\r\\n<Result Value=\\\"2402\\\" Desc=\\\"Unhandled, masked in results. Logged to file\\\" Code=\\\"667547575\\\" Type=\\\"CriticalError\\\" />\\r\\n\\r\\nWe would expect a CBR error here but instead we get an unhandled error.\",\r\n" + 
			"      \"start_date\": \"2016-08-05\",\r\n" + 
			"      \"done_ratio\": 0,\r\n" + 
			"      \"custom_fields\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 83,\r\n" + 
			"          \"name\": \"How Found'\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 844,\r\n" + 
			"          \"name\": \"Affected code versions\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"6.0.6 (Prod)\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 87,\r\n" + 
			"          \"name\": \"Module'\",\r\n" + 
			"          \"value\": \"RFQ\\\\Quote\\\\Policy - RFQ\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 6,\r\n" + 
			"          \"name\": \"Resolution Code\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 181,\r\n" + 
			"          \"name\": \"Trunk Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 782,\r\n" + 
			"          \"name\": \"Pre-Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 684,\r\n" + 
			"          \"name\": \"Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 8,\r\n" + 
			"          \"name\": \"Steps to reproduce\",\r\n" + 
			"          \"value\": \"1) Locate a contact with an RFQ on it.\\r\\n2) Run the attached script for the CBR's to update.\\r\\n3) Run LocatePartRisk inputting values into: ContactRef = ContactRefSeqno LocateContactRFQSearchOnValue = 1\\r\\nLocateContactRFQSearchOnValue = RFQSeqNo\\r\\nRFQStatus = 2\\r\\n4) No RFQ is found and critical error is returned. This should be a CBR error saying RFQStatus is read-only.\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 9,\r\n" + 
			"          \"name\": \"Expected results\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 10,\r\n" + 
			"          \"name\": \"Additional Info\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 88,\r\n" + 
			"          \"name\": \"Footprint No'\",\r\n" + 
			"          \"value\": \"n/a\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 20,\r\n" + 
			"          \"name\": \"Release version No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 650,\r\n" + 
			"          \"name\": \"Internal release notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 869,\r\n" + 
			"          \"name\": \"Needed in Rel Notes/Func Guide\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 850,\r\n" + 
			"          \"name\": \"Include in Client Notes?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 89,\r\n" + 
			"          \"name\": \"Release notes Desc'\",\r\n" + 
			"          \"value\": \"n/a\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 27,\r\n" + 
			"          \"name\": \"Resolution\",\r\n" + 
			"          \"value\": \"KD 08/08/2016 Fixed in Trunk v 1129\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 47,\r\n" + 
			"          \"name\": \"Act Finish Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 97,\r\n" + 
			"          \"name\": \"Analyst Assigned To\",\r\n" + 
			"          \"value\": \"Karabo Modise\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 102,\r\n" + 
			"          \"name\": \"Priority Defect\",\r\n" + 
			"          \"value\": \"No\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 113,\r\n" + 
			"          \"name\": \"Deferred reason\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 115,\r\n" + 
			"          \"name\": \"Developer\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Gustaf Strauss\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 146,\r\n" + 
			"          \"name\": \"Back End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 147,\r\n" + 
			"          \"name\": \"Front End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 148,\r\n" + 
			"          \"name\": \"XSI Files\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 177,\r\n" + 
			"          \"name\": \"Scripts\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 178,\r\n" + 
			"          \"name\": \"Applications or Client Tools\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 230,\r\n" + 
			"          \"name\": \"Exclude from Regression Tests\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 247,\r\n" + 
			"          \"name\": \"Completed Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 287,\r\n" + 
			"          \"name\": \"Crucible Reviewers\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 288,\r\n" + 
			"          \"name\": \"Crucible No.\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 292,\r\n" + 
			"          \"name\": \"Trunk - pre-prod merge\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 843,\r\n" + 
			"          \"name\": \"Scope Change?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 771,\r\n" + 
			"          \"name\": \"App Functional Area\",\r\n" + 
			"          \"value\": \"N/A\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 773,\r\n" + 
			"          \"name\": \"App Module\",\r\n" + 
			"          \"value\": \"N/A\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 774,\r\n" + 
			"          \"name\": \"WS Function\",\r\n" + 
			"          \"value\": \"LocateContactRFQ\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 775,\r\n" + 
			"          \"name\": \"[Merge Review] Trunk > PreProd\",\r\n" + 
			"          \"value\": \"0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 784,\r\n" + 
			"          \"name\": \"[Merge Review] Pre-Prod > Prod\",\r\n" + 
			"          \"value\": \"0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 823,\r\n" + 
			"          \"name\": \"Production Defect?\",\r\n" + 
			"          \"value\": \"1\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 854,\r\n" + 
			"          \"name\": \"Old Project\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 903,\r\n" + 
			"          \"name\": \"Needed in R6.0.6++?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 906,\r\n" + 
			"          \"name\": \"Regression Scope (Developers)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 939,\r\n" + 
			"          \"name\": \"Code Review Status\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 938,\r\n" + 
			"          \"name\": \"Code Reviewed by (BB&D)\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 935,\r\n" + 
			"          \"name\": \"Code Reviewed on Branch\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 936,\r\n" + 
			"          \"name\": \"Code Review Notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        }\r\n" + 
			"      ],\r\n" + 
			"      \"created_on\": \"2016-08-05T16:55:36Z\",\r\n" + 
			"      \"updated_on\": \"2016-08-08T11:53:51Z\"\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 248302,\r\n" + 
			"      \"project\": {\r\n" + 
			"        \"id\": 342,\r\n" + 
			"        \"name\": \"Yellow Application Development R6.0 (L)\"\r\n" + 
			"      },\r\n" + 
			"      \"tracker\": {\r\n" + 
			"        \"id\": 131,\r\n" + 
			"        \"name\": \"Defect\"\r\n" + 
			"      },\r\n" + 
			"      \"status\": {\r\n" + 
			"        \"id\": 115,\r\n" + 
			"        \"name\": \"[Trunk] Awaiting drop \"\r\n" + 
			"      },\r\n" + 
			"      \"priority\": {\r\n" + 
			"        \"id\": 5,\r\n" + 
			"        \"name\": \"High\"\r\n" + 
			"      },\r\n" + 
			"      \"author\": {\r\n" + 
			"        \"id\": 252,\r\n" + 
			"        \"name\": \"James Gillard\"\r\n" + 
			"      },\r\n" + 
			"      \"assigned_to\": {\r\n" + 
			"        \"id\": 25,\r\n" + 
			"        \"name\": \"-BBD Defects\"\r\n" + 
			"      },\r\n" + 
			"      \"subject\": \"SCC Unresponsive when FieldDefinitionMasterList Partitions Expire\",\r\n" + 
			"      \"description\": \"As per the attached chain, we have replicated an issue with the SCC becoming unresponsive when the following steps are followed:\\r\\n\\r\\n* Create FieldDefinitionMasterList partitions for some brokerages\\r\\n* Expire the cached FieldDefinitionMasterList partitions\\r\\n* While masterlists are being recreated, make calls from new brokerages\\r\\n\\r\\nPlease can you investigate making updates which:\\r\\n\\r\\n* Prioritise the creation of the new masterlist partitions ahead of expiring old partitions, to allow requests for the new broker to be processed\\r\\n* Allow caches to be served from the snapshot of the old masterlist during the expiry of existing partitions, so call times remain unaffected\",\r\n" + 
			"      \"start_date\": \"2016-08-04\",\r\n" + 
			"      \"done_ratio\": 0,\r\n" + 
			"      \"custom_fields\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 83,\r\n" + 
			"          \"name\": \"How Found'\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 844,\r\n" + 
			"          \"name\": \"Affected code versions\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Trunk\",\r\n" + 
			"            \"6.0.7 (Pre-Prod)\",\r\n" + 
			"            \"6.0.6 (Pre-Prod)\",\r\n" + 
			"            \"6.0.6 (Prod)\",\r\n" + 
			"            \"6.0.5\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 87,\r\n" + 
			"          \"name\": \"Module'\",\r\n" + 
			"          \"value\": \"N/A\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 6,\r\n" + 
			"          \"name\": \"Resolution Code\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 181,\r\n" + 
			"          \"name\": \"Trunk Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 782,\r\n" + 
			"          \"name\": \"Pre-Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 684,\r\n" + 
			"          \"name\": \"Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 8,\r\n" + 
			"          \"name\": \"Steps to reproduce\",\r\n" + 
			"          \"value\": \"1. Turn forward-loading off, and masterlist expiry to 1 minute\\r\\n2. Setup 20 parallel threads all running InitAddContact calls for users from different brokerages\\r\\n3. Expire all FieldDefinitionMasterList partitions\\r\\n4. Kick off 10 more threads of new, uncached brokerages staggered over the next minute\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 9,\r\n" + 
			"          \"name\": \"Expected results\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 10,\r\n" + 
			"          \"name\": \"Additional Info\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 88,\r\n" + 
			"          \"name\": \"Footprint No'\",\r\n" + 
			"          \"value\": \"N/A\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 20,\r\n" + 
			"          \"name\": \"Release version No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 650,\r\n" + 
			"          \"name\": \"Internal release notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 869,\r\n" + 
			"          \"name\": \"Needed in Rel Notes/Func Guide\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 850,\r\n" + 
			"          \"name\": \"Include in Client Notes?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 89,\r\n" + 
			"          \"name\": \"Release notes Desc'\",\r\n" + 
			"          \"value\": \"Resolved an issue affecting stability of the system when configuration changes were made during periods of high load.\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 27,\r\n" + 
			"          \"name\": \"Resolution\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 47,\r\n" + 
			"          \"name\": \"Act Finish Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 97,\r\n" + 
			"          \"name\": \"Analyst Assigned To\",\r\n" + 
			"          \"value\": \"Tshimangadzo Davhana\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 102,\r\n" + 
			"          \"name\": \"Priority Defect\",\r\n" + 
			"          \"value\": \"No\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 113,\r\n" + 
			"          \"name\": \"Deferred reason\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 115,\r\n" + 
			"          \"name\": \"Developer\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Jason Pon\",\r\n" + 
			"            \"Phillip Whittaker\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 146,\r\n" + 
			"          \"name\": \"Back End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 147,\r\n" + 
			"          \"name\": \"Front End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 148,\r\n" + 
			"          \"name\": \"XSI Files\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 177,\r\n" + 
			"          \"name\": \"Scripts\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 178,\r\n" + 
			"          \"name\": \"Applications or Client Tools\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 230,\r\n" + 
			"          \"name\": \"Exclude from Regression Tests\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 247,\r\n" + 
			"          \"name\": \"Completed Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 287,\r\n" + 
			"          \"name\": \"Crucible Reviewers\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 288,\r\n" + 
			"          \"name\": \"Crucible No.\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 292,\r\n" + 
			"          \"name\": \"Trunk - pre-prod merge\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 843,\r\n" + 
			"          \"name\": \"Scope Change?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 771,\r\n" + 
			"          \"name\": \"App Functional Area\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 773,\r\n" + 
			"          \"name\": \"App Module\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 774,\r\n" + 
			"          \"name\": \"WS Function\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 775,\r\n" + 
			"          \"name\": \"[Merge Review] Trunk > PreProd\",\r\n" + 
			"          \"value\": \"0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 784,\r\n" + 
			"          \"name\": \"[Merge Review] Pre-Prod > Prod\",\r\n" + 
			"          \"value\": \"0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 823,\r\n" + 
			"          \"name\": \"Production Defect?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 854,\r\n" + 
			"          \"name\": \"Old Project\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 903,\r\n" + 
			"          \"name\": \"Needed in R6.0.6++?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 906,\r\n" + 
			"          \"name\": \"Regression Scope (Developers)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 939,\r\n" + 
			"          \"name\": \"Code Review Status\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 938,\r\n" + 
			"          \"name\": \"Code Reviewed by (BB&D)\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 935,\r\n" + 
			"          \"name\": \"Code Reviewed on Branch\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 936,\r\n" + 
			"          \"name\": \"Code Review Notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        }\r\n" + 
			"      ],\r\n" + 
			"      \"created_on\": \"2016-08-04T13:58:46Z\",\r\n" + 
			"      \"updated_on\": \"2016-08-08T07:55:32Z\"\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 248184,\r\n" + 
			"      \"project\": {\r\n" + 
			"        \"id\": 342,\r\n" + 
			"        \"name\": \"Yellow Application Development R6.0 (L)\"\r\n" + 
			"      },\r\n" + 
			"      \"tracker\": {\r\n" + 
			"        \"id\": 131,\r\n" + 
			"        \"name\": \"Defect\"\r\n" + 
			"      },\r\n" + 
			"      \"status\": {\r\n" + 
			"        \"id\": 115,\r\n" + 
			"        \"name\": \"[Trunk] Awaiting drop \"\r\n" + 
			"      },\r\n" + 
			"      \"priority\": {\r\n" + 
			"        \"id\": 5,\r\n" + 
			"        \"name\": \"High\"\r\n" + 
			"      },\r\n" + 
			"      \"author\": {\r\n" + 
			"        \"id\": 815,\r\n" + 
			"        \"name\": \"Emily Waters\"\r\n" + 
			"      },\r\n" + 
			"      \"assigned_to\": {\r\n" + 
			"        \"id\": 25,\r\n" + 
			"        \"name\": \"-BBD Defects\"\r\n" + 
			"      },\r\n" + 
			"      \"subject\": \"UpdatePolicyAccountExecutive WS clears the values of QuoteObtainedDate and QuoteExpiryDate\",\r\n" + 
			"      \"description\": \"Was this defect introduced with #233036 ?\",\r\n" + 
			"      \"start_date\": \"2016-08-03\",\r\n" + 
			"      \"done_ratio\": 0,\r\n" + 
			"      \"custom_fields\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 83,\r\n" + 
			"          \"name\": \"How Found'\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 844,\r\n" + 
			"          \"name\": \"Affected code versions\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Trunk\",\r\n" + 
			"            \"6.0.7 (Pre-Prod)\",\r\n" + 
			"            \"6.0.6 (Pre-Prod)\",\r\n" + 
			"            \"6.0.6 (Prod)\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 87,\r\n" + 
			"          \"name\": \"Module'\",\r\n" + 
			"          \"value\": \"RFQ\\\\Quote\\\\Policy - Policy\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 6,\r\n" + 
			"          \"name\": \"Resolution Code\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 181,\r\n" + 
			"          \"name\": \"Trunk Resolution drop No\",\r\n" + 
			"          \"value\": \"1128.0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 782,\r\n" + 
			"          \"name\": \"Pre-Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 684,\r\n" + 
			"          \"name\": \"Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 8,\r\n" + 
			"          \"name\": \"Steps to reproduce\",\r\n" + 
			"          \"value\": \"1) Obtain a Risk Capture Test Product Policy\\r\\n2) Process an MTA (make sure values of Quote Obtained Date and Quote Expiry Date are not null)\\r\\n3) Run UpdatePolicyAccountExecutive WS on the MTA, and change the office & Account exec\\r\\n4) Refresh the MTA\\r\\n::Quote Obtained Date and Quote Expiry Date are null --DEFECT\\r\\n5) Repeat for Renewal, Cancellation, Declaration, Reinstatement, Temp MTA, Temp MTA Canc\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 9,\r\n" + 
			"          \"name\": \"Expected results\",\r\n" + 
			"          \"value\": \"Updating the account exec should not clear the quote obtained/expiry dates.\\r\\n\\r\\nWhy does this happen? Where was this introduced?\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 10,\r\n" + 
			"          \"name\": \"Additional Info\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 88,\r\n" + 
			"          \"name\": \"Footprint No'\",\r\n" + 
			"          \"value\": \"n/a\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 20,\r\n" + 
			"          \"name\": \"Release version No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 650,\r\n" + 
			"          \"name\": \"Internal release notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 869,\r\n" + 
			"          \"name\": \"Needed in Rel Notes/Func Guide\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 850,\r\n" + 
			"          \"name\": \"Include in Client Notes?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 89,\r\n" + 
			"          \"name\": \"Release notes Desc'\",\r\n" + 
			"          \"value\": \"n/a\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 27,\r\n" + 
			"          \"name\": \"Resolution\",\r\n" + 
			"          \"value\": \"KD 05/08/2016 Fixed in Trunk v1128.0\\r\\nKD 08/08/2016 Fixed in Trunk v1128.0\\r\\n\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 47,\r\n" + 
			"          \"name\": \"Act Finish Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 97,\r\n" + 
			"          \"name\": \"Analyst Assigned To\",\r\n" + 
			"          \"value\": \"Karabo Modise\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 102,\r\n" + 
			"          \"name\": \"Priority Defect\",\r\n" + 
			"          \"value\": \"Yes\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 113,\r\n" + 
			"          \"name\": \"Deferred reason\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 115,\r\n" + 
			"          \"name\": \"Developer\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Gustaf Strauss\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 146,\r\n" + 
			"          \"name\": \"Back End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 147,\r\n" + 
			"          \"name\": \"Front End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 148,\r\n" + 
			"          \"name\": \"XSI Files\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 177,\r\n" + 
			"          \"name\": \"Scripts\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 178,\r\n" + 
			"          \"name\": \"Applications or Client Tools\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 230,\r\n" + 
			"          \"name\": \"Exclude from Regression Tests\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 247,\r\n" + 
			"          \"name\": \"Completed Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 287,\r\n" + 
			"          \"name\": \"Crucible Reviewers\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 288,\r\n" + 
			"          \"name\": \"Crucible No.\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 292,\r\n" + 
			"          \"name\": \"Trunk - pre-prod merge\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 843,\r\n" + 
			"          \"name\": \"Scope Change?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 771,\r\n" + 
			"          \"name\": \"App Functional Area\",\r\n" + 
			"          \"value\": \"Back-end processing issue\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 773,\r\n" + 
			"          \"name\": \"App Module\",\r\n" + 
			"          \"value\": \"N/A\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 774,\r\n" + 
			"          \"name\": \"WS Function\",\r\n" + 
			"          \"value\": \"UpdatePolicyAccountExecutive\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 775,\r\n" + 
			"          \"name\": \"[Merge Review] Trunk > PreProd\",\r\n" + 
			"          \"value\": \"0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 784,\r\n" + 
			"          \"name\": \"[Merge Review] Pre-Prod > Prod\",\r\n" + 
			"          \"value\": \"1\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 823,\r\n" + 
			"          \"name\": \"Production Defect?\",\r\n" + 
			"          \"value\": \"1\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 854,\r\n" + 
			"          \"name\": \"Old Project\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 903,\r\n" + 
			"          \"name\": \"Needed in R6.0.6++?\",\r\n" + 
			"          \"value\": \"1\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 906,\r\n" + 
			"          \"name\": \"Regression Scope (Developers)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 939,\r\n" + 
			"          \"name\": \"Code Review Status\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 938,\r\n" + 
			"          \"name\": \"Code Reviewed by (BB&D)\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 935,\r\n" + 
			"          \"name\": \"Code Reviewed on Branch\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 936,\r\n" + 
			"          \"name\": \"Code Review Notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        }\r\n" + 
			"      ],\r\n" + 
			"      \"created_on\": \"2016-08-03T14:04:55Z\",\r\n" + 
			"      \"updated_on\": \"2016-08-09T13:41:00Z\"\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 246294,\r\n" + 
			"      \"project\": {\r\n" + 
			"        \"id\": 342,\r\n" + 
			"        \"name\": \"Yellow Application Development R6.0 (L)\"\r\n" + 
			"      },\r\n" + 
			"      \"tracker\": {\r\n" + 
			"        \"id\": 131,\r\n" + 
			"        \"name\": \"Defect\"\r\n" + 
			"      },\r\n" + 
			"      \"status\": {\r\n" + 
			"        \"id\": 115,\r\n" + 
			"        \"name\": \"[Trunk] Awaiting drop \"\r\n" + 
			"      },\r\n" + 
			"      \"priority\": {\r\n" + 
			"        \"id\": 3,\r\n" + 
			"        \"name\": \"Low\"\r\n" + 
			"      },\r\n" + 
			"      \"author\": {\r\n" + 
			"        \"id\": 255,\r\n" + 
			"        \"name\": \"Richard Saunders\"\r\n" + 
			"      },\r\n" + 
			"      \"assigned_to\": {\r\n" + 
			"        \"id\": 25,\r\n" + 
			"        \"name\": \"-BBD Defects\"\r\n" + 
			"      },\r\n" + 
			"      \"parent\": {\r\n" + 
			"        \"id\": 234101\r\n" + 
			"      },\r\n" + 
			"      \"subject\": \"CR964 A1 - Error not returned when unable to reach Target Due to Fee Amounts\",\r\n" + 
			"      \"description\": \"RS Edit: It appears this is an issue with switching Default Fees. I can replicate a similar issue when the Commission Discount default changes when applying a Commission Override. I do not get the same issue when applying Premium Overrides.\\r\\n\\r\\n-------------------------------------\\r\\n\\r\\nIf we set up a case where the default fees applied mean the Target cannot be reached, and try to use the Commission Override calculation, then I am not getting the ERC_CANNOT_CALC_OVERRIDE error code reading 'It was not possible to apply the override specified due to the rules set up. Please select a different Authorisation code, or continue manually.' \\r\\n\\r\\nI am not sure whether this is an issue with the way the Default Fees are re-calculated, or is an issue with the error code not being returned when expected. When applying the update, half the time I get no errors, half the time I get ERC_RATINGDETCALC_COMM_OVERRIDE_LIMIT_REACHED 'The Target Amount is outside the limit of allowed commission overrides. The commission rate has been set to the closest allowed value.' This appears to depend on the initial value of the Default Fees.\\r\\n\\r\\nPlease see steps to replicate.\",\r\n" + 
			"      \"start_date\": \"2016-07-19\",\r\n" + 
			"      \"done_ratio\": 0,\r\n" + 
			"      \"custom_fields\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 83,\r\n" + 
			"          \"name\": \"How Found'\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 844,\r\n" + 
			"          \"name\": \"Affected code versions\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Trunk\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 87,\r\n" + 
			"          \"name\": \"Module'\",\r\n" + 
			"          \"value\": \"RFQ\\\\Quote\\\\Policy - Target Calculator\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 6,\r\n" + 
			"          \"name\": \"Resolution Code\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 181,\r\n" + 
			"          \"name\": \"Trunk Resolution drop No\",\r\n" + 
			"          \"value\": \"1127.0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 782,\r\n" + 
			"          \"name\": \"Pre-Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 684,\r\n" + 
			"          \"name\": \"Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 8,\r\n" + 
			"          \"name\": \"Steps to reproduce\",\r\n" + 
			"          \"value\": \"1. Add a Ship Hull manual Quote\\r\\n2. Run Delete 1 and Insert 1\\r\\n::Default Fees set up so that a premium of between 200 and 300 is not possible\\r\\n3. Apply a Premium of 80, Commission Rate = 90%, IPT = VAT = 0 on the Quote\\r\\n::Premium applied\\r\\n4. Check the Premium Summary screen\\r\\n::Commission Fee = 100, Admin Fee = 0, Disc Total Amount = 180 -CORRECT (If the Admin Fee <> 0, please set it to 0)\\r\\n5. Run CalculateTargetCalculatorAmounts with CalculationType = 2, TargetAmount = 202\\r\\n::Call is successful with PolicyAmountDue = 302, but no ERC_CANNOT_CALC_OVERRIDE error -DEFECT: The Target cannot be reached, but there is no error information code returned\\r\\n(FIXED)\\r\\n6. Run ApplyTargetCalculatorAmounts with CalculationType = 2, TargetAmount = 202\\r\\n::Call is successful with PolicyAmountDue = 302, but no ERC_CANNOT_CALC_OVERRIDE error -DEFECT: Same issue\\r\\n7. Load the Premium Summary screen\\r\\n::Discounted Premium = 102, Commission Fee = 200, Disc Total Amount = 302 \\r\\n8. Run CalculateTargetCalculatorAmounts then ApplyTargetCalculatorAmounts \\r\\n::Calls return ERC_RATINGDETCALC_COMM_OVERRIDE_LIMIT_REACHED -DEFECT: These should still be returning ERC_CANNOT_CALC_OVERRIDE as the limit cannot be reached, and it is not an issue with the Commission Rates being applied\\r\\n(FIXED)\\r\\n9. Run the Calculate / Apply calls with TargetAmount = 190\\r\\n::Call is successful, and DiscTotalAmount = 190 -CORRECT\\r\\n::Error described above is returned -DEFECT: The error is now being returned for low values which can be reached. Please can you investigate why?\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 9,\r\n" + 
			"          \"name\": \"Expected results\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 10,\r\n" + 
			"          \"name\": \"Additional Info\",\r\n" + 
			"          \"value\": \"--Delete 1--\\r\\nDelete From DefaultFee\\r\\nWhere (BrokSeqNo, ProductTargetSeqNo) = (Select Q.BrokSeqNo, PM.ProductTargetSeqNo\\r\\n  FROM Quote Q, PolMain PM\\r\\n  WHERE Q.QuoteSeqNo = :QUOTESEQNO\\r\\n    AND Q.PolMainSeqNo = PM.PolMainSeqNo);\\r\\nCOMMIT;\\r\\n\\r\\n--Insert 1--\\r\\nInsert Into DefaultFee\\r\\n(SELECT DEFAULTFEESEQ.NEXTVAL\\r\\n, Q.BROKSEQNO\\r\\n, NULL\\r\\n, PM.ProductTargetSeqNo --Target Calculator Test\\r\\n, NULL\\r\\n, NULL\\r\\n, 1\\r\\n, NULL\\r\\n, 100\\r\\n, NULL\\r\\n, NULL\\r\\n, 5\\r\\n, NULL\\r\\n, NULL\\r\\n, 1\\r\\n, 5\\r\\n, 5\\r\\n, 5\\r\\n, 5\\r\\n, 100\\r\\n, NULL\\r\\n, NULL\\r\\n, NULL\\r\\n, 5\\r\\n, 1\\r\\n, 'CR964TP'\\r\\n, SYSDATE\\r\\nFROM Quote Q, PolMain PM\\r\\nWHERE Q.QuoteSeqNo = :QUOTESEQNO\\r\\n  AND Q.PolMainSeqNo = PM.PolMainSeqNo);\\r\\nInsert Into DefaultFee\\r\\n(SELECT DEFAULTFEESEQ.NEXTVAL\\r\\n, Q.BROKSEQNO\\r\\n, NULL\\r\\n, PM.ProductTargetSeqNo --Target Calculator Test\\r\\n, NULL\\r\\n, NULL\\r\\n, 1\\r\\n, 100\\r\\n, NULL\\r\\n, NULL\\r\\n, NULL\\r\\n, 5\\r\\n, NULL\\r\\n, NULL\\r\\n, 1\\r\\n, 5\\r\\n, 5\\r\\n, 5\\r\\n, 5\\r\\n, 200\\r\\n, NULL\\r\\n, NULL\\r\\n, NULL\\r\\n, 5\\r\\n, 1\\r\\n, 'CR964TP'\\r\\n, SYSDATE\\r\\nFROM Quote Q, PolMain PM\\r\\nWHERE Q.QuoteSeqNo = :QUOTESEQNO\\r\\n  AND Q.PolMainSeqNo = PM.PolMainSeqNo);\\r\\nCOMMIT;\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 88,\r\n" + 
			"          \"name\": \"Footprint No'\",\r\n" + 
			"          \"value\": \"N/A\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 20,\r\n" + 
			"          \"name\": \"Release version No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 650,\r\n" + 
			"          \"name\": \"Internal release notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 869,\r\n" + 
			"          \"name\": \"Needed in Rel Notes/Func Guide\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 850,\r\n" + 
			"          \"name\": \"Include in Client Notes?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 89,\r\n" + 
			"          \"name\": \"Release notes Desc'\",\r\n" + 
			"          \"value\": \"N/A\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 27,\r\n" + 
			"          \"name\": \"Resolution\",\r\n" + 
			"          \"value\": \"VW 02/08/2016 Fixed in prod patch v1127.0\\r\\nVW 10/08/2016 Fixed in prod patch v1129.0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 47,\r\n" + 
			"          \"name\": \"Act Finish Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 97,\r\n" + 
			"          \"name\": \"Analyst Assigned To\",\r\n" + 
			"          \"value\": \"Vandra Wiehahn\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 102,\r\n" + 
			"          \"name\": \"Priority Defect\",\r\n" + 
			"          \"value\": \"No\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 113,\r\n" + 
			"          \"name\": \"Deferred reason\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 115,\r\n" + 
			"          \"name\": \"Developer\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Wesleigh Pieters\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 146,\r\n" + 
			"          \"name\": \"Back End Components\",\r\n" + 
			"          \"value\": \"RatingDetailsCalc.dll\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 147,\r\n" + 
			"          \"name\": \"Front End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 148,\r\n" + 
			"          \"name\": \"XSI Files\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 177,\r\n" + 
			"          \"name\": \"Scripts\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 178,\r\n" + 
			"          \"name\": \"Applications or Client Tools\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 230,\r\n" + 
			"          \"name\": \"Exclude from Regression Tests\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 247,\r\n" + 
			"          \"name\": \"Completed Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 287,\r\n" + 
			"          \"name\": \"Crucible Reviewers\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 288,\r\n" + 
			"          \"name\": \"Crucible No.\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 292,\r\n" + 
			"          \"name\": \"Trunk - pre-prod merge\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 843,\r\n" + 
			"          \"name\": \"Scope Change?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 771,\r\n" + 
			"          \"name\": \"App Functional Area\",\r\n" + 
			"          \"value\": \"Back-end processing issue\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 773,\r\n" + 
			"          \"name\": \"App Module\",\r\n" + 
			"          \"value\": \"RFQ\\\\Quote\\\\Policy - Target Calculator\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 774,\r\n" + 
			"          \"name\": \"WS Function\",\r\n" + 
			"          \"value\": \"CalculateTargetCalculatorAmounts\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 775,\r\n" + 
			"          \"name\": \"[Merge Review] Trunk > PreProd\",\r\n" + 
			"          \"value\": \"0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 784,\r\n" + 
			"          \"name\": \"[Merge Review] Pre-Prod > Prod\",\r\n" + 
			"          \"value\": \"0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 823,\r\n" + 
			"          \"name\": \"Production Defect?\",\r\n" + 
			"          \"value\": \"0\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 854,\r\n" + 
			"          \"name\": \"Old Project\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 903,\r\n" + 
			"          \"name\": \"Needed in R6.0.6++?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 906,\r\n" + 
			"          \"name\": \"Regression Scope (Developers)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 939,\r\n" + 
			"          \"name\": \"Code Review Status\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 938,\r\n" + 
			"          \"name\": \"Code Reviewed by (BB&D)\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 935,\r\n" + 
			"          \"name\": \"Code Reviewed on Branch\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 936,\r\n" + 
			"          \"name\": \"Code Review Notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        }\r\n" + 
			"      ],\r\n" + 
			"      \"created_on\": \"2016-07-19T10:29:10Z\",\r\n" + 
			"      \"updated_on\": \"2016-08-10T07:54:35Z\"\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 248536,\r\n" + 
			"      \"project\": {\r\n" + 
			"        \"id\": 342,\r\n" + 
			"        \"name\": \"Yellow Application Development R6.0 (L)\"\r\n" + 
			"      },\r\n" + 
			"      \"tracker\": {\r\n" + 
			"        \"id\": 132,\r\n" + 
			"        \"name\": \"CR Section\"\r\n" + 
			"      },\r\n" + 
			"      \"status\": {\r\n" + 
			"        \"id\": 115,\r\n" + 
			"        \"name\": \"[Trunk] Awaiting drop \"\r\n" + 
			"      },\r\n" + 
			"      \"priority\": {\r\n" + 
			"        \"id\": 10,\r\n" + 
			"        \"name\": \"Not-set\"\r\n" + 
			"      },\r\n" + 
			"      \"author\": {\r\n" + 
			"        \"id\": 242,\r\n" + 
			"        \"name\": \"Floris Coetzee\"\r\n" + 
			"      },\r\n" + 
			"      \"assigned_to\": {\r\n" + 
			"        \"id\": 25,\r\n" + 
			"        \"name\": \"-BBD Defects\"\r\n" + 
			"      },\r\n" + 
			"      \"parent\": {\r\n" + 
			"        \"id\": 219740\r\n" + 
			"      },\r\n" + 
			"      \"subject\": \"CR865 A1 - RtReporting Component\",\r\n" + 
			"      \"description\": \"\",\r\n" + 
			"      \"start_date\": \"2016-08-06\",\r\n" + 
			"      \"done_ratio\": 100,\r\n" + 
			"      \"custom_fields\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 6,\r\n" + 
			"          \"name\": \"Resolution Code\",\r\n" + 
			"          \"value\": \"Sent For Testing\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 181,\r\n" + 
			"          \"name\": \"Trunk Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 782,\r\n" + 
			"          \"name\": \"Pre-Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 684,\r\n" + 
			"          \"name\": \"Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 8,\r\n" + 
			"          \"name\": \"Steps to reproduce\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 9,\r\n" + 
			"          \"name\": \"Expected results\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 10,\r\n" + 
			"          \"name\": \"Additional Info\",\r\n" + 
			"          \"value\": \"---\\r\\nBE methods updated\\r\\n---\\r\\nRetrieveBusinessProcessed\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 20,\r\n" + 
			"          \"name\": \"Release version No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 47,\r\n" + 
			"          \"name\": \"Act Finish Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 97,\r\n" + 
			"          \"name\": \"Analyst Assigned To\",\r\n" + 
			"          \"value\": \"Vandra Wiehahn\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 102,\r\n" + 
			"          \"name\": \"Priority Defect\",\r\n" + 
			"          \"value\": \"No\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 115,\r\n" + 
			"          \"name\": \"Developer\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Floris Coetzee\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 146,\r\n" + 
			"          \"name\": \"Back End Components\",\r\n" + 
			"          \"value\": \"RtReporting.dll\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 147,\r\n" + 
			"          \"name\": \"Front End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 148,\r\n" + 
			"          \"name\": \"XSI Files\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 177,\r\n" + 
			"          \"name\": \"Scripts\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 178,\r\n" + 
			"          \"name\": \"Applications or Client Tools\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 247,\r\n" + 
			"          \"name\": \"Completed Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 287,\r\n" + 
			"          \"name\": \"Crucible Reviewers\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 288,\r\n" + 
			"          \"name\": \"Crucible No.\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 827,\r\n" + 
			"          \"name\": \"QA Testing Assignee\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 854,\r\n" + 
			"          \"name\": \"Old Project\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 855,\r\n" + 
			"          \"name\": \"FE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 856,\r\n" + 
			"          \"name\": \"BE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 857,\r\n" + 
			"          \"name\": \"SCC Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 858,\r\n" + 
			"          \"name\": \"FE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 859,\r\n" + 
			"          \"name\": \"BE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 860,\r\n" + 
			"          \"name\": \"SCC Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 903,\r\n" + 
			"          \"name\": \"Needed in R6.0.6++?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 906,\r\n" + 
			"          \"name\": \"Regression Scope (Developers)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 939,\r\n" + 
			"          \"name\": \"Code Review Status\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 938,\r\n" + 
			"          \"name\": \"Code Reviewed by (BB&D)\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 935,\r\n" + 
			"          \"name\": \"Code Reviewed on Branch\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 936,\r\n" + 
			"          \"name\": \"Code Review Notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        }\r\n" + 
			"      ],\r\n" + 
			"      \"created_on\": \"2016-08-06T18:32:08Z\",\r\n" + 
			"      \"updated_on\": \"2016-08-10T07:43:07Z\"\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 248535,\r\n" + 
			"      \"project\": {\r\n" + 
			"        \"id\": 342,\r\n" + 
			"        \"name\": \"Yellow Application Development R6.0 (L)\"\r\n" + 
			"      },\r\n" + 
			"      \"tracker\": {\r\n" + 
			"        \"id\": 132,\r\n" + 
			"        \"name\": \"CR Section\"\r\n" + 
			"      },\r\n" + 
			"      \"status\": {\r\n" + 
			"        \"id\": 115,\r\n" + 
			"        \"name\": \"[Trunk] Awaiting drop \"\r\n" + 
			"      },\r\n" + 
			"      \"priority\": {\r\n" + 
			"        \"id\": 10,\r\n" + 
			"        \"name\": \"Not-set\"\r\n" + 
			"      },\r\n" + 
			"      \"author\": {\r\n" + 
			"        \"id\": 242,\r\n" + 
			"        \"name\": \"Floris Coetzee\"\r\n" + 
			"      },\r\n" + 
			"      \"assigned_to\": {\r\n" + 
			"        \"id\": 25,\r\n" + 
			"        \"name\": \"-BBD Defects\"\r\n" + 
			"      },\r\n" + 
			"      \"parent\": {\r\n" + 
			"        \"id\": 219740\r\n" + 
			"      },\r\n" + 
			"      \"subject\": \"CR865 A1 - ContactAcc Component\",\r\n" + 
			"      \"description\": \"\",\r\n" + 
			"      \"start_date\": \"2016-08-06\",\r\n" + 
			"      \"done_ratio\": 100,\r\n" + 
			"      \"custom_fields\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 6,\r\n" + 
			"          \"name\": \"Resolution Code\",\r\n" + 
			"          \"value\": \"Sent For Testing\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 181,\r\n" + 
			"          \"name\": \"Trunk Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 782,\r\n" + 
			"          \"name\": \"Pre-Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 684,\r\n" + 
			"          \"name\": \"Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 8,\r\n" + 
			"          \"name\": \"Steps to reproduce\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 9,\r\n" + 
			"          \"name\": \"Expected results\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 10,\r\n" + 
			"          \"name\": \"Additional Info\",\r\n" + 
			"          \"value\": \"---\\r\\nBE Methods Updated\\r\\n---\\r\\nGetAccountSummary\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 20,\r\n" + 
			"          \"name\": \"Release version No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 47,\r\n" + 
			"          \"name\": \"Act Finish Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 97,\r\n" + 
			"          \"name\": \"Analyst Assigned To\",\r\n" + 
			"          \"value\": \"Vandra Wiehahn\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 102,\r\n" + 
			"          \"name\": \"Priority Defect\",\r\n" + 
			"          \"value\": \"No\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 115,\r\n" + 
			"          \"name\": \"Developer\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Floris Coetzee\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 146,\r\n" + 
			"          \"name\": \"Back End Components\",\r\n" + 
			"          \"value\": \"ContactAcc.dll\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 147,\r\n" + 
			"          \"name\": \"Front End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 148,\r\n" + 
			"          \"name\": \"XSI Files\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 177,\r\n" + 
			"          \"name\": \"Scripts\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 178,\r\n" + 
			"          \"name\": \"Applications or Client Tools\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 247,\r\n" + 
			"          \"name\": \"Completed Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 287,\r\n" + 
			"          \"name\": \"Crucible Reviewers\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 288,\r\n" + 
			"          \"name\": \"Crucible No.\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 827,\r\n" + 
			"          \"name\": \"QA Testing Assignee\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 854,\r\n" + 
			"          \"name\": \"Old Project\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 855,\r\n" + 
			"          \"name\": \"FE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 856,\r\n" + 
			"          \"name\": \"BE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 857,\r\n" + 
			"          \"name\": \"SCC Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 858,\r\n" + 
			"          \"name\": \"FE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 859,\r\n" + 
			"          \"name\": \"BE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 860,\r\n" + 
			"          \"name\": \"SCC Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 903,\r\n" + 
			"          \"name\": \"Needed in R6.0.6++?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 906,\r\n" + 
			"          \"name\": \"Regression Scope (Developers)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 939,\r\n" + 
			"          \"name\": \"Code Review Status\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 938,\r\n" + 
			"          \"name\": \"Code Reviewed by (BB&D)\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 935,\r\n" + 
			"          \"name\": \"Code Reviewed on Branch\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 936,\r\n" + 
			"          \"name\": \"Code Review Notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        }\r\n" + 
			"      ],\r\n" + 
			"      \"created_on\": \"2016-08-06T18:20:13Z\",\r\n" + 
			"      \"updated_on\": \"2016-08-10T07:43:04Z\"\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 248534,\r\n" + 
			"      \"project\": {\r\n" + 
			"        \"id\": 342,\r\n" + 
			"        \"name\": \"Yellow Application Development R6.0 (L)\"\r\n" + 
			"      },\r\n" + 
			"      \"tracker\": {\r\n" + 
			"        \"id\": 132,\r\n" + 
			"        \"name\": \"CR Section\"\r\n" + 
			"      },\r\n" + 
			"      \"status\": {\r\n" + 
			"        \"id\": 115,\r\n" + 
			"        \"name\": \"[Trunk] Awaiting drop \"\r\n" + 
			"      },\r\n" + 
			"      \"priority\": {\r\n" + 
			"        \"id\": 10,\r\n" + 
			"        \"name\": \"Not-set\"\r\n" + 
			"      },\r\n" + 
			"      \"author\": {\r\n" + 
			"        \"id\": 242,\r\n" + 
			"        \"name\": \"Floris Coetzee\"\r\n" + 
			"      },\r\n" + 
			"      \"assigned_to\": {\r\n" + 
			"        \"id\": 25,\r\n" + 
			"        \"name\": \"-BBD Defects\"\r\n" + 
			"      },\r\n" + 
			"      \"parent\": {\r\n" + 
			"        \"id\": 219740\r\n" + 
			"      },\r\n" + 
			"      \"subject\": \"CR865 A1 - BatchProcessor Component\",\r\n" + 
			"      \"description\": \"\",\r\n" + 
			"      \"start_date\": \"2016-08-06\",\r\n" + 
			"      \"done_ratio\": 100,\r\n" + 
			"      \"custom_fields\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 6,\r\n" + 
			"          \"name\": \"Resolution Code\",\r\n" + 
			"          \"value\": \"Sent For Testing\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 181,\r\n" + 
			"          \"name\": \"Trunk Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 782,\r\n" + 
			"          \"name\": \"Pre-Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 684,\r\n" + 
			"          \"name\": \"Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 8,\r\n" + 
			"          \"name\": \"Steps to reproduce\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 9,\r\n" + 
			"          \"name\": \"Expected results\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 10,\r\n" + 
			"          \"name\": \"Additional Info\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 20,\r\n" + 
			"          \"name\": \"Release version No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 47,\r\n" + 
			"          \"name\": \"Act Finish Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 97,\r\n" + 
			"          \"name\": \"Analyst Assigned To\",\r\n" + 
			"          \"value\": \"Vandra Wiehahn\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 102,\r\n" + 
			"          \"name\": \"Priority Defect\",\r\n" + 
			"          \"value\": \"No\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 115,\r\n" + 
			"          \"name\": \"Developer\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Floris Coetzee\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 146,\r\n" + 
			"          \"name\": \"Back End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 147,\r\n" + 
			"          \"name\": \"Front End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 148,\r\n" + 
			"          \"name\": \"XSI Files\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 177,\r\n" + 
			"          \"name\": \"Scripts\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 178,\r\n" + 
			"          \"name\": \"Applications or Client Tools\",\r\n" + 
			"          \"value\": \"BatchProcessor.exe\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 247,\r\n" + 
			"          \"name\": \"Completed Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 287,\r\n" + 
			"          \"name\": \"Crucible Reviewers\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 288,\r\n" + 
			"          \"name\": \"Crucible No.\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 827,\r\n" + 
			"          \"name\": \"QA Testing Assignee\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 854,\r\n" + 
			"          \"name\": \"Old Project\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 855,\r\n" + 
			"          \"name\": \"FE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 856,\r\n" + 
			"          \"name\": \"BE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 857,\r\n" + 
			"          \"name\": \"SCC Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 858,\r\n" + 
			"          \"name\": \"FE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 859,\r\n" + 
			"          \"name\": \"BE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 860,\r\n" + 
			"          \"name\": \"SCC Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 903,\r\n" + 
			"          \"name\": \"Needed in R6.0.6++?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 906,\r\n" + 
			"          \"name\": \"Regression Scope (Developers)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 939,\r\n" + 
			"          \"name\": \"Code Review Status\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 938,\r\n" + 
			"          \"name\": \"Code Reviewed by (BB&D)\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 935,\r\n" + 
			"          \"name\": \"Code Reviewed on Branch\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 936,\r\n" + 
			"          \"name\": \"Code Review Notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        }\r\n" + 
			"      ],\r\n" + 
			"      \"created_on\": \"2016-08-06T17:12:23Z\",\r\n" + 
			"      \"updated_on\": \"2016-08-10T07:43:00Z\"\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 248533,\r\n" + 
			"      \"project\": {\r\n" + 
			"        \"id\": 342,\r\n" + 
			"        \"name\": \"Yellow Application Development R6.0 (L)\"\r\n" + 
			"      },\r\n" + 
			"      \"tracker\": {\r\n" + 
			"        \"id\": 132,\r\n" + 
			"        \"name\": \"CR Section\"\r\n" + 
			"      },\r\n" + 
			"      \"status\": {\r\n" + 
			"        \"id\": 115,\r\n" + 
			"        \"name\": \"[Trunk] Awaiting drop \"\r\n" + 
			"      },\r\n" + 
			"      \"priority\": {\r\n" + 
			"        \"id\": 10,\r\n" + 
			"        \"name\": \"Not-set\"\r\n" + 
			"      },\r\n" + 
			"      \"author\": {\r\n" + 
			"        \"id\": 242,\r\n" + 
			"        \"name\": \"Floris Coetzee\"\r\n" + 
			"      },\r\n" + 
			"      \"assigned_to\": {\r\n" + 
			"        \"id\": 25,\r\n" + 
			"        \"name\": \"-BBD Defects\"\r\n" + 
			"      },\r\n" + 
			"      \"parent\": {\r\n" + 
			"        \"id\": 219735\r\n" + 
			"      },\r\n" + 
			"      \"subject\": \"CR865 A1 - FlexiContact Component\",\r\n" + 
			"      \"description\": \"\",\r\n" + 
			"      \"start_date\": \"2016-08-06\",\r\n" + 
			"      \"done_ratio\": 100,\r\n" + 
			"      \"custom_fields\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 6,\r\n" + 
			"          \"name\": \"Resolution Code\",\r\n" + 
			"          \"value\": \"Sent For Testing\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 181,\r\n" + 
			"          \"name\": \"Trunk Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 782,\r\n" + 
			"          \"name\": \"Pre-Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 684,\r\n" + 
			"          \"name\": \"Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 8,\r\n" + 
			"          \"name\": \"Steps to reproduce\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 9,\r\n" + 
			"          \"name\": \"Expected results\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 10,\r\n" + 
			"          \"name\": \"Additional Info\",\r\n" + 
			"          \"value\": \"Removed Query source lookup from the Ini file as its no longer used in SQLAPI\\r\\n\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 20,\r\n" + 
			"          \"name\": \"Release version No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 47,\r\n" + 
			"          \"name\": \"Act Finish Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 97,\r\n" + 
			"          \"name\": \"Analyst Assigned To\",\r\n" + 
			"          \"value\": \"Vandra Wiehahn\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 102,\r\n" + 
			"          \"name\": \"Priority Defect\",\r\n" + 
			"          \"value\": \"No\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 115,\r\n" + 
			"          \"name\": \"Developer\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Floris Coetzee\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 146,\r\n" + 
			"          \"name\": \"Back End Components\",\r\n" + 
			"          \"value\": \"FlexiContact.dll\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 147,\r\n" + 
			"          \"name\": \"Front End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 148,\r\n" + 
			"          \"name\": \"XSI Files\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 177,\r\n" + 
			"          \"name\": \"Scripts\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 178,\r\n" + 
			"          \"name\": \"Applications or Client Tools\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 247,\r\n" + 
			"          \"name\": \"Completed Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 287,\r\n" + 
			"          \"name\": \"Crucible Reviewers\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 288,\r\n" + 
			"          \"name\": \"Crucible No.\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 827,\r\n" + 
			"          \"name\": \"QA Testing Assignee\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 854,\r\n" + 
			"          \"name\": \"Old Project\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 855,\r\n" + 
			"          \"name\": \"FE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 856,\r\n" + 
			"          \"name\": \"BE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 857,\r\n" + 
			"          \"name\": \"SCC Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 858,\r\n" + 
			"          \"name\": \"FE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 859,\r\n" + 
			"          \"name\": \"BE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 860,\r\n" + 
			"          \"name\": \"SCC Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 903,\r\n" + 
			"          \"name\": \"Needed in R6.0.6++?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 906,\r\n" + 
			"          \"name\": \"Regression Scope (Developers)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 939,\r\n" + 
			"          \"name\": \"Code Review Status\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 938,\r\n" + 
			"          \"name\": \"Code Reviewed by (BB&D)\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 935,\r\n" + 
			"          \"name\": \"Code Reviewed on Branch\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 936,\r\n" + 
			"          \"name\": \"Code Review Notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        }\r\n" + 
			"      ],\r\n" + 
			"      \"created_on\": \"2016-08-06T06:45:51Z\",\r\n" + 
			"      \"updated_on\": \"2016-08-10T07:43:37Z\"\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 248532,\r\n" + 
			"      \"project\": {\r\n" + 
			"        \"id\": 342,\r\n" + 
			"        \"name\": \"Yellow Application Development R6.0 (L)\"\r\n" + 
			"      },\r\n" + 
			"      \"tracker\": {\r\n" + 
			"        \"id\": 132,\r\n" + 
			"        \"name\": \"CR Section\"\r\n" + 
			"      },\r\n" + 
			"      \"status\": {\r\n" + 
			"        \"id\": 115,\r\n" + 
			"        \"name\": \"[Trunk] Awaiting drop \"\r\n" + 
			"      },\r\n" + 
			"      \"priority\": {\r\n" + 
			"        \"id\": 10,\r\n" + 
			"        \"name\": \"Not-set\"\r\n" + 
			"      },\r\n" + 
			"      \"author\": {\r\n" + 
			"        \"id\": 242,\r\n" + 
			"        \"name\": \"Floris Coetzee\"\r\n" + 
			"      },\r\n" + 
			"      \"assigned_to\": {\r\n" + 
			"        \"id\": 25,\r\n" + 
			"        \"name\": \"-BBD Defects\"\r\n" + 
			"      },\r\n" + 
			"      \"parent\": {\r\n" + 
			"        \"id\": 219735\r\n" + 
			"      },\r\n" + 
			"      \"subject\": \"CR865 A1 - IssuePolicy Component\",\r\n" + 
			"      \"description\": \"\",\r\n" + 
			"      \"start_date\": \"2016-08-06\",\r\n" + 
			"      \"done_ratio\": 100,\r\n" + 
			"      \"custom_fields\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 6,\r\n" + 
			"          \"name\": \"Resolution Code\",\r\n" + 
			"          \"value\": \"Sent For Testing\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 181,\r\n" + 
			"          \"name\": \"Trunk Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 782,\r\n" + 
			"          \"name\": \"Pre-Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 684,\r\n" + 
			"          \"name\": \"Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 8,\r\n" + 
			"          \"name\": \"Steps to reproduce\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 9,\r\n" + 
			"          \"name\": \"Expected results\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 10,\r\n" + 
			"          \"name\": \"Additional Info\",\r\n" + 
			"          \"value\": \"---\\r\\nUpdated BE Methods\\r\\n---\\r\\nCopyQuoteCoIns\\r\\nPreAcceptCheck\\r\\nPreAccept\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 20,\r\n" + 
			"          \"name\": \"Release version No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 47,\r\n" + 
			"          \"name\": \"Act Finish Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 97,\r\n" + 
			"          \"name\": \"Analyst Assigned To\",\r\n" + 
			"          \"value\": \"Vandra Wiehahn\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 102,\r\n" + 
			"          \"name\": \"Priority Defect\",\r\n" + 
			"          \"value\": \"No\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 115,\r\n" + 
			"          \"name\": \"Developer\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Floris Coetzee\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 146,\r\n" + 
			"          \"name\": \"Back End Components\",\r\n" + 
			"          \"value\": \"IssuePolicy.dll\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 147,\r\n" + 
			"          \"name\": \"Front End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 148,\r\n" + 
			"          \"name\": \"XSI Files\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 177,\r\n" + 
			"          \"name\": \"Scripts\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 178,\r\n" + 
			"          \"name\": \"Applications or Client Tools\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 247,\r\n" + 
			"          \"name\": \"Completed Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 287,\r\n" + 
			"          \"name\": \"Crucible Reviewers\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 288,\r\n" + 
			"          \"name\": \"Crucible No.\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 827,\r\n" + 
			"          \"name\": \"QA Testing Assignee\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 854,\r\n" + 
			"          \"name\": \"Old Project\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 855,\r\n" + 
			"          \"name\": \"FE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 856,\r\n" + 
			"          \"name\": \"BE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 857,\r\n" + 
			"          \"name\": \"SCC Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 858,\r\n" + 
			"          \"name\": \"FE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 859,\r\n" + 
			"          \"name\": \"BE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 860,\r\n" + 
			"          \"name\": \"SCC Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 903,\r\n" + 
			"          \"name\": \"Needed in R6.0.6++?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 906,\r\n" + 
			"          \"name\": \"Regression Scope (Developers)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 939,\r\n" + 
			"          \"name\": \"Code Review Status\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 938,\r\n" + 
			"          \"name\": \"Code Reviewed by (BB&D)\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 935,\r\n" + 
			"          \"name\": \"Code Reviewed on Branch\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 936,\r\n" + 
			"          \"name\": \"Code Review Notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        }\r\n" + 
			"      ],\r\n" + 
			"      \"created_on\": \"2016-08-06T06:45:24Z\",\r\n" + 
			"      \"updated_on\": \"2016-08-10T07:43:35Z\"\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 248531,\r\n" + 
			"      \"project\": {\r\n" + 
			"        \"id\": 342,\r\n" + 
			"        \"name\": \"Yellow Application Development R6.0 (L)\"\r\n" + 
			"      },\r\n" + 
			"      \"tracker\": {\r\n" + 
			"        \"id\": 132,\r\n" + 
			"        \"name\": \"CR Section\"\r\n" + 
			"      },\r\n" + 
			"      \"status\": {\r\n" + 
			"        \"id\": 115,\r\n" + 
			"        \"name\": \"[Trunk] Awaiting drop \"\r\n" + 
			"      },\r\n" + 
			"      \"priority\": {\r\n" + 
			"        \"id\": 10,\r\n" + 
			"        \"name\": \"Not-set\"\r\n" + 
			"      },\r\n" + 
			"      \"author\": {\r\n" + 
			"        \"id\": 242,\r\n" + 
			"        \"name\": \"Floris Coetzee\"\r\n" + 
			"      },\r\n" + 
			"      \"assigned_to\": {\r\n" + 
			"        \"id\": 25,\r\n" + 
			"        \"name\": \"-BBD Defects\"\r\n" + 
			"      },\r\n" + 
			"      \"parent\": {\r\n" + 
			"        \"id\": 219735\r\n" + 
			"      },\r\n" + 
			"      \"subject\": \"CR865 A1 - Declaration Component\",\r\n" + 
			"      \"description\": \"\",\r\n" + 
			"      \"start_date\": \"2016-08-06\",\r\n" + 
			"      \"done_ratio\": 100,\r\n" + 
			"      \"custom_fields\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 6,\r\n" + 
			"          \"name\": \"Resolution Code\",\r\n" + 
			"          \"value\": \"Sent For Testing\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 181,\r\n" + 
			"          \"name\": \"Trunk Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 782,\r\n" + 
			"          \"name\": \"Pre-Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 684,\r\n" + 
			"          \"name\": \"Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 8,\r\n" + 
			"          \"name\": \"Steps to reproduce\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 9,\r\n" + 
			"          \"name\": \"Expected results\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 10,\r\n" + 
			"          \"name\": \"Additional Info\",\r\n" + 
			"          \"value\": \"--\\r\\nUpdated BE Methods\\r\\n---\\r\\nInitiateDeclaration\\r\\nAcceptDeclaration\\r\\nCheckAccessForLinkedContacts\\r\\nPreAcceptDeclarationCheck\\r\\nPreAcceptDeclaration\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 20,\r\n" + 
			"          \"name\": \"Release version No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 47,\r\n" + 
			"          \"name\": \"Act Finish Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 97,\r\n" + 
			"          \"name\": \"Analyst Assigned To\",\r\n" + 
			"          \"value\": \"Vandra Wiehahn\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 102,\r\n" + 
			"          \"name\": \"Priority Defect\",\r\n" + 
			"          \"value\": \"No\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 115,\r\n" + 
			"          \"name\": \"Developer\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Floris Coetzee\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 146,\r\n" + 
			"          \"name\": \"Back End Components\",\r\n" + 
			"          \"value\": \"Declaration.dll\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 147,\r\n" + 
			"          \"name\": \"Front End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 148,\r\n" + 
			"          \"name\": \"XSI Files\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 177,\r\n" + 
			"          \"name\": \"Scripts\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 178,\r\n" + 
			"          \"name\": \"Applications or Client Tools\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 247,\r\n" + 
			"          \"name\": \"Completed Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 287,\r\n" + 
			"          \"name\": \"Crucible Reviewers\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 288,\r\n" + 
			"          \"name\": \"Crucible No.\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 827,\r\n" + 
			"          \"name\": \"QA Testing Assignee\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 854,\r\n" + 
			"          \"name\": \"Old Project\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 855,\r\n" + 
			"          \"name\": \"FE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 856,\r\n" + 
			"          \"name\": \"BE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 857,\r\n" + 
			"          \"name\": \"SCC Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 858,\r\n" + 
			"          \"name\": \"FE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 859,\r\n" + 
			"          \"name\": \"BE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 860,\r\n" + 
			"          \"name\": \"SCC Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 903,\r\n" + 
			"          \"name\": \"Needed in R6.0.6++?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 906,\r\n" + 
			"          \"name\": \"Regression Scope (Developers)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 939,\r\n" + 
			"          \"name\": \"Code Review Status\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 938,\r\n" + 
			"          \"name\": \"Code Reviewed by (BB&D)\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 935,\r\n" + 
			"          \"name\": \"Code Reviewed on Branch\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 936,\r\n" + 
			"          \"name\": \"Code Review Notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        }\r\n" + 
			"      ],\r\n" + 
			"      \"created_on\": \"2016-08-06T06:44:50Z\",\r\n" + 
			"      \"updated_on\": \"2016-08-10T07:43:33Z\"\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 248530,\r\n" + 
			"      \"project\": {\r\n" + 
			"        \"id\": 342,\r\n" + 
			"        \"name\": \"Yellow Application Development R6.0 (L)\"\r\n" + 
			"      },\r\n" + 
			"      \"tracker\": {\r\n" + 
			"        \"id\": 132,\r\n" + 
			"        \"name\": \"CR Section\"\r\n" + 
			"      },\r\n" + 
			"      \"status\": {\r\n" + 
			"        \"id\": 115,\r\n" + 
			"        \"name\": \"[Trunk] Awaiting drop \"\r\n" + 
			"      },\r\n" + 
			"      \"priority\": {\r\n" + 
			"        \"id\": 10,\r\n" + 
			"        \"name\": \"Not-set\"\r\n" + 
			"      },\r\n" + 
			"      \"author\": {\r\n" + 
			"        \"id\": 242,\r\n" + 
			"        \"name\": \"Floris Coetzee\"\r\n" + 
			"      },\r\n" + 
			"      \"assigned_to\": {\r\n" + 
			"        \"id\": 25,\r\n" + 
			"        \"name\": \"-BBD Defects\"\r\n" + 
			"      },\r\n" + 
			"      \"parent\": {\r\n" + 
			"        \"id\": 219735\r\n" + 
			"      },\r\n" + 
			"      \"subject\": \"CR865 A1 - ReInst Component\",\r\n" + 
			"      \"description\": \"\",\r\n" + 
			"      \"start_date\": \"2016-08-06\",\r\n" + 
			"      \"done_ratio\": 100,\r\n" + 
			"      \"custom_fields\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 6,\r\n" + 
			"          \"name\": \"Resolution Code\",\r\n" + 
			"          \"value\": \"Sent For Testing\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 181,\r\n" + 
			"          \"name\": \"Trunk Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 782,\r\n" + 
			"          \"name\": \"Pre-Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 684,\r\n" + 
			"          \"name\": \"Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 8,\r\n" + 
			"          \"name\": \"Steps to reproduce\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 9,\r\n" + 
			"          \"name\": \"Expected results\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 10,\r\n" + 
			"          \"name\": \"Additional Info\",\r\n" + 
			"          \"value\": \"---\\r\\nUpdate BE methods\\r\\n---\\r\\nReInstProcessReinstatement\\r\\nCheckAccessForLinkedContacts\\r\\nPreAccept\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 20,\r\n" + 
			"          \"name\": \"Release version No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 47,\r\n" + 
			"          \"name\": \"Act Finish Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 97,\r\n" + 
			"          \"name\": \"Analyst Assigned To\",\r\n" + 
			"          \"value\": \"Vandra Wiehahn\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 102,\r\n" + 
			"          \"name\": \"Priority Defect\",\r\n" + 
			"          \"value\": \"No\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 115,\r\n" + 
			"          \"name\": \"Developer\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Floris Coetzee\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 146,\r\n" + 
			"          \"name\": \"Back End Components\",\r\n" + 
			"          \"value\": \"ReInstPol.dll\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 147,\r\n" + 
			"          \"name\": \"Front End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 148,\r\n" + 
			"          \"name\": \"XSI Files\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 177,\r\n" + 
			"          \"name\": \"Scripts\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 178,\r\n" + 
			"          \"name\": \"Applications or Client Tools\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 247,\r\n" + 
			"          \"name\": \"Completed Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 287,\r\n" + 
			"          \"name\": \"Crucible Reviewers\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 288,\r\n" + 
			"          \"name\": \"Crucible No.\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 827,\r\n" + 
			"          \"name\": \"QA Testing Assignee\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 854,\r\n" + 
			"          \"name\": \"Old Project\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 855,\r\n" + 
			"          \"name\": \"FE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 856,\r\n" + 
			"          \"name\": \"BE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 857,\r\n" + 
			"          \"name\": \"SCC Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 858,\r\n" + 
			"          \"name\": \"FE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 859,\r\n" + 
			"          \"name\": \"BE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 860,\r\n" + 
			"          \"name\": \"SCC Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 903,\r\n" + 
			"          \"name\": \"Needed in R6.0.6++?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 906,\r\n" + 
			"          \"name\": \"Regression Scope (Developers)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 939,\r\n" + 
			"          \"name\": \"Code Review Status\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 938,\r\n" + 
			"          \"name\": \"Code Reviewed by (BB&D)\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 935,\r\n" + 
			"          \"name\": \"Code Reviewed on Branch\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 936,\r\n" + 
			"          \"name\": \"Code Review Notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        }\r\n" + 
			"      ],\r\n" + 
			"      \"created_on\": \"2016-08-06T06:44:17Z\",\r\n" + 
			"      \"updated_on\": \"2016-08-10T07:43:26Z\"\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 248529,\r\n" + 
			"      \"project\": {\r\n" + 
			"        \"id\": 342,\r\n" + 
			"        \"name\": \"Yellow Application Development R6.0 (L)\"\r\n" + 
			"      },\r\n" + 
			"      \"tracker\": {\r\n" + 
			"        \"id\": 132,\r\n" + 
			"        \"name\": \"CR Section\"\r\n" + 
			"      },\r\n" + 
			"      \"status\": {\r\n" + 
			"        \"id\": 115,\r\n" + 
			"        \"name\": \"[Trunk] Awaiting drop \"\r\n" + 
			"      },\r\n" + 
			"      \"priority\": {\r\n" + 
			"        \"id\": 10,\r\n" + 
			"        \"name\": \"Not-set\"\r\n" + 
			"      },\r\n" + 
			"      \"author\": {\r\n" + 
			"        \"id\": 242,\r\n" + 
			"        \"name\": \"Floris Coetzee\"\r\n" + 
			"      },\r\n" + 
			"      \"assigned_to\": {\r\n" + 
			"        \"id\": 25,\r\n" + 
			"        \"name\": \"-BBD Defects\"\r\n" + 
			"      },\r\n" + 
			"      \"parent\": {\r\n" + 
			"        \"id\": 219735\r\n" + 
			"      },\r\n" + 
			"      \"subject\": \"CR865 A1 - Transaction Engine Component\",\r\n" + 
			"      \"description\": \"\",\r\n" + 
			"      \"start_date\": \"2016-08-06\",\r\n" + 
			"      \"done_ratio\": 100,\r\n" + 
			"      \"custom_fields\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 6,\r\n" + 
			"          \"name\": \"Resolution Code\",\r\n" + 
			"          \"value\": \"Sent For Testing\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 181,\r\n" + 
			"          \"name\": \"Trunk Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 782,\r\n" + 
			"          \"name\": \"Pre-Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 684,\r\n" + 
			"          \"name\": \"Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 8,\r\n" + 
			"          \"name\": \"Steps to reproduce\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 9,\r\n" + 
			"          \"name\": \"Expected results\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 10,\r\n" + 
			"          \"name\": \"Additional Info\",\r\n" + 
			"          \"value\": \"---\\r\\nUpdate BE methods\\r\\n---\\r\\nDeterminePartPremium\\r\\nGetMinMaxRules\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 20,\r\n" + 
			"          \"name\": \"Release version No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 47,\r\n" + 
			"          \"name\": \"Act Finish Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 97,\r\n" + 
			"          \"name\": \"Analyst Assigned To\",\r\n" + 
			"          \"value\": \"Vandra Wiehahn\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 102,\r\n" + 
			"          \"name\": \"Priority Defect\",\r\n" + 
			"          \"value\": \"No\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 115,\r\n" + 
			"          \"name\": \"Developer\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Floris Coetzee\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 146,\r\n" + 
			"          \"name\": \"Back End Components\",\r\n" + 
			"          \"value\": \"Full MSMQ\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 147,\r\n" + 
			"          \"name\": \"Front End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 148,\r\n" + 
			"          \"name\": \"XSI Files\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 177,\r\n" + 
			"          \"name\": \"Scripts\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 178,\r\n" + 
			"          \"name\": \"Applications or Client Tools\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 247,\r\n" + 
			"          \"name\": \"Completed Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 287,\r\n" + 
			"          \"name\": \"Crucible Reviewers\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 288,\r\n" + 
			"          \"name\": \"Crucible No.\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 827,\r\n" + 
			"          \"name\": \"QA Testing Assignee\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 854,\r\n" + 
			"          \"name\": \"Old Project\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 855,\r\n" + 
			"          \"name\": \"FE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 856,\r\n" + 
			"          \"name\": \"BE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 857,\r\n" + 
			"          \"name\": \"SCC Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 858,\r\n" + 
			"          \"name\": \"FE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 859,\r\n" + 
			"          \"name\": \"BE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 860,\r\n" + 
			"          \"name\": \"SCC Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 903,\r\n" + 
			"          \"name\": \"Needed in R6.0.6++?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 906,\r\n" + 
			"          \"name\": \"Regression Scope (Developers)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 939,\r\n" + 
			"          \"name\": \"Code Review Status\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 938,\r\n" + 
			"          \"name\": \"Code Reviewed by (BB&D)\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 935,\r\n" + 
			"          \"name\": \"Code Reviewed on Branch\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 936,\r\n" + 
			"          \"name\": \"Code Review Notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        }\r\n" + 
			"      ],\r\n" + 
			"      \"created_on\": \"2016-08-06T06:39:51Z\",\r\n" + 
			"      \"updated_on\": \"2016-08-10T07:43:24Z\"\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 248528,\r\n" + 
			"      \"project\": {\r\n" + 
			"        \"id\": 342,\r\n" + 
			"        \"name\": \"Yellow Application Development R6.0 (L)\"\r\n" + 
			"      },\r\n" + 
			"      \"tracker\": {\r\n" + 
			"        \"id\": 132,\r\n" + 
			"        \"name\": \"CR Section\"\r\n" + 
			"      },\r\n" + 
			"      \"status\": {\r\n" + 
			"        \"id\": 115,\r\n" + 
			"        \"name\": \"[Trunk] Awaiting drop \"\r\n" + 
			"      },\r\n" + 
			"      \"priority\": {\r\n" + 
			"        \"id\": 10,\r\n" + 
			"        \"name\": \"Not-set\"\r\n" + 
			"      },\r\n" + 
			"      \"author\": {\r\n" + 
			"        \"id\": 242,\r\n" + 
			"        \"name\": \"Floris Coetzee\"\r\n" + 
			"      },\r\n" + 
			"      \"assigned_to\": {\r\n" + 
			"        \"id\": 25,\r\n" + 
			"        \"name\": \"-BBD Defects\"\r\n" + 
			"      },\r\n" + 
			"      \"parent\": {\r\n" + 
			"        \"id\": 219735\r\n" + 
			"      },\r\n" + 
			"      \"subject\": \"CR865 A1 - User Component\",\r\n" + 
			"      \"description\": \"\",\r\n" + 
			"      \"start_date\": \"2016-08-06\",\r\n" + 
			"      \"done_ratio\": 100,\r\n" + 
			"      \"custom_fields\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 6,\r\n" + 
			"          \"name\": \"Resolution Code\",\r\n" + 
			"          \"value\": \"Sent For Testing\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 181,\r\n" + 
			"          \"name\": \"Trunk Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 782,\r\n" + 
			"          \"name\": \"Pre-Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 684,\r\n" + 
			"          \"name\": \"Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 8,\r\n" + 
			"          \"name\": \"Steps to reproduce\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 9,\r\n" + 
			"          \"name\": \"Expected results\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 10,\r\n" + 
			"          \"name\": \"Additional Info\",\r\n" + 
			"          \"value\": \"---\\r\\nUpdated BE methods\\r\\n---\\r\\nGetUserContact\\r\\nGetUserItem\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 20,\r\n" + 
			"          \"name\": \"Release version No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 47,\r\n" + 
			"          \"name\": \"Act Finish Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 97,\r\n" + 
			"          \"name\": \"Analyst Assigned To\",\r\n" + 
			"          \"value\": \"Vandra Wiehahn\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 102,\r\n" + 
			"          \"name\": \"Priority Defect\",\r\n" + 
			"          \"value\": \"No\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 115,\r\n" + 
			"          \"name\": \"Developer\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Floris Coetzee\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 146,\r\n" + 
			"          \"name\": \"Back End Components\",\r\n" + 
			"          \"value\": \"User.dll\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 147,\r\n" + 
			"          \"name\": \"Front End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 148,\r\n" + 
			"          \"name\": \"XSI Files\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 177,\r\n" + 
			"          \"name\": \"Scripts\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 178,\r\n" + 
			"          \"name\": \"Applications or Client Tools\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 247,\r\n" + 
			"          \"name\": \"Completed Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 287,\r\n" + 
			"          \"name\": \"Crucible Reviewers\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 288,\r\n" + 
			"          \"name\": \"Crucible No.\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 827,\r\n" + 
			"          \"name\": \"QA Testing Assignee\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 854,\r\n" + 
			"          \"name\": \"Old Project\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 855,\r\n" + 
			"          \"name\": \"FE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 856,\r\n" + 
			"          \"name\": \"BE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 857,\r\n" + 
			"          \"name\": \"SCC Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 858,\r\n" + 
			"          \"name\": \"FE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 859,\r\n" + 
			"          \"name\": \"BE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 860,\r\n" + 
			"          \"name\": \"SCC Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 903,\r\n" + 
			"          \"name\": \"Needed in R6.0.6++?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 906,\r\n" + 
			"          \"name\": \"Regression Scope (Developers)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 939,\r\n" + 
			"          \"name\": \"Code Review Status\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 938,\r\n" + 
			"          \"name\": \"Code Reviewed by (BB&D)\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 935,\r\n" + 
			"          \"name\": \"Code Reviewed on Branch\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 936,\r\n" + 
			"          \"name\": \"Code Review Notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        }\r\n" + 
			"      ],\r\n" + 
			"      \"created_on\": \"2016-08-06T06:39:03Z\",\r\n" + 
			"      \"updated_on\": \"2016-08-10T07:43:22Z\"\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 248527,\r\n" + 
			"      \"project\": {\r\n" + 
			"        \"id\": 342,\r\n" + 
			"        \"name\": \"Yellow Application Development R6.0 (L)\"\r\n" + 
			"      },\r\n" + 
			"      \"tracker\": {\r\n" + 
			"        \"id\": 132,\r\n" + 
			"        \"name\": \"CR Section\"\r\n" + 
			"      },\r\n" + 
			"      \"status\": {\r\n" + 
			"        \"id\": 115,\r\n" + 
			"        \"name\": \"[Trunk] Awaiting drop \"\r\n" + 
			"      },\r\n" + 
			"      \"priority\": {\r\n" + 
			"        \"id\": 10,\r\n" + 
			"        \"name\": \"Not-set\"\r\n" + 
			"      },\r\n" + 
			"      \"author\": {\r\n" + 
			"        \"id\": 242,\r\n" + 
			"        \"name\": \"Floris Coetzee\"\r\n" + 
			"      },\r\n" + 
			"      \"assigned_to\": {\r\n" + 
			"        \"id\": 25,\r\n" + 
			"        \"name\": \"-BBD Defects\"\r\n" + 
			"      },\r\n" + 
			"      \"parent\": {\r\n" + 
			"        \"id\": 219735\r\n" + 
			"      },\r\n" + 
			"      \"subject\": \"CR865 A1 - WebAPI Component\",\r\n" + 
			"      \"description\": \"\",\r\n" + 
			"      \"start_date\": \"2016-08-06\",\r\n" + 
			"      \"done_ratio\": 100,\r\n" + 
			"      \"custom_fields\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 6,\r\n" + 
			"          \"name\": \"Resolution Code\",\r\n" + 
			"          \"value\": \"Sent For Testing\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 181,\r\n" + 
			"          \"name\": \"Trunk Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 782,\r\n" + 
			"          \"name\": \"Pre-Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 684,\r\n" + 
			"          \"name\": \"Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 8,\r\n" + 
			"          \"name\": \"Steps to reproduce\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 9,\r\n" + 
			"          \"name\": \"Expected results\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 10,\r\n" + 
			"          \"name\": \"Additional Info\",\r\n" + 
			"          \"value\": \"---\\r\\nUpdated BE Methods\\r\\n---\\r\\nGetDataExtract\\r\\nGetContactRefsForClaimRefs\\r\\nGetContactRefsForPartRefs\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 20,\r\n" + 
			"          \"name\": \"Release version No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 47,\r\n" + 
			"          \"name\": \"Act Finish Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 97,\r\n" + 
			"          \"name\": \"Analyst Assigned To\",\r\n" + 
			"          \"value\": \"Vandra Wiehahn\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 102,\r\n" + 
			"          \"name\": \"Priority Defect\",\r\n" + 
			"          \"value\": \"No\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 115,\r\n" + 
			"          \"name\": \"Developer\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Floris Coetzee\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 146,\r\n" + 
			"          \"name\": \"Back End Components\",\r\n" + 
			"          \"value\": \"WebAPI.dll\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 147,\r\n" + 
			"          \"name\": \"Front End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 148,\r\n" + 
			"          \"name\": \"XSI Files\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 177,\r\n" + 
			"          \"name\": \"Scripts\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 178,\r\n" + 
			"          \"name\": \"Applications or Client Tools\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 247,\r\n" + 
			"          \"name\": \"Completed Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 287,\r\n" + 
			"          \"name\": \"Crucible Reviewers\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 288,\r\n" + 
			"          \"name\": \"Crucible No.\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 827,\r\n" + 
			"          \"name\": \"QA Testing Assignee\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 854,\r\n" + 
			"          \"name\": \"Old Project\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 855,\r\n" + 
			"          \"name\": \"FE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 856,\r\n" + 
			"          \"name\": \"BE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 857,\r\n" + 
			"          \"name\": \"SCC Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 858,\r\n" + 
			"          \"name\": \"FE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 859,\r\n" + 
			"          \"name\": \"BE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 860,\r\n" + 
			"          \"name\": \"SCC Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 903,\r\n" + 
			"          \"name\": \"Needed in R6.0.6++?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 906,\r\n" + 
			"          \"name\": \"Regression Scope (Developers)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 939,\r\n" + 
			"          \"name\": \"Code Review Status\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 938,\r\n" + 
			"          \"name\": \"Code Reviewed by (BB&D)\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 935,\r\n" + 
			"          \"name\": \"Code Reviewed on Branch\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 936,\r\n" + 
			"          \"name\": \"Code Review Notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        }\r\n" + 
			"      ],\r\n" + 
			"      \"created_on\": \"2016-08-06T06:38:30Z\",\r\n" + 
			"      \"updated_on\": \"2016-08-10T07:43:20Z\"\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 248526,\r\n" + 
			"      \"project\": {\r\n" + 
			"        \"id\": 342,\r\n" + 
			"        \"name\": \"Yellow Application Development R6.0 (L)\"\r\n" + 
			"      },\r\n" + 
			"      \"tracker\": {\r\n" + 
			"        \"id\": 132,\r\n" + 
			"        \"name\": \"CR Section\"\r\n" + 
			"      },\r\n" + 
			"      \"status\": {\r\n" + 
			"        \"id\": 115,\r\n" + 
			"        \"name\": \"[Trunk] Awaiting drop \"\r\n" + 
			"      },\r\n" + 
			"      \"priority\": {\r\n" + 
			"        \"id\": 10,\r\n" + 
			"        \"name\": \"Not-set\"\r\n" + 
			"      },\r\n" + 
			"      \"author\": {\r\n" + 
			"        \"id\": 242,\r\n" + 
			"        \"name\": \"Floris Coetzee\"\r\n" + 
			"      },\r\n" + 
			"      \"assigned_to\": {\r\n" + 
			"        \"id\": 25,\r\n" + 
			"        \"name\": \"-BBD Defects\"\r\n" + 
			"      },\r\n" + 
			"      \"parent\": {\r\n" + 
			"        \"id\": 219735\r\n" + 
			"      },\r\n" + 
			"      \"subject\": \"CR865 A1 - MTA Component\",\r\n" + 
			"      \"description\": \"\",\r\n" + 
			"      \"start_date\": \"2016-08-06\",\r\n" + 
			"      \"done_ratio\": 100,\r\n" + 
			"      \"custom_fields\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 6,\r\n" + 
			"          \"name\": \"Resolution Code\",\r\n" + 
			"          \"value\": \"Sent For Testing\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 181,\r\n" + 
			"          \"name\": \"Trunk Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 782,\r\n" + 
			"          \"name\": \"Pre-Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 684,\r\n" + 
			"          \"name\": \"Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 8,\r\n" + 
			"          \"name\": \"Steps to reproduce\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 9,\r\n" + 
			"          \"name\": \"Expected results\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 10,\r\n" + 
			"          \"name\": \"Additional Info\",\r\n" + 
			"          \"value\": \"--\\r\\nUpdated BE methods\\r\\n---\\r\\nInitiateMTA\\r\\nCheckAccessForLinkedContacts\\r\\nPreAccept\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 20,\r\n" + 
			"          \"name\": \"Release version No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 47,\r\n" + 
			"          \"name\": \"Act Finish Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 97,\r\n" + 
			"          \"name\": \"Analyst Assigned To\",\r\n" + 
			"          \"value\": \"Vandra Wiehahn\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 102,\r\n" + 
			"          \"name\": \"Priority Defect\",\r\n" + 
			"          \"value\": \"No\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 115,\r\n" + 
			"          \"name\": \"Developer\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Floris Coetzee\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 146,\r\n" + 
			"          \"name\": \"Back End Components\",\r\n" + 
			"          \"value\": \"MTA.dll\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 147,\r\n" + 
			"          \"name\": \"Front End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 148,\r\n" + 
			"          \"name\": \"XSI Files\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 177,\r\n" + 
			"          \"name\": \"Scripts\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 178,\r\n" + 
			"          \"name\": \"Applications or Client Tools\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 247,\r\n" + 
			"          \"name\": \"Completed Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 287,\r\n" + 
			"          \"name\": \"Crucible Reviewers\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 288,\r\n" + 
			"          \"name\": \"Crucible No.\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 827,\r\n" + 
			"          \"name\": \"QA Testing Assignee\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 854,\r\n" + 
			"          \"name\": \"Old Project\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 855,\r\n" + 
			"          \"name\": \"FE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 856,\r\n" + 
			"          \"name\": \"BE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 857,\r\n" + 
			"          \"name\": \"SCC Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 858,\r\n" + 
			"          \"name\": \"FE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 859,\r\n" + 
			"          \"name\": \"BE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 860,\r\n" + 
			"          \"name\": \"SCC Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 903,\r\n" + 
			"          \"name\": \"Needed in R6.0.6++?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 906,\r\n" + 
			"          \"name\": \"Regression Scope (Developers)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 939,\r\n" + 
			"          \"name\": \"Code Review Status\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 938,\r\n" + 
			"          \"name\": \"Code Reviewed by (BB&D)\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 935,\r\n" + 
			"          \"name\": \"Code Reviewed on Branch\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 936,\r\n" + 
			"          \"name\": \"Code Review Notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        }\r\n" + 
			"      ],\r\n" + 
			"      \"created_on\": \"2016-08-06T06:37:58Z\",\r\n" + 
			"      \"updated_on\": \"2016-08-10T07:43:17Z\"\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 248525,\r\n" + 
			"      \"project\": {\r\n" + 
			"        \"id\": 342,\r\n" + 
			"        \"name\": \"Yellow Application Development R6.0 (L)\"\r\n" + 
			"      },\r\n" + 
			"      \"tracker\": {\r\n" + 
			"        \"id\": 132,\r\n" + 
			"        \"name\": \"CR Section\"\r\n" + 
			"      },\r\n" + 
			"      \"status\": {\r\n" + 
			"        \"id\": 115,\r\n" + 
			"        \"name\": \"[Trunk] Awaiting drop \"\r\n" + 
			"      },\r\n" + 
			"      \"priority\": {\r\n" + 
			"        \"id\": 10,\r\n" + 
			"        \"name\": \"Not-set\"\r\n" + 
			"      },\r\n" + 
			"      \"author\": {\r\n" + 
			"        \"id\": 242,\r\n" + 
			"        \"name\": \"Floris Coetzee\"\r\n" + 
			"      },\r\n" + 
			"      \"assigned_to\": {\r\n" + 
			"        \"id\": 25,\r\n" + 
			"        \"name\": \"-BBD Defects\"\r\n" + 
			"      },\r\n" + 
			"      \"parent\": {\r\n" + 
			"        \"id\": 219735\r\n" + 
			"      },\r\n" + 
			"      \"subject\": \"CR865 A1 - Cancellation Component\",\r\n" + 
			"      \"description\": \"\",\r\n" + 
			"      \"start_date\": \"2016-08-06\",\r\n" + 
			"      \"done_ratio\": 100,\r\n" + 
			"      \"custom_fields\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 6,\r\n" + 
			"          \"name\": \"Resolution Code\",\r\n" + 
			"          \"value\": \"Sent For Testing\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 181,\r\n" + 
			"          \"name\": \"Trunk Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 782,\r\n" + 
			"          \"name\": \"Pre-Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 684,\r\n" + 
			"          \"name\": \"Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 8,\r\n" + 
			"          \"name\": \"Steps to reproduce\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 9,\r\n" + 
			"          \"name\": \"Expected results\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 10,\r\n" + 
			"          \"name\": \"Additional Info\",\r\n" + 
			"          \"value\": \"---\\r\\nBE Methods Updated\\r\\n---\\r\\nAcceptCancellation\\r\\nCheckAccessForLinkedContacts\\r\\nPreAcceptCheck\\r\\n\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 20,\r\n" + 
			"          \"name\": \"Release version No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 47,\r\n" + 
			"          \"name\": \"Act Finish Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 97,\r\n" + 
			"          \"name\": \"Analyst Assigned To\",\r\n" + 
			"          \"value\": \"Vandra Wiehahn\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 102,\r\n" + 
			"          \"name\": \"Priority Defect\",\r\n" + 
			"          \"value\": \"No\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 115,\r\n" + 
			"          \"name\": \"Developer\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Floris Coetzee\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 146,\r\n" + 
			"          \"name\": \"Back End Components\",\r\n" + 
			"          \"value\": \"Cancellation.dll\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 147,\r\n" + 
			"          \"name\": \"Front End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 148,\r\n" + 
			"          \"name\": \"XSI Files\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 177,\r\n" + 
			"          \"name\": \"Scripts\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 178,\r\n" + 
			"          \"name\": \"Applications or Client Tools\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 247,\r\n" + 
			"          \"name\": \"Completed Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 287,\r\n" + 
			"          \"name\": \"Crucible Reviewers\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 288,\r\n" + 
			"          \"name\": \"Crucible No.\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 827,\r\n" + 
			"          \"name\": \"QA Testing Assignee\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 854,\r\n" + 
			"          \"name\": \"Old Project\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 855,\r\n" + 
			"          \"name\": \"FE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 856,\r\n" + 
			"          \"name\": \"BE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 857,\r\n" + 
			"          \"name\": \"SCC Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 858,\r\n" + 
			"          \"name\": \"FE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 859,\r\n" + 
			"          \"name\": \"BE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 860,\r\n" + 
			"          \"name\": \"SCC Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 903,\r\n" + 
			"          \"name\": \"Needed in R6.0.6++?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 906,\r\n" + 
			"          \"name\": \"Regression Scope (Developers)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 939,\r\n" + 
			"          \"name\": \"Code Review Status\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 938,\r\n" + 
			"          \"name\": \"Code Reviewed by (BB&D)\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 935,\r\n" + 
			"          \"name\": \"Code Reviewed on Branch\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 936,\r\n" + 
			"          \"name\": \"Code Review Notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        }\r\n" + 
			"      ],\r\n" + 
			"      \"created_on\": \"2016-08-06T06:37:25Z\",\r\n" + 
			"      \"updated_on\": \"2016-08-10T07:43:15Z\"\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 248524,\r\n" + 
			"      \"project\": {\r\n" + 
			"        \"id\": 342,\r\n" + 
			"        \"name\": \"Yellow Application Development R6.0 (L)\"\r\n" + 
			"      },\r\n" + 
			"      \"tracker\": {\r\n" + 
			"        \"id\": 132,\r\n" + 
			"        \"name\": \"CR Section\"\r\n" + 
			"      },\r\n" + 
			"      \"status\": {\r\n" + 
			"        \"id\": 115,\r\n" + 
			"        \"name\": \"[Trunk] Awaiting drop \"\r\n" + 
			"      },\r\n" + 
			"      \"priority\": {\r\n" + 
			"        \"id\": 10,\r\n" + 
			"        \"name\": \"Not-set\"\r\n" + 
			"      },\r\n" + 
			"      \"author\": {\r\n" + 
			"        \"id\": 242,\r\n" + 
			"        \"name\": \"Floris Coetzee\"\r\n" + 
			"      },\r\n" + 
			"      \"assigned_to\": {\r\n" + 
			"        \"id\": 25,\r\n" + 
			"        \"name\": \"-BBD Defects\"\r\n" + 
			"      },\r\n" + 
			"      \"parent\": {\r\n" + 
			"        \"id\": 219735\r\n" + 
			"      },\r\n" + 
			"      \"subject\": \"CR865 A1 - FLGL Component\",\r\n" + 
			"      \"description\": \"\",\r\n" + 
			"      \"start_date\": \"2016-08-06\",\r\n" + 
			"      \"done_ratio\": 100,\r\n" + 
			"      \"custom_fields\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 6,\r\n" + 
			"          \"name\": \"Resolution Code\",\r\n" + 
			"          \"value\": \"Sent For Testing\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 181,\r\n" + 
			"          \"name\": \"Trunk Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 782,\r\n" + 
			"          \"name\": \"Pre-Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 684,\r\n" + 
			"          \"name\": \"Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 8,\r\n" + 
			"          \"name\": \"Steps to reproduce\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 9,\r\n" + 
			"          \"name\": \"Expected results\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 10,\r\n" + 
			"          \"name\": \"Additional Info\",\r\n" + 
			"          \"value\": \"---\\r\\nBE Methods updated\\r\\n---\\r\\nCountFailedInvoices\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 20,\r\n" + 
			"          \"name\": \"Release version No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 47,\r\n" + 
			"          \"name\": \"Act Finish Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 97,\r\n" + 
			"          \"name\": \"Analyst Assigned To\",\r\n" + 
			"          \"value\": \"Vandra Wiehahn\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 102,\r\n" + 
			"          \"name\": \"Priority Defect\",\r\n" + 
			"          \"value\": \"No\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 115,\r\n" + 
			"          \"name\": \"Developer\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Floris Coetzee\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 146,\r\n" + 
			"          \"name\": \"Back End Components\",\r\n" + 
			"          \"value\": \"FLGL.dll\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 147,\r\n" + 
			"          \"name\": \"Front End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 148,\r\n" + 
			"          \"name\": \"XSI Files\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 177,\r\n" + 
			"          \"name\": \"Scripts\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 178,\r\n" + 
			"          \"name\": \"Applications or Client Tools\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 247,\r\n" + 
			"          \"name\": \"Completed Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 287,\r\n" + 
			"          \"name\": \"Crucible Reviewers\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 288,\r\n" + 
			"          \"name\": \"Crucible No.\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 827,\r\n" + 
			"          \"name\": \"QA Testing Assignee\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 854,\r\n" + 
			"          \"name\": \"Old Project\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 855,\r\n" + 
			"          \"name\": \"FE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 856,\r\n" + 
			"          \"name\": \"BE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 857,\r\n" + 
			"          \"name\": \"SCC Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 858,\r\n" + 
			"          \"name\": \"FE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 859,\r\n" + 
			"          \"name\": \"BE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 860,\r\n" + 
			"          \"name\": \"SCC Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 903,\r\n" + 
			"          \"name\": \"Needed in R6.0.6++?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 906,\r\n" + 
			"          \"name\": \"Regression Scope (Developers)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 939,\r\n" + 
			"          \"name\": \"Code Review Status\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 938,\r\n" + 
			"          \"name\": \"Code Reviewed by (BB&D)\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 935,\r\n" + 
			"          \"name\": \"Code Reviewed on Branch\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 936,\r\n" + 
			"          \"name\": \"Code Review Notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        }\r\n" + 
			"      ],\r\n" + 
			"      \"created_on\": \"2016-08-06T06:33:31Z\",\r\n" + 
			"      \"updated_on\": \"2016-08-10T07:43:13Z\"\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 248523,\r\n" + 
			"      \"project\": {\r\n" + 
			"        \"id\": 342,\r\n" + 
			"        \"name\": \"Yellow Application Development R6.0 (L)\"\r\n" + 
			"      },\r\n" + 
			"      \"tracker\": {\r\n" + 
			"        \"id\": 132,\r\n" + 
			"        \"name\": \"CR Section\"\r\n" + 
			"      },\r\n" + 
			"      \"status\": {\r\n" + 
			"        \"id\": 115,\r\n" + 
			"        \"name\": \"[Trunk] Awaiting drop \"\r\n" + 
			"      },\r\n" + 
			"      \"priority\": {\r\n" + 
			"        \"id\": 10,\r\n" + 
			"        \"name\": \"Not-set\"\r\n" + 
			"      },\r\n" + 
			"      \"author\": {\r\n" + 
			"        \"id\": 242,\r\n" + 
			"        \"name\": \"Floris Coetzee\"\r\n" + 
			"      },\r\n" + 
			"      \"assigned_to\": {\r\n" + 
			"        \"id\": 25,\r\n" + 
			"        \"name\": \"-BBD Defects\"\r\n" + 
			"      },\r\n" + 
			"      \"parent\": {\r\n" + 
			"        \"id\": 219735\r\n" + 
			"      },\r\n" + 
			"      \"subject\": \"CR865 A1 - Remote Config Component\",\r\n" + 
			"      \"description\": \"\",\r\n" + 
			"      \"start_date\": \"2016-08-06\",\r\n" + 
			"      \"done_ratio\": 100,\r\n" + 
			"      \"custom_fields\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 6,\r\n" + 
			"          \"name\": \"Resolution Code\",\r\n" + 
			"          \"value\": \"Sent For Testing\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 181,\r\n" + 
			"          \"name\": \"Trunk Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 782,\r\n" + 
			"          \"name\": \"Pre-Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 684,\r\n" + 
			"          \"name\": \"Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 8,\r\n" + 
			"          \"name\": \"Steps to reproduce\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 9,\r\n" + 
			"          \"name\": \"Expected results\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 10,\r\n" + 
			"          \"name\": \"Additional Info\",\r\n" + 
			"          \"value\": \"---\\r\\nBE Methods Updated\\r\\n---\\r\\nGetDocTemplates\\r\\nGetAvailableOfficesForInsurer\\r\\nGetInsurerInfo\\r\\nGetInsurerCommissionParmData\\r\\nGetBrokOffInfo\\r\\nGetBrokOffTeamInfo\\r\\nGetUserInfo\\r\\nGetCertInfo\\r\\nGetStdWordListForRatingDetails\\r\\nGetStdWordListForRatingDetails2\\r\\nGetActiveModules\\r\\nGetProductSections\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 20,\r\n" + 
			"          \"name\": \"Release version No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 47,\r\n" + 
			"          \"name\": \"Act Finish Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 97,\r\n" + 
			"          \"name\": \"Analyst Assigned To\",\r\n" + 
			"          \"value\": \"Vandra Wiehahn\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 102,\r\n" + 
			"          \"name\": \"Priority Defect\",\r\n" + 
			"          \"value\": \"No\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 115,\r\n" + 
			"          \"name\": \"Developer\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Floris Coetzee\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 146,\r\n" + 
			"          \"name\": \"Back End Components\",\r\n" + 
			"          \"value\": \"RemoteConfig.dll\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 147,\r\n" + 
			"          \"name\": \"Front End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 148,\r\n" + 
			"          \"name\": \"XSI Files\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 177,\r\n" + 
			"          \"name\": \"Scripts\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 178,\r\n" + 
			"          \"name\": \"Applications or Client Tools\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 247,\r\n" + 
			"          \"name\": \"Completed Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 287,\r\n" + 
			"          \"name\": \"Crucible Reviewers\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 288,\r\n" + 
			"          \"name\": \"Crucible No.\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 827,\r\n" + 
			"          \"name\": \"QA Testing Assignee\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 854,\r\n" + 
			"          \"name\": \"Old Project\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 855,\r\n" + 
			"          \"name\": \"FE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 856,\r\n" + 
			"          \"name\": \"BE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 857,\r\n" + 
			"          \"name\": \"SCC Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 858,\r\n" + 
			"          \"name\": \"FE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 859,\r\n" + 
			"          \"name\": \"BE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 860,\r\n" + 
			"          \"name\": \"SCC Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 903,\r\n" + 
			"          \"name\": \"Needed in R6.0.6++?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 906,\r\n" + 
			"          \"name\": \"Regression Scope (Developers)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 939,\r\n" + 
			"          \"name\": \"Code Review Status\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 938,\r\n" + 
			"          \"name\": \"Code Reviewed by (BB&D)\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 935,\r\n" + 
			"          \"name\": \"Code Reviewed on Branch\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 936,\r\n" + 
			"          \"name\": \"Code Review Notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        }\r\n" + 
			"      ],\r\n" + 
			"      \"created_on\": \"2016-08-06T06:32:40Z\",\r\n" + 
			"      \"updated_on\": \"2016-08-10T07:43:10Z\"\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 229577,\r\n" + 
			"      \"project\": {\r\n" + 
			"        \"id\": 342,\r\n" + 
			"        \"name\": \"Yellow Application Development R6.0 (L)\"\r\n" + 
			"      },\r\n" + 
			"      \"tracker\": {\r\n" + 
			"        \"id\": 132,\r\n" + 
			"        \"name\": \"CR Section\"\r\n" + 
			"      },\r\n" + 
			"      \"status\": {\r\n" + 
			"        \"id\": 115,\r\n" + 
			"        \"name\": \"[Trunk] Awaiting drop \"\r\n" + 
			"      },\r\n" + 
			"      \"priority\": {\r\n" + 
			"        \"id\": 10,\r\n" + 
			"        \"name\": \"Not-set\"\r\n" + 
			"      },\r\n" + 
			"      \"author\": {\r\n" + 
			"        \"id\": 241,\r\n" + 
			"        \"name\": \"Luke Sims\"\r\n" + 
			"      },\r\n" + 
			"      \"assigned_to\": {\r\n" + 
			"        \"id\": 25,\r\n" + 
			"        \"name\": \"-BBD Defects\"\r\n" + 
			"      },\r\n" + 
			"      \"parent\": {\r\n" + 
			"        \"id\": 229513\r\n" + 
			"      },\r\n" + 
			"      \"subject\": \"CR865 A1 - 3.1.29.1 - XMLApi - DynamicSqlElement Conversion\",\r\n" + 
			"      \"description\": \"CreateTag_PartComparison\\r\\n\",\r\n" + 
			"      \"start_date\": \"2016-03-10\",\r\n" + 
			"      \"done_ratio\": 100,\r\n" + 
			"      \"custom_fields\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 6,\r\n" + 
			"          \"name\": \"Resolution Code\",\r\n" + 
			"          \"value\": \"Sent For Testing\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 181,\r\n" + 
			"          \"name\": \"Trunk Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 782,\r\n" + 
			"          \"name\": \"Pre-Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 684,\r\n" + 
			"          \"name\": \"Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 8,\r\n" + 
			"          \"name\": \"Steps to reproduce\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 9,\r\n" + 
			"          \"name\": \"Expected results\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 10,\r\n" + 
			"          \"name\": \"Additional Info\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 20,\r\n" + 
			"          \"name\": \"Release version No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 47,\r\n" + 
			"          \"name\": \"Act Finish Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 97,\r\n" + 
			"          \"name\": \"Analyst Assigned To\",\r\n" + 
			"          \"value\": \"Vandra Wiehahn\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 102,\r\n" + 
			"          \"name\": \"Priority Defect\",\r\n" + 
			"          \"value\": \"No\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 115,\r\n" + 
			"          \"name\": \"Developer\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Floris Coetzee\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 146,\r\n" + 
			"          \"name\": \"Back End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 147,\r\n" + 
			"          \"name\": \"Front End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 148,\r\n" + 
			"          \"name\": \"XSI Files\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 177,\r\n" + 
			"          \"name\": \"Scripts\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 178,\r\n" + 
			"          \"name\": \"Applications or Client Tools\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 247,\r\n" + 
			"          \"name\": \"Completed Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 287,\r\n" + 
			"          \"name\": \"Crucible Reviewers\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 288,\r\n" + 
			"          \"name\": \"Crucible No.\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 827,\r\n" + 
			"          \"name\": \"QA Testing Assignee\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 854,\r\n" + 
			"          \"name\": \"Old Project\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 855,\r\n" + 
			"          \"name\": \"FE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 856,\r\n" + 
			"          \"name\": \"BE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 857,\r\n" + 
			"          \"name\": \"SCC Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 858,\r\n" + 
			"          \"name\": \"FE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 859,\r\n" + 
			"          \"name\": \"BE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 860,\r\n" + 
			"          \"name\": \"SCC Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 903,\r\n" + 
			"          \"name\": \"Needed in R6.0.6++?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 906,\r\n" + 
			"          \"name\": \"Regression Scope (Developers)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 939,\r\n" + 
			"          \"name\": \"Code Review Status\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 938,\r\n" + 
			"          \"name\": \"Code Reviewed by (BB&D)\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 935,\r\n" + 
			"          \"name\": \"Code Reviewed on Branch\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 936,\r\n" + 
			"          \"name\": \"Code Review Notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        }\r\n" + 
			"      ],\r\n" + 
			"      \"created_on\": \"2016-03-10T10:09:31Z\",\r\n" + 
			"      \"updated_on\": \"2016-08-10T07:46:26Z\"\r\n" + 
			"    },\r\n" + 
			"    {\r\n" + 
			"      \"id\": 229576,\r\n" + 
			"      \"project\": {\r\n" + 
			"        \"id\": 342,\r\n" + 
			"        \"name\": \"Yellow Application Development R6.0 (L)\"\r\n" + 
			"      },\r\n" + 
			"      \"tracker\": {\r\n" + 
			"        \"id\": 132,\r\n" + 
			"        \"name\": \"CR Section\"\r\n" + 
			"      },\r\n" + 
			"      \"status\": {\r\n" + 
			"        \"id\": 115,\r\n" + 
			"        \"name\": \"[Trunk] Awaiting drop \"\r\n" + 
			"      },\r\n" + 
			"      \"priority\": {\r\n" + 
			"        \"id\": 10,\r\n" + 
			"        \"name\": \"Not-set\"\r\n" + 
			"      },\r\n" + 
			"      \"author\": {\r\n" + 
			"        \"id\": 241,\r\n" + 
			"        \"name\": \"Luke Sims\"\r\n" + 
			"      },\r\n" + 
			"      \"assigned_to\": {\r\n" + 
			"        \"id\": 25,\r\n" + 
			"        \"name\": \"-BBD Defects\"\r\n" + 
			"      },\r\n" + 
			"      \"parent\": {\r\n" + 
			"        \"id\": 229512\r\n" + 
			"      },\r\n" + 
			"      \"subject\": \"CR865 A1 - 3.1.28.2 - TMBatchProcessor - Method Definition Refactoring\",\r\n" + 
			"      \"description\": \"GenQry\\r\\n\",\r\n" + 
			"      \"start_date\": \"2016-03-10\",\r\n" + 
			"      \"done_ratio\": 100,\r\n" + 
			"      \"custom_fields\": [\r\n" + 
			"        {\r\n" + 
			"          \"id\": 6,\r\n" + 
			"          \"name\": \"Resolution Code\",\r\n" + 
			"          \"value\": \"Sent For Testing\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 181,\r\n" + 
			"          \"name\": \"Trunk Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 782,\r\n" + 
			"          \"name\": \"Pre-Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 684,\r\n" + 
			"          \"name\": \"Prod Resolution drop No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 8,\r\n" + 
			"          \"name\": \"Steps to reproduce\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 9,\r\n" + 
			"          \"name\": \"Expected results\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 10,\r\n" + 
			"          \"name\": \"Additional Info\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 20,\r\n" + 
			"          \"name\": \"Release version No\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 47,\r\n" + 
			"          \"name\": \"Act Finish Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 97,\r\n" + 
			"          \"name\": \"Analyst Assigned To\",\r\n" + 
			"          \"value\": \"Vandra Wiehahn\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 102,\r\n" + 
			"          \"name\": \"Priority Defect\",\r\n" + 
			"          \"value\": \"No\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 115,\r\n" + 
			"          \"name\": \"Developer\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": [\r\n" + 
			"            \"Floris Coetzee\"\r\n" + 
			"          ]\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 146,\r\n" + 
			"          \"name\": \"Back End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 147,\r\n" + 
			"          \"name\": \"Front End Components\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 148,\r\n" + 
			"          \"name\": \"XSI Files\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 177,\r\n" + 
			"          \"name\": \"Scripts\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 178,\r\n" + 
			"          \"name\": \"Applications or Client Tools\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 247,\r\n" + 
			"          \"name\": \"Completed Date\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 287,\r\n" + 
			"          \"name\": \"Crucible Reviewers\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 288,\r\n" + 
			"          \"name\": \"Crucible No.\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 827,\r\n" + 
			"          \"name\": \"QA Testing Assignee\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 854,\r\n" + 
			"          \"name\": \"Old Project\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 855,\r\n" + 
			"          \"name\": \"FE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 856,\r\n" + 
			"          \"name\": \"BE Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 857,\r\n" + 
			"          \"name\": \"SCC Dev Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 858,\r\n" + 
			"          \"name\": \"FE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 859,\r\n" + 
			"          \"name\": \"BE Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 860,\r\n" + 
			"          \"name\": \"SCC Test Estimate (days)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 903,\r\n" + 
			"          \"name\": \"Needed in R6.0.6++?\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 906,\r\n" + 
			"          \"name\": \"Regression Scope (Developers)\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 939,\r\n" + 
			"          \"name\": \"Code Review Status\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 938,\r\n" + 
			"          \"name\": \"Code Reviewed by (BB&D)\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 935,\r\n" + 
			"          \"name\": \"Code Reviewed on Branch\",\r\n" + 
			"          \"multiple\": true,\r\n" + 
			"          \"value\": []\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"          \"id\": 936,\r\n" + 
			"          \"name\": \"Code Review Notes\",\r\n" + 
			"          \"value\": \"\"\r\n" + 
			"        }\r\n" + 
			"      ],\r\n" + 
			"      \"created_on\": \"2016-03-10T10:08:47Z\",\r\n" + 
			"      \"updated_on\": \"2016-08-10T07:46:21Z\"\r\n" + 
			"    }\r\n" + 
			"  ],\r\n" + 
			"  \"total_count\": 100,\r\n" + 
			"  \"offset\": 0,\r\n" + 
			"  \"limit\": 25\r\n" + 
			"}";
}
