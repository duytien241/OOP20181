package datacount;

import java.io.BufferedWriter;
import java.io.FileWriter;
 
public class WriteID {
    public static void updateID(long a,long b, long c, long d, long e,long f) throws Exception {
        FileWriter writer = new FileWriter("idenfiti.txt");
        BufferedWriter buffer = new BufferedWriter(writer);
        	buffer.write(String.valueOf(a));
        	buffer.newLine();
        	buffer.write(String.valueOf(b));
        	buffer.newLine();
        	buffer.write(String.valueOf(c));
        	buffer.newLine();
        	buffer.write(String.valueOf(d));
        	buffer.newLine();
        	buffer.write(String.valueOf(e));
        	buffer.newLine();
        	buffer.write(String.valueOf(f));
        	buffer.newLine();;
        buffer.close();
        System.out.println("Success...");
    }
}
