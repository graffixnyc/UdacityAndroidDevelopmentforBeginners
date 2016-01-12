package com.graffixnyc.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView scoreViewA;
    TextView scoreViewB;
    int scoreTeamA=0;
    int scoreTeamB=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreViewA = (TextView) findViewById(R.id.team_a_score);
        scoreViewB = (TextView) findViewById(R.id.team_b_score);
        final Button btnAThree=(Button) findViewById(R.id.btnA3);
        final Button btnATwo=(Button) findViewById(R.id.btnA2);
        final Button btnAOne=(Button) findViewById(R.id.btnA1);
        final Button btnBThree=(Button) findViewById(R.id.btnB3);
        final Button btnBTwo=(Button) findViewById(R.id.btnB2);
        final Button btnBOne=(Button) findViewById(R.id.btnB1);
        final Button btnReset=(Button) findViewById(R.id.btnReset);
        scoreTeamA = Integer.parseInt(scoreViewA.getText().toString());
        scoreTeamB = Integer.parseInt(scoreViewB.getText().toString());
        btnAThree.setOnClickListener(new ScoreButtonListener());
        btnATwo.setOnClickListener(new ScoreButtonListener());
        btnAOne.setOnClickListener(new ScoreButtonListener());
        btnBThree.setOnClickListener(new ScoreButtonListener());
        btnBTwo.setOnClickListener(new ScoreButtonListener());
        btnBOne.setOnClickListener(new ScoreButtonListener());
        btnReset.setOnClickListener(new ScoreButtonListener());
    }
    public void displayScore(int scoreA,int scoreB) {
        scoreViewA.setText(String.valueOf(scoreA));
        scoreViewB.setText(String.valueOf(scoreB));
    }
    class ScoreButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnA1:
                    scoreTeamA+=1;
                    break;
                case R.id.btnA2:
                    scoreTeamA+=2;
                    break;
                case R.id.btnA3:
                    scoreTeamA+=3;
                    break;
                case R.id.btnB1:
                    scoreTeamB+=1;
                    break;
                case R.id.btnB2:
                    scoreTeamB+=2;
                    break;
                case R.id.btnB3:
                    scoreTeamB+=3;
                    break;
                case R.id.btnReset:
                    scoreTeamA=0;
                    scoreTeamB=0;
            }
            displayScore(scoreTeamA,scoreTeamB);
        }
    }
}
