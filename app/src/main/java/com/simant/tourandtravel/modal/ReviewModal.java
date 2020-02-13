package com.simant.tourandtravel.modal;

public class ReviewModal {
    private String _rating;
    private String _fullName;
    private String _comment;

    public ReviewModal(String _rating, String _fullName, String _comment) {
        this._rating = _rating;
        this._fullName = _fullName;
        this._comment = _comment;
    }

    public String get_rating() {
        return _rating;
    }

    public void set_rating(String _rating) {
        this._rating = _rating;
    }

    public String get_fullName() {
        return _fullName;
    }

    public void set_fullName(String _fullName) {
        this._fullName = _fullName;
    }

    public String get_comment() {
        return _comment;
    }

    public void set_comment(String _comment) {
        this._comment = _comment;
    }
}
