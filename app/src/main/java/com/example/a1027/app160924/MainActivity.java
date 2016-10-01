package com.example.a1027.app160924;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.a1027.app160924.Calcurator.CalcActivity;
import com.example.a1027.app160924.Member.LoginActivity;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // implements 기능 속성

    Button bt_calc, bt_contacts;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_calc = (Button) findViewById(R.id.bt_calc);  //xml과 연결
        bt_contacts = (Button) findViewById(R.id.bt_contacts);
        bt_calc.setOnClickListener(this);
        bt_contacts.setOnClickListener(this);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onClick(View v) {//res 화면의 리소스를 가져옴
        switch (v.getId()) {
            case R.id.bt_calc:
/*                Intent intent = new Intent(this.getApplicationContext(), CalcActivity.class);//메모리 상주개체를 가져오는경우
                //텍스트 상의 데이터는 .java로 호출
                //getApplicationContext 와 startActivity는 AppCompatActivity에포함되어 있어서 상속된것임
                //get*은 속성등 을 가져오는 경우에 사용한다. read only
                //ApplicationContext = Application상의 개제들(Context) 을 모두포함함
                //from(this.getApplicationContext()) to(CalcActivity.class) 기능으로 본다.
                //어플리케이션의 메서드를 calactivity로 가져온다
                //intent 는

                this.startActivity(intent);
*/
                startActivity(new Intent(MainActivity.this, CalcActivity.class));
                //intent 는 2회이상사용할때 직관적사유로 상기와 같이 만든다.
                break;
            case R.id.bt_contacts:
                Toast.makeText(MainActivity.this,"주소페이지 가기",Toast.LENGTH_LONG).show();
                //디버깅용
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
