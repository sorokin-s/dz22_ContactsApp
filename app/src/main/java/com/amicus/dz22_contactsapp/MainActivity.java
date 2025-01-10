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

public class MainActivity extends AppCompatActivity {
    //  активити для отображения списка контактов
    ArrayList<Person> listPersons = new ArrayList<>();  // список контактов
    ArrayAdapter<String> arrayAdapter;
    ListView listContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listContacts = findViewById(R.id.listContacts);
        listPersons.add(new Person("Firstname1 Lastname1","accaunt@gmail.com","+7 999 9999990")); // добавляем контакты для примера
        listPersons.add(new Person("Firstname2 Lastname2","accaunt@gmail.com","+7 999 9999999"));
        listPersons.add(new Person("Firstname3 Lastname3","accaunt@gmail.com","+7 999 9999996"));
        listPersons.add(new Person("Firstname4 Lastname4","accaunt@gmail.com","+7 999 9999993"));
        Button btnAddContact = findViewById(R.id.buttonAddContact);
        Button btnExit = findViewById(R.id.buttonExit);
        ArrayList<String> list = listPersons
                .stream().map(Person::toString)
                .collect(Collectors
                        .toCollection(ArrayList::new)); // приводим к списку строк
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list); // адаптер связывает список строк с ListView
        listContacts.setAdapter(arrayAdapter); // устанавливаем для списка адаптер

        Bundle arguments = getIntent().getExtras();
        if( arguments != null){
            var _list = arguments.getStringArrayList("list");// получаем список из др активити
            arrayAdapter.clear();   // Очищаем список
            assert _list != null;
            arrayAdapter.addAll(_list);  // Заполняем, с новым элементом если добавили
        }
        Intent intent = new Intent(this,MainActivityContacts.class);
        btnExit.setOnClickListener(new View.OnClickListener() {    // закрыть приложение
            @Override
            public void onClick(View v) {

                finish();
            }

        });

        btnAddContact.setOnClickListener(new View.OnClickListener() {  // кнопка вызова активити для добавления нового контакта
            @Override
            public void onClick(View v) {
                intent.putExtra("list",list);  // передаём список между активити
                startActivity(intent);
                finish();
            }
        });

    }

}