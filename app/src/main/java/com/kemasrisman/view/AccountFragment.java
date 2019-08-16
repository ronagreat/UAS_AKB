package com.kemasrisman.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.kemasrisman.R;
import com.kemasrisman.model.Login;

import io.realm.Realm;
import io.realm.RealmResults;


/*
        Nim  : 10116313
        Nama : Kemas Risman Fauzan
        Kelas: IF 7
        Waktu: 14/08/19
*/

public class AccountFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account,container,false);

        Button btnLogout = (Button) view.findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Realm.init(getContext());
                Realm realm = Realm.getDefaultInstance();
                RealmResults<Login> login = realm.where(Login.class).findAll();
                realm.beginTransaction();
                login.deleteAllFromRealm();
                realm.commitTransaction();
                Intent intent = new Intent(getContext(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });

        return view;
    }

}
