package com.example.uasandroid.activities;

import android.content.Intent;
import android.os.Bundle;
//import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uasandroid.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class LoginActivity extends AppCompatActivity {



    private EditText mEmailField;

    private EditText mPasswordField;

    private Button mloginBtn;



    private FirebaseAuth mAuth;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);



        //Membuat FullScreen

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



        mEmailField = (EditText) findViewById(R.id.email);

        mPasswordField = (EditText) findViewById(R.id.password);

        mloginBtn = (Button) findViewById(R.id.LoginBtn);



        mAuth = FirebaseAuth.getInstance();




        mloginBtn.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                startSignIn();

            }

        });

    }




    private void startSignIn() {

        String email = mEmailField.getText().toString();

        String password = mPasswordField.getText().toString();



        if (TextUtils.isEmpty(email) | TextUtils.isEmpty(password)) {

            Toast.makeText(LoginActivity.this, "Fields are Empty", Toast.LENGTH_SHORT).show();

        } else {



            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                 if (task.isSuccessful()){
                     Toast.makeText(LoginActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                     startActivity(new Intent(LoginActivity.this, MainActivity.class) );
                 }
                }
            });

        }

    }

}
