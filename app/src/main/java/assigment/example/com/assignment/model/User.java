package assigment.example.com.assignment.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Start4me on 6/23/2017.
 */

public class User {

    @SerializedName("access_token")
    private String access_token;

    @SerializedName("email")
    private String email;


    public User(String access_token, String email) {
        this.access_token = access_token;
        this.email=email;


    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

}
