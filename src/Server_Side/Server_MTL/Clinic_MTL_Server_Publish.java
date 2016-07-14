package Server_Side.Server_MTL;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.xml.ws.Endpoint;

import Client_Side.ManagerClients;


public class Clinic_MTL_Server_Publish {
	public static void main(String[] args) {
		System.out.println("Initial Logger Of Server Montreal...");
		initLogger(Config_MTL.SERVER_NAME);
		System.out.println("Initial UDP Listener Of Server Montreal...");
		openUDPListener();
		System.out.println("Publish Web Service Of Server Montreal...");
		publishMTLService();
	}
	
	/**
	 * Initial the Logger function.
	 * @param server_name
	 */
	public static void initLogger(String server_name){
		try {
			String dir = "Server_Side_Log/";
			Config_MTL.LOGGER = Logger.getLogger(ManagerClients.class.getName());
			Config_MTL.LOGGER.setUseParentHandlers(false);
			Config_MTL.FH = new FileHandler(dir+server_name+".log",true);
			Config_MTL.LOGGER.addHandler(Config_MTL.FH);
			SimpleFormatter formatter = new SimpleFormatter();
			Config_MTL.FH.setFormatter(formatter);
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
		Thread udp_listener = new Thread(new Clinic_MTL_UDP_Listener());
		udp_listener.start();
	}
	
	public static void publishMTLService(){
		// http://localhost:9001/server_mtl
		Endpoint endpoint = Endpoint.publish("http://localhost:"+Config_MTL.WEB_SERVICE_PORT+"/"+Config_MTL.SERVER_NAME, new Clinic_MTL_Impl());
		System.out.println("Status of publish MTL Web Service: " + endpoint.isPublished());
	}
	
	
}
