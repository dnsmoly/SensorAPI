package com.smoly.restsensorapp.util;

public class MeasurementNotCreatedError extends RuntimeException{
    public MeasurementNotCreatedError (String msg) {
        super(msg);
    }
}
