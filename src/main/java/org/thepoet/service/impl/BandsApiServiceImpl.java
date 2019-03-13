package org.thepoet.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.thepoet.model.Band;
import org.thepoet.service.spec.BandsApiService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oguzhan Dogan <dogan_oguzhan@hotmail.com>
 */
@Service
public class BandsApiServiceImpl implements BandsApiService {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public List<Band> getListFromApi() {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("bands-api");
        if (serviceInstances != null && !serviceInstances.isEmpty()) {
            ServiceInstance serviceInstance = serviceInstances.get(0);
            String serviceUrl = serviceInstance.getUri().toString();
            serviceUrl += "/list";
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(serviceUrl, List.class);
        }
        return new ArrayList<>();
    }
}
