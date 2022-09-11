package za.ac.cput.capstone_Employee_Management.domain;

import za.ac.cput.capstone_Employee_Management.domain.employee.EmployeeContactType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/*
ContactType.java
AUTHOR Farai Malone Chawora
Student Number 220145547
Date April 9 2022
 */
@Entity
@Table(name = "Contact_Type")
public class ContactType implements Serializable {
    @Id
    @NotNull@Column(name = "contact_ID")
    private String contactId;
    @Column(name = "email_Address")
    private String email;
    @Column(name="contact_Numeber")
    private String phoneNumber;

    @OneToMany(mappedBy = "contactType")
    private Set<EmployeeContactType> employeeAdrss=new HashSet<>();

    protected ContactType(){}

    private ContactType(Builder build){
        this.contactId= build.contactId;
        this.email= build.email;
        this.phoneNumber= build.phoneNumber;


    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "ContactType{" +
                "contactId='" + contactId + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static class Builder{
        private String contactId;
        private String email;
        private String phoneNumber;

        public Builder setContactId(String contactId) {
            this.contactId = contactId;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Builder copy(ContactType cntType){
            this.contactId=cntType.contactId;
            this.email=cntType.email;
            this.phoneNumber= cntType.phoneNumber;
            return this;

        }
        public ContactType build(){
            return new ContactType(this);
        }
    }
}
