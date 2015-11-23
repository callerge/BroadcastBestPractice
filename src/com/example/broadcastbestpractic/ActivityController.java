package com.example.broadcastbestpractic;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

/**
 * ������� 1.��ӻ 2.ɾ��� 3.�������л
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
