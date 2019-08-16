package com.kemasrisman.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kemasrisman.MainActivity;
import com.kemasrisman.R;
import com.kemasrisman.model.Friend;

import io.realm.Realm;


/*
        Nim  : 10116313
        Nama : Kemas Risman Fauzan
        Kelas: IF 7
        Waktu: 13/08/19
*/

public class EditFriendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final EditText inputName,inputEmail,inputNim,inputKelas,inputTlp,inputIg;
        Button btnAddFriend;
        final int id;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_friend);
        Bundle bundle = getIntent().getExtras();
        id = bundle.getInt("data");
        Realm.init(this);
        final Realm realm = Realm.getDefaultInstance();
        final Friend specificFriend = realm.where(Friend.class).equalTo("id", id).findFirst();

        inputNim = (EditText) findViewById(R.id.input_nim);
        inputName = (EditText) findViewById(R.id.input_nama);
        inputKelas = (EditText) findViewById(R.id.input_kelas);
        inputTlp= (EditText) findViewById(R.id.input_tlp);
        inputIg = (EditText) findViewById(R.id.input_ig);
        inputEmail = (EditText) findViewById(R.id.input_email);
        btnAddFriend = (Button) findViewById(R.id.btn_editFriend);

        inputName.setText(specificFriend.getNama());
        inputNim.setText(specificFriend.getNim());
        inputKelas.setText(specificFriend.getKelas());
        inputTlp.setText(specificFriend.getTelepon());
        inputEmail.setText(specificFriend.getEmail());
        inputIg.setText(specificFriend.getInstagram());

        btnAddFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm.beginTransaction();
                specificFriend.setNama(inputName.getText().toString());
                specificFriend.setNim(inputNim.getText().toString());
                specificFriend.setKelas(inputKelas.getText().toString());
                specificFriend.setTelepon(inputTlp.getText().toString());
                specificFriend.setEmail(inputEmail.getText().toString());
                specificFriend.setInstagram(inputIg.getText().toString());
                realm.commitTransaction();
                Toast.makeText(getBaseContext(), "Data sudah berhasil diedit", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                getBaseContext().startActivity(intent);
            }
        });
    }
}
