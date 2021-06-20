package View;
import Controller.nvc;
import Model.phongban;
import Model.nhanvien;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int choice = 0;
        String b;
        int a;
        var controller = new nvc();
        var PB = new ArrayList<phongban>();
        var NV = new ArrayList<nhanvien>();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("_______________MENU_______________");
            System.out.println("1. Hien thi pb.");
            System.out.println("2. Them 1 pb");
            System.out.println("3. Sua 1 phong ban theo ma");
            System.out.println("4. Xoa 1 pb theo ma");
            System.out.println("0. Thoát khỏi ứng dụng.");
            System.out.println("Bạn chọn ? ");

            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("_____________________________________________");
                    System.out.println("Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi!");
                    break;
                case 1:
                    try {
                        PB = controller.getAllPb();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    finally {
                        if (PB != null) {
                            showPbInfo(PB);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Nhập tên pb: ");
                    b = scanner.nextLine();
                    System.out.println("Nhập mã bp: ");
                    a = scanner.nextInt();
                    try {
                        controller.insertpb(b,a);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("Nhập ten pb moi: ");
                    b = scanner.nextLine();
                    System.out.println("Nhập ma pb can sua: ");
                    a = scanner.nextInt();
                    try {
                        controller.updatepb(b,a);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("Nhập ma pb can sua: ");
                    a = scanner.nextInt();
                    try {
                        controller.deletepb(a);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
            }

        }while (choice != 0);
    }

    private static void showPbInfo(ArrayList<phongban> pb) {
        System.out.println("_________________Thông tin pb trong mysql_________________");
        for (var b : pb) {
            System.out.println(b);
        }
    }
}
