public class NgheNghiep {
    private String tenCongViec;
    private String maCongViec;


    public String getTenCongViec() {
        return tenCongViec;
    } 
    public void setTenCongViec(String tenCongViec) {
        this.tenCongViec = tenCongViec;
    }
    public String getMaCongViec() {
        return maCongViec;
    }
    public void setMaCongViec(String maCongViec) {
        this.maCongViec = maCongViec;
    }
    
    public NgheNghiep(String maCongViec ,String tenCongViec) {
        this.tenCongViec = tenCongViec;
        this.maCongViec = maCongViec;
    }
    public NgheNghiep(String maCongViec) {
        this.maCongViec = maCongViec;
    }
}
