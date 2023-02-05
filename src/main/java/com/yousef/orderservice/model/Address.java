package com.yousef.orderservice.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
public class Address {
    @Size(max = 30)
    private String address;
    @Length(max = 30)
    private String zipCode;
    @Length(max = 30)
    private String city;
    @Length(max = 30)
    private String state;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public static Address generateSampleAddress(){
        Address address = new Address();
        address.setCity("New Cairo");
        address.setState("Cairo");
        address.setZipCode("11911");
        address.setAddress("40/1 , mp st., 10th");
        return address;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address1 = (Address) o;

        if (getAddress() != null ? !getAddress().equals(address1.getAddress()) : address1.getAddress() != null)
            return false;
        if (getZipCode() != null ? !getZipCode().equals(address1.getZipCode()) : address1.getZipCode() != null)
            return false;
        if (getCity() != null ? !getCity().equals(address1.getCity()) : address1.getCity() != null) return false;
        return getState() != null ? getState().equals(address1.getState()) : address1.getState() == null;
    }

    @Override
    public int hashCode() {
        int result = getAddress() != null ? getAddress().hashCode() : 0;
        result = 31 * result + (getZipCode() != null ? getZipCode().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getState() != null ? getState().hashCode() : 0);
        return result;
    }
}
