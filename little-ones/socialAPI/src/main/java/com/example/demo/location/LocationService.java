package com.example.demo.location;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LocationService {

	Location l1 = new Location(1,"Adana");
	Location l2 = new Location(2,"Adıyaman");
	Location l3 = new Location(6,"Ankara");
	List<Location> locations = Arrays.asList(l1,l2,l3);

	public List<Location> getLocations(){
		return locations;
	}
}
