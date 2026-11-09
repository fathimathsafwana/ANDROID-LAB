
package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Patterns;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText username = findViewById(R.id.username);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        EditText userpassword = findViewById(R.id.userpassword);

        Button loginbtn = findViewById(R.id.loginbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = username.getText().toString().trim();
                String mail = email.getText().toString().trim();
                String pass = password.getText().toString();
                String confirm = userpassword.getText().toString();

                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Enter username", Toast.LENGTH_SHORT).show();
                }
                else if (mail.isEmpty() ||
                        !Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
                    Toast.makeText(MainActivity.this,
                            "Enter valid email with @", Toast.LENGTH_SHORT).show();
                }
                else if (pass.length() < 6) {
                    Toast.makeText(MainActivity.this,
                            "Password must contain at least 6 characters",
                            Toast.LENGTH_SHORT).show();
                }
                else if (!pass.equals(confirm)) {
                    Toast.makeText(MainActivity.this,
                            "Password does not match", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this,
                            "Registration Successful. Welcome " + name,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
