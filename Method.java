package Project;

import java.util.*;
import java.util.regex.Pattern;
import java.time.LocalDate;


class Method{
    // static ArrayList<Transport> arrTransport = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    // Phương thức nhập phương tiện va người lái xe
    public void inputTransport(ArrayList<Transport> arr, ArrayList<Error> arrError) {
        try {
            String name = inputName();
            String cardID = inputCardID();
            String gender = inputGender();
            System.out.println("Enter address:");
            String address = input.nextLine();
            String phoneNumber = inputPhone();
            String vehicle = inputVehicle();
            String manufacturer = inputManufacturer();
            String plates = inputPlates();
            String errorID = inputErrorID(arrError);
            System.out.println("Enter Date Of Violation:");
            System.out.println("Enter Day:");
            int day = input.nextInt();
            System.out.println("Enter Month:");
            int month = input.nextInt();
            System.out.println("Enter Year:");
            int year = input.nextInt();
            do {
                if (Date.chekcDate(day, month, year)) {
                    break;
                } else {
                    System.out.println("Date Of Violation is wrong, enter agian:");
                    System.out.println("Enter Day:");
                    day = input.nextInt();
                    System.out.println("Enter month:");
                    month = input.nextInt();
                    System.out.println("Enter year:");
                    year = input.nextInt();
                }
            } while (true);
            input.nextLine();
            System.out.println("If 'The fine has been paid' enter 'done' ");
            System.out.println("If 'Haven't paid the fine 'not yet' ");
            System.out.println("Enter status:");
            boolean status = checkStatus();
            arr.add(new Transport(vehicle, manufacturer, plates, new Error(errorID), new Date(day, month, year),
                    new Violator(name, gender, address, phoneNumber, cardID, new Error(errorID)), status));
        } catch (Exception e) {
            System.out.println("Input error, please enter agian");
            input.nextLine();
            inputTransport(arr, arrError);
        }
    }
        

    // Phuong thuc check da nop phat hay chua
    public static boolean checkStatus(){
        String status = input.nextLine();
        if(status.equals("done") || status.equals("Done")){
            return true;
        }else if (status.equals("not yet") || status.equals("Not yet")){
            return false;
        }else{
            System.out.println("Enter status agian:");
            checkStatus();
            return true;
        }
    }

    // Phuong thuc in ra trang thai nop phat
    public static String showStatus(boolean status){
        if (status == true){
            return "The fine has been paid";
        }
        if (status == false){
            return "Haven't paid the fine";
        }
        return null;
    }

    // Phuong thuc tim kiem theo trang thai nop phat
    public int searchStstus(ArrayList<Transport> arr){
        for(Transport i : arr){
            System.out.println("Enter status where you want find:");
            if (i.getStatus() == true){
                return arr.indexOf(i);
            }
        }
        return -1;
    }

    // Phuong thuc tim kiem theo card ID 
    public int searchCardID(String index,ArrayList<Transport> arr){
        for (Transport i : arr) {
            if (i.getViolator().getCardID().equals(index)) {
                return arr.indexOf(i);
            }
        }
        return -1;
    }

    // Phuong thuc tim kiem theo ten cua nguoi vi pham
    public  int searchName(String name, ArrayList<Transport> arr){
        for (Transport i : arr){
            if (i.getViolator().getName().equals(name)){
                return arr.indexOf(i);
            }
        }
        return -1;
    }

