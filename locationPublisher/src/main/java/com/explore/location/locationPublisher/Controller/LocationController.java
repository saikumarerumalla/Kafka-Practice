package com.explore.location.locationPublisher.Controller;

import com.explore.location.locationPublisher.Model.DriverLocation;
import com.explore.location.locationPublisher.Service.LocationPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

    @Autowired
    private LocationPublisherService locationPublisherService;

    @PostMapping("/updateLocation")
    public String updateLocation(@RequestBody DriverLocation location) {
        locationPublisherService.publishLocation(location);
        return "Location update published successfully.";
    }
}
