package at.fhtw.swen3.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Warehouse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-24T14:25:41.651Z[GMT]")


public class Warehouse extends Hop  {
  @JsonProperty("level")
  @NotNull(message = "level may not be null")
  @Min(value = 0, message = "level must be 0 or higher")
  private Integer level = null;

  @JsonProperty("nextHops")
  @Valid
  @NotNull(message = "may not be null")
  private List<WarehouseNextHops> nextHops = new ArrayList<WarehouseNextHops>();

  public Warehouse level(Integer level) {
    this.level = level;
    return this;
  }

  /**
   * Get level
   * @return level
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public void setDummyData(){
    super.setDummyData();
    this.level=1;
    this.setNextHops(new ArrayList<WarehouseNextHops>());
  }

  public Warehouse nextHops(List<WarehouseNextHops> nextHops) {
    this.nextHops = nextHops;
    return this;
  }

  public Warehouse addNextHopsItem(WarehouseNextHops nextHopsItem) {
    this.nextHops.add(nextHopsItem);
    return this;
  }

  /**
   * Next hops after this warehouse (warehouses or trucks).
   * @return nextHops
   **/
  @Schema(required = true, description = "Next hops after this warehouse (warehouses or trucks).")
      @NotNull
    @Valid
    public List<WarehouseNextHops> getNextHops() {
    return nextHops;
  }

  public void setNextHops(List<WarehouseNextHops> nextHops) {
    this.nextHops = nextHops;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Warehouse warehouse = (Warehouse) o;
    return Objects.equals(this.level, warehouse.level) &&
        Objects.equals(this.nextHops, warehouse.nextHops) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(level, nextHops, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Warehouse {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
    sb.append("    nextHops: ").append(toIndentedString(nextHops)).append("\n");
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
