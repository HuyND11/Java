import java.util.*;

public class Main {
    static ArrayList<Nguoi> arrNguoi = new ArrayList<>();
    static ArrayList<VC> arrVC = new ArrayList<>();
    static ArrayList<NgheNghiep> arrCV = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void inputInf(){
        try {
            input.nextLine();
            System.out.println("Nhap ten cua doi tuong tiem vac sin");
            String ten = input.nextLine();
            System.out.println("Nhap CMND cua doi tuong tiem vac sin");
            String cmnd = input.nextLine();
            System.out.println("Nhap gioi tinh cua doi tuong tiem vac sin");
            String gioiTinh = input.nextLine();
            System.out.println("Nhap dia chi cua doi tuong tiem vac sin");
            String diaChi = input.nextLine();
            System.out.println("Danh sach Cong Viec Va Ma Cong Viec");
            for(NgheNghiep i : arrCV){
                System.out.printf("| Ma Cong Viec: %s | Ten Cong Viec: %s |",i.getMaCongViec(),i.getTenCongViec());
                System.out.println();
            }
            System.out.println("Nhap ma Cong Viec cua doi tuong tiem vac sin");
            String maCV = input.nextLine();
            do{
                if (searchCV(maCV) == -1){
                    System.out.println("Cong Viec Khong Ton Tai:");
                    System.out.println("Nhap Lai:");
                    maCV = input.nextLine();
                }
                else
                {
                    break;
                }
            }
            while(true);
            System.out.println("Danh sach Cong Viec Va Ma Cong Viec");
            for(VC i : arrVC){
                System.out.printf("| Ma Vac Sin: %s | Ten Vac Sin: %s |",i.getMaVC(),i.getTenVC());
                System.out.println();
            }
            System.out.println("Nhap Ma Vac sin tiem cho doi tuong");
            String maVC = input.nextLine();
            do{
                if (searchVC(maVC) == -1){
                    System.out.println("Khong Co Loai Vac Sin:");
                    System.out.println("Nhap Lai:");
                    maVC = input.nextLine();
                }
                else
                {
                    break;
                }
            }
            while(true);
            arrNguoi.add(new Nguoi(ten, cmnd, gioiTinh, diaChi, new NgheNghiep(maCV), new VC(maVC)));
        } catch (Exception e) {
            menu();
        }
        
    }

    public static void showInf(){
        for (Nguoi i : arrNguoi){
            System.out.printf("| Ten: %s | CMND: %s | Gioi Tinh: %s | Dia Chi: %s | Ma Cong Viec: %s | Ten Cong Viec: %s | Ma Vac Sin: %s | ", i.getTenDT(),i.getCMND(),i.getGioiTinh(),i.getDiaChi(),i.getNghe().getMaCongViec(),i.getNghe().getTenCongViec(),i.getVacSin().getMaVC());
            System.out.println();
            System.out.println("Loai Vac Sin da tiem:");
            if(searchVC(i.getVacSin().getMaVC()) != -1){
                for(VC j : arrVC){
                    if(j.getMaVC().equals(i.getVacSin().getMaVC())){
                        System.out.printf("| Ma Vac Sin: %s | Ten VAc Sin: %s |",j.getMaVC(),j.getTenVC());
                        break;
                    }
                }
            }
            System.out.println();
        }
    }

    public static int searchVC(String maVC){
        for (VC i : arrVC){
            if (i.getMaVC().equals(maVC)){
                return arrVC.indexOf(i);
            }
        }
        return -1;
    }

    public static int searchCV(String maCV){
        for (NgheNghiep i : arrCV){
            if (i.getMaCongViec().equals(maCV)){
                return arrCV.indexOf(i);
            }
        }
        return -1;
    }

