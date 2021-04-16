package com.tbadhit.blogidn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.tbadhit.blogidn.api.ApiConfig;
import com.tbadhit.blogidn.model.DataArtikelItem;
import com.tbadhit.blogidn.model.ResponseBlog;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// Start!
// PERTAMA : Tambahkan Library", masuk ke "build.gradle (Module)" ->
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // (BA)
        RecyclerView rvBlog = findViewById(R.id.rv_blog);
        rvBlog.setHasFixedSize(true);
        rvBlog.setLayoutManager(new LinearLayoutManager(this));
        //-----------------

        // (GLA)
        ApiConfig.service.getListArtikel().enqueue(new Callback<ResponseBlog>() {
            @Override
            public void onResponse(Call<ResponseBlog> call, Response<ResponseBlog> response) {
                if (response.isSuccessful()) {
                    // Ambil data
                    ResponseBlog responseBlog = response.body();
                    boolean status = responseBlog.isStatus();
                    String message = responseBlog.getMessage();

                    // (GLAML)
                    List<DataArtikelItem> dataArtikel = responseBlog.getDataArtikel();
                    // (GLAML) Akhir-----------------------------------------------------------------

                    // (BA)
                    BlogAdapter blogAdapter = new BlogAdapter(dataArtikel);
                    blogAdapter.notifyDataSetChanged();
                    rvBlog.setAdapter(blogAdapter);
                    // (BA) Akhir-----------------------------
                    // Coba di running (SEHARUSNYA UDH MUNCUL DATANYA HOREEE!)
                    // Setelah di running, next bikin HALAMAN DETAIL
                    // Untuk bikin halaman detail PERTAMA bikin activity baru beri nama "DetailBlogActivity (pilih yang scrolling)" ->
                    // Setelah terbuat pergi ke "DetailBlogActivity" ->

                    // untuk test dataya berhasil di ambil / ga
                    String judul = dataArtikel.get(0).getJudul();

                    for(int i = 0; i < dataArtikel.size(); i++) {
                        String allJudul = dataArtikel.get(i).getJudul();
                        Log.d("MainActivity", allJudul);
                    }

                    // untuk test dataya berhasil di ambil / ga
                    Log.d("MainActivity", String.valueOf(status));
                    Log.d("MainActivity", message);
                    // Setelah ketik code di atas, masuk ke AndroidManifest dan tambahkan kode yang di komen (GLAM) ->

                    // (GLAML)
                    Log.d("MainActivity", judul);
                    // (GLAML) Akhir---------------------------
                    // Setelah tambahin kode yang dikomen (GLAML), sekarang klik kanan pada layout lalu pilih (New/Layout Resource File) dan beri nama "item_row_blog (plih CardView)"
                    // setelah bikin file resource tadi, sekarang styling layout "item_row_blog.xml" nya ->

                }
            }

            @Override
            public void onFailure(Call<ResponseBlog> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        //--------------------------------------------------------------------------------------------------------
    }
}