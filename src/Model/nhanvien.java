package Model;

public class nhanvien {
    private int maNv;
    private String tenNv;
    private phongban phongban;
    public nhanvien(int maNv, String tenNv, Model.phongban phongban) {
        this.maNv = maNv;
        this.tenNv = tenNv;
        this.phongban = phongban;
    }

    public int getMaNv() {
        return maNv;
    }

    public void setMaNv(int maNv) {
        this.maNv = maNv;
    }

    public String getTenNv() {
        return tenNv;
    }

    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }

    public Model.phongban getPhongban() {
        return phongban;
    }

    public void setPhongban(Model.phongban phongban) {
        this.phongban = phongban;
    }
}
