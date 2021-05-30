package quanlysanphamluurafilenhiphan;

import luu_file_text.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagementProduct {
    List<Product> list = new ArrayList<>();

    public void addProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập id thêm");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("nhập tên sản phẩm muốn thêm");
        String name = scanner.nextLine();
        System.out.println("nhập hãng sản phẩm");
        String brand = scanner.nextLine();
        System.out.println("nhập giá muốn thêm");
        int price = scanner.nextInt();
        list.add(new Product(id,name,brand,price));
    }
    public void displayProduct(){
        for (int i = 0; i<list.size(); i++){
            System.out.println(list.get(i).toString());
        }
        System.out.println("----------------------");
    }
    public void seachProduct(int id){
        boolean isid = false;
        for (int i = 0; i<list.size(); i++){
            if (list.get(i).getId() == id){
                System.out.println(list.get(i).toString());
                isid = true;
            }
        }
        if (!isid){
            System.out.println("không tìm thấy");
        }
    }
    public void writeToFile(String path){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new  FileOutputStream(path);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(list);

        }catch (Exception e){
        }finally {
            try {
                if (fos!=null){
                    fos.close();
                }
                if (oos!=null){
                    oos.close();
                }
            } catch (Exception e) {
            }
        }


    }
    public void readDataFromFile(String path){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);

            list = (List<Product>) ois.readObject();

        }catch (Exception e){
        }finally {
            try {
                if (fis!=null){
                    fis.close();
                }
                if (ois!=null){
                    ois.close();
                }
            } catch (Exception e) {
            }
        }
    }
}
