package Project;
import java.util.*;

public class Person {
    protected String name;
    protected String gender;
    protected String phoneNumber;
    protected String address;
    protected String cardID;

    static Scanner input = new Scanner(System.in);

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getCardID() {
        return cardID;
    }
    public void setCardID(String cardID) {
        this.cardID = cardID;
    }
    
    Person(String name, String gender, String address, String phoneNumber, String cardID){
        setName(name);
        setGender(gender);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setCardID(cardID);
    }
}