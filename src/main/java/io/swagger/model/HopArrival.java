package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * HopArrival
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-24T14:25:41.651Z[GMT]")


public class HopArrival   {
  @JsonProperty("code")
  private String code = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("dateTime")
  private OffsetDateTime dateTime = null;

  public HopArrival code(String code) {
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

  public HopArrival description(String description) {
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

  public HopArrival dateTime(OffsetDateTime dateTime) {
    this.dateTime = dateTime;
    return this;
  }

  /**
   * The date/time the parcel arrived at the hop.
   * @return dateTime
   **/
  @Schema(required = true, description = "The date/time the parcel arrived at the hop.")
      @NotNull

    @Valid
    public OffsetDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(OffsetDateTime dateTime) {
    this.dateTime = dateTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HopArrival hopArrival = (HopArrival) o;
    return Objects.equals(this.code, hopArrival.code) &&
        Objects.equals(this.description, hopArrival.description) &&
        Objects.equals(this.dateTime, hopArrival.dateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, description, dateTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HopArrival {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
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
