package com.thazin.employee.model;

import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;

public record SimplePayload<T>(PayloadStatus status, LocalDateTime issuedAt, T payload) {
	
	public static<T> SimplePayload<T> success(T payload) {
		return new SimplePayload<>(PayloadStatus.Success, now(), payload);
	}
	
	public static<T> SimplePayload<T> validation(T payload) {
		return new SimplePayload<>(PayloadStatus.Validation, now(), payload);
	}

	public static<T> SimplePayload<T> business(T payload) {
		return new SimplePayload<>(PayloadStatus.Business, now(), payload);
	}
	
	public enum PayloadStatus {
		Success, Validation, Business
	}
}
