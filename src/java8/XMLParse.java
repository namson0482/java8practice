package java8;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLParse {

	public XMLParse() {

	}

	static void parse() throws ParserConfigurationException, SAXException, IOException {

		String xmlRecords = "<?xml version=\"1.0\"?>\r\n"
				+ "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">"
				+ "<SOAP-ENV:Header/><SOAP-ENV:Body><ns2:GetNuocChoLonDetailsResponse xmlns:ns2=\"http://acb.com.vn/nuoccholon\">"
				+ "<ns2:NuocChoLonDetails><ns2:danhBa>10002</ns2:danhBa><ns2:name>name 10002</ns2:name>"
				+ "<ns2:billId>bill_id_10002</ns2:billId><ns2:year>2021</ns2:year><ns2:period>10</ns2:period>"
				+ "<ns2:amount>1000</ns2:amount><ns2:totalAmount>1000</ns2:totalAmount><ns2:status>Danh bạ nợ tiền nước</ns2:status>"
				+ "</ns2:NuocChoLonDetails></ns2:GetNuocChoLonDetailsResponse></SOAP-ENV:Body></SOAP-ENV:Envelope>";

		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(xmlRecords));

		Document doc = db.parse(is);
		NodeList nodes = doc.getElementsByTagName("ns2:NuocChoLonDetails");
		for (int i = 0; i < nodes.getLength(); i++) {
			Element element = (Element) nodes.item(i);

			NodeList name = element.getElementsByTagName("ns2:danhBa");
			Element line = (Element) name.item(0);
			System.out.println("Danh ba: " + getCharacterDataFromElement(line));

			NodeList title = element.getElementsByTagName("ns2:name");
			line = (Element) title.item(0);
			System.out.println("name: " + getCharacterDataFromElement(line));
		}
	}

	public static String getCharacterDataFromElement(Element e) {
		Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
			return cd.getData();
		}
		return "";
	}

	public static void main(String[] args) {
		try {
			parse();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
