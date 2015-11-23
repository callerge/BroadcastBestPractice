package com.example.broadcastbestpractic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button offLine_btn = (Button) findViewById(R.id.force_offline);
        offLine_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 发送轻质下线广播				
				Intent intent = new Intent("com.example.broadcastbestpractic.FORCE_OFFLINE");
				
				sendBroadcast(intent);
				
			}
		});
    }

}
