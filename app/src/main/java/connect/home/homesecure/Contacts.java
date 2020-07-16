package connect.home.homesecure;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Contacts extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onTVClick(View view) {
        switch (view.getId()) {
            case R.id.amitPhone:
                Intent cIntent = new Intent(Intent.ACTION_CALL);
                cIntent.setData(Uri.parse("tel:9987518538"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(cIntent);
                break;
            case R.id.vishalPhone:
                Intent cvIntent = new Intent(Intent.ACTION_CALL);
                cvIntent.setData(Uri.parse("tel:9930331035"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(cvIntent);
                break;
            case R.id.hardikPhone:
                Intent chIntent = new Intent(Intent.ACTION_CALL);
                chIntent.setData(Uri.parse("tel:9033549279"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(chIntent);
                break;
            case R.id.sameerPhone:
                Intent cSamIntent = new Intent(Intent.ACTION_CALL);
                cSamIntent.setData(Uri.parse("tel:9820287587"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(cSamIntent);
                break;
            case R.id.swapnilPhone:
                Intent cSwapIntent = new Intent(Intent.ACTION_CALL);
                cSwapIntent.setData(Uri.parse("tel:9833407034"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(cSwapIntent);
                break;

            case R.id.amitEmail:
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto: tamit@godrej.com"));
                startActivity(Intent.createChooser(emailIntent, "Send feedback"));
                break;
            case R.id.swapnilEmail:
                Intent emailSwapIntent = new Intent(Intent.ACTION_SENDTO);
                emailSwapIntent.setData(Uri.parse("mailto: sjm@godrej.com"));
                startActivity(Intent.createChooser(emailSwapIntent, "Send feedback"));
                break;
            case R.id.vishalEmail:
                Intent emailVishIntent = new Intent(Intent.ACTION_SENDTO);
                emailVishIntent.setData(Uri.parse("mailto: vpc@godrej.com"));
                startActivity(Intent.createChooser(emailVishIntent, "Send feedback"));
                break;
            case R.id.sameerEmail:
                Intent emailSamIntent = new Intent(Intent.ACTION_SENDTO);
                emailSamIntent.setData(Uri.parse("mailto: sameerp@godrej.com"));
                startActivity(Intent.createChooser(emailSamIntent, "Send feedback"));
                break;
            case R.id.hardikEmail:
                Intent emailHardIntent = new Intent(Intent.ACTION_SENDTO);
                emailHardIntent.setData(Uri.parse("mailto: hrdk@godrej.com"));
                startActivity(Intent.createChooser(emailHardIntent, "Send feedback"));
                break;
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
