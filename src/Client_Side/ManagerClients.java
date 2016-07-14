package Client_Side;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Client_Side.Web_DDO.ClinicDDOImplService;
import Client_Side.Web_LVL.ClinicLVLImplService;
import Client_Side.Web_MTL.ClinicMTLImplService;

/**
 * This is a Client side of DSMS.
 * @author AlexChen
 *
 */
public class ManagerClients {
	
	/**
	 * this is a constructor of the class
	 */
	public ManagerClients() {
		super();
	}
	
	/**
	 * This is a local function for check manager format use Regular expression.
	 * @param n_managerID
	 * @return
	 */
	public static Boolean checkManagerIDFormat(String n_managerID){
		String pattern = "^(MTL|LVL|DDO)(\\d{5})$";
		Pattern re = Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
		Matcher matcher = re.matcher(n_managerID);
		if(matcher.find()){
			return true;
		}else{
			System.err.println("Usage:[MTL,LVL,DDO]+[10000]\n");
			return false;
		}
	}
	
	/**
	 * This is a loop for require user to input the managerID, like Login.
	 */
	public static void checkManagerLogIn(){
		Boolean valid = false;
		while(!valid){
			Scanner keyboard = new Scanner(System.in);
			do{
				System.out.println("****Please input the manager ID****");
				Config_Client.MANAGER_ID = keyboard.next();
			}while(!checkManagerIDFormat(Config_Client.MANAGER_ID));
			valid = true;
		}
	}
	
	/**
	 * This function is for check the prefix of managerID and send this managerID to specific server to check valid or not.
	 * @param n_managerID
	 * @return
	 */
	public static Boolean checkServerInfo(String n_managerID){
		DatagramSocket socket = null;
		String hostname = Config_Client.HOST;
		String requestcode = "001";
		int serverPort = 0;
		
		if(Config_Client.MANAGER_ID.substring(0, 3).equalsIgnoreCase("mtl")){
			serverPort = Config_Client.SERVER_PORT_MTL;
		}else if(Config_Client.MANAGER_ID.substring(0, 3).equalsIgnoreCase("lvl")){
			serverPort = Config_Client.SERVER_PORT_LVL;
		}else if(Config_Client.MANAGER_ID.substring(0, 3).equalsIgnoreCase("ddo")){
			serverPort = Config_Client.SERVER_PORT_DDO;
		}
		
	    try {
	    	socket = new DatagramSocket();
	    	byte[] message = (new String(requestcode+"\n"+n_managerID)).getBytes();
	    	InetAddress host = InetAddress.getByName(hostname);
	    	DatagramPacket request = new DatagramPacket(message, message.length, host, serverPort);
	    	socket.send(request);
	    	byte[] buffer = new byte[100];
	    	DatagramPacket reply = new DatagramPacket(buffer, buffer.length); 
	    	socket.receive(reply);
	    	String result = new String(reply.getData()).trim();
	    	if(result.equals("valid")){
	    		System.out.println("Valid Account");
	    		return true;
	    	}else{
	    		System.out.println("Invalid Account");
	    		return false;
	    	}
	    }
	    catch(Exception e){
	    	System.out.println("Socket: " + e.getMessage()); 
	    	}
		finally{
			if(socket != null){
				socket.close();
				}
			}
		return null; 
	}
	
