package luu_file_text;

import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {
    String fullname;
    int id;
    String address;
    int age;
    float gpa;

    public Student() {
    }

    public Student(String fullname, int id, String address, int age, float gpa) {
        this.fullname = fullname;
        this.id = id;
        this.address = address;
        this.age = age;
        this.gpa = gpa;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" + "fullname=" + fullname + ", id=" + id + ", address=" + address + ", age=" + age + ", gpa=" + gpa + '}';
    }

    public void display() {
        System.out.println(toString());
    }

    public void input() {
        Scanner input = new Scanner(System.in);

        System.out.println("Nhap ID : ");
        id = Integer.parseInt(input.nextLine());

        inputWithoutId();
    }

    public void inputWithoutId() {
        Scanner input = new Scanner(System.in);

        System.out.println("Nhap ten : ");
        fullname = input.nextLine();
        System.out.println("Nhap dia chi : ");
        address = input.nextLine();
        System.out.println("Nhap tuoi : ");
        age = Integer.parseInt(input.nextLine());
        System.out.println("Nhap diem trung binh : ");
        gpa = Float.parseFloat(input.nextLine());
    }
}
