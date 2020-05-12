package com.example.shubham.tictactoe2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        TextView t=findViewById(R.id.textView_c);
        Button b = findViewById(R.id.button);

        if(SecondActivity.sss==1)
            t.setText("Congratulations "+MainActivity.player1_name);
        else if(SecondActivity.sss==2)
            t.setText("Congratulations "+MainActivity.player2_name);
        else if(SecondActivity.sss==3)
            t.setText("Draw!!!");

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinalActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
