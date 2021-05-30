package demo_text_file_chi_chau;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManagement {
    List<String> readFile(String path) throws IOException {
        List<String> contents = new ArrayList<>();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String text = null;
        while ((text = bufferedReader.readLine())!=null){
            contents.add(text);
        }
        bufferedReader.close();
        fileReader.close();
        return contents;
    }
    void writeFiel(String path, String content) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(content+"\n");
        bufferedWriter.write("\n");
        bufferedWriter.close();
        fileWriter.close();
    }
}
