package com.example.brody.faddingshapesstyle;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;

public class Style3Factory extends ShapeFactory{

    Paint styleInner = new Paint();
    Paint styleBorder = new Paint();


    @Override
    public Shape getRectangle(Context context){
        styleInner.setStyle(Paint.Style.FILL);
        styleInner.setColor(Color.CYAN);
        styleBorder.setStyle(Paint.Style.STROKE);
        styleBorder.setColor(Color.MAGENTA);
        Shape rectangle = new Rectangle(context, styleInner, styleBorder);
        return rectangle;
    }

    @Override
    public Shape getCircle(Context context) {
        styleInner.setStyle(Paint.Style.FILL);
        styleInner.setColor(Color.CYAN);
        styleBorder.setStyle(Paint.Style.STROKE);
        styleBorder.setColor(Color.MAGENTA);
        Shape circle = new Circle(context, styleInner, styleBorder);
        return circle;
    }
}
