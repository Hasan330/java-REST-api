package com.hasan;

import com.hasan.models.Owner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);


//        RestTemplate restTemplate = new RestTemplate();
//        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
//        System.out.println("Quote is: " + quote.toString());

        RestTemplate restTemplate = new RestTemplate();
//        Owner owner = restTemplate.getForObject("https://randomuser.me/api/", Owner.class);
        Owner owner = restTemplate.getForObject("https://qhc7ac9d7c.execute-api.us-east-1.amazonaws.com/development/sampleFunction", Owner.class);
        System.out.println("Quote is: " + owner.toString());
    }
}