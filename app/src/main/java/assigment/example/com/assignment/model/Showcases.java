package assigment.example.com.assignment.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Start4me on 6/24/2017.
 */

public class Showcases {
    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("year")
    private String year;

    @SerializedName("user_id")
    private String user_id;

    public Showcases(String id, String title, String description, String year, String user_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.year = year;
        this.user_id = user_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}