
package Client_Side.Web_DDO;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the Client_Side.Web_DDO package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateDRecord_QNAME = new QName("http://Server_Side/", "createDRecord");
    private final static QName _TransferRecord_QNAME = new QName("http://Server_Side/", "transferRecord");
    private final static QName _TransferRecordResponse_QNAME = new QName("http://Server_Side/", "transferRecordResponse");
    private final static QName _CreateNRecord_QNAME = new QName("http://Server_Side/", "createNRecord");
    private final static QName _EditRecordResponse_QNAME = new QName("http://Server_Side/", "editRecordResponse");
    private final static QName _GetRecordCounts_QNAME = new QName("http://Server_Side/", "getRecordCounts");
    private final static QName _EditRecord_QNAME = new QName("http://Server_Side/", "editRecord");
    private final static QName _GetRecordCountsResponse_QNAME = new QName("http://Server_Side/", "getRecordCountsResponse");
    private final static QName _CreateDRecordResponse_QNAME = new QName("http://Server_Side/", "createDRecordResponse");
    private final static QName _CreateNRecordResponse_QNAME = new QName("http://Server_Side/", "createNRecordResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Client_Side.Web_DDO
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetRecordCounts }
     * 
     */
    public GetRecordCounts createGetRecordCounts() {
        return new GetRecordCounts();
    }

    /**
     * Create an instance of {@link CreateDRecordResponse }
     * 
     */
    public CreateDRecordResponse createCreateDRecordResponse() {
        return new CreateDRecordResponse();
    }

    /**
     * Create an instance of {@link CreateNRecordResponse }
     * 
     */
    public CreateNRecordResponse createCreateNRecordResponse() {
        return new CreateNRecordResponse();
    }

    /**
     * Create an instance of {@link EditRecord }
     * 
     */
    public EditRecord createEditRecord() {
        return new EditRecord();
    }

    /**
     * Create an instance of {@link GetRecordCountsResponse }
     * 
     */
    public GetRecordCountsResponse createGetRecordCountsResponse() {
        return new GetRecordCountsResponse();
    }

    /**
     * Create an instance of {@link CreateDRecord }
     * 
     */
    public CreateDRecord createCreateDRecord() {
        return new CreateDRecord();
    }

    /**
     * Create an instance of {@link TransferRecord }
     * 
     */
    public TransferRecord createTransferRecord() {
        return new TransferRecord();
    }

    /**
     * Create an instance of {@link CreateNRecord }
     * 
     */
    public CreateNRecord createCreateNRecord() {
        return new CreateNRecord();
    }

    /**
     * Create an instance of {@link TransferRecordResponse }
     * 
     */
    public TransferRecordResponse createTransferRecordResponse() {
        return new TransferRecordResponse();
    }

    /**
     * Create an instance of {@link EditRecordResponse }
     * 
     */
    public EditRecordResponse createEditRecordResponse() {
        return new EditRecordResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateDRecord }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server_Side/", name = "createDRecord")
    public JAXBElement<CreateDRecord> createCreateDRecord(CreateDRecord value) {
        return new JAXBElement<CreateDRecord>(_CreateDRecord_QNAME, CreateDRecord.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferRecord }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server_Side/", name = "transferRecord")
    public JAXBElement<TransferRecord> createTransferRecord(TransferRecord value) {
        return new JAXBElement<TransferRecord>(_TransferRecord_QNAME, TransferRecord.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferRecordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server_Side/", name = "transferRecordResponse")
    public JAXBElement<TransferRecordResponse> createTransferRecordResponse(TransferRecordResponse value) {
        return new JAXBElement<TransferRecordResponse>(_TransferRecordResponse_QNAME, TransferRecordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNRecord }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server_Side/", name = "createNRecord")
    public JAXBElement<CreateNRecord> createCreateNRecord(CreateNRecord value) {
        return new JAXBElement<CreateNRecord>(_CreateNRecord_QNAME, CreateNRecord.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditRecordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server_Side/", name = "editRecordResponse")
    public JAXBElement<EditRecordResponse> createEditRecordResponse(EditRecordResponse value) {
        return new JAXBElement<EditRecordResponse>(_EditRecordResponse_QNAME, EditRecordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecordCounts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server_Side/", name = "getRecordCounts")
    public JAXBElement<GetRecordCounts> createGetRecordCounts(GetRecordCounts value) {
        return new JAXBElement<GetRecordCounts>(_GetRecordCounts_QNAME, GetRecordCounts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditRecord }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server_Side/", name = "editRecord")
    public JAXBElement<EditRecord> createEditRecord(EditRecord value) {
        return new JAXBElement<EditRecord>(_EditRecord_QNAME, EditRecord.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecordCountsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server_Side/", name = "getRecordCountsResponse")
    public JAXBElement<GetRecordCountsResponse> createGetRecordCountsResponse(GetRecordCountsResponse value) {
        return new JAXBElement<GetRecordCountsResponse>(_GetRecordCountsResponse_QNAME, GetRecordCountsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateDRecordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server_Side/", name = "createDRecordResponse")
    public JAXBElement<CreateDRecordResponse> createCreateDRecordResponse(CreateDRecordResponse value) {
        return new JAXBElement<CreateDRecordResponse>(_CreateDRecordResponse_QNAME, CreateDRecordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateNRecordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server_Side/", name = "createNRecordResponse")
    public JAXBElement<CreateNRecordResponse> createCreateNRecordResponse(CreateNRecordResponse value) {
        return new JAXBElement<CreateNRecordResponse>(_CreateNRecordResponse_QNAME, CreateNRecordResponse.class, null, value);
    }

}
