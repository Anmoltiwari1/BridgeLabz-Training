import java.util.*;

public class NameUppercasing {
    public static void main(String[] args){

        List<String> name=List.of("anmol","amit","priya");

        name.stream().map(String::toUpperCase).forEach(System.out::println); 
    }    
}
