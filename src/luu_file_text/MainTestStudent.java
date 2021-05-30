package luu_file_text;

import com.sun.tools.javac.Main;

import javax.print.DocFlavor;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainTestStudent {

    static List<Student> studentList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choose;

        do {
            showMenu();
            choose = Integer.parseInt(input.nextLine());
            switch (choose) {
                case 1:
                    input();
                    break;
                case 2:
                    editById();
                    break;
                case 3:
                    deleteById();
                    break;
                case 4:
                    sortByGpa();
                    break;
                case 5:
                    sortByName();
                    break;
                case 6:
                    showAll();
                    break;
                case 7:
                    saveIntoFile();
                    break;
                case 8:
                    readDataFromFile();
                    break;
                case 9:
                    System.out.println("Exit!!!");
                    break;
                default:
                    System.out.println("Input failed!");
                    break;
            }
        } while (choose != 9);
    }

    static void input() {
        System.out.println("Nhap so sinh vien can them : ");
        int n = Integer.parseInt(input.nextLine());

        for (int i = 0; i < n; i++) {
            Student std = new Student();
            std.input();
            studentList.add(std);
        }
    }

    static void editById() {
        System.out.println("Nhap ID can sua : ");
        int id = Integer.parseInt(input.nextLine());

        for (Student student : studentList) {
            if (student.getId() == id) {
                //sua
                student.inputWithoutId();
                break;
            }
        }
    }

    static void deleteById() {
        System.out.println("Nhap ID can xoa : ");
        int id = Integer.parseInt(input.nextLine());

        for (Student student : studentList) {
            if (student.getId() == id) {
                //sua
                studentList.remove(student);
                break;
            }
        }
    }

    static void sortByGpa() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (o1.getGpa() > o2.getGpa()) ? 1 : -1;
            }
        });
    }

    static void sortByName() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getFullname().compareTo(o2.getFullname());
            }
        });
    }

    static void showAll() {
        for (Student student : studentList) {
            student.display();
        }
    }

    static void saveIntoFile() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("student.txt");
            oos = new ObjectOutputStream(fos);

            oos.writeObject(studentList);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    static void readDataFromFile() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("student.txt");
            ois = new ObjectInputStream(fis);

            studentList = (List<Student>) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    static void showMenu() {
        System.out.println("1. Add student");
        System.out.println("2. Edit student by ID");
        System.out.println("3. Delete student by ID");
        System.out.println("4. Sort student list by GPA");
        System.out.println("5. Sort student list by Name");
        System.out.println("6. Show All Stundent");
        System.out.println("7. Save all student into student.dat");
        System.out.println("8. Read file student.dat and show all");
        System.out.println("9. Exit");
        System.out.println("Choose : ");
    }
}
