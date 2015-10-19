package com.grabonrentcoffeelist;// TODO change pkg name before uploading

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Solution extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        findViewById(R.id.btnCoffee).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Solution.this, CoffeeList.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("test", "onActivityResult() resultCode:" + resultCode + " data:" + data);
        if (data != null && data.hasExtra("Order"))
            Toast.makeText(this, data.getStringExtra("Order") + " ordered.", Toast.
                    LENGTH_LONG).show();
        else
            Toast.makeText(this, "Nothing ordered!", Toast.LENGTH_LONG).show();
    }

}
