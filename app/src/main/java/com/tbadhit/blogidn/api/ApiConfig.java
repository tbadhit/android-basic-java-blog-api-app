package com.tbadhit.blogidn.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Buka dokumentasi https://square.github.io/retrofit/ pilih retrofit configuration (Copy code nya)
public class ApiConfig {

    private static String baseURL = "http://172.16.8.171/api_blog_idn/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static ApiService service = retrofit.create(ApiService.class);
    // Setelah bikin code di atas, sekarang masuk ke plugin android studio install "RoboPOJO" (Karna mau ubah json ke object java)
    // Setelah itu masuk ke browser search JSON Viewer, dan copy code json yang di http://localhost/api_blog_idn/list_artikel.php (biar gampang liat susunan jsonnya)
    // setelah itu klik kanan pada package "model" lalu pilih (New/Generate Pojo from Json), lalu paste kode json nya disitu, lalu beri nama "ResponseBlog"
    // Setelah bikin ResponseBlog, skrng masuk ke ApiService ->
}
