package at.fhtw3.swen3.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

/**
 * Hop
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-24T14:25:41.651Z[GMT]")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "hopType", visible = true )
@JsonSubTypes({
        @JsonSubTypes.Type(value = Warehouse.class, name = "warehouse"),
        @JsonSubTypes.Type(value = Truck.class, name = "truck"),
        @JsonSubTypes.Type(value = Transferwarehouse.class, name = "transferwarehouse"),
})


public class Hop   {
  @JsonTypeId
  @NotNull(message= "hopType may not be null")
  private String hopType = null;

  @JsonProperty("code")
  @Pattern(regexp="^[A-Z]{4}\\d{1,4}$", message = "code has to match \'^[A-Z]{4}\\d{1,4}$\'")
  @NotNull(message = "code may not be null")
  private String code = null;

  @JsonProperty("description")
  @NotNull(message= "description may not be null")
  @Pattern(regexp="^[A-Z0-9\\- ]*", message="description has to match \'^[A-Z0-9\\- ]*\'")
  private String description = null;

  @JsonProperty("processingDelayMins")
  @NotNull(message= "processingDelayMins may not be null")
  @Min(value = 1, message = "processingDelayMins cannot be less than 1")
  private Integer processingDelayMins = null;

  @JsonProperty("locationName")
  @Pattern(regexp="^[A-Z0-9\\- ]*", message="location has to match \'^[A-Z0-9\\- ]*\'")
  @NotNull(message= "locationName may not be null")
  private String locationName = null;

  @JsonProperty("locationCoordinates")
  @NotNull(message= "locationCoordinates may not be null")
  private GeoCoordinate locationCoordinates = null;

  public Hop hopType(String hopType) {
    this.hopType = hopType;
    return this;
  }

  public void setDummyData() {
    this.hopType="dummyHopType";
    this.code="ABCD1234";
    this.description="DUMMY";
    this.processingDelayMins=1;
    this.locationName="DUMMY";
    this.locationCoordinates= new GeoCoordinate().lat(12.9).lon(12.9);
  }

  /**
   * Get hopType
   * @return hopType
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getHopType() {
    return hopType;
  }

  public void setHopType(String hopType) {
    this.hopType = hopType;
  }

  public Hop code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Unique CODE of the hop.
   * @return code
   **/
  @Schema(required = true, description = "Unique CODE of the hop.")
      @NotNull

  @Pattern(regexp="^[A-Z]{4}\\d{1,4}$")   public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Hop description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the hop.
   * @return description
   **/
  @Schema(required = true, description = "Description of the hop.")
      @NotNull

    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Hop processingDelayMins(Integer processingDelayMins) {
    this.processingDelayMins = processingDelayMins;
    return this;
  }

  /**
   * Delay processing takes on the hop.
   * @return processingDelayMins
   **/
  @Schema(required = true, description = "Delay processing takes on the hop.")
      @NotNull

    public Integer getProcessingDelayMins() {
    return processingDelayMins;
  }

  public void setProcessingDelayMins(Integer processingDelayMins) {
    this.processingDelayMins = processingDelayMins;
  }

  public Hop locationName(String locationName) {
    this.locationName = locationName;
    return this;
  }

  /**
   * Name of the location (village, city, ..) of the hop.
   * @return locationName
   **/
  @Schema(required = true, description = "Name of the location (village, city, ..) of the hop.")
      @NotNull

    public String getLocationName() {
    return locationName;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
  }

  public Hop locationCoordinates(GeoCoordinate locationCoordinates) {
    this.locationCoordinates = locationCoordinates;
    return this;
  }

  /**
   * Get locationCoordinates
   * @return locationCoordinates
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public GeoCoordinate getLocationCoordinates() {
    return locationCoordinates;
  }

  public void setLocationCoordinates(GeoCoordinate locationCoordinates) {
    this.locationCoordinates = locationCoordinates;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Hop hop = (Hop) o;
    return Objects.equals(this.hopType, hop.hopType) &&
        Objects.equals(this.code, hop.code) &&
        Objects.equals(this.description, hop.description) &&
        Objects.equals(this.processingDelayMins, hop.processingDelayMins) &&
        Objects.equals(this.locationName, hop.locationName) &&
        Objects.equals(this.locationCoordinates, hop.locationCoordinates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hopType, code, description, processingDelayMins, locationName, locationCoordinates);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Hop {\n");
    
    sb.append("    hopType: ").append(toIndentedString(hopType)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    processingDelayMins: ").append(toIndentedString(processingDelayMins)).append("\n");
    sb.append("    locationName: ").append(toIndentedString(locationName)).append("\n");
    sb.append("    locationCoordinates: ").append(toIndentedString(locationCoordinates)).append("\n");
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
