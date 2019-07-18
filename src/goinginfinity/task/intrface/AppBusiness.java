package goinginfinity.task.intrface;

import goinginfinity.task.entity.Books;

public interface AppBusiness {
	
	public void viewAllBooks(Books availableBooks); 

	public void searchForBook(String keyword, Books availableBooks);
	
	public void save(Books availableBooks);
}
