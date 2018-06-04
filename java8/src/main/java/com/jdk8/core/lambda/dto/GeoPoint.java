package com.jdk8.core.lambda.dto;

import java.io.Serializable;

/**
 * Created by jiangkai
 * Date 2018/6/1
 */
public class GeoPoint implements Serializable {
    private double lat;
    private double lng;

    public GeoPoint() {

    }

    public GeoPoint(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return String.format("{\"lat\":%s,\"lng\":%s}", lat, lng);
    }
}
