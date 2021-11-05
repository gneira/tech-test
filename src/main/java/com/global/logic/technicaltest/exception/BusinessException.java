package com.global.logic.technicaltest.exception;

public class BusinessException extends RuntimeException {
  private Enum code;
  private String message;

  public BusinessException(Enum code) {
    super(code.toString());
    this.setCode(code);
  }

  public BusinessException(Enum code, String message) {
    super(message);
    this.setCode(code);
    this.setMessage(message);
  }

  public Enum getCode() {
    return this.code;
  }

  public void setCode(Enum code) {
    this.code = code;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
