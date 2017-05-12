package com.epam.lab.model;


public class User {
    private String name;
    private String surname;
    private String gender;
    private String email;
    private String password;
    private String telephoneNumber;
    private UserRole role;

    public User(String name, String surname, String gender, String email,
                String password, String telephoneNumber, UserRole role) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.telephoneNumber = telephoneNumber;
        this.role = role;
    }

    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if(object instanceof User){
            User user = (User) object;
            if(user.email.equals(email)){
                if(user.password.equals(password)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return String.format("First name - %s\n" +
                "Second Name - %s\n" +
                "Email - %s\n" +
                "Telephone number - %s\n" +
                "User Role - %s",name, surname, email, telephoneNumber, role);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
