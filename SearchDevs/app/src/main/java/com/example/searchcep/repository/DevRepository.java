package com.example.searchcep.repository;

import android.content.Context;

import com.example.searchcep.DAO.AppDatabase;
import com.example.searchcep.model.Dev;
import com.example.searchcep.model.DevMessage;
import com.example.searchcep.model.DevRequest;
import com.example.searchcep.model.UserID;
import com.example.searchcep.service.RequestResult;
import com.example.searchcep.service.RetrofitConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DevRepository {

    private AppDatabase database;

    public DevRepository(Context context) {
        this(AppDatabase.getInstance(context));
    }

    private DevRepository(AppDatabase instance) {
        this.database = instance;
    }

    private void insert(List<Dev> devs) {
        database.devDao().insertAll(devs);
    }

    public void getAll(final RequestResult requestResult) {

        Call<List<Dev>> call = new RetrofitConfig().getDevService().getAllDevs();
        call.enqueue(new Callback<List<Dev>>() {
            @Override
            public void onResponse(Call<List<Dev>> call, Response<List<Dev>> response) {
                List<Dev> devs = response.body();
                DevRepository.this.insert(devs);
                requestResult.returnSuccess(devs);
            }

            @Override
            public void onFailure(Call<List<Dev>> call, Throwable t) {
                requestResult.returnError("Deu erro na requisição! Error message: \n" + t.getMessage());
            }
        });
    }

    public void getDevs(String name, final RequestResult requestResult) {

        Call<DevMessage> call = new RetrofitConfig().getDevService().getMessage(name);
        call.enqueue(new Callback<DevMessage>() {
            @Override
            public void onResponse(Call<DevMessage> call, Response<DevMessage> response) {
                DevMessage message = response.body();
                requestResult.returnSuccess(message.getMenssagem());
            }

            @Override
            public void onFailure(Call<DevMessage> call, Throwable t) {
                requestResult.returnError("Deu erro na requisição! Error message: \n" + t.getMessage());
            }
        });
    }

    public void getDevsByLike(String name, final RequestResult requestResult) {

        Call<List<Dev>> call = new RetrofitConfig().getDevService().getDevsByLike(name);
        call.enqueue(new Callback<List<Dev>>() {
            @Override
            public void onResponse(Call<List<Dev>> call, Response<List<Dev>> response) {
                requestResult.returnSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Dev>> call, Throwable t) {
                requestResult.returnError("Deu erro na requisição! Error message: \n" + t.getMessage());
            }
        });
    }

    public void addDev(String userName ,final RequestResult requestResult) {

        Call<Dev> call = new RetrofitConfig().getDevService().add(new DevRequest(userName));

        call.enqueue(new Callback<Dev>() {
            @Override
            public void onResponse(Call<Dev> call, Response<Dev> response) {
                Dev dev = response.body();
                requestResult.returnSuccess(dev);
            }

            @Override
            public void onFailure(Call<Dev> call, Throwable t) {
                requestResult.returnError("Deu erro na requisição! Error message: \n" + t.getMessage());
            }
        });

    }

    public void getUserProfile(String username, final RequestResult requestResult) {

        Call<Dev> call = new RetrofitConfig().getDevService().getDevByUsername(username);

        call.enqueue(new Callback<Dev>() {
            @Override
            public void onResponse(Call<Dev> call, Response<Dev> response) {
                Dev dev = response.body();
                UserID userID = new UserID(dev.get_id());
                database.idDao().insertUserID(userID);
                requestResult.returnSuccess(dev);
            }

            @Override
            public void onFailure(Call<Dev> call, Throwable t) {
                requestResult.returnError("Deu erro na requisição! Error message: \n" + t.getMessage());
            }
        });

    }
}
