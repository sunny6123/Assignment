package com.interview.unicorn.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class UnicornDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer unicornId;
    private String name;
    private String hairColor;
    private double hornLength;
    private String heightLengthUnit;
    private String hornColor;
    private String eyeColor;
    private double height;
    private String heightUnit;
    private double weight;
    private String weightUnit;
    @JsonProperty("identifiableMarks")
    @OneToMany(cascade = CascadeType.ALL)
    private List<UnicornIdentifiableMarks> identifiableMarks;

    public Integer getUnicornId() {
        return unicornId;
    }

    public void setUnicornId(Integer unicornId) {
        this.unicornId = unicornId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public double getHornLength() {
        return hornLength;
    }

    public void setHornLength(double hornLength) {
        this.hornLength = hornLength;
    }

    public String getHornColor() {
        return hornColor;
    }

    public void setHornColor(String hornColor) {
        this.hornColor = hornColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getHeightUnit() {
        return heightUnit;
    }

    public void setHeightUnit(String heightUnit) {
        this.heightUnit = heightUnit;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public List<UnicornIdentifiableMarks> getIdentifiableMarks() {
        return identifiableMarks;
    }

    public void setIdentifiableMarks(List<UnicornIdentifiableMarks> identifiableMarks) {
        this.identifiableMarks = identifiableMarks;
    }
}
