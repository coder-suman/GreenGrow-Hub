package com.example.krishiculture.userlogin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.krishiculture.MainActivity;
import com.example.krishiculture.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class loginActivity extends AppCompatActivity {
    Button signIn;
    EditText email, password;
    TextView signUp;


    //Database connection
    FirebaseAuth auth;

    //ProgressBar
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();

        //Progress bar id fetching
        progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);

        // Initialize UI components
        signIn = findViewById(R.id.login_btn);
        email = findViewById(R.id.email_login);
        password = findViewById(R.id.password_login);
        signUp = findViewById(R.id.sign_up);

        // Handle sign-up click
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to RegistrationActivity
                Intent intent = new Intent(loginActivity.this, registrationActivity.class);
                startActivity(intent);
            }
        });


        signIn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginUser();
                progressBar.setVisibility(View.VISIBLE);
            }
        }));

        //
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    private void loginUser() {


        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();


        if (TextUtils.isEmpty(userEmail)){
            Toast.makeText(this, "Email is Empty!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(userPassword)){
            Toast.makeText(this, "Password is Empty!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (userPassword.length() < 6){
            Toast.makeText(this, "Password Length Must be greater then 6 letter", Toast.LENGTH_SHORT).show();
            return;
        }

        //login User
        auth.signInWithEmailAndPassword(userEmail,userPassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            progressBar.setVisibility(View.GONE);

                            Toast.makeText(loginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            //connect the main page
                            startActivity(new Intent(loginActivity.this, MainActivity.class));

                        }else{
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(loginActivity.this, "Error:"+task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


}