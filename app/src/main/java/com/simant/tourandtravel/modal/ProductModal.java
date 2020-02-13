package com.simant.tourandtravel.modal;

public class ProductModal {

    private String _id;
    private String _subCatId;
    private String _productName;
    private String _productPrice;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_subCatId() {
        return _subCatId;
    }

    public void set_subCatId(String _subCatId) {
        this._subCatId = _subCatId;
    }

    public String get_productName() {
        return _productName;
    }

    public void set_productName(String _productName) {
        this._productName = _productName;
    }

    public String get_productPrice() {
        return _productPrice;
    }

    public void set_productPrice(String _productPrice) {
        this._productPrice = _productPrice;
    }

    public ProductModal(String _id, String _subCatId, String _productName, String _productPrice) {
        this._id = _id;
        this._subCatId = _subCatId;
        this._productName = _productName;
        this._productPrice = _productPrice;
    }

}
