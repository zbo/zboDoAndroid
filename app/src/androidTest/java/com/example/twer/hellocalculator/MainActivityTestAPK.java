package com.example.twer.hellocalculator;
import com.robotium.solo.Solo;
import android.test.ActivityInstrumentationTestCase2;
@SuppressWarnings("unchecked")
public class MainActivityTestAPK  extends ActivityInstrumentationTestCase2 {
    public MainActivityTestAPK(){
        super(launcherActivityClass);
    }
    private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.example.twer.hellocalculator.MainActivity";
    private static Class launcherActivityClass;
    static {
        try {
            launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Solo solo;
    @Override
    protected void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }
    public void testDisplayBlackBox() {
        // Enter any integer/decimal value for first edit-field, we are writing 10
        solo.clearEditText(0);
        solo.enterText(0, "10");
        // Enter any integer/decimal value for first edit-field, we are writing 20
        solo.clearEditText(1);
        solo.enterText(1, "20");
        // Tap on Multiply button
        solo.clickOnButton("ok");
        //Assert that the correct resultant of 10 x 20 is returned
        assertTrue("Problem asserting multiply", solo.searchText("200"));
    }
    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
}
