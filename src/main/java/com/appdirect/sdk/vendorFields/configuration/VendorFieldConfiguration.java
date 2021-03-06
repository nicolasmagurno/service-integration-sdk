package com.appdirect.sdk.vendorFields.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.appdirect.sdk.vendorFields.controller.VendorFieldValidationController;
import com.appdirect.sdk.vendorFields.handler.VendorFieldValidationHandler;
import com.appdirect.sdk.vendorFields.model.VendorFieldsValidationRequest;

@Configuration
public class VendorFieldConfiguration {
	@Bean
	public VendorFieldValidationController vendorFieldValidationController(VendorFieldValidationHandler vendorFieldValidationHandler) {
		return new VendorFieldValidationController(vendorFieldValidationHandler);
	}

	@Bean
	public VendorFieldValidationHandler vendorFieldValidationHandler() {
		return (VendorFieldsValidationRequest vendorFieldsValidationRequest) -> {
			throw new UnsupportedOperationException(String.format(
					"Vendor Fields Validation Service for editionCode=%s, flowType=%s and operationType=%s is not supported.",
					vendorFieldsValidationRequest.getEditionCode(),
					vendorFieldsValidationRequest.getFlowType(),
					vendorFieldsValidationRequest.getOperationType()));
		};
	}
}
