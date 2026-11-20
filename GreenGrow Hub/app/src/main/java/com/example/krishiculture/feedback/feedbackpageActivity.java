package com.example.krishiculture.feedback;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.krishiculture.R;

public class feedbackpageActivity extends AppCompatActivity {

    EditText etName, etEmail, etMessage;
    Button btnSend;
    String adminEmail = "manishgiri8101@gmail.com"; // Replace with your admin email

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedbackpage);

        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etMessage = findViewById(R.id.et_message);
        btnSend = findViewById(R.id.btn_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendFeedback();
            }
        });
    }

    private void sendFeedback() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String message = etMessage.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty() || message.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        String subject = "Feedback from " + name;
        String body = "Name: " + name + "\nEmail: " + email + "\nMessage:\n" + message;

        JavaMailAPI javaMailAPI = new JavaMailAPI(adminEmail, subject, body);
        javaMailAPI.execute(); // Runs in the background


        Toast.makeText(this, "Feedback Sent!", Toast.LENGTH_SHORT).show();
    }
}