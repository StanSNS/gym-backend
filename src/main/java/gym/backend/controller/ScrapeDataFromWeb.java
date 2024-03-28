package gym.backend.controller;

import gym.backend.init.ProductDataFromWebSite;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScrapeDataFromWeb {

    private final ProductDataFromWebSite productDataFromWebSite;


    @GetMapping("/startCollecting")
    public void startCollectingPrices(){
        System.out.println("Start collecting data...");

        productDataFromWebSite.addEnemyPrices();
    }
}
