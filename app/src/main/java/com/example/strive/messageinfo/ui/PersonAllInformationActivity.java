package com.example.strive.messageinfo.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.strive.messageinfo.R;
import com.example.strive.messageinfo.entity.Node;

public class PersonAllInformationActivity extends AppCompatActivity {
    private Node node;
    private TextView name,title,date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_all_information);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        node = (Node) bundle.getSerializable("node");

        PersonAllInformationFragment fragment = new PersonAllInformationFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.allInformation,fragment);
        transaction.commit();

        fragment.setNode(node);

    }
}
