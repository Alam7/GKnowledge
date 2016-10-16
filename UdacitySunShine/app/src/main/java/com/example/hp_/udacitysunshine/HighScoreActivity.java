package com.example.hp_.udacitysunshine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class HighScoreActivity extends AppCompatActivity {

    ListView listOfScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        listOfScore = (ListView) findViewById(R.id.list_high_score);
        DBScore dbScore = new DBScore(this);
        List<ScoreBoard> scoreBoardList = dbScore.getAllScore();

        CustomAdapter adapter = new CustomAdapter(this,R.layout.row,scoreBoardList);
        adapter.add(scoreBoardList);
        listOfScore.setAdapter(adapter);

    }
}
