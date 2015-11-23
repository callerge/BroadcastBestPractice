package com.example.broadcastbestpractic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {
	private EditText accoutnEdit;
	private EditText passwordEdit;
	private Button loginButton;
	private CheckBox rememberBox;


	private SharedPreferences pref;
	private SharedPreferences.Editor editor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.login);
		
		loginButton = (Button) findViewById(R.id.login);
		accoutnEdit = (EditText) findViewById(R.id.account);
		passwordEdit = (EditText) findViewById(R.id.password);
		rememberBox = (CheckBox) findViewById(R.id.remember_pass);
		
		/* �ڵ�¼���洴����ʱ���ȶ�ȡxml�ļ�������ѡ���ֵ�Ƿ�Ϊtrue
		 * ���Ϊtrue����ѡ��״̬��Ϊtrue���˺��������������Ϊxml�ļ����˺�����
		 * ��Ϊtrue���򲻹�
		 */
		// ��ȡcheckbox��ֵ
		pref = getSharedPreferences("data", MODE_PRIVATE);
		Boolean isRemember = pref.getBoolean("isRemember", false);
		
		if(isRemember){
			accoutnEdit.setText(pref.getString("account", ""));
			passwordEdit.setText(pref.getString("password", ""));
			
			// ע������ѡ�е����Ϊ setChecked(true)
			rememberBox.setChecked(true);
		}
		
		loginButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// ��֤�ɹ�����ת�������棬ʧ������ʾ�˺����벻��ȷ
				if("admin".equals(accoutnEdit.getText().toString())&&"123456".equals(passwordEdit.getText().toString())){
					// ��¼�˺�
					editor = getSharedPreferences("data", MODE_PRIVATE).edit();
					// ���ѡ�У����ϴ�
					if(rememberBox.isChecked()){ 
						editor.putBoolean("isRemember", true);
						editor.putString("account", "admin");
						editor.putString("password", "123456");
						
					}else {
						// ���δѡ�У��������������������Ȼ���ס����
						// ���õķ������ǣ��������������԰�isRemember���ֵ����Ϊfalse���Ͳ��ô�Χ�������
						editor.clear();
					}
					editor.commit();
					
					Intent intent = new Intent(LoginActivity.this,MainActivity.class);
					
					startActivity(intent);
				}else {
					Toast.makeText(LoginActivity.this, "account or password is not corret", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
	}
}
