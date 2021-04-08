package org.academiadecodigo.cachealots.sports.services;

import org.academiadecodigo.cachealots.sports.model.Places;

import java.util.List;

public interface CityService {

    List<Places> getPlaces(String cityName);
}
