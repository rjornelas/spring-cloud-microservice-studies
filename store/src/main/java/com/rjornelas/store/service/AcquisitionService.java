package com.rjornelas.store.service;

import com.rjornelas.store.client.ProviderClient;
import com.rjornelas.store.dto.AcquisitionDto;
import com.rjornelas.store.dto.InfoOrderDTO;
import com.rjornelas.store.dto.InfoProviderDto;
import com.rjornelas.store.model.Purchase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcquisitionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AcquisitionService.class);

    @Autowired
    private ProviderClient providerClient;

    public Purchase purchase(AcquisitionDto acquisitionDto){

        LOGGER.info("BUSCANDO FORNECEDOR DO {}", acquisitionDto.getAdressDto().getState());
        InfoProviderDto info = providerClient
                .getInfoByState(acquisitionDto
                        .getAdressDto()
                        .getState());

        LOGGER.info("REALIZANDO O PEDIDO");
        InfoOrderDTO infoOrderDTO = providerClient
                .placeOrder(acquisitionDto
                        .getProductItemDtoList());

        Purchase persistePurchase = new Purchase();
        persistePurchase.setOrderId(infoOrderDTO.getId());
        persistePurchase.setPreparationTime(infoOrderDTO.getPreparationTime());
        persistePurchase.setDestinyAdress(acquisitionDto.getAdressDto().toString());

        return persistePurchase;
    }
}
