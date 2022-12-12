package com.smoly.restsensorapp.util;

import com.smoly.restsensorapp.models.Measurement;
import com.smoly.restsensorapp.models.Sensor;
import com.smoly.restsensorapp.services.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class MeasurementValidator implements Validator {

    private final SensorsService sensorsService;

    @Autowired
    public MeasurementValidator(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Measurement.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Measurement measurement = (Measurement) target;
        if (measurement.getSensor() != null) {
            Optional<Sensor> sensor = sensorsService.findByName(measurement.getSensor().getName());
            if (sensor.isEmpty()) {
                errors.rejectValue("sensor", "", "Sensor with this name doesn't exist");
            }
        }
    }
}
