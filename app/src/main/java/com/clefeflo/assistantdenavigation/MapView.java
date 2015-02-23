package com.clefeflo.assistantdenavigation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Félix on 04/02/2015.
 */
public class MapView extends View {
    Paint paint = new Paint();
    Canvas floor0;
    Canvas floor1;
    Canvas floor2;
    Canvas floor3;
    Canvas selectedCanvas;
    Bitmap bmp;
    Thread create;
    float ratio;

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);

        selectedCanvas.setBitmap(bmp);
        selectedCanvas = new Canvas();
        
        create = new Thread() {
            @Override
            public void run() {
                paint.setColor(Color.YELLOW);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(10);
                floor0 = new Canvas(((BitmapDrawable) getResources().getDrawable(R.drawable.ifloor0)).getBitmap());
                floor1 = new Canvas(((BitmapDrawable) getResources().getDrawable(R.drawable.ifloor1)).getBitmap());
                floor2 = new Canvas(((BitmapDrawable) getResources().getDrawable(R.drawable.ifloor2)).getBitmap());
                floor3 = new Canvas(((BitmapDrawable) getResources().getDrawable(R.drawable.ifloor3)).getBitmap());
                ratio = (float)floor0.getHeight() / (float)floor0.getWidth();
                System.out.println("Canvas setted. Ratio: " + ratio);
            }
        };
        create.start();
    }

    public void onDraw(final Canvas canvas) {
        while(create.isAlive()) {
            try {
                System.out.println(canvas.getWidth() + " " + (int) (canvas.getWidth() * ratio) + " Ratio: " + ratio);
                canvas.drawBitmap(bmp.createScaledBitmap(bmp, canvas.getWidth(), (int) ((float) canvas.getWidth() * ratio), false), 0, 0, null);
            } catch (Exception e) {
                System.out.println("Bitmap not printed: " + e);
            }
        }
    }

    public static void draw(int[] pathNums) {
        for(int i=0; i<pathNums.length ; i++) {
            char floor = AddToMap.liaison[pathNums[i]].getPoint1().charAt(AddToMap.liaison[pathNums[i]].getPoint1().length()-1);
            switch(floor) {
                case '0':
                    floor0 = AddToMap.liaison[i].addCanvas(floor0);
                    break;
                case '1':
                    floor1 = AddToMap.liaison[i].addCanvas(floor1);
                    break;
                case '2':
                    floor2 = AddToMap.liaison[i].addCanvas(floor2);
                    break;
                case '3':
                    floor3 = AddToMap.liaison[i].addCanvas(floor3);
                    break;
            }
        }
    }
    
    public static void selectFloor(int i) {
        switch(i){
            case 0:
                selectedCanvas = floor0;
                break;
            case 1:
                selectedCanvas = floor1;
                break;
            case 2:
                selectedCanvas = floor2;
                break;
            case 3:
                selectedCanvas = floor3;
                break;
        }
    }
}
