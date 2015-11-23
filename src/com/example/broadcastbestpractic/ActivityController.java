package com.example.broadcastbestpractic;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

/**
 * 活动控制器 1.添加活动 2.删除活动 3.销毁所有活动
 */
public class ActivityController {
	public static List<Activity> activities = new ArrayList<Activity>();

	public static void addActivity(Activity activity) {
		if (!activities.contains(activity)) {
			activities.add(activity);
		}
	}

	public static void removeActivity(Activity activity) {

		activities.remove(activity);
	}

	public static void finishAll() {
		for (Activity activity : activities) {
			activity.finish();
		}
	}
}
