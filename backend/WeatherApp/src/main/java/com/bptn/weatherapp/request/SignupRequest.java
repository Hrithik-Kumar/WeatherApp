package com.bptn.weatherapp.request;

public class SignupRequest {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String emailId;
    private boolean isAdmin;
    private String address;
    private String cityName;
    private String country;
    private long phone;
    private String securityQuestion1;
    private String securityQuestion2;
    private String securityQuestion3;
    private String securityAnswer1;
    private String securityAnswer2;
    private String securityAnswer3;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getSecurityQuestion1() {
        return securityQuestion1;
    }

    public void setSecurityQuestion1(String securityQuestion1) {
        this.securityQuestion1 = securityQuestion1;
    }

    public String getSecurityQuestion2() {
        return securityQuestion2;
    }

    public void setSecurityQuestion2(String securityQuestion2) {
        this.securityQuestion2 = securityQuestion2;
    }

    public String getSecurityQuestion3() {
        return securityQuestion3;
    }

    public void setSecurityQuestion3(String securityQuestion3) {
        this.securityQuestion3 = securityQuestion3;
    }

    public String getSecurityAnswer1() {
        return securityAnswer1;
    }

    public void setSecurityAnswer1(String securityAnswer1) {
        this.securityAnswer1 = securityAnswer1;
    }

    public String getSecurityAnswer2() {
        return securityAnswer2;
    }

    public void setSecurityAnswer2(String securityAnswer2) {
        this.securityAnswer2 = securityAnswer2;
    }

    public String getSecurityAnswer3() {
        return securityAnswer3;
    }

    public void setSecurityAnswer3(String securityAnswer3) {
        this.securityAnswer3 = securityAnswer3;
    }

    public String body(){

        String request = "{ username: "  + this.getUsername()
                + "\n password: " + this.getPassword()
                + "\n firstName: " + this.getFirstName()
                +  "\n lastName: " + this.getLastName()
                + "\n emailId: " + this.getEmailId()
                + "\n isAdmin: " + this.isAdmin()
                + "\n address: " + this.getAddress()
                + "\n cityName: " + this.getCityName()
                + "\n country: " + this.getCountry()
                + "\n phone: " + this.getPhone()
                + "\n securityQuestion1: " + this.securityQuestion1
                + "\n securityQuestion2: " + this.securityQuestion2
                + "\n securityQuestion3: " + this.securityQuestion3
                + "\n securityAnswer1: " + this.securityAnswer1
                + "\n securityAnswer2: " + this.securityAnswer2
                + "\n securityAnswer3: " + this.securityAnswer3
                + "}";

        return request;

    }


}

