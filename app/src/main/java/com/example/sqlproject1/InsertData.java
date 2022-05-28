package com.example.sqlproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertData extends AppCompatActivity {

    EditText  idet,nameet, numberet, emailet, couseet;
    dbManager dbManager;
    SQLiteDatabase sqLiteDatabase;

    String idStr, nameStr, numbStr, emailStr, courseStr;
    int idint;
    String numint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);
        idet = findViewById(R.id.id_et);
        nameet = findViewById(R.id.name_et);
        numberet = findViewById(R.id.number_et);
        emailet = findViewById(R.id.email_et);
        couseet = findViewById(R.id.course_et);

        dbManager = new dbManager(this);
        sqLiteDatabase = dbManager.getReadableDatabase();

    }

    public void addRecord(View view) {
        converterMethod();
        long set = dbManager.addRecord(sqLiteDatabase, idint, nameStr, numint, emailStr, courseStr);
        Toast.makeText(this, "Data Inserted Sucessfully" + set, Toast.LENGTH_SHORT).show();

        idet.setText("");
        nameet.setText("");
        numberet.setText("");
        emailet.setText("");
        couseet.setText("");
    }
    private void converterMethod() {
        idStr = idet.getText().toString();
        nameStr = nameet.getText().toString();
        numbStr = numberet.getText().toString();
        emailStr = emailet.getText().toString();
        courseStr = couseet.getText().toString();

        idint = Integer.parseInt(idStr);
//        numint = Integer.parseInt(numbStr);
    }
}