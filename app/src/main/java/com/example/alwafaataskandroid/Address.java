package com.example.alwafaataskandroid;

public class Address {

    String city,area,streetname,buildingname,nearbylandmark,phone;

    public Address(String city, String area, String streetname, String buildingname, String nearbylandmark, String phone) {
        this.city = city;
        this.area = area;
        this.streetname = streetname;
        this.buildingname = buildingname;
        this.nearbylandmark = nearbylandmark;
        this.phone = phone;
    }

    public Address(Address address) {

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getBuildingname() {
        return buildingname;
    }

    public void setBuildingname(String buildingname) {
        this.buildingname = buildingname;
    }

    public String getNearbylandmark() {
        return nearbylandmark;
    }

    public void setNearbylandmark(String nearbylandmark) {
        this.nearbylandmark = nearbylandmark;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
