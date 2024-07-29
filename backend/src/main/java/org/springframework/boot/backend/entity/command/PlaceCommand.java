package org.springframework.boot.backend.entity.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.backend.entity.input.AccuracyOfCoordinates;

@Data
public class PlaceCommand {
    @NotBlank(message = "Place name is mandatory!")
    private String name;
    @NotBlank(message = "Country of place is mandatory!")
    private String country;
    @NotNull(message = "Region code is mandatory!")
    private String regionCode;
    @NotNull(message = "Latitude is mandatory!")
    private Double latitude;
    @NotNull(message = "Longitude is mandatory!")
    private Double longitude;
    @NotNull(message = "Accuracy of coordinates must not be null!")
    private AccuracyOfCoordinates precision;
    private String notes;
}
