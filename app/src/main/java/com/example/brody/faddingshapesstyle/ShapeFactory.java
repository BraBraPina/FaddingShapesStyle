package com.example.brody.faddingshapesstyle;

import android.content.Context;

public abstract class ShapeFactory {
    public abstract Shape getRectangle(Context context);
    public abstract Shape getCircle(Context context);
}
