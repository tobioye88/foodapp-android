package com.tobioyelami.foodstack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btnLogin);
        EditText username = findViewById(R.id.editTextUsername);
        EditText password = findViewById(R.id.editTextPassword);

        TextView createAnAccount = findViewById(R.id.textViewCreateAnAccount);
        TextView forgotPassword = findViewById(R.id.textViewForgotPassword);

        forgotPassword.setOnClickListener((view) -> {
            //Todo go to forgot passsword activity
            Toast.makeText(getBaseContext(), "Forgot password activity", Toast.LENGTH_SHORT).show();
        });

        createAnAccount.setOnClickListener((view) ->{
            //Todo go to register activity
            Toast.makeText(getBaseContext(), "Register activity", Toast.LENGTH_SHORT).show();
        });

        button.setOnClickListener((view)-> {
            String usernameString = username.getText().toString();
            String passwordString = password.getText().toString();

            if(usernameString.isEmpty() || passwordString.isEmpty()){
                Toast.makeText(getBaseContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                return;
            }

            if(validate(usernameString, passwordString)) {
                homeActivity(view);
            }
        });
    }

    private boolean validate(String usernameString, String passwordString) {
        //network call to validate username
        Log.i("MainActivity",usernameString + " " +passwordString);
        return true;
    }


    private void homeActivity(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
