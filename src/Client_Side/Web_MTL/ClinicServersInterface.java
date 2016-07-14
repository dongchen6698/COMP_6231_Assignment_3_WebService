
package Client_Side.Web_MTL;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ClinicServers_Interface", targetNamespace = "http://Server_Side/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ClinicServersInterface {


    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg6
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createDRecord", targetNamespace = "http://Server_Side/", className = "Client_Side.Web_MTL.CreateDRecord")
    @ResponseWrapper(localName = "createDRecordResponse", targetNamespace = "http://Server_Side/", className = "Client_Side.Web_MTL.CreateDRecordResponse")
    @Action(input = "http://Server_Side/ClinicServers_Interface/createDRecordRequest", output = "http://Server_Side/ClinicServers_Interface/createDRecordResponse")
    public String createDRecord(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4,
        @WebParam(name = "arg5", targetNamespace = "")
        String arg5,
        @WebParam(name = "arg6", targetNamespace = "")
        String arg6);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createNRecord", targetNamespace = "http://Server_Side/", className = "Client_Side.Web_MTL.CreateNRecord")
    @ResponseWrapper(localName = "createNRecordResponse", targetNamespace = "http://Server_Side/", className = "Client_Side.Web_MTL.CreateNRecordResponse")
    @Action(input = "http://Server_Side/ClinicServers_Interface/createNRecordRequest", output = "http://Server_Side/ClinicServers_Interface/createNRecordResponse")
    public String createNRecord(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4,
        @WebParam(name = "arg5", targetNamespace = "")
        String arg5);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getRecordCounts", targetNamespace = "http://Server_Side/", className = "Client_Side.Web_MTL.GetRecordCounts")
    @ResponseWrapper(localName = "getRecordCountsResponse", targetNamespace = "http://Server_Side/", className = "Client_Side.Web_MTL.GetRecordCountsResponse")
    @Action(input = "http://Server_Side/ClinicServers_Interface/getRecordCountsRequest", output = "http://Server_Side/ClinicServers_Interface/getRecordCountsResponse")
    public String getRecordCounts(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "editRecord", targetNamespace = "http://Server_Side/", className = "Client_Side.Web_MTL.EditRecord")
    @ResponseWrapper(localName = "editRecordResponse", targetNamespace = "http://Server_Side/", className = "Client_Side.Web_MTL.EditRecordResponse")
    @Action(input = "http://Server_Side/ClinicServers_Interface/editRecordRequest", output = "http://Server_Side/ClinicServers_Interface/editRecordResponse")
    public String editRecord(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "transferRecord", targetNamespace = "http://Server_Side/", className = "Client_Side.Web_MTL.TransferRecord")
    @ResponseWrapper(localName = "transferRecordResponse", targetNamespace = "http://Server_Side/", className = "Client_Side.Web_MTL.TransferRecordResponse")
    @Action(input = "http://Server_Side/ClinicServers_Interface/transferRecordRequest", output = "http://Server_Side/ClinicServers_Interface/transferRecordResponse")
    public String transferRecord(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

}
