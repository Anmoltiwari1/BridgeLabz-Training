import java.io.FileWriter;
import java.util.Scanner;

public class UserInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = "";
        String age = "";
        String language = "";

        System.out.println("Enter your name");
        name = sc.nextLine();

        System.out.println("Enter your age");
        age = sc.nextLine();

        System.out.println("Enter your language");
        language = sc.nextLine();

        
        try (FileWriter fw = new FileWriter("user_info.txt")) {
            fw.append(name).append("\n");
            fw.append(age).append("\n");
            fw.append(language).append("\n");
        } catch (Exception e) {
            System.out.println("Error occurred: " + e);
        }
    }
}
