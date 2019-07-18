package goinginfinity.task.entity;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="books")
@XmlAccessorType(XmlAccessType.FIELD)
public class Books {

	private Map<Integer, Book> booksMap = new HashMap<>();

	public Map<Integer, Book> getBooksMap() {
		return booksMap;
	}

	public void setBooksMap(Map<Integer, Book> booksMap) {
		this.booksMap = booksMap;
	}
}
