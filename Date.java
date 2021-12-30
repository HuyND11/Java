package Project;

import java.util.*;
import java.time.LocalDate;

public class Date{

    static Scanner input = new Scanner(System.in);

    private int day;
    private int month;
    private int year;

    Date(int day, int month, int year){
        if(chekcDate(day, month, year)){
            setDay(day);
            setMonth(month);
            setYear(year);
        }
    }


    public int getDay() {
        return day;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setDay(int day) {
        this.day = day;
    }
    
    public static  boolean checkYear(int year){
        if(year % 4 == 0){
            if( year % 100 == 0){
                if( year % 400 == 0){
                    return true;
                }else{
                    return false;
                }
            }else{
                return true;
            }
        }else{
            return false;
        }
    }

    public static boolean chekcDate(int day, int month, int year){
        if((day <= 0 && (month <= 0 || month > 12) && year < 0)){
            return false;
        }
        if(checkMonth(month, year) < day){
            return false;
        }
        return true;
    }

    public static int checkMonth(int month, int year){
        try{
            switch(month){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8: 
                case 10:
                case 12:
                return 31;
                case 4:
                case 6:
                case 9:
                case 11:
                return 30;
                case 2:
                if(checkYear(year)){
                    return 29;
                }else{
                    return 28;
                }
                default:{
                    return 0;
                }
            }
        }
        catch(Exception e){
            System.out.println("Error");
            return 0;
        }
    }




    public LocalDate daytime() {
        LocalDate date;

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
    }
}

