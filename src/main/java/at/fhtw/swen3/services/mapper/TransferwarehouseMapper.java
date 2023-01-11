package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
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
public interface TransferwarehouseMapper extends CoordinateToPointMapper{
    TransferwarehouseMapper INSTANCE= Mappers.getMapper(TransferwarehouseMapper.class);

    @SneakyThrows
    @Named("toGeometry")
    public static com.vividsolutions.jts.geom.Geometry fromStringToGeometry(String geoJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(geoJson);
        JsonNode geometry = jsonNode.get("geometry");
        Geometry geoJSON = (Geometry) GeoJSONFactory.create(geometry.toString());
        return new GeoJSONReader().read(geoJSON);
    }

    @Named("fromGeometry")
    public static String fromGeometryToString(com.vividsolutions.jts.geom.Geometry geometry) {
        return new GeoJSONWriter().write(geometry).toString();
    }

    @Mapping(source = "locationCoordinates", target = "locationCoordinates", qualifiedByName = "geoCoordinateToPoint")
    @Mapping(source = "regionGeoJson", target = "regionGeoJson", qualifiedByName = "toGeometry")
    TransferwarehouseEntity fromDTO(Transferwarehouse transferwarehouse);
    @Mapping(source = "locationCoordinates", target = "locationCoordinates", qualifiedByName = "pointToGeoCoordinate")
    @Mapping(source = "regionGeoJson", target = "regionGeoJson", qualifiedByName = "fromGeometry")
    Transferwarehouse fromEntity(TransferwarehouseEntity entity);
}