	/**
	 * If managerID is valid, this function is for get the stub of that server.
	 * @param managerID
	 * @return
	 * @throws Exception
	 */
	public static Client_Side.Web_MTL.ClinicServersInterface getServerReferrence(String managerID){
		try {
			if(managerID.substring(0, 3).equalsIgnoreCase("mtl")){
				ClinicMTLImplService mtl_service = new ClinicMTLImplService();
				Client_Side.Web_MTL.ClinicServersInterface mtl_port = mtl_service.getClinicMTLImplPort();
				return mtl_port;
				
//			}else if(managerID.substring(0, 3).equalsIgnoreCase("lvl")){
//				ClinicLVLImplService lvl_service = new ClinicLVLImplService();
//				Client_Side.Web_LVL.ClinicServersInterface lvl_port = lvl_service.getClinicLVLImplPort();
//				return lvl_port;
//				
//			}else if(managerID.substring(0, 3).equalsIgnoreCase("ddo")){
//				ClinicDDOImplService ddo_service = new ClinicDDOImplService();
//				Client_Side.Web_DDO.ClinicServersInterface ddo_port = ddo_service.getClinicDDOImplPort();
//				return ddo_port;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	
	/**
	 * Define the Menu list.
	 * @param managerID
	 */
	public static void showMenu(String managerID) {
		System.out.println("****Welcome to DSMS****");
		System.out.println("****Manager: "+managerID +"****\n");
		System.out.println("Please select an option (1-5)");
		System.out.println("1. Create Doctor Record.");
		System.out.println("2. Create Nurse Record");
		System.out.println("3. Get Record Counts");
		System.out.println("4. Edit Record");
		System.out.println("5. Transfer Record");
		System.out.println("6. Exit DSMS");
	}
	
	/**
	 * Initial the Logger function.
	 * @param server_name
	 */
	public static void initLogger(String managerID){
		try {
			String dir = "Client_Side_Log/";
			Config_Client.LOGGER = Logger.getLogger(ManagerClients.class.getName());
			Config_Client.LOGGER.setUseParentHandlers(false);
			Config_Client.FH = new FileHandler(dir+managerID+".log",true);
			Config_Client.LOGGER.addHandler(Config_Client.FH);
			SimpleFormatter formatter = new SimpleFormatter();
			Config_Client.FH.setFormatter(formatter);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		checkManagerLogIn();
		while(!checkServerInfo(Config_Client.MANAGER_ID)){
			System.err.println("ManagerID is not right !\n");
			checkManagerLogIn();
		};
		initLogger(Config_Client.MANAGER_ID);
		Config_Client.LOGGER.info("ManagerID: "+ Config_Client.MANAGER_ID + " log in DSMS.");
		
		try {
			Config_Client.DSMS_IMPL = getServerReferrence(Config_Client.MANAGER_ID);
			int userChoice=0;
			Scanner keyboard = new Scanner(System.in);
			showMenu(Config_Client.MANAGER_ID);
			
			while(true)
			{
				Boolean valid = false;
				while(!valid)
				{
					try{
						userChoice=keyboard.nextInt();
						valid=true;
					}
					catch(Exception e)
					{
						System.out.println("Invalid Input, please enter an Integer");
						valid=false;
						keyboard.nextLine();
					}
				}
				
				switch(userChoice)
				{
				case 1: 
					Config_Client.LOGGER.info("Manager Choose Creat Doctor Record.");
					System.out.println("Please input the FirstName");
					String d_firstname = keyboard.next();
					System.out.println("Please input the LastName");
					String d_lastname = keyboard.next();
					System.out.println("Please input the Address");
					String d_address = keyboard.next();
					System.out.println("Please input the Phone");
					String d_phone = keyboard.next();
					System.out.println("Please input the Specialization");
					String d_specialization = keyboard.next();
					System.out.println("Please input the Location(mtl/lvl/ddo)");
					String d_location =keyboard.next();
					String d_result = Config_Client.DSMS_IMPL.createDRecord(Config_Client.MANAGER_ID, d_firstname, d_lastname, d_address, d_phone, d_specialization, d_location);
					System.out.println(d_result);
					if(!d_result.contains("is not right")){
						Config_Client.LOGGER.info("Manager Creat Doctor Record Succeed!" + "\n" + d_result);
					}
					showMenu(Config_Client.MANAGER_ID);
					break;
				case 2:
					Config_Client.LOGGER.info("Manager Choose Creat Nurse Record.");
					System.out.println("Please input the FirstName");
					String n_firstname = keyboard.next();
					System.out.println("Please input the LastName");
					String n_lastname = keyboard.next();
					System.out.println("Please input the Designation(junior/senior)");
					String n_designation = keyboard.next();
					System.out.println("Please input the Status(active/terminated)");
					String n_status = keyboard.next();
					System.out.println("Please input the Status Date(yyyy/mm/dd/)");
					String n_status_date = keyboard.next();
					String n_result = Config_Client.DSMS_IMPL.createNRecord(Config_Client.MANAGER_ID ,n_firstname, n_lastname, n_designation, n_status, n_status_date);
					System.out.println(n_result);
					if(!n_result.contains("is not right")){
						Config_Client.LOGGER.info("Manager Creat Doctor Record Succeed!" + "\n" + n_result);
					}
					showMenu(Config_Client.MANAGER_ID);
					break;
				case 3:
					Config_Client.LOGGER.info("Manager Choose Get Record Counts.");
					System.out.println("Please input search type");
					String searchtype = keyboard.next();
					String s_result = Config_Client.DSMS_IMPL.getRecordCounts(Config_Client.MANAGER_ID, searchtype);
					System.out.println(s_result);
					Config_Client.LOGGER.info("Get Record Counts: " + "\n" + s_result);
					showMenu(Config_Client.MANAGER_ID);
					break;
				case 4:
					Config_Client.LOGGER.info("Manager Choose Edit Record.");
					System.out.println("Please input the RecordID");
					String e_recordID = keyboard.next();
					System.out.println("Please input the FieldName");
					String e_fieldname = keyboard.next();
					System.out.println("Please input the New Value");
					String e_newvalue = keyboard.next();
					String e_result = Config_Client.DSMS_IMPL.editRecord(Config_Client.MANAGER_ID, e_recordID, e_fieldname, e_newvalue);
					System.out.println(e_result);
					if(!e_result.contains("is not right")){
						Config_Client.LOGGER.info("Manager Creat Doctor Record Succeed!" + "\n" + e_result);
					}
					showMenu(Config_Client.MANAGER_ID);
					break;
				case 5:
					Config_Client.LOGGER.info("Manager Choose Transfer Record.");
					System.out.println("Please input the RecordID");
					String t_recordID = keyboard.next();
					System.out.println("Please input the remote clinic server name.(mtl/lvl/ddo)");
					String t_remoteClinicServerName = keyboard.next();
					String t_result = Config_Client.DSMS_IMPL.transferRecord(Config_Client.MANAGER_ID, t_recordID, t_remoteClinicServerName);
					System.out.println(t_result);
					if(!t_result.contains("is not right")){
						Config_Client.LOGGER.info("Manager Transfer Record Succeed!" + "\n" + t_result);
					}
					showMenu(Config_Client.MANAGER_ID);
					break;
				case 6:
					Config_Client.LOGGER.info("Manager Exit the DSMS");
					System.out.println("Have a nice day!");
					keyboard.close();
					System.exit(0);
				default:
					System.out.println("Invalid Input, please try again.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
}
