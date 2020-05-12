package com.example.shubham.tictactoe2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    private Button[] aa=new Button[10];
    static int sss=0;
    private TextView textViewPlayer1;
    private TextView textViewPlayer2;

    private boolean player1Turn=true;
    static int player1Points;
    static int player2Points;
    private int roundCount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        textViewPlayer1=findViewById(R.id.text_view_p1);
        textViewPlayer2=findViewById(R.id.text_view_p2);
        textViewPlayer1.setText(MainActivity.player1_name+" : "+player1Points);
        textViewPlayer2.setText(MainActivity.player2_name+" : "+player2Points);

        for (int i=1;i<10;i++)
        {
            String buttonId = "button_"+i;
            int resId = getResources().getIdentifier(buttonId,"id",getPackageName());
            aa[i]=findViewById(resId);
            aa[i].setOnClickListener(this);
        }

        Button reset=findViewById(R.id.button_reset);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(!((Button)v).getText().toString().equals("")){
            return;
        }

        if (player1Turn)
        {
            ((Button)v).setText("x");
        }

        roundCount++;

        if(checkForWin())
        {
            if (player1Turn)
            {
                player1Wins();
            }
            else
            {
                player2Wins();
            }
        }
        else if(roundCount == 9)
        {
            draw();
        }
        else
        {
            int i = (int)(Math.random()*9) % 9;
            String buttonId = "button_"+i;
            aa[i].setText("o");
        }
    }
    private boolean checkForWin() {
        String[] a = new String[10];
        for (int i=1;i<10;i++)
        {
            a[i]=aa[i].getText().toString();
        }

        if((a[1].equals(a[2]) && a[2].equals(a[3]) && !a[1].equals("")) || (a[4].equals(a[5]) && a[5].equals(a[6]) && !a[4].equals("")) || (a[7].equals(a[8]) && a[8].equals(a[9]) && !a[7].equals("")))
            return true;

        if((a[1].equals(a[4]) && a[4].equals(a[7]) && !a[1].equals("")) || (a[2].equals(a[5]) && a[5].equals(a[8]) && !a[2].equals("")) || (a[3].equals(a[6]) && a[6].equals(a[9]) && !a[3].equals("")))
            return true;

        if((a[1].equals(a[5]) && a[5].equals(a[9]) && !a[1].equals("")) )
            return true;

        if((a[3].equals(a[5]) && a[5].equals(a[7]) && !a[3].equals("")) )
            return true;

        return false;

    }

    private void draw() {
        Toast.makeText(this,"Draw!",Toast.LENGTH_SHORT).show();
        resetBoard();
        sss=3;
        Intent intent = new Intent(SecondActivity.this, FinalActivity.class);
        startActivity(intent);
    }

    private void player1Wins() {
        player1Points++;
        Toast.makeText(this,"Player 1 Wins ! ",Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
        sss=1;
        Intent intent = new Intent(SecondActivity.this, FinalActivity.class);
        startActivity(intent);
    }
    private void player2Wins() {
        player2Points++;
        Toast.makeText(this,"Player 2 Wins ! ",Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
        sss=2;
        Intent intent = new Intent(SecondActivity.this, FinalActivity.class);
        startActivity(intent);
    }

    private void updatePointsText() {
        textViewPlayer1.setText(MainActivity.player1_name+" : "+player1Points);
        textViewPlayer2.setText(MainActivity.player2_name+" : "+player2Points);
    }

    private void resetGame()
    {
        player1Points=0;
        player2Points=0;
        updatePointsText();
        resetBoard();
    }

    private void resetBoard() {
        for (int i=1;i<10;i++)
        {
            aa[i].setText("");
        }

        roundCount=0;
        player1Turn=true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("roundCount",roundCount);
        outState.putInt("player1Points",player1Points);
        outState.putInt("player2Points",player2Points);
        outState.putBoolean("player1Turn",player1Turn);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        roundCount = savedInstanceState.getInt("roundCount");
        player1Points=savedInstanceState.getInt("player1Points");
        player2Points=savedInstanceState.getInt("player2Points");
        player1Turn=savedInstanceState.getBoolean("player1Turn");
    }
}
