package com.sunrin.tint.Util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class SharedPreferenceUtil {
    static final String PREF_USER_NAME = "user_name";
    static final String PREF_USER_EMAIL = "user_email";
    static final String PREF_FILTER = "filter";

    static SharedPreferences getSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    //*** set ***//
    public static void setPrefUsername(Context context, String userName) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(PREF_USER_NAME, userName).apply();
    }

    public static void setPrefUserEmail(Context context, String email) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(PREF_USER_EMAIL, email).apply();
    }

    public static void setPrefFilterBool(Context context, List<Boolean> booleans) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < booleans.size(); i++)
            jsonArray.put(booleans.get(i));

        if (!booleans.isEmpty())
            editor.putString(PREF_FILTER, jsonArray.toString());
        else
            editor.putString(PREF_FILTER, "");
        editor.apply();
    }

    //*** get ***//
    public static String getPrefUsername(Context context) {
        return getSharedPreferences(context).getString(PREF_USER_NAME, "");
    }

    public static String getPrefUserEmail(Context context) {
        return getSharedPreferences(context).getString(PREF_USER_EMAIL, "");
    }

    public static List<Boolean> getPrefFilterBool(Context context) {
        String s = getSharedPreferences(context).getString(PREF_FILTER, "");
        ArrayList<Boolean> arrayList = new ArrayList<>();
        if (s != null) {
            try {
                JSONArray jsonArray = new JSONArray(s);
                for (int i = 0; i < jsonArray.length(); i++) {
                    boolean b = jsonArray.optBoolean(i);
                    arrayList.add(b);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }
}
