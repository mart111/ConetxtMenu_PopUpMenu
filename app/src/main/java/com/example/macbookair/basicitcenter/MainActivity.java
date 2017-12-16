package com.example.macbookair.basicitcenter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txt;
    private Button btnContext;
    private Button btnPopUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.txt);
        btnContext = findViewById(R.id.btnContext);
        btnPopUp = findViewById(R.id.btnPopUp);
        registerForContextMenu(btnContext);

        btnPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0, 5, 0, "Red");
        menu.add(0, 6, 0, "Green");
        menu.add(0, 7, 0, "Blue");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 5:
                txt.setTextColor(Color.RED);
                break;
            case 6:
                txt.setTextColor(Color.GREEN);
                break;
            case 7:
                txt.setTextColor(Color.BLUE);
                break;

            default:
                break;
        }

        return true;
    }

    private void showPopup(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.my_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.small:
                        txt.setTextSize(30);
                        break;

                    case R.id.medium:
                        txt.setTextSize(50);
                        break;
                    case R.id.large:
                        txt.setTextSize(70);
                        break;

                    default:
                        break;
                }

                return true;
            }
        });
        popupMenu.show();
    }


}
