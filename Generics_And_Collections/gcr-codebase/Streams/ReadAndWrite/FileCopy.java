import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {
    public static void main(String[] args) {
        
        FileInputStream fis=null;
        FileOutputStream fos=null;

        try {
            
            fis=new FileInputStream("source.txt");

            fos=new FileOutputStream("destination.txt");


            int data;

            while((data=fis.read())!=-1){
                fos.write(data);
            }

            System.out.println("File copied successfully");;
        } catch (Exception e) {
            System.out.println("File does not exist");
        }finally{
            try {
                fis.close();
                fos.close();
            } catch (Exception e) {
                System.out.println("Error closing the file");
            }
        }
    }
}
