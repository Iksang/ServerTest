package kr.co.tjeit.servertest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends BaseActivity {

    private android.widget.Button serverBtn;
    private Button signUpBtn;
    private android.widget.EditText idEdt;
    private android.widget.EditText pwEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();
        setupEvents();
        setValues();



    }

    @Override
    public void setupEvents() {
        serverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServerUtil.sign_in(LoginActivity.this,idEdt.getText().toString(),pwEdt.getText().toString(), new ServerUtil.JsonResponseHandler() {
                    @Override
                    public void onResponse(JSONObject json) {
                        try {
                            String message = json.getString("message");
                            Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
        this.signUpBtn = (Button) findViewById(R.id.signUpBtn);
        this.serverBtn = (Button) findViewById(R.id.serverBtn);

    }
}
