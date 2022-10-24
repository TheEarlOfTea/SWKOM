package io.swagger.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * GeoCoordinate
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-24T14:25:41.651Z[GMT]")


public class GeoCoordinate   {
  @JsonProperty("lat")
  @NotNull(message = "lat may not be null")
  @DecimalMin(value="-180.0000000", message="latitude cannot be less than -180")
  @DecimalMax(value="180.0000000", message="latitude cannot be higher than 180")
  private Double lat = null;

  @JsonProperty("lon")
  @NotNull(message = "lat may not be null")
  @DecimalMin(value="-180.0000000", message="longitude cannot be less than -180")
  @DecimalMax(value="180.0000000", message="longitude cannot be higher than 180")
  private Double lon = null;

  public GeoCoordinate lat(Double lat) {
    this.lat = lat;
    return this;
  }

  /**
   * Latitude of the coordinate.
   * @return lat
   **/
  @Schema(required = true, description = "Latitude of the coordinate.")
      @NotNull

    public Double getLat() {
    return lat;
  }

  public void setLat(Double lat) {
    this.lat = lat;
  }

  public GeoCoordinate lon(Double lon) {
    this.lon = lon;
    return this;
  }

  /**
   * Longitude of the coordinate.
   * @return lon
   **/
  @Schema(required = true, description = "Longitude of the coordinate.")
      @NotNull

    public Double getLon() {
    return lon;
  }

  public void setLon(Double lon) {
    this.lon = lon;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeoCoordinate geoCoordinate = (GeoCoordinate) o;
    return Objects.equals(this.lat, geoCoordinate.lat) &&
        Objects.equals(this.lon, geoCoordinate.lon);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lat, lon);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeoCoordinate {\n");
    
    sb.append("    lat: ").append(toIndentedString(lat)).append("\n");
    sb.append("    lon: ").append(toIndentedString(lon)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
