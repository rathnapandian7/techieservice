package org.customer.service.service;


import org.customer.service.entity.TokenDetailEntity;
import org.customer.service.repository.TokenDetailRepository;
import org.customer.service.security.dao.LoginDao;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.apache.commons.codec.binary.Base64;
import javax.crypto.SecretKey;
import java.util.Arrays;
//import java.util.Base64;

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
    @Autowired
    private TokenDetailRepository tokenRepo;
    private RestTemplate restTemplate;
    @Autowired
    private TokenDetailRepository tokeRepo;

    public GenerateToken() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        this.restTemplate = restTemplate;
    }

    public TokenDetailEntity generateToken(TokenDetailEntity tokenDetail, LoginDao login, Integer userId) {
        JSONObject jsonObj = new JSONObject(getOauthAccessToken(login));
        String access_token = jsonObj.get("access_token").toString();
        String refresh_token = jsonObj.get("refresh_token").toString();
        tokenDetail.setToken(access_token);
        tokenDetail.setRefreshToken(refresh_token);
        tokenRepo.deleteTokenById(userId);
        return tokenDetail;
    }

    private String getOauthAccessToken(LoginDao login) {
        String response = null;
        try {
//            DesPasswordEncoder pwd = new DesPasswordEncoder();
//            despwd.

            String credentials = "techie" + ":" + "test";
//            String encodedCredentials = login.getPassword() + Base64.getEncoder().despwd.en(securityKey.getEncoded());
            String encoding = new String(Base64.encodeBase64((credentials).getBytes()));
//            request.addHeader("Authorization", "Basic " + encoding);

//            String encodedCredentials = new String(despwd.encode(credentials));
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.valueOf(MediaType.APPLICATION_XML_VALUE)));
            headers.setAccept(Arrays.asList(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE)));
            headers.setContentType(MediaType.valueOf(String.valueOf(MediaType.APPLICATION_FORM_URLENCODED)));
            headers.add("Authorization", "Basic " + encoding);

            HttpEntity<String> request = new HttpEntity<String>(headers);
            String access_token_url = "http://localhost:1005/api/authservice/oauth/token";
            access_token_url += "?client_id=" + client_id;
            access_token_url += "&grant_type=password";
            access_token_url += "&username=" + login.getUserName();
            access_token_url += "&password=" + login.getPassword();

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
        String credentials = "techie:password";
        String encodedCredentials = new String(Base64.encodeBase64((credentials).getBytes()));
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.valueOf(MediaType.APPLICATION_XML_VALUE)));
        headers.setAccept(Arrays.asList(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE)));
        headers.setContentType(MediaType.valueOf(String.valueOf(MediaType.APPLICATION_FORM_URLENCODED)));
        headers.add("Authorization", "Basic " + encodedCredentials);
        return headers;
    }

}
