package com.tbadhit.blogidn;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tbadhit.blogidn.model.DataArtikelItem;

import java.util.List;

// Setelah selesai buat class, tambahkan "extends RecyclerView.Adapter<BlogAdapter.MyViewHolder>"
// Kalo merah, tinggal alt + enter aja yang merahnya sampe ga merah
public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.MyViewHolder> {

    // 1. bikin constructor
    private List<DataArtikelItem> dataArtikelItemList;

    public BlogAdapter(List<DataArtikelItem> dataArtikelItemList) {
        this.dataArtikelItemList = dataArtikelItemList;
    }
    //--------------------

    // 2. call layout
    @NonNull
    @Override
    public BlogAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_blog, parent, false);
        return new MyViewHolder(view);
    }

    // 4. Show data
    @Override
    public void onBindViewHolder(@NonNull BlogAdapter.MyViewHolder holder, int position) {
        holder.tvTanggal.setText(dataArtikelItemList.get(position).getTglPosting());
        holder.tvPenulis.setText(dataArtikelItemList.get(position).getAuthor());
        holder.tvJudul.setText(dataArtikelItemList.get(position).getJudul());

        // Gambar
        Glide.with(holder.itemView).load(dataArtikelItemList.get(position).getGambar())
                                .error(R.drawable.ic_launcher_background)
                                .into(holder.imgBlog);

        // (CS)
        Context context = holder.itemView.getContext();
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailBlogActivity.class);
            // cara biar ga merah, pergi ke "DataArtikelItem" tambahkan kode yang di komen (PL)->
            intent.putExtra("DETAIL", dataArtikelItemList.get(position));
            context.startActivity(intent);
        });
        //--------------------------
        // Setelah membuat code di atas, masuk ke "DetailBlogActivity" tambahkan kode yang dikomen (CSL) ->
    }

    // 5. jumlah data
    @Override
    public int getItemCount() {
        return dataArtikelItemList.size();
        // Setelah menulis kode di atas, sekarang pergi ke "MainActivity" tambahkan code yang di komen (BA)->
    }

    // 3. Call view / widget
    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgBlog;
        TextView tvJudul, tvPenulis, tvTanggal;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBlog = itemView.findViewById(R.id.item_img_blog);
            tvJudul = itemView.findViewById(R.id.item_tv_judul);
            tvPenulis = itemView.findViewById(R.id.item_tv_penulis);
            tvTanggal = itemView.findViewById(R.id.item_tv_tanggal);
        }
    }
}
