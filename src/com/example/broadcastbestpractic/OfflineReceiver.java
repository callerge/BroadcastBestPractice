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
 * ��̬ע��һ���㲥���������������ٻ�Ϳ����
 */
public class OfflineReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(final Context context, Intent intent) {
		// ���ٻ
		ActivityController.finishAll();
		// �����Ի���
		AlertDialog.Builder alerBuilder = new AlertDialog.Builder(context);
		alerBuilder.setTitle("Warnning!");
		alerBuilder.setMessage("You are forced line , plese try to login agin.");
		alerBuilder.setCancelable(false);
		alerBuilder.setPositiveButton("OK", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// �������л
				ActivityController.finishAll();
				// ������¼
				Intent intent = new Intent(context, LoginActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(intent);
			}
		});
		
		AlertDialog dialog = alerBuilder.create();
		
		// dialog �������ˣ�����Ҫ������ʾ,��������home��
		dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		dialog.show();
		

	}

}
