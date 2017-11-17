package com.geometry.constraintlayout;

import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ConstraintLayout constraintLayout;
    private Button applyButton, resetButton;
    private ConstraintSet applyConstraintSet = new ConstraintSet();
    private ConstraintSet resetConstraintSet = new ConstraintSet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout = (ConstraintLayout) findViewById(R.id.main);
        applyButton = (Button) findViewById(R.id.applyButton);
        resetButton = (Button) findViewById(R.id.resetButton);

        applyButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);

        resetConstraintSet.clone(constraintLayout);
        applyConstraintSet.clone(constraintLayout);
    }

    @Override
    public void onClick(View v) {
        //dev test
        //v1.0 test
        //v2.0 test
        switch (v.getId()) {
            case R.id.applyButton:
                onApplyClick(v);
                break;

            case R.id.resetButton:
                onResetClick(v);
                break;

        }
    }


    public void onApplyClick(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(constraintLayout);
        }
//        applyConstraintSet.setMargin(R.id.button1, ConstraintSet.START, 0);
//        applyConstraintSet.setMargin(R.id.button1, ConstraintSet.END, 0);
//        applyConstraintSet.setMargin(R.id.button2, ConstraintSet.START, 0);
//        applyConstraintSet.setMargin(R.id.button2, ConstraintSet.END, 0);
//        applyConstraintSet.setMargin(R.id.button3, ConstraintSet.START, 0);
//        applyConstraintSet.setMargin(R.id.button3, ConstraintSet.END, 0);
//
//        applyConstraintSet.centerHorizontally(R.id.button1, R.id.main);
//        applyConstraintSet.centerHorizontally(R.id.button2, R.id.main);
//        applyConstraintSet.centerHorizontally(R.id.button3, R.id.main);

//        applyConstraintSet.constrainWidth(R.id.button1,600);
//        applyConstraintSet.constrainWidth(R.id.button2,600);
//        applyConstraintSet.constrainWidth(R.id.button3,600);

//         applyConstraintSet.constrainHeight(R.id.button1,100);
//         applyConstraintSet.constrainHeight(R.id.button2,100);
//         applyConstraintSet.constrainHeight(R.id.button3,100);

        applyConstraintSet.setVisibility(R.id.button2,ConstraintSet.GONE);
        applyConstraintSet.setVisibility(R.id.button3,ConstraintSet.GONE);
        applyConstraintSet.clear(R.id.button1);
        applyConstraintSet.connect(R.id.button1,ConstraintSet.LEFT,R.id.main,ConstraintSet.LEFT,0);
        applyConstraintSet.connect(R.id.button1,ConstraintSet.RIGHT,R.id.main,ConstraintSet.RIGHT,0);
        applyConstraintSet.connect(R.id.button1,ConstraintSet.TOP,R.id.main,ConstraintSet.TOP,0);
        applyConstraintSet.connect(R.id.button1,ConstraintSet.BOTTOM,R.id.main,ConstraintSet.BOTTOM,0);

        applyConstraintSet.applyTo(constraintLayout);
    }

    public void onResetClick(View view) {
        resetConstraintSet.applyTo(constraintLayout);
    }
}
