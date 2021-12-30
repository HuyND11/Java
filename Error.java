package Project;

public class Error {

    private String errorID;
    private String errorName;
    private String fine;
    
    public Error(String errorID){
        setErrorID(errorID);
    }

    public Error(String errorID, String errorName, String fine) {
        setErrorID(errorID);
        setErrorName(errorName);
        setFine(fine);
    }

    public String getErrorID() {
        return errorID;
    }
    public void setErrorID(String errorID) {
        this.errorID = errorID;
    }
    public String getFine() {
        return fine;
    }
    public void setFine(String fine) {
        this.fine = fine;
    }
    public String getErrorName() {
        return errorName;
    }
    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }    
}