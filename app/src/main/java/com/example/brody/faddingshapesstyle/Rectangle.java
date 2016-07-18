package com.example.brody.faddingshapesstyle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Random;

public class Rectangle extends Shape{

    Paint colorInner, colorBorder;

    public Rectangle(Context context, Paint styleInner, Paint styleBorder) {
        super(context);

        colorInner = styleInner;
        colorBorder = styleBorder;
    }

    @Override
    String getShapeType() {
        return "RECTANGLE";
    }

    @Override
    public void onDraw(Canvas canvas) {

        //  Randomized Size/Placement
        int xL, xR, yT, yB;
        Random rand = new Random();

        xL = rand.nextInt(500);
        yT = rand.nextInt(500);
        xR = rand.nextInt(500) + xL;
        yB = rand.nextInt(500) + yT;

        Rect rectangle = new Rect();
        rectangle.set(xL, yT, xR, yB);

        canvas.drawRect(rectangle, colorInner);
        canvas.drawRect(rectangle, colorBorder);
    }
}