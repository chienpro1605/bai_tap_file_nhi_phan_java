package quanlysanphamluurafilenhiphan;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TestProduct {
    public static void main(String[] args) {

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
                   int id;
                       System.out.println("nhập id cần tìm kiếm");
                       id = scanner.nextInt();
                       ql.seachProduct(id);
                       break;
               case 3:
                   ql.displayProduct();
                   break;
               case 4:
                   ql.writeToFile("product.csv",ql.list);
                   break;
               case 5:
                   ql.readDataFromFile("product.csv");
                   break;
               case 6:
                   System.out.println("good bye");
                   System.exit(0);
                   break;
               default:
                   System.out.println("nhập lại");
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
//    static void writeToFile(String path, List<Product> list) {
//        try {
//            FileOutputStream fos = new FileOutputStream(path);
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(list);
//            oos.close();
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public static List<Product> readDataFromFile(String path){
//        List<Product> list = new ArrayList<>();
//        try{
//            FileInputStream fis = new FileInputStream(path);
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            list = (List<Product>) ois.readObject();
//            System.out.println("done");
//            ois.close();
//            fis.close();
//
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        return list;
//    }
}
