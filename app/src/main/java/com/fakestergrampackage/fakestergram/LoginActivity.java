package com.fakestergrampackage.fakestergram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText et_Email, et_Password;
    private Button btn_Login, btn_Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        btn_Login = findViewById(R.id.btn_Login);
        btn_Register = findViewById(R.id.btn_Register);

        btn_Login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                signIn();
            }
        });

        btn_Register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }


    public void signIn() {

        et_Email = findViewById(R.id.et_Email);
        et_Password = findViewById(R.id.et_Password);

        mAuth.signInWithEmailAndPassword(et_Email.getText().toString(), et_Password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Login Status ", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            /*//updateUI(user);*/
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Login Status ", "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            /*//updateUI(null);*/
                        }
                    }
                });
    }

    public void updateUI(FirebaseUser user){

        /*//if the login details are valid
        if(user != null) {
            Log.i("Login Status ", mAuth.getCurrentUser().getEmail());
            Intent i = new Intent(this, TabActivity.class);
            startActivity(i);
        }*/
    }

}