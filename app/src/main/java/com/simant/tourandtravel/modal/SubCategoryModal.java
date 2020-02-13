package com.simant.tourandtravel.modal;

public class SubCategoryModal {

    private String _id;
    private String _catId;
    private String _userId;
    private String _subCatName;
    private String _locationName;
    private String _longitude;
    private String _lattitude;
    private String _description;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_catId() {
        return _catId;
    }

    public void set_catId(String _catId) {
        this._catId = _catId;
    }

    public String get_userId() {
        return _userId;
    }

    public void set_userId(String _userId) {
        this._userId = _userId;
    }

    public String get_subCatName() {
        return _subCatName;
    }

    public void set_subCatName(String _subCatName) {
        this._subCatName = _subCatName;
    }

    public String get_locationName() {
        return _locationName;
    }

    public void set_locationName(String _locationName) {
        this._locationName = _locationName;
    }

    public String get_longitude() {
        return _longitude;
    }

    public void set_longitude(String _longitude) {
        this._longitude = _longitude;
    }

    public String get_lattitude() {
        return _lattitude;
    }

    public void set_lattitude(String _lattitude) {
        this._lattitude = _lattitude;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }


    public SubCategoryModal(String _id, String _catId, String _userId, String _subCatName, String _locationName, String _longitude, String _lattitude, String _description) {
        this._id = _id;
        this._catId = _catId;
        this._userId = _userId;
        this._subCatName = _subCatName;
        this._locationName = _locationName;
        this._longitude = _longitude;
        this._lattitude = _lattitude;
        this._description = _description;
    }

}
