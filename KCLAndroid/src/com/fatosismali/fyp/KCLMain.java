package com.fatosismali.fyp;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class KCLMain extends Activity {
    /** Called when the activity is first created. */
	 StringBuilder sb;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://itza.dnsdojo.net:3000/viewers");
       
        try {
            
        	
        	sb = new StringBuilder();
        	sb.append("<?xml version='1.0' encoding='UTF-8' ?>");
        	sb.append("<viewer>");
        	sb.append("<year type='integer'>12</year>");
        	sb.append("<bluetoothid>43:62:34:12:39:GA</bluetoothid>");
        	sb.append("<course>TSP</course>");
        	sb.append("<email>Chirag@thecarpenter.com</email>");
        	sb.append("<name>Chirag Desai</name>");
        	sb.append("</viewer>");
        	
        	StringEntity entity = new StringEntity(sb.toString(), "UTF-8");
       
            httppost.setEntity(entity);
            httppost.addHeader("Accept","application/xml");
            httppost.addHeader("Content-Type","application/xml");
            
            // Execute HTTP Post Request
            HttpResponse response = httpclient.execute(httppost);
            Log.e("fatos","" + response.getStatusLine());
	    // Edited the KCLMain.java file            
            
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
        	Log.e("ClientProtocolException: ", "erroroooooooooooooooooooooooooo");
        } catch (IOException e) {
            // TODO Auto-generated catch block
        	Log.e("IOEXception: ", "erroroooooooooooooooooooooooooo");
        	
        }

        
    }
}
