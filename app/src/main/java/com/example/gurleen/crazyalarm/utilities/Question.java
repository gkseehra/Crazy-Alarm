package com.example.gurleen.crazyalarm.utilities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gurleen.crazyalarm.MainActivity;
import com.example.gurleen.crazyalarm.R;

import java.util.Random;

public class Question extends AppCompatActivity {

    int rn[];
    TextView textView;
    EditText editText;
    Button button;
    String Ans;
    private static final int ALARM_NOTIFICATION_ID =101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        textView = (TextView)findViewById(R.id.questionTV);
        editText = (EditText)findViewById(R.id.answerET);
        button = (Button)findViewById(R.id.submitAnswerB);
        rn = new int[6];
        for(int i=0; i<6; i++) {
            rn[i] = new Random().nextInt(50) + 35;
        }
        int m = new Random().nextInt(4) + 1;
        String ques = "("+String.valueOf(rn[0])+"+"+String.valueOf(rn[1])+"-"+String.valueOf(rn[2])+"+"+String.valueOf(rn[3])
                +"+"+String.valueOf(rn[4])+"+"+String.valueOf(rn[5])+" )% "+String.valueOf(m)+" = ?";
        textView.setText(ques);
        int ans = (rn[0]+rn[1]-rn[2]+rn[3]+rn[4]+rn[5])%m;
        Ans = String.valueOf(ans);
    }

    public void submitAnswer(View view) {
        if(editText.getText().toString().equals(Ans)){
            NotificationUtils.nManager.cancel(ALARM_NOTIFICATION_ID);
            Toast.makeText(this, "CORRECT ANSWER", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        else{
            Toast.makeText(this, "WRONG ANSWER! TRY AGAIN!", Toast.LENGTH_LONG).show();
            editText.setText("");
        }
    }
}
