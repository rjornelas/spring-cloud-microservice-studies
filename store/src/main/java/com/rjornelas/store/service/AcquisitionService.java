package com.rjornelas.store.service;

import com.rjornelas.store.client.ProviderClient;
import com.rjornelas.store.dto.AcquisitionDto;
import com.rjornelas.store.dto.InfoProviderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcquisitionService {

    @Autowired
    private ProviderClient providerClient;

    public void purchase(AcquisitionDto acquisitionDto){

        InfoProviderDto info = providerClient
                .getInfoByState(acquisitionDto
                        .getAdressDto()
                        .getState());

        System.out.println(info.getAdress());
    }
}
