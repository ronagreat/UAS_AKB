package com.kemasrisman.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kemasrisman.MainActivity;
import com.kemasrisman.R;
import com.kemasrisman.model.Friend;

import io.realm.Realm;
import io.realm.RealmResults;


/*
        Nim  : 10116313
        Nama : Kemas Risman Fauzan
        Kelas: IF 7
        Waktu: 13/08/19
*/

public class FriendDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView textNama,textNim,textKelas,textTelepon,textEmail,textInstagram;;
        Button btn_detailHapus,btn_detailEdit;
        final int id;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_detail);

        Bundle bundle = getIntent().getExtras();
        id = bundle.getInt("data");
        Realm.init(this);
        final Realm realm = Realm.getDefaultInstance();
        final Friend specificFriend = realm.where(Friend.class).equalTo("id", id)
                .findFirst();

        btn_detailHapus = (Button) findViewById(R.id.btn_detailHapus);
        btn_detailEdit = (Button) findViewById(R.id.btn_detailEdit);
        textNama = (TextView)findViewById(R.id.detail_nama);
        textNim = (TextView)findViewById(R.id.detail_nim);
        textKelas = (TextView)findViewById(R.id.detail_kelas);
        textTelepon = (TextView)findViewById(R.id.detail_telepon);
        textEmail = (TextView)findViewById(R.id.detail_email);
        textInstagram= (TextView)findViewById(R.id.detail_ig);

        textNama.setText(specificFriend.getNama());
        textNim.setText(specificFriend.getNim());
        textKelas.setText(specificFriend.getKelas());
        textTelepon.setText(specificFriend.getTelepon());
        textEmail.setText(specificFriend.getEmail());
        textInstagram.setText(specificFriend.getInstagram());

        btn_detailHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realm.beginTransaction();
                specificFriend.deleteFromRealm();
                realm.commitTransaction();
                Toast.makeText(getBaseContext(), "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                getBaseContext().startActivity(intent);
            }
        });

        btn_detailEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentEditTemanView = new Intent(getBaseContext(), EditFriendActivity.class);
                intentEditTemanView.putExtra("data",id);
                intentEditTemanView.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getBaseContext().startActivity(intentEditTemanView);
            }
        });


    }
}
