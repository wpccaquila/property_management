package com.property_management.pojo;


/**
 * 业主信息实体类
 */
public class OwnerInfo {
    private int owner_id;
    private String owner_name;
    private String owner_phone;
    private String owner_password;
    private String owner_identity;

    @Override
    public String toString() {
        return "OwnerInfo{" +
                "owner_id=" + owner_id +
                ", owner_name='" + owner_name + '\'' +
                ", owner_phone='" + owner_phone + '\'' +
                ", owner_password='" + owner_password + '\'' +
                ", owner_identity='" + owner_identity + '\'' +
                '}';
    }

    public OwnerInfo(String owner_name, String owner_phone, String owner_password, String owner_identity) {
        this.owner_name = owner_name;
        this.owner_phone = owner_phone;
        this.owner_password = owner_password;
        this.owner_identity = owner_identity;
    }

    public OwnerInfo(int owner_id, String owner_name, String owner_phone, String owner_password, String owner_identity) {
        this.owner_id = owner_id;
        this.owner_name = owner_name;
        this.owner_phone = owner_phone;
        this.owner_password = owner_password;
        this.owner_identity = owner_identity;
    }

    public OwnerInfo() {
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getOwner_phone() {
        return owner_phone;
    }

    public void setOwner_phone(String owner_phone) {
        this.owner_phone = owner_phone;
    }



    public String getOwner_password() {
        return owner_password;
    }

    public void setOwner_password(String owner_password) {
        this.owner_password = owner_password;
    }



    public String getOwner_identity() {
        return owner_identity;
    }

    public void setOwner_identity(String owner_identity) {
        this.owner_identity = owner_identity;
    }
}
