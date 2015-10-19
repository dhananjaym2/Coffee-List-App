package com.grabonrentcoffeelist;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CoffeeList extends ListActivity {

    String[] arrCoffeeMenu;
    private final String LOG_TAG = CoffeeList.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        Log.d(LOG_TAG, "in onCreate()");

        //TODO: Get the coffeeMenu from resources and populate them onto the ListView

        arrCoffeeMenu = getResources().getStringArray(R.array.coffeeMenu);
        Log.d(LOG_TAG, "arrCoffeeMenu.length:" + arrCoffeeMenu.length);

        ArrayAdapter<String> mListAdapter = new ArrayAdapter<String>(this,
                R.layout.list_item, R.id.textCoffeeName, arrCoffeeMenu);

        setListAdapter(mListAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO: Display the current selection
        Log.d(LOG_TAG, "arrCoffeeMenu[position]:" + arrCoffeeMenu[position]);

        Intent mIntent = new Intent();
        mIntent.putExtra("Order", arrCoffeeMenu[position]);

        setResult(RESULT_OK, mIntent);

        this.finish();
    }
}