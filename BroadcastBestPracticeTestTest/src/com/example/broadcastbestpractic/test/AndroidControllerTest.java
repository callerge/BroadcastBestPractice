package com.example.broadcastbestpractic.test;

import com.example.broadcastbestpractic.ActivityController;
import com.example.broadcastbestpractic.LoginActivity;

import android.test.AndroidTestCase;
/**
 * 
 * BroadcastBestPractice中的AndroidController类测试用例.<br/>
 * 需要重写setUp和tearDown方法
 */
public class AndroidControllerTest extends AndroidTestCase {

	/**
	 * 测试用例调用前执行，可以在这里进行初始化操作
	 */
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}
	
	/**
	 * 在需要测试的方法前面加上test，系统就会自动测试该方法.</br>
	 * 通过assert进行断言.<br/>
	 * Run as Android JUit Test运行测试用例.<br/>
	 */
	public void testaddActivity(){
		// 断言activity结合的数量初始为0
		assertEquals(0, ActivityController.activities.size());
		LoginActivity loginActivity = new LoginActivity();
		ActivityController.addActivity(loginActivity);
		// 断言经过addActivity方法操作之后，活动个数增加成为1，被认为是正确的
		assertEquals(1, ActivityController.activities.size());
		
		ActivityController.addActivity(loginActivity);
		// 断言再次执行addActivity时，活动个数仍然是1，即不重复加载
		assertEquals(1, ActivityController.activities.size());
		
	}
	

	/**
	 * 测试用例执行完成时执行，可以在这里进行资源的释放
	 */
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}
	
}
