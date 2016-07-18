package com.example.brody.faddingshapesstyle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class Circle extends Shape{
    Paint colorInner, colorBorder;

    public Circle(Context context, Paint styleInner, Paint styleBorder) {
        super(context);

        colorInner = styleInner;
        colorBorder = styleBorder;
    }

    @Override
    String getShapeType() {
        return "CIRCLE";
    }

    @Override
    public void onDraw(Canvas canvas) {

        //  Randomized Size/Placement
        int x, y, radius;
        Random rand = new Random();

        x = rand.nextInt(500);
        y = rand.nextInt(500);
        radius = rand.nextInt(500-100)+100;

        canvas.drawCircle(x, y, radius, colorInner);
        canvas.drawCircle(x, y, radius, colorBorder);
    }
}
