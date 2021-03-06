package com.example.android101;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtraWithKey;
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
        onView(withText("Dach kopertowy")).check(matches(isDisplayed()));
        onView(withText("Ekran logowania")).check(matches(isDisplayed()));

        onView(withId(R.id.button_roof_1)).check(matches(withText("Dach jednospadowy")));
        onView(withId(R.id.button_roof_2)).check(matches(withText("Dach dwuspadowy")));
        onView(withId(R.id.button_roof_3)).check(matches(withText("Dach niesymetryczny")));
        onView(withId(R.id.button_roof_4)).check(matches(withText("Dach kopertowy")));
        onView(withId(R.id.button_login_screen)).check(matches(withText("Ekran logowania")));
    }

    @Test
    public void navigationTo_Roof1_isCorrect() {
        Intents.init();
        // Go to roof 1
        onView(withId(R.id.button_roof_1)).perform(click());
        // Check that correct activity is displayed
        intended(hasExtra("ROOF_TYPE", 1));
        intended(hasComponent(UserInputsActivity.class.getName()));
        // Check that all needed input views are present
        onView(withHint("D??ugo???? bud.: A")).check(matches(isDisplayed()));
        onView(withHint("Szeroko???? bud.: B")).check(matches(isDisplayed()));
        onView(withHint("Okap tylni: D")).check(matches(isDisplayed()));
        onView(withHint("Zacios pionowy krokwi")).check(matches(isDisplayed()));
        onView(withHint("K??t dachu: ??")).check(matches(isDisplayed()));
        onView(withHint("Odleg??o???? C")).check(matches(isDisplayed()));
        onView(withHint("Szeroko???? mur??aty")).check(matches(isDisplayed()));
        onView(withHint("Grubo???? p??atwi kalenicowej")).check(matches(isDisplayed()));
        onView(withHint("Okap przedni E")).check(matches(isDisplayed()));
        onView(withHint("Grubo???? krokwi")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withHint("Szeroko???? krokwi")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withHint("Pole krokwi: Pk1")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withHint("Max. pole krokwi")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.roof1_input_41)).check(matches(not(isDisplayed())));
        // Check that button is initially disabled
        onView(withId(R.id.button_roof1_count)).check(matches(not(isEnabled())));
        Intents.release();
    }

    @Test
    public void navigationTo_Roof2_isCorrect() {
        Intents.init();
        // Go to roof 1
        onView(withId(R.id.button_roof_2)).perform(click());
        // Check that correct activity is displayed
        intended(hasExtra("ROOF_TYPE", 2));
        intended(hasComponent(UserInputsActivity.class.getName()));
        // Check that all needed input views are present
        onView(withHint("D??ugo???? bud.: A")).check(matches(isDisplayed()));
        onView(withHint("Szeroko???? bud.: B")).check(matches(isDisplayed()));
        onView(withHint("Okap: D")).check(matches(isDisplayed()));
        onView(withHint("Zacios pionowy krokwi")).check(matches(isDisplayed()));
        onView(withHint("K??t dachu: ??")).check(matches(isDisplayed()));
        onView(withHint("Odleg??o???? C")).check(matches(isDisplayed()));
        onView(withHint("Szeroko???? mur??aty")).check(matches(isDisplayed()));
        onView(withHint("Grubo???? p??atwi kalenicowej")).check(matches(isDisplayed()));
        onView(withHint("Grubo???? krokwi")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withHint("Szeroko???? krokwi")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withHint("Pole krokwi: Pk1")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withHint("Max. pole krokwi")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withId(R.id.roof1_input_40)).check(matches(not(isDisplayed())));
        onView(withId(R.id.roof1_input_41)).check(matches(not(isDisplayed())));
        // Check that button is initially disabled
        onView(withId(R.id.button_roof1_count)).check(matches(not(isEnabled())));
        Intents.release();
    }

    @Test
    public void navigationTo_Roof3_isCorrect() {
        Intents.init();
        // Go to roof 1
        onView(withId(R.id.button_roof_3)).perform(click());
        // Check that correct activity is displayed
        intended(hasExtra("ROOF_TYPE", 3));
        intended(hasComponent(UserInputsActivity.class.getName()));
        // Check that all needed input views are present
        onView(withHint("D??ugo???? cz????ci A")).check(matches(isDisplayed()));
        onView(withHint("D??ugo???? cz????ci B")).check(matches(isDisplayed()));
        onView(withHint("Pierwszy okap: D")).check(matches(isDisplayed()));
        onView(withHint("Zacios pionowy krokwi")).check(matches(isDisplayed()));
        onView(withHint("K??t po??aci A: ??")).check(matches(isDisplayed()));
        onView(withHint("K??t po??aci B: ??")).check(matches(isDisplayed()));
        onView(withHint("Szeroko???? mur??aty")).check(matches(isDisplayed()));
        onView(withHint("Grubo???? p??atwi kalenicowej")).check(matches(isDisplayed()));
        onView(withHint("Drugi okap: E")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withHint("Grubo???? mur??aty")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withHint("Grubo???? krokwi")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withHint("Szeroko???? krokwi")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withHint("Odleg??o???? A1")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        onView(withHint("Odleg??o???? B1")).perform(ViewActions.scrollTo()).check(matches(isDisplayed()));
        // Check that button is initially disabled
        onView(withId(R.id.button_roof1_count)).check(matches(not(isEnabled())));
        Intents.release();
    }

    @Test
    public void navigationTo_LoginScreen_isCorrect() {
        Intents.init();
        // Go back to login screen
        onView(withId(R.id.button_login_screen)).perform(click());
        // Check that correct activity is displayed
        intended(not(hasExtraWithKey("ROOF_TYPE")));
        intended(hasComponent(LoginMainActivity.class.getName()));
        // Check that all needed input views are present
        onView(withHint("Email")).check(matches(isDisplayed()));
        onView(withHint("Has??o")).check(matches(isDisplayed()));

        onView(withText("Logowanie")).check(matches(isDisplayed()));
        onView(withText("Rejestracja")).check(matches(isDisplayed()));
        onView(withText("Kontynuuj jako go????")).check(matches(isDisplayed()));

        Intents.release();
    }
}
