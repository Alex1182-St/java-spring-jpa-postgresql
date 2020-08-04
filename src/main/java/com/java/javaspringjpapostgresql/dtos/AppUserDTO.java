package com.java.javaspringjpapostgresql.dtos;

import com.java.javaspringjpapostgresql.entities.RoleEntity;

import java.util.Set;
import java.util.UUID;

public class AppUserDTO {

    private UUID id;

    private String appUserLogin;

    private String appUserPassword;

    private String email;

    private Set<RoleEntity> roles;

    private String appUserSurname;

    private String appUserName;

    private String phone;

    private Boolean isEnabled;

    public AppUserDTO(UUID id, String appUserLogin, String appUserPassword, String email, Set<RoleEntity> roles, String appUserSurname, String appUserName, String phone, Boolean isEnabled) {
        this.id = id;
        this.appUserLogin = appUserLogin;
        this.appUserPassword = appUserPassword;
        this.email = email;
        this.roles = roles;
        this.appUserSurname = appUserSurname;
        this.appUserName = appUserName;
        this.phone = phone;
        this.isEnabled = isEnabled;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public AppUserDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
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
}
