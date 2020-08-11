package com.example.searchcep.service;

public interface RequestResult {
    <T> void returnSuccess(T requestResult);
    void returnError(String message);
}
