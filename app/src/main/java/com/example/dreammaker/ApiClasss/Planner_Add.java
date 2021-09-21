package com.example.dreammaker.ApiClasss;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Planner_Add {

    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Message")
    @Expose
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
