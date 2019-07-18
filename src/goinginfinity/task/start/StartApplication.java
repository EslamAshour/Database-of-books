package goinginfinity.task.start;

import java.io.File;
import java.util.Scanner;

import goinginfinity.task.db.DataBaseManager;
import goinginfinity.task.db.logic.AppBusinessImpl;
import goinginfinity.task.entity.Book;
import goinginfinity.task.entity.Books;
import goinginfinity.task.entity.UserOperations;
import goinginfinity.task.utils.PropertiesReader;

public class StartApplication {
	
	private static Scanner in;
	private static Books availableBooks;
	static {
		in = new Scanner(System.in); 
		availableBooks = DataBaseManager.initialize(new File(PropertiesReader.getValue("dbFilePath")));
	}

	public static void main(String[] args) {
		start();
	}

	private static void start() {
		AppBusinessImpl appBusinessImpl = new AppBusinessImpl();
		
		System.out.println("loaded " + availableBooks.getBooksMap().size() + "  into the library\n");

		int requiredOperation = drawBookManagerView();
		
		switch (requiredOperation) {
		case 1:
			System.out.println("==== View Books ====");
			appBusinessImpl.viewAllBooks(availableBooks);
			viewBookDetails(availableBooks);
			break;
		case 2:
			System.out.println("==== Add a Book ====");
			System.out.println("Please enter the following information:");
			Book bookToAdd = new Book();
			System.out.println("Title:");
			bookToAdd.setTitle(in.nextLine());
			System.out.println("Author:");
			bookToAdd.setAuthor(in.nextLine());
			System.out.println("Description:");
			bookToAdd.setDescription(in.nextLine());
			bookToAdd.setId(availableBooks.getBooksMap().size()+1);
			availableBooks.getBooksMap().put(availableBooks.getBooksMap().size()+1, bookToAdd);

			System.out.println("Book [" + bookToAdd.getId() + "] Saved");
			start();
			break;
		case 3:
			
			System.out.println("==== Edit a Book ====");
			appBusinessImpl.viewAllBooks(availableBooks);
			
			editBook();
			
			break;
		case 4:
			System.out.println("==== Search ====");
			System.out.println("Type in one or more keywords to search for");
			String keyword = in.nextLine();
			appBusinessImpl.searchForBook(keyword , availableBooks);
			break;
		case 5:
			appBusinessImpl.save(availableBooks);
			System.out.println("Library saved.");
			break;
		default:
			break;
		}
	}

	private static void editBook() {
		System.out.println("Enter the book ID of the book you want to edit; to return press <Enter>.");
		
		String editDecesion = in.nextLine();
		if(editDecesion.isEmpty()) {
			start();
		}else {
			System.out.println("Input the following information. To leave a field unchanged, hit <Enter>");
			System.out.println("Title:");
			String editOrNot = in.nextLine();
			if(editOrNot.isEmpty()) {
				start();
			}else {
				Book bookToEdit = availableBooks.getBooksMap().get(Integer.parseInt(editDecesion));
				bookToEdit.setTitle(in.nextLine());
				System.out.println("Author:");
				bookToEdit.setAuthor(in.nextLine());
				System.out.println("Description:");
				bookToEdit.setDescription(in.nextLine());
				System.out.println("Book saved.");
				editBook();
			}			
		}
	}

	private static void viewBookDetails(Books availableBooks) {
		System.out.println("To view details enter the book ID, to return press <Enter>");
		String userDecesion = in.nextLine();
		if(userDecesion.isEmpty()) {
			start();
		}else {
			int id = Integer.parseInt(userDecesion);
			Book bookToView = availableBooks.getBooksMap().get(id);
			System.out.println("Book ID: " + bookToView.getId());
			System.out.println("     ID: " + bookToView.getId());
			System.out.println("     Title: " + bookToView.getTitle());
			System.out.println("     Author: " + bookToView.getAuthor());
			System.out.println("     Description: " + bookToView.getDescription());
			viewBookDetails(availableBooks);
		}
	}

	private static int drawBookManagerView() {
		try {
			System.out.println("==== Book Manager ====");

			UserOperations[] userOperations = UserOperations.values();

			for (UserOperations userOperation : userOperations) {
				System.out.println(userOperation.getUserOperation());
			}
			
			 System.out.print("Choose [1-5]: "); 
			 
			 int requiredOperation = Integer.parseInt(in.nextLine()); 
			 
			 if(requiredOperation > 0 && requiredOperation < 6)
				 return  requiredOperation; 
			 else {
				 System.out.println("Please enter valid operation number");
				  drawBookManagerView();
			 }
			 
			 return requiredOperation;
		} catch (Exception e) {
			System.out.println("Please enter valid number ");
			return drawBookManagerView();
		}
		
	}
}
