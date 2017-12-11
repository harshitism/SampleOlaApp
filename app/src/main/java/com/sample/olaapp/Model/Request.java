package com.sample.olaapp.Model;

/**
 * Created by harshitgupta on 11/12/17.
 */

public class Request {
    String id;
    String drive_id;
    String customer_id;
    String state;
    String start_time;
    String end_time;
    Integer location_x;
    Integer location_y;

    public Request() {
    }

    public Request(String id, String drive_id, String customer_id, String state, String start_time, String end_time, Integer location_x, Integer location_y) {
        this.id = id;
        this.drive_id = drive_id;
        this.customer_id = customer_id;
        this.state = state;
        this.start_time = start_time;
        this.end_time = end_time;
        this.location_x = location_x;
        this.location_y = location_y;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDrive_id() {
        return drive_id;
    }

    public void setDrive_id(String drive_id) {
        this.drive_id = drive_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
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
