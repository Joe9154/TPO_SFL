package application;

import java.util.ArrayList;
import java.util.List;


public class Data {
	List<String[]> content = new ArrayList<String[]>();
	List<String[]> employees = new ArrayList<String[]>();
	List<String[]> shipments = new ArrayList<String[]>();
	public static String user;
	
	public Data() {
		setupParcelData();
		setupShipmentData();
	}
	
	// *** test data ***
	void setupParcelData() {
		String id, tracking_no, weight, dimensions, status, action;
		id = "0045";
		tracking_no = "YT72760621444007800";
		weight = "2.53";
		dimensions = "12.3 x 10.5 x 5.0";
		status = "Pending";
		action = "None"; // Delivery driver -> None, Handover, Cancelled
		String[][] temp_content = {	{id+"1", tracking_no, weight, dimensions, status, action},
							  		{id+"2", tracking_no, weight, dimensions, status, action},
							  		{id+"3", tracking_no, weight, dimensions, status, action},
							  		{id+"4", tracking_no, weight, dimensions, status, action},
							  		{id+"5", tracking_no, weight, dimensions, status, action},
							  		{id+"5", tracking_no, weight, dimensions, status, action},
							  		{id+"6", tracking_no, weight, dimensions, status, action},
							  		{id+"7", tracking_no, weight, dimensions, status, action},
							  		{id+"8", tracking_no, weight, dimensions, status, action},
							  		{id+"9", tracking_no, weight, dimensions, status, action},
							  		{id+"10", tracking_no, weight, dimensions, status, action},
							  		{id+"11", tracking_no, weight, dimensions, status, action},
							  		{id+"12", tracking_no, weight, dimensions, status, action},
							  		{id+"13", tracking_no, weight, dimensions, status, action},
							  		{id+"14", tracking_no, weight, dimensions, status, action},
							  		{id+"15", tracking_no, weight, dimensions, status, action},
							 	};
		
		
		
		
		for (String[] parcel : temp_content) {
			content.add(parcel);
		}

	}
	// *** test data ***
	void setupShipmentData() {
		String id, no_of_parcels, net_weight, status;
		id = "04";
		no_of_parcels = "23";
		net_weight = "22.5";
		status = "None";

		String[][] temp_content = {	{id+"1", no_of_parcels, net_weight, status},
							  		{id+"2", no_of_parcels, net_weight, status},
							  		{id+"3", no_of_parcels, net_weight, status},
							  		{id+"4", no_of_parcels, net_weight, status},
							  		{id+"5", no_of_parcels, net_weight, status},
							  		{id+"5", no_of_parcels, net_weight, status},
							  		{id+"6", no_of_parcels, net_weight, status},
							  		{id+"7", no_of_parcels, net_weight, status},
							  		{id+"8", no_of_parcels, net_weight, status},
							  		{id+"9", no_of_parcels, net_weight, status},
							  		{id+"10", no_of_parcels, net_weight, status},
							  		{id+"11", no_of_parcels, net_weight, status},
							  		{id+"12", no_of_parcels, net_weight, status},
							  		{id+"13", no_of_parcels, net_weight, status},
							  		{id+"14", no_of_parcels, net_weight, status},
							  		{id+"15", no_of_parcels, net_weight, status},
							 	};
		
		
		
		
		for (String[] shipment : temp_content) {
			shipments.add(shipment);
		}

	}
	
	


	// Funkcija vrne pošiljke v formatu: 
	// String[] parcel = {id, tracking_no, weight, dimensions, status};   // <--vsi podatkovni tipi so String
	// v ArrayList-u.
	//
	// Funkcija vrne samo 7 pošiljk (ker jih gre toliko na eno stran). Katere pošiljke je odvisno od argumenta 'page':
	//    --> page 0: pošiljke 0-6, page 1: pošiljke 7-13, page 2: pošiljke 14-20, itd..
	
	public List<String[]> getParcelDataByPage(int page) { 
		int from = page * 7; // *7 because we can fit 7 elements per page
		int to; 
		if(content.size() >= page * 7 + 7) {
			to = page * 7 + 7;
		}else { // if we're on the last page
			to = content.size();
		}
		
		return content.subList(from, to); 
	}
	
	// for Order Confirmation Specialist
	public List<String[]> getParcelDataOrderConfirmationSpecialistByPage(int page) { 
		int from = page * 7; // *7 because we can fit 7 elements per page
		int to; 
		if(content.size() >= page * 7 + 7) {
			to = page * 7 + 7;
		}else { // if we're on the last page
			to = content.size();
		}
		
		return content.subList(from, to); 
	}
	
	// for Delivery Driver - Delivery Cargo Info
	public List<String[]> getShipmentDataByPage(int page){
		int from = page * 7; // *7 because we can fit 7 elements per page
		int to; 
		if(shipments.size() >= page * 7 + 7) {
			to = page * 7 + 7;
		}else { // if we're on the last page
			to = shipments.size();
		}
		
		return shipments.subList(from, to); 
	}
	
