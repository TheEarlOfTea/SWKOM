package at.fhtw.swen3.services.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TrackingInformation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-24T14:25:41.651Z[GMT]")


public class TrackingInformation   {
  /**
   * State of the parcel.
   */
  public enum StateEnum {
    PICKUP("Pickup"),
    
    INTRANSPORT("InTransport"),
    
    INTRUCKDELIVERY("InTruckDelivery"),
    
    TRANSFERRED("Transferred"),
    
    DELIVERED("Delivered");

    private String value;

    StateEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StateEnum fromValue(String text) {
      for (StateEnum b : StateEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("state")
  @NotNull(message="state may not be null")
  private StateEnum state = null;

  @JsonProperty("visitedHops")
  @Valid
  @NotNull(message="visitedHops may not be null")
  private List<HopArrival> visitedHops = new ArrayList<HopArrival>();

  @JsonProperty("futureHops")
  @Valid
  @NotNull(message="futureHops may not be null")
  private List<HopArrival> futureHops = new ArrayList<HopArrival>();

  public TrackingInformation state(StateEnum state) {
    this.state = state;
    return this;
  }

  /**
   * State of the parcel.
   * @return state
   **/
  @Schema(required = true, description = "State of the parcel.")
      @NotNull

    public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }

  public TrackingInformation visitedHops(List<HopArrival> visitedHops) {
    this.visitedHops = visitedHops;
    return this;
  }

  public TrackingInformation addVisitedHopsItem(HopArrival visitedHopsItem) {
    this.visitedHops.add(visitedHopsItem);
    return this;
  }

  /**
   * Hops visited in the past.
   * @return visitedHops
   **/
  @Schema(required = true, description = "Hops visited in the past.")
      @NotNull
    @Valid
    public List<HopArrival> getVisitedHops() {
    return visitedHops;
  }

  public void setVisitedHops(List<HopArrival> visitedHops) {
    this.visitedHops = visitedHops;
  }

  public TrackingInformation futureHops(List<HopArrival> futureHops) {
    this.futureHops = futureHops;
    return this;
  }

  public TrackingInformation addFutureHopsItem(HopArrival futureHopsItem) {
    this.futureHops.add(futureHopsItem);
    return this;
  }

  /**
   * Hops coming up in the future - their times are estimations.
   * @return futureHops
   **/
  @Schema(required = true, description = "Hops coming up in the future - their times are estimations.")
      @NotNull
    @Valid
    public List<HopArrival> getFutureHops() {
    return futureHops;
  }

  public void setFutureHops(List<HopArrival> futureHops) {
    this.futureHops = futureHops;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrackingInformation trackingInformation = (TrackingInformation) o;
    return Objects.equals(this.state, trackingInformation.state) &&
        Objects.equals(this.visitedHops, trackingInformation.visitedHops) &&
        Objects.equals(this.futureHops, trackingInformation.futureHops);
  }

  @Override
  public int hashCode() {
    return Objects.hash(state, visitedHops, futureHops);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrackingInformation {\n");
    
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    visitedHops: ").append(toIndentedString(visitedHops)).append("\n");
    sb.append("    futureHops: ").append(toIndentedString(futureHops)).append("\n");
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
