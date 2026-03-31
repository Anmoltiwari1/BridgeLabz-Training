import java.util.*;

class InvalidRatingException extends Exception{

    public InvalidRatingException(String message){
        super(message);
    }
}

class Event{
    private static int EventCounter=0;
    int eventId;
    String eventName;

    Event(String eventName){
        this.eventName=eventName;
        this.eventId=++EventCounter;
    }
}

public class RatingAnalysis {
    static List<Event> events=new ArrayList<>();
    static Map<Integer,List<Integer>> feedback=new HashMap<>();

    public static void addEvent(String eventName){
        Event e=new Event(eventName);
        events.add(e);
        feedback.put(e.eventId, new ArrayList<>());
        System.out.println("Event Added :" + e.eventName +" and its id is :"+e.eventId);   
    }

    public static void addRating(int eventId,int rate) throws InvalidRatingException{
        if(!feedback.containsKey(eventId)){
            throw new InvalidRatingException("No such event found");
        }

        if(rate<1 || rate>5){
            throw new InvalidRatingException("Rating must be between 1 and 5");
        }

        feedback.get(eventId).add(rate);
    }

    public static double averageRating(){

        double sum=0,avg=0,count=0;
        for(Map.Entry<Integer,List<Integer>> entry: feedback.entrySet()){

            List<Integer> rating=entry.getValue();

            for(int i:rating){
                sum+=i;
                count++;
            }
            avg=sum/count;

        }
        return avg;
    }


    public static int topRating(){
        int maxRating=Integer.MIN_VALUE;
        for(Map.Entry<Integer,List<Integer>> entry: feedback.entrySet()){

            for(int i:entry.getValue()){
                if(i>maxRating){
                    maxRating=i;
                }
            }
        }
        return maxRating;
    }

    public static void main(String[] args) {

        boolean run=true;
        while(run){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the choice ");
            System.out.println("1. To add the event");
            System.out.println("2. To add the rating of particular event");
            System.out.println("3. To find the average rating");
            System.out.println("4. To find the top rated event");
            System.out.println("5. to exit");
            int ch=sc.nextInt();
    
            switch (ch) {
    
                case 1:
                    System.out.println("Enter the name of event");
                    String name=sc.nextLine();
    
                    addEvent(name);
                    break;
                
                case 2:
                    System.out.println("Enter the eventid and ratings");
                    int eventId=sc.nextInt();

                    int rate=sc.nextInt();

                    try {
                        addRating(eventId, rate); 
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
            
                case 3:
                      
                    
                default:
                    break;
            }
        }



        
        addEvent("Diljit");
        addEvent("Sidhu");
        addEvent("Arijit Singh");

        try {
            addRating(1, 2);
            addRating(1, 3);
            addRating(1, 4);
            addRating(1, 5);
            addRating(3, 2);
            addRating(3, 5);  
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Top rating is :"+topRating());

        System.out.println("Average Rating is :"+averageRating());
    }
}
