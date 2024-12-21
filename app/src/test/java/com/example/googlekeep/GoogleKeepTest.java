package com.example.googlekeep;

import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleKeepTest extends BaseTest {

    @Test
    public void testAddNote() {
        // Locate "New Note" button using accessibilityId
        MobileElement newNoteButton = driver.findElementByAccessibilityId("New text note");
        newNoteButton.click();

        // Locate the note title field using resource ID
        MobileElement titleField = driver.findElementById("com.google.android.keep:id/editable_title");
        titleField.sendKeys("Appium Note");

        // Locate the note body field using resource ID
        MobileElement bodyField = driver.findElementById("com.google.android.keep:id/edit_note_text");
        bodyField.sendKeys("This is a note added using Appium.");

        // Save and navigate back
        driver.navigate().back();
        driver.navigate().back();

        // Verify the note appears
        MobileElement noteTitle = driver.findElementByXPath("//android.widget.TextView[@text='Appium Note']");
        Assert.assertTrue(noteTitle.isDisplayed(), "Note title is not displayed");
    }

    @Test
    public void testScroll() {
        // Use UIAutomator to locate a specific element by scrolling
        MobileElement element = (MobileElement) driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Appium Note\"))");
        Assert.assertTrue(element.isDisplayed(), "Failed to scroll to the note");
    }

    @Test
    public void testSwipeGesture() {
        // Perform swipe gesture
        MobileElement firstElement = driver.findElementByXPath("//android.widget.TextView[1]");
        MobileElement secondElement = driver.findElementByXPath("//android.widget.TextView[2]");

        int startX = firstElement.getLocation().getX();
        int startY = firstElement.getLocation().getY();
        int endX = secondElement.getLocation().getX();
        int endY = secondElement.getLocation().getY();

        driver.swipe(startX, startY, endX, endY, 1000);
    }
}

