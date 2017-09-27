package com.example.diego.sorts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button bt1,bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=(Button)findViewById(R.id.bt1);
        bt2=(Button)findViewById(R.id.bt2);
    }
    public void manual(View view)
    {
        Intent i=new Intent(this,ManualActivity.class);
        startActivity(i);
        finish();
    }
    public void random(View view)
    {
        Intent i=new Intent(this,RandomActivity.class);
        startActivity(i);
        finish();
    }
}
