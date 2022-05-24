package com.example.bookingfood;

public class Address {
    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public int get_picture() {
        return _picture;
    }

    public void set_picture(int _picture) {
        this._picture = _picture;
    }

    public Address(int _id, String _description, int _picture) {
        this._id = _id;
        this._description = _description;
        this._picture = _picture;
    }

    int _id;
    String _description;
    int _picture;
}