	// type is "Cargo Departing Info" or "Cargo Arrival Info"
	// for International Driver
	public List<String[]> getShipmentDataByTypeByPage(String type, int page){
		int from = page * 7; // *7 because we can fit 7 elements per page
		int to; 
		if(shipments.size() >= page * 7 + 7) {
			to = page * 7 + 7;
		}else { // if we're on the last page
			to = shipments.size();
		}
		
		return shipments.subList(from, to); 
	}
	
	
	
	// Ta funkcija se izvede ko uporabnik spremeni status pošiljke.
	// Funkcija dobi kot vhodni argument ID pošiljke in pa nov status.
	public void statusChanged(String parcelID, String status) {
		System.out.println(parcelID + " " + status);
		// primer: 00451 Processed
	}
	

	// Ta funkcija vrne pošiljke filterane po zaposlenemu. Ozirama vse če je employee == "All".
	public List<String[]> getParcelDataByPageByEmployee(String employee, int page){
		int from = page * 7; // *7 because we can fit 7 elements per page
		int to; 
		if(content.size() >= page * 7 + 7) {
			to = page * 7 + 7;
		}else { // if we're on the last page
			to = content.size();
		}
		return content.subList(from, to); 
	}
	
	public String[] getEmployeesArray() {
		String[] employees = {"Bob", "Jack", "Darcy"};
		return employees;
		
	} 
	
	public String[] getEmployeesByBranchArray(String branch) {
		String[] employees = {"Michael", "Johnny", "Bobby"};
		return employees;
		
	}
	
	public String getNoOfJobsOfEmployee(String employee, String branch) {
		return "2";
	}
	
	
	// Returns userID (String) if correct, or "false" (String) if incorrect
	public String verifyUsernameAndPassword(String username, String password) {
	
		if (new String("a").equals(username)) return "014";
		if (new String("b").equals(username)) return "015";
		if (new String("c").equals(username)) return "016";
		if (new String("d").equals(username)) return "017";
		if (new String("e").equals(username)) return "018";
		if (new String("f").equals(username)) return "019";
		
		return "false";
	}
	
	
	// function returns image.png of the user
	// UserID is in 'user' static variable
	public String getUserProfilePicture() {
		String usericons[] = {"User icon.png", "User icon2.png", "User icon3.png", "User icon4.png", "User icon5.png", "User icon6.png"};
		
		switch(user) {
			case "014": return usericons[0];
			case "015": return usericons[1];
			case "016": return usericons[2];
			case "017": return usericons[3];
			case "018": return usericons[4];
			case "019": return usericons[5];
		}
		return usericons[0];
	}
	public String getUserFullName() {
		System.out.println("in data class: " + user);
		String users[] = {"Jeff McJeff", "Bobby Cee", "Michael Lee", "Bobby Chow", "Leo Black", "Johnny Ray"};
		switch(user) {
			case "014": return users[0];
			case "015": return users[1];
			case "016": return users[2];
			case "017": return users[3];
			case "018": return users[4];
			case "019": return users[5];
		}
		return users[0];
	}
	
	// za Logistic Agent
	public String[] getEmployeesDriversArray() {
		String[] employees = {"Joe", "Jack", "Bob"};
		return employees;
		
	}
	
	// za Logistic Agent
	public String[] getBranchesArray() {
		String[] branches = {"Munich", "Ljubljana", "Vienna"};
		return branches;
		
	}
	
	// za Logistic Agent
	public String[] getBranchData(String branch) {
		// inbound, outbound, branch load, average load, all jobs for drivers,
		// no. of drivers, avg. no. of jobs per driver
		String[] branchData = {"4.512", "1.332", "24", "3", "242", "32", "2.4"};
		return branchData;
	}
	
	// za Logistic Agent
	public boolean isEnoughDriversInThisBranch(String branch) {
		return false;
	}
	
	// Warehouse manager - data for 'stats' view
	public String getNumberOfAllPackages() {
		return "20.451";
	}
	// Warehouse manager - data for 'stats' view
	public String getNumberOfPendingPackages() {
		return "2.214";
	}
	// Warehouse manager - data for 'stats' view
	public String getNumberOfProcessedPackages() {
		return "17.234";
	}
	
	// Warehouse manager -  data for employees view
	public List<String[]> getEmployees(){
		String[][] employees_temp = {
								    {"1", "Bob Marley", "", "Warehouse Agent", ""},
									{"2", "Bob Ross", "", "Warehouse Manager", ""},
									{"3", "Joe Mama", "", "Delivery Driver", ""},
									{"4", "Slim Shady", "", "International Driver", ""},
									};
		for (String[] employee : employees_temp) {
			employees.add(employee);
		}
		return employees;
	}
	
	public void deliveryDriverAction(String action, String value) {
		System.out.println(action + " " + value);
	}
	
	
	// funkcija se izvede ko Order conf. specialist ustvari novo pošiljko
	public void createNewParcel(String _sender, String _senderStreetName, String _senderStreetNumber, String _senderCityCode, String _senderCityName, String _senderCountryCode, String _senderID, String _rec, String _recStreetName, String _recStreetNumber, String _recCityCode, String _recCityName, String _recCountryCode, String _recID, String _weight, String _height, String _width, String _depth) {
		System.out.println("created new parcel! ");
		System.out.println(_sender + _senderStreetName+ _rec+ _recStreetName+ _weight+ _height+ _depth);
		
	}
}
