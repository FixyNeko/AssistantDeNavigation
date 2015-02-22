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

/**
 * Created by Félix on 04/02/2015.
 */
public class MapView extends View {
    Paint paint = new Paint();
    Canvas floor0 = new Canvas(), floor1 = new Canvas(), floor2 = new Canvas(), floor3 = new Canvas();
    Bitmap bmp;
    Thread t;

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);

        t = new Thread() {
            @Override
            public void run() {
                paint.setColor(Color.BLACK);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(10);
//                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ifloor0);
//                floor0.drawBitmap(bmp, 500, 500, null);
//                floor0.drawLine(0,0,500,500,paint);
//                pic.draw(floor0);

                bmp = ((BitmapDrawable) getResources().getDrawable(R.drawable.ifloor0)).getBitmap();
                System.out.println("bmp défini");
            }
        };
        t.start();
    }

    public void onDraw(Canvas canvas) {
        canvas.drawLine(0, 50, 200, 250, paint);
        while(t.isAlive()) {
            try {
                canvas.drawBitmap(bmp, 0, 0, paint);
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
//                    floor0.draw
                    break;
            }
        }
    }
}
