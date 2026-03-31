import java.io.*;
import java.util.*;

public class PerformanceChallenge {
    public static void main(String[] args) {
        // String concatenation performance test
        testStringConcatenation();
        
        // File reading performance test
        testFileReading();
    }
    
    public static void testStringConcatenation() {
        int iterations = 1000000;
        String testString = "hello";
        
        // StringBuilder test
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(testString);
        }
        long sbTime = System.nanoTime() - startTime;
        
        // StringBuffer test
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(testString);
        }
        long sbfTime = System.nanoTime() - startTime;
        
        System.out.println("=== String Concatenation Performance ===");
        System.out.println("StringBuilder: " + sbTime + " ns");
        System.out.println("StringBuffer: " + sbfTime + " ns");
        System.out.println("StringBuilder is " + (sbfTime / sbTime) + "x faster");
    }
    
    public static void testFileReading() {
        String fileName = "large_file.txt";
        createLargeFile(fileName);
        
        // FileReader test
        long startTime = System.currentTimeMillis();
        int wordCount1 = countWordsFileReader(fileName);
        long frTime = System.currentTimeMillis() - startTime;
        
        // InputStreamReader test
        startTime = System.currentTimeMillis();
        int wordCount2 = countWordsInputStreamReader(fileName);
        long isrTime = System.currentTimeMillis() - startTime;
        
        System.out.println("\n=== File Reading Performance ===");
        System.out.println("FileReader: " + frTime + " ms, Words: " + wordCount1);
        System.out.println("InputStreamReader: " + isrTime + " ms, Words: " + wordCount2);
    }
    
    private static void createLargeFile(String fileName) {
        try (FileWriter fw = new FileWriter(fileName)) {
            for (int i = 0; i < 100000; i++) {
                fw.write("This is line " + i + " with multiple words for testing.\n");
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }
    
    private static int countWordsFileReader(String fileName) {
        int wordCount = 0;
        try (FileReader fr = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fr)) {
            
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return wordCount;
    }
    
    private static int countWordsInputStreamReader(String fileName) {
        int wordCount = 0;
        try (FileInputStream fis = new FileInputStream(fileName);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {
            
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return wordCount;
    }
}