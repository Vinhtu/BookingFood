package com.example.bookingfood;

public class User {
    int _id;
    String _username;
    String _password;
    String _email;
    String _name;
    String _phone_number;
    String _address;

    public User() {}

    public User(int _id, String _username, String _password, String _email, String _name, String _phone_number, String _address) {
        this._id = _id;
        this._username = _username;
        this._password = _password;
        this._email = _email;
        this._name = _name;
        this._phone_number = _phone_number;
        this._address = _address;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_username() {
        return _username;
    }

    public void set_username(String _username) {
        this._username = _username;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_phone_number() {
        return _phone_number;
    }

    public void set_phone_number(String _phone_number) {
        this._phone_number = _phone_number;
    }


    public String get_address() {
        return _address;
    }

    public void set_address(String _address) {
        this._address = _address;
    }

}
