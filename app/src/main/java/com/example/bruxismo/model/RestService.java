package com.example.bruxismo.model;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface RestService {
    @GET("sorteio/{dog}")
    Call<ResponseBody> Buscar(@Path("dog") String dog);

}