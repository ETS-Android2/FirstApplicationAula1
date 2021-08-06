package com.example.searchcep.repository;

import android.os.Messenger;

import com.example.searchcep.model.Dev;
import com.example.searchcep.model.DevMessage;
import com.example.searchcep.service.RetrofitConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DevRepo {

    public interface ResultListener {
        void sucesso(List<Dev> dev);
        void falha(DevMessage messenger);
    }

    public void getDevRepo(final ResultListener resultadoDaRequisicao){
        Call<List<Dev>> call = new RetrofitConfig().getDevService().getAllDevs();

        call.enqueue(new Callback<List<Dev>>() {
            @Override
            public void onResponse(Call<List<Dev>> call, Response<List<Dev>> response) {
                if(!response.isSuccessful()){
                    int code = response.code();
                    resultadoDaRequisicao.falha(new DevMessage(response.errorBody().toString()));
                } else {
                    List<Dev> list = response.body();
                    resultadoDaRequisicao.sucesso(list);
                }
            }

            @Override
            public void onFailure(Call<List<Dev>> call, Throwable t) {
                // O erro 500 significa que o servidor falou em lhe responder
                resultadoDaRequisicao.falha(new DevMessage("Deu erro na requisição! Error message: \n" + t.getMessage()));
            }
        });
    }
}

