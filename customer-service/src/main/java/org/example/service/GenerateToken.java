package org.example.service;



import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Base64;

@Service
public class GenerateToken {

    @Value("${security.oauth2-server-url}")
    private String authServer;

    @Value("${security.jwt.grant-type-password}")
    private String grantType_Password;

    @Value("${security.jwt.grant-type-refresh_token}")
    private String grantType_RefreshToken;

    @Value("${security.oauth2-server.user-id}")
    private String client_id;

    @Value("${security.oauth2-server.password}")
    private String client_secret;


    private RestTemplate restTemplate;


    public GenerateToken() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        this.restTemplate = restTemplate;
    }


    public String generateToken() {
        String token=getOauthAccessToken();
        JSONObject jsonObj = new JSONObject(token);
        String access_token = jsonObj.get("access_token").toString();
        String refresh_token = jsonObj.get("refresh_token").toString();

        return access_token;
    }


    private String getOauthAccessToken() {
        String response = null;
        try {

            String credentials = "tcl" + ":" +"password";
            String encodedCredentials = new String(Base64.getEncoder().encode(credentials.getBytes()));

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.valueOf(MediaType.APPLICATION_XML_VALUE)));
            headers.setAccept(Arrays.asList(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE)));
            headers.setContentType(MediaType.valueOf(String.valueOf(MediaType.APPLICATION_FORM_URLENCODED)));
            headers.add("Authorization", "Basic " + encodedCredentials);

            HttpEntity<String> request = new HttpEntity<String>(headers);
            String access_token_url = "http://localhost:1004/oauth/token";
            access_token_url += "?client_id=" + client_id;
            access_token_url += "&grant_type=password";
            access_token_url += "&username=" + "tcl";
            access_token_url += "&password=" + "password";

            response = restTemplate.postForObject(access_token_url, request, String.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response;
    }

    private MultiValueMap<String, String> setTokenParams() {
        MultiValueMap<String, String> jsonCredentials = new LinkedMultiValueMap<>();
        jsonCredentials.add("grant_type", "passowrd");
        jsonCredentials.add("username", "techie");
        jsonCredentials.add("password", "password");
        jsonCredentials.add("client_id", client_id);
        return jsonCredentials;

    }

    private HttpHeaders setHeaders() {
        String credentials = "tc:password";
        String encodedCredentials = new String(Base64.getEncoder().encode(credentials.getBytes()));
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.valueOf(MediaType.APPLICATION_XML_VALUE)));
        headers.setAccept(Arrays.asList(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE)));
        headers.setContentType(MediaType.valueOf(String.valueOf(MediaType.APPLICATION_FORM_URLENCODED)));
        headers.add("Authorization", "Basic " + encodedCredentials);
        return headers;
    }

}
