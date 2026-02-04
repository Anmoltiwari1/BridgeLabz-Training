import java.util.Random;

class FileDownloaderThread extends Thread {
    private String fileName;
    
    public FileDownloaderThread(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    public void run() {
        Random random = new Random();
        for (int progress = 0; progress <= 100; progress += 25) {
            System.out.println("[" + Thread.currentThread().getName() + "] Downloading " + fileName + ": " + progress + "%");
            try {
                Thread.sleep(random.nextInt(500) + 200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class FileDownloaderRunnable implements Runnable {
    private String fileName;
    
    public FileDownloaderRunnable(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    public void run() {
        Random random = new Random();
        for (int progress = 0; progress <= 100; progress += 25) {
            System.out.println("[" + Thread.currentThread().getName() + "] Downloading " + fileName + ": " + progress + "%");
            try {
                Thread.sleep(random.nextInt(500) + 200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class DownloadManager {
    public static void main(String[] args) {
        System.out.println("=== Using Thread Class Approach ===");
        
        FileDownloaderThread thread1 = new FileDownloaderThread("Document.pdf");
        FileDownloaderThread thread2 = new FileDownloaderThread("Image.jpg");
        FileDownloaderThread thread3 = new FileDownloaderThread("Video.mp4");
        
        thread1.start();
        thread2.start();
        thread3.start();
        
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("All downloads complete!");
        
        System.out.println("\n=== Using Runnable Interface Approach ===");
        
        Thread t1 = new Thread(new FileDownloaderRunnable("Music.mp3"));
        Thread t2 = new Thread(new FileDownloaderRunnable("Software.exe"));
        Thread t3 = new Thread(new FileDownloaderRunnable("Archive.zip"));
        
        t1.start();
        t2.start();
        t3.start();
        
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("All downloads complete!");
    }
}