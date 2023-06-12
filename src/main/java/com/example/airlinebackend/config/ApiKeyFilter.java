package com.example.airlinebackend.config;
import com.example.airlinebackend.model.ApiKey;
import com.example.airlinebackend.service.ApiKeyService;
import jakarta.servlet.*;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class ApiKeyFilter implements Filter {
    private static final String API_KEY_HEADER = "X-API-Key";
    private static final String TARGET_ENDPOINT = "/api/ticket/purchase/external";

    private final ApiKeyService apiKeyService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        String apiKey = httpRequest.getHeader(API_KEY_HEADER);
        String requestURL = httpRequest.getRequestURI();

        System.out.println(requestURL);

        if (!requestURL.equals(TARGET_ENDPOINT) || apiKey == null) {
            chain.doFilter(request, response);
            return;
        }

        System.out.println("Did i make it here");


        var apiKeyList = apiKeyService.getAll();
        var exists = false;
        ApiKey foundApiKey = null;
;        for (var a: apiKeyList) {
            if (a.getKey().equals(apiKey)) {
                foundApiKey = a;
                exists = true;
            }
        }

        System.out.println(foundApiKey);

        if (!exists || (foundApiKey.getExpiryDate().isBefore(LocalDate.now()) && !foundApiKey.isPermanent())) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            System.out.println("He needs to be canceled");
            return;
        }


        System.out.println("I did continue");
        // API key is valid or not required, continue with the request
        chain.doFilter(request, response);
    }
}