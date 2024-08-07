package ru.hawkingbros.model;

import lombok.Data;

@Data
public class Message {
    private String msg;
    private String lng;
    private double latitude;
    private double longitude;
}
