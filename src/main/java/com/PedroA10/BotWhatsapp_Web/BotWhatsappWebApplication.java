package com.PedroA10.BotWhatsapp_Web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@SpringBootApplication
@Slf4j
public class BotWhatsappWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BotWhatsappWebApplication.class, args);
	}

    @Bean
    public WebDriver webDriver() {
        log.info("Instanciando o Seleniun webdriver");
        ChromeOptions options = new ChromeOptions();
        var webDriver = new ChromeDriver(options);
        webDriver.get("https://web.whatsapp.com/");
        return webDriver;
    }
}
