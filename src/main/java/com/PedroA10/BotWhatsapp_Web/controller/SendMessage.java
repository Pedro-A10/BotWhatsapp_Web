package com.PedroA10.BotWhatsapp_Web.controller;

import com.PedroA10.BotWhatsapp_Web.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/zip-zop")
@Slf4j
public class SendMessage {

    @Autowired
    private WebDriver webDriver;

    @PostMapping
    public void receiveMessage (@RequestBody Message message) {
        for (String Contact : message.getMessage()) {
            try {
                var elementContact = findContact(Contact);
                elementContact.click();

                var messageBox = findTextBox();
                messageBox.sendKeys(message.getContent());
                messageBox.sendKeys(Keys.RETURN);
            }catch (Exception e) {
                log.error("Não foi possível enviar a mensagem {}", Contact, e);
            }
        }
    }

    private WebElement findContact(String contactName) {
        var xPathContact = "//*[@id=\"pane-side\"]/*//span[@title='" + contactName + "']";
        return webDriver.findElement(By.xpath(xPathContact));
    }

    private WebElement findTextBox() {
        var xPathTextBox = "//*[@id=\"main\"]/footer//*[@role='textbox']";
        return webDriver.findElement(By.xpath(xPathTextBox));
    }
}