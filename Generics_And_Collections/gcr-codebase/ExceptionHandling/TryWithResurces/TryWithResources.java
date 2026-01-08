package TryWithResurces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args) {
        
        try {
            FileReader fr=new FileReader("info.txt");
            BufferedReader br=new BufferedReader(fr);

            String line=br.readLine();
            System.out.println(line);

            br.close();
            
        } catch (IOException e) {
           System.out.println("Error in readig file");
        }
    }
}
