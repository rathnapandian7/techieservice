package org.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;


@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private ResourceServerTokenServices tokenServices;

    @Value("${security.jwt.resource-ids}")
    private String resourceIds;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(resourceIds).tokenServices(tokenServices);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .requestMatchers()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/swagger-ui.html", "/customer/login/","/api-docs/**", "/oauth/**","/auth-service/h2/**").permitAll()
                .antMatchers("/**/secure/**").authenticated();

//        http.csrf().disable().authorizeRequests()
//                .antMatchers("/h2/*", "/customer/login","/customer/signOut"
//                        ,"/*" ,"/customer/get","/api/authservice/customer/get").permitAll()
//                .anyRequest().authenticated();
    }
}


