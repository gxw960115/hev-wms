package com.bank.service;

import java.util.List;

public interface BarcodeValidationServiceFromBankToOtcwms {
  public List barcodesCheckFromBankToOtcwms(List barcodeList);
  public String barcodeCheckFromBankToOtcwms(String barcode);
}