    // Phuong thuc hien thi thong tin cua toan bo nhung nguoi vi pham
    public void show(ArrayList<Transport> arr,ArrayList<Error> arrError){
        for(Transport i : arr){
            System.out.println("Violator");
            System.out.printf("|Name: %s | Gender: %s | Address: %s | Phone number: %s | Card ID: %s | ",i.getViolator().getName(),i.getViolator().getGender(),i.getViolator().getAddress(),i.getViolator().getPhoneNumber(),i.getViolator().getCardID());
            System.out.println();
            System.out.println("Transport");
            System.out.printf("| Vehicle: %s | Manufacturer: %s | Plates: %s | Date Of Violation: %d / %d / %d | Penalty payment status: %s |",i.getVehicle(),i.getManufacturer(),i.getPlates(),i.getDateOfViolation().getDay(),i.getDateOfViolation().getMonth(),i.getDateOfViolation().getYear(),showStatus(i.getStatus()));
            System.out.println();
            System.out.println("Error:");
            if(Method.searchIdError(i.getErrorID().getErrorID(), arrError) != -1){
                for(Error j : arrError){
                    if(j.getErrorID().equals(i.getErrorID().getErrorID())){
                        System.out.printf("| Error ID: %s | Error Name: %s | Fine: %s Vnd |",j.getErrorID(),j.getErrorName(),j.getFine());
                        break;
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    // Phuong thuc hien thi mot nguoi vi pham 
    public void showInf(int index,ArrayList<Transport> arr,ArrayList<Error> arrError){
        if (index != -1){
            System.out.println("Violator");
            System.out.printf("|Name: %s | Gender: %s | Address: %s | Phone number: %s | Card ID: %s | ",arr.get(index).getViolator().getName(),arr.get(index).getViolator().getGender(),arr.get(index).getViolator().getAddress(),arr.get(index).getViolator().getPhoneNumber(),arr.get(index).getViolator().getCardID());
            System.out.println();
            System.out.println("Transport");
            System.out.printf("| Vehicle: %s | Manufacturer: %s | Plates: %s | Date Of Violation: %d / %d / %d | Penalty payment status: %s |",arr.get(index).getVehicle(),arr.get(index).getManufacturer(),arr.get(index).getPlates(),arr.get(index).getDateOfViolation().getDay(),arr.get(index).getDateOfViolation().getMonth(),arr.get(index).getDateOfViolation().getYear(),showStatus(arr.get(index).getStatus()));
            System.out.println();
            System.out.println("Error:");
            System.out.printf("| Error ID: %s | Error Name: %s | Fine: %s Vnd |",arrError.get(searchIdError(arr.get(index).getErrorID().getErrorID(), arrError)).getErrorID(),arrError.get(searchIdError(arr.get(index).getErrorID().getErrorID(), arrError)).getErrorName(),arrError.get(searchIdError(arr.get(index).getErrorID().getErrorID(), arrError)).getFine());                
        }else{
            System.out.println("Error");
        }
    }

    // Phuong thuc hien thi theo status
    public void showStatus(Boolean status,ArrayList<Transport> arr,ArrayList<Error> arrError){
        if( showStatus(status).equals("The fine has been paid")){
            for(Transport i : arr){
                System.out.println("Violator");
                System.out.printf("|Name: %s | Gender: %s | Address: %s | Phone number: %s | Card ID: %s |",i.getViolator().getName(),i.getViolator().getGender(),i.getViolator().getAddress(),i.getViolator().getPhoneNumber(),i.getViolator().getCardID());
                System.out.println();
                System.out.println("Transport");
                System.out.printf("| Vehicle: %s | Manufacturer: %s | Plates: %s | Date Of Violation: %d / %d / %d | Penalty payment status: %s |",i.getVehicle(),i.getManufacturer(),i.getPlates(),i.getDateOfViolation().getDay(),i.getDateOfViolation().getMonth(),i.getDateOfViolation().getYear(),showStatus(i.getStatus()));
                System.out.println();
                System.out.println("Error:");
                if(Method.searchIdError(i.getErrorID().getErrorID(), arrError) != -1){
                    for(Error j : arrError){
                        if(j.getErrorID().equals(i.getErrorID().getErrorID())){
                            System.out.printf("| Error ID: %s | Error Name: %s | Fine: %s Vnd |",j.getErrorID(),j.getErrorName(),j.getFine());
                            break;
                        }
                    }
                }
                System.out.println();
            }
        }

    }

    // Phuong thuc sap xep theo ten cua nguoi vi pham
    public void SortName(ArrayList<Transport> arr) {
        if(arr.size() > 1){
            for (int i = 0; i < arr.size(); i++) {
                for (int j = 0; j < arr.size() - j; j++) {
                    if (arr.get(j).getViolator().getName().compareTo(arr.get(j + 1).getViolator().getName()) > 0) {
                        Transport temp = arr.get(j);
                        arr.set(j, arr.get(j + 1));
                        arr.set(j + 1, temp);
                    }
                }
            }
        }else{
            System.out.println("Can't arrange");
        }
    }

    // Phuong thuc sap xep theo card ID cua nguoi vi pham
    public void SortCardID(ArrayList<Transport> arr) {
        if (arr.size() > 1){
            for (int i = 0; i < arr.size(); i++) {
                for (int j = 0; j < arr.size() - j; j++) {
                    if (arr.get(j).getViolator().getCardID().compareTo( arr.get(j + 1).getViolator().getCardID()) > 0) {
                        Transport temp = arr.get(j);
                        arr.set(j, arr.get(j + 1));
                        arr.set(j + 1, temp);
                    }
                }
            }
        }else{
            System.out.println("Can't arrange");
        }
    }

    // Phuong thuc xoa 1 nguoi vi pham
    public void remove(int index,ArrayList<Transport> arr){
        if(index != -1){
            arr.remove(index);
        }else{
            System.out.println("Error");
            
        }
    }

    // Phuong thuc them 1 phuong tien vi pham vao truoc 1 vi tri 
    public void insertBefore(int index, ArrayList<Transport> arr, ArrayList<Error> arrError) {
        if (index != -1) {
            try {
                String name = inputName();
                String cardID = inputCardID();
                String gender = inputGender();
                System.out.println("Enter address:");
                String address = input.nextLine();
                String phoneNumber = inputPhone();
                String vehicle = inputVehicle();
                String manufacturer = inputManufacturer();
                String plates = inputPlates();
                String errorID = inputErrorID(arrError);
                System.out.println("Enter Date Of Violation:");
                System.out.println("Enter Day:");
                int day = input.nextInt();
                System.out.println("Enter Month:");
                int month = input.nextInt();
                System.out.println("Enter Year:");
                int year = input.nextInt();
                do {
                    if (Date.chekcDate(day, month, year)) {
                        break;
                    } else {
                        System.out.println("Date Of Violation is wrong, enter agian:");
                        System.out.println("Enter Day:");
                        day = input.nextInt();
                        System.out.println("Enter month:");
                        month = input.nextInt();
                        System.out.println("Enter year:");
                        year = input.nextInt();
                    }
                } while (true);
                input.nextLine();
                System.out.println("If 'The fine has been paid' enter 'done' ");
                System.out.println("If 'Haven't paid the fine 'not yet' ");
                System.out.println("Enter status:");
                boolean status = checkStatus();
                arr.add(index,
                        new Transport(vehicle, manufacturer, plates, new Error(errorID), new Date(day, month, year),
                                new Violator(name, gender, address, phoneNumber, cardID, new Error(errorID)), status));
            } catch (Exception e) {
                System.out.println("Input error, please enter agian");
                input.nextLine();
                insertBefore(index, arr, arrError);
            }
        } else {
            System.out.println("Error");
        }
    }

    // Phuong thuc them 1 phuong tien vi pham vao sau 1 vi tri
    public void insertAfter(int index, ArrayList<Transport> arr, ArrayList<Error> arrError) {
        if (index != -1) {
            try {
                String name = inputName();
                String cardID = inputCardID();
                String gender = inputGender();
                System.out.println("Enter address:");
                String address = input.nextLine();
                String phoneNumber = inputPhone();
                String vehicle = inputVehicle();
                String manufacturer = inputManufacturer();
                String plates = inputPlates();
                String errorID = inputErrorID(arrError);
                System.out.println("Enter Date Of Violation:");
                System.out.println("Enter Day:");
                int day = input.nextInt();
                System.out.println("Enter Month:");
                int month = input.nextInt();
                System.out.println("Enter Year:");
                int year = input.nextInt();
                do {
                    if (Date.chekcDate(day, month, year)) {
                        break;
                    } else {
                        System.out.println("Date Of Violation is wrong, enter agian:");
                        System.out.println("Enter Day:");
                        day = input.nextInt();
                        System.out.println("Enter month:");
                        month = input.nextInt();
                        System.out.println("Enter year:");
                        year = input.nextInt();
                    }
                } while (true);
                input.nextLine();
                System.out.println("If 'The fine has been paid' enter 'done' ");
                System.out.println("If 'Haven't paid the fine 'not yet' ");
                System.out.println("Enter status:");
                boolean status = checkStatus();
                arr.add(index + 1,
                        new Transport(vehicle, manufacturer, plates, new Error(errorID), new Date(day, month, year),
                                new Violator(name, gender, address, phoneNumber, cardID, new Error(errorID)), status));
            } catch (Exception e) {
                System.out.println("Input error, please enter agian");
                input.nextLine();
                insertAfter(index +1, arr, arrError);
            }
        } else {
            System.out.println("Error");
        }
    }

     /* Phuong thuc Update information  */

        // Update ten
        public void updateName (int index,ArrayList<Transport> arr){
            if(index != -1){
                try {
                    arr.get(index).getViolator().setName(inputName());
                } catch (Exception e) {
                    System.out.println("Input error, please enter agian");
                    input.nextLine();
                    updateName(index, arr);
                }
            }else{
                System.out.println("Error");
            }
        }

        // Update Card ID
        public void updateCardId (int index,ArrayList<Transport> arr){
            if(index != -1){
                try {
                    arr.get(index).getViolator().setCardID(inputCardID());
                } catch (Exception e) {
                    System.out.println("Input error, please enter agian");
                    updateCardId(index, arr);
                }
            }else{
                System.out.println("Error");
            }
        }

        // Update Gender
        public void updateGender (int index,ArrayList<Transport> arr){
            if(index != -1){
                arr.get(index).getViolator().setGender(inputGender());
            }else{
                System.out.println("Error");
            }
        }

        // Update Phone number
        public void updatePhoneNumber (int index,ArrayList<Transport> arr){
            if(index != -1){
                arr.get(index).getViolator().setPhoneNumber(inputPhone());
            }else{
                System.out.println("Error");
            }
        }

        // Update Address
        public void updateAddress (int index,ArrayList<Transport> arr){
            if(index != -1){
                System.out.println("Enter address update");
                arr.get(index).getViolator().setAddress(input.nextLine());
            }else{
                System.out.println("Error");
            }
        }

        // Update Loai xe
        public void updateLoaiXe (int index,ArrayList<Transport> arr){
            if(index != -1){
                arr.get(index).setVehicle(inputVehicle());
            }else{
                System.out.println("Error");
            }
        }

        // Update Hang xe
        public void updateHangXe(int index,ArrayList<Transport> arr){
            if(index != -1){
                arr.get(index).setManufacturer(inputManufacturer());
            }else{
                System.out.println("Error");
            }
        }

        // Update Hang xe
        public void updatePlates(int index,ArrayList<Transport> arr){
            if(index != -1){
                System.out.println("Enter Plates");
                arr.get(index).setPlates(input.nextLine());
            }else{
                System.out.println("Error");
            }
        }

        // Update ID Loi
        public void updateErrorID(int index,ArrayList<Transport> arr){
            if(index != -1){
                arr.get(index).getErrorID().setErrorID(inputErrorID(Main.arrError));
            }else{
                System.out.println("Error");
            }
        }

        // Update Ngay Vi Pham
        public void updateNgayViPham(int index,ArrayList<Transport> arr){
            if(index != -1){
                try{
                    System.out.println("Enter Date Of Violation update:");
                    System.out.println("Enter day:");
                    int day = input.nextInt();
                    System.out.println("Enter month:");
                    int month = input.nextInt();
                    System.out.println("Enter year:");
                    int year = input.nextInt();
                    do{
                        if(Date.chekcDate(day, month, year)){
                            arr.get(index).getDateOfViolation().setDay(day);
                            arr.get(index).getDateOfViolation().setMonth(month);
                            arr.get(index).getDateOfViolation().setYear(year);
                            break;
                        }else{
                            System.out.println("Date Of Violation is wrong, enter agian:");
                            System.out.println("Enter day:");
                            day = input.nextInt();
                            System.out.println("Enter month:");
                            month = input.nextInt();
                            System.out.println("Enter year:");
                            year = input.nextInt();
                        }
                    }
                    while(true);
                }catch( Exception e){
                    System.out.println("Input Error");
                    Main.menuTransport();
                }
            }else{
                System.out.println("Error");
            }
        }

        // Update Status
        public void updateStatus(int index,ArrayList<Transport> arr){
            if(index != -1){
                System.out.println("Enter status update");
                String status = input.nextLine();
                if(status.equals("done") || status.equals("Done")){
                    arr.get(index).setStatus(true);
                }
                if(status.equals("not yet") || status.equals("Not yet")){
                    arr.get(index).setStatus(false);
                }
            }else{
                System.out.println("Error");
            }
        }


        // Loi vi pham 

        // Phuong thuc them 1 loi moi vao danh sach loi
        public void inputError(ArrayList<Error> arrError){
            arrError.add(new Error(inputErrorIDArrError(), inputErrorName(), inputErrorFine()));
        }

        // Phuong thuc xoa 1 loi ra khoi danh sach loi
        public void removeError(int index ,ArrayList<Error> arrError){
            if (index != -1){
                arrError.remove(index);
            }else{
                System.out.println("Error");
            }
        }

        // Phuong thuc update Error 

        // Phuong thuc update Error ID
        public void updateErrorIDInArrError(int index, ArrayList<Transport> arr, ArrayList<Error> arrError){
            if(index != -1){
                String idUpdate = inputErrorIDArrError();
                for(Transport i : arr){
                    System.out.println(i.getErrorID().getErrorID());
                    if(i.getErrorID().getErrorID().equals(arrError.get(index).getErrorID())){
                        i.getErrorID().setErrorID(idUpdate);
                    }
                }
                arrError.get(index).setErrorID(idUpdate);
            }else{
                System.out.println("Error");
            }
        }

        // Phuong thuc update ten loi
        public void updateErrorName(int index ,ArrayList<Error> arrError){
            if(index != -1){
                arrError.get(index).setErrorName(inputErrorName());
            }else{
                System.out.println("Error");
            }
        }

        // Phuong thuc update tien phat
        public void updateErrorFine(int index ,ArrayList<Error> arrError){
            if(index != -1){
                arrError.get(index).setFine(inputErrorFine());
            }else{
                System.out.println("Error");
            }
        }

        // Phuong thuc hien thi tat ca cac loi
        public void showError(ArrayList<Error> arrError){
            for(Error i : arrError){
                System.out.printf("| Error ID: %s | Error Name: %s | Fine: %s Vnd |", i.getErrorID(), i.getErrorName(),i.getFine());
                System.out.println();
            }
        }

        // Phuong thuc hien thi 1 loi vi pham
        public void showErrorBy(int index ,ArrayList<Error> arrError){
            if(index != -1){
                System.out.printf("| Error ID: %s | Error Name: %s | Fine: %s Vnd |" , arrError.get(index).getErrorID(),arrError.get(index).getErrorName(),arrError.get(index).getFine());
                System.out.println();
            }
        }

        // Phuong thuc tim kiem loi vi pham
    public static int searchIdError(String errorID, ArrayList<Error> arr){
        for (Error i : arr){
            if (i.getErrorID().equals(errorID)){
                return arr.indexOf(i);
            }
        }
        return -1;
    }

    // Sap xep Error

    public void sortErrorByID(ArrayList<Error> arrError){
        if (arrError.size() > 1){
            for (int i = 0; i < arrError.size(); i++) {
                for (int j = 0; j < arrError.size() - j; j++) {
                    if (arrError.get(j).getErrorID().compareTo( arrError.get(j + 1).getErrorID()) > 0) {
                        Error temp = arrError.get(j);
                        arrError.set(j, arrError.get(j + 1));
                        arrError.set(j + 1, temp);
                    }
                }
            }
        }else{
            System.out.println("Can't arrange");
        }
    }

    public void sortErrorByName(ArrayList<Error> arrError){
        if (arrError.size() > 1){
            for (int i = 0; i < arrError.size(); i++) {
                for (int j = 0; j < arrError.size() - j; j++) {
                    if (arrError.get(j).getErrorName().compareTo( arrError.get(j + 1).getErrorName()) > 0) {
                        Error temp = arrError.get(j);
                        arrError.set(j, arrError.get(j + 1));
                        arrError.set(j + 1, temp);
                    }
                }
            }
        }else{
            System.out.println("Can't arrange");
        }
    }


    public static Pattern checkName = Pattern.compile("^[a-z A-z 1-9]{1,50}+$");
    public static Pattern checkPhone = Pattern.compile("^0[0-9]{9}+$");
    public static Pattern checkPlates = Pattern.compile("^[0-9]{2}-[A-z 0-9]{2} [0-9]{4,5}+$");
    public static Pattern checkFine = Pattern.compile("^[0-9]{3} [0-9]{3,6}+$");

    public String inputName() {
        System.out.println("Enter Name:");
        String name = input.nextLine();
        do {
            if (checkName.matcher(name).find()) {
                return name;
            } else {
                System.out.println("Enter Name agian:");
                name = input.nextLine();
            }
        } while (true);
    }

    public String inputGender() {
        System.out.println("Enter gender:");
        System.out.println("'male' or 'female");
        String gender = input.nextLine();
        do {
            if (gender.equals("male") || gender.equals("female") || gender.equals("Male") || gender.equals("Female")) {
                return gender;
            } else {
                System.out.println("Enter gender again:");
                gender = input.nextLine();
            }
        } while (true);
    }

    public String inputPhone(){
        System.out.println("Enter phone number:");
        String phoneNumber = input.nextLine();
        do {
            if (checkPhone.matcher(phoneNumber).find()) {
                return phoneNumber;
            } else {
                System.out.println("Enter phone number again:");
                phoneNumber = input.nextLine();
            }
        } while (true);
    }

    public String inputCardID() {
        System.out.println("Enter card ID:");
        String cardID = input.nextLine();
        do {
            if (cardID.length() == 9 && searchCardID(cardID, Main.arrTransport) == -1) {
                return cardID;
            } else {
                System.out.println("Enter card ID again:");
                cardID = input.nextLine();
            }
        } while (true);
    }

    public String inputVehicle() {
        System.out.println("Enter vehicle:");
        String vehicle = input.nextLine();
        do {
            if (checkName.matcher(vehicle).find()) {
                return vehicle;
            } else {
                System.out.println("Enter vehicle agian:");
                vehicle = input.nextLine();
            }
        } while (true);
    }

    public String inputManufacturer() {
        System.out.println("Enter manufacturer:");
        String manufacturer = input.nextLine();
        do {
            if (checkName.matcher(manufacturer).find()) {
                return manufacturer;
            } else {
                System.out.println("Enter manufacturer agian:");
                manufacturer = input.nextLine();
            }
        } while (true);
    }

    public String inputPlates(){
        System.out.println("Enter plates:");
        String plates = input.nextLine();
        do {
            if (checkPlates.matcher(plates).find()) {
                return plates;
            } else {
                System.out.println("Enter plates agian:");
                plates = input.nextLine();
            }
        } while (true);
    }

    public String inputErrorID(ArrayList<Error> arrError){
        for (Error i : arrError) {
            System.out.printf("| Error ID: %s | Error name: %s | Fine: %s Vnd|", i.getErrorID(), i.getErrorName(),
                    i.getFine());
            System.out.println();
        }
        System.out.println("Enter Error ID:");
        String errorID = input.nextLine();
        do {
            if (searchIdError(errorID, arrError) == -1) {
                System.out.println("Error ID doesn't exits, Enter again:");
                System.out.println("Enter Error ID:");
                errorID = input.nextLine();
            } else {
                return errorID;
            }
        } while (true);
    }

    public LocalDate daytime() {
        LocalDate date;
        try {
            System.out.println("Enter Date Of Violation:");
            System.out.print("Enter Day:");
            int day = input.nextInt();
            System.out.print("Enter Month:");
            int month = input.nextInt();
            System.out.print("Enter Year:");
            int year = input.nextInt();
            try {
                date = LocalDate.of(day, month, year);
                if (date.isAfter(LocalDate.now())) {
                    throw new Exception("");
                }
            } catch (Exception e) {
                System.out.println(e.toString());
                return daytime();
            }
            return date;
        } catch (Exception e) {
            System.out.println(e.toString());
            return daytime();
        }
    }

    public String inputErrorIDArrError(){
        System.out.println("Enter Error:");
        String errorID = input.nextLine();
        do {
            if (checkName.matcher(errorID).find() && searchIdError(errorID, Main.arrError) == -1) {
                return errorID;
            } else {
                System.out.println("Enter Error agian:");
                errorID = input.nextLine();
            }
        } while (true);
    }

    public String inputErrorName(){
        System.out.println("Enter Name:");
        String ErrorName = input.nextLine();
        do {
            if (checkName.matcher(ErrorName).find()) {
                return ErrorName;
            } else {
                System.out.println("Enter Name agian:");
                ErrorName = input.nextLine();
            }
        } while (true);
    }

    public String inputErrorFine(){
        System.out.println("Enter Fine:");
        String ErrorFine = input.nextLine();
        do {
            if (checkFine.matcher(ErrorFine).find()) {
                return ErrorFine;
            } else {
                System.out.println("Enter Fine agian:");
                ErrorFine = input.nextLine();
            }
        } while (true);
    }

}


