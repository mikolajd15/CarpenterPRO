package com.example.android101;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.hasTextColor;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;

import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;


public class InstrumentedTest_RoofsView {
    // Function for waiting <delay> milliseconds during test steps
    public static ViewAction waitFor(long delay) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return ViewMatchers.isRoot();
            }

            @Override
            public String getDescription() {
                return "wait for " + delay + "milliseconds";
            }

            @Override
            public void perform(UiController uiController, View view) {
                uiController.loopMainThreadForAtLeast(delay);
            }
        };
    }

    private View decorView;

    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void countingValuesFor_Roof1_isCorrect() {
        Intents.init();
        // Go to roof 1
        onView(withId(R.id.button_roof_1)).perform(click());
        // Check that correct activity InputRoof1Activity is displayed
        intended(hasExtra("ROOF_TYPE", 1));
        intended(hasComponent(UserInputsActivity.class.getName()));
        // Pass reference values:
        onView(withHint("D??ugo???? bud.: A")).perform(typeText("500"), closeSoftKeyboard());
        onView(withHint("Szeroko???? bud.: B")).perform(typeText("1"), closeSoftKeyboard());
        onView(withHint("Okap tylni: D")).perform(typeText("80"), closeSoftKeyboard());
        onView(withHint("Zacios pionowy krokwi")).perform(typeText("5"), closeSoftKeyboard());
        onView(withHint("K??t dachu: ??")).perform(typeText("30"), closeSoftKeyboard());
        onView(withHint("Odleg??o???? C")).perform(typeText("250"), closeSoftKeyboard());
        onView(withHint("Szeroko???? mur??aty")).perform(typeText("20"), closeSoftKeyboard());
        onView(withHint("Grubo???? p??atwi kalenicowej")).perform(typeText("16"), closeSoftKeyboard());
        onView(withHint("Okap przedni E")).perform(typeText("20"), closeSoftKeyboard());
        onView(withHint("Grubo???? krokwi")).perform(ViewActions.scrollTo(), typeText("1"), closeSoftKeyboard());
        onView(withHint("Szeroko???? krokwi")).perform(typeText("16"), closeSoftKeyboard());
        onView(withHint("Pole krokwi: Pk1")).perform(typeText("1"), closeSoftKeyboard());
        onView(withHint("Max. pole krokwi")).perform(typeText("1"), closeSoftKeyboard());
        Intents.release();

        Intents.init();
        // Check that button is enabled now and click it
        onView(withId(R.id.button_roof1_count)).check(matches(isEnabled())).perform(click());
        // // Check that correct activity ResultRoof1Activity is displayed
        intended(hasExtra("ROOF_TYPE", 1));
        intended(hasComponent(ResultsActivity.class.getName()));
        // Verify results
//        onView(withText("?? = 60.00")).check(matches(isDisplayed()));
//        onView(withText("Lc = 702.06")).check(matches(isDisplayed()));
//        onView(withText("Lp = 692.82")).check(matches(isDisplayed()));
//        onView(withText("M2 = 600.44")).check(matches(isDisplayed()));
//        onView(withText("N2 = 311.77")).check(matches(isDisplayed()));
//        onView(withText("K1 = 31.57")).check(matches(isDisplayed()));
//        onView(withText("H1 = 299.44")).check(matches(isDisplayed()));
        Intents.release();
    }

    @Test
    public void countingValuesFor_Roof2_isCorrect() {
        Intents.init();
        // Go to roof 1
        onView(withId(R.id.button_roof_2)).perform(click());
        // Check that correct activity InputRoof1Activity is displayed
        intended(hasExtra("ROOF_TYPE", 2));
        intended(hasComponent(UserInputsActivity.class.getName()));
        // Pass reference values:
        onView(withHint("D??ugo???? bud.: A")).perform(typeText("984"), closeSoftKeyboard());
        onView(withHint("Szeroko???? bud.: B")).perform(typeText("1"), closeSoftKeyboard());
        onView(withHint("Okap: D")).perform(typeText("80"), closeSoftKeyboard());
        onView(withHint("Zacios pionowy krokwi")).perform(typeText("5"), closeSoftKeyboard());
        onView(withHint("K??t dachu: ??")).perform(typeText("30"), closeSoftKeyboard());
        onView(withHint("Odleg??o???? C")).perform(typeText("250"), closeSoftKeyboard());
        onView(withHint("Szeroko???? mur??aty")).perform(typeText("20"), closeSoftKeyboard());
        onView(withHint("Grubo???? p??atwi kalenicowej")).perform(typeText("16"), closeSoftKeyboard());
        onView(withHint("Grubo???? krokwi")).perform(ViewActions.scrollTo(), typeText("1"), closeSoftKeyboard());
        onView(withHint("Szeroko???? krokwi")).perform(typeText("16"), closeSoftKeyboard());
        onView(withHint("Pole krokwi: Pk1")).perform(typeText("1"), closeSoftKeyboard());
        onView(withHint("Max. pole krokwi")).perform(typeText("1"), closeSoftKeyboard());
        Intents.release();

        Intents.init();
        // Check that button is enabled now and click it
        onView(withId(R.id.button_roof1_count)).check(matches(isEnabled())).perform(click());
        // // Check that correct activity ResultRoof1Activity is displayed
        intended(hasExtra("ROOF_TYPE", 2));
        intended(hasComponent(ResultsActivity.class.getName()));
        // Verify results
//        onView(withText("?? = 60.00")).check(matches(isDisplayed()));
//        onView(withText("Lc = 669.73")).check(matches(isDisplayed()));
//        onView(withText("Lp = 660.49")).check(matches(isDisplayed()));
//        onView(withText("M2 = 568.11")).check(matches(isDisplayed()));
//        onView(withText("N2 = 279.44")).check(matches(isDisplayed()));
//        onView(withText("K2 = 9.24")).check(matches(isDisplayed()));
//        onView(withText("H1 = 299.44")).check(matches(isDisplayed()));
        Intents.release();
    }

    @Test
    public void countingValuesFor_Roof3_isCorrect() {
        Intents.init();
        // Go to roof 1
        onView(withId(R.id.button_roof_3)).perform(click());
        // Check that correct activity InputRoof1Activity is displayed
        intended(hasExtra("ROOF_TYPE", 3));
        intended(hasComponent(UserInputsActivity.class.getName()));
        // Pass reference values:
        onView(withHint("D??ugo???? cz????ci A")).perform(typeText("300"), closeSoftKeyboard());
        onView(withHint("D??ugo???? cz????ci B")).perform(typeText("200"), closeSoftKeyboard());
        onView(withHint("Pierwszy okap: D")).perform(typeText("40"), closeSoftKeyboard());
        onView(withHint("Zacios pionowy krokwi")).perform(typeText("3"), closeSoftKeyboard());
        onView(withHint("K??t po??aci A: ??")).perform(typeText("30"), closeSoftKeyboard());
        onView(withHint("K??t po??aci B: ??")).perform(typeText("45"), closeSoftKeyboard());
        onView(withHint("Szeroko???? mur??aty")).perform(typeText("12"), closeSoftKeyboard());
        onView(withHint("Grubo???? p??atwi kalenicowej")).perform(typeText("8"), closeSoftKeyboard());
        onView(withHint("Drugi okap: E")).perform(ViewActions.scrollTo(), typeText("30"), closeSoftKeyboard());
        onView(withHint("Grubo???? mur??aty")).perform(typeText("8"), closeSoftKeyboard());
        onView(withHint("Grubo???? krokwi")).perform(ViewActions.scrollTo(), typeText("4"), closeSoftKeyboard());
        onView(withHint("Szeroko???? krokwi")).perform(typeText("8"), closeSoftKeyboard());
        onView(withHint("Odleg??o???? A1")).perform(typeText("150"), closeSoftKeyboard());
        onView(withHint("Odleg??o???? B1")).perform(typeText("100"), closeSoftKeyboard());
        Intents.release();

        Intents.init();
        // Check that button is enabled now and click it
        onView(withId(R.id.button_roof1_count)).check(matches(isEnabled())).perform(click());
        // // Check that correct activity ResultRoof1Activity is displayed
        intended(hasExtra("ROOF_TYPE", 3));
        intended(hasComponent(ResultsActivity.class.getName()));
//        // Verify results
//        onView(withText("LAc = 397.22")).check(matches(isDisplayed()));
//        onView(withText("LBp = 325.27")).check(matches(isDisplayed()));
//        onView(withText("SA = 1.31")).check(matches(isDisplayed()));
//        onView(withText("HK = 209.32")).check(matches(isDisplayed()));
//        onView(withText("HB1 = 112.00")).check(matches(isDisplayed()));
//        onView(withText("NB2 = 143.28")).check(matches(isDisplayed()));
//        onView(withText("NA1 = 165.69")).check(matches(isDisplayed()));
//        onView(withText("MA1 = 338.89")).check(matches(isDisplayed()));
//        onView(withText("PP = 1.32")).check(matches(isDisplayed()));
        Intents.release();
    }

    @Test
    public void toastsFor_Roof1_areCorrect() throws InterruptedException {
        // Initialize decor view needed for checking toasts
        mainActivityRule.getScenario().onActivity(activity -> {
            decorView = activity.getWindow().getDecorView();
        });

        Intents.init();
        // Go to roof 1
        onView(withId(R.id.button_roof_1)).perform(click());
        // Check that correct activity is displayed
        intended(hasExtra("ROOF_TYPE", 1));
        intended(hasComponent(UserInputsActivity.class.getName()));
        // Fill input parameters
        onView(withHint("D??ugo???? bud.: A")).perform(typeText("500"), closeSoftKeyboard());
        onView(withHint("Szeroko???? bud.: B")).perform(typeText("1"), closeSoftKeyboard());
        onView(withHint("Okap tylni: D")).perform(typeText("80"), closeSoftKeyboard());
        onView(withHint("Zacios pionowy krokwi")).perform(typeText("5"), closeSoftKeyboard());
        onView(withHint("K??t dachu: ??")).perform(typeText("0"), closeSoftKeyboard());
        onView(withHint("Odleg??o???? C")).perform(typeText("250"), closeSoftKeyboard());
        onView(withHint("Szeroko???? mur??aty")).perform(typeText("20"), closeSoftKeyboard());
        onView(withHint("Grubo???? p??atwi kalenicowej")).perform(typeText("16"), closeSoftKeyboard());
        onView(withHint("Okap przedni E")).perform(typeText("20"), closeSoftKeyboard());
        onView(withHint("Grubo???? krokwi")).perform(ViewActions.scrollTo(), typeText("1"), closeSoftKeyboard());
        onView(withHint("Szeroko???? krokwi")).perform(typeText("16"), closeSoftKeyboard());
        onView(withHint("Pole krokwi: Pk1")).perform(typeText("1"), closeSoftKeyboard());
        onView(withHint("Max. pole krokwi")).perform(typeText("1"), closeSoftKeyboard());
        onView(withId(R.id.button_roof1_count)).check(matches(isEnabled())).perform(click());
        // Verify that toast is correct for value 0
        onView(withHint("K??t dachu: ??")).check(matches(hasTextColor(R.color.red)));

        onView(withText("Niepoprawna warto???? dla theta: 0.0")).inRoot(withDecorView(not(decorView))).check(matches(isDisplayed()));
        // Clear theta, wait for 4 seconds and type value greater than 90
        onView(withHint("K??t dachu: ??")).perform(clearText(), closeSoftKeyboard());
        onView(isRoot()).perform(waitFor(3000));
        onView(withHint("K??t dachu: ??")).perform(typeText("91"), closeSoftKeyboard());
        onView(withHint("K??t dachu: ??")).check(matches(hasTextColor(R.color.red)));
        onView(withId(R.id.button_roof1_count)).check(matches(isEnabled())).perform(click());
        // Verify that toast is correct for value over 90
        onView(withText("Niepoprawna warto???? dla theta: 91.0")).inRoot(withDecorView(not(decorView))).check(matches(isDisplayed()));

        Intents.release();
    }

    @Test
    public void toastsFor_Roof2_areCorrect() throws InterruptedException {
        // Initialize decor view needed for checking toasts
        mainActivityRule.getScenario().onActivity(activity -> {
            decorView = activity.getWindow().getDecorView();
        });

        Intents.init();
        // Go to roof 1
        onView(withId(R.id.button_roof_2)).perform(click());
        // Check that correct activity is displayed
        intended(hasExtra("ROOF_TYPE", 2));
        intended(hasComponent(UserInputsActivity.class.getName()));
        // Fill input parameters
        onView(withHint("D??ugo???? bud.: A")).perform(typeText("500"), closeSoftKeyboard());
        onView(withHint("Szeroko???? bud.: B")).perform(typeText("1"), closeSoftKeyboard());
        onView(withHint("Okap: D")).perform(typeText("80"), closeSoftKeyboard());
        onView(withHint("Zacios pionowy krokwi")).perform(typeText("5"), closeSoftKeyboard());
        onView(withHint("K??t dachu: ??")).perform(typeText("0"), closeSoftKeyboard());
        onView(withHint("Odleg??o???? C")).perform(typeText("250"), closeSoftKeyboard());
        onView(withHint("Szeroko???? mur??aty")).perform(typeText("20"), closeSoftKeyboard());
        onView(withHint("Grubo???? p??atwi kalenicowej")).perform(typeText("16"), closeSoftKeyboard());
        onView(withHint("Grubo???? krokwi")).perform(ViewActions.scrollTo(), typeText("1"), closeSoftKeyboard());
        onView(withHint("Szeroko???? krokwi")).perform(typeText("16"), closeSoftKeyboard());
        onView(withHint("Pole krokwi: Pk1")).perform(typeText("1"), closeSoftKeyboard());
        onView(withHint("Max. pole krokwi")).perform(typeText("1"), closeSoftKeyboard());
        onView(withId(R.id.button_roof1_count)).check(matches(isEnabled())).perform(click());
        // Verify that toast is correct for value 0
        onView(withHint("K??t dachu: ??")).check(matches(hasTextColor(R.color.red)));

        onView(withText("Niepoprawna warto???? dla theta: 0.0")).inRoot(withDecorView(not(decorView))).check(matches(isDisplayed()));
        // Clear theta, wait for 4 seconds and type value greater than 90
        onView(withHint("K??t dachu: ??")).perform(clearText(), closeSoftKeyboard());
        onView(isRoot()).perform(waitFor(3000));
        onView(withHint("K??t dachu: ??")).perform(typeText("91"), closeSoftKeyboard());
        onView(withHint("K??t dachu: ??")).check(matches(hasTextColor(R.color.red)));
        onView(withId(R.id.button_roof1_count)).check(matches(isEnabled())).perform(click());
        // Verify that toast is correct for value over 90
        onView(withText("Niepoprawna warto???? dla theta: 91.0")).inRoot(withDecorView(not(decorView))).check(matches(isDisplayed()));

        Intents.release();
    }

    @Test
    public void toastsFor_Roof3_areCorrect() throws InterruptedException {
        // Initialize decor view needed for checking toasts
        mainActivityRule.getScenario().onActivity(activity -> {
            decorView = activity.getWindow().getDecorView();
        });

        Intents.init();
        // Go to roof 1
        onView(withId(R.id.button_roof_3)).perform(click());
        // Check that correct activity is displayed
        intended(hasExtra("ROOF_TYPE", 3));
        intended(hasComponent(UserInputsActivity.class.getName()));
        // Fill input parameters
        onView(withHint("D??ugo???? cz????ci A")).perform(typeText("300"), closeSoftKeyboard());
        onView(withHint("D??ugo???? cz????ci B")).perform(typeText("200"), closeSoftKeyboard());
        onView(withHint("Pierwszy okap: D")).perform(typeText("40"), closeSoftKeyboard());
        onView(withHint("Zacios pionowy krokwi")).perform(typeText("3"), closeSoftKeyboard());
        onView(withHint("Szeroko???? mur??aty")).perform(typeText("12"), closeSoftKeyboard());
        onView(withHint("Grubo???? p??atwi kalenicowej")).perform(typeText("8"), closeSoftKeyboard());
        onView(withHint("Drugi okap: E")).perform(ViewActions.scrollTo(), typeText("30"), closeSoftKeyboard());
        onView(withHint("Grubo???? mur??aty")).perform(typeText("8"), closeSoftKeyboard());
        onView(withHint("Grubo???? krokwi")).perform(ViewActions.scrollTo(), typeText("4"), closeSoftKeyboard());
        onView(withHint("Szeroko???? krokwi")).perform(typeText("8"), closeSoftKeyboard());
        onView(withHint("Odleg??o???? A1")).perform(typeText("150"), closeSoftKeyboard());
        onView(withHint("Odleg??o???? B1")).perform(typeText("100"), closeSoftKeyboard());

        // Verify that toast is correct for value 0
        onView(withHint("K??t po??aci A: ??")).perform(ViewActions.scrollTo(), typeText("0"), closeSoftKeyboard());
        onView(withHint("K??t po??aci B: ??")).perform(typeText("45"), closeSoftKeyboard());
        onView(withHint("K??t po??aci A: ??")).check(matches(hasTextColor(R.color.red)));
        onView(withHint("K??t po??aci B: ??")).check(matches(hasTextColor(R.color.black)));
        onView(withId(R.id.button_roof1_count)).check(matches(isEnabled())).perform(click());
        onView(withText("Niepoprawna warto???? dla alpha: 0.0")).inRoot(withDecorView(not(decorView))).check(matches(isDisplayed()));
        onView(isRoot()).perform(waitFor(3000));

        // Verify that toast is correct for value 91
        onView(withHint("K??t po??aci A: ??")).perform(clearText(), typeText("40"), closeSoftKeyboard());
        onView(withHint("K??t po??aci B: ??")).perform(clearText(), typeText("91"), closeSoftKeyboard());
        onView(withHint("K??t po??aci A: ??")).check(matches(hasTextColor(R.color.black)));
        onView(withHint("K??t po??aci B: ??")).check(matches(hasTextColor(R.color.red)));
        onView(withId(R.id.button_roof1_count)).check(matches(isEnabled())).perform(click());
        onView(withText("Niepoprawna warto???? dla beta: 91.0")).inRoot(withDecorView(not(decorView))).check(matches(isDisplayed()));
        onView(isRoot()).perform(waitFor(3000));
        // Verify alpha < beta condition
        onView(withHint("K??t po??aci A: ??")).perform(clearText(), typeText("40"), closeSoftKeyboard());
        onView(withHint("K??t po??aci B: ??")).perform(clearText(), typeText("39"), closeSoftKeyboard());
        onView(withHint("K??t po??aci A: ??")).check(matches(hasTextColor(R.color.red)));
        onView(withHint("K??t po??aci B: ??")).check(matches(hasTextColor(R.color.red)));
        onView(withId(R.id.button_roof1_count)).check(matches(isEnabled())).perform(click());
        onView(withText("Alpha musi by?? mniejsze od beta")).inRoot(withDecorView(not(decorView))).check(matches(isDisplayed()));

        Intents.release();
    }

}