package com.java.javaspringjpapostgresql.entities;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "appUsers")
public class AppUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false, unique = true)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String appUserLogin;

    @Column(nullable = false)
    private String appUserPassword;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "appUser_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private Set<RoleEntity> roles;

    @Column(nullable = false)
    private Boolean isEnabled;

    @Column(nullable = false)
    private Boolean isAccountNonLocked;

    @Column(nullable = false)
    private Boolean isAccountNonExpired;

    @Column(nullable = false)
    private Boolean isCredentialsNonExpired;

    @Column(nullable = false, unique = true)
    private String email;

    private String appUserSurname;

    private String appUserName;

    @Column(unique = true)
    private String phone;

    @Column(unique = true)
    private String skype;

    private int userAge;

    public AppUserEntity() {
    }

    public AppUserEntity(UUID id, String appUserLogin, String appUserPassword, Set<RoleEntity> roles, Boolean isEnabled, Boolean isAccountNonLocked, Boolean isAccountNonExpired, Boolean isCredentialsNonExpired, String email, String appUserSurname, String appUserName, String phone, String skype, int userAge) {
        this.id = id;
        this.appUserLogin = appUserLogin;
        this.appUserPassword = appUserPassword;
        this.roles = roles;
        this.isEnabled = isEnabled;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.email = email;
        this.appUserSurname = appUserSurname;
        this.appUserName = appUserName;
        this.phone = phone;
        this.skype = skype;
        this.userAge = userAge;
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

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public Boolean getAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public Boolean getAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    public Boolean getCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
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
