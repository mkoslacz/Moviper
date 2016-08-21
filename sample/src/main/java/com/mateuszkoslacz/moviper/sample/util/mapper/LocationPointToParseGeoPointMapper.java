package com.mateuszkoslacz.moviper.sample.util.mapper;

import com.mateuszkoslacz.moviper.sample.data.bundle.LocationPoint;
import com.mateuszkoslacz.moviper.sample.util.mapper.iface.Mapper;
import com.parse.ParseGeoPoint;

/**
 * Created by mateuszkoslacz on 15.08.2016.
 */
public class LocationPointToParseGeoPointMapper implements Mapper<LocationPoint, ParseGeoPoint> {
    @Override
    public ParseGeoPoint map(LocationPoint locationPoint) {
        return new ParseGeoPoint(locationPoint.getLatitude(), locationPoint.getLongitude());
    }
}
