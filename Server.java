import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.lang.Thread;


public class Server{
    public static void main(String[] args) {
        printToFile();
    }
    public static void printToFile(){
        String fileName = "src/inventory.ser";

        while(true) {
            try {
                ServerSocket server = new ServerSocket(3000);
                Socket s = server.accept();

                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintStream ps = new PrintStream((s.getOutputStream()));

                BookFunctions function = new BookFunctions();
                function.readFile(fileName);
                while (true) {
                    ps.println("Menu:\n" + "1) Add a book\n" + "2) Add an author to a book\n" + "3) Remove book\n" + "4) Remove author\n" + "5) Print titles of all books\n" + "6) Print all information on a specific book\n" + "e) Exit");
                    try {
                        String option = br.readLine();

                        if (option.length() == 0) {
                        } else if (option.charAt(0) == '1') {
                            function.addBook(ps, br);
                        } else if (option.charAt(0) == '2') {
                            function.addAuthor(ps, br);
                        } else if (option.charAt(0) == '3') {
                            function.removeBook(ps, br);
                        } else if (option.charAt(0) == '4') {
                            function.removeAuthor(ps, br);
                        } else if (option.charAt(0) == '5') {
                            function.printTitles(ps, br);
                        } else if (option.charAt(0) == '6') {
                            function.printInfo(ps, br);
                        } else if (option.charAt(0) == 'e' || option.charAt(0) == 'E') {
                            try {
                                server.close();
                                br.close();
                                ps.close();
                                function.writeFile(fileName);
                                break;
                            } catch (IOException e) {
                                e.printStackTrace(System.err);
                            }
                        } else {
                            ps.println("Invalid");
                        }
                    } catch (NullPointerException e) {
                        s.close();
                        br.close();
                        ps.close();
                        System.exit(1);
                    }
                }

            } catch (IOException e) {
                System.out.println("Could not read in data from file");
            }
        }
    }
}
