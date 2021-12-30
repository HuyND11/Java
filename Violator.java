package Project;

public class Violator extends Person{
    private Error errorID;

    public Error getErrorID() {
        return errorID;
    }
    public void setErrorID(Error errorID) {
        this.errorID = errorID;
    }
    
    
    public Violator(String name, String gender, String address, String phoneNumber,String cardID ,Error errorID) {
        super(name, gender, address, phoneNumber,cardID);
        setErrorID(errorID);
    }

}