package model;

import utils.DistanceCalculator;

public class Location implements Comparable<Location> {
    private double latitude;
    private double longitude;
    private Location comparableLocation;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void addComparableLocation(Location location) {
        this.comparableLocation = location;
    }

    @Override
    public int compareTo(Location location) {
        if (this.comparableLocation != null) {
            return DistanceCalculator.distance(this, this.comparableLocation) > DistanceCalculator.distance(location, this.comparableLocation) ? 1 : -1;
        } else {
            if (this.latitude != location.latitude) {
                return this.latitude > location.latitude ? 1 : -1;
            }
            if (this.longitude != location.longitude) {
                return this.longitude > location.longitude ? 1 : -1;
            }
            return 0;
        }
    }

    @Override
    public String toString() {
        String val = "Location{";

        if (this.comparableLocation != null) {
            val += "distance=" + DistanceCalculator.distance(this, this.comparableLocation) + " miles, ";
        }

        val += "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';

        return val;
    }
}
