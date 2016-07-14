package Client_Side;

import java.util.logging.FileHandler;
import java.util.logging.Logger;

/**
 * this is configuration class
 * @author jpl19
 *
 */
public class Config_Client {
	static String MANAGER_ID = null;
	static String HOST = "127.0.0.1";
	static Client_Side.Web_MTL.ClinicServersInterface DSMS_IMPL = null;
	static int SERVER_PORT_MTL = 6001;
	static int SERVER_PORT_LVL = 6002;
	static int SERVER_PORT_DDO = 6003;
	
	static Logger LOGGER = null;
	static FileHandler FH = null;
}