package at.fhtw3.swen3.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

/**
 * Recipient
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-24T14:25:41.651Z[GMT]")


public class Recipient   {
  @JsonProperty("name")
  @NotNull(message = "name may not be null")
  private String name = null;

  @JsonProperty("street")
  @Pattern(regexp = "^[A-Za-zß0-9 \\/-]*", message = "pattern must match ^[A-Za-zß0-9 \\/-]*")
  private String street = null;

  @JsonProperty("postalCode")
  @NotNull(message = "postalcode may not be null")
  private String postalCode = null;

  @JsonProperty("city")
  @NotNull(message = "city may not be null")
  private String city = null;

  @JsonProperty("country")
  @NotNull(message = "country may not be null")
  @Pattern(regexp = "[A-Za-z]*", message = "Country must match pattern [A-Za-z]*")
  private String country = null;

  public Recipient name(String name) {
    this.name = name;
    return this;
  }

  public void setDummyData(){
    this.name="name";
    this.city="testcity";
    this.country="testcountry";
    this.postalCode="ABCD";
    this.street="dummyStreet";

  }

  /**
   * Name of person or company.
   * @return name
   **/
  @Schema(required = true, description = "Name of person or company.")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Recipient street(String street) {
    this.street = street;
    return this;
  }

  /**
   * Street
   * @return street
   **/
  @Schema(required = true, description = "Street")
      @NotNull

    public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public Recipient postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  /**
   * Postalcode
   * @return postalCode
   **/
  @Schema(required = true, description = "Postalcode")
      @NotNull

    public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public Recipient city(String city) {
    this.city = city;
    return this;
  }

  /**
   * City
   * @return city
   **/
  @Schema(required = true, description = "City")
      @NotNull

    public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Recipient country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Country
   * @return country
   **/
  @Schema(required = true, description = "Country")
      @NotNull

    public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recipient recipient = (Recipient) o;
    return Objects.equals(this.name, recipient.name) &&
        Objects.equals(this.street, recipient.street) &&
        Objects.equals(this.postalCode, recipient.postalCode) &&
        Objects.equals(this.city, recipient.city) &&
        Objects.equals(this.country, recipient.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, street, postalCode, city, country);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Recipient {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
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
