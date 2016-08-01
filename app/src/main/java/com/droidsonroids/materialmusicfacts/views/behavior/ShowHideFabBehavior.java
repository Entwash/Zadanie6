package com.droidsonroids.materialmusicfacts.views.behavior;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

import com.droidsonroids.materialmusicfacts.R;

import org.w3c.dom.Attr;

import static android.support.v4.view.ViewCompat.SCROLL_AXIS_VERTICAL;

/**
 * Created by Jakub on 01.08.2016.
 */
public class ShowHideFabBehavior extends CoordinatorLayout.Behavior<FloatingActionButton>{

    String direction;

    public ShowHideFabBehavior() {
        super();
    }

    public ShowHideFabBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        return nestedScrollAxes == SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        child.hide();

        //child.animate().setDuration(300).translationX(-100);
    }

    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target) {
        super.onStopNestedScroll(coordinatorLayout, child, target);

//        if(direction.equals("center"))
            child.show();
//        else if(direction.equals("right"))
            child.animate().setDuration(300).translationXBy(100);
    }
    public void initialize(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.FloatingActionButtonBehavior);
        direction = typedArray.getString(R.styleable.FloatingActionButtonBehavior_direction);
        typedArray.recycle();

    }

    public void moveRight() {
        Animation showAnimation = new TranslateAnimation(300, 0, 0, 0);
        showAnimation.setDuration(300);
    }

    public void moveleft() {
        Animation showAnimation = new TranslateAnimation(0, 300, 0, 0);
        showAnimation.setDuration(300);
    }

//    @Override
//    public Boolean layoutDependsOn(final )
}
