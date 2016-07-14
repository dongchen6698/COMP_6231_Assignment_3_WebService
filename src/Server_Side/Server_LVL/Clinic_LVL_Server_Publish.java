package Server_Side.Server_LVL;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.xml.ws.Endpoint;

import Client_Side.ManagerClients;


public class Clinic_LVL_Server_Publish {
	public static void main(String[] args) {
		System.out.println("Initial Logger Of Server Laval...");
		initLogger(Config_LVL.SERVER_NAME);
		System.out.println("Initial UDP Listener Of Server Laval...");
		openUDPListener();
		System.out.println("Publish Web Service Of Server Laval...");
		publishService();
	}
	
	/**
	 * Initial the Logger function.
	 * @param server_name
	 */
	public static void initLogger(String server_name){
		try {
			String dir = "Server_Side_Log/";
			Config_LVL.LOGGER = Logger.getLogger(ManagerClients.class.getName());
			Config_LVL.LOGGER.setUseParentHandlers(false);
			Config_LVL.FH = new FileHandler(dir+server_name+".log",true);
			Config_LVL.LOGGER.addHandler(Config_LVL.FH);
			SimpleFormatter formatter = new SimpleFormatter();
			Config_LVL.FH.setFormatter(formatter);
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
		Thread udp_listener = new Thread(new Clinic_LVL_UDP_Listener());
		udp_listener.start();
	}
	
	public static void publishService(){
		// http://localhost:9002/server_lvl
		Endpoint endpoint = Endpoint.publish("http://localhost:"+Config_LVL.WEB_SERVICE_PORT+"/"+Config_LVL.SERVER_NAME, new Clinic_LVL_Impl());
		System.out.println("Status of publish MTL Web Service: " + endpoint.isPublished());
	}
	
	
}
