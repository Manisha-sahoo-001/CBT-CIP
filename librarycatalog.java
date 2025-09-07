import java.util.Scanner;
import java.util.ArrayList;

class Book
{
    private String title;
    private String auther;
    private int year;

    public Book(String title,String auther,int year)
    {
        this.title=title;
        this.auther=auther;
        this.year=year;
    }
    public String getTitle()
    {
        return title;
    }
    public String getAuther()
    {
        return auther;
    }
    public int getYear()
    {
        return year;
    }
    public String toString()
    {
        return title +" by "+auther+"("+year+")";
    }

}
class Library
{
   private ArrayList<Book> books;
   public Library()
   {
      books=new ArrayList<>();
   } 
   public void addBook(Book book)
   {
    books.add(book);
    System.out.println("book added successfully. ");
   }
   public void searchByTitle(String title)
   {
    boolean found = false;
    for(Book book : books)
    {
        if(book.getTitle().equalsIgnoreCase(title))
        {
           System.out.println("Found: "+book);
           found =true;
        }
    }
    if(!found)
    {
        System.out.println("no book found with title : "+title);
    }
   }
   public void searchByAuthor(String auther)
   {
    boolean found = false;
    for(Book book : books)
    {
        if(book.getAuther().equalsIgnoreCase(auther))
        {
            System.out.println("found : "+book);
            found = true;
        }
    }
    if(!found)
    {
        System.out.println("no book found by auther: "+auther);
    }
   }
   public void listBooks()
   {
    if(books.isEmpty())
    {
        System.out.println("no books in the catalog ");
    }
    else
    {
        System.out.println("all available books : ");
        for( Book book : books)
        {
            System.out.println(book);
        }
    }
   }
}
public class librarycatalog {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Library library =new Library();

        while(true)
        {
        System.out.println("======LIBRARY CATALOG MENU======");
        System.out.println();
        System.out.println("1.ADD BOOKS");
        System.out.println("2.SEARCH BY TITLE");
        System.out.println("3.SEARCH BY AUTHOR");
        System.out.println("4.LIST ALL BOOKS");
        System.out.println("5.EXIT");
        System.out.println();
        System.out.print("ENTER YOUR CHOICE : ");
        int choose = sc.nextInt();
        sc.nextLine();
        switch(choose)
        {
            case 1:
             System.out.print("Enter book title : ");
             String title = sc.nextLine();
             System.out.print("Enter auther : ");
             String auther = sc.nextLine();
             System.out.print("Enter publication year : ");
             int year = sc.nextInt();
             library.addBook(new Book(title,auther,year));
             break;
            case 2:
             System.out.print("Enter title to search : ");
             String searchTitle = sc.nextLine();
             library.searchByTitle(searchTitle);
             break;
            case 3:
             System.out.println("Enter auther to search : ");
             String searchAuther = sc.nextLine();
             library.searchByAuthor(searchAuther);
             break;
            case 4:
             library.listBooks();
             break;
            case 5:
             System.out.println("Exiting library catalog ");
             System.out.println("Thanks for visiting");
             break;
            default:
             System.out.println("invalid choice , try again ");
        }
        }

    }
    
}
