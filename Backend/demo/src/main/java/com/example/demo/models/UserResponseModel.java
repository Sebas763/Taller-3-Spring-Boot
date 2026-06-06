package com.example.demo.models;

import java.util.UUID;

public record UserResponseModel (
    UUID resourceId,
    String name,
    int age) {

}