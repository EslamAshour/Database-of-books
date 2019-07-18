package goinginfinity.task.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
@XmlAccessorType (XmlAccessType.FIELD)
public class Book {
	
	private Integer id;
	
	private String title;
	
	private String author;
	
	private String Description;

	
	public Book() {
		super();
	}


	public Book(Integer id, String title, String author, String description) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		Description = description;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}

}
