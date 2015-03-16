package com.example.twer.hellocalculator;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.robotium.solo.Solo;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TutorialActivityTest extends ActivityInstrumentationTestCase2<TutorialActivity> {
    private Solo solo;
    public TutorialActivityTest() {
        super(TutorialActivity.class);
    }
    @Override
    public void setUp() throws Exception {
        super.setUp();
        solo=new Solo(getInstrumentation(),getActivity());
    }
    public void testDisplayTutorialActivity(){
        Assert.assertTrue(solo.searchText("Hello world!"));
        Assert.assertTrue(solo.searchEditText("Enter Message"));
        Assert.assertTrue(solo.searchButton("Send"));
    }
    public void testSendMessageAction(){
        EditText editText=(EditText)solo.getView(R.id.tu_edit_message);
        solo.enterText(editText,String.valueOf("test message"));
        solo.clickOnButton("Send");

        assertTrue("Cannot find text with 'message is:test message'", solo.searchText("message is:test message"));
    }
}