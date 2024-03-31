package gym.backend.controller;

import gym.backend.init.ProductDataFromSheetInit;
import gym.backend.init.ProductDataFromWebSite;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ScrapeDataFromWeb {

    private final ProductDataFromWebSite productDataFromWebSite;
    private final ProductDataFromSheetInit productDataFromSheetInit;


    @GetMapping("/startCollecting")
    public void startCollectingPrices(){
        System.out.println("Start collecting data...");

        productDataFromWebSite.addEnemyPricesAndRating();
    }

    @GetMapping("/getXML")
    public void startXML() throws IOException {
        System.out.println("Start collecting data...");

        productDataFromSheetInit.startInit();
    }


}
