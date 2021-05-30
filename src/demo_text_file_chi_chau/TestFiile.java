package demo_text_file_chi_chau;

import java.io.IOException;
import java.util.List;

public class TestFiile {
    public static void main(String[] args) {
        FileManagement fileManagement = new FileManagement();
        List<String> contents = null;

        try {
            fileManagement.writeFiel("file.txt","ok am phai");
            contents = fileManagement.readFile("file.txt");
            for (String line: contents){
                System.out.println(line);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
