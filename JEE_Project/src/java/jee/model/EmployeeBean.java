package jee.model;

import javax.persistence.Entity;
import javax.persistence.*;
import static javax.persistence.GenerationType.AUTO;

//@Entity
//@Table(name="EMPLOYEE")
public class EmployeeBean {
    
    //@Id @GeneratedValue(strategy=AUTO) 
    private int ID;
    
    //@Column(name="NAME", nullable=false, length=100) 
    private String name;
    
    //@Column(name="FIRSTNAME", nullable=false, length=100) 
    private String firstName;
    
    //@Column(name="HOME_PHONE", nullable=false, length=100) 
    private String homePhone;
    
    //@Column(name="MOBILE_PHONE", nullable=false, length=100) 
    private String mobilePhone;
    
    //@Column(name="WORK_PHONE", nullable=false, length=100) 
    private String workPhone;
    
    //@Column(name="ADDRESS", nullable=false, length=100) 
    private String address;
    
    //@Column(name="POSTAL_CODE", nullable=false, length=100) 
    private String postalCode;
    
    //@Column(name="CITY", nullable=false, length=100) 
    private String city;
    
    //@Column(name="EMAIL", nullable=false, length=100) 
    private String email;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
}
