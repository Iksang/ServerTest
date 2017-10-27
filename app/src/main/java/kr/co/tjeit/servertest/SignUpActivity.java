package kr.co.tjeit.servertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUpActivity extends AppCompatActivity {

    private android.widget.EditText idEdt;
    private android.widget.EditText pwEdt;
    private android.widget.EditText nameEdt;
    private android.widget.RadioButton man;
    private android.widget.Button signUpBtn;
    private RadioButton woman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.woman = (RadioButton) findViewById(R.id.woman);
        this.signUpBtn = (Button) findViewById(R.id.signUpBtn);
        this.man = (RadioButton) findViewById(R.id.man);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
        final int genderValue = man.isChecked() ? 0 : 1;
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServerUtil.sign_up(SignUpActivity.this,
                        idEdt.getText().toString(),
                        pwEdt.getText().toString(),
                        nameEdt.getText().toString(),
                        genderValue,
                        new ServerUtil.JsonResponseHandler() {
                            @Override
                            public void onResponse(JSONObject json) {
                                try {
                                    String message = json.getString("message");
                                    Toast.makeText(SignUpActivity.this, message, Toast.LENGTH_SHORT).show();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
            }
        });

    }
}
