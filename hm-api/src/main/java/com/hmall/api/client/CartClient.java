package com.hmall.api.client;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient("cart-service")
public interface CartClient {

    @DeleteMapping("/carts")
    public void deleteCartItemByIds(@RequestParam("ids") List<Long> ids);
}