import java.io.*;

public class PipedStreamsDemo {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);
            
            Thread writerThread = new Thread(new Writer(pos));
            Thread readerThread = new Thread(new Reader(pis));
            
            writerThread.start();
            readerThread.start();
            
            writerThread.join();
            readerThread.join();
            
        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class Writer implements Runnable {
    private PipedOutputStream pos;
    
    Writer(PipedOutputStream pos) {
        this.pos = pos;
    }
    
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                String message = "Message " + i + "\n";
                pos.write(message.getBytes());
                System.out.println("Writer: Sent " + message.trim());
                Thread.sleep(1000);
            }
            pos.close();
        } catch (IOException | InterruptedException e) {
            System.out.println("Writer error: " + e.getMessage());
        }
    }
}

class Reader implements Runnable {
    private PipedInputStream pis;
    
    Reader(PipedInputStream pis) {
        this.pis = pis;
    }
    
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(pis))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Reader: Received " + line);
            }
        } catch (IOException e) {
            System.out.println("Reader error: " + e.getMessage());
        }
    }
}