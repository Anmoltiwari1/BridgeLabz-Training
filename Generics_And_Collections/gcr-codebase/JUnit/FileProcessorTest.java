import java.io.*;

public class FileProcessorTest {
    public static void main(String[] args) {
        testWriteAndRead();
        testFileExists();
        testFileNotFound();
        System.out.println("All FileProcessor tests completed!");
    }
    
    static void testWriteAndRead() {
        FileProcessor processor = new FileProcessor();
        String filename = "test.txt";
        String content = "Hello World";
        
        try {
            processor.writeToFile(filename, content);
            String readContent = processor.readFromFile(filename);
            
            if (content.equals(readContent)) {
                System.out.println("✅ testWriteAndRead passed");
            } else {
                System.out.println("❌ testWriteAndRead failed");
            }
            
            new File(filename).delete();
        } catch (IOException e) {
            System.out.println("❌ testWriteAndRead failed: " + e.getMessage());
        }
    }
    
    static void testFileExists() {
        FileProcessor processor = new FileProcessor();
        String filename = "exists.txt";
        
        try {
            processor.writeToFile(filename, "test");
            File file = new File(filename);
            
            if (file.exists()) {
                System.out.println("✅ testFileExists passed");
            } else {
                System.out.println("❌ testFileExists failed");
            }
            
            file.delete();
        } catch (IOException e) {
            System.out.println("❌ testFileExists failed: " + e.getMessage());
        }
    }
    
    static void testFileNotFound() {
        FileProcessor processor = new FileProcessor();
        
        try {
            processor.readFromFile("nonexistent.txt");
            System.out.println("❌ testFileNotFound failed - no exception thrown");
        } catch (IOException e) {
            System.out.println("✅ testFileNotFound passed - IOException caught: " + e.getMessage());
        }
    }
}