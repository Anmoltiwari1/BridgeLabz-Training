class PrintJob implements Runnable {
    private String jobName;
    private int pages;
    private int priority;
    
    public PrintJob(String jobName, int pages, int priority) {
        this.jobName = jobName;
        this.pages = pages;
        this.priority = priority;
    }
    
    @Override
    public void run() {
        String priorityLevel = getPriorityLevel();
        
        for (int page = 1; page <= pages; page++) {
            System.out.println("[" + priorityLevel + "] Printing " + jobName + " - Page " + page + " of " + pages);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println(jobName + " completed!");
    }
    
    private String getPriorityLevel() {
        if (priority >= 7) return "High Priority";
        if (priority >= 5) return "Medium Priority";
        return "Low Priority";
    }
    
    public int getPriority() {
        return priority;
    }
}

public class PrintShopScheduler {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        
        PrintJob job1 = new PrintJob("Job1", 10, 5);
        PrintJob job2 = new PrintJob("Job2", 5, 8);
        PrintJob job3 = new PrintJob("Job3", 15, 3);
        PrintJob job4 = new PrintJob("Job4", 8, 6);
        PrintJob job5 = new PrintJob("Job5", 12, 7);
        
        Thread t1 = new Thread(job1);
        Thread t2 = new Thread(job2);
        Thread t3 = new Thread(job3);
        Thread t4 = new Thread(job4);
        Thread t5 = new Thread(job5);
        
        t1.setPriority(5);
        t2.setPriority(8);
        t3.setPriority(3);
        t4.setPriority(6);
        t5.setPriority(7);
        
        System.out.println("Starting print jobs...");
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        
        System.out.println("All jobs completed in " + totalTime + "ms");
    }
}