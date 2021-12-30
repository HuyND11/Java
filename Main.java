package Project;

import java.util.*;

class Main {
    static ArrayList<Error> arrError = new ArrayList<>();
    static ArrayList<Transport> arrTransport = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static Method obj = new Method();

    static{
        arrError.add(new Error("A1", "Running a red light", "200 000"));
        arrError.add(new Error("A2", "Over speed limit", "500 000"));
        arrError.add(new Error("B1", "Not old enough to drive", "200 000"));
        arrError.add(new Error("B2", "No helmet", "300 000"));
        arrError.add(new Error("B3", "Carries more persons specified", "500 000"));
        arrTransport.add(new Transport("moto", "Honda", "77-F1 1232", new Error("B3"), new Date(15,8,2020), new Violator("Huy", "Male", "101B Le Huu Trac", "0971168760", "215554314", new Error("B3")), true));
        arrTransport.add(new Transport("Car", "Mercedes", "74-F1 99999", new Error("A2"), new Date(28,6,2021), new Violator("Thao", "Female", "Quang Tri", "0397124293", "123456789", new Error("A2")), false));
        arrTransport.add(new Transport("Car", "Toyota", "77-F1 8888", new Error("A1"), new Date(11,5,2021), new Violator("Nguyen Van 12", "Male", "Binh Dinh", "0123456789", "987654321", new Error("A1")), true));
    }

