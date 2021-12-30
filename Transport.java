package Project;

public class Transport {
    private String vehicle;
    private String manufacturer;
    private String plates; 
    private Error errorID;
    private Date dateOfViolation;
    private Violator violator;
    private Boolean status;

    public Transport(String vehicle, String manufacturer,String plates, Error errorID, Date dateOfViolation, Violator violator, Boolean status) {
        setVehicle(vehicle);
        setManufacturer(manufacturer);
        setPlates(plates);
        setErrorID(errorID);
        setDateOfViolation(dateOfViolation);
        setViolator(violator);
        setStatus(status);
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getVehicle() {
        return vehicle;
    }
    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }
    public Error getErrorID() {
        return errorID;
    }
    public void setErrorID(Error errorID) {
        this.errorID = errorID;
    }
    
    public String getPlates() {
        return plates;
    }
    public void setPlates(String plates) {
        this.plates = plates;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public Date getDateOfViolation() {
        return dateOfViolation;
    }
    public void setDateOfViolation(Date dateOfViolation) {
        this.dateOfViolation = dateOfViolation;
    }
    public Violator getViolator() {
        return violator;
    }
    public void setViolator(Violator violator) {
        this.violator = violator;
    }
    
}