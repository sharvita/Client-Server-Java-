import java.io.*;
import java.util.ArrayList;
import java.net.*;

public class BookFunctions {

    public ArrayList<Book> Library = new ArrayList<>();

    public void readFile(String fileName){
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
            while (true) {
                Book book = (Book) inputStream.readObject();
                Library.add(book);
            }
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e){

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(String fileName){
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            for(int i = 0; i < this.Library.size(); ++i) {
                outputStream.writeObject(this.Library.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBook(PrintStream ps, BufferedReader br) throws IOException {
        ps.println("1) Printed Book\n" +
                "2) Electronic Book");
        String type = br.readLine();
        while(type.length() == 0){
            type = br.readLine();
        }

        if(type.charAt(0) == '1') {
            PrintedBook printedBook = new PrintedBook();
            ps.println("Enter the book title:");
            String title = br.readLine();
            printedBook.setTitle(title);
            ps.println("Enter the year published:");
            String yearPub = br.readLine();
            try {printedBook.setYearPub(Integer.parseInt(yearPub));}
            catch (NumberFormatException e){
                ps.println("Must be an integer");
                return;
            }
            ps.println("Enter the location code:");
            String locationCode = br.readLine();
            printedBook.setLocationCode(locationCode);

            while (true) {
                Author newAuthor = new Author();
                ps.println("Enter the authors name:");
                String name = br.readLine();
                newAuthor.setName(name);
                ps.println("Enter another author? y/n");
                printedBook.addAuthor(newAuthor);
                String again = br.readLine();
                if (again.length() == 0 || again.charAt(0) == 'y' || again.charAt(0) == 'Y') {
                } else {
                    break;
                }
            }

            ps.println("Enter the number of pages:");
            String pages = br.readLine();
            try {printedBook.setNumberOfPages(Integer.parseInt(pages));}
            catch (NumberFormatException e){
                ps.println("Must be an integer");
                return;
            }
            ps.println("Enter the date of print:");
            String date = br.readLine();
            try {printedBook.setDateOfPrint(Integer.parseInt(date));}
            catch (NumberFormatException e){
                ps.println("Must be an integer");
                return;
            }
            ps.println("Enter the name of the publisher:");
            String publisherName = br.readLine();
            Publisher publisher = new Publisher();
            publisher.setPublisher(publisherName);
            printedBook.setPublisher(publisher);
            Library.add(printedBook);
        }

        else if(type.charAt(0) == '2'){
            ElectronicBook electronicBook = new ElectronicBook();
            ps.println("Enter the book title:");
            String title = br.readLine();
            electronicBook.setTitle(title);
            ps.println("Enter the year published:");
            String yearPub = br.readLine();
            try {electronicBook.setYearPub(Integer.parseInt(yearPub));}
            catch (NumberFormatException e){
                ps.println("Must be an integer");
                return;
            }
            ps.println("Enter the location code:");
            String locationCode = br.readLine();
            electronicBook.setLocationCode(locationCode);

            while (true) {
                Author newAuthor = new Author();
                ps.println("Enter the authors name:");
                String name = br.readLine();
                newAuthor.setName(name);
                ps.println("Enter another author? y/n");
                electronicBook.addAuthor(newAuthor);
                String again = br.readLine();
                if (again.length() == 0 || again.charAt(0) == 'y' || again.charAt(0) == 'Y') {
                } else {
                    break;
                }
            }

            ps.println("Enter the number of pages:");
            String pages = br.readLine();
            try {electronicBook.setNumberOfPages(Integer.parseInt(pages));}
            catch (NumberFormatException e){
                ps.println("Must be an integer");
                return;
            }
            ps.println("Enter the date digitized:");
            String date = br.readLine();
            try {electronicBook.setDateDigitized(Integer.parseInt(date));}
            catch (NumberFormatException e){
                ps.println("Must be an integer");
                return;
            }
            ps.println("Enter the name of the publisher:");
            String publisherName = br.readLine();
            Publisher publisher = new Publisher();
            publisher.setPublisher(publisherName);
            electronicBook.setPublisher(publisher);
            Library.add(electronicBook);
        }

        else{
            ps.println("Enter a valid option...");
        }
    }

    public void addAuthor(PrintStream ps, BufferedReader br) throws IOException {
        ps.println("Enter the title of the book you want to add an author to:");
        String title = br.readLine();
        for (int i = 0; i < Library.size(); ++i) {
            if (Library.get(i).getTitle().equals(title)) {
                while (true) {
                    Author newAuthor = new Author();
                    ps.println("Enter the authors name:");
                    String name = br.readLine();
                    newAuthor.setName(name);
                    ps.println("Enter another author? y/n");
                    Library.get(i).addAuthor(newAuthor);
                    String again = br.readLine();
                    if (again.length() == 0 || again.charAt(0) == 'y' || again.charAt(0) == 'Y') {
                    } else {
                        return;
                    }
                }
            }
        }
        ps.println("Book not found...");
    }

    public void removeBook(PrintStream ps, BufferedReader br) throws IOException {
        ps.println("Enter the title of the book you want to remove:");
        String title = br.readLine();

        for(int i = 0; i < Library.size();++i){
            if(Library.get(i).getTitle().equals(title)){
                Library.remove(i);
                ps.println("The book was removed.");
                return;
            }
        }
        ps.println("Book not found...");
    }

    public void removeAuthor(PrintStream ps, BufferedReader br) throws IOException {
        ps.println("Enter the title of the book whose authors you want to edit:");
        String title = br.readLine();

        for(int i = 0; i < Library.size();++i){
            if(Library.get(i).getTitle().equals(title)){
                ps.println("Book found, enter the name of the author to remove:");
                String name = br.readLine();
                Library.get(i).authors.remove(name);
                ps.println("The author was removed.");
                return;
            }
        }
        ps.println("Book not found...");
    }

    public void printTitles(PrintStream ps, BufferedReader br) {
        if (Library.size() == 0) {
            ps.println("There are no books...");
        } else {
            ps.println("Books:");
            for (Book title : Library) {
                ps.println(title.getTitle());
            }
            ps.println(" ");
        }
    }

    public void printInfo(PrintStream ps, BufferedReader br) throws IOException {
        ps.println("Enter the title of the book you want to see:");
        String title = br.readLine();

        for (Book aLibrary : Library) {
            if (aLibrary.getTitle().equals(title)) {
                ps.println("Book information:\n" +
                        aLibrary.toString() +
                        "\nAuthors: ");
                aLibrary.printAuthors(ps);
                ps.println(" ");
                return;
            }
        }
        ps.println("Book not found...");
    }
}
