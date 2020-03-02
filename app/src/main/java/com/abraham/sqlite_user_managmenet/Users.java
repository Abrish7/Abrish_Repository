package com.abraham.sqlite_user_managmenet;

public class Users {
    private int id;
    private String fname;
    private String lname;
    private String uname;
    private String email;
    private String phone;
    private String pass;
    private String gender;
     public Users(){}



        public Users(int id, String fname, String lname, String uname, String email, String phone, String pass, String gender) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.uname = uname;
        this.email = email;
        this.phone = phone;
        this.pass = pass;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
