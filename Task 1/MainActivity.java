package com.example.flashlightapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Switch aSwitch;
    TextView tv_result;
    CameraManager cameraManager;
    String cameraid, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aSwitch=findViewById(R.id.switch1);
        tv_result=findViewById(R.id.tv2);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //flashlight code

                torch(isChecked);
            }
        });
    }

    private void torch(boolean isChecked) {

        try {
            cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
            cameraid = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraid,isChecked);
            result = isChecked?"ON":"OFF";
            tv_result.setText(result);
        } catch (CameraAccessException e) {
            throw new RuntimeException(e);
        }
    }
}