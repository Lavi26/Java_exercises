package org.espire.deadlock;

/*
 * Avoiding deadlock using synchronization
 * */

// A Class used to send a message
class Sender {
    public void send(String msg) {
        System.out.println("Sending" + msg);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Thread  interrupted.");
        }
        System.out.println("" + msg + "Sent");
    }
}


// Class for send a message using Threads
class ThreadedSend extends Thread {
    private String msg;
    private Sender sender;

    // Receives a message object and a string message to be sent
    ThreadedSend(String m, Sender obj) {
        msg = m;
        sender = obj;
    }

    public void run() {
        // Only one thread can send a message at a time.
        synchronized (sender) {
            // synchronizing the send object
            sender.send(msg);
        }
    }
}


public class DeadlockAvoidanceSync {
    public static void main(String args[]) {
        Sender snd = new Sender();
        ThreadedSend S1 = new ThreadedSend(" Hi ", snd);
        ThreadedSend S2 = new ThreadedSend(" Bye ", snd);

        // Start two threads of ThreadedSend type
        S1.start();
        S2.start();

        // wait for threads to end
        try {
            S1.join();
            S2.join();
        } catch (Exception e) {
            System.out.println("Interrupted");
        }
    }
}


