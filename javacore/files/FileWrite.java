package corejava.files;

/**
 * Created by Maor on 5/21/2018.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {

    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\Maor\\Desktop\\data driven\\FileWrite.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write("Test Selenium");
            bufferedWriter.newLine();
            bufferedWriter.write("Test Appium");

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
