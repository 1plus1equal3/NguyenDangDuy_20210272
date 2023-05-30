package hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        String filename = "C:\\Users\\D\\Downloads\\vnedict.txt";
        byte[] inputBytes = { 0 };
        long startTime = System.currentTimeMillis(), endTime;
        inputBytes = Files.readAllBytes(Paths.get(filename));
        String outputString = "";
        for(byte b: inputBytes) {
            outputString += (char)b;
        }
/*      StringBuffer outputStringBuffer = new StringBuffer();
        for(byte b: inputBytes) {
            outputStringBuffer.append((char) b);
        }*/
        endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
