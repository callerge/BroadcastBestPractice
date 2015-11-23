package com.example.broadcastbestpractic;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.WindowManager;
/**
 * 
 * 静态注册一个广播接收器，用于销毁活动和开启活动
 */
public class OfflineReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(final Context context, Intent intent) {
		// 销毁活动
		ActivityController.finishAll();
		// 弹出对话框
		AlertDialog.Builder alerBuilder = new AlertDialog.Builder(context);
		alerBuilder.setTitle("Warnning!");
		alerBuilder.setMessage("You are forced line , plese try to login agin.");
		alerBuilder.setCancelable(false);
		alerBuilder.setPositiveButton("OK", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// 销毁所有活动
				ActivityController.finishAll();
				// 重启登录
				Intent intent = new Intent(context, LoginActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(intent);
			}
		});
		
		AlertDialog dialog = alerBuilder.create();
		
		// dialog 创建好了，必须要让其显示,并且屏蔽home键
		dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		dialog.show();
		

	}

}
