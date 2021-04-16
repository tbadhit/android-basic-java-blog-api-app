package com.tbadhit.blogidn.api;

import com.tbadhit.blogidn.model.ResponseBlog;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    // Di Tambah
    @GET("list_artikel.php")
    Call<ResponseBlog> getListArtikel();
    // Setelah buat kode di atas, sekarang masuk ke "MainActivity" tambahkan kode yang di komen (GLA) ->
}