    public static void showByMaCV(){
        if(arrNguoi.size() > 0){
            System.out.println("Danh sach Cong Viec Va Ma Cong Viec");
            for(NgheNghiep i : arrCV){
                System.out.printf("| Ma Cong Viec: %s | Ten Cong Viec: %s |",i.getMaCongViec(),i.getTenCongViec());
                System.out.println();
            }
            input.nextLine();
            System.out.println("Nhap ma Cong Viec ma ban muon hien thi:");
            String maCV = input.nextLine();
            for(Nguoi i : arrNguoi){
                if( i.getNghe().getMaCongViec().equals(maCV)){
                    System.out.printf("| Ten: %s | CMND: %s | Gioi Tinh: %s | Dia Chi: %s | Ma Cong Viec: %s | Ten Cong Viec: %s | Ma Vac Sin: %s | ", i.getTenDT(),i.getCMND(),i.getGioiTinh(),i.getDiaChi(),i.getNghe().getMaCongViec(),i.getNghe().getTenCongViec(),i.getVacSin().getMaVC());
                    System.out.println();
                    System.out.println("Loai Vac Sin da tiem:");
                    if(searchVC(i.getVacSin().getMaVC()) != -1){
                        for(VC j : arrVC){
                            if(j.getMaVC().equals(i.getVacSin().getMaVC())){
                                System.out.printf("| Ma Vac Sin: %s | Ten VAc Sin: %s |",j.getMaVC(),j.getTenVC());
                                break;
                            }
                        }
                    }
                }
                System.out.println();
            }
        }
    }

    public static void showByMaVC(){
        if(arrNguoi.size() > 0){
            System.out.println("Danh sach Cong Viec Va Ma Cong Viec");
            for(VC i : arrVC){
                System.out.printf("| Ma Vac Sin: %s | Ten Vac Sin: %s |",i.getMaVC(),i.getTenVC());
                System.out.println();
            }
            input.nextLine();
            System.out.println("Nhap ma Vac Sin ma ban muon hien thi:");
            String maVC = input.nextLine();
            for(Nguoi i : arrNguoi){
                if(i.getVacSin().getMaVC().equals(maVC)){
                    System.out.printf("| Ten: %s | CMND: %s | Gioi Tinh: %s | Dia Chi: %s | Ma Cong Viec: %s | Ten Cong Viec: %s | Ma Vac Sin: %s | ", i.getTenDT(),i.getCMND(),i.getGioiTinh(),i.getDiaChi(),i.getNghe().getMaCongViec(),i.getNghe().getTenCongViec(),i.getVacSin().getMaVC());
                    System.out.println();
                    System.out.println("Loai Vac Sin da tiem:");
                    if(searchVC(i.getVacSin().getMaVC()) != -1){
                        for(VC j : arrVC){
                            if(j.getMaVC().equals(i.getVacSin().getMaVC())){
                                System.out.printf("| Ma Vac Sin: %s | Ten VAc Sin: %s |",j.getMaVC(),j.getTenVC());
                                break;
                            }
                        }
                    }
                }
                System.out.println();
            }
        }
    }

    public static void showByDiaChi(){
        if(arrNguoi.size() > 0){
            input.nextLine();
            System.out.println("Nhap dia chi ma ban muon hien thi:");
            String diaChi = input.nextLine();
            for(Nguoi i : arrNguoi){
                if(i.getDiaChi().equals(diaChi)){
                    System.out.printf("| Ten: %s | CMND: %s | Gioi Tinh: %s | Dia Chi: %s | Ma Cong Viec: %s | Ten Cong Viec: %s | Ma Vac Sin: %s | ", i.getTenDT(),i.getCMND(),i.getGioiTinh(),i.getDiaChi(),i.getNghe().getMaCongViec(),i.getNghe().getTenCongViec(),i.getVacSin().getMaVC());
                    System.out.println();
                    System.out.println("Loai Vac Sin da tiem:");
                    if(searchVC(i.getVacSin().getMaVC()) != -1){
                        for(VC j : arrVC){
                            if(j.getMaVC().equals(i.getVacSin().getMaVC())){
                                System.out.printf("| Ma Vac Sin: %s | Ten VAc Sin: %s |",j.getMaVC(),j.getTenVC());
                                break;
                            }
                        }
                    }
                }
                System.out.println();
            }
        }
    }

