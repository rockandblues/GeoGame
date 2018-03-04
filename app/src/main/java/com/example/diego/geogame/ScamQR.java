package com.example.diego.geogame;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScamQR extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    private static final int MY_PERMISSIONS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);

        //Pedimos permisos para usar la camara
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)

                != PackageManager.PERMISSION_GRANTED) {


            if (ActivityCompat.shouldShowRequestPermissionRationale(this,

                    Manifest.permission.CAMERA)) {


            } else {


                ActivityCompat.requestPermissions(this,

                        new String[]{Manifest.permission.CAMERA},

                        MY_PERMISSIONS);


            }

        }



    }

    @Override
    public void onResume() {
        super.onResume();

        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result rawResult) {

        Log.i("QRCode", rawResult.getText());

        mScannerView.resumeCameraPreview(this);


    }


    public void checkTerosoros(){
        boolean teroso1 = false;
        boolean tesoro2 = false;
        boolean tesoro3 = false;

        Intent intent = new Intent(getApplicationContext(), Game.class);



    }
}
