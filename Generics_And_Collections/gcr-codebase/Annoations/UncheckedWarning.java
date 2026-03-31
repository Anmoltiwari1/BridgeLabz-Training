import java.util.ArrayList;

public class UncheckedWarning {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list=new ArrayList();

        list.add(1);
        list.add("Hello");
        list.add(3);

        System.out.println(list);
    }    
}
