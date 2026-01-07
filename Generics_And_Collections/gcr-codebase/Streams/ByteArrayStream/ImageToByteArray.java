import java.io.*;

public class ImageToByteArray {
    public static void main(String[] args) {
        String sourceImage = "source_image.jpg";
        String outputImage = "output_image.jpg";
        
        try {
            byte[] imageBytes = readImageToByteArray(sourceImage);
            System.out.println("Image size: " + imageBytes.length + " bytes");
            
            writeByteArrayToImage(imageBytes, outputImage);
            System.out.println("Image written to: " + outputImage);
            
            if (areFilesIdentical(sourceImage, outputImage)) {
                System.out.println("Files are identical");
            } else {
                System.out.println("Files are different");
            }
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    static byte[] readImageToByteArray(String filename) throws IOException {
        try (FileInputStream fis = new FileInputStream(filename);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            
            return baos.toByteArray();
        }
    }
    
    static void writeByteArrayToImage(byte[] imageBytes, String filename) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(filename)) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
    
    static boolean areFilesIdentical(String file1, String file2) throws IOException {
        try (FileInputStream fis1 = new FileInputStream(file1);
             FileInputStream fis2 = new FileInputStream(file2)) {
            
            int byte1, byte2;
            while ((byte1 = fis1.read()) != -1 && (byte2 = fis2.read()) != -1) {
                if (byte1 != byte2) {
                    return false;
                }
            }
            
            return fis1.read() == -1 && fis2.read() == -1;
        }
    }
}