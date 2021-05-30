package copy_cac_file_co_dung_luong_lon;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer))>0){
                os.write(buffer,0, length);
            }

        }finally {
            is.close();
            os.close();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("nhập đường file nguồn");
        String sourcePath = in.nextLine();
        System.out.println("nhập đường file đích");
        String destPath = in.nextLine();

        File fileSource = new File(sourcePath);
        File fileDest = new File(destPath);

        try {
            //copyFileUsingJava7Files(fileSource, fileDest);
            copyFileUsingStream(fileSource,fileDest);
            System.out.println("copy hoàn thành");

        }catch (IOException ioe){
            System.out.println("không thể copy file");
            System.out.println(ioe.getMessage());
        }
    }

}
