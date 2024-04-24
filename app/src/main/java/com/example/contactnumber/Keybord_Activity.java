package com.example.contactnumber;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Keybord_Activity extends AppCompatActivity {

    ImageView callButton, backButton;
    TextView eNumber, addNumber;
    String phone_number;

    Button oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn,sixBtn, sevenBtn, eightBtn, nineBtn, zeroBtn, hashBtn, starBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_keybord);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // getWindow().setStatusBarColor(ContextCompat.getColor(Keybord_Activity.this, R.color.dark_blue));


        callButton = findViewById(R.id.imageView2);
        eNumber = findViewById(R.id.displayTv);
        oneBtn = findViewById(R.id.one_button);
        twoBtn = findViewById(R.id.two_button);
        threeBtn = findViewById(R.id.three_button);
        fourBtn = findViewById(R.id.four_button);
        fiveBtn = findViewById(R.id.five_button);
        sixBtn = findViewById(R.id.six_button);
        sevenBtn = findViewById(R.id.seven_button);
        eightBtn = findViewById(R.id.eight_button);
        nineBtn = findViewById(R.id.nine_button);
        zeroBtn = findViewById(R.id.xero_button);
        hashBtn = findViewById(R.id.hash_button);
        starBtn = findViewById(R.id.star_button);
        backButton = findViewById(R.id.imageView);
        addNumber = findViewById(R.id.add_numberTv);

        oneBtn.setOnClickListener(v -> {
            eNumber.setText(eNumber.getText() + "1");
        });

        twoBtn.setOnClickListener(v -> {
            eNumber.setText(eNumber.getText() + "2");
        });

        threeBtn.setOnClickListener(v -> {
            eNumber.setText(eNumber.getText() + "3");
        });

        fourBtn.setOnClickListener(v -> {
            eNumber.setText(eNumber.getText() + "4");
        });

        fiveBtn.setOnClickListener(v -> {
            eNumber.setText(eNumber.getText() + "5");
        });

        sixBtn.setOnClickListener(v -> {
            eNumber.setText(eNumber.getText() + "6");
        });

        sevenBtn.setOnClickListener(v -> {
            eNumber.setText(eNumber.getText() + "7");
        });

        eightBtn.setOnClickListener(v -> {
            eNumber.setText(eNumber.getText() + "8");
        });

        nineBtn.setOnClickListener(v -> {
            eNumber.setText(eNumber.getText() + "9");
        });

        zeroBtn.setOnClickListener(v -> {
            eNumber.setText(eNumber.getText() + "0");
        });

        hashBtn.setOnClickListener(v -> {
            eNumber.setText(eNumber.getText() + "#");
        });

        starBtn.setOnClickListener(v -> {
            eNumber.setText(eNumber.getText() + "*");
        });

        backButton.setOnClickListener(v -> {
            if (eNumber.getText().length() > 0){
                CharSequence currentText = eNumber.getText();
                eNumber.setText(currentText.subSequence(0, currentText.length()-1 ));
            } else if (eNumber == null) {
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
            }
        });

        callButton.setOnClickListener(v -> {
            // getting phone number from edit text and changing it to String
            phone_number = eNumber.getText().toString();

            // Getting instance of Intent with action as ACTION_CALL
            Intent phone_intent = new Intent(Intent.ACTION_CALL);

            // Set data of Intent through Uri by parsing phone number
            phone_intent.setData(Uri.parse("tel:" + phone_number));

            // start Intent
            startActivity(phone_intent);

        });

        addNumber.setOnClickListener(v -> {

           Intent intent = new Intent(Keybord_Activity.this, CreateNewContactActivity.class);
           intent.putExtra("number", eNumber.getText().toString());
           startActivity(intent);

        });


    }
}