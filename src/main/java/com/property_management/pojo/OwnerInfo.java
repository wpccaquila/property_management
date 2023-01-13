package com.property_management.pojo;


/**
 * 业主信息实体类
 */
public class OwnerInfo {
    private int owner_id;
    private String owner_name;
    private int owner_phone;
    private String owner_address;
    private String owner_password;
    private int house_id;
    private String owner_identity;

    @Override
    public String toString() {
        return "Owner_info{" +
                "owner_id=" + owner_id +
                ", owner_name='" + owner_name + '\'' +
                ", owner_phone=" + owner_phone +
                ", owner_address='" + owner_address + '\'' +
                ", owner_password='" + owner_password + '\'' +
                ", house_id=" + house_id +
                ", owner_identity='" + owner_identity + '\'' +
                '}';
    }

    public OwnerInfo() {
    }

    public OwnerInfo(int owner_id, String owner_name, int owner_phone, String owner_address, String owner_password, int house_id, String owner_identity) {
        this.owner_id = owner_id;
        this.owner_name = owner_name;
        this.owner_phone = owner_phone;
        this.owner_address = owner_address;
        this.owner_password = owner_password;
        this.house_id = house_id;
        this.owner_identity = owner_identity;
    }

    /**
     * 无id构造函数
     */
    public OwnerInfo(String owner_name, int owner_phone, String owner_address, String owner_password, int house_id, String owner_identity) {
        this.owner_name = owner_name;
        this.owner_phone = owner_phone;
        this.owner_address = owner_address;
        this.owner_password = owner_password;
        this.house_id = house_id;
        this.owner_identity = owner_identity;
    }

    /**
     * 无id和房间id构造函数
     */
    public OwnerInfo(String owner_name, int owner_phone, String owner_address, String owner_password, String owner_identity) {
        this.owner_name = owner_name;
        this.owner_phone = owner_phone;
        this.owner_address = owner_address;
        this.owner_password = owner_password;
        this.owner_identity = owner_identity;
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

    public int getOwner_phone() {
        return owner_phone;
    }

    public void setOwner_phone(int owner_phone) {
        this.owner_phone = owner_phone;
    }

    public String getOwner_address() {
        return owner_address;
    }

    public void setOwner_address(String owner_address) {
        this.owner_address = owner_address;
    }

    public String getOwner_password() {
        return owner_password;
    }

    public void setOwner_password(String owner_password) {
        this.owner_password = owner_password;
    }

    public int getHouse_id() {
        return house_id;
    }

    public void setHouse_id(int house_id) {
        this.house_id = house_id;
    }

    public String getOwner_identity() {
        return owner_identity;
    }

    public void setOwner_identity(String owner_identity) {
        this.owner_identity = owner_identity;
    }
}
