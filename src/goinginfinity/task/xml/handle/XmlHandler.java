package goinginfinity.task.xml.handle;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import goinginfinity.task.entity.Books;
import goinginfinity.task.utils.PropertiesReader;

public class XmlHandler {

	public static Books unmarshal(File dbFile) {
		Books books = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			books = (Books) jaxbUnmarshaller.unmarshal(dbFile);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return books;
	}
	
	public static void marshal(Books availableBooks) {
		try {
	    	JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		 
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 
		    jaxbMarshaller.marshal(availableBooks, System.out);
			jaxbMarshaller.marshal(availableBooks, new File(PropertiesReader.getValue("dbFilePath")));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
