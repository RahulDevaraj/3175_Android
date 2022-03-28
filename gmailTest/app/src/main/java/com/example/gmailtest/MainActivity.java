package com.example.gmailtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import javax.mail.MessagingException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.buttonSendMail);

        button.setOnClickListener((View view)-> {

            try {
                sendMail();
            } catch (MessagingException e) {
                e.printStackTrace();
            }

        });

    }

    private void sendMail() throws MessagingException {

        String senderAddress = "kannan.vegeta@gmail.com";
        String subject = "Test Subject";
        String message = "Test message";


        MailHelper mailHelper = new MailHelper(this, senderAddress, subject, message);

        mailHelper.execute();
    }
}