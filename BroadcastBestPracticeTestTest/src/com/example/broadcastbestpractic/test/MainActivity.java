package com.example.broadcastbestpractic.test;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
	// ��������г�ʼ�������������������¼���
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (savedInstanceState != null) {
			// �ָ���ʱ����
			String tempData = savedInstanceState.getString("key");
			// ...
		}
	}

	// �����ﱣ����ʱ����
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		// ��A->B��A����ֹͣ״̬�����ܱ�ϵͳ���գ���ʱ��Back������Ȼ��ص�A�����ǻ����A��onCreate����������onRestart����ʱ���ݽ����ٴ��ڣ����������
		// ͨ��Bundle������������Խ���ʱ���ݱ��棬����put...;��A�ٱ�����ʱ������ȡ��Bundle������ݣ�������ز��������ϣ�
		String tempData = "this is  temp data";
		outState.putString("key", tempData);
	}

	// �������ã���ֹͣ״̬��Ϊ����״̬
	@Override
	public void onRestart() {
		super.onRestart();
		// ��֪����������еĻ�Ѿ��ɼ�֮������ı�
	}

	// �ڿɼ������ڿ�ʼʱ����
	@Override
	public void onStart() {
		super.onStart();
	}

	// ���׼���ú��û����������ڷ���ջջ��
	@Override
	public void onResume() {
		super.onResume();
		// ��˵���ָ������Ҫ���κ���ͣ��UI���¡��̻߳��߽��̣����ǵ������ʱ�򣬾͹�������
	}

	// ���ͣʱ�����Ȼ�ɼ������ʱ�����Ի��򣬻�ʹ�����ͣ
	@Override
	public void onPause() {
		// ��˵���������ǰ̨�Ļ״̬�Ļʱ��������Ҫ���µ�UI���¡��̻߳���CPU�ܼ��Ľ��̡�
		super.onPause();
		// ���ͷ�CPU��Դ������ؼ����ݣ����Ƕ���һ���ÿ죬����Ӱ����ջ���
	}

	// ���ȫ���ɼ�
	@Override
	public void onStop() {
		// ��˵�������̲��ɼ���ʱ�򣬹�����Ҫ��ʣ�µ�UI���¡��̻߳��ߴ����������еı༭����
		// ״̬�ı䣬��Ϊ������̿��ܻᱻ����(�Ӷ�Ϊ������������Դ)
		super.onStop();
	}

	// �����������ڽ���ʱ����
	@Override
	public void onDestroy() {
		// ������е���Դ�����������̡߳��ر����ݿ����ӵȡ�
		super.onDestroy();
	}

}