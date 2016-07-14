package Server_Side;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService
public interface ClinicServers_Interface {
	@WebMethod
	public String createDRecord(String managerId, String firstName, String lastName, String address, String phone, String specialization, String location);
	@WebMethod
	public String createNRecord(String managerId, String firstName, String lastName, String designation, String status, String statusDate);
	@WebMethod
	public String getRecordCounts(String managerId, String recordType);
	@WebMethod
	public String editRecord(String managerId, String recordID, String fielddName, String newValue);
	@WebMethod
	public String transferRecord(String managerId, String recordID, String remoteClinicServerName);
}
