package io.swagger.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Transferwarehouse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-24T14:25:41.651Z[GMT]")


public class Transferwarehouse extends Hop  {
  @JsonProperty("regionGeoJson")
  @NotNull(message = "regiongGeoJson may not be null")
  private String regionGeoJson = null;

  @JsonProperty("logisticsPartner")
  @NotNull(message = "logisticsPartner may not be null")
  private String logisticsPartner = null;

  @JsonProperty("logisticsPartnerUrl")
  @NotNull(message = "logisticsPartnerUrl may not be null")
  private String logisticsPartnerUrl = null;

  public Transferwarehouse regionGeoJson(String regionGeoJson) {
    this.regionGeoJson = regionGeoJson;
    return this;
  }

  /**
   * GeoJSON (https://geojson.org/) of the area covered by the logistics partner.
   * @return regionGeoJson
   **/
  @Schema(required = true, description = "GeoJSON (https://geojson.org/) of the area covered by the logistics partner.")
      @NotNull

    public String getRegionGeoJson() {
    return regionGeoJson;
  }

  public void setRegionGeoJson(String regionGeoJson) {
    this.regionGeoJson = regionGeoJson;
  }

  public Transferwarehouse logisticsPartner(String logisticsPartner) {
    this.logisticsPartner = logisticsPartner;
    return this;
  }

  /**
   * Name of the logistics partner.
   * @return logisticsPartner
   **/
  @Schema(required = true, description = "Name of the logistics partner.")
      @NotNull

    public String getLogisticsPartner() {
    return logisticsPartner;
  }

  public void setLogisticsPartner(String logisticsPartner) {
    this.logisticsPartner = logisticsPartner;
  }

  public Transferwarehouse logisticsPartnerUrl(String logisticsPartnerUrl) {
    this.logisticsPartnerUrl = logisticsPartnerUrl;
    return this;
  }

  /**
   * BaseURL of the logistics partner's REST service.
   * @return logisticsPartnerUrl
   **/
  @Schema(required = true, description = "BaseURL of the logistics partner's REST service.")
      @NotNull

    public String getLogisticsPartnerUrl() {
    return logisticsPartnerUrl;
  }

  public void setLogisticsPartnerUrl(String logisticsPartnerUrl) {
    this.logisticsPartnerUrl = logisticsPartnerUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transferwarehouse transferwarehouse = (Transferwarehouse) o;
    return Objects.equals(this.regionGeoJson, transferwarehouse.regionGeoJson) &&
        Objects.equals(this.logisticsPartner, transferwarehouse.logisticsPartner) &&
        Objects.equals(this.logisticsPartnerUrl, transferwarehouse.logisticsPartnerUrl) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(regionGeoJson, logisticsPartner, logisticsPartnerUrl, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transferwarehouse {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    regionGeoJson: ").append(toIndentedString(regionGeoJson)).append("\n");
    sb.append("    logisticsPartner: ").append(toIndentedString(logisticsPartner)).append("\n");
    sb.append("    logisticsPartnerUrl: ").append(toIndentedString(logisticsPartnerUrl)).append("\n");
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
