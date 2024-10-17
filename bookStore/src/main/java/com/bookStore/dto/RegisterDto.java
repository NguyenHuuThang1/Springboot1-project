package com.bookStore.dto;

import jakarta.validation.constraints.*;

public class RegisterDto {
    @NotEmpty
    private String first_name;
    @NotEmpty
    private String last_name;
    @NotEmpty
    @Email
    private String email;
    private String phone;
    private String address;
    @Size(min = 6, message = "minimum password length is 6 characters")
    private String password;

    private String confirmPassword;

    public @NotEmpty String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(@NotEmpty String first_name) {
        this.first_name = first_name;
    }

    public @NotEmpty String getLast_name() {
        return last_name;
    }

    public void setLast_name(@NotEmpty String last_name) {
        this.last_name = last_name;
    }

    public @NotEmpty @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty @Email String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public @Size(min = 6, message = "minimum password length is 6 characters") String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 6, message = "minimum password length is 6 characters") String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
