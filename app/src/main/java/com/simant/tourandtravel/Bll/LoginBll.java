package com.simant.tourandtravel.Bll;

import com.simant.tourandtravel.MainActivity;
import com.simant.tourandtravel.activity.ReviewActivity;
import com.simant.tourandtravel.api.BaseURL;
import com.simant.tourandtravel.api.Interface;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBll {

    boolean isSuccess = false;

    public boolean checkuser(String email, String password) {

        Interface Interface = BaseURL.getInstance().create(Interface.class);
        Call<SignUpResponse> usersCall = Interface.checkUser(email, password);

        // use try and catch
        try {
            Response<SignUpResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful() && loginResponse.body().isStatus()) {
                // setID
                MainActivity.userID = loginResponse.body().get_id();
                ReviewActivity.userID = loginResponse.body().get_id();

                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;


    }
}