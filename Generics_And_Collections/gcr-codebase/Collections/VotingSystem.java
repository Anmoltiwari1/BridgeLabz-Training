import java.util.*;

public class VotingSystem {
    HashMap<String, Integer> votes = new HashMap<>();
    LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();
    
    void vote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteOrder.getOrDefault(candidate, 0) + 1);
    }
    
    void displayResults() {
        System.out.println("\n=== Voting Results ===");
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }
    
    void displayResultsSorted() {
        System.out.println("\n=== Results Sorted by Votes (Descending) ===");
        TreeMap<Integer, List<String>> sortedResults = new TreeMap<>(Collections.reverseOrder());
        
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            sortedResults.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }
        
        for (Map.Entry<Integer, List<String>> entry : sortedResults.entrySet()) {
            for (String candidate : entry.getValue()) {
                System.out.println(candidate + ": " + entry.getKey() + " votes");
            }
        }
    }
    
    void displayVoteOrder() {
        System.out.println("\n=== Votes in Order Received ===");
        for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }
    
    String getWinner() {
        return votes.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No votes cast");
    }
    
    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        
        // Cast votes
        system.vote("Alice");
        system.vote("Bob");
        system.vote("Alice");
        system.vote("Charlie");
        system.vote("Bob");
        system.vote("Alice");
        system.vote("David");
        
        system.displayResults();
        system.displayResultsSorted();
        system.displayVoteOrder();
        
        System.out.println("\nWinner: " + system.getWinner());
    }
}