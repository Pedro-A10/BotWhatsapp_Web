package com.PedroA10.BotWhatsapp_Web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message{
    private Set<String> message;
    private String content;
}
