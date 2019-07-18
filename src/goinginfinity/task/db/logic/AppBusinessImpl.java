package goinginfinity.task.db.logic;

import java.util.Map.Entry;

import goinginfinity.task.entity.Book;
import goinginfinity.task.entity.Books;
import goinginfinity.task.intrface.AppBusiness;
import goinginfinity.task.xml.handle.XmlHandler;

public class AppBusinessImpl implements AppBusiness{

	@Override
	public void viewAllBooks(Books availableBooks) {
		if(availableBooks != null && availableBooks.getBooksMap() != null && availableBooks.getBooksMap().size() > 0)
		for(Entry<Integer, Book> book : availableBooks.getBooksMap().entrySet()) {
			System.out.println("[" + book.getKey() + "] " + book.getValue().getTitle());
		}else 
			System.out.println("There is no books in your database ");
	}

	@Override
	public void searchForBook(String keyword, Books availableBooks) {
		if(availableBooks != null && availableBooks.getBooksMap() != null && availableBooks.getBooksMap().size() > 0)
			for(Entry<Integer, Book> book : availableBooks.getBooksMap().entrySet()) {
				if(book.getValue().getAuthor().contains(keyword) || book.getValue().getDescription().contains(keyword) || book.getValue().getTitle().contains(keyword)){
					System.out.println("[" + book.getKey() + "] " + book.getValue().getTitle());
				}else {
					System.out.println("Not found books");
				}
			}else 
				System.out.println("There is no books in your database ");
		
	}

	@Override
	public void save(Books availableBooks) {	
		XmlHandler.marshal(availableBooks);
	}
	
	
}
