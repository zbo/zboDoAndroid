package com.example.twer.hellocalculator;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.TextView;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private Solo solo;

    public MainActivityTest(){
        super(MainActivity.class);
    }
    @Override
    public void setUp() throws Exception {
        super.setUp();
        solo=new Solo(getInstrumentation(),getActivity());
    }
    public void testDisplayWhiteBox(){
        float vFirstNumber=10;
        float vSecondNumber=20;
        float vResutl=vFirstNumber*vSecondNumber;
        //Access First value (edit-filed) and putting first Number value in it
        EditText vFirstEditText=(EditText)solo.getView(R.id.EditText01);
        solo.clearEditText(vFirstEditText);
        solo.enterText(vFirstEditText,String.valueOf(vFirstNumber));
        //Access Second value (edit-filed) and putting Second Number value in it
        EditText vSecondEditText=(EditText)solo.getView(R.id.EditText02);
        solo.clearEditText(vSecondEditText);
        solo.enterText(vSecondEditText,String.valueOf(vSecondNumber));
        //Click on Multiply button
        solo.clickOnButton("ok");
        assertTrue(solo.searchText(String.valueOf(vResutl)));
        TextView outputField=(TextView)solo.getView(R.id.TextView01);
        //Assert to verify result with visible value
        assertEquals(String.valueOf(vResutl),outputField.getText().toString());
    }
    @Override
    protected void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }
}