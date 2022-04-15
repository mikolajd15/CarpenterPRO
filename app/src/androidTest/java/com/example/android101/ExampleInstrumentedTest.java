package com.example.android101;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;

import android.content.Context;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Rule;
import org.junit.Test;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
// TODO dodaj testy sprawdzające apke
public class ExampleInstrumentedTest {
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
    public void navigationToRoof1_isCorrect(){
        Intents.init();
        // Go to roof 1
        onView(withId(R.id.button_roof_1)).perform(click());
        // Check that correct activity is displayed
        intended(hasExtra("ROOF_TYPE", 1));
        intended(hasComponent(InputRoof1Activity.class.getName()));
        // TODO add images check
        // Check that all input views are present
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
        // Check that button initially is disabled
        onView(withId(R.id.button_roof1_count)).check(matches(not(isEnabled())));
        Intents.release();
    }

    @Test
    public void countingValuesForRoof1_isCorrect(){
        Intents.init();
        // Go to roof 1
        onView(withId(R.id.button_roof_1)).perform(click());
        // Check that correct activity is displayed
        intended(hasExtra("ROOF_TYPE", 1));
        intended(hasComponent(InputRoof1Activity.class.getName()));
        // Pass reference values:
        onView(withHint("Podaj A")).perform(typeText("100"), closeSoftKeyboard());
        onView(withHint("Podaj B")).perform(typeText("100"), closeSoftKeyboard());
        onView(withHint("Podaj D")).perform(typeText("100"), closeSoftKeyboard());
        onView(withHint("Podaj S")).perform(typeText("100"), closeSoftKeyboard());
        onView(withHint("Podaj theta")).perform(typeText("50"), closeSoftKeyboard());
        onView(withHint("Podaj C")).perform(typeText("100"), closeSoftKeyboard());
        onView(withHint("Podaj s_mu")).perform(typeText("100"), closeSoftKeyboard());
        onView(withHint("Podaj g_pk")).perform(typeText("100"), closeSoftKeyboard());
        onView(withHint("Podaj E")).perform(typeText("100"), closeSoftKeyboard());
        onView(withHint("Podaj g_kr")).perform(ViewActions.scrollTo(), typeText("100"), closeSoftKeyboard()); // g_kr
        onView(withHint("Podaj s_kr")).perform(typeText("100"), closeSoftKeyboard()); // s_kr
        onView(withHint("Podaj fpk")).perform(typeText("100"), closeSoftKeyboard()); // fpk
        onView(withHint("Podaj k_max")).perform(typeText("100"), closeSoftKeyboard()); // k_max
        // Check that button is enabled now
        onView(withId(R.id.button_roof1_count)).check(matches(isEnabled()));

        Intents.release();
    }

}