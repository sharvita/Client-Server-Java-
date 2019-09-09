import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.util.Scanner;


public class Client {
        public static void main(String arg[]){
            Scanner scanner = new Scanner(System.in);
            String IP= "10.0.0.112";

            startClient(scanner,IP);

        }

        public static void startClient(Scanner scan, String IP) {

            String output;
            int port;
            String user;

            System.out.println("Connecting to servers");
            try {
                port = 3000;


                Socket s = new Socket(IP, port);
                System.out.println("Connected to server...");


                BufferedReader br = new BufferedReader(new InputStreamReader((s.getInputStream())));

                PrintStream ps = new PrintStream((s.getOutputStream()));


                while (true) {
                    for (int i = 0; i < 8; ++i) {
                        output = br.readLine();
                        System.out.println(output);
                    }
                    user = scan.nextLine();
                    ps.println(user);


                    if (user.charAt(0) == '1') {
                        for (int i = 0; i < 2; ++i) {
                            output = br.readLine();
                            System.out.println(output);
                        }
                        user = scan.nextLine();
                        ps.println(user);

                        if (user.charAt(0) == '1') {
                            output = br.readLine();
                            System.out.println(output);
                            user = scan.nextLine();
                            ps.println(user);
                            output = br.readLine();
                            System.out.println(output);
                            user = scan.nextLine();
                            ps.println(user);
                            try {
                                Integer.parseInt(user);
                            } catch (NumberFormatException e) {
                                System.out.println("Must be an integer");
                                return;
                            }
                            output = br.readLine();
                            System.out.println(output);
                            user = scan.nextLine();
                            ps.println(user);
                            while (true) {
                                output = br.readLine();
                                System.out.println(output);
                                user = scan.nextLine();
                                ps.println(user);
                                output = br.readLine();
                                System.out.println(output);
                                user = scan.nextLine();
                                ps.println(user);
                                if (user.length() == 0 || user.charAt(0) == 'y' || user.charAt(0) == 'Y') {
                                } else {
                                    break;
                                }
                            }
                            output = br.readLine();
                            System.out.println(output);
                            user = scan.nextLine();
                            ps.println(user);
                            output = br.readLine();
                            System.out.println(output);
                            user = scan.nextLine();
                            ps.println(user);
                            output = br.readLine();
                            System.out.println(output);
                            user = scan.nextLine();
                            ps.println(user);
                        }


                        if (user.charAt(0) == '2') { // if electronic book
                            output = br.readLine();
                            System.out.println(output);
                            user = scan.nextLine();
                            ps.println(user);
                            output = br.readLine();
                            System.out.println(output);
                            user = scan.nextLine();
                            ps.println(user);
                            try {
                                Integer.parseInt(user);
                            } catch (NumberFormatException e) {
                                System.out.println("Must be an integer");
                                return;
                            }
                            output = br.readLine();
                            System.out.println(output);
                            user = scan.nextLine();
                            ps.println(user);
                            while (true) {
                                output = br.readLine();
                                System.out.println(output);
                                user = scan.nextLine();
                                ps.println(user);
                                output = br.readLine();
                                System.out.println(output);
                                user = scan.nextLine();
                                ps.println(user);
                                if (user.length() == 0 || user.charAt(0) == 'y' || user.charAt(0) == 'Y') {
                                } else {
                                    break;
                                }
                            }
                            output = br.readLine();
                            System.out.println(output);
                            user = scan.nextLine();
                            ps.println(user);
                            output = br.readLine();
                            System.out.println(output);
                            user = scan.nextLine();
                            ps.println(user);
                            output = br.readLine();
                            System.out.println(output);
                            user = scan.nextLine();
                            ps.println(user);
                        }
                        user = "0";
                    }

                    if (user.charAt(0) == '2') {
                        output = br.readLine();
                        System.out.println(output);
                        user = scan.nextLine();
                        ps.println(user);
                        while (true) {
                            output = br.readLine();
                            System.out.println(output);
                            if (output.equals("Book not found...")) {
                                break;
                            }
                            user = scan.nextLine();
                            ps.println(user);
                            output = br.readLine();
                            System.out.println(output);
                            user = scan.nextLine();
                            ps.println(user);
                            if (user.length() == 0 || user.charAt(0) == 'y' || user.charAt(0) == 'Y') {
                            } else {
                                break;
                            }
                        }
                        user = "0";
                    }
                    if (user.charAt(0) == '3') {
                        output = br.readLine();
                        System.out.println(output);
                        user = scan.nextLine();
                        ps.println(user);
                        output = br.readLine();
                        System.out.println(output);
                        user = "0";
                    }
                    if (user.charAt(0) == '4') {
                        output = br.readLine();
                        System.out.println(output);
                        user = scan.nextLine();
                        ps.println(user);
                        output = br.readLine();
                        if (output.equals("Book was not found")) {
                            System.out.println(output);
                        } else {
                            System.out.println(output);
                            user = scan.nextLine();
                            ps.println(user);
                            output = br.readLine();
                            System.out.println(output);
                        }
                        user = "0";
                    }

                    if (user.charAt(0) == '5') {
                        output = br.readLine();
                        if (output.equals("Books were not found")) {
                            System.out.println(output);
                        } else {
                            System.out.println(output);
                            while (!output.equals(" ")) {
                                output = br.readLine();
                                System.out.println(output);
                            }
                        }
                        user = "0";
                    }
                    if (user.charAt(0) == '6') {
                        output = br.readLine();
                        System.out.println(output);
                        user = scan.nextLine();
                        ps.println(user);
                        while (!output.equals(" ")) {
                            output = br.readLine();
                            System.out.println(output);
                        }
                        user = "0";
                    }
                    if (user.charAt(0) == ('e')) {
                        System.exit(1);
                    } else {
                        if (!user.equals("0")) {
                            output = br.readLine();
                            System.out.println(output);
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println("Server cannot be connected.");
                System.exit(1);
            }
        }
}

