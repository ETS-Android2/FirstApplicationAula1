package com.example.searchcep;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DevService {

    @GET("devs/all")
    Call<List<Dev>> getAllDevs();

}
