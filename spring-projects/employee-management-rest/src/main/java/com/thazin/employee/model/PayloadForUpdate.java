package com.thazin.employee.model;

public record PayloadForUpdate<T>(T payload, String message) {}
