package com.example.checkconnectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkConnectivity();
    }


    private void checkConnectivity(){
        boolean isWiFiConnected;
        boolean isMobileNetConnected;
        ConnectivityManager myConManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeInfo = myConManager.getActiveNetworkInfo();
        if(activeInfo != null && activeInfo.isConnected()){//so connected with either wifi or cellular
            isWiFiConnected = activeInfo.getType() == ConnectivityManager.TYPE_WIFI;
            isMobileNetConnected = activeInfo.getType() == ConnectivityManager.TYPE_MOBILE;
            if(isWiFiConnected){
                Log.e("Connectivity ","WiFi");
                Toast.makeText(this, "WiFi connected", Toast.LENGTH_SHORT).show();
            }
            else if(isMobileNetConnected){
                Log.e("Connectivity ","Cellular");
                Toast.makeText(this, "Cellular data connected", Toast.LENGTH_SHORT).show();
            }
        }
        else {//No internet connection
            Log.e("Connectivity ","None!");
            Toast.makeText(this, "No Internet!", Toast.LENGTH_SHORT).show();
        }

    }
}
