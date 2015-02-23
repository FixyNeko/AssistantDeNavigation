package com.clefeflo.assistantdenavigation;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.Switch;

/**
 * Created by Félix on 04/02/2015.
 */
public class Liaison {
    private String point1, point2;
    private int poids;
    private float X1, Y1, X2, Y2, startAngle, sweepAngle, radius;
    private RectF rectF;
    private byte type;

    public Liaison(String p1, String p2, int poids) {
        this.point1 = p1;
        this.point2 = p2;
        this.poids = poids;
    }

    public Liaison(String p1, String p2, int poids, float x1, float y1, float x2, float y2, Paint p) {
        this.point1 = p1;
        this.point2 = p2;
        this.poids = poids;
        this.X1 = x1;
        this.Y1 = y1;
        this.X2 = x2;
        this.Y2 = y2;
        this.type = 1;
    }

    public Liaison(String p1, String p2, int poids, RectF rectF, float startAngle, float endAngle, Paint p) {
        this.point1 = p1;
        this.point2 = p2;
        this.poids = poids;
        this.rectF = rectF;
        this.startAngle = startAngle;
        this.sweepAngle = endAngle - startAngle;
        this.type = 2;
    }

    public Liaison(String p1, String p2, int poids, float x1, float y1, float radius, Paint p) {
        this.point1 = p1;
        this.point2 = p2;
        this.poids = poids;
        this.X1 = x1;
        this.Y1 = y1;
        this.radius = radius;
        this.type = 3;
    }

    public String getPoint1() {
        return this.point1;
    }

    public String getPoint2() {
        return this.point2;
    }

    public int getPoids() {
        return this.poids;
    }

    public Canvas addCanvas(Canvas canvas) {
        Paint p = new Paint();
        switch(this.type){
            case 1:
                p.setStyle(Paint.Style.STROKE);
                p.setStrokeWidth(7);
                p.setColor(Color.YELLOW);
                canvas.drawLine(this.X1, this.Y1, this.X2, this.Y2, p);
                break;
            case 2:
                p.setStyle(Paint.Style.STROKE);
                p.setStrokeWidth(7);
                p.setColor(Color.YELLOW);
                canvas.drawArc(this.rectF, this.startAngle, this.sweepAngle, false, p);
                break;
            case 3:
                p.setStyle(Paint.Style.FILL_AND_STROKE);
                p.setStrokeWidth(7);
                p.setColor(Color.RED);
                canvas.drawCircle(this.X1, this.Y1, this.radius, p);
                break;
        }
        return canvas;
    }
}
