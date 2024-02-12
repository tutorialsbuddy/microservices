package com.tutorialsbuddy.userservice.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import org.springframework.web.util.DefaultUriBuilderFactory;
import com.tutorialsbuddy.userservice.client.PaymentClient;

@Configuration
public class WebClientConfig {

  @Autowired
  private LoadBalancedExchangeFilterFunction filterFunction;

  @Bean
  public WebClient paymentWebClient() {
    String baseUrl = "http://payment-service";
    DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(baseUrl);
    return WebClient.builder().uriBuilderFactory(factory).filter(filterFunction).build();
  }

  @Bean
  public PaymentClient paymentClient() {
    HttpServiceProxyFactory httpServiceProxyFactory =
        HttpServiceProxyFactory.builderFor(WebClientAdapter.create(paymentWebClient())).build();
    return httpServiceProxyFactory.createClient(PaymentClient.class);
  }

}
