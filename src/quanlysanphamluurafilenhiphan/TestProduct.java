package quanlysanphamluurafilenhiphan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestProduct {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
       Scanner scanner = new Scanner(System.in);
       ManagementProduct ql = new ManagementProduct();
        int choose;
//        ql.addProduct();
//        ql.addProduct();
//        ql.displayProduct();
//        System.out.println("nhập id cần tìm kiếm");
//        int id = scanner.nextInt();
//        ql.seachProduct(id);
       do {
           showMenu();
           choose = scanner.nextInt();
           switch (choose){
               case 1:
                   ql.addProduct();
                   break;
               case 2:
                   System.out.println("nhập id cần tìm kiếm");
                   int id = scanner.nextInt();
                   ql.seachProduct(id);
                   break;
               case 3:
                   ql.displayProduct();
                   break;
               case 4:
                   writeToFile("product.txt",list);
                   break;
               case 5:
                   readDataFromFile("product.txt");
                   break;
               case 6:
                   System.out.println("good bye");
                   System.exit(0);
           }


       }while (choose!=6);

    }
    static void showMenu(){
        System.out.println("1. thêm sản phẩm");
        System.out.println("2. tìm kiếm sản phẩm");
        System.out.println("3. hiển thị sản phẩm ");
        System.out.println("4. lưu sản phẩm");
        System.out.println("5. hiển thị sản phẩm từ file lưu");
        System.out.println("6. thoát");
    }
    static void writeToFile(String path, List<Product> list) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Product> readDataFromFile(String path){
        List<Product> list = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
}