    public static void menu(){
        System.out.println("Want to perform on: ");
        System.out.println("Enter number 1, with Transport");
        System.out.println("Enter number 2, with Error");
        System.out.println("Enter number 0, to exit");
        try {
            int option = input.nextInt();
            switch(option){
                case 0 -> {
                    System.out.println("Thank you for your used my application");
                    System.out.println("See you late");
                    break;
                }
                case 1 -> {
                    menuTransport();
                }
                case 2 ->{
                    menuError();
                }
                default -> {
                    menu();
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
            input.nextLine();
            menu();
        }
    }
    public static void menuTransport(){
        System.out.println("Enter 0 to back");
        System.out.println("Enter 1: Input new transport");
        System.out.println("Enter 2: Show all transport violate");
        System.out.println("Enter 3: Show 1 transport violate by");
        System.out.println("Enter 4: Sort transport");
        System.out.println("Enter 5: Add new transport");
        System.out.println("Enter 6: Remove 1 transport");
        System.out.println("Enter 7: Update information");
        System.out.println("Enter choose");
        try{
        int choose = input.nextInt();
            switch(choose){
                case 0 -> {
                    System.out.println("Back to home page");
                    System.out.println();
                    menu();
                }
                case 1-> {
                obj.inputTransport(arrTransport, arrError);
                menuTransport();
                }
                case 2 -> {
                    obj.show(arrTransport, arrError);
                    menuTransport();
                }
                case 3 -> {
                    System.out.println("Enter 0 to back:");
                    System.out.println("You want show by:");
                    System.out.println("Enter 1 to show by Card ID:");
                    System.out.println("Enter 2 to show by Name:");
                    System.out.println("Enter 3 to show by Status:");
                    int choice = input.nextInt();
                    switch(choice){
                        case 0 ->{
                            break;
                        }
                        case 1 -> {
                            input.nextLine();
                            System.out.println("Enter Card ID where you want show:");
                            obj.showInf(obj.searchCardID(input.nextLine(), arrTransport), arrTransport, arrError);
                        }
                        case 2 -> {
                            input.nextLine();
                            System.out.println("Enter name where you want show:");
                            obj.showInf(obj.searchName(input.nextLine(), arrTransport), arrTransport, arrError);
                        }
                        case 3 -> {
                            System.out.println("Enter Status where you want show:");
                            obj.showStatus(Method.checkStatus(), arrTransport, arrError);
                        }
                        default -> {
                            menuTransport();
                        }
                    }
                    menuTransport();
                }
                case 4 ->{
                    System.out.println("Enter 0 to back:");
                    System.out.println("You want sort by:");
                    System.out.println("Enter 1 to sort by card ID:");
                    System.out.println("Enter 2 to sort by name:");
                    int choice = input.nextInt();
                        switch(choice){
                            case 0 -> {
                                break;
                            }
                            case 1 -> {
                                obj.SortCardID(arrTransport);
                                System.out.println("List after sort");
                                obj.show(arrTransport, arrError);
                            }
                            case 2 -> {
                                obj.SortName(arrTransport);
                                System.out.println("List after sort");
                                obj.show(arrTransport, arrError);
                            }
                            default -> {
                                menuTransport();
                            }
                        }
                        menuTransport();
                    }
                case 5 ->{
                    System.out.println("Enter 0 to back:");
                    System.out.println("You want insert by");
                    System.out.println("Enter 1 to insert by card ID:");
                    System.out.println("Enter 2 to insert by name:");
                    int choice = input.nextInt();
                    switch(choice){
                        case 0 -> {
                            break;
                        }
                        case 1 -> {
                            System.out.println("Enter 0 to back:");
                            System.out.println("Do you want to insert before or after?");
                            System.out.println("Enter 1 to insert before:");
                            System.out.println("Enter 2 to insert after:");
                        int insert = input.nextInt();
                        switch(insert){
                            case 0 -> {
                                break;
                                }
                            case 1 -> {
                                input.nextLine();
                               System.out.println("where you want to insert");
                               obj.insertAfter(obj.searchCardID(input.nextLine(), arrTransport), arrTransport, arrError);
                               System.out.println("List after insert");
                                    obj.show(arrTransport, arrError);
                            }
                            case 2 -> {
                                input.nextLine();
                                System.out.println("where you want to insert");
                                obj.insertBefore(obj.searchCardID(input.nextLine(), arrTransport), arrTransport, arrError);
                                System.out.println("List after insert");
                                    obj.show(arrTransport, arrError);
                                }
                            default -> {
                                menuTransport();
                            }
                        }
                        menuTransport();
                        }   
                        case 2 -> {
                            System.out.println("Enter 0 to back:");
                            System.out.println("Do you want to insert before or after?");
                            System.out.println("Enter 1 to insert before:");
                            System.out.println("Enter 2 to insert after:");
                            int insert = input.nextInt();
                            switch(insert){
                                case 0 -> {
                                    break;
                                }
                                case 1 -> {
                                    input.nextLine();
                                    System.out.println("where you want to insert");
                                    obj.insertAfter(obj.searchName(input.nextLine(), arrTransport), arrTransport, arrError);
                                    System.out.println("List after insert");
                                    obj.show(arrTransport, arrError);
                                }
                                case 2 -> {
                                    input.nextLine();
                                    System.out.println("where you want to insert");
                                    obj.insertBefore(obj.searchName(input.nextLine(), arrTransport), arrTransport, arrError);
                                    System.out.println("List after insert");
                                    obj.show(arrTransport, arrError);
                                }
                                default -> {
                                    menuTransport();
                                }
                            }
                            menuTransport();
                        }
                        default -> {
                            menuTransport();
                        } 
                    }
                    menuTransport();
                }
            case 6 ->{
                System.out.println("Enter 0 to back:");
                System.out.println("You want remove by:");
                System.out.println("Enter 1 to remove by card ID:");
                System.out.println("Enter 2 to remove by name:");
                int choice = input.nextInt();
                switch(choice){
                    case 0 -> {
                        break;
                    }
                    case 1 -> {
                        input.nextLine();
                        System.out.println("Card Id where you want remove");
                        obj.remove(obj.searchCardID(input.nextLine(),arrTransport), arrTransport);
                        System.out.println("List after remove");
                        obj.show(arrTransport, arrError);
                    }
                    case 2 -> {
                        input.nextLine();
                        System.out.println("Name where you want remove");
                        obj.remove(obj.searchName(input.nextLine(),arrTransport), arrTransport);
                        System.out.println("List after remove");
                        obj.show(arrTransport, arrError);
                    }
                    default -> {
                        menuTransport();
                    }
                }
                menuTransport();
            }
            case 7 -> {
                System.out.println("Enter 1 to update by ID");
                System.out.println("Enter 2 to update by name");
                int choosen = input.nextInt();
                switch (choosen) {
                    case 0 -> {
                        break;
                    }
                    case 1 -> {
                        System.out.println("You want update:");
                        System.out.println("Enter 1 to update name:");
                        System.out.println("Enter 2 to update card ID:");
                        System.out.println("Enter 3 to update gender ");
                        System.out.println("Enter 4 to update address:");
                        System.out.println("Enter 5 to phone number:");
                        System.out.println("Enter 6 to update vehicle:");
                        System.out.println("Enter 7 to update manufacturer ");
                        System.out.println("Enter 8 to update plates:");
                        System.out.println("Enter 9 to update error ID:");
                        System.out.println("Enter 10 to phone date of violation:");
                        System.out.println("Enter 11 to update Status:");
                        System.out.println("Enter choose:");
                        int choice = input.nextInt();
                        switch(choice){
                            case 0 -> {
                                break;
                            }
                            case 1 -> {
                                input.nextLine();
                                System.out.println("Card Id where you want to update");
                                obj.updateName(obj.searchCardID(input.nextLine(), arrTransport), arrTransport);
                                System.out.println("List after update");
                                obj.show(arrTransport, arrError);
                            }
                            case 2 -> {
                                input.nextLine();
                                System.out.println("Card Id where you want to update");
                                obj.updateCardId(obj.searchCardID(input.nextLine(), arrTransport), arrTransport);
                                System.out.println("List after update");
                                obj.show(arrTransport, arrError);
                            }
                            case 3 -> {
                                input.nextLine();
                                System.out.println("Card Id where you want to update");
                                obj.updateGender(obj.searchCardID(input.nextLine(), arrTransport), arrTransport);
                                System.out.println("List after update");
                                obj.show(arrTransport, arrError);
                            }
                            case 4 -> {
                                input.nextLine();
                                System.out.println("Card Id where you want to update");
                                obj.updateAddress(obj.searchCardID(input.nextLine(), arrTransport), arrTransport);
                                System.out.println("List after update");
                                obj.show(arrTransport, arrError);
                            }
                            case 5 -> {
                                input.nextLine();
                                System.out.println("Card Id where you want to update");
                                obj.updatePhoneNumber(obj.searchCardID(input.nextLine(), arrTransport), arrTransport);
                                System.out.println("List after update");
                                obj.show(arrTransport, arrError);
                            }
                            case 6 -> {
                                input.nextLine();
                                System.out.println("Card Id where you want to update");
                                obj.updateLoaiXe(obj.searchCardID(input.nextLine(), arrTransport), arrTransport);
                                System.out.println("List after update");
                                obj.show(arrTransport, arrError);
                            }
                            case 7 -> {
                                input.nextLine();
                                System.out.println("Card Id where you want to update");
                                obj.updateHangXe(obj.searchCardID(input.nextLine(), arrTransport), arrTransport);
                                System.out.println("List after update");
                                obj.show(arrTransport, arrError);
                            }
                            case 8 -> {
                                input.nextLine();
                                System.out.println("Card Id where you want to update");
                                obj.updatePlates(obj.searchCardID(input.nextLine(), arrTransport), arrTransport);
                                System.out.println("List after update");
                                obj.show(arrTransport, arrError);
                            }
                            case 9 -> {
                                input.nextLine();
                                System.out.println("Card Id where you want to update");
                                obj.updateErrorID(obj.searchCardID(input.nextLine(), arrTransport), arrTransport);
                                System.out.println("List after update");
                                obj.show(arrTransport, arrError);
                            }
                            case 10 -> {
                                input.nextLine();
                                System.out.println("Card Id where you want to update");
                                obj.updateNgayViPham(obj.searchCardID(input.nextLine(), arrTransport), arrTransport);
                                System.out.println("List after update");
                                obj.show(arrTransport, arrError);
                            }
                            case 11 -> {
                                input.nextLine();
                                System.out.println("Card Id where you want to update");
                                obj.updateStatus(obj.searchCardID(input.nextLine(), arrTransport), arrTransport);
                                System.out.println("List after update");
                                obj.show(arrTransport, arrError);
                            }
                            default -> {
                                menuTransport();
                            }
                        }
                        menuTransport();
                    }
                    case 2 -> {
                        System.out.println("You want update:");
                        System.out.println("Enter 1 to update name:");
                        System.out.println("Enter 2 to update card ID:");
                        System.out.println("Enter 3 to update gender ");
                        System.out.println("Enter 4 to update address:");
                        System.out.println("Enter 5 to phone number:");
                        System.out.println("Enter 6 to update vehicle:");
                        System.out.println("Enter 7 to update manufacturer ");
                        System.out.println("Enter 8 to update plates:");
                        System.out.println("Enter 9 to update error ID:");
                        System.out.println("Enter 10 to phone date of violation:");
                        System.out.println("Enter 11 to update Status:");
                        System.out.println("Enter choose:");
                        int choice = input.nextInt();
                        switch(choice){
                            case 0 -> {
                                break;
                            }
                            case 1 -> {
                                input.nextLine();
                                System.out.println("Name where you want to update");
                                obj.updateName(obj.searchName(input.nextLine(), arrTransport), arrTransport);
                                System.out.println("List after update");
                                obj.show(arrTransport, arrError);
                            }
                            case 2 -> {
                                input.nextLine();
                                System.out.println("Name where you want to update");
                                obj.updateCardId(obj.searchName(input.nextLine(), arrTransport), arrTransport);
                                System.out.println("List after update");
                                obj.show(arrTransport, arrError);
                            }
                            case 3 -> {
                                input.nextLine();
                                System.out.println("Name where you want to update");
                                obj.updateGender(obj.searchName(input.nextLine(), arrTransport), arrTransport);
                                System.out.println("List after update");
                                obj.show(arrTransport, arrError);
                            }
                            case 4 -> {
                                input.nextLine();
                                System.out.println("Name where you want to update");
                                obj.updateAddress(obj.searchName(input.nextLine(), arrTransport), arrTransport);
                                System.out.println("List after update");
                                obj.show(arrTransport, arrError);
                            }
                            case 5 -> {
                                input.nextLine();
                                System.out.println("Name where you want to update");
                                obj.updatePhoneNumber(obj.searchName(input.nextLine(), arrTransport), arrTransport);
                                System.out.println("List after update");
                                obj.show(arrTransport, arrError);
                            }
                            case 6 -> {
                                input.nextLine();
                                System.out.println("Name where you want to update");
                                obj.updateLoaiXe(obj.searchName(input.nextLine(), arrTransport), arrTransport);
                                System.out.println("List after update");
                                obj.show(arrTransport, arrError);
                            }
                            case 7 -> {
                                input.nextLine();
                                System.out.println("Name where you want to update");
                                obj.updateHangXe(obj.searchName(input.nextLine(), arrTransport), arrTransport);
                                System.out.println("List after update");
                                obj.show(arrTransport, arrError);
                            }
                            case 8 -> {
                                input.nextLine();
                                System.out.println("Name where you want to update");
                                obj.updatePlates(obj.searchName(input.nextLine(), arrTransport), arrTransport);
                                System.out.println("List after update");
                                obj.show(arrTransport, arrError);
                            }
                            case 9 -> {
                                input.nextLine();
                                System.out.println("Name where you want to update");
                                obj.updateErrorID(obj.searchName(input.nextLine(), arrTransport), arrTransport);
                                System.out.println("List after update");
                                obj.show(arrTransport, arrError);
                            }
                            case 10 -> {
                                input.nextLine();
                                System.out.println("Name where you want to update");
                                obj.updateNgayViPham(obj.searchName(input.nextLine(), arrTransport), arrTransport);
                                System.out.println("List after update");
                                obj.show(arrTransport, arrError);
                            }
                            case 11 -> {
                                input.nextLine();
                                System.out.println("Name where you want to update");
                                obj.updateStatus(obj.searchName(input.nextLine(), arrTransport), arrTransport);
                                System.out.println("List after update");
                                obj.show(arrTransport, arrError);
                            }
                            default -> {
                                menuTransport();
                            }
                        }
                        menuTransport(); 
                    }
                    default -> {
                        menuTransport();
                    }
                            
                }
                break;
            }
            default -> {
                menuTransport();
            }
        }
        } catch (Exception e) {
            System.out.println("Error");
            input.nextLine();
            menuTransport();
        }
    }
    
    
    public static void menuError(){
        System.out.println("Enter 0 to back home page");
        System.out.println("Enter 1: Show Error");
        System.out.println("Enter 2: Add new Error to the list");
        System.out.println("Enter 3: Remove 1 Error in list");
        System.out.println("Enter 4: Sort Error in list");
        System.out.println("Enter 5: Update information Error");
        try {
            int choose = input.nextInt();
        switch(choose){
            case 0 -> {
                menu();
            }
            case 1 ->{
                System.out.println("Enter 1: Show all Error in list");
                System.out.println("Enter 2: Show 1 Error in list");
                System.out.println("Enter choose");
                byte choice = input.nextByte();
                switch(choice){
                    case 1 -> {
                        obj.showError(arrError);
                        menuError();
                    }
                    case 2 -> {
                        System.out.println("Enter 1: Show 1 Error by ID Error");
                        System.out.println("Enter 2: Show 1 Error by name Error");
                        System.out.println("Enter choose");
                        byte chosen = input.nextByte();
                        switch(chosen){
                            case 1 -> {
                                input.nextLine();
                                System.out.println("Enter ID where you want show");
                                obj.showErrorBy(Method.searchIdError(input.nextLine(), arrError), arrError);
                                menuError();
                            }
                            case 2 -> {
                                input.nextLine();
                                System.out.println("Enter ID where you want show");
                                obj.showErrorBy(Method.searchIdError(input.nextLine(), arrError), arrError);
                                menuError();
                            }
                            default -> {
                                menuError();
                            }
                        }
                    }
                    default -> {
                        menuError();
                    }
                }
            }
            case 2 -> {
                obj.inputError(arrError);
                System.out.println("List after input");
                obj.showError(arrError);
                menuError();
            }
            case 3 -> {
                System.out.println("Enter 1: Remove by ID Error");
                System.out.println("Enter 2: Remove by Name Error");
                int choice = input.nextInt();
                switch(choice){
                    case 0 -> {
                        break;
                    }
                    case 1 -> {
                        input.nextLine();
                        System.out.println("ID error where you want remove");
                        obj.removeError(Method.searchIdError(input.nextLine(), arrError), arrError);
                        System.out.println("List after remove");
                        obj.showError(arrError);
                    }
                    case 2 -> {
                        input.nextLine();
                        System.out.println("Name where you want remove");
                        obj.removeError(Method.searchIdError(input.nextLine(), arrError), arrError);
                        System.out.println("List after remove");
                        obj.showError(arrError);
                    } 
                    default -> {
                        menuError();
                    }
                }
                menuError();
            }
            case 4 ->{
                System.out.println("Enter 0 to back:");
                System.out.println("You want sort by:");
                System.out.println("Enter 1 to sort by card ID:");
                System.out.println("Enter 2 to sort by name:");
                int choice = input.nextInt();
                switch (choice) {
                    case 0 -> {
                        break;
                    }
                    case 1 -> {
                        obj.sortErrorByID(arrError);
                        System.out.println("List after sort");
                        obj.showError(arrError);
                    }
                    case 2 -> {
                        obj.sortErrorByName(arrError);
                        System.out.println("List after sort");
                        obj.showError(arrError);
                    }
                    default -> {
                        menuError();
                    }
                }
                menuError();
            }
            case 5 -> {
                System.out.println("Enter 1 to update by Error ID");
                System.out.println("Enter 2 to update by name Error");
                int choice = input.nextInt();
                switch(choice){
                    case 0 -> {
                        break;
                    }
                    case 1 -> {
                        System.out.println("You want update:");
                        System.out.println("Enter 1 to update Error ID:");
                        System.out.println("Enter 2 to update name Error:");
                        System.out.println("Enter 3 to update fine ");
                        int chosen = input.nextInt();
                        switch(chosen){
                            case 0 -> {
                                break;
                            }
                            case 1 -> {
                                input.nextLine();
                                System.out.println("ID error where you want update");
                                obj.updateErrorIDInArrError(Method.searchIdError(input.nextLine(), arrError), arrTransport, arrError);
                                System.out.println("List after insert");
                                obj.showError(arrError);
                            }
                            case 2 -> {
                                input.nextLine();
                                System.out.println("ID error where you want update");
                                obj.updateErrorName(Method.searchIdError(input.nextLine(), arrError), arrError);
                                System.out.println("List after insert");
                                obj.showError(arrError);
                            }
                            case 3 -> {
                                input.nextLine();
                                System.out.println("ID error where you want update");
                                obj.updateErrorFine(Method.searchIdError(input.nextLine(), arrError), arrError);
                                System.out.println("List after insert");
                                obj.showError(arrError);
                            }
                            default -> {
                                menuError();
                            }
                        }
                        menuError();
                    }
                    case 2 -> {
                        System.out.println("You want update:");
                        System.out.println("Enter 1 to update Error ID:");
                        System.out.println("Enter 2 to update name Error:");
                        System.out.println("Enter 3 to update fine ");
                        int chosen = input.nextInt();
                        switch(chosen){
                            case 0 -> {
                                break;
                            }
                            case 1 -> {
                                input.nextLine();
                                System.out.println("Name where you want update");
                                obj.updateErrorIDInArrError(Method.searchIdError(input.nextLine(), arrError), arrTransport , arrError);
                                System.out.println("List after update");
                                obj.showError(arrError);
                            }
                            case 2 -> {
                                input.nextLine();
                                System.out.println("Name where you want update");
                                obj.updateErrorName(Method.searchIdError(input.nextLine(), arrError), arrError);
                                System.out.println("List after update");
                                obj.showError(arrError);
                            }
                            case 3 -> {
                                input.nextLine();
                                System.out.println("Name where you want update");
                                obj.updateErrorFine(Method.searchIdError(input.nextLine(), arrError), arrError);
                                System.out.println("List after update");
                                obj.showError(arrError);
                            }
                            default -> {
                                menuError();
                            }
                        }
                        menuError();
                    }
                    default -> {
                        menuError();
                    }
                    
                }
                break;
            }
            default -> {
                menuError();
            }
        }
        } catch (Exception e) {
            System.out.println("Error");
            input.nextLine();
            menuError();
        }
        
    }

            
    
    public static void main(String[] args) {
        menu();
    }
}