package com.example.shubham.tictactoe2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button start;
    static String player1_name;
    static String player2_name;
    private EditText t1;
    private EditText t2;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    static String choice = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=(Button)findViewById(R.id.start);
        t1=(EditText)findViewById(R.id.editText_player1);
        t2=(EditText)findViewById(R.id.editText_player2);





        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!t1.getText().toString().trim().equals("") && !t2.getText().toString().trim().equals("")) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                    player1_name=t1.getText().toString();
                    player2_name=t2.getText().toString();
                }
                else {
                    Toast.makeText(getBaseContext(), "Invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void onClickRadioButton(View view)
    {
        radioGroup=findViewById(R.id.radioGroup);
        int selectId =radioGroup.getCheckedRadioButtonId();
        radioButton=findViewById(selectId);
        if(radioButton.getText()=="SinglePlayer")
        {
            choice="S";
        }
        if(radioButton.getText()=="TwoPlayer")
        {
            choice="D";
        }
    }
}
