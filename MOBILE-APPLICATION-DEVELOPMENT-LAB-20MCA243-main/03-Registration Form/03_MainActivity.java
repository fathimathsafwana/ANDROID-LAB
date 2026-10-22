package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView  username= (TextView)findViewById(R.id.username);
        TextView email = (TextView)findViewById(R.id.email);
        TextView password = (TextView)findViewById(R.id.password);
        TextView userpassword = (TextView)findViewById(R.id.userpassword);
        Button loginbtn = (Button)findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (password.getText().toString().equals("123456"))
                {
                    Toast.makeText(MainActivity.this, "username is "  + username.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

