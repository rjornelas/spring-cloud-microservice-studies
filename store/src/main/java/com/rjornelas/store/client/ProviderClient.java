package com.rjornelas.store.client;

import com.rjornelas.store.dto.InfoOrderDTO;
import com.rjornelas.store.dto.InfoProviderDto;
import com.rjornelas.store.dto.ProductItemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("provider")
public interface ProviderClient {

    @RequestMapping("/info/{state}")
    InfoProviderDto getInfoByState(@PathVariable String state);

    @RequestMapping(method = RequestMethod.POST, value = "/order")
    InfoOrderDTO placeOrder(List<ProductItemDto> productItemDtoList);
}
