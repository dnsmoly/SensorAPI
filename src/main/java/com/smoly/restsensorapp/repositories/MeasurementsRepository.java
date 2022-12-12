package com.smoly.restsensorapp.repositories;

import com.smoly.restsensorapp.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementsRepository extends JpaRepository<Measurement, Integer> {
    List<Measurement> findAllByRainingIsTrue();
}
