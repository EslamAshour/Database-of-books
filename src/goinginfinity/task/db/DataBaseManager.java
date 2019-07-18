package goinginfinity.task.db;

import java.io.File;
import java.io.IOException;

import goinginfinity.task.entity.Books;
import goinginfinity.task.xml.handle.XmlHandler;

public class DataBaseManager {

	public static final synchronized Books initialize(File dbFile) {
		if (!dbFile.exists())
			try {
				dbFile.createNewFile();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		Books availableBooks = XmlHandler.unmarshal(dbFile);

		return availableBooks;
	}

}
