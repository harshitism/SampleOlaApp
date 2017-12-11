package com.sample.olaapp.Model;

/**
 * Created by harshitgupta on 11/12/17.
 */

public class Drivers {
    String id;
    String name;
    Integer location_x;
    Integer location_y;

    public Drivers() {
    }

    public Drivers(String id, String name, Integer location_x, Integer location_y) {
        this.id = id;
        this.name = name;
        this.location_x = location_x;
        this.location_y = location_y;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLocation_x() {
        return location_x;
    }

    public void setLocation_x(Integer location_x) {
        this.location_x = location_x;
    }

    public Integer getLocation_y() {
        return location_y;
    }

    public void setLocation_y(Integer location_y) {
        this.location_y = location_y;
    }
}

