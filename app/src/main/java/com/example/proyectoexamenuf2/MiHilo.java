package com.example.proyectoexamenuf2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MiHilo extends AsyncTask<String, Void, Bitmap> {

    ImageView imagen;
    Context context;

    public MiHilo(ImageView imagen, Context context) {
        this.imagen = imagen;
        this.context = context;
    }

    public MiHilo(ImageView imagen) {
        this.imagen = imagen;

    }

    @Override
    protected Bitmap doInBackground(String... strings) {


        URL url;

        HttpURLConnection connection;

        Bitmap bitmap = null;


        try {

            url = new URL(strings[0]);

            connection = (HttpURLConnection) url.openConnection();

            InputStream in = connection.getInputStream();


            bitmap = BitmapFactory.decodeStream(in);


        } catch (Exception e) {

            e.printStackTrace();

        }


        return bitmap;

    }

    @Override

    protected void onPostExecute(Bitmap bitmap) {

        super.onPostExecute(bitmap);


        imagen.setImageBitmap(bitmap);

    }

}
