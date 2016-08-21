package com.mateuszkoslacz.moviper.sample.data.bundle;

/**
 * Created by mateuszkoslacz on 12.08.2016.
 * <p>
 * To be used in the business logic layer to separate it from view and data layer specific objects.
 */
public class LocationPoint {

    private final double latitude;
    private final double longitude;
    private final boolean unknown;

    /**
     * A null object constructor.
     */
    public LocationPoint() {
        unknown = true;
        latitude = Double.MIN_VALUE;
        longitude = Double.MIN_VALUE;
    }

    public LocationPoint(double latitudeDegrees, double longitudeDegrees) {
        unknown = false;
        this.latitude = latitudeDegrees;
        this.longitude = longitudeDegrees;
    }

    public boolean isUnknown() {
        return unknown;
    }

    /**
     * It will throw a RuntimeException if location is unknown. Always check
     * LocationPoint#isUnknown() before invoking this method.
     *
     * @return
     */
    public double getLatitude() {
        if (isUnknown()) throw new RuntimeException("cannot get latitude, location is unknown! " +
                "Make sure that you have checked LocationPoint#isUnknown() " +
                "before trying to get latitude");
        return latitude;
    }

    /**
     * It will throw a RuntimeException if location is unknown. Always check
     * LocationPoint#isUnknown() before invoking this method.
     *
     * @return
     */
    public double getLongitude() {
        if (isUnknown()) throw new RuntimeException("cannot get longitude, location is unknown! " +
                "Make sure that you have checked LocationPoint#isUnknown() " +
                "before trying to get longitude");
        return longitude;
    }
}
