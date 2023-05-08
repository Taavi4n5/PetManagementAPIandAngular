package com.taaviansper.petmanagementapi.DTO;

public class ResponseDTO {


    private Integer status;
    private String success;
    private String message;

    public ResponseDTO(Integer status, String success, String message) {
        this.status = status;
        this.success = success;
        this.message = message;
    }
    public Integer getstatus() {
        return status;
    }

    public void setstatus(Integer status) {
        this.status = status;
    }

    public String getsuccess() {
        return success;
    }

    public void setsuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
