package com.example.brody.faddingshapesstyle;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;

public class Style4Factory extends ShapeFactory{

    Paint styleInner = new Paint();
    Paint styleBorder = new Paint();


    @Override
    public Shape getRectangle(Context context){
        styleInner.setStyle(Paint.Style.FILL);
        styleInner.setColor(Color.YELLOW);
        styleBorder.setStyle(Paint.Style.STROKE);
        styleBorder.setColor(Color.CYAN);
        Shape rectangle = new Rectangle(context, styleInner, styleBorder);
        return rectangle;
    }

    @Override
    public Shape getCircle(Context context) {
        styleInner.setStyle(Paint.Style.FILL);
        styleInner.setColor(Color.YELLOW);
        styleBorder.setStyle(Paint.Style.STROKE);
        styleBorder.setColor(Color.CYAN);
        Shape circle = new Circle(context, styleInner, styleBorder);
        return circle;
    }
}
