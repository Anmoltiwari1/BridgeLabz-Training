import java.io.*;

public class StudentDataStreams {
    public static void main(String[] args) {
        String filename = "students.dat";
        
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.writeInt(101);
            dos.writeUTF("Alice Johnson");
            dos.writeDouble(3.8);
            
            dos.writeInt(102);
            dos.writeUTF("Bob Smith");
            dos.writeDouble(3.5);
            
            dos.writeInt(103);
            dos.writeUTF("Carol Davis");
            dos.writeDouble(3.9);
            
            System.out.println("Student data written");
            
        } catch (IOException e) {
            System.out.println("Write error: " + e.getMessage());
        }
        
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            
            System.out.println("Roll No\tName\t\tGPA");
            System.out.println("--------------------------------");
            
            while (dis.available() > 0) {
                int rollNo = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                
                System.out.println(rollNo + "\t" + name + "\t" + gpa);
            }
            
        } catch (IOException e) {
            System.out.println("Read error: " + e.getMessage());
        }
    }
}