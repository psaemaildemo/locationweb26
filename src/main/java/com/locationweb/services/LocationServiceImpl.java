package com.locationweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locationweb.entities.Locations;
import com.locationweb.repositories.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationRepository locationRepo;

	@Override
	public void saveLocation(Locations location) {
		locationRepo.save(location);
	}

	@Override
	public List<Locations> getAllLocations() {
		List<Locations> locations = locationRepo.findAll();
		return locations;
	}

	@Override
	public void deleteLocationById(long id) {
		locationRepo.deleteById(id);
	}

}
