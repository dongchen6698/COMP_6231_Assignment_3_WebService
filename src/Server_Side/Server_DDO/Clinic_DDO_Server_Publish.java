package Server_Side.Server_DDO;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.xml.ws.Endpoint;

import Client_Side.ManagerClients;


public class Clinic_DDO_Server_Publish {
	public static void main(String[] args) {
		System.out.println("Initial Logger Of Server DDO...");
		initLogger(Config_DDO.SERVER_NAME);
		System.out.println("Initial UDP Listener Of Server DDO...");
		openUDPListener();
		System.out.println("Publish Web Service Of Server DDO...");
		publishService();
	}
	
	/**
	 * Initial the Logger function.
	 * @param server_name
	 */
	public static void initLogger(String server_name){
		try {
			String dir = "Server_Side_Log/";
			Config_DDO.LOGGER = Logger.getLogger(ManagerClients.class.getName());
			Config_DDO.LOGGER.setUseParentHandlers(false);
			Config_DDO.FH = new FileHandler(dir+server_name+".log",true);
			Config_DDO.LOGGER.addHandler(Config_DDO.FH);
			SimpleFormatter formatter = new SimpleFormatter();
			Config_DDO.FH.setFormatter(formatter);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Open UDP Listener to receive message from other server.
	 */
	public static void openUDPListener(){
		Thread udp_listener = new Thread(new Clinic_DDO_UDP_Listener());
		udp_listener.start();
	}
	
	public static void publishService(){
		// http://localhost:9003/server_ddo
		Endpoint endpoint = Endpoint.publish("http://localhost:"+Config_DDO.WEB_SERVICE_PORT+"/"+Config_DDO.SERVER_NAME, new Clinic_DDO_Impl());
		System.out.println("Status of publish MTL Web Service: " + endpoint.isPublished());
	}
	
	
}
