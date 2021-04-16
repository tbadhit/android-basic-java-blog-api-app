package com.tbadhit.blogidn.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

// (PL) Tambahkan Parcelable
// Kalau sudah kembali ke "BlogAdapter" ->
public class DataArtikelItem implements Parcelable {

	@SerializedName("tgl_posting")
	private String tglPosting;

	@SerializedName("author")
	private String author;

	@SerializedName("id")
	private String id;

	@SerializedName("judul")
	private String judul;

	@SerializedName("gambar")
	private String gambar;

	@SerializedName("isi")
	private String isi;

	protected DataArtikelItem(Parcel in) {
		tglPosting = in.readString();
		author = in.readString();
		id = in.readString();
		judul = in.readString();
		gambar = in.readString();
		isi = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(tglPosting);
		dest.writeString(author);
		dest.writeString(id);
		dest.writeString(judul);
		dest.writeString(gambar);
		dest.writeString(isi);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<DataArtikelItem> CREATOR = new Creator<DataArtikelItem>() {
		@Override
		public DataArtikelItem createFromParcel(Parcel in) {
			return new DataArtikelItem(in);
		}

		@Override
		public DataArtikelItem[] newArray(int size) {
			return new DataArtikelItem[size];
		}
	};

	public void setTglPosting(String tglPosting){
		this.tglPosting = tglPosting;
	}

	public String getTglPosting(){
		return tglPosting;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return author;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setJudul(String judul){
		this.judul = judul;
	}

	public String getJudul(){
		return judul;
	}

	public void setGambar(String gambar){
		this.gambar = gambar;
	}

	public String getGambar(){
		return gambar;
	}

	public void setIsi(String isi){
		this.isi = isi;
	}

	public String getIsi(){
		return isi;
	}
}