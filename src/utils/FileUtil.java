package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static void writeToFile(String fileName,String data){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
            writer.write(data);
            writer.newLine();
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }

    public static List<String> readFromFile(String fileName){
        List<String> lines = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null){
                lines.add(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return lines;
    }
}
