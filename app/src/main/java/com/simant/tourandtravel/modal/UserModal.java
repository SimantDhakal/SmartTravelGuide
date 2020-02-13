package com.simant.tourandtravel.modal;

public class UserModal {

    private String _fullName;
    private String _userEmail;
    private String _userPassword;
    private String _userPhone;


    public UserModal(String _fullName, String _userEmail, String _userPassword, String _userPhone) {
        this._fullName = _fullName;
        this._userEmail = _userEmail;
        this._userPassword = _userPassword;
        this._userPhone = _userPhone;
    }

    public String get_fullName() {
        return _fullName;
    }

    public void set_fullName(String _fullName) {
        this._fullName = _fullName;
    }

    public String get_userEmail() {
        return _userEmail;
    }

    public void set_userEmail(String _userEmail) {
        this._userEmail = _userEmail;
    }

    public String get_userPassword() {
        return _userPassword;
    }

    public void set_userPassword(String _userPassword) {
        this._userPassword = _userPassword;
    }

    public String get_userPhone() {
        return _userPhone;
    }

    public void set_userPhone(String _userPhone) {
        this._userPhone = _userPhone;
    }

}
