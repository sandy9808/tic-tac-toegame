package com.sandeep.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive =true;
    //player representation
    //0-X
    //1-O
    int activePlayer=0;

    int [] gameState={ 2, 2, 2, 2, 2, 2, 2, 2, 2};
    // State meanings
    //0-X
    //1-O
    //2-Blank
    int [][] winPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void tapit(View view)
    {
        ImageView img = (ImageView) view;
        int tappedimage = Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            gameReset(view);
        }
        if(gameState[tappedimage]==2){
            gameState[tappedimage]=activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer==0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn - Tap to Play");
            }
            else{
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn - Tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for(int i=0;i<8;i++)
        {
            if(gameState[winPositions[i][0]]==gameState[winPositions[i][1]]&&gameState[winPositions[i][1]]==gameState[winPositions[i][2]]&&gameState[winPositions[i][0]]!=2) {
                //somebody has won but who......
                String winnerstr;
                gameActive=false;
                if (gameState[winPositions[i][0]] == 0) {
                    winnerstr="X has won";
                }
                else{
                    winnerstr="O has won";
                }
                //Update status by teling the winner name
                TextView status = findViewById(R.id.status);
                status.setText(winnerstr);
            }
        }

    }
    public void gameReset(View view){
              gameActive=true;
              for(int i=0;i<gameState.length;i++)
              {
                  gameState[i]=2;
              }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
//0,1,2
//3,4,5
//6,7,8