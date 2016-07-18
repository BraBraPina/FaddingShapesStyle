package com.example.brody.faddingshapesstyle;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

abstract class Shape extends View {
    public Shape(Context context) {
        super(context);
    }

    void setShapeAlpha(float alpha){
        //https://developer.android.com/reference/android/view/View.html
        setAlpha(alpha);
    };

    float getShapeAlpha(){
        //https://developer.android.com/reference/android/view/View.html
        return getAlpha();
    };

    void removeShape(){
        //https://developer.android.com/reference/android/view/View.html
        setVisibility(View.GONE);
    };

    abstract String getShapeType();

    @Override
    public abstract void onDraw(Canvas canvas);
}
