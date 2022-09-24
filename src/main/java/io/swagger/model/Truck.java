package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.GeoCoordinate;
import io.swagger.model.Hop;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Truck
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-24T14:25:41.651Z[GMT]")


public class Truck extends Hop  {
  @JsonProperty("regionGeoJson")
  private String regionGeoJson = null;

  @JsonProperty("numberPlate")
  private String numberPlate = null;

  public Truck regionGeoJson(String regionGeoJson) {
    this.regionGeoJson = regionGeoJson;
    return this;
  }

  /**
   * GeoJSON (https://geojson.org/) of the area covered by the truck.
   * @return regionGeoJson
   **/
  @Schema(required = true, description = "GeoJSON (https://geojson.org/) of the area covered by the truck.")
      @NotNull

    public String getRegionGeoJson() {
    return regionGeoJson;
  }

  public void setRegionGeoJson(String regionGeoJson) {
    this.regionGeoJson = regionGeoJson;
  }

  public Truck numberPlate(String numberPlate) {
    this.numberPlate = numberPlate;
    return this;
  }

  /**
   * The truck's number plate.
   * @return numberPlate
   **/
  @Schema(required = true, description = "The truck's number plate.")
      @NotNull

    public String getNumberPlate() {
    return numberPlate;
  }

  public void setNumberPlate(String numberPlate) {
    this.numberPlate = numberPlate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Truck truck = (Truck) o;
    return Objects.equals(this.regionGeoJson, truck.regionGeoJson) &&
        Objects.equals(this.numberPlate, truck.numberPlate) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(regionGeoJson, numberPlate, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Truck {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    regionGeoJson: ").append(toIndentedString(regionGeoJson)).append("\n");
    sb.append("    numberPlate: ").append(toIndentedString(numberPlate)).append("\n");
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
