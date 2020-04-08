package com.studentshub.android.activities.intro;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;


import com.github.paolorotolo.appintro.AppIntro2;
import com.google.api.Context;
import com.studentshub.android.R;

public class IntroActivity extends AppIntro2 {
    Intro1 intro1 ;
    Intro2 intro2 ;
    Intro3 intro3 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        intro1 = new Intro1();
        intro2 = new Intro2();
        intro3 = new Intro3();
        addSlide(intro1);
        addSlide(intro2);
        addSlide(intro3);




        // Hide Skip/Done button
        showPagerIndicator(true);
       // setImageSkipButton(getDrawable(R.drawable.ic_notice));
        showSkipButton(true);
        setFadeAnimation();
        setIndicatorColor(Color.parseColor("#0297E8"),Color.parseColor("#B2D1E1"));


    }
    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.
        finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }
}
