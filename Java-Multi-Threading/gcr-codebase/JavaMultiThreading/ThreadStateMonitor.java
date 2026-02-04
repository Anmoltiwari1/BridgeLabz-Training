import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class TaskRunner extends Thread {
    public TaskRunner(String name) {
        super(name);
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            
            for (int i = 0; i < 1000000; i++) {
                Math.sqrt(i);
            }
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class StateMonitor extends Thread {
    private List<Thread> threadsToMonitor;
    private Map<String, List<String>> stateHistory;
    
    public StateMonitor(List<Thread> threads) {
        this.threadsToMonitor = threads;
        this.stateHistory = new HashMap<>();
        for (Thread t : threads) {
            stateHistory.put(t.getName(), new ArrayList<>());
        }
    }
    
    @Override
    public void run() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        while (true) {
            boolean allTerminated = true;
            
            for (Thread thread : threadsToMonitor) {
                String currentTime = LocalTime.now().format(formatter);
                Thread.State state = thread.getState();
                
                System.out.println("[Monitor] " + thread.getName() + " is in " + state + " state at " + currentTime);
                
                List<String> history = stateHistory.get(thread.getName());
                String stateEntry = state.toString();
                if (!history.contains(stateEntry)) {
                    history.add(stateEntry);
                }
                
                if (state != Thread.State.TERMINATED) {
                    allTerminated = false;
                }
            }
            
            if (allTerminated) {
                break;
            }
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        
        System.out.println("\n=== State Summary ===");
        for (Map.Entry<String, List<String>> entry : stateHistory.entrySet()) {
            System.out.println("Summary: " + entry.getKey() + " went through " + 
                             entry.getValue().size() + " states: " + entry.getValue());
        }
    }
}

public class ThreadStateMonitor {
    public static void main(String[] args) {
        TaskRunner task1 = new TaskRunner("Task-1");
        TaskRunner task2 = new TaskRunner("Task-2");
        
        List<Thread> threads = Arrays.asList(task1, task2);
        StateMonitor monitor = new StateMonitor(threads);
        
        System.out.println("[Monitor] Task-1 is in " + task1.getState() + " state");
        System.out.println("[Monitor] Task-2 is in " + task2.getState() + " state");
        
        monitor.start();
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        task1.start();
        task2.start();
        
        try {
            task1.join();
            task2.join();
            monitor.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}