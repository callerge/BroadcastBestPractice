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
		
		/* 在登录界面创建的时候，先读取xml文件，看复选框的值是否为true
		 * 如果为true，复选框状态改为true，账号密码的内容设置为xml文件的账号密码
		 * 不为true，则不管
		 */
		// 获取checkbox的值
		pref = getSharedPreferences("data", MODE_PRIVATE);
		Boolean isRemember = pref.getBoolean("isRemember", false);
		
		if(isRemember){
			accoutnEdit.setText(pref.getString("account", ""));
			passwordEdit.setText(pref.getString("password", ""));
			
			// 注意设置选中的语句为 setChecked(true)
			rememberBox.setChecked(true);
		}
		
		loginButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 验证成功则跳转至主界面，失败者提示账号密码不正确
				if("admin".equals(accoutnEdit.getText().toString())&&"123456".equals(passwordEdit.getText().toString())){
					// 记录账号
					editor = getSharedPreferences("data", MODE_PRIVATE).edit();
					// 如果选中，则上传
					if(rememberBox.isChecked()){ 
						editor.putBoolean("isRemember", true);
						editor.putString("account", "admin");
						editor.putString("password", "123456");
						
					}else {
						// 如果未选中，则清除，如果不清除，依然会记住密码
						// 可用的方案二是，如果不清除，可以吧isRemember这个值设置为false，就不用大范围清空数据
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
