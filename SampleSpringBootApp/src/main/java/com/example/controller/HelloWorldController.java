package com.example.controller;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ServerLocation;
import com.example.repository.WRRepositoryImpl;
import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;
import com.maxmind.geoip.regionName;

@RestController
@RequestMapping("/site")
public class HelloWorldController {

	@Autowired
	@Qualifier("wrRepositoryImpl")
	private WRRepositoryImpl wrRepositoryImpl;

	@Autowired
	private Logger logger;

//	@RequestMapping(name = "/helloWorld", method = RequestMethod.GET)
//	public String helloWorld() {
//
//		logger.debug("debug");
//		logger.info("info         EEEEEEEEEE");
//
//		try {
//			wrRepositoryImpl.insertEmployee();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "Hello World";
//
//	}
	
	
	@RequestMapping(name = "/geoipDetail/{q}", method = RequestMethod.GET)
	public ServerLocation geoipDetail(@PathVariable Integer q) {
		return getLocation("ip1");
	}
	
	

	private ServerLocation getLocation(String ipAddress) {

		File file = new File("/etc/nginx/geoip/GeoIP.dat");
		return getLocation(ipAddress, file);

	}

	private ServerLocation getLocation(String ipAddress, File file) {

		ServerLocation serverLocation = null;

		try {

			serverLocation = new ServerLocation();

			LookupService lookup = new LookupService(file, LookupService.GEOIP_MEMORY_CACHE);
			Location locationServices = lookup.getLocation(ipAddress);

			serverLocation.setCountryCode(locationServices.countryCode);
			serverLocation.setCountryName(locationServices.countryName);
			serverLocation.setRegion(locationServices.region);
			serverLocation
					.setRegionName(regionName.regionNameByCode(locationServices.countryCode, locationServices.region));
			serverLocation.setCity(locationServices.city);
			serverLocation.setPostalCode(locationServices.postalCode);
			serverLocation.setLatitude(String.valueOf(locationServices.latitude));
			serverLocation.setLongitude(String.valueOf(locationServices.longitude));

		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		return serverLocation;

	}

}
