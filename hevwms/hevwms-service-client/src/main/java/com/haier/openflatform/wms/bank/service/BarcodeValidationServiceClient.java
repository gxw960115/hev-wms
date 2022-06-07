package com.haier.openflatform.wms.bank.service;

public interface BarcodeValidationServiceClient {
	  public boolean barcodeCheckFromBankToOtcwms(String barcode);
	  public String barcodesCheckFromBankToOtcwms(String barcodes);
}

