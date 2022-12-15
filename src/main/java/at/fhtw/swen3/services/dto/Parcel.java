package at.fhtw.swen3.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Parcel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-24T14:25:41.651Z[GMT]")


public class Parcel   {
  @JsonProperty("weight")
  @DecimalMin(value="0.001", message="parcels must weight at least 1 gram")
  @ApiModelProperty(required = true, notes = "Weight of the parcel")
  private Float weight = null;

  @JsonProperty("recipient")
  @NotNull(message= "recipient cannot be null")
  private Recipient recipient = null;

  @JsonProperty("sender")
  @NotNull(message= "sender cannot be null")
  private Recipient sender = null;

  public Parcel weight(Float weight) {
    this.weight = weight;
    return this;
  }

  /**
   * Get weight
   * @return weight
   **/
  @Schema(required = true, description = "")

    public Float getWeight() {
    return weight;
  }

  public void setWeight(Float weight) {
    this.weight = weight;
  }

  public Parcel recipient(Recipient recipient) {
    this.recipient = recipient;
    return this;
  }

  /**
   * Get recipient
   * @return recipient
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Recipient getRecipient() {
    return recipient;
  }

  public void setRecipient(Recipient recipient) {
    this.recipient = recipient;
  }

  public Parcel sender(Recipient sender) {
    this.sender = sender;
    return this;
  }

  /**
   * Get sender
   * @return sender
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Recipient getSender() {
    return sender;
  }

  public void setSender(Recipient sender) {
    this.sender = sender;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Parcel parcel = (Parcel) o;
    return Objects.equals(this.weight, parcel.weight) &&
        Objects.equals(this.recipient, parcel.recipient) &&
        Objects.equals(this.sender, parcel.sender);
  }

  @Override
  public int hashCode() {
    return Objects.hash(weight, recipient, sender);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Parcel {\n");
    
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
    sb.append("    recipient: ").append(toIndentedString(recipient)).append("\n");
    sb.append("    sender: ").append(toIndentedString(sender)).append("\n");
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
