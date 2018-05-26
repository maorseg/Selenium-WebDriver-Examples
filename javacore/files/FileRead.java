package corejava.files;

/**
 * Created by Maor on 5/21/2018.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {

    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("C:\\Users\\Maor\\Desktop\\data driven\\FileRead.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
