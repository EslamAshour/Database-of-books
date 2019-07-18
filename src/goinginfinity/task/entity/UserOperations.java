package goinginfinity.task.entity;

public enum UserOperations {
	
    View("1) View all books"), 
    ADD("2) Add a book"),
    Edit("3) Edit a book"), 
    SEARCH("4) Search for a book"),
    SAVE("5) Save and exit"); 
	
    private String userOperation; 
  
    public String getUserOperation() { 
        return this.userOperation; 
    } 
  
    private UserOperations(String userOperation) { 
        this.userOperation = userOperation; 
    } 
} 
