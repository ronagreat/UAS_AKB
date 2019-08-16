package com.kemasrisman.view;

/*
        Nim  : 10116313
        Nama : Kemas Risman Fauzan
        Kelas: IF 7
        Waktu: 13/08/19
*/
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.kemasrisman.MainActivity;
import com.kemasrisman.R;
import com.kemasrisman.model.Login;
import com.kemasrisman.presenter.LoginPresenter;

import io.realm.Realm;
import io.realm.RealmResults;

public class LoginActivity extends AppCompatActivity{
    private EditText inputEmail,inputPassword;
    private Button btnLogin,btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Realm.init(this);
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Login> login = realm.where(Login.class).findAll();
        if(login.size() > 0){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inputEmail = (EditText) findViewById(R.id.input_email);
        inputPassword = (EditText) findViewById(R.id.input_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnRegister = (Button) findViewById(R.id.btn_register);


        final LoginPresenter loginPresenter = new LoginPresenter();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.btnLoginClicked(getBaseContext(),inputEmail,inputPassword);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), RegisterActivity.class);
                startActivity(intent);

            }
        });
    }
}
