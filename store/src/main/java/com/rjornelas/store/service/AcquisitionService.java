package com.rjornelas.store.service;

import com.rjornelas.store.dto.AcquisitionDto;
import com.rjornelas.store.dto.InfoProviderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class AcquisitionService {

    @Autowired
    private RestTemplate client;

    public void purchase(AcquisitionDto acquisitionDto){

        ResponseEntity<InfoProviderDto> exchange =
                client.exchange(
                        "http://provider/info/"+acquisitionDto.getAdressDto().getState(),
                        HttpMethod.GET,
                        null,
                        InfoProviderDto.class);

        System.out.println(exchange.getBody().getAdress());
    }
}
