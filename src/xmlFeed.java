
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.amazonaws.mws.MarketplaceWebService;
import com.amazonaws.mws.MarketplaceWebServiceClient;
import com.amazonaws.mws.MarketplaceWebServiceConfig;
import com.amazonaws.mws.MarketplaceWebServiceException;
import com.amazonaws.mws.model.FeedSubmissionInfo;
import com.amazonaws.mws.model.GetReportRequest;
import com.amazonaws.mws.model.GetReportRequestListRequest;
import com.amazonaws.mws.model.GetReportRequestListResponse;
import com.amazonaws.mws.model.GetReportRequestListResult;
import com.amazonaws.mws.model.GetReportResponse;
import com.amazonaws.mws.model.IdList;
import com.amazonaws.mws.model.ReportRequestInfo;
import com.amazonaws.mws.model.RequestReportRequest;
import com.amazonaws.mws.model.RequestReportResponse;
import com.amazonaws.mws.model.RequestReportResult;
import com.amazonaws.mws.model.ResponseMetadata;
import com.amazonaws.mws.model.SubmitFeedRequest;
import com.amazonaws.mws.model.SubmitFeedResponse;
import com.amazonaws.mws.model.SubmitFeedResult;
import com.amazonservices.mws.products.MarketplaceWebServiceProductsClient;
import com.amazonservices.mws.products.model.FeesEstimateRequest;
import com.amazonservices.mws.products.model.FeesEstimateRequestList;
import com.amazonservices.mws.products.model.GetLowestPricedOffersForASINRequest;
import com.amazonservices.mws.products.model.GetMatchingProductForIdRequest;
import com.amazonservices.mws.products.model.GetMyFeesEstimateRequest;
import com.amazonservices.mws.products.model.IdListType;
import com.amazonservices.mws.products.model.MoneyType;
import com.amazonservices.mws.products.model.PriceToEstimateFees;
import com.amazonservices.mws.products.samples.GetLowestPricedOffersForASINSample;
import com.amazonservices.mws.products.samples.GetMatchingProductForIdSample;
import com.amazonservices.mws.products.samples.GetMyFeesEstimateSample;
import com.amazonservices.mws.products.samples.MarketplaceWebServiceProductsSampleConfig;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class xmlFeed {
	
    public static void invokeRequestReport(MarketplaceWebService service, RequestReportRequest request) {
        try {
            
            RequestReportResponse response = service.requestReport(request);

            
            System.out.println ("RequestReport Action Response");
            System.out.println ("=============================================================================");
            System.out.println ();

            System.out.print("    RequestReportResponse");
            System.out.println();
            if (response.isSetRequestReportResult()) {
                System.out.print("        RequestReportResult");
                System.out.println();
                RequestReportResult  requestReportResult = response.getRequestReportResult();
                if (requestReportResult.isSetReportRequestInfo()) {
                    System.out.print("            ReportRequestInfo");
                    System.out.println();
                    ReportRequestInfo  reportRequestInfo = requestReportResult.getReportRequestInfo();
                    if (reportRequestInfo.isSetReportRequestId()) {
                        System.out.print("                ReportRequestId");
                        System.out.println();
                        System.out.print("                    " + reportRequestInfo.getReportRequestId());
                        System.out.println();
                    }
                    if (reportRequestInfo.isSetReportType()) {
                        System.out.print("                ReportType");
                        System.out.println();
                        System.out.print("                    " + reportRequestInfo.getReportType());
                        System.out.println();
                    }
                    if (reportRequestInfo.isSetStartDate()) {
                        System.out.print("                StartDate");
                        System.out.println();
                        System.out.print("                    " + reportRequestInfo.getStartDate());
                        System.out.println();
                    }
                    if (reportRequestInfo.isSetEndDate()) {
                        System.out.print("                EndDate");
                        System.out.println();
                        System.out.print("                    " + reportRequestInfo.getEndDate());
                        System.out.println();
                    }
                    if (reportRequestInfo.isSetSubmittedDate()) {
                        System.out.print("                SubmittedDate");
                        System.out.println();
                        System.out.print("                    " + reportRequestInfo.getSubmittedDate());
                        System.out.println();
                    }
                    if (reportRequestInfo.isSetReportProcessingStatus()) {
                        System.out.print("                ReportProcessingStatus");
                        System.out.println();
                        System.out.print("                    " + reportRequestInfo.getReportProcessingStatus());
                        System.out.println();
                    }
                } 
            } 
            if (response.isSetResponseMetadata()) {
                System.out.print("        ResponseMetadata");
                System.out.println();
                ResponseMetadata  responseMetadata = response.getResponseMetadata();
                if (responseMetadata.isSetRequestId()) {
                    System.out.print("            RequestId");
                    System.out.println();
                    System.out.print("                " + responseMetadata.getRequestId());
                    System.out.println();
                }
            } 
            System.out.println();
            System.out.println(response.getResponseHeaderMetadata());
            System.out.println();

           
        } catch (MarketplaceWebServiceException ex) {
            
            System.out.println("Caught Exception: " + ex.getMessage());
            System.out.println("Response Status Code: " + ex.getStatusCode());
            System.out.println("Error Code: " + ex.getErrorCode());
            System.out.println("Error Type: " + ex.getErrorType());
            System.out.println("Request ID: " + ex.getRequestId());
            System.out.print("XML: " + ex.getXML());
            System.out.println("ResponseHeaderMetadata: " + ex.getResponseHeaderMetadata());
        }
    }
    
    public static void invokeGetReportRequestList(MarketplaceWebService service, GetReportRequestListRequest request) {
        try {

            GetReportRequestListResponse response = service.getReportRequestList(request);
            

            System.out.println ("GetReportRequestList Action Response");
            System.out.println ("=============================================================================");
            System.out.println ();

            System.out.print("    GetReportRequestListResponse");
            System.out.println();
            if (response.isSetGetReportRequestListResult()) {
                System.out.print("        GetReportRequestListResult");
                System.out.println();
                GetReportRequestListResult  getReportRequestListResult = response.getGetReportRequestListResult();
                if (getReportRequestListResult.isSetNextToken()) {
                    System.out.print("            NextToken");
                    System.out.println();
                    System.out.print("                " + getReportRequestListResult.getNextToken());
                    System.out.println();
                }
                if (getReportRequestListResult.isSetHasNext()) {
                    System.out.print("            HasNext");
                    System.out.println();
                    System.out.print("                " + getReportRequestListResult.isHasNext());
                    System.out.println();
                }
                java.util.List<ReportRequestInfo> reportRequestInfoList = getReportRequestListResult.getReportRequestInfoList();
                for (ReportRequestInfo reportRequestInfo : reportRequestInfoList) {
                    System.out.print("            ReportRequestInfo");
                    System.out.println();
                    if (reportRequestInfo.isSetReportRequestId()) {
                        System.out.print("                ReportRequestId");
                        System.out.println();
                        System.out.print("                    " + reportRequestInfo.getReportRequestId());
                        System.out.println();
                    }
                    if (reportRequestInfo.isSetReportType()) {
                        System.out.print("                ReportType");
                        System.out.println();
                        System.out.print("                    " + reportRequestInfo.getReportType());
                        System.out.println();
                    }
                    if (reportRequestInfo.isSetStartDate()) {
                        System.out.print("                StartDate");
                        System.out.println();
                        System.out.print("                    " + reportRequestInfo.getStartDate());
                        System.out.println();
                    }
                    if (reportRequestInfo.isSetEndDate()) {
                        System.out.print("                EndDate");
                        System.out.println();
                        System.out.print("                    " + reportRequestInfo.getEndDate());
                        System.out.println();
                    }
                    if (reportRequestInfo.isSetSubmittedDate()) {
                        System.out.print("                SubmittedDate");
                        System.out.println();
                        System.out.print("                    " + reportRequestInfo.getSubmittedDate());
                        System.out.println();
                    }
                    if (reportRequestInfo.isSetCompletedDate()) {
                        System.out.print("                CompletedDate");
                        System.out.println();
                        System.out.print("                    " + reportRequestInfo.getCompletedDate());
                        System.out.println();
                    }                    
                    if (reportRequestInfo.isSetReportProcessingStatus()) {
                        System.out.print("                ReportProcessingStatus");
                        System.out.println();
                        System.out.print("                    " + reportRequestInfo.getReportProcessingStatus());
                        System.out.println();
                    }
                    if (reportRequestInfo.isSetGeneratedReportId()){
                    	System.out.print(reportRequestInfo.getGeneratedReportId());
                    }
                }
            } 
            if (response.isSetResponseMetadata()) {
                System.out.print("        ResponseMetadata");
                System.out.println();
                ResponseMetadata  responseMetadata = response.getResponseMetadata();
                if (responseMetadata.isSetRequestId()) {
                    System.out.print("            RequestId");
                    System.out.println();
                    System.out.print("                " + responseMetadata.getRequestId());
                    System.out.println();
                }
            } 
            System.out.println();
            System.out.println(response.getResponseHeaderMetadata());
            System.out.println();


        } catch (MarketplaceWebServiceException ex) {

            System.out.println("Caught Exception: " + ex.getMessage());
            System.out.println("Response Status Code: " + ex.getStatusCode());
            System.out.println("Error Code: " + ex.getErrorCode());
            System.out.println("Error Type: " + ex.getErrorType());
            System.out.println("Request ID: " + ex.getRequestId());
            System.out.print("XML: " + ex.getXML());
            System.out.println("ResponseHeaderMetadata: " + ex.getResponseHeaderMetadata());
        }
    }
    
    
    public static void invokeGetReport(MarketplaceWebService service, GetReportRequest request) {
        try {

            GetReportResponse response = service.getReport(request);


            System.out.println ("GetReport Action Response");
            System.out.println ("=============================================================================");
            System.out.println ();

            System.out.print("    GetReportResponse");
            System.out.println();
            System.out.print("    GetReportResult");
            System.out.println();
            System.out.print("            MD5Checksum");
            System.out.println();
            System.out.print("                " + response.getGetReportResult().getMD5Checksum());
            System.out.println();
            if (response.isSetResponseMetadata()) {
                System.out.print("        ResponseMetadata");
                System.out.println();
                ResponseMetadata  responseMetadata = response.getResponseMetadata();
                if (responseMetadata.isSetRequestId()) {
                    System.out.print("            RequestId");
                    System.out.println();
                    System.out.print("                " + responseMetadata.getRequestId());
                    System.out.println();
                }
            } 
            System.out.println();

            System.out.println("Report");
            System.out.println ("=============================================================================");
            System.out.println();
            System.out.println( request.getReportOutputStream().toString() );
            System.out.println();

            System.out.println(response.getResponseHeaderMetadata());
            System.out.println();


        } catch (MarketplaceWebServiceException ex) {

            System.out.println("Caught Exception: " + ex.getMessage());
            System.out.println("Response Status Code: " + ex.getStatusCode());
            System.out.println("Error Code: " + ex.getErrorCode());
            System.out.println("Error Type: " + ex.getErrorType());
            System.out.println("Request ID: " + ex.getRequestId());
            System.out.print("XML: " + ex.getXML());
            System.out.println("ResponseHeaderMetadata: " + ex.getResponseHeaderMetadata());
        }
    }
	
	public static void invokeSubmitFeed(MarketplaceWebService service,
            SubmitFeedRequest request) {
        try {

            SubmitFeedResponse response = service.submitFeed(request);

            System.out.println("SubmitFeed Action Response");
            System.out
            .println("=============================================================================");
            System.out.println();

            System.out.print("    SubmitFeedResponse");
            System.out.println();
            if (response.isSetSubmitFeedResult()) {
                System.out.print("        SubmitFeedResult");
                System.out.println();
                SubmitFeedResult submitFeedResult = response
                .getSubmitFeedResult();
                if (submitFeedResult.isSetFeedSubmissionInfo()) {
                    System.out.print("            FeedSubmissionInfo");
                    System.out.println();
                    FeedSubmissionInfo feedSubmissionInfo = submitFeedResult
                    .getFeedSubmissionInfo();
                    if (feedSubmissionInfo.isSetFeedSubmissionId()) {
                        System.out.print("                FeedSubmissionId");
                        System.out.println();
                        System.out.print("                    "
                                + feedSubmissionInfo.getFeedSubmissionId());
                        System.out.println();
                    }
                    if (feedSubmissionInfo.isSetFeedType()) {
                        System.out.print("                FeedType");
                        System.out.println();
                        System.out.print("                    "
                                + feedSubmissionInfo.getFeedType());
                        System.out.println();
                    }
                    if (feedSubmissionInfo.isSetSubmittedDate()) {
                        System.out.print("                SubmittedDate");
                        System.out.println();
                        System.out.print("                    "
                                + feedSubmissionInfo.getSubmittedDate());
                        System.out.println();
                    }
                    if (feedSubmissionInfo.isSetFeedProcessingStatus()) {
                        System.out
                        .print("                FeedProcessingStatus");
                        System.out.println();
                        System.out.print("                    "
                                + feedSubmissionInfo.getFeedProcessingStatus());
                        System.out.println();
                    }
                    if (feedSubmissionInfo.isSetStartedProcessingDate()) {
                        System.out
                        .print("                StartedProcessingDate");
                        System.out.println();
                        System.out
                        .print("                    "
                                + feedSubmissionInfo
                                .getStartedProcessingDate());
                        System.out.println();
                    }
                    if (feedSubmissionInfo.isSetCompletedProcessingDate()) {
                        System.out
                        .print("                CompletedProcessingDate");
                        System.out.println();
                        System.out.print("                    "
                                + feedSubmissionInfo
                                .getCompletedProcessingDate());
                        System.out.println();
                    }
                }
            }
            if (response.isSetResponseMetadata()) {
                System.out.print("        ResponseMetadata");
                System.out.println();
                ResponseMetadata responseMetadata = response
                .getResponseMetadata();
                if (responseMetadata.isSetRequestId()) {
                    System.out.print("            RequestId");
                    System.out.println();
                    System.out.print("                "
                            + responseMetadata.getRequestId());
                    System.out.println();
                }
            }
            System.out.println(response.getResponseHeaderMetadata());
            System.out.println();
            System.out.println();

        } catch (MarketplaceWebServiceException ex) {

            System.out.println("Caught Exception: " + ex.getMessage());
            System.out.println("Response Status Code: " + ex.getStatusCode());
            System.out.println("Error Code: " + ex.getErrorCode());
            System.out.println("Error Type: " + ex.getErrorType());
            System.out.println("Request ID: " + ex.getRequestId());
            System.out.print("XML: " + ex.getXML());
            System.out.println("ResponseHeaderMetadata: " + ex.getResponseHeaderMetadata());
        }
    }
	
	public static String computeContentMD5Value( FileInputStream fis ) 
		    throws IOException, NoSuchAlgorithmException {

		    DigestInputStream dis = new DigestInputStream( fis,
		        MessageDigest.getInstance( "MD5" ));

		    byte[] buffer = new byte[8192];
		    while( dis.read( buffer ) > 0 );

		    String md5Content = new String(
		        org.apache.commons.codec.binary.Base64.encodeBase64(
		            dis.getMessageDigest().digest()) ); 

		    // Effectively resets the stream to be beginning of the file
		    // via a FileChannel.
		    fis.getChannel().position( 0 );

		    return md5Content;
		}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	@SuppressWarnings("null")
	public static void main(String[] args) throws Exception {
		File itemsFile = new File("./inventory.txt");
		File logsFile = new File("./logs.txt");
    	FileWriter logWriter = new FileWriter(logsFile, true);
    	BufferedWriter bufferedLogWriter = new BufferedWriter(logWriter);
		
    	FileWriter mpifw = new FileWriter(itemsFile);
    	BufferedWriter mpibfw = new BufferedWriter(mpifw);
    	
    	mpibfw.write("sku\tproduct-id\tproduct-id-type\tprice\tminimum-seller-allowed-price\tmaximum-seller-allowed-price\titem-condition\tquantity\tadd-delete\twill-ship-internationally\texpedited-shipping\titem-note\tfulfillment-center-id\tmerchant-shipping-group-name\tproduct_tax_code\n");
    	mpibfw.close();
   	  		
		int startingPoint = 0;		
		File spf = new File("./progressCounter.txt");
		FileReader spfr = new FileReader(spf);
		BufferedReader spbr = new BufferedReader(spfr);
		startingPoint = Integer.parseInt(spbr.readLine().trim());
		int endPoint = startingPoint + 50;
		
		URL url = new URL("http://www.puckator-dropship.co.uk/gifts/feed_xml_products.php?email=michaelbrand@ntlworld.com&passwd=m5PjTb1WGIiP&action=full");
		URL url2 = new URL("http://www.puckator-dropship.co.uk/gifts/out_of_stock.php?email=michaelbrand@ntlworld.com&passwd=m5PjTb1WGIiP&action=full");
		InputStream stream = url.openStream();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(stream);		
		String inventoryFilePath = "./inventory.txt";		
		
        final String accessKeyId = "AKIAIMDEW7A52MUKBJDA";
        final String secretAccessKey = "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";

        final String appName = "dropshipUtil";
        final String appVersion = "1.0";

        
        
        MarketplaceWebServiceConfig config = new MarketplaceWebServiceConfig();

        config.setServiceURL("https://mws.amazonservices.co.uk/");

        MarketplaceWebService service = new MarketplaceWebServiceClient(
                    accessKeyId, secretAccessKey, appName, appVersion, config);

        final String merchantId = "A3HVTA4MNUBNX3";
        final String sellerDevAuthToken = "<Merchant Developer MWS Auth Token>";

        final IdList marketplaces = new IdList(Arrays.asList(
        		"A1F83G8C2ARO7P"));
		
		
        RequestReportRequest request1 = new RequestReportRequest()
		        .withMerchant(merchantId)
		        .withMarketplaceIdList(marketplaces)
		        .withReportType("_GET_MERCHANT_LISTINGS_DATA_LITER_")
		        .withReportOptions("ShowSalesChannel=true");
        //request = request.withMWSAuthToken(sellerDevAuthToken);
        
        // demonstrates how to set the date range
		DatatypeFactory df = null;
		try {
			df = DatatypeFactory.newInstance();
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		XMLGregorianCalendar startDate = df
				.newXMLGregorianCalendar(new GregorianCalendar(2011, 1, 1));
		request1.setStartDate(startDate);
		
	    // @TODO: set additional request parameters here
		
		invokeRequestReport(service, request1);
		Thread.sleep(60000);
		RequestReportResponse response = service.requestReport(request1);
		RequestReportResult  requestReportResult = response.getRequestReportResult();
		ReportRequestInfo  reportRequestInfo = requestReportResult.getReportRequestInfo();
		
        GetReportRequestListRequest request2 = new GetReportRequestListRequest();
        request2.setMerchant( merchantId );
        //request.setMWSAuthToken(sellerDevAuthToken);

        // @TODO: set request parameters here
        
        request2.setMaxCount(1);
        IdList requestID = new IdList();
        requestID.withId(reportRequestInfo.getReportRequestId());
        request2.setReportRequestIdList(requestID);
        invokeGetReportRequestList(service, request2);
        Thread.sleep(60000);
        GetReportRequestListResponse response2 = service.getReportRequestList(request2);
        GetReportRequestListResult  getReportRequestListResult = response2.getGetReportRequestListResult();
        java.util.List<ReportRequestInfo> reportRequestInfoList = getReportRequestListResult.getReportRequestInfoList();
                
        GetReportRequest request3 = new GetReportRequest();
        
        for (ReportRequestInfo reportRequestInfo1 : reportRequestInfoList) {
        	request3.setReportId( reportRequestInfo1.getGeneratedReportId() );
        }
        
        request3.setMerchant( merchantId );
        //request.setMWSAuthToken(sellerDevAuthToken);

        

        // Note that depending on the type of report being downloaded, a report can reach 
        // sizes greater than 1GB. For this reason we recommend that you _always_ program to
        // MWS in a streaming fashion. Otherwise, as your business grows you may silently reach
        // the in-memory size limit and have to re-work your solution.
        //
        OutputStream report = new FileOutputStream( "./inventoryReport.csv" );
        request3.setReportOutputStream( report );

        invokeGetReport(service, request3);
        report.close();
        
		
		doc.getDocumentElement().normalize();
		
		//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

		NodeList nList = doc.getElementsByTagName("PRODUCT");
				
		List<String> SKUs = Files.readAllLines(Paths.get("./inventoryReport.csv"), Charset.forName("UTF-8"));
		List<String> tekboxSKUs = Files.readAllLines(Paths.get("./tekbox.txt"), Charset.forName("UTF-8"));
		
		for(String line:SKUs){
			  System.out.println(line.split("\t")[0]);
			};
		
		for (int a = 0; a < SKUs.size();a++){
			Boolean delete = true;
			
			for(int b = 0; b < nList.getLength();b++){
				Node nNode = nList.item(b);
				Element	eElement = (Element) nNode;
				
				if(eElement.getElementsByTagName("MODEL").item(0).getTextContent().trim().contains(SKUs.get(a).split("\t")[0].trim())){
					delete = false;
					System.out.println("Item is in stock still");
				}
			}
			
			for(int d = 0; d < tekboxSKUs.size();d++){
				if(SKUs.get(a).split("\t")[0].trim().contains(tekboxSKUs.get(d).trim())){
					delete = false;			
				}
			}	
					
			if(delete){						
				System.out.println("Item no longer in stock");
				File npif = new File(inventoryFilePath);
				FileWriter npifw = new FileWriter(npif, true);
				BufferedWriter npibfw = new BufferedWriter(npifw);
        	
				npibfw.write(SKUs.get(a).split("\t")[0] + "\t" + "\t" + "\t4\t" + "\t" + "\t\t\t11\t" + "\t" + "\tx\t6\t3\n");
				npibfw.close();	
			}
		}
		
		
								//nList.getLength()
								//startingPoint+199
		for (int temp = startingPoint; temp < endPoint; temp++) {			
			Node nNode = nList.item(temp);
			
			if(temp == nList.getLength()){
				startingPoint = 0;
				endPoint = 0;
				
		    	FileWriter spfw = new FileWriter(spf);
		    	BufferedWriter spfbw = new BufferedWriter(spfw);
		    	
		    	spfbw.write(Integer.toString(0));
		    	spfbw.close();
		    	
		    	break;
		    	//System.exit(0);				
			}
							
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;

				System.out.println("Model : " + eElement.getElementsByTagName("MODEL").item(0).getTextContent());
				System.out.println("EAN : " + eElement.getElementsByTagName("EAN").item(0).getTextContent());
				System.out.println("Name : " + eElement.getElementsByTagName("NAME").item(0).getTextContent());
				System.out.println("Description : " + eElement.getElementsByTagName("DESCRIPTION").item(0).getTextContent());
				System.out.println("Dimension : " + eElement.getElementsByTagName("DIMENSION").item(0).getTextContent());
				System.out.println("Price : " + eElement.getElementsByTagName("PRICE").item(0).getTextContent());
				System.out.println("Delivery : " + eElement.getElementsByTagName("DELIVERY").item(0).getTextContent());
				System.out.println("Quantity : " + eElement.getElementsByTagName("QUANTITY").item(0).getTextContent());
				System.out.println("URL : " + eElement.getElementsByTagName("URL").item(0).getTextContent());
				
				String itemSKU1 = eElement.getElementsByTagName("MODEL").item(0).getTextContent();
				String itemEAN = eElement.getElementsByTagName("EAN").item(0).getTextContent();
				String itemQuantity = eElement.getElementsByTagName("QUANTITY").item(0).getTextContent();
				
				MarketplaceWebServiceProductsClient client = MarketplaceWebServiceProductsSampleConfig.getClient();

		        // Create a request.
		        GetMatchingProductForIdRequest matchingProductRequest = new GetMatchingProductForIdRequest();
		        String sellerId = "A3HVTA4MNUBNX3";
		        matchingProductRequest.setSellerId(sellerId);
		        String mwsAuthToken = "AKIAIMDEW7A52MUKBJDA";
		        matchingProductRequest.setMWSAuthToken(mwsAuthToken);
		        String marketplaceId = "A1F83G8C2ARO7P";
		        matchingProductRequest.setMarketplaceId(marketplaceId);
		        String idType = "EAN";
		        matchingProductRequest.setIdType(idType);
		        IdListType idList = new IdListType();
		        idList.withId(eElement.getElementsByTagName("EAN").item(0).getTextContent());
		        matchingProductRequest.setIdList(idList);
		        
		        String amazonASIN = "";
		        try {
			        String matchingProductResponse = GetMatchingProductForIdSample.invokeGetMatchingProductForId(client, matchingProductRequest).toXML();
			        amazonASIN = matchingProductResponse.split("<ASIN>")[1].split("</ASIN>")[0];
		        } catch (Exception e) {
			    	FileWriter nsfw = new FileWriter(new File("./notOnAmazon.txt"),true);
			    	BufferedWriter nsbw = new BufferedWriter(nsfw);
			    	
			    	nsbw.write(itemSKU1 + " - " + eElement.getElementsByTagName("URL").item(0).getTextContent()+ "\n");
			    	nsbw.close();
		        	System.out.println(itemSKU1 + " not currently selling on Amazon");
		        	continue;
		        }
		        // Make the call.

		        //System.out.println(amazonASIN);	        
		        GetLowestPricedOffersForASINRequest lowestPricedRequest = new GetLowestPricedOffersForASINRequest();
		        lowestPricedRequest.setSellerId(sellerId);
		        lowestPricedRequest.setMWSAuthToken(mwsAuthToken);
		        lowestPricedRequest.setMarketplaceId(marketplaceId);
		        String asin = amazonASIN;
		        lowestPricedRequest.setASIN(asin);
		        String itemCondition = "NEW";
		        lowestPricedRequest.setItemCondition(itemCondition);
		        
		        String lowestPricedOffers = ""; 
	        	String lowestPrice = "";
		        // Make the call.
		        try {
		        	lowestPricedOffers = GetLowestPricedOffersForASINSample.invokeGetLowestPricedOffersForASIN(client, lowestPricedRequest).toXML();
		        	lowestPrice = lowestPricedOffers.split("<Amount>")[1].split("</Amount>")[0];
		        	System.out.println(lowestPrice);
		        } catch (Exception e){
		        	continue;
		        }
		        Double puckatorPriceExVAT = Double.parseDouble(eElement.getElementsByTagName("PRICE").item(0).getTextContent());
		        Double puckatorPriceWithVAT = puckatorPriceExVAT*1.2;
		        Double lowestAmazonPriceWithVAT = Double.parseDouble(lowestPrice);
		        Double deliveryCost;
		        Double amazonFees;
		        
		        switch(eElement.getElementsByTagName("DELIVERY").item(0).getTextContent()){
		        	
		        	case "Z":
		        		deliveryCost = 0.99;
		        		break;
		        		
		        	case "A":
		        		deliveryCost = 1.99;
		        		break;
		        	
		        	case "B":
		        		deliveryCost = 2.49;
		        		break;
		        		
		        	case "C":
		        		deliveryCost = 2.99;
		        		break;
		        		
		        	case "D":
		        		deliveryCost = 2.99;
		        		break;
		        		
		        	case "E":
		        		deliveryCost = 2.99;
		        		break;
		        		
		        	case "F":
		        		deliveryCost = 3.49;
		        		break;
		        	
		        	case "G":
		        		deliveryCost = 3.99;
		        		break;
		        	
		        	case "H":
		        		deliveryCost = 4.49;
		        		break;
		        	
		        	case "I":
		        		deliveryCost = 4.99;
		        		break;
		        		
		        	case "J":
		        		deliveryCost = 6.49;
		        		break;
		        		
		        	case "K":
		        		deliveryCost = 6.49;
		        		break;
		        	
		        	case "L":
		        		deliveryCost = 6.49;
		        		break;
		        		
		        	case "M":
		        		deliveryCost = 6.99;
		        		break;
		        		
		        	default:
		        		deliveryCost = 0.00;
		        		break;		       
		        }
		        
		        GetMyFeesEstimateRequest feesEstimateRequest = new GetMyFeesEstimateRequest();
		        feesEstimateRequest.setSellerId(sellerId);
		        feesEstimateRequest.setMWSAuthToken(mwsAuthToken);
		        FeesEstimateRequestList feesEstimateRequestList = new FeesEstimateRequestList();
		        FeesEstimateRequest productASIN = new FeesEstimateRequest();
		        productASIN.setIdType("ASIN");
		        productASIN.setIdValue(amazonASIN);
		        productASIN.setIdentifier("productASIN");
		        productASIN.setMarketplaceId("A1F83G8C2ARO7P");
		        PriceToEstimateFees price = new PriceToEstimateFees();
		        MoneyType myPrice = new MoneyType();
		        MoneyType shipping = new MoneyType();
		        myPrice.setAmount(new BigDecimal(puckatorPriceWithVAT));
		        myPrice.setCurrencyCode("GBP");
		        shipping.setAmount(new BigDecimal(deliveryCost));
		        shipping.setCurrencyCode("GBP");
		        price.setListingPrice(myPrice);
		        price.setShipping(shipping);
		        productASIN.setPriceToEstimateFees(price);;
		        feesEstimateRequestList.withFeesEstimateRequest(productASIN);		        
		        feesEstimateRequest.setFeesEstimateRequestList(feesEstimateRequestList);
		        
		        // Make the call.
		        String feeEstimate = GetMyFeesEstimateSample.invokeGetMyFeesEstimate(client, feesEstimateRequest).toXML();
		        amazonFees = Double.parseDouble(feeEstimate.split("<Amount>")[3].split("</Amount>")[0]);
		        Double totalCost = puckatorPriceWithVAT + deliveryCost + amazonFees;
		        
		        if(totalCost < lowestAmazonPriceWithVAT && Integer.parseInt(itemQuantity) > 50){
		        	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		        	Date dateNow = new Date();
		        	
		        	Double profits = lowestAmazonPriceWithVAT-totalCost;
		        	bufferedLogWriter.write(dateFormat.format(dateNow).toString() + " - Listing - " + itemSKU1 + " is profitable. My costs:" + puckatorPriceWithVAT.toString() + "+" + deliveryCost.toString() + "+" + amazonFees.toString() + "=" + totalCost.toString() + ". Amazon price: " + lowestAmazonPriceWithVAT.toString() + ". Profits: " + profits.toString() +"\n");
		        	//The item is profitable
		        	//Check if i'm already selling the item. If I am then update the price and quantity
		        	//If I'm not then list it
		        	File pif = new File(inventoryFilePath);
		        	FileWriter pifw = new FileWriter(pif, true);
		        	BufferedWriter pibfw = new BufferedWriter(pifw);
		        	
		        	pibfw.write(itemSKU1 + "\t" + itemEAN + "\t4\t" + lowestAmazonPriceWithVAT.toString() + "\t\t\t11\t" +  itemQuantity.toString() + "\ta\t6\t3\n");      
		        	pibfw.close();
		        			            		        	
		        	System.out.println("Item is profitable");
		        } else {
		        	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		        	Date dateNow = new Date();
		        	
		        	Double profits = lowestAmazonPriceWithVAT-totalCost;
		        	bufferedLogWriter.write(dateFormat.format(dateNow).toString() + " - Not Listing - " + itemSKU1 + " is not profitable. My costs:" + puckatorPriceWithVAT.toString() + "+" + deliveryCost.toString() + "+" + amazonFees.toString() + "=" + totalCost.toString() + ". Amazon price: " + lowestAmazonPriceWithVAT.toString() + ". Profits: " + profits.toString() +"\n");
		        	//The item's not profitable
		        	//Check if i'm selling it. If I am then de-list it
		        	File npif = new File(inventoryFilePath);
		        	FileWriter npifw = new FileWriter(npif, true);
		        	BufferedWriter npibfw = new BufferedWriter(npifw);
		        	
		        	npibfw.write(itemSKU1 + "\t" + itemEAN + "\t4\t" + lowestAmazonPriceWithVAT.toString() + "\t\t\t11\t" +  itemQuantity.toString() + "\tx\t6\t3\n");
		        	npibfw.close();		        	
		            	        	
		        	System.out.println("Item is not profitable");
		        }		      		        
			}	
		}
		
		final String accessKeyId1 = "AKIAIMDEW7A52MUKBJDA";
        final String secretAccessKey1 = "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";

        final String appName1 = "Dropship_Util";
        final String appVersion1 = "1.0";
	
        MarketplaceWebServiceConfig config1 = new MarketplaceWebServiceConfig();

        config.setServiceURL("https://mws.amazonservices.co.uk/");

        MarketplaceWebService service1 = new MarketplaceWebServiceClient(
                accessKeyId1, secretAccessKey1, appName1, appVersion1, config1);

        final String merchantId1 = "A3HVTA4MNUBNX3";
        final String sellerDevAuthToken1 = "AKIAIMDEW7A52MUKBJDA";

        final IdList marketplaces1 = new IdList(Arrays.asList("A1F83G8C2ARO7P"));

        FileInputStream flatFilep = new FileInputStream(inventoryFilePath);
        
        SubmitFeedRequest request11 = new SubmitFeedRequest();
        request11.setMerchant(merchantId);
        request11.setMWSAuthToken(sellerDevAuthToken);
        request11.setMarketplaceIdList(marketplaces);

        request11.setFeedType("_POST_FLAT_FILE_INVLOADER_DATA_");

        request11.setFeedContent(flatFilep);
        request11.setContentMD5(computeContentMD5Value(flatFilep));     

        invokeSubmitFeed(service, request11);       
		
    	FileWriter spfw = new FileWriter(spf);
    	BufferedWriter spfbw = new BufferedWriter(spfw);
    	
    	spfbw.write(Integer.toString(endPoint));
    	spfbw.close();
    	bufferedLogWriter.close();
	}
}