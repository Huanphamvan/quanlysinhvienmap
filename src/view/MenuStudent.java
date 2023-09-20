package view;

import manager.StudentManager;
import model.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuStudent {
   StudentManager studentManager = new StudentManager();
   Scanner inputInt = new Scanner(System.in);
   Scanner inputString = new Scanner(System.in);

    public void showMainMenu (){
        int choice;
        do {
            System.out.println("=====Menu Quản Lý Sinh Viên =====\n1.Thêm mới sinh viên.\n2.Xóa sinh viên.\n3.Sửa sinh viên.\n" +
                    "4.Tìm kiếm sinh viên theo Id.\n5.Hiển thị danh sách sinh viên theo tên gần đúng.\n6.Sinh viên có điểm trung bình lớn nhất.\n" +
                    "7.Hiển thị tất cả.\n0.Thoát.");
            System.out.println("Xin mời nhập sự lựa chọn");
            choice = inputInt.nextInt();
            switch (choice){
                case  1:
                    showMenuAdd();
                    break;
                case  2:
                    showMenuDelete();
                    break;
                case 3:
                    showMenuEdit();
                    break;
                case 4:
                    showMenuSearchById();
                    break;
                case 5:
                    showMenuShowStudent();
                    break;
                case 6:
                    showMaxAvg();
                    break;
                case 7:
                    showAll();
                    break;
            }
        } while (choice != 0);

    }

    public void showMenuAdd(){
        System.out.println("=======Đây là mục thêm mới sinh viên =====");
        System.out.println("Nhập id muốn thêm mới");
        int id = inputInt.nextInt();
        System.out.println("Nhập tên muốn thêm mới");
        String name = inputString.nextLine();
        System.out.println("Nhập giới tinh muốn thêm mới");
        String gender = inputString.nextLine();
        System.out.println("Nhập điểm Toán : ");
        double math = inputInt.nextDouble();
        System.out.println("Nhập điểm Văn : ");
        double literature = inputInt.nextDouble();
        System.out.println("Nhập điểm Anh : ");
        double english = inputInt.nextDouble();
        double pointsAvg = (math+literature+english)/3;

        Student student = new Student(id,name,gender,pointsAvg);
        studentManager.add(student);
        System.out.println("=======Đã thêm mới thành công =====");
    }
    public void showMenuDelete(){
        System.out.println("=======Đây là mục xóa sinh viên =====");
        System.out.println("Nhập id muốn xóa");
        int id = inputInt.nextInt();
        Map<Integer,Student> list= studentManager.findAll();
        boolean check = list.containsKey(id);
        if (check){
            studentManager.delete(id);
        }
        else
        {System.out.println("Không có sinh viên này.");}
        System.out.println("=======Đã xóa thành công =====");
    }
    public void showMenuEdit(){
        System.out.println("=======Đây là mục sửa dữ liệu sinh viên =====");
        System.out.println("Nhập id muốn sửa");
        int id = inputInt.nextInt();
        Map<Integer,Student> list= studentManager.findAll();
        boolean check = list.containsKey(id);
        if (!check){
            System.out.println("Không có sinh viên này.");
        }
        else {
            System.out.println("Nhập tên muốn sửa đổi");
            String name = inputString.nextLine();
            System.out.println("Nhập giới tinh muốn sửa đổi");
            String gender = inputString.nextLine();
            System.out.println("Nhập điểm Toán sửa đổi : ");
            double math = inputInt.nextDouble();
            System.out.println("Nhập điểm Văn sửa đổi : ");
            double literature = inputInt.nextDouble();
            System.out.println("Nhập điểm Anh sửa đổi : ");
            double english = inputInt.nextDouble();
            double pointsAvg = (math+literature+english)/3;
            Student student = new Student(id,name,gender,pointsAvg);
            studentManager.edit(id,student);
            System.out.println("=======Đã sửa đổi thành công =====");

        }

    }
    public void showMenuShowStudent(){
        System.out.println("=======Đây là mục tìm kiếm sinh viên theo tên gần đúng  =====");
        System.out.println("Nhập ký tự muốn tìm kiếm");
        String charactor = inputString.nextLine();
        Map<Integer,Student> list= studentManager.findAll();
        Map<Integer,Student>newList = new HashMap<>();
        for (Integer element: list.keySet()) {
            if (list.get(element).getName().toLowerCase().contains(charactor.toLowerCase())) {
                newList.put(element,list.get(element));
            }

        }


        System.out.println("Danh sách sinh viên có ký tự : " + charactor+ " là : ");
        for (Integer element:newList.keySet()) {
            System.out.println(newList.get(element));
        }
    }
    public void showMenuSearchById(){
        System.out.println("=======Đây là mục tìm kiếm sinh viên theo Id =====");
        System.out.println("Nhập id tên sinh viên bạn muốn tìm kiếm");
        int id = inputInt.nextInt();
        Map<Integer,Student> list= studentManager.findAll();
        boolean check = list.containsKey(id);
        if (check){
            System.out.println("Sinh viên bạn muốn tìm kiếm la : ");
            System.out.println(list.get(id));
        }
        else {
            System.out.println("Không có sinh viên này.");
        }

    }
    public void showMaxAvg(){
        System.out.println("=======Đây là mục hiển thị sinh viên có điểm trung bình cao nhất =====");
        Map<Integer,Student> list= studentManager.findAll();
        double max = 0;
        int index = -1;
        for (Integer element : list.keySet()) {
            if (list.get(element).getPointsAvg()>max){
                max = list.get(element).getPointsAvg();
                index = element;
            }

        }
        System.out.println("Sinh viên đạt điểm trung bình cào nhất là : "+ max+ "sinh viên đó là : " + list.get(index).getName());
    }
    public void showAll(){
        System.out.println("Danh sách sinh viên : ");
        Map<Integer,Student> list= studentManager.findAll();
        for (Integer element:list.keySet()) {
            System.out.println(list.get(element));
        }
    }




}

