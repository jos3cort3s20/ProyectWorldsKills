package com.example.jos3cort3s_pc.worldskillentreno2018.Activitys;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jos3cort3s_pc.worldskillentreno2018.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookDialog;
import com.facebook.FacebookException;
import com.facebook.share.Sharer;
import com.facebook.share.internal.ShareDialogFeature;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityDetalle extends AppCompatActivity {


    TextView texto;
    ImageView imagenVista;
    Button btnTakePhoto,btnShareFace, btnMaps;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    Bitmap imageBitmap;
    ShareDialog shareDialog;

    CallbackManager callbackManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detalle);
        llamaId();
        shareDialog = new ShareDialog(this);


        btnTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnShareFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareLinkContent content = new ShareLinkContent.Builder()
                        .setContentUrl(Uri.parse("https://developers.facebook.com"))
                        .build();
            }
        });



        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goMapa =  new Intent(ActivityDetalle.this, MapsActivity.class);
                startActivity(goMapa);

            }
        });



    }

    public void llamaId(){
        imagenVista = (ImageView)findViewById(R.id.ivImagePhoto);
        btnTakePhoto = (Button)findViewById(R.id.btnTakePhoto);
        btnShareFace = (Button)findViewById(R.id.btnShareFace);
        btnMaps = (Button)findViewById(R.id.btnMapss);

    }











    public void  publicarOnTwitter (){

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent
                .putExtra(Intent.EXTRA_TEXT,
                        "<---YOUR TEXT HERE--->.");
        sendIntent.setType("text/plain");
        sendIntent.setPackage("COLOAR PAQUETE DE LA APLICACION ABRIR");
        try {
            startActivity(sendIntent);
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(),"Please Install twitter", Toast.LENGTH_LONG).show();
        }

    }



    protected void sendEmail() {

        Log.i("Send email", "");

        String[] TO = {"someone@gmail.com"};
        String[] CC = {"xyz@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        //emailIntent.setData(pkg);
        emailIntent.setPackage("com.a");
        emailIntent.setType("message/rfc822");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished ", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(),
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }


public boolean verificarSiExisteApp() {
    try {
        ApplicationInfo info = getPackageManager().
                getApplicationInfo("com.facebook.lite", 0);
        return true;
    } catch (PackageManager.NameNotFoundException e) {
        return false;
    }

}
    private void takePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                File photoFile = null;
                try {
                    photoFile = createImageFile();
                } catch (IOException ex) {
                }

                if (photoFile != null) {
                   /* Uri photoURI = FileProvider.getUriForFile(this,
                            "com.example.android.fileprovider",
                            photoFile);*/
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoFile);
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
    }



    String nameforPhotoPath;
    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "DOGDOG" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",   /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        nameforPhotoPath = image.getAbsolutePath();
        return image;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            imagenVista.setImageBitmap(imageBitmap);

            ShareDialog myShareDialog =  new ShareDialog(this);

            SharePhoto photo = new SharePhoto.Builder()
                    .setBitmap(imageBitmap)
                    .build();
            SharePhotoContent content = new SharePhotoContent.Builder()
                    .addPhoto(photo)
                    .build();

            myShareDialog.show(this, content);


        }
    }
}