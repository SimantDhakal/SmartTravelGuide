package com.simant.tourandtravel.Bll;

public class SignUpResponse {

    // new
    private String _id;
    private boolean status;

    // new
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public SignUpResponse(String _id, boolean status) {
        this._id = _id;
        this.status = status;
    }

}
