package com.example.twer.hellocalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    EditText vFirstValue;
    EditText vSecondValue;
    TextView vResult;
    Button vCalculate;
    float vNum1,vNum2,vOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vFirstValue=(EditText)findViewById(R.id.EditText01);
        vFirstValue.setText("0");
        vFirstValue.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                vFirstValue.setText("");
                return false;
            }
        });
        vSecondValue=(EditText)findViewById(R.id.EditText02);
        vSecondValue.setText("0");
        vSecondValue.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                vSecondValue.setText("0");
                return false;
            }
        });
        vResult=(TextView)findViewById(R.id.TextView01);
        vResult.setText("0.00");
        vCalculate=(Button)findViewById(R.id.Button01);
        vCalculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showResult(vFirstValue.getText().toString(),vSecondValue.getText().toString());
            }
        });
    }

    private void showResult(String s1, String s2) {
        vNum1=Float.parseFloat(s1);
        vNum2=Float.parseFloat(s2);
        vOutput=vNum1*vNum2;
        vResult.setText(String.valueOf(vOutput));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendMessage(View view){
        Intent intent=new Intent(this,SendMessageActivity.class);
        startActivity(intent);
    }
}
