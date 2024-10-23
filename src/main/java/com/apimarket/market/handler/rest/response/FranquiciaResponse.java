package com.apimarket.market.handler.rest.response;


import com.apimarket.market.domain.model.FranquiciaModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FranquiciaResponse {

    @JsonProperty("body")
    private FranquiciaModel franquiciaModel;

    @JsonProperty("status_code")
    private String statusCode;

    @JsonProperty("message")
    private String messsage;

}
