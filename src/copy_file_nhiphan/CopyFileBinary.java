package copy_file_nhiphan;

import java.io.*;

public class CopyFileBinary {
    public static void main(String[] args) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(new File("chien1.txt"));
            outputStream = new FileOutputStream(new File("chien3.txt"));

            int length;
            byte[] buffer = new byte[1024];

            while ((length = inputStream.read(buffer))>0){
                outputStream.write(buffer,0,length);

            }
            System.out.println("copy hoàn thành");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
