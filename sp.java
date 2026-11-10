package com.example.sharedpreferences;

import android.os.Bundle;
import android.widget.*;
import android.content.SharedPreferences;
import android.util.Patterns;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText usernameEt, mobileEt, emailEt, pass1Et, pass2Et;
    Button submitBtn, displayBtn;
    TextView result;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEt = findViewById(R.id.username);
        mobileEt = findViewById(R.id.mobile);
        emailEt = findViewById(R.id.Email);
        pass1Et = findViewById(R.id.password);
        pass2Et = findViewById(R.id.repass);

        submitBtn = findViewById(R.id.submit);
        displayBtn = findViewById(R.id.display);
        result = findViewById(R.id.result);

        sharedPreferences = getSharedPreferences(
                "UserDetails", MODE_PRIVATE);

        editor = sharedPreferences.edit();

        // Register Button
        submitBtn.setOnClickListener(v -> {

            String username = usernameEt.getText().toString();
            String mobile = mobileEt.getText().toString();
            String email = emailEt.getText().toString();
            String pass1 = pass1Et.getText().toString();
            String pass2 = pass2Et.getText().toString();

            if (username.isEmpty()) {
                usernameEt.setError("Enter Username");
            }
            else if (mobile.isEmpty()) {
                mobileEt.setError("Enter Mobile Number");
            }
            else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailEt.setError("Enter Valid Email");
            }
            else if (pass1.length() < 6) {
                pass1Et.setError("Password must contain 6 characters");
            }
            else if (!pass1.equals(pass2)) {
                pass2Et.setError("Password does not match");
            }
            else {

                editor.putString("keyusername", username);
                editor.putString("keymobile", mobile);
                editor.putString("keymail", email);
                editor.putString("keypassword", pass1);

                editor.apply();

                Toast.makeText(MainActivity.this,
                        "Registration Successful",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Display Button
        displayBtn.setOnClickListener(v -> {

            String username = sharedPreferences.getString(
                    "keyusername", "");

            String mobile = sharedPreferences.getString(
                    "keymobile", "");

            String email = sharedPreferences.getString(
                    "keymail", "");

            result.setText(
                    "Username: " + username +
                            "\nMobile: " + mobile +
                            "\nEmail: " + email
            );
        });
    }
}
