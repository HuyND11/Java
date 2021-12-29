public class VC {
    private String maVC;
    private String tenVC;

    public String getTenVC() {
        return tenVC;
    }
    public void setTenVC(String tenVC) {
        this.tenVC = tenVC;
    }
    public void setMaVC(String maVC) {
        this.maVC = maVC;
    }
    public String getMaVC() {
        return maVC;
    }

    public VC(String maVC, String tenVC) {
        this.maVC = maVC;
        this.tenVC = tenVC;
    }

    public VC(String maVC) {
        this.maVC = maVC;
    }
}
