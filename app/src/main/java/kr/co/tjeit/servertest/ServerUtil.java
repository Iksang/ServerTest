package kr.co.tjeit.servertest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;



/**
 * Created by KJ_Studio on 2015-12-24.
 */
public class ServerUtil {

    private static final String TAG = ServerUtil.class.getSimpleName();

    private final static String BASE_URL = "http://13.125.39.162/"; // 라이브서버

    public interface JsonResponseHandler {
        void onResponse(JSONObject json);
    }


    // 사용자 관련 함수 모음

//     회원 가입
    public static void test(final Context context, final JsonResponseHandler handler) {
        String url = BASE_URL+"mobile/hello_json";
        //		String registrationId = ContextUtil.getRegistrationId(context);

        Map<String, String> data = new HashMap<String, String>();



        AsyncHttpRequest.post(context, url,  data, true, new AsyncHttpRequest.HttpResponseHandler() {

            @Override
            public boolean onPrepare() {
                return true;
            }

            @Override
            public void onResponse(String response) {
                System.out.println(response);
                try {
                    JSONObject json = new JSONObject(response);

                    if (handler != null)
                        handler.onResponse(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFinish() {

            }

            @Override
            public void onCancelled() {

            }

        });
    }


    public static void sign_up(final Context context,
                               final String user_id,
                               final String user_pw,
                               final String name,
                               final int gender,
                               final JsonResponseHandler handler) {
        String url = BASE_URL+"mobile/sign_up";
        //		String registrationId = ContextUtil.getRegistrationId(context);

        Map<String, String> data = new HashMap<String, String>();
        data.put("user_id",user_id);
        data.put("user_pw",user_pw);
        data.put("name",name);
        data.put("gender",gender+"");

        AsyncHttpRequest.post(context, url,  data, true, new AsyncHttpRequest.HttpResponseHandler() {

            @Override
            public boolean onPrepare() {
                return true;
            }

            @Override
            public void onResponse(String response) {
                System.out.println(response);
                try {
                    JSONObject json = new JSONObject(response);

                    if (handler != null)
                        handler.onResponse(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFinish() {

            }

            @Override
            public void onCancelled() {

            }

        });
    }


    public static void sign_in(final Context context,
                               final String user_id,
                               final String user_pw,
                               final JsonResponseHandler handler) {
        String url = BASE_URL+"mobile/sign_in";
        //		String registrationId = ContextUtil.getRegistrationId(context);

        Map<String, String> data = new HashMap<String, String>();
        data.put("user_id",user_id);
        data.put("user_pw",user_pw);

        AsyncHttpRequest.post(context, url,  data, true, new AsyncHttpRequest.HttpResponseHandler() {

            @Override
            public boolean onPrepare() {
                return true;
            }

            @Override
            public void onResponse(String response) {
                System.out.println(response);
                try {
                    JSONObject json = new JSONObject(response);

                    if (handler != null)
                        handler.onResponse(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFinish() {

            }

            @Override
            public void onCancelled() {

            }

        });
    }

}
