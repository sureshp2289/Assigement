package assigment.example.com.assignment.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;

import assigment.example.com.assignment.R;
import assigment.example.com.assignment.apputils.ApiInterface;
import assigment.example.com.assignment.apputils.AppUtils;
import assigment.example.com.assignment.feeds.GetFeed;
import assigment.example.com.assignment.model.UserLogin;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login_Activity extends AppCompatActivity {
SharedPreferences sharedPreferences;
    SharedPreferences.Editor spe;
    @BindView(R.id.et_email) EditText et_email;
    @BindView(R.id.et_password) EditText et_password;
    @BindView(R.id.btn_signin)Button btn_signin;
    @OnClick(R.id.btn_signin)

    public void onclick(Button button) {
        AppUtils.hideEdittext(Login_Activity.this);
        String emailPattern ="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(et_email.getText().toString().trim().length()>0&&et_password.getText().toString().trim().length()>0)
        {
            if(et_email.getText().toString().trim().matches(emailPattern))
            {
                JsonObject postParam = new JsonObject();
                JsonObject postParam1 = new JsonObject();
                postParam.addProperty("email",et_email.getText().toString().trim().toLowerCase()) ;
                postParam.addProperty("password",et_password.getText().toString().trim()) ;
                AppUtils.showProgressDialog(Login_Activity.this,"Please wait");
                login(postParam);
            }
            else {
                Toast.makeText(Login_Activity.this, "Enter the valid emailid", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(Login_Activity.this, "all fieds are madatatory", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        ButterKnife.bind(this);
        sharedPreferences=AppUtils.shared(Login_Activity.this);
        spe = sharedPreferences.edit();




    }
    private void login(final JsonObject jsonObject){

        ApiInterface mApiService = AppUtils.getInterfaceService();
        Call<UserLogin> call = mApiService.login("application/json;charset=UTF-8",jsonObject);
        call.enqueue(new Callback<UserLogin>() {
            @Override
            public void onResponse(Call<UserLogin> call, Response<UserLogin> response) {
AppUtils.hideProgressDialog();
                UserLogin mLoginObject = response.body();
                Toast.makeText(Login_Activity.this, mLoginObject.getInfo(), Toast.LENGTH_LONG).show();

                if(mLoginObject.getStatus().equalsIgnoreCase("Success")) {
                    String accestoken = mLoginObject.getData().getUser().getAccess_token();
                    String email=mLoginObject.getData().getUser().getEmail();
                    spe.putBoolean("status",true);
                    spe.putString("email",email);
                    spe.putString("accesstoken",accestoken);
                    spe.commit();
                    Intent a=new Intent(Login_Activity.this, GetFeed.class);
                    startActivity(a);
                }
            }

            @Override
            public void onFailure(Call<UserLogin> call, Throwable t) {
                AppUtils.hideProgressDialog();
                call.cancel();
                Toast.makeText(Login_Activity.this, "Please check your network connection and internet permission", Toast.LENGTH_LONG).show();
            }
        });
    }
}
