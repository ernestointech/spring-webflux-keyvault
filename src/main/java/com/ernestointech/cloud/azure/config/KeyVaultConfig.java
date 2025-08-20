package com.ernestointech.cloud.azure.config;

import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;

import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.ernestointech.cloud.azure.properties.KeyVaultProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

@Configuration
public class KeyVaultConfig {

    @Bean
    @ConfigurationProperties(prefix = "application.ernestotech.azure.key-vault")
    public KeyVaultProperties keyVaultProperties(){
        return new KeyVaultProperties();
    }


    @Bean(name = "secretClient")
    public SecretClient getSecretClient(KeyVaultProperties keyVaultProperties){

        ClientSecretCredential clientSecretCredential = new ClientSecretCredentialBuilder()
                .clientId(keyVaultProperties.getClientId())
                .clientSecret(keyVaultProperties.getClientSecret())
                .tenantId(keyVaultProperties.getTenantId())
                .build();

        return new SecretClientBuilder()
                .vaultUrl(keyVaultProperties.getEndpoint())
                .credential(clientSecretCredential)
                .buildClient();
    }


    @Nullable
    @Bean(name = "tbdbTokenSecret")
    public String tbdbTokenSecret(
            SecretClient secretClient,
            KeyVaultProperties keyVaultProperties){
        return secretClient.getSecret(keyVaultProperties.getSecrets().get("tbdbTokenSecret")).getValue();
    }
}
