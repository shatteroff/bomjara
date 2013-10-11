package com.example.ns;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

    EditText edt;
    Button button1;
    Button button2;
    TextView Textview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        edt = (EditText) findViewById (R.id.edt);
        button1 = (Button) findViewById (R.id.button1);
        button2 = (Button) findViewById (R.id.button2);
        Textview1 = (TextView) findViewById (R.id.textView1);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);



    }


    @Override
    public void onClick (View v){
        String	 name;
        Intent intent;
        String encodedHash = Uri.encode("#");
        int rar;
        long value1;
        String a;
        name = edt.getText().toString();
        int tab=name.length();
        rar=tab-10;
        a=name.substring(rar, tab);
        value1 = Long.parseLong(a);
                switch (v.getId()){
            case R.id.button1:
                Textview1.setText("*144*"+value1+"#");
                break;
            case R.id.button2:
                intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:*144*"+value1+encodedHash));
                startActivity(intent);
                break;

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub

        switch (item.getItemId()){
            case (R.id.exit):
                finish();
                break;
            case (R.id.about):
                Intent intent = new Intent(this, About.class);
                startActivity(intent);
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}