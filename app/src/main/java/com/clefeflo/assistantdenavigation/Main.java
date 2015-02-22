package com.clefeflo.assistantdenavigation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Main extends Activity implements View.OnClickListener{
    EditText startRoom, endRoom;
    int[] pathNums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_menu);
        startRoom = (EditText) findViewById(R.id.startRoom);
        endRoom = (EditText) findViewById(R.id.endRoom);
        Button startCalcButton = (Button) findViewById(R.id.startCalcButton);
        startCalcButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.startCalcButton:
                int start, end;
                try {start = Integer.parseInt(startRoom.getText().toString());}
                catch (Exception e) {
                    Toast.makeText(Main.this, R.string.enterStartRoom, Toast.LENGTH_LONG).show();
                    break;
                }
                try {end = Integer.parseInt(endRoom.getText().toString());}
                catch (Exception e) {
                    Toast.makeText(Main.this, R.string.enterEndRoom, Toast.LENGTH_LONG).show();
                    break;
                }
                if(start==end){
                    Toast.makeText(Main.this, R.string.sameRoom, Toast.LENGTH_LONG).show();
                    break;
                }

                try {
                    Integer.parseInt(Sector.getSector(start));
                    Toast.makeText(Main.this, R.string.wrongStartRoom, Toast.LENGTH_LONG).show();
                }
                catch (Exception a) {
                    try {
                        Integer.parseInt(Sector.getSector(end));
                        Toast.makeText(Main.this, R.string.wrongEndRoom, Toast.LENGTH_LONG).show();
                    }
                    catch (Exception b) {
                        Path.calcPath(Sector.getSector(start),Sector.getSector(end));
                        pathNums = Path.getPathNums();
                        MapView.draw(pathNums);
                    }
                }
                setContentView(R.layout.map_screen);
                Button floor0 = (Button) findViewById(R.id.floor0);
                floor0.setOnClickListener(this);
                Button floor1 = (Button) findViewById(R.id.floor1);
                floor1.setOnClickListener(this);
                Button floor2 = (Button) findViewById(R.id.floor2);
                floor2.setOnClickListener(this);
                Button floor3 = (Button) findViewById(R.id.floor3);
                floor3.setOnClickListener(this);
                break;
            case R.id.floor0:
                break;
            case R.id.floor1:
                break;
            case R.id.floor2:
                break;
            case R.id.floor3:
                break;
        }
    }
}
