package assigment.example.com.assignment.apputils;

import com.google.gson.JsonObject;

import assigment.example.com.assignment.model.Feed;
import assigment.example.com.assignment.model.UserLogin;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {
    @Headers({"Accept:application/json"})
    @POST("/users/sign_in")
    Call<UserLogin> login(
            @Header("Content-Type") String str_content,
            @Body JsonObject method);

    @Headers({"Accept:application/json"})
    @GET("/get_feeds")
    Call<Feed> getfeeds(
            @Header("X-ACCESS-TOKEN") String accestoken,
            @Header("X-USER-EMAIL") String email
    );
}
