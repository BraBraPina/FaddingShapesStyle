package com.example.brody.faddingshapesstyle;

public class AbstractFactory {
    public static ShapeFactory getShapeFactory(int style){
        ShapeFactory currentStyleFactory = null;
        if (style == 1){
            currentStyleFactory = new Style1Factory();
        }else if (style == 2){
            currentStyleFactory = new Style2Factory();
        }else if (style == 3){
            currentStyleFactory = new Style3Factory();
        }else if (style == 4){
            currentStyleFactory = new Style4Factory();
        }else if (style == 5){
            currentStyleFactory = new Style5Factory();
        }else if (style == 6){
            currentStyleFactory = new Style6Factory();
        }
        return currentStyleFactory;
    }
}

