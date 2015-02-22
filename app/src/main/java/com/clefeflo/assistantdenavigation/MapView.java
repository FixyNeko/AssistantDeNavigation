package com.clefeflo.assistantdenavigation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Félix on 04/02/2015.
 */
public class MapView extends View {
    Paint paint = new Paint();
    Canvas floor0 = new Canvas(), floor1 = new Canvas(), floor2 = new Canvas(), floor3 = new Canvas();
    Bitmap bmp;
    Picture pic = new Picture();

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);

        final Thread t = new Thread() {
            @Override
            public void run() {
                paint.setColor(Color.YELLOW);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(10);
                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ifloor0);
                floor0.drawBitmap(bmp, 0,0, null);
                pic.draw(floor0);
                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ifloor0);
                floor1.drawBitmap(bmp, 0,0, null);
                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ifloor0);
                floor2.drawBitmap(bmp, 0,0, null);
                bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ifloor0);
                floor3.drawBitmap(bmp, 0,0, null);
            }
        };
        t.start();
    }

    public void onDraw(Canvas canvas) {
        canvas.drawPicture(pic);

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
