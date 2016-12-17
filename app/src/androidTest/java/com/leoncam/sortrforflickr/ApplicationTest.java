package com.leoncam.sortrforflickr;

import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.leoncam.sortrforflickr.view.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * UI testing
 */
@RunWith(AndroidJUnit4.class)
public class ApplicationTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule =
            new ActivityTestRule<>(MainActivity.class, true, false);

    @Test
    public void swipeDown_RefreshImageGrid() {

        Intent intent = new Intent();
        mainActivityTestRule.launchActivity(intent);
        // Swipe down
        onView(withId(R.id.refresh_layout)).perform(swipeDown());

        // Verify recycler view (with image grid) is displayed
        onView(withId(R.id.rvImages))
                .check(matches(isDisplayed()));

    }

    // clickOnImage_ShowFullImageScreen Test will fail - Espresso doesn't wait for RecyclerView to load entries.
    // Need to create custom Espresso Idling Resource to handle Retrofit API calls.
    // Espresso UI tests only handle standard asynctasks by default.
    @Test
    public void clickOnImage_ShowFullImageScreen() {
        Intent intent = new Intent();
        mainActivityTestRule.launchActivity(intent);

        // Click an image at position 0
        onView(withId(R.id.rvImages))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));

        // Verify full image is displayed
        onView(withId(R.id.image_full))
                .check(matches(isDisplayed()));

    }
}