package ly.generalassemb.espresso;

import android.support.test.espresso.ViewAssertion;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
//import static android.support.test.espresso.matcher.ViewMatchers.onData;

/**
 * Created by wanmac on 7/21/16.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<BalanceActivity> mBalanceActivityTest =
            new ActivityTestRule<BalanceActivity>(BalanceActivity.class);

    @Test
    public void viewBalance() throws Exception{
        onView(withId(R.id.balanceTextView))
                .check((ViewAssertion) isDisplayed());
    }

    @Test
    public void withdraw() throws Exception{
       onView(withId(R.id.newTransactionButton)).
               perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(typeText("money"));
        onView(withId(R.id.amountEditText))
                .perform(typeText("10"));
        onView(withId(R.id.withdrawButton))
                .perform(click());
        onView(withId(R.id.balanceTextView))
                .check(matches(withText("-$10.00")))
    }

    @Test
    public void deposit() throws Exception{
        onView(withId(R.id.newTransactionButton)).
                perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(typeText("money"));
        onView(withId(R.id.amountEditText))
                .perform(typeText("10"));
        onView(withId(R.id.depositButton))
                .perform(click());
        onView(withId(R.id.balanceTextView))
                .check(matches(withText("$10.00")))
    }

    @Test
    public void multiTransaction() throws Exception{
        onView(withId(R.id.newTransactionButton)).
                perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(typeText("money"));
        onView(withId(R.id.amountEditText))
                .perform(typeText("10"));
        onView(withId(R.id.withdrawButton))
                .perform(click());

        onView(withId(R.id.newTransactionButton)).
                perform(click());
        onView(withId(R.id.descriptionEditText))
                .perform(typeText("money"));
        onView(withId(R.id.amountEditText))
                .perform(typeText("10"));
        onView(withId(R.id.depositButton))
                .perform(click());
        onView(withId(R.id.balanceTextView))
                .check(matches(withText("$0.00")))


    }


}
