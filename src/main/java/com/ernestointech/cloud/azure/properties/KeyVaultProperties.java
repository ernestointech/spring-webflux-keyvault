package com.ernestointech.cloud.azure.properties;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class KeyVaultProperties {
    private Map<String,String> secrets;
    private String endpoint;
    private String clientId;
    private String clientSecret;
    private String tenantId;
}

