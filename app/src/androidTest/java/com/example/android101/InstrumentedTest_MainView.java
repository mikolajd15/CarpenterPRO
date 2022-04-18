package com.example.android101;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
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

public class InstrumentedTest_MainView {
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
    public void navigationToRoof_1_isCorrect() {
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
    public void navigationToRoof_2_isCorrect() {
        Intents.init();
        // Go to roof 1
        onView(withId(R.id.button_roof_2)).perform(click());
        // Check that correct activity is displayed
        intended(hasExtra("ROOF_TYPE", 2));
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
        onView(withHint("Podaj g_kr")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withHint("Podaj s_kr")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withHint("Podaj fpk")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withHint("Podaj k_max")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.roof1_input_40)).check(matches(not(isDisplayed())));
        onView(withId(R.id.roof1_input_41)).check(matches(not(isDisplayed())));
        // Check that button is initially disabled
        onView(withId(R.id.button_roof1_count)).check(matches(not(isEnabled())));
        Intents.release();
    }

    @Test
    public void navigationToRoof_3_isCorrect() {
        Intents.init();
        // Go to roof 1
        onView(withId(R.id.button_roof_3)).perform(click());
        // Check that correct activity is displayed
        intended(hasExtra("ROOF_TYPE", 3));
        intended(hasComponent(InputRoof1Activity.class.getName()));
        // Check that all needed input views are present
        onView(withHint("Podaj A")).check(matches(isDisplayed()));
        onView(withHint("Podaj B")).check(matches(isDisplayed()));
        onView(withHint("Podaj D")).check(matches(isDisplayed()));
        onView(withHint("Podaj SB")).check(matches(isDisplayed()));
        onView(withHint("Podaj alpha")).check(matches(isDisplayed()));
        onView(withHint("Podaj beta")).check(matches(isDisplayed()));
        onView(withHint("Podaj s_mu")).check(matches(isDisplayed()));
        onView(withHint("Podaj g_pk")).check(matches(isDisplayed()));
        onView(withHint("Podaj E")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withHint("Podaj g_mu")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withHint("Podaj g_kr")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withHint("Podaj s_kr")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withHint("Podaj A1")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withHint("Podaj B1")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        // Check that button is initially disabled
        onView(withId(R.id.button_roof1_count)).check(matches(not(isEnabled())));
        Intents.release();
    }
}
