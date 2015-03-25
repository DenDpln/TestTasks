package task4;

import java.io.*;

/**
 * Created by den on 25.03.2015.
 */
public class testRewrite {

    private static String orignePath = "test";
    private static String newPath =  "!!!!!!!!!!!!!!!!";
    private static void changeLineInFile(String orignePath, String newPath){
        try {
            File file = new File("C:\\test\\111.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "", oldtext = "";
            while((line = reader.readLine()) != null)
            {
                oldtext += line + "\r\n";
            }
            reader.close();
            String newtext = oldtext.replaceAll(orignePath, newPath);
            FileWriter writer = new FileWriter(file);
            writer.write(newtext);writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        changeLineInFile(orignePath, newPath);
    }

}
