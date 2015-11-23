package com.example.broadcastbestpractic.test;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
	// 在这里进行初始化操作，如界面加载与事件绑定
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (savedInstanceState != null) {
			// 恢复临时数据
			String tempData = savedInstanceState.getString("key");
			// ...
		}
	}

	// 在这里保存临时数据
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		// 设活动A->B，A处于停止状态，可能被系统回收，此时在Back键，依然会回到A，但是会调用A的onCreate方法而不是onRestart，临时数据将不再存在，如界面数据
		// 通过Bundle这个参数，可以将临时数据保存，各种put...;当A再被创建时，可以取出Bundle存的数据，进行相关操作，如上：
		String tempData = "this is  temp data";
		outState.putString("key", tempData);
	}

	// 重启调用，由停止状态变为运行状态
	@Override
	public void onRestart() {
		super.onRestart();
		// 当知道这个进程中的活动已经可见之后，载入改变
	}

	// 在可见生存期开始时调用
	@Override
	public void onStart() {
		super.onStart();
	}

	// 活动已准备好和用户交互——在返回栈栈顶
	@Override
	public void onResume() {
		super.onResume();
		// 据说：恢复活动所需要的任何暂停的UI更新、线程或者进程，但是当不活动的时候，就挂起它们
	}

	// 活动暂停时，活动依然可见，如此时弹出对话框，活动就处于暂停
	@Override
	public void onPause() {
		// 据说：当活动不是前台的活动状态的活动时，挂起不需要更新的UI更新、线程或者CPU密集的进程。
		super.onPause();
		// 即释放CPU资源，保存关键数据，但是动作一定得快，否则影响新栈顶活动
	}

	// 活动完全不可见
	@Override
	public void onStop() {
		// 据说：当进程不可见的时候，挂起不需要的剩下的UI更新、线程或者处理，保存所有的编辑或者
		// 状态改变，因为这个进程可能会被销毁(从而为其他进程释资源)
		super.onStop();
	}

	// 在完整生存期结束时调用
	@Override
	public void onDestroy() {
		// 清空所有的资源，包括结束线程、关闭数据库连接等。
		super.onDestroy();
	}

}