package com.example.brody.faddingshapesstyle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class FaddingShapesStyle extends AppCompatActivity {
    // Global Variables
    ShapeFactory currentFactory = null;
    ArrayList<Shape> shapeArray = new ArrayList<Shape>();
    RelativeLayout shapeArea = (RelativeLayout) findViewById(R.id.shapeArea);
    TextView shapeCounter = (TextView) findViewById(R.id.shapeCounter);

    String styleCounter;
    int styleIterator;
    int rectCounter;
    int circCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fadding_shapes_style);

        // Initializing Styles & Shape Factory
        currentFactory = AbstractFactory.getShapeFactory(1);
        styleCounter = "Blue/Green";
        shapeCounter.setText("Style: " + styleCounter + "Rectangles: " + rectCounter + " Circles: " + circCounter);
        styleIterator = 1;

        //  Style Button
        //  changes current style
        Button styleb =(Button)findViewById(R.id.styleb);
        styleb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (styleIterator == 1) {
                    currentFactory = AbstractFactory.getShapeFactory(1);
                    styleCounter = "Blue/Green";
                    shapeCounter.setText("Style: " + styleCounter + "Rectangles: " + rectCounter + " Circles: " + circCounter);
                    styleIterator++;
                } else if (styleIterator == 2){
                    currentFactory = AbstractFactory.getShapeFactory(2);
                    styleCounter = "Red/Yellow";
                    shapeCounter.setText("Style: " + styleCounter + "Rectangles: " + rectCounter + " Circles: " + circCounter);
                    styleIterator++;
                } else if (styleIterator == 3){
                    currentFactory = AbstractFactory.getShapeFactory(3);
                    styleCounter = "Magenta/Cyan";
                    shapeCounter.setText("Style: " + styleCounter + "Rectangles: " + rectCounter + " Circles: " + circCounter);
                    styleIterator++;
                } else if (styleIterator == 4){
                    currentFactory = AbstractFactory.getShapeFactory(4);
                    styleCounter = "Cyan/Yellow";
                    shapeCounter.setText("Style: " + styleCounter + "Rectangles: " + rectCounter + " Circles: " + circCounter);
                    styleIterator++;
                } else if (styleIterator == 5){
                    currentFactory = AbstractFactory.getShapeFactory(5);
                    styleCounter = "Red/Blue";
                    shapeCounter.setText("Style: " + styleCounter + "Rectangles: " + rectCounter + " Circles: " + circCounter);
                    styleIterator++;
                } else if (styleIterator == 6){
                    currentFactory = AbstractFactory.getShapeFactory(6);
                    styleCounter = "Yellow/Green";
                    shapeCounter.setText("Style: " + styleCounter + "Rectangles: " + rectCounter + " Circles: " + circCounter);
                    styleIterator++;
                } else if (styleIterator > 6){
                    styleIterator = 1;
                }

            }
        });

        //  Rectangle Button
        //  draws rectangles in current style
        Button rectb =(Button)findViewById(R.id.rectb);
        rectb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adjustShapesAlpha();
                Shape rectangle = currentFactory.getRectangle(v.getContext());
                shapeArray.add(rectangle);
                shapeArea.addView(rectangle);
                updateShapesCount();
            }
        });

        // Circle Button
        //  draws circles in current style
        Button circb =(Button)findViewById(R.id.circb);
        circb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adjustShapesAlpha();
                Shape circle = currentFactory.getCircle(v.getContext());
                shapeArray.add(circle);
                shapeArea.addView(circle);
                updateShapesCount();
            }
        });

        //  Clear Button
        //  clears all shapes from shapeArea
        Button clearb =(Button) findViewById(R.id.clearb);
        clearb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rectCounter = 0;
                circCounter = 0;
                for (final Shape shape : shapeArray) {
                    shape.removeShape();
                    shapeArray.remove(shape);
                }
                shapeCounter.setText("Style: " + styleCounter + "Rectangles: " + rectCounter + " Circles: " + circCounter);
            }
        });
    }

    //  Shape Adjustment
    //  reduces currently drawn shapes visibility for every new shape & removes invisible shapes
    public void adjustShapesAlpha(){
        for (Shape shape : shapeArray) {
            shape.setShapeAlpha(shape.getAlpha() - 0.01f);
            if (shape.getShapeAlpha() <= 0f){
                shape.removeShape();
                if (shape.getShapeType().equalsIgnoreCase("RECTANGLE")){
                    rectCounter--;
                }else if (shape.getShapeType().equalsIgnoreCase("CIRCLE")){
                    circCounter--;
                }
                shapeArray.remove(shape);
            }
        }
        shapeCounter.setText("Style: " + styleCounter + "Rectangles: " + rectCounter + " Circles: " + circCounter);
    }

    //  Shape Counter
    //  traverses shapeArray to display current number of rectangless & circles currently drawn
    public void updateShapesCount(){
        rectCounter = 0;
        circCounter = 0;
        for (Shape shape : shapeArray){
            if (shape.getShapeType().equalsIgnoreCase("RECTANGLE")){
                rectCounter++;
            }else if(shape.getShapeType().equalsIgnoreCase("CIRCLE")){
                circCounter++;
            }
        }
        shapeCounter.setText("Style: " + styleCounter + "Rectangles: " + rectCounter + " Circles: " + circCounter);
    }
}
