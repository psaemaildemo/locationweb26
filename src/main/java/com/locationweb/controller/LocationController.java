package com.locationweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.locationweb.dto.LocationData;
import com.locationweb.entities.Locations;
import com.locationweb.services.LocationService;

@Controller
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	//handler methods
	
	@RequestMapping("/show")
	public String showLocationPage() {
		return "create_location";
	}
	
	//dto
	@RequestMapping("/saveLocation")
	public String saveLocationData(@ModelAttribute("loc") Locations location, ModelMap model) {
		locationService.saveLocation(location);
		model.addAttribute("msg","Location is saved!!");
		return "create_location";
	}
	
	
//	@RequestMapping("/saveLocation")
//	public String saveLocationData(@RequestParam("id") long id,@RequestParam("name") String name, @RequestParam("codes") String code, @RequestParam("type") String type) {
//		Locations location = new Locations();
//		location.setId(id);
//		location.setName(name);
//		location.setCodes(code);
//		location.setType(type);
//		locationService.saveLocation(location);
//		return "create_location";
//	}
	
	
//	@RequestMapping("/saveLocation")
//	public String saveLocationData(LocationData loc, ModelMap model) {
//		Locations location = new Locations();
//		location.setId(loc.getId());
//		location.setName(loc.getName());
//		location.setCodes(loc.getCodes());
//		location.setType(loc.getType());
//		model.addAttribute("msg","Location is saved!!");
//		locationService.saveLocation(location);
//		return "create_location";
//	}
	
	@RequestMapping("/listall")
	public String listAll(ModelMap model) {
		List<Locations> locations = locationService.getAllLocations();
		model.addAttribute("locations",locations);
		return "search_result";
	}
	
	@RequestMapping("/delete")
	public String deleteLocation(@RequestParam("id") long id, ModelMap model) {
		locationService.deleteLocationById(id);
		List<Locations> locations = locationService.getAllLocations();
		model.addAttribute("locations",locations);
		return "search_result";
	}
}
