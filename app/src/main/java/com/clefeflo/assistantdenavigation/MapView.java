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
    private static Canvas floor0;
    Paint paint = new Paint();
//    Canvas floor0 = new Canvas();
    Canvas floor1 = new Canvas();
    Canvas floor2 = new Canvas();
    Canvas floor3 = new Canvas();
    Bitmap bmp;
    Thread create;
    float ratio;

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);

        create = new Thread() {
            @Override
            public void run() {
                paint.setColor(Color.YELLOW);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(10);
                bmp = ((BitmapDrawable) getResources().getDrawable(R.drawable.ifloor0)).getBitmap();
                ratio = (float)bmp.getHeight() / (float)bmp.getWidth();
                System.out.println("bmp défini. Ratio: " + ratio);
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
                    Canvas tmpCanvas = Liaison.addCanvas(floor0);
                    floor0 = tmpCanvas;
                    break;
            }
        }
    }
}
