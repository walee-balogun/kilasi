package com.example.zheey.kilasi.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.zheey.kilasi.R;

public class MyActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class splashscreen extends SurfaceView implements Runnable  {
     int x,y = 0;
        SurfaceHolder surfaceholder;
        boolean validate = true;
        Bitmap zainab;
        public splashscreen(Context context) {
            super(context);
            zainab = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        }
  public void onDraw(Canvas c) {
      int width = c.getWidth();
      int height = c.getHeight();

      Rect timing = new Rect();
      timing.set(width/8, (3*height)/4, x , 10);

      Paint rectX = new Paint();
      rectX.setColor(Color.rgb(18,186,222));

      Rect loader = new Rect();
      loader.set(0, 0, c.getWidth(), c.getHeight());

      c.drawRect(0,0,c.getWidth(),c.getHeight(),null);
      c.drawBitmap(zainab, null, loader, rectX);




  }
        @Override
    public void run() {
            Canvas c;
     while(validate == true) {
        c = null;
         try{   c = surfaceholder.lockCanvas(null);
             this.onDraw(c);
           Thread.sleep(300);
         } catch (Exception e) {   }

         if(c != null) {
             surfaceholder.unlockCanvasAndPost(c);
         }

     }
    }

        public void TimerRate(){


        }

        public void fetchDataFromFile() {




        }
}
    }
