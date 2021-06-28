package com.example.bodeguinmicroinventario.cliente;


import com.example.bodeguinmicroinventario.Config.InventarioServiceconfig;
import com.example.bodeguinmicroinventario.dto.BodegaDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@Component
public class BodegaServiceClient {
    private RestTemplate restTemplate;

    @Autowired
    private InventarioServiceconfig  config;

    public BodegaServiceClient(RestTemplateBuilder builder){restTemplate = builder.build();}

    public Optional<BodegaDto> findAccount(String bodegaid){
        Optional<BodegaDto> result=Optional.empty();
        try{
            result = Optional.ofNullable(restTemplate
                    .getForObject(config.getBodegaserviceUrl()+"/{id}",BodegaDto.class,bodegaid));
        }
        catch (HttpClientErrorException ex){
            if(ex.getStatusCode() != HttpStatus.NOT_FOUND){
                throw ex;
            }
        }
        return result;

    }


}
