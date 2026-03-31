import java.util.*;

class CreatorStats{
    
    public String CreatorName;
    public double[] WeeklyLikes;

    public static List<CreatorStats> EngagementBoard=new ArrayList<>();
    
}

public class Program {
    
    public void RegisterCreator(CreatorStats record){
        CreatorStats.EngagementBoard.add(record);
    }

    public Dictionary<String ,Integer> GetTopPostCounts(List<CreatorStats> records,double likeThreshold){

        Dictionary<String,Integer> result=new Hashtable<>();

        for(CreatorStats creator: records){
            int count=0;

            for(double likes: creator.WeeklyLikes){
                if(likes>=likeThreshold){
                    count++;
                }
            }
            if(count>0){
                result.put(creator.CreatorName, count);
            }
        }
        return result;
    }

    public double CalculateAvgLikes(){
        double sum=0;
        int count=0;

        for(CreatorStats creator: CreatorStats.EngagementBoard){
            for(double likes:creator.WeeklyLikes){
                sum+=likes;
                count++;
            }
        }
        if(count==0)
            return 0;
    
        return sum/count;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Program program = new Program();

        while (true) {
            System.out.println("1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                
                case 1:
                    CreatorStats cs=new CreatorStats();
                    System.out.println("Enter the Creator name:");
                    cs.CreatorName=sc.nextLine();

                    cs.WeeklyLikes=new double[4];
                    System.out.println("Enter the weekly likes(Week 1 to 4 ");
                    for(int i=0;i<4;i++){
                        cs.WeeklyLikes[i]=sc.nextDouble();
                    }

                    program.RegisterCreator(cs);
                    System.out.println("Creator Register SuccessFully");
                    break;

                case 2:
                    System.out.println("Enter the threshold");
                    double threshold=sc.nextDouble();

                    Dictionary<String ,Integer> topPosts=program.GetTopPostCounts(CreatorStats.EngagementBoard, threshold);

                     if (topPosts.isEmpty()) {
                        System.out.println("No top-performing posts this week");
                    } else {
                        Enumeration<String> keys = topPosts.keys();
                        while (keys.hasMoreElements()) {
                            String name = keys.nextElement();
                            System.out.println(name + " - " + topPosts.get(name));
                        }
                    }
                    break;

                case 3:
                    double avg=program.CalculateAvgLikes();
                    System.out.println("Average likes are :"+avg );
                    break;

                case 4:
                    System.out.println("Logging Off .....");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }

    }
}

