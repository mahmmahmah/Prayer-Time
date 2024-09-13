package com.my.newproject167;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class PrayerTimesService {

    private static final String BASE_URL = "https://api.aladhan.com/v1/timings";

    public interface PrayerTimesListener {
        void onPrayerTimesReceived(JSONObject response);

        void onError(String message);
    }

    public static void getPrayerTimes(Context context, double latitude, double longitude, final PrayerTimesListener listener) {
        String url = BASE_URL + "?latitude=" + latitude + "&longitude=" + longitude + "&method=2"; // Adjust method as needed

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Pass the JSON response to the listener
                        listener.onPrayerTimesReceived(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("PrayerTimesService", "API Error: " + error.getMessage());
                        listener.onError("API Error: " + error.getMessage());
                    }
                });

        // Add the request to the queue
        Volley.newRequestQueue(context).add(request);
    }
}