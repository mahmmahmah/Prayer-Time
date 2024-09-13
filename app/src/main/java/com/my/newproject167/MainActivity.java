package com.my.newproject167;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.android.volley.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.HashMap;
import java.util.regex.*;
import net.alhazmy13.library.*;
import org.json.*;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.Locale;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
	
	int LOCATION_PERMISSION_REQUEST_CODE;
	TextView currentPrayerTimeTextView;
	TextView nextPrayerTimeTextView;
	private String time = "";
	TextView currentPrayerNameTextView;
	TextView nextPrayerNameTextView;
	TextView azanTimeTextView;
	TextView jamaatTimeTextView;
	private String API_ENDPOINT = "";
	LocationManager locationManager;
	private String d = "";
	private HashMap<String, Object> hostIP = new HashMap<>();
	private String City = "";
	private String Country = "";
	
	private LinearLayout linear1;
	private LinearLayout linear60;
	private LinearLayout linear2;
	private LinearLayout linear6;
	private LinearLayout linear23;
	private LinearLayout linear32;
	private ProgressBar progressbar1;
	private ImageView imageview1;
	private LinearLayout linear4;
	private ImageView imageview2;
	private TextView textview2;
	private LinearLayout linear5;
	private TextView textview1;
	private CardView cardview1;
	private LinearLayout linear9;
	private CardView cardview2;
	private LinearLayout linear8;
	private LinearLayout linear12;
	private LinearLayout linear13;
	private LinearLayout linear14;
	private LinearLayout linear15;
	private LinearLayout linear16;
	private TextView textview3;
	private TextView current_prayer_name_text_view;
	private TextView current_prayer_time_text_view;
	private TextView textview7;
	private TextView textview8;
	private LinearLayout linear11;
	private LinearLayout linear17;
	private LinearLayout linear18;
	private LinearLayout linear19;
	private LinearLayout linear20;
	private LinearLayout linear21;
	private LinearLayout linear22;
	private TextView textview9;
	private TextView next_prayer_name_text_view;
	private TextView next_prayer_time_text_view;
	private TextView textview13;
	private TextView azan_time_text_view;
	private TextView textview15;
	private TextView jamaat_time_text_view;
	private LinearLayout linear25;
	private LinearLayout linear24;
	private LinearLayout linear26;
	private LinearLayout linear27;
	private LinearLayout linear28;
	private LinearLayout linear29;
	private LinearLayout linear30;
	private TextView textview17;
	private TextView textview18;
	private LinearLayout linear31;
	private TextView textview20;
	private TextView textview19;
	private LinearLayout linear33;
	private LinearLayout linear56;
	private LinearLayout linear34;
	private LinearLayout linear36;
	private LinearLayout linear37;
	private LinearLayout linear39;
	private LinearLayout linear40;
	private LinearLayout linear42;
	private LinearLayout linear43;
	private LinearLayout linear45;
	private LinearLayout linear46;
	private LinearLayout linear57;
	private LinearLayout linear58;
	private LinearLayout linear59;
	private TextView country;
	private TextView city;
	private TextView fajrTextView;
	private LinearLayout linear35;
	private TextView fajrTimeTextView;
	private TextView dhuhrTextView;
	private LinearLayout linear38;
	private TextView dhuhrTimeTextView;
	private TextView asrTextView;
	private LinearLayout linear41;
	private TextView asrTimeTextView;
	private TextView maghribTextView;
	private LinearLayout linear44;
	private TextView maghribTimeTextView;
	private TextView ishaTextView;
	private LinearLayout linear47;
	private TextView ishaTimeTextView;
	
	private RequestNetwork gettime;
	private RequestNetwork.RequestListener _gettime_request_listener;
	private RequestNetwork Rr;
	private RequestNetwork.RequestListener _Rr_request_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear60 = findViewById(R.id.linear60);
		linear2 = findViewById(R.id.linear2);
		linear6 = findViewById(R.id.linear6);
		linear23 = findViewById(R.id.linear23);
		linear32 = findViewById(R.id.linear32);
		progressbar1 = findViewById(R.id.progressbar1);
		imageview1 = findViewById(R.id.imageview1);
		linear4 = findViewById(R.id.linear4);
		imageview2 = findViewById(R.id.imageview2);
		textview2 = findViewById(R.id.textview2);
		linear5 = findViewById(R.id.linear5);
		textview1 = findViewById(R.id.textview1);
		cardview1 = findViewById(R.id.cardview1);
		linear9 = findViewById(R.id.linear9);
		cardview2 = findViewById(R.id.cardview2);
		linear8 = findViewById(R.id.linear8);
		linear12 = findViewById(R.id.linear12);
		linear13 = findViewById(R.id.linear13);
		linear14 = findViewById(R.id.linear14);
		linear15 = findViewById(R.id.linear15);
		linear16 = findViewById(R.id.linear16);
		textview3 = findViewById(R.id.textview3);
		current_prayer_name_text_view = findViewById(R.id.current_prayer_name_text_view);
		current_prayer_time_text_view = findViewById(R.id.current_prayer_time_text_view);
		textview7 = findViewById(R.id.textview7);
		textview8 = findViewById(R.id.textview8);
		linear11 = findViewById(R.id.linear11);
		linear17 = findViewById(R.id.linear17);
		linear18 = findViewById(R.id.linear18);
		linear19 = findViewById(R.id.linear19);
		linear20 = findViewById(R.id.linear20);
		linear21 = findViewById(R.id.linear21);
		linear22 = findViewById(R.id.linear22);
		textview9 = findViewById(R.id.textview9);
		next_prayer_name_text_view = findViewById(R.id.next_prayer_name_text_view);
		next_prayer_time_text_view = findViewById(R.id.next_prayer_time_text_view);
		textview13 = findViewById(R.id.textview13);
		azan_time_text_view = findViewById(R.id.azan_time_text_view);
		textview15 = findViewById(R.id.textview15);
		jamaat_time_text_view = findViewById(R.id.jamaat_time_text_view);
		linear25 = findViewById(R.id.linear25);
		linear24 = findViewById(R.id.linear24);
		linear26 = findViewById(R.id.linear26);
		linear27 = findViewById(R.id.linear27);
		linear28 = findViewById(R.id.linear28);
		linear29 = findViewById(R.id.linear29);
		linear30 = findViewById(R.id.linear30);
		textview17 = findViewById(R.id.textview17);
		textview18 = findViewById(R.id.textview18);
		linear31 = findViewById(R.id.linear31);
		textview20 = findViewById(R.id.textview20);
		textview19 = findViewById(R.id.textview19);
		linear33 = findViewById(R.id.linear33);
		linear56 = findViewById(R.id.linear56);
		linear34 = findViewById(R.id.linear34);
		linear36 = findViewById(R.id.linear36);
		linear37 = findViewById(R.id.linear37);
		linear39 = findViewById(R.id.linear39);
		linear40 = findViewById(R.id.linear40);
		linear42 = findViewById(R.id.linear42);
		linear43 = findViewById(R.id.linear43);
		linear45 = findViewById(R.id.linear45);
		linear46 = findViewById(R.id.linear46);
		linear57 = findViewById(R.id.linear57);
		linear58 = findViewById(R.id.linear58);
		linear59 = findViewById(R.id.linear59);
		country = findViewById(R.id.country);
		city = findViewById(R.id.city);
		fajrTextView = findViewById(R.id.fajrTextView);
		linear35 = findViewById(R.id.linear35);
		fajrTimeTextView = findViewById(R.id.fajrTimeTextView);
		dhuhrTextView = findViewById(R.id.dhuhrTextView);
		linear38 = findViewById(R.id.linear38);
		dhuhrTimeTextView = findViewById(R.id.dhuhrTimeTextView);
		asrTextView = findViewById(R.id.asrTextView);
		linear41 = findViewById(R.id.linear41);
		asrTimeTextView = findViewById(R.id.asrTimeTextView);
		maghribTextView = findViewById(R.id.maghribTextView);
		linear44 = findViewById(R.id.linear44);
		maghribTimeTextView = findViewById(R.id.maghribTimeTextView);
		ishaTextView = findViewById(R.id.ishaTextView);
		linear47 = findViewById(R.id.linear47);
		ishaTimeTextView = findViewById(R.id.ishaTimeTextView);
		gettime = new RequestNetwork(this);
		Rr = new RequestNetwork(this);
		
		_gettime_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				d = _response;
				fajrTimeTextView.setText(d.substring((int)(d.indexOf("\"Fajr\":\"")), (int)(d.indexOf("\",\"Sunrise\":\""))).replace("\"Fajr\":\"", ""));
				dhuhrTimeTextView.setText(d.substring((int)(d.indexOf("\"Dhuhr\":\"")), (int)(d.indexOf("\",\"Asr\":\""))).replace("\"Dhuhr\":\"", ""));
				asrTimeTextView.setText(d.substring((int)(d.indexOf("\"Asr\":\"")), (int)(d.indexOf("\",\"Sunset\":\""))).replace("\"Asr\":\"", ""));
				maghribTimeTextView.setText(d.substring((int)(d.indexOf("\"Maghrib\":\"")), (int)(d.indexOf("\",\"Isha\":\""))).replace("\"Maghrib\":\"", ""));
				ishaTimeTextView.setText(d.substring((int)(d.indexOf("\"Isha\":\"")), (int)(d.indexOf("\",\"Imsak\":\""))).replace("\"Isha\":\"", ""));
				textview17.setText(d.substring((int)(d.indexOf("\"Sunrise\":\"")), (int)(d.indexOf("\",\"Dhuhr\":\""))).replace("\"Sunrise\":\"", ""));
				textview20.setText(d.substring((int)(d.indexOf("\"Imsak\":\"")), (int)(d.indexOf("\",\"Midnight\":\""))).replace("\"Imsak\":\"", ""));
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_Rr_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				hostIP = new Gson().fromJson(_response, new TypeToken<HashMap<String, Object>>(){}.getType());
				if (hostIP.get("status").toString().equals("success")) {
					City = hostIP.get("city").toString();
					Country = hostIP.get("country").toString();
					linear60.setVisibility(View.VISIBLE);
					gettime.startRequestNetwork(RequestNetworkController.GET, "http://api.aladhan.com/v1/timingsByCity?city=".concat(City.concat("&country=".concat(Country.concat("&method=8")))), "", _gettime_request_listener);
					city.setText(hostIP.get("city").toString());
					country.setText(hostIP.get("country").toString());
					linear60.setVisibility(View.GONE);
				}
				else {
					
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		Rr.startRequestNetwork(RequestNetworkController.GET, "http://ip-api.com/json/", "", _Rr_request_listener);
		getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
		
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w = this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.setNavigationBarColor(Color.parseColor("#fffcf9"));
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(Color.parseColor("#33000000"));
		}
		linear24.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)35, 0xFFFAF3EE));
		linear33.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)35, 0xFFFAF3EE));
		linear28.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)35, 0xFFF18F5C));
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		current_prayer_time_text_view.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 1);
		next_prayer_time_text_view.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 1);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/number.ttf"), 0);
		country.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/salesbold.ttf"), 0);
		city.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/number.ttf"), 0);
		textview9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/number.ttf"), 0);
		textview18.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/salesbold.ttf"), 0);
		textview19.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/salesbold.ttf"), 0);
		textview17.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/title.ttf"), 0);
		country.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/title.ttf"), 0);
		city.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/title.ttf"), 0);
		textview20.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/title.ttf"), 0);
		fajrTextView.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/salesbold.ttf"), 0);
		dhuhrTextView.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/salesbold.ttf"), 0);
		asrTextView.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/salesbold.ttf"), 0);
		maghribTextView.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/salesbold.ttf"), 0);
		ishaTextView.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/salesbold.ttf"), 0);
		fajrTimeTextView.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		dhuhrTimeTextView.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		asrTimeTextView.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		maghribTimeTextView.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		ishaTimeTextView.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bold.ttf"), 0);
		currentPrayerTimeTextView = findViewById(R.id.current_prayer_time_text_view);
		        currentPrayerNameTextView = findViewById(R.id.current_prayer_name_text_view);
		        nextPrayerTimeTextView = findViewById(R.id.next_prayer_time_text_view);
		        nextPrayerNameTextView = findViewById(R.id.next_prayer_name_text_view);
		        azanTimeTextView = findViewById(R.id.azan_time_text_view);
		        jamaatTimeTextView = findViewById(R.id.jamaat_time_text_view);
		
		        // Check and request location permission if not granted
		        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
		                != PackageManager.PERMISSION_GRANTED) {
			            ActivityCompat.requestPermissions(this,
			                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
			                    LOCATION_PERMISSION_REQUEST_CODE);
			        } else {
			            // Permission already granted, get prayer times
			            calculatePrayerTimes();
			        }
		    }
	
	    @Override
	    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
			            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
				                // Permission granted, get prayer times
				                calculatePrayerTimes();
				            } else {
				                Toast.makeText(this, "Location permission is required to get prayer times", Toast.LENGTH_SHORT).show();
				            }
			        }
		    }
	
	    private void calculatePrayerTimes() {
		        // You can set the location manually or use the device's location here
		        double latitude = 40.7128; // Example: New York City
		        double longitude = -74.0060;
		
		        PrayerTimesService.getPrayerTimes(this, latitude, longitude, new PrayerTimesService.PrayerTimesListener() {
			            @Override
			            public void onPrayerTimesReceived(JSONObject response) {
				                try {
					                    // Extract prayer times and names from the JSON response
					                    JSONObject data = response.getJSONObject("data");
					                    JSONObject timings = data.getJSONObject("timings");
					
					                    String fajrTime = timings.getString("Fajr");
					                    String dhuhrTime = timings.getString("Dhuhr");
					                    String asrTime = timings.getString("Asr");
					                    String maghribTime = timings.getString("Maghrib");
					                    String ishaTime = timings.getString("Isha");
					
					                    // Extract prayer names
					                    String fajrName = "Fajr";
					                    String dhuhrName = "Dhuhr";
					                    String asrName = "Asr";
					                    String maghribName = "Maghrib";
					                    String ishaName = "Isha";
					
					                    // Calculate the current time
					                    Calendar calendar = Calendar.getInstance();
					                    int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
					                    int currentMinute = calendar.get(Calendar.MINUTE);
					                    String currentTime = String.format(Locale.getDefault(), "%02d:%02d", currentHour, currentMinute);
					
					                    // Find the current and next prayer times and names
					                    String currentPrayerName = "";
					                    String nextPrayerName = "";
					                    String currentPrayerTime = "";
					                    String nextPrayerTime = "";
					
					                    if (currentTime.compareTo(fajrTime) < 0) {
						                        currentPrayerName = ishaName; // Set to the last prayer of the previous day
						                        nextPrayerName = fajrName;
						                        nextPrayerTime = fajrTime;
						                    } else if (currentTime.compareTo(dhuhrTime) < 0) {
						                        currentPrayerName = fajrName;
						                        nextPrayerName = dhuhrName;
						                        currentPrayerTime = fajrTime;
						                        nextPrayerTime = dhuhrTime;
						                    } else if (currentTime.compareTo(asrTime) < 0) {
						                        currentPrayerName = dhuhrName;
						                        nextPrayerName = asrName;
						                        currentPrayerTime = dhuhrTime;
						                        nextPrayerTime = asrTime;
						                    } else if (currentTime.compareTo(maghribTime) < 0) {
						                        currentPrayerName = asrName;
						                        nextPrayerName = maghribName;
						                        currentPrayerTime = asrTime;
						                        nextPrayerTime = maghribTime;
						                    } else if (currentTime.compareTo(ishaTime) < 0) {
						                        currentPrayerName = maghribName;
						                        nextPrayerName = ishaName;
						                        currentPrayerTime = maghribTime;
						                        nextPrayerTime = ishaTime;
						                    } else {
						                        currentPrayerName = ishaName;
						                        nextPrayerName = fajrName; // Set to the first prayer of the next day
						                        nextPrayerTime = fajrTime;
						                    }
					
					                    // Extract AM/PM from the times
					                    String currentAMPM = getAMPM(currentPrayerTime);
					                    String nextAMPM = getAMPM(nextPrayerTime);
					
					                    // Update the TextViews with current and next prayer times and names including am/pm
					                    currentPrayerTimeTextView.setText("" + currentPrayerTime + " " + currentAMPM);
					
					
					                    currentPrayerNameTextView.setText("" + currentPrayerName);
					
					
					
					textview8.setText("" + nextPrayerTime + " " + nextAMPM);
					
					                    nextPrayerTimeTextView.setText("" + nextPrayerTime + " " + nextAMPM);
					                    nextPrayerNameTextView.setText("" + nextPrayerName);
					
					                    // Get Azan and Jama'at times
					                    String azanTime = getAzanTime(nextPrayerTime);
					                    String jamaatTime = getJamaatTime(nextPrayerTime);
					
					                    // Extract AM/PM from the times
					                    String azanAMPM = getAMPM(azanTime);
					                    String jamaatAMPM = getAMPM(jamaatTime);
					
					                    // Update the TextViews for Azan and Jama'at times
					                    azanTimeTextView.setText("" + azanTime + " " + azanAMPM);
					                    jamaatTimeTextView.setText("" + jamaatTime + " " + jamaatAMPM);
					                } catch (JSONException e) {
					                    e.printStackTrace();
					                    Toast.makeText(MainActivity.this, "Error parsing JSON response", Toast.LENGTH_SHORT).show();
					                }
				            }
			
			            @Override
			            public void onError(String message)
			{ Toast.makeText(MainActivity.this, "Error: " + message, Toast.LENGTH_SHORT).show();
				       }
			  });
	}
	private String getAMPM(String time) {
		    // Extract the hour from the time
		    String[] timeParts = time.split(":");
		    if (timeParts.length == 2) {
			        int hour = Integer.parseInt(timeParts[0]);
			        return (hour >= 12) ? "pm" : "am";
			    }
		    return "am"; // Default to am
	}
	
	// Calculate Azan time based on the next prayer time
	private String getAzanTime(String nextPrayerTime) {
		    String[] timeParts = nextPrayerTime.split(":");
		    if (timeParts.length == 2) {
			        int hour = Integer.parseInt(timeParts[0]);
			        int minute = Integer.parseInt(timeParts[1]);
			
			        // Subtract some minutes from the next prayer time for Azan (e.g., 15 minutes)
			        minute -= 15;
			        if (minute < 0) {
				            // Borrow an hour if necessary
				            hour--;
				            minute += 60;
				        }
			
			        // Format the Azan time
			        return String.format(Locale.getDefault(), "%02d:%02d", hour, minute);
			    }
		
		    return "N/A"; // Return N/A if unable to calculate
	}
	
	// Calculate Jama'at time based on the next prayer time
	private String getJamaatTime(String nextPrayerTime) {
		    String[] timeParts = nextPrayerTime.split(":");
		    if (timeParts.length == 2) {
			        int hour = Integer.parseInt(timeParts[0]);
			        int minute = Integer.parseInt(timeParts[1]);
			
			        // Add some minutes to the next prayer time for Jama'at (e.g., 10 minutes)
			        minute += 10;
			        if (minute >= 60) {
				            // Carry an hour if necessary
				            hour++;
				            minute -= 60;
				        }
			
			        // Format the Jama'at time
			        return String.format(Locale.getDefault(), "%02d:%02d", hour, minute);
			    }
		
		    return "N/A";
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}