package ObjectOrientedDesign;

import java.util.HashMap;

public class OnlineBookReader {
    /**
     * Design the data structures for an online book reader system
     * User membership creation and extension
     * searching the database of books
     * reading a book
     * only one active user at a time
     * only one active book by this user
     */
}
/*
// represents the body of the program
class OnlineReaderSystem{
    private Library library;
    private UserManager userManger;
    private Display display;

    private Book activeBook;
    private User activeUser;

    public OnlineReaderSystem(){
        userManger = new UserManager();
        library = new Library();
        display = new Display();
    }
    public Library getLibrary(){return this.library;}
    public UserManager getUserManger(){return this.userManger;}
    public Display getDisplay(){return this.display;}

    public Book getActiveBook(){return activeBook;}
    public void setActiveBook(Book book){
        activeBook = book;
        display.displayBook(book);
    }
    public User getActiveUser(){return activeUser;}
    public void setActiveUser(User user){
        activeUser = user;
        display.displayUser(user);
    }
}

class Library{
    private HashMap<Integer, Book> books;

    public Book addBook(int id, String details){
        if(books.containsKey(id))
            return null;
        Book book = new Book(id, details);
        books.put(id, book);
        return book;
    }

    public boolean remove(Book book){return remove(book.getId());}
    public boolean remove(int id){
        if(!books.containsKey(id))
            return false;
        books.remove(id);
        return true;
    }
    public Book find(int id){return books.get(id);}
}
class UserManager{
    private HashMap<Integer, User> users;

    public User addUser(int id, String details, int accountType){
        if(users.containsKey(id))
            return null;
        User user = new User(id, details, accountType);
        users.put(id, user);
        return user;
    }
    public User find(int id){return users.get(id);}
    public boolean remove(User u){return remove(u.getId());}
    public boolean remove(int id){
        if(!users.containsKey(id))
            return false;
        users.remove(id);
        return true;
    }
}
class Display{
    private Book activeBook;
    private User activeUser;
    private int pageNumber = 0;


    public void displayBook(Book book){
        pageNumber = 0;
        activeBook = book;

        refreshTitle();
        refreshDetails();
        refreshPage();
    }
    public void displayUser(User user){
        activeUser = user;
        refreshUsername();
    }
    public void turnPageForward(){pageNumber++; refreshPage();}
    public void turnPageBackward(){pageNumber--; refreshPage();}

    public void refreshUsername(){...}
    public void refreshTitle(){...}
    public void refreshDetails(){...}
    public void refreshPage(){...}
}
class Book{
    private int bookId;
    private String details;

    public Book(int id, String details){this.bookId = id; this.details = details;}

    public int getId(){return this.bookId;}
    public void setId(int id){this.bookId = id;}

    public String getDetails(){return this.details;}
    public void setDetails(String details){this.details = details;}
}
class User{
    private int id;
    private String details;
    private int accountType;

    public User(int id, String details, int accountType){
        this.id = id;
        this.details = details;
        this.accountType = accountType;
    }

    public void renewMembership(){...}
    public int getId(){return this.id;}
    public void setId(int id){this.id = id;}
    public String getDetails(){return this.details;}
    public void setDetails(String d){this.details = d;}
    public int getAccountType(){return this.accountType;}
    public void setAccountType(int a){this.accountType = a;}
}
*/