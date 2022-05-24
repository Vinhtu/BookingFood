package com.example.bookingfood;

public class Product {

    int _id;
    String _name;
    String _price;
    String _description;
    int _idcategory;
    int _picture;

    public Product(){}
    public Product(int _id, String _name, String _price, String _description, int _idcategory, int _picture) {
        this._id = _id;
        this._name = _name;
        this._price = _price;
        this._description = _description;
        this._idcategory = _idcategory;
        this._picture = _picture;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_price() {
        return _price;
    }

    public void set_price(String _price) {
        this._price = _price;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public int get_idcategory() {
        return _idcategory;
    }

    public void set_idcategory(int _idcategory) {
        this._idcategory = _idcategory;
    }

    public int get_picture() {
        return _picture;
    }

    public void set_picture(int _picture) {
        this._picture = _picture;
    }
}
