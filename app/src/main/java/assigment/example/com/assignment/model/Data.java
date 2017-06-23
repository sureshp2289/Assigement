package assigment.example.com.assignment.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Start4me on 6/23/2017.
 */

public class Data {
    @SerializedName("user")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
