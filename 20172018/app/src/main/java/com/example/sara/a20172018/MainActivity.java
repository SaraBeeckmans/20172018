package com.example.sara.a20172018;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;



import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button[3][3];
    private boolean playerXturn = true;

    private int roundCount;

    private Game game;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new Game();

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                String buttonID = "button_"+i+j;
                int resId= getResources().getIdentifier(buttonID,"id",getPackageName());
                buttons[i][j] = findViewById(resId);
                buttons[i][j].setOnClickListener(this);

                buttons[i][j].setTag(""+i+j);
                buttons[i][j].setText(game.getXO(i,j));
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v instanceof Button) {
            Button button = (Button) v;

            Log.d("abc", "onClick: " + v.getTag());
            String tag = v.getTag().toString();
            int x = Character.getNumericValue(tag.charAt(0));
            int y = Character.getNumericValue(tag.charAt(1));
            if (game.getXO(x, y).compareTo("?") == 0) {

                game.setXO(x, y);
                button.setText(game.getXO(x, y));
            }
            else{
                Toast toast = Toast.makeText(getApplicationContext(), "Veld is reeds ingevuld.", Toast.LENGTH_SHORT);
                toast.show();
            }


        }
    }



}
