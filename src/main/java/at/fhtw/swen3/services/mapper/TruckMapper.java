package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.services.dto.Truck;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.wololo.geojson.GeoJSONFactory;
import org.wololo.geojson.Geometry;
import org.wololo.jts2geojson.GeoJSONReader;
import org.wololo.jts2geojson.GeoJSONWriter;

@Mapper
public interface TruckMapper extends CoordinateToPointMapper{

    TruckMapper INSTANCE= Mappers.getMapper(TruckMapper.class);

    @SneakyThrows
    @Named("toGeometry")
    static com.vividsolutions.jts.geom.Geometry fromStringToGeometry(String geoJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(geoJson);
        JsonNode geometry = jsonNode.get("geometry");
        Geometry geoJSON = (Geometry) GeoJSONFactory.create(geometry.toString());
        return new GeoJSONReader().read(geoJSON);
    }

    @Named("fromGeometry")
    static String fromGeometryToString(com.vividsolutions.jts.geom.Geometry geometry) {
        return new GeoJSONWriter().write(geometry).toString();
    }

    @Mapping(source = "locationCoordinates", target = "locationCoordinates", qualifiedByName = "geoCoordinateToPoint")
    @Mapping(source = "regionGeoJson", target = "regionGeoJson", qualifiedByName = "toGeometry")
    TruckEntity fromDTO(Truck hop);
    @Mapping(source = "locationCoordinates", target = "locationCoordinates", qualifiedByName = "pointToGeoCoordinate")
    @Mapping(source = "regionGeoJson", target = "regionGeoJson", qualifiedByName = "fromGeometry")
    Truck fromEntity(TruckEntity entity);
}
