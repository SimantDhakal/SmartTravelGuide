package com.simant.tourandtravel.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.simant.tourandtravel.R;
import com.simant.tourandtravel.api.BaseURL;
import com.simant.tourandtravel.api.Interface;
import com.simant.tourandtravel.modal.UserModal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    EditText etFullname, etEmail, etPassword, etPhone;
    TextView backToLogin;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        etFullname = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etPhone = findViewById(R.id.etPhone);
        backToLogin=findViewById(R.id.backToLogin);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etFullname.getText().toString().equals("") || etPhone.getText().toString().equals("") || etPassword.getText().toString().equals("")){
                    Toast.makeText(RegisterActivity.this, "All the fields are mandatory", Toast.LENGTH_SHORT).show();
                    etEmail.setHighlightColor(1);
                    return;
                }
                if(etEmail.getText().toString().length()>0 && etEmail.getText().toString().matches(emailPattern)){
                    if(etPassword.getText().toString().length()<6){
                        Toast.makeText(RegisterActivity.this, "Password must be minimum of 6 characters", Toast.LENGTH_SHORT).show();
                        etPassword.setHighlightColor(1);
                        etPassword.requestFocus();
                        return;
                    }
                }
                else {
                    Toast.makeText(RegisterActivity.this, "Please enter valid email", Toast.LENGTH_SHORT).show();
                    etEmail.requestFocus();
                    return;
                }


                userRegister();
            }
        });

        backToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void userRegister() {
        String fullname = etFullname.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String phone = etPhone.getText().toString();

        UserModal employee = new UserModal(fullname, email, password, phone);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseURL.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Interface userInt = retrofit.create(Interface.class);
        Call<Void> voidCall = userInt.registerUser(employee);

        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                System.out.println("User" + response.body());
                Toast.makeText(getApplicationContext(), "You have been registered", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
