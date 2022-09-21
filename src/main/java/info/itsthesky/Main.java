package info.itsthesky;

import info.itsthesky.api.utils.DataObject;
import info.itsthesky.api.utils.Location;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, DocumentException {

		Instances.init();

		/*
		Tests
		 */

		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("test.xml"));
		final Location location = Location.of(DataObject.loadFromXML(document.getRootElement()));
		System.out.println(location);
	}

}