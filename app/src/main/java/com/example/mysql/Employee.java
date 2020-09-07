package com.example.mysql;

public class Employee {

    private int id;
    private String epf;
    private String location;
    private String longitude;
    private String latitude;
    private String timeIn;

    public Employee(int id, String epf, String location, String longitude, String latitude, String timeIn) {
        this.id = id;
        this.epf = epf;
        this.location = location;
        this.longitude = longitude;
        this.latitude = latitude;
        this.timeIn = timeIn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }
}
