package com.rjornelas.provider.service;

import com.rjornelas.provider.entity.InfoProvider;
import com.rjornelas.provider.repository.InfoProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoProviderService {

    @Autowired
    private InfoProviderRepository infoProviderRepository;

    public InfoProvider getInfoProvidersByState(String state) {
        return infoProviderRepository.findByState(state);
    }
}
