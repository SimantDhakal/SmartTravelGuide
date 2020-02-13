package com.simant.tourandtravel.modal;

public class CategoryModal {

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_catName() {
        return _catName;
    }

    public void set_catName(String _catName) {
        this._catName = _catName;
    }

    public String get_catImage() {
        return _catImage;
    }

    public void set_catImage(String _catImage) {
        this._catImage = _catImage;
    }

    public CategoryModal(String _id, String _catName, String _catImage) {
        this._id = _id;
        this._catName = _catName;
        this._catImage = _catImage;
    }

    private String _id;
    private String _catName;
    private String _catImage;



}
