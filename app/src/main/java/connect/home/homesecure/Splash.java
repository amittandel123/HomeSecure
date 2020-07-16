package connect.home.homesecure;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    Thread splashThread;
    SharedPreferences sharedPreferences;

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        StartAnimations();
    }

    private boolean StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        RelativeLayout l = (RelativeLayout) findViewById(R.id.Rel_Layout);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.imgLogo);
        TextView tvConHome = (TextView) findViewById(R.id.tvCH);
        TextView tvPurp = (TextView) findViewById(R.id.tvPurpose);
        iv.clearAnimation();
        tvConHome.clearAnimation();
        tvPurp.clearAnimation();
        iv.startAnimation(anim);
        tvConHome.startAnimation(anim);
        tvPurp.startAnimation(anim);

        splashThread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 3000) {
                        sleep(100);
                        waited += 100;
                    }
                    sharedPreferences = getSharedPreferences("Pref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    boolean firstTime = sharedPreferences.getBoolean("first", true);
                    if (firstTime) {
                        editor.putBoolean("first", false);
                        editor.apply();
                        Intent phoneIntent = new Intent(Splash.this, EditPhone.class);
                        phoneIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(phoneIntent);
                    } else {
                        Intent mainIntent = new Intent(Splash.this, MainActivity.class);
                        mainIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(mainIntent);
                    }
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    Splash.this.finish();
                }
            }
        };
        splashThread.start();
        return true;
    }
}