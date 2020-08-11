package com.java.javaspringjpapostgresql.dtos;


public class AppUserCreateInput {


    private String appUserLogin;

    private String appUserPassword;

    private String email;

    private String appUserSurname;

    private String appUserName;

    private String phone;

    private String skype;

    private int userAge;

    public AppUserCreateInput(String appUserLogin, String appUserPassword, String email, String appUserSurname, String appUserName, String phone, String skype, int userAge) {
        this.appUserLogin = appUserLogin;
        this.appUserPassword = appUserPassword;
        this.email = email;
        this.appUserSurname = appUserSurname;
        this.appUserName = appUserName;
        this.phone = phone;
        this.skype = skype;
        this.userAge = userAge;
    }

    public AppUserCreateInput() {
    }

    public String getAppUserLogin() {
        return appUserLogin;
    }

    public void setAppUserLogin(String appUserLogin) {
        this.appUserLogin = appUserLogin;
    }

    public String getAppUserPassword() {
        return appUserPassword;
    }

    public void setAppUserPassword(String appUserPassword) {
        this.appUserPassword = appUserPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAppUserSurname() {
        return appUserSurname;
    }

    public void setAppUserSurname(String appUserSurname) {
        this.appUserSurname = appUserSurname;
    }

    public String getAppUserName() {
        return appUserName;
    }

    public void setAppUserName(String appUserName) {
        this.appUserName = appUserName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }
}