    public static void sortByTen(){
        try {
            for (int i = 0; i < arrNguoi.size(); i++) {
                for (int j = 0; j < arrNguoi.size() - j; j++) {
                    if (arrNguoi.get(j).getTenDT().compareTo(arrNguoi.get(j + 1).getTenDT()) > 0) {
                        Nguoi temp = arrNguoi.get(j);
                        arrNguoi.set(j, arrNguoi.get(j + 1));
                        arrNguoi.set(j + 1, temp);
                    }
                }
            }
            
        } catch (Exception e) {
            System.out.println("Khong Sap Xep Duoc");
            menu();
        }
        
    }

    public static void sortByMaCV(){
        try {
            for (int i = 0; i < arrNguoi.size(); i++) {
                for (int j = 0; j < arrNguoi.size() - j; j++) {
                    if (arrNguoi.get(j).getNghe().getMaCongViec().compareTo(arrNguoi.get(j + 1).getNghe().getMaCongViec()) < 0) {
                        Nguoi temp = arrNguoi.get(j);
                        arrNguoi.set(j, arrNguoi.get(j + 1));
                        arrNguoi.set(j + 1, temp);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Khong Sap Xep Duoc");
            menu();
        }
    }

    public static void menu(){
        System.out.println("Nhap 0 de thoat chuong trinh");
        System.out.println("Nhap 1: Them 1 doi tuong moi da tiem Vac Sin");
        System.out.println("Nhap 2: Hien thi ra tat ca cac doi tuong da tiem Vac Sin");
        System.out.println("Nhap 3: Hien thi ra 1 nhom doi tuong can da tiem Vac Sin");
        System.out.println("Nhap 4: Sap xep cac doi tuong da tiem Vac Sin");
        byte option = input.nextByte();
        switch(option){
            case 0 -> {
                System.out.println("Tam Biet");
                break;
            }
            case 1 -> {
                inputInf();
                menu();
            }
            case 2 -> {
                showInf();
                menu();
            }
            case 3 -> {
                System.out.println("Nhap 0 de quay lai menu:");
                System.out.println("Ban muon hien thi theo:");
                System.out.println("Nhap 1 de hien thi theo nhom Doi Tuong:");
                System.out.println("Nhap 2 de hien thi theo loai Vac Sin :");
                System.out.println("Nhap 3 de hien thi theo Dia Chi :");
                byte choose = input.nextByte();
                switch(choose){
                    case 0 -> {
                        menu();
                    }
                    case 1 -> {
                        showByMaCV();
                        menu();
                    }
                    case 2 -> {
                        showByMaVC();
                        menu();
                    }
                     case 3 -> {
                        showByDiaChi();
                        menu();
                    }
                    default -> {
                        menu();
                    }
                }
            }
            case 4 -> {
                System.out.println("Enter 0 de quay lai menu:");
                System.out.println("Ban muon sap xep theo:");
                System.out.println("Enter 1 de sap xep theo Ten:");
                System.out.println("Enter 2 de sap xep theo Ma Cong Viec:");
                byte choose = input.nextByte();
                switch(choose){
                    case 0 -> {
                        menu();
                    }
                    case 1 -> {
                        sortByTen();
                        showInf();
                        menu();
                    }
                    case 2 -> {
                        sortByMaCV();
                        showInf();
                        menu();
                    }
                    default -> {
                        menu();
                    }
                }
            }
            default -> {
                menu();
            }
        }
    }
    static{
        arrVC.add(new VC("A1", "AstraZeneca"));
        arrVC.add(new VC("S5", "SPUTNIK V"));
        arrVC.add(new VC("S1", "Sinopharm"));
        arrVC.add(new VC("P1", "Pfizer"));
        arrVC.add(new VC("M1", "Moderna"));


        arrCV.add(new NgheNghiep("SH","Shipper"));
        arrCV.add(new NgheNghiep("YT","Y Ta"));
        arrCV.add(new NgheNghiep("NVCH","Nhan Vien Chong Dich"));
        arrCV.add(new NgheNghiep("CA","Cong An"));
        arrCV.add(new NgheNghiep("DB","Bo Doi"));
        arrCV.add(new NgheNghiep("TX","Tai Xe"));

    }
    public static void main(String[] args) {
        menu();
    }
}
