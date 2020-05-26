package com.flightmap.demo.Common.CustomException;

public interface CommonError {
    public int getErrorCode();

    public String getErrorMsg();

    public CommonError setErrorMsg(String ErrorMsg);
}
