package com.ptp.phamtanphat.volleyjsonarrayrequest0208;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ReadJsonArrayRequest("https://khoapham.vn/KhoaPhamTraining/json/tien/demo4.json");
    }

    private void ReadJsonArrayRequest(final String url) {
        final RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
               for (int i = 0 ; i< response.length();i++){
                   try {
                       JSONObject jsonObject = response.getJSONObject(i);

                       String khoahoc = "";
                       if (jsonObject.has("khoahoc")){
                           khoahoc = jsonObject.optString("khoahoc");
                       }

                        String hocphi = jsonObject.getString("hocphi");

                       Log.d("BBB","Khoa hoc " + khoahoc);
                       Log.d("BBB","Hoc phi " + hocphi);
                   } catch (JSONException e) {
                       e.printStackTrace();
                   }
               }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}
