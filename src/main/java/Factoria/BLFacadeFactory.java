package Factoria;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import configuration.ConfigXML;
import dataAccess.DataAccess;

public class BLFacadeFactory {
	ConfigXML a;

	public BLFacadeFactory(ConfigXML c) {
		// TODO Auto-generated constructor stub
		this.a = c;
	}

	public BLFacade createBLFacade() {

		if (a.isBusinessLogicLocal()) {
			DataAccess da = new DataAccess(a.getDataBaseOpenMode().equals("initialize"));
			BLFacade appFacadeInterface = new BLFacadeImplementation(da);
			return appFacadeInterface;

		} else {
			// TODO Auto-generated method stub
			String serviceName = "http://" + a.getBusinessLogicNode() + ":" + a.getBusinessLogicPort() + "/ws/"
					+ a.getBusinessLogicName() + "?wsdl";

			// URL url = new URL("http://localhost:9999/ws/ruralHouses?wsdl");
			URL url = null;
			try {
				url = new URL(serviceName);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 1st argument refers to wsdl document above
			// 2nd argument is service name, refer to wsdl document above
			// QName qname = new QName("http://businessLogic/",
			// "FacadeImplementationWSService");
			QName qname = new QName("http://businessLogic/", "BLFacadeImplementationService");

			Service service = Service.create(url, qname);

			BLFacade appFacadeInterface = service.getPort(BLFacade.class);
			return appFacadeInterface;
		}

	}
}
