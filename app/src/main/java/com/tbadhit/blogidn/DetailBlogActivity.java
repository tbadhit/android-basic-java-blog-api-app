package com.tbadhit.blogidn;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.tbadhit.blogidn.model.DataArtikelItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

// PERTAMA: Bikin layout ->
public class DetailBlogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_blog);

        // (CSL)
        ImageView imgDetail = findViewById(R.id.img_detail);
        TextView tvIsiDetail = findViewById(R.id.tv_isi_detail);

        DataArtikelItem dataArtikelItem = getIntent().getParcelableExtra("DETAIL");
        //-------------------------------------------------------------------------------

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // (CSL)
        tvIsiDetail.setText(dataArtikelItem.getIsi());
        toolBarLayout.setTitle(dataArtikelItem.getJudul());
        Glide.with(this)
                .load(dataArtikelItem.getGambar())
                .error(R.drawable.ic_launcher_background)
                .into(imgDetail);
        //------------------------
        // Coba running
        // SELESAI!!!!!
    }
}