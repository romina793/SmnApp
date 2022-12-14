package com.desi.SmnApp.controllers.extendedForecast;

import java.sql.Date;

import javax.validation.constraints.*;

import com.desi.SmnApp.entities.ExtendedForecast;

public class ExtendedForecastForm {
    private Long id;
    @NotNull(message = "Debes seleccionar una ciudad")
    private Long idCity;
    @NotNull(message = "La fecha no puede ser nula")
    private Date date;
    @NotNull(message = "Debes completar el campo probabilidad de lluvias")
    @Min(0)
    private int rainProbability;
    @NotNull(message = "Debes completa el campo lluvias previstas")
    @Min(0)
    private int predictedRain;
    @NotEmpty(message = "La descripción es obligatoria")
    @Size(min = 1, max = 500)
    private String description;

    public ExtendedForecastForm() {
    }

    public ExtendedForecastForm(ExtendedForecast e) {
        this.id = e.getId();
        this.date = e.getDate();
        this.rainProbability = e.getRainProbability();
        this.predictedRain = e.getPredictedRain();
        this.description = e.getDescription();
        this.idCity = e.getCity().getId();
    }

    public ExtendedForecast toPojo() {
        ExtendedForecast e = new ExtendedForecast();
        e.setId(this.id);
        e.setDate(this.getDate());
        e.setPredictedRain(this.getPredictedRain());
        e.setRainProbability(this.getRainProbability());
        e.setDescription(this.getDescription());
        return e;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRainProbability() {
        return rainProbability;
    }

    public void setRainProbability(int rainProbability) {
        this.rainProbability = rainProbability;
    }

    public int getPredictedRain() {
        return predictedRain;
    }

    public void setPredictedRain(int predictedRain) {
        this.predictedRain = predictedRain;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIdCity() {
        return idCity;
    }

    public void setIdCity(Long idCity) {
        this.idCity = idCity;
    }
}
