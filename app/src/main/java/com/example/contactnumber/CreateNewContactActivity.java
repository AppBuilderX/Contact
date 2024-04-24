package com.example.contactnumber;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class CreateNewContactActivity extends AppCompatActivity {

    // creating a new variable for our edit text and button.
    private TextInputEditText nameEdt, phoneEdt, emailEdt;
    private MaterialButton addContactEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        ColorDrawable drawable = new ColorDrawable(Color.parseColor("#448AFF"));
        getSupportActionBar().setBackgroundDrawable(drawable);
        getWindow().setStatusBarColor(ContextCompat.getColor(CreateNewContactActivity.this, R.color.dark_blue));
        setContentView(R.layout.activity_create_new_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getSupportActionBar().setTitle("Save Contact");

        // on below line we are initializing our variables.
        nameEdt = findViewById(R.id.con_name);
        phoneEdt = findViewById(R.id.con_number);
        emailEdt = findViewById(R.id.con_email);
        addContactEdt = findViewById(R.id.idBtnAddContact);

        Intent intent = getIntent();
        String num = intent.getExtras().getString("number");
        phoneEdt.setText(num);

        // on below line we are adding on click listener for our button.
        addContactEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are getting text from our edit text.
                String name = nameEdt.getText().toString();
                String phone = phoneEdt.getText().toString();
                String email = emailEdt.getText().toString();

                // on below line we are making a text validation.
                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(email) && TextUtils.isEmpty(phone)) {
                    Toast.makeText(CreateNewContactActivity.this, "Please enter the data in all fields. ", Toast.LENGTH_SHORT).show();
                } else {
                    // calling a method to add contact.
                    addContact(name, email, phone);
                }
            }
        });

    }

    private void addContact(String name, String email, String phone) {
        // in this method we are calling an intent and passing data to that
        // intent for adding a new contact.
        Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
        intent
                .putExtra(ContactsContract.Intents.Insert.NAME, name)
                .putExtra(ContactsContract.Intents.Insert.PHONE, phone)
                .putExtra(ContactsContract.Intents.Insert.EMAIL, email);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // in on activity result method.
        if (requestCode == 1){
            // we are checking if the request code is 1
            if (requestCode == Activity.RESULT_OK){
                // if the result is ok we are displaying a toast message.
                Toast.makeText(this, "Contact Has Been Added", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(CreateNewContactActivity.this, MainActivity.class);
                startActivity(i);
            }else {
                // else we are displaying a message as contact addition has cancelled.
                Toast.makeText(this, "Try Again For add new contact", Toast.LENGTH_SHORT).show();
            }
            if (requestCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "Cancelled Added Contact",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}