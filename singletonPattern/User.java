package singletonPattern;

import java.util.Scanner;

public class User {
    public static void main(String[] args) {
        Application app = Application.getInstance();
        Scanner sc = new Scanner(System.in);
        String answer = "y";

        do {
            System.out.println("\n1.) Add to queue\n2.) Remove from queue\n3.) Reset the queue\n4.) Exit App");
            System.out.print("What would you like to do? Choose: ");

            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 1:
                    System.out.print("Enter name: ");
                    String userName = sc.nextLine();
                    if (!app.isUserLoggedIn()) {
                        app.addToQueue(userName);
                        app.addToQueueCount();
                    } else {
                        System.out.println("Another user is still in queue. Remove current user from queue before adding another please!");
                    }
                    break;
                case 2:
                    app.removeFromQueue();
                    app.showQueue();
                    break;
                case 3:
                    app.resetQueue();
                    break;
                case 4:
                    System.out.println("Exiting App...\nThank you!");
                    answer = "n";
                    break;
                default:
                    System.out.println("Please choose a valid option!");
                    break;
            }
        } while (!answer.equalsIgnoreCase("n"));

    }
}
