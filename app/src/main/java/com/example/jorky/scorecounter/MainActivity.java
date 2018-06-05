package com.example.jorky.scorecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.button;
import static android.R.attr.x;

public class MainActivity extends AppCompatActivity {

    int scoreA = 0;
    int scoreB = 0;

    Button btnTouchdownA;
    Button btnXtraTouchdownA;
    Button btnXtraPointA;
    Button btnFieldGoalA;
    Button btnSafetyA;
    Button btnTouchdownB;
    Button btnXtraTouchdownB;
    Button btnXtraPointB;
    Button btnFieldGoalB;
    Button btnSafetyB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void hideXtrasIfVisible() {
        if (btnXtraTouchdownA.getVisibility() == View.VISIBLE) {
            btnXtraTouchdownA.setVisibility(View.GONE);
            btnXtraPointA.setVisibility(View.GONE);
        }

        if (btnXtraTouchdownB.getVisibility() == View.VISIBLE) {
            btnXtraTouchdownB.setVisibility(View.GONE);
            btnXtraPointB.setVisibility(View.GONE);
        }
    }

    private void initView() {
        btnTouchdownA = (Button) findViewById(R.id.touchdown_a);
        btnXtraTouchdownA = (Button) findViewById(R.id.xtra_touch_a);
        btnXtraPointA = (Button) findViewById(R.id.xtra_point_a);
        btnFieldGoalA = (Button) findViewById(R.id.field_goal_a);
        btnSafetyA = (Button) findViewById(R.id.safety_a);
        btnTouchdownB = (Button) findViewById(R.id.touchdown_b);
        btnXtraTouchdownB = (Button) findViewById(R.id.xtra_touch_b);
        btnXtraPointB = (Button) findViewById(R.id.xtra_point_b);
        btnFieldGoalB = (Button) findViewById(R.id.field_goal_b);
        btnSafetyB = (Button) findViewById(R.id.safety_b);
    }

    public void touchdownA (View view) {
        scoreA += 6;
        displayScoreTeamA(scoreA);
        hideXtrasIfVisible();
        btnTouchdownA.setEnabled(false);
        btnSafetyA.setEnabled(false);
        btnXtraTouchdownA.setVisibility(View.VISIBLE);
        btnXtraPointA.setVisibility(View.VISIBLE);
        btnSafetyB.setEnabled(true);
    }

    public void touchdownB (View view) {
        scoreB += 6;
        displayScoreTeamB(scoreB);
        hideXtrasIfVisible();
        btnTouchdownB.setEnabled(false);
        btnSafetyB.setEnabled(false);
        btnXtraTouchdownB.setVisibility(View.VISIBLE);
        btnXtraPointB.setVisibility(View.VISIBLE);
        btnSafetyA.setEnabled(true);
    }

    public void fieldGoalA (View view) {
        if (btnTouchdownA.isEnabled()) {
            scoreA += 3;
        } else {
            scoreA += 1;
        }
        hideXtrasIfVisible();
        displayScoreTeamA(scoreA);
        btnTouchdownA.setEnabled(true);
        btnSafetyA.setEnabled(true);
        btnTouchdownB.setEnabled(true);
        btnSafetyB.setEnabled(true);
    }

    public void fieldGoalB (View view) {
        if (btnTouchdownB.isEnabled()) {
            scoreB += 3;
        } else {
            scoreB += 1;
        }
        hideXtrasIfVisible();
        displayScoreTeamB(scoreB);
        btnTouchdownA.setEnabled(true);
        btnSafetyA.setEnabled(true);
        btnTouchdownB.setEnabled(true);
        btnSafetyB.setEnabled(true);
    }

    public void safetyA (View view) {
        scoreA += 2;
        displayScoreTeamA(scoreA);
        hideXtrasIfVisible();
        btnTouchdownA.setEnabled(true);
        btnSafetyA.setEnabled(false);
        btnTouchdownB.setEnabled(true);
        btnSafetyB.setEnabled(true);
    }

    public void safetyB (View view) {
        scoreB += 2;
        displayScoreTeamB(scoreB);
        hideXtrasIfVisible();
        btnTouchdownA.setEnabled(true);
        btnSafetyA.setEnabled(true);
        btnTouchdownB.setEnabled(true);
        btnSafetyB.setEnabled(false);
    }

    public void xtraTouchdownA (View view) {
        scoreA += 2;
        displayScoreTeamA(scoreA);
        hideXtrasIfVisible();
        btnTouchdownA.setEnabled(true);
        btnSafetyA.setEnabled(true);
    }

    public void xtraTouchdownB (View view) {
        scoreB += 2;
        displayScoreTeamB(scoreB);
        hideXtrasIfVisible();
        btnTouchdownB.setEnabled(true);
        btnSafetyB.setEnabled(true);
    }

    public void xtraPointA (View view) {
        scoreA += 1;
        displayScoreTeamA(scoreA);
        hideXtrasIfVisible();
        btnTouchdownA.setEnabled(true);
        btnSafetyA.setEnabled(true);
    }

    public void xtraPointB (View view) {
        scoreB += 1;
        displayScoreTeamB(scoreB);
        hideXtrasIfVisible();
        btnTouchdownB.setEnabled(true);
        btnSafetyB.setEnabled(true);
    }

    public void reset (View view) {
        scoreA = 0;
        scoreB = 0;
        displayScoreTeamA(scoreA);
        displayScoreTeamB(scoreB);
        hideXtrasIfVisible();
        btnTouchdownA.setEnabled(true);
        btnFieldGoalA.setEnabled(true);
        btnSafetyA.setEnabled(true);
        btnTouchdownB.setEnabled(true);
        btnFieldGoalB.setEnabled(true);
        btnSafetyB.setEnabled(true);

    }

    public void displayScoreTeamA (int score) {
        TextView scoreTextA = (TextView) findViewById(R.id.count_a);
        scoreTextA.setText(String.valueOf(score));
    }

    public void displayScoreTeamB (int score) {
        TextView scoreTextB = (TextView) findViewById(R.id.count_b);
        scoreTextB.setText(String.valueOf(score));
    }
}
