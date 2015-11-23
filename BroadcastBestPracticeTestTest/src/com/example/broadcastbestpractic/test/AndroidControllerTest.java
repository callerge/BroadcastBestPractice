package com.example.broadcastbestpractic.test;

import com.example.broadcastbestpractic.ActivityController;
import com.example.broadcastbestpractic.LoginActivity;

import android.test.AndroidTestCase;
/**
 * 
 * BroadcastBestPractice�е�AndroidController���������.<br/>
 * ��Ҫ��дsetUp��tearDown����
 */
public class AndroidControllerTest extends AndroidTestCase {

	/**
	 * ������������ǰִ�У�������������г�ʼ������
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}
	
	/**
	 * ����Ҫ���Եķ���ǰ�����test��ϵͳ�ͻ��Զ����Ը÷���.</br>
	 * ͨ��assert���ж���.<br/>
	 * Run as Android JUit Test���в�������.<br/>
	 */
	public void testaddActivity(){
		// ����activity��ϵ�������ʼΪ0
		assertEquals(0, ActivityController.activities.size());
		LoginActivity loginActivity = new LoginActivity();
		ActivityController.addActivity(loginActivity);
		// ���Ծ���addActivity��������֮�󣬻�������ӳ�Ϊ1������Ϊ����ȷ��
		assertEquals(1, ActivityController.activities.size());
		
		ActivityController.addActivity(loginActivity);
		// �����ٴ�ִ��addActivityʱ���������Ȼ��1�������ظ�����
		assertEquals(1, ActivityController.activities.size());
		
	}
	

	/**
	 * ��������ִ�����ʱִ�У����������������Դ���ͷ�
	 */
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}
	
}
