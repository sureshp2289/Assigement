package assigment.example.com.assignment.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Start4me on 6/24/2017.
 */

public class Feed implements Serializable {
    @SerializedName("status")
    private String status;
    @SerializedName("info")
    private String info;
    @SerializedName("showcases")
    ArrayList<Showcases> showcases;

    public Feed(String status,String info){
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

    public ArrayList<Showcases> getShowcases(){
        return showcases;
    }

    public void setUsers(ArrayList<Showcases> showcases) {
        this.showcases= showcases;
    }
}

