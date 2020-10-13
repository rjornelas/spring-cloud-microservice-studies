package com.rjornelas.store.dto;

import java.util.List;

public class AcquisitionDto {

    private List<ProductItemDto> productItemDtoList;

    private AdressDto adressDto;

    public List<ProductItemDto> getProductItemDtoList() {
        return productItemDtoList;
    }

    public void setProductItemDtoList(List<ProductItemDto> productItemDtoList) {
        this.productItemDtoList = productItemDtoList;
    }

    public AdressDto getAdressDto() {
        return adressDto;
    }

    public void setAdressDto(AdressDto adressDto) {
        this.adressDto = adressDto;
    }
}
