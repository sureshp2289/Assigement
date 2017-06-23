package assigment.example.com.assignment.apputils;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Start4me on 2/14/2017.
 */

public class AppUtils {

    public static final String BASE_URL ="https://polar-crag-10136.herokuapp.com";

    static ProgressDialog progessDialog;

    public static  void hideEdittext(Context context)
    {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }

    public static ApiInterface getInterfaceService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final ApiInterface mInterfaceService = retrofit.create(ApiInterface.class);
        return mInterfaceService;
    }
    public static SharedPreferences shared(Context context)
    {
        SharedPreferences sharedpreparence;
        sharedpreparence=context.getSharedPreferences("loginstatus",context.MODE_PRIVATE);
        return  sharedpreparence;
    }
    public static void showProgressDialog(Context context, String message) {

        if (context != null) {
            progessDialog = new ProgressDialog(context);
            progessDialog.setTitle("Retrofit App...");
            // progessDialog.setIcon(R.drawable.ic_launcher);
            progessDialog.setMessage("" + message);

            progessDialog.setCanceledOnTouchOutside(false);

            progessDialog.show();
        }
    }
    public static void hideProgressDialog() {


        if (progessDialog.isShowing()) {
            progessDialog.cancel();
            progessDialog.dismiss();

        } else {
            Log.d("Therapist App", "Progress Dialog is Null");
        }
    }
}
