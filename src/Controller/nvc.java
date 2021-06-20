package Controller;
import Model.phongban;

import java.sql.*;
import java.util.ArrayList;

public class nvc {
    Connection conn1 = null;
    Statement stmt = null;
    ResultSet rs = null;

    public Connection connection(){
        try {
            String url1 = "jdbc:mysql://localhost:3306/bkacad";
            String user = "root";
            String password = "";

            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Connected to the database test1");
            }

        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        return conn1;
    }

    public void close(){
            if (conn1 != null) {
                try {
                    conn1.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

    public ArrayList<phongban> getAllPb() throws SQLException {
        ArrayList<phongban> pb = new ArrayList<phongban>();
        Connection conn = connection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM `phongban`");
        while (rs.next()) {
            int a= rs.getInt(1);
            String b= rs.getString(2);
            phongban arr = new phongban(a,b);
            pb.add(arr);
        }
        close();
    return pb;
    }

    public void insertpb(String b,int a) throws SQLException{
        String sql="INSERT INTO `phongban`(`MaPB`, `TenPB`) VALUES (?,?)";
        Connection conn = connection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, Integer.parseInt(String.valueOf(a)));
        stmt.setString(2, b);
        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }
        close();
    }

    public void updatepb(String b, int a) throws SQLException{
        String sql = "UPDATE `phongban` SET `TenPB`=? WHERE `MaPB`=?";
        Connection conn = connection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, b);
        stmt.setInt(2, a );
        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was updated successfully!");
        }
        close();
    }

    public void deletepb(int a) throws SQLException{
        String sql = "DELETE FROM `phongban` WHERE MaPB=?";
        Connection conn = connection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, a);
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A user was deleted successfully!");
        }
        close();
    }

    public String string(){
        return "haha";
    }


}
/*
Phòng ban:
    Xem tất cả phong ban
    thêm mới 1 phòng ban
    xóa phong ban theo id
    sua 1 ban ghi

Nhân viên:
    xem tất cả nhân viên
    thêm mơi một nhân viên
    xóa nhân viên theo id
    tìm kiếm tên nhân viên
 */