package singletonPattern;

public class Application {
    private static Application instance;
    private String user;
    private boolean isUserLoggedIn;
    private int queueCount;

    private Application() {

    }

    // get application instance
    public static synchronized Application getInstance() {
        if (instance == null)
            instance = new Application();
        return instance;
    }

    public synchronized boolean isUserLoggedIn() {
        return isUserLoggedIn;
    }

    // add user to queue
    public synchronized void addToQueue(String user) {
        if (!isUserLoggedIn) {
            isUserLoggedIn = true;
            this.user = user;
            System.out.println(user + "  is currently in queue.");
        } else
            System.out.println("Another user already logged in!");
    }

    // remove user from queue
    public synchronized void removeFromQueue() {
        isUserLoggedIn = false;
        System.out.println(user + "'s business is done, removed from queue.");
    }

    //Adding a number to queue and displays it
    public synchronized void addToQueueCount() {
        queueCount += 1;
        System.out.println("Current in queue: " + queueCount + "\n");
    }

    //resetting the queue
    public synchronized void resetQueue() {
        queueCount=0;
        System.out.println("Current in queue: " + queueCount + "\n");
    }

    //just show the queue count
    public synchronized void showQueue() {
        System.out.println("Current in queue: " + queueCount + "\n");
    }

}
