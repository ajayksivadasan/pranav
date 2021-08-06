package com.example.newtrainigproject;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class RegistrationActivity extends AppCompatActivity {
    int year;
    int month;
    int day;


    Calendar myCalender = Calendar.getInstance();
    Context context;
    private EditText etName;
    private EditText etPass;
    private EditText etEmail;
    private EditText etPhone;
    private EditText etAddress;
    private EditText etDob;
    private EditText etAge;
    private Button btRegister;
    private RadioGroup rgGender;
    private CheckBox cbMusic;
    private CheckBox cbMovies;
    private CheckBox cbFootball;
    private CheckBox cbReading;
    private CheckBox cbRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        init();
        context = this;
        btRegister.setOnClickListener(view -> {
            int age;
            try {
                age = Integer.parseInt(etAge.getText().toString());
            } catch (Exception e) {
                e.printStackTrace();
                age = 0;
            }
            if (etName.getText().toString().trim().equals("")) {
                etName.setError("Enter valid Name");
            } else if (etPass.getText().toString().trim().equals("") || etPass.getText().toString().length() < 6) {
                etPass.setError("Enter valid password");
            } else if (etEmail.getText().toString().trim().equals("")) {
                etEmail.setError("Enter valid Email");
            } else if (etPhone.getText().toString().trim().equals("")) {
                etPhone.setError("Enter valid Phone Number");
            } else if (age == 0 || age > 120) {
                etAge.setError("Enter correct age");
            } else if (!cbRegister.isChecked()) {
                toastDislplay("Please agree the terms and conditions");
            } else {
                toastDislplay("Registration Success full ");
            }
            if (cbFootball.isChecked()) {
                toastDislplay("Foot Ball selected");

            }
            if (cbMovies.isChecked()) {
                toastDislplay("Movie selected");

            }
            if (cbMusic.isChecked()) {
                toastDislplay("Music selected");

            }
            if (cbReading.isChecked()) {
                toastDislplay("Reading selected");

            }


        });
        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rtMale) {
                    Toast t = Toast.makeText(RegistrationActivity.this, "Male selected", Toast.LENGTH_LONG);
                    t.show();
                } else if (i == R.id.rtFemale) {
                    Toast t = Toast.makeText(RegistrationActivity.this, "Female selected ", Toast.LENGTH_LONG);
                    t.show();
                } else if (i == R.id.rtOther) {
                    Toast t = Toast.makeText(RegistrationActivity.this, "Other selected", Toast.LENGTH_LONG);
                    t.show();
                }
            }
        });
        etDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(RegistrationActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        year = i;
                        month = i1;
                        day = i2;
                        myCalender.set(Calendar.DAY_OF_MONTH, day);
                        myCalender.set(Calendar.MONTH, month);
                        myCalender.set(Calendar.YEAR, year);
                        etDob.setText( day + "/" + (month + 1) + "/" + year);

                    }
                }, myCalender.get(Calendar.YEAR), myCalender.get(Calendar.MONTH), myCalender.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });


    }

    private void init() {
        etName = findViewById(R.id.etName);
        etPass = findViewById(R.id.etPass);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etAddress = findViewById(R.id.etAddress);
        etDob = findViewById(R.id.etDob);
        etAge = findViewById(R.id.etAge);
        btRegister = findViewById(R.id.btRegister);
        rgGender = findViewById(R.id.rgGender);
        cbMusic = findViewById(R.id.cbMusic);
        cbMovies = findViewById(R.id.cbMovies);
        cbFootball = findViewById(R.id.cbFootball);
        cbRegister = findViewById(R.id.cbRegister);
        cbReading = findViewById(R.id.cbReading);

    }

    private void toastDislplay(String message) {
        Toast t = Toast.makeText(RegistrationActivity.this, message, Toast.LENGTH_LONG);
        t.show();

    }
}