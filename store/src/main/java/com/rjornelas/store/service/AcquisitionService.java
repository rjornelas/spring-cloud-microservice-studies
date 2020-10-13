package com.rjornelas.store.service;

import com.rjornelas.store.dto.AcquisitionDto;
import com.rjornelas.store.dto.InfoProviderDto;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AcquisitionService {

    public void purchase(AcquisitionDto acquisitionDto){
        RestTemplate client = new RestTemplate();
        ResponseEntity<InfoProviderDto> exchange =
                client.exchange("http://localhost:8081/info/"+acquisitionDto.getAdressDto(),
                HttpMethod.GET, null, InfoProviderDto.class);

        System.out.println(exchange.getBody().getAdress());
    }
}
