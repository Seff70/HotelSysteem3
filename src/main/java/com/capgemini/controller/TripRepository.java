package com.capgemini.controller;

import com.capgemini.Model.Boten.Trip;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TripRepository extends CrudRepository<Trip, Integer> {
    List<Trip> findAll();
}