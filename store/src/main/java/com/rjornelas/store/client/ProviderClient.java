package com.rjornelas.store.client;

import com.rjornelas.store.dto.InfoProviderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("provider")
public interface ProviderClient {

    @RequestMapping("/info/{state}")
    InfoProviderDto getInfoByState(@PathVariable String state);
}
