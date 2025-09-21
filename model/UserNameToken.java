package com.devnologix.exploria_backend.model;


public class UserNameToken {
   
    private String name;

    private String email;

    private String phone;

    private String businessTitle;

    private String token;
    
   
    public UserNameToken(String name, String email, String phone, String businessTitle, String token) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.businessTitle = businessTitle;
        this.token = token;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getBusinessTitle() {
        return businessTitle;
    }
    public void setBusinessTitle(String businessTitle) {
        this.businessTitle = businessTitle;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    
    public UserNameToken() {
    }
}
