import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
       Stack<Integer> s1=new Stack<>();
       Stack<Integer> s2=new Stack<>();
       s1.push(10);
       s1.push(30);
       s1.push(40);
       s1.push(50);
       s1.push(20);

       sortStack(s1, s2);
       System.out.println("Sorted Stack");
       while(!s1.isEmpty()){
           System.out.println(s1.pop());
       }
    }

    public static Stack<Integer> sortStack(Stack<Integer> s1,Stack<Integer> s2){
        if(s1.isEmpty()){
            System.out.println("Stack is Empty");
            return s1;
        }
        
        while(!s1.isEmpty()){
            int temp=s1.pop();
            while(!s2.isEmpty() && s2.peek()>temp){
                s1.push(s2.pop());
            }
            s2.push(temp);
        }
         while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return s1;
    }
}


