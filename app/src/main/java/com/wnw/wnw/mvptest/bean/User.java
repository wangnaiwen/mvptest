package com.wnw.wnw.mvptest.bean;

import java.io.Serializable;

/**
 * Created by yue on 17/7/25.
 */

public class User implements Serializable {
    private String area;
    private String province_id;
    private String province_name;
    private String district_id;
    private String district_name;
    private String city_id;
    private String city_name;
    private String address;
    private String sfzphoto_z;
    private String sfzphoto_f;
    private String role_flag;
    private String realname_status; //实名认证状态：0 未认证，1 已认证
    private String sfz;
    private String sex;
    private ImgModel icon;
    private String name;
    private String id;
    private String username;
    private String status;//0为待审核 ，1为正常，2为禁用, 3未绑定代理商, 4 (绑定申请)待代理商同意

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSfzphoto_z() {
        return sfzphoto_z;
    }

    public void setSfzphoto_z(String sfzphoto_z) {
        this.sfzphoto_z = sfzphoto_z;
    }

    public String getSfzphoto_f() {
        return sfzphoto_f;
    }

    public void setSfzphoto_f(String sfzphoto_f) {
        this.sfzphoto_f = sfzphoto_f;
    }

    public String getRole_flag() {
        return role_flag;
    }

    public void setRole_flag(String role_flag) {
        this.role_flag = role_flag;
    }

    public String getRealname_status() {
        return realname_status;
    }

    public void setRealname_status(String realname_status) {
        this.realname_status = realname_status;
    }

    public String getSfz() {
        return sfz;
    }

    public void setSfz(String sfz) {
        this.sfz = sfz;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public ImgModel getIcon() {
        return icon;
    }

    public void setIcon(ImgModel icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProvince_id() {
        return province_id;
    }

    public void setProvince_id(String province_id) {
        this.province_id = province_id;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public String getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(String district_id) {
        this.district_id = district_id;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }
}
