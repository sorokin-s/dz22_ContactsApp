package com.amicus.dz22_contactsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MainActivityContacts extends AppCompatActivity {
    // активити для добавления нового контакта(наверно слишком жирно для этого)
    EditText editName;
    EditText editMail;
    EditText editPhone;
    ArrayList<String> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_add_contacts);
        editName = findViewById(R.id.editName);
        editMail = findViewById(R.id.edit_email);
        editPhone = findViewById(R.id.edit_phone);
        Button btnCancel = findViewById(R.id.button_cancel);
        Bundle arguments = getIntent().getExtras();
        if( arguments != null){
          list = arguments.getStringArrayList("list");  // получаем список из др активити

        }
        Intent intent = new Intent(this, MainActivity.class);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
                finish();
            }
        });

        Button btnAdd = findViewById(R.id.button_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {         // кнопка добавления контакта
            @Override
            public void onClick(View v) {
            list.add(new Person(editName.getText().toString(),editMail.getText().toString(),editPhone.getText().toString()).toString() ); // добавляем в список новый контакт
            intent.putExtra("list",list ) ;// передаём список между активити
            startActivity(intent);
            finish();
            }
        });
    }
}