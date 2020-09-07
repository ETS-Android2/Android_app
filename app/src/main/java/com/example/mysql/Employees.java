package com.example.mysql;

public class Employees {

    private String epf,location,longitude,latitude,time;

    public Employees() {
    }

    public Employees(String epf, String location, String longitude, String latitude, String time) {
        this.epf = epf;
        this.location = location;
        this.longitude = longitude;
        this.latitude = latitude;
        this.time = time;
    }

    public String getEpf() {
        return epf;
    }

    public void setEpf(String epf) {
        this.epf = epf;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
