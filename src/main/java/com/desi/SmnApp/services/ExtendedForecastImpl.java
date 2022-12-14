package com.desi.SmnApp.services;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desi.SmnApp.entities.ExtendedForecast;
import com.desi.SmnApp.repositories.IExtendedForecastRepository;

@Service
public class ExtendedForecastImpl implements IExtendedForecast {

    private IExtendedForecastRepository extendedForecastRepository;

    @Autowired
    public ExtendedForecastImpl(IExtendedForecastRepository extendedForecastRepository) {
        this.extendedForecastRepository = extendedForecastRepository;
    }

    @Override
    public void createExtendedForecast(ExtendedForecast extendedForecast) {
        extendedForecastRepository.save(extendedForecast);
    }

    @Override
    public List<ExtendedForecast> getExtendedForecastByCityId(Long cityId) {
        return extendedForecastRepository.findByCityId(cityId);
    }

    @Override
    public ExtendedForecast getById(Long extendedForecastId) {
        return extendedForecastRepository.findById(extendedForecastId).get();
    }

    @Override
    public Boolean doesExtendedForescastExists(Long cityId, Date date) {
        return Objects.nonNull(extendedForecastRepository.findByCityIdAndDate(cityId, date));
    }

}
