import java.util.*;
public class Frequency {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of string arrays");
        int n=sc.nextInt();
        String[] arr=new String[n];
        System.out.println("Enter the string arrays");
        for(int i=0;i<n;i++){
            arr[i]=sc.next();
        }
        HashMap<String,Integer> h=new HashMap<>();

        for(String i:arr){
            if(h.containsKey(i)){
                h.put(i,h.get(i)+1);
            }
            else{
                h.put(i,1);
            }
        }
        System.out.println("Frequency of each string in the array");
        System.out.println(h);
    }
}
