package NASSEKINE.SPARTAK.tarea05;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iVrise = findViewById(R.id.iVrise);
        ImageView iVanthony = findViewById(R.id.iVanthony);
        ImageView iVmago = findViewById(R.id.iVmago);
        ImageView iVmartin = findViewById(R.id.iVmartin);


        //posible asignacion del objeto cancion, en vez de posicion
        setClickListenerForImage(iVrise, 0);
        setClickListenerForImage(iVanthony, 1);
        setClickListenerForImage(iVmago, 2);
        setClickListenerForImage(iVmartin, 3);
    }

    private void setClickListenerForImage(ImageView imageView, int index) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v, index);
            }
        });
    }

    private void showPopupMenu(View view, int index) {
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
        popupMenu.getMenuInflater().inflate(R.menu.pop, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if (item.getItemId() == R.id.menu_informacion) {

                    daInfoAlbum(index);

                    return true;
                } else if (item.getItemId() == R.id.menu_pagina_web) {

                    abreWebView(index);

                    return true;
                } else {
                    return false;
                }
            }
        });

        popupMenu.show();
    }


    //quizas crear objeto cancion con toda la info
    private void daInfoAlbum(int index){


            String mensaje = "";

            if (index == 0) {
                mensaje = "Titulo: Not Gonna Die\n" +
                        "Autor: J. Cooper, Korey Cooper\n" +
                        "Disco: Rise\n" +
                        "Año: 2013";
            } else if (index == 1) {
                mensaje = "Titulo: Valió la pena\n" +
                        "Autor: Marc Anthony · Estéfano \n" +
                        "Disco: Valió la pena\n" +
                        "Año: 2004";
            } else if (index == 2) {
                mensaje = "Titulo: Mägo de Oz\n" +
                        "Autor: Txus di Fellatio \n" +
                        "Disco: Mägo de Oz\n" +
                        "Año: 1994";
            } else if (index == 3) {
                mensaje = "Titulo: Livin’ la Vida Loca\n" +
                        "Autor: Desmond Child, Draco Rosa Luis Gómez-Escolar\n" +
                        "Disco: Ricky Martin\n" +
                        "Año: 1999";
            }

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(mensaje)
                    .setPositiveButton("OK", null)
                    .create()
                    .show();

        Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
        }

        //para posible setUrl del posible objeto cancion
        // Método para abrir la WebView o una nueva actividad con la página web
    private void abreWebView(int index) {

        String url=null;

        Intent webViewIntent = new Intent(MainActivity.this, WebViewActivity.class);

        if(index==0){
            url = "https://en.wikipedia.org/wiki/Rise_%28Skillet_album%29";
        } else if (index==1) {
            url = "https://es.wikipedia.org/wiki/Vali%C3%B3_la_pena_(%C3%A1lbum)";
        } else if (index==2) {
            url = "https://es.wikipedia.org/wiki/M%C3%A4go_de_Oz_(%C3%A1lbum)";
        } else if (index==3) {
            url = "https://es.wikipedia.org/wiki/Ricky_Martin_(%C3%A1lbum_de_1999)";
        }

        webViewIntent.putExtra("url", url);
        startActivity(webViewIntent);
    }
}