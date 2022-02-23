package com.example.alwafaataskandroid;

import com.google.gson.annotations.SerializedName;

public class AddrResponse {

    @SerializedName("building_name")
   private String building_name;

    @SerializedName("city_name")
   private String city_name;

    @SerializedName("area")
   private String area;

    @SerializedName("street_name")
   private String street_name;

    @SerializedName("nearest_landmark")
   private String nearest_landmark;

    @SerializedName("mobile_number")
   private String mobile_number;

    @SerializedName("user_id")
   private Integer user_id;

    public AddrResponse(String building_name, String city_name, String area, String street_name, String nearest_landmark, String mobile_number, Integer user_id) {
        this.building_name = building_name;
        this.city_name = city_name;
        this.area = area;
        this.street_name = street_name;
        this.nearest_landmark = nearest_landmark;
        this.mobile_number = mobile_number;
        this.user_id = user_id;
    }

    public String getBuilding_name() {
        return building_name;
    }

    public void setBuilding_name(String building_name) {
        this.building_name = building_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getNearest_landmark() {
        return nearest_landmark;
    }

    public void setNearest_landmark(String nearest_landmark) {
        this.nearest_landmark = nearest_landmark;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
