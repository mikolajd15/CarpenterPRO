package com.example.android101;

import static androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior.setTag;
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

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class InstrumentedTest {
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

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.android101", appContext.getPackageName());

    }

    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void mainActivityView_isCorrect() {
        //ViewInteraction viewInteraction = Espresso.onView(withText("Hello World!"));
        onView(withText("Dach jednospadowy")).check(matches(isDisplayed()));
        onView(withText("Dach dwuspadowy")).check(matches(isDisplayed()));
        onView(withText("Dach niesymetryczny")).check(matches(isDisplayed()));
        onView(withText("Dach 4")).check(matches(isDisplayed()));

        onView(withId(R.id.button_roof_1)).check(matches(withText("Dach jednospadowy")));
        onView(withId(R.id.button_roof_2)).check(matches(withText("Dach dwuspadowy")));
        onView(withId(R.id.button_roof_3)).check(matches(withText("Dach niesymetryczny")));
        onView(withId(R.id.button_roof_4)).check(matches(withText("Dach 4")));
    }

    @Test
    public void navigationToRoof1_isCorrect() {
        Intents.init();
        // Go to roof 1
        onView(withId(R.id.button_roof_1)).perform(click());
        // Check that correct activity is displayed
        intended(hasExtra("ROOF_TYPE", 1));
        intended(hasComponent(InputRoof1Activity.class.getName()));
        // Check that all needed input views are present
        onView(withHint("Podaj A")).check(matches(isDisplayed()));
        onView(withHint("Podaj B")).check(matches(isDisplayed()));
        onView(withHint("Podaj D")).check(matches(isDisplayed()));
        onView(withHint("Podaj S")).check(matches(isDisplayed()));
        onView(withHint("Podaj theta")).check(matches(isDisplayed()));
        onView(withHint("Podaj C")).check(matches(isDisplayed()));
        onView(withHint("Podaj s_mu")).check(matches(isDisplayed()));
        onView(withHint("Podaj g_pk")).check(matches(isDisplayed()));
        onView(withHint("Podaj E")).check(matches(isDisplayed()));
        onView(withHint("Podaj g_kr")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withHint("Podaj s_kr")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withHint("Podaj fpk")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withHint("Podaj k_max")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.roof1_input_41)).check(matches(not(isDisplayed())));
        // Check that button is initially disabled
        onView(withId(R.id.button_roof1_count)).check(matches(not(isEnabled())));
        Intents.release();
    }

    @Test
    public void countingValuesForRoof1_isCorrect() {
        Intents.init();
        // Go to roof 1
        onView(withId(R.id.button_roof_1)).perform(click());
        // Check that correct activity InputRoof1Activity is displayed
        intended(hasExtra("ROOF_TYPE", 1));
        intended(hasComponent(InputRoof1Activity.class.getName()));
        // Pass reference values:
        onView(withHint("Podaj A")).perform(typeText("500"), closeSoftKeyboard());
        onView(withHint("Podaj B")).perform(typeText("1"), closeSoftKeyboard());
        onView(withHint("Podaj D")).perform(typeText("80"), closeSoftKeyboard());
        onView(withHint("Podaj S")).perform(typeText("5"), closeSoftKeyboard());
        onView(withHint("Podaj theta")).perform(typeText("30"), closeSoftKeyboard());
        onView(withHint("Podaj C")).perform(typeText("250"), closeSoftKeyboard());
        onView(withHint("Podaj s_mu")).perform(typeText("20"), closeSoftKeyboard());
        onView(withHint("Podaj g_pk")).perform(typeText("16"), closeSoftKeyboard());
        onView(withHint("Podaj E")).perform(typeText("20"), closeSoftKeyboard());
        onView(withHint("Podaj g_kr")).perform(ViewActions.scrollTo(), typeText("1"), closeSoftKeyboard());
        onView(withHint("Podaj s_kr")).perform(typeText("16"), closeSoftKeyboard());
        onView(withHint("Podaj fpk")).perform(typeText("1"), closeSoftKeyboard());
        onView(withHint("Podaj k_max")).perform(typeText("1"), closeSoftKeyboard());
        Intents.release();

        Intents.init();
        // Check that button is enabled now and click it
        onView(withId(R.id.button_roof1_count)).check(matches(isEnabled())).perform(click());
        // // Check that correct activity ResultRoof1Activity is displayed
        intended(hasExtra("ROOF_TYPE", 1));
        intended(hasComponent(ResultRoof1Activity.class.getName()));
        // Verify results
        onView(withText("Ɣ = 60.00")).check(matches(isDisplayed()));
        onView(withText("Lc = 702.06")).check(matches(isDisplayed()));
        onView(withText("Lp = 692.82")).check(matches(isDisplayed()));
        onView(withText("M2 = 600.44")).check(matches(isDisplayed()));
        onView(withText("N2 = 311.77")).check(matches(isDisplayed()));
        onView(withText("K1 = 31.57")).check(matches(isDisplayed()));
        onView(withText("H1 = 299.44")).check(matches(isDisplayed()));
        Intents.release();
    }

    private View decorView;

    @Test
    public void toastsForRoof1_areCorrect() throws InterruptedException {
        // Initialize decor view needed for checking toasts
        mainActivityRule.getScenario().onActivity(activity -> {
            decorView = activity.getWindow().getDecorView();
        });

        Intents.init();
        // Go to roof 1
        onView(withId(R.id.button_roof_1)).perform(click());
        // Check that correct activity is displayed
        intended(hasExtra("ROOF_TYPE", 1));
        intended(hasComponent(InputRoof1Activity.class.getName()));
        // Fill input parameters
        onView(withHint("Podaj A")).perform(typeText("500"), closeSoftKeyboard());
        onView(withHint("Podaj B")).perform(typeText("1"), closeSoftKeyboard());
        onView(withHint("Podaj D")).perform(typeText("80"), closeSoftKeyboard());
        onView(withHint("Podaj S")).perform(typeText("5"), closeSoftKeyboard());
        onView(withHint("Podaj theta")).perform(typeText("0"), closeSoftKeyboard());
        onView(withHint("Podaj C")).perform(typeText("250"), closeSoftKeyboard());
        onView(withHint("Podaj s_mu")).perform(typeText("20"), closeSoftKeyboard());
        onView(withHint("Podaj g_pk")).perform(typeText("16"), closeSoftKeyboard());
        onView(withHint("Podaj E")).perform(typeText("20"), closeSoftKeyboard());
        onView(withHint("Podaj g_kr")).perform(ViewActions.scrollTo(), typeText("1"), closeSoftKeyboard());
        onView(withHint("Podaj s_kr")).perform(typeText("16"), closeSoftKeyboard());
        onView(withHint("Podaj fpk")).perform(typeText("1"), closeSoftKeyboard());
        onView(withHint("Podaj k_max")).perform(typeText("1"), closeSoftKeyboard());
        onView(withId(R.id.button_roof1_count)).check(matches(isEnabled())).perform(click());
        // Verify that toast is correct for value 0
        onView(withHint("Podaj theta")).check(matches(hasTextColor(R.color.red)));

        onView(withText("Niepoprawna wartość dla theta: 0.0")).inRoot(withDecorView(not(decorView))).check(matches(isDisplayed()));
        // Clear theta, wait for 4 seconds and type value greater than 90
        onView(withHint("Podaj theta")).perform(clearText(), closeSoftKeyboard());
        onView(isRoot()).perform(waitFor(3000));
        onView(withHint("Podaj theta")).perform(typeText("91"), closeSoftKeyboard());
        onView(withHint("Podaj theta")).check(matches(hasTextColor(R.color.red)));
        onView(withId(R.id.button_roof1_count)).check(matches(isEnabled())).perform(click());
        // Verify that toast is correct for value over 90
        onView(withText("Niepoprawna wartość dla theta: 91.0")).inRoot(withDecorView(not(decorView))).check(matches(isDisplayed()));

        Intents.release();
    }

}