package com.tbadhit.blogidn.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseBlog{

	@SerializedName("message")
	private String message;

	@SerializedName("data_artikel")
	private List<DataArtikelItem> dataArtikel;

	@SerializedName("status")
	private boolean status;

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setDataArtikel(List<DataArtikelItem> dataArtikel){
		this.dataArtikel = dataArtikel;
	}

	public List<DataArtikelItem> getDataArtikel(){
		return dataArtikel;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}