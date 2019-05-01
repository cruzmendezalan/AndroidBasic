package com.krakenlabs.androidbasic.models.login.response;


import com.google.gson.annotations.SerializedName;


public class Login {

	@SerializedName("data")
	private Data data;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"Login{" +
			"data = '" + data + '\'' + 
			"}";
		}
}