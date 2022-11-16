package io.swagger.services.mapper;

import io.swagger.services.dto.GeoCoordinate;
import org.mapstruct.Named;
import org.springframework.data.geo.Point;

public interface CoordinateToPointMapper {
    @Named("geoCoordinateToPoint")
    public static Point geoCoordinateToPoint(GeoCoordinate coordinate){
        return new Point(coordinate.getLon(), coordinate.getLat());
    }
    @Named("pointToGeoCoordinate")
    public static GeoCoordinate pointToGeoCoordinate(Point point){
        return new GeoCoordinate().lon(point.getX()).lat(point.getY());
    }
}
