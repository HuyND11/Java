public class Nguoi {
    private String tenDT;
    private String cmnd;
    private String gioiTinh;
    private String diaChi;
    private NgheNghiep nghe;
    private VC vacSin;

    public String getTenDT() {
        return tenDT;
    }
    public void setTenDT(String tenDT) {
        this.tenDT = tenDT;
    }

    public String getCMND() {
        return cmnd;
    } 
    public void setCMND(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getGioiTinh() {
        return gioiTinh;
    } 
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    } 
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    public VC getVacSin() {
        return vacSin;
    }
    public void setVacSin(VC vacSin) {
        this.vacSin = vacSin;
    }

    public NgheNghiep getNghe() {
        return nghe;
    }
    public void setNghe(NgheNghiep nghe) {
        this.nghe = nghe;
    }

    public Nguoi(String tenDT, String cmnd, String gioiTinh, String diaChi, NgheNghiep nghe, VC vacSin) {
        this.tenDT = tenDT;
        this.cmnd = cmnd;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.nghe = nghe;
        this.vacSin = vacSin;
    }

    public Nguoi() {
    }
    
}

