package io.swagger.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodeEntity {
    @Pattern(regexp="^[A-Z]{4}\\d{1,4}$", message = "has to match \'^[A-Z]{4}\\d{1,4}$\'")
    @NotNull(message = "trackingId may not be null")
    private String code;

    @Override
    public String toString() {
        return "CodeEntity{" +
                "code='" + code + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
