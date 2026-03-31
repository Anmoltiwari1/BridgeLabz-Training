import java.io.*;

public class FileCopyBuffered {
    public static void main(String[] args) {
        String source = "source.txt";
        String dest = "destFile_buffered.dat";

        long startTime = System.nanoTime();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[4096]; // 4KB
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        System.out.println("Buffered copy time: " + (endTime - startTime)/1_000_000 + " ms");
    }
}
