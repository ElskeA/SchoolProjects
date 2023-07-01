package com.example.stoplichtarduino;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    //Voor het maken van de bluetooth connectie is de volgende link/video gebruikt
    //https://www.youtube.com/watch?v=TLXpDY1pItQ&t=902s&ab_channel=BranislavStanojkovic
    //de UUID werkte bij mij niet. Bij het troubleshooten is de volgende oplossing gebruikt bij deze link
    //https://stackoverflow.com/questions/36785985/buetooth-connection-failed-read-failed-socket-might-closed-or-timeout-read-re

    //Voor het aanmaken van de bluetoothsocket was deze string nodig. Die komt uit de tutorial
    static final UUID mUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    BluetoothAdapter btA;
    BluetoothSocket bs;
    BluetoothDevice dev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnBluetooth = (Button) findViewById(R.id.button);

        //Aanmaken bluetooth adapter
        btA = BluetoothAdapter.getDefaultAdapter();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

        }

        //MAC adressen printen om die van de bluetooth adapter(HC-05) van arduino te vinden
        System.out.println(btA.getBondedDevices());
        //Aanspreken van HC-05
        dev = btA.getRemoteDevice("98:D3:61:FD:35:1E");
        // Naam printen om zeker te weten dat het de goede is
        System.out.println(dev.getName());

        //Button start het maken van een connectie met HC-05
        btnBluetooth.setOnClickListener(e-> {
            bs = null;
            try {
                //Bluetooth socket aanmaken. Code is anders dan de tutorial, die werkte bij mij niet. Er wordt dus ook uiteindelijk
                //geen gebruik gemaakt van de UUID string
                bs = (BluetoothSocket) dev.getClass().getMethod("createRfcommSocket", new Class[] { int.class } ).invoke(dev, 1);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException i) {
                i.printStackTrace();
            }

            //Het probeert 3x een connectie te maken. Het kan soms falen, dus het probeert meerdere keren en dan kapt het af
            for(int teller = 0; teller <3; teller++) {
                assert bs != null;
                if (!bs.isConnected()) {
                    try {
                        System.out.println(bs);
                        bs.connect();
                        System.out.println(bs.isConnected());
                    } catch (IOException a) {
                        a.printStackTrace();
                    }
                    teller++;
                }
            }
            try {
                OutputStream op = bs.getOutputStream();
                //49 wordt doorgegeven naar arduino. Dit wordt als arduino ingelezen als 1. De tutorial gaf 48 aan, maar die werkte bij mij niet
                //Omgezet naar 49, toen werkte het wel
                op.write(49);
            } catch (IOException x) {
                x.printStackTrace();
            }
            try {
                bs.close();
                System.out.println(bs.isConnected());
            } catch (IOException o) {
                o.printStackTrace();
            }
        });
    }
}