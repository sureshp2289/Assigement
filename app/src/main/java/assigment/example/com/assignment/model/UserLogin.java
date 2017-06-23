package assigment.example.com.assignment.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Start4me on 6/23/2017.
 */

public class UserLogin implements Serializable {
    @SerializedName("status")
    private String status;
    @SerializedName("info")
    private String info;
    @SerializedName("data")
    Data data;


    public UserLogin(String status, String info){
        this.status = status;
        this.info = info;


    }
    public String getStatus() {
        return status ;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info ;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
