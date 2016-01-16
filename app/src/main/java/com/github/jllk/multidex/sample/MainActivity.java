/*
 * Copyright (C) 2016 chentaov5@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jllk.multidex.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.github.jllk.multidex.sample.a.SampleActivityA;
import com.github.jllk.multidex.sample.b.SampleActivityB;
import com.github.jllk.multidex.sample.c.SampleActivityC;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnA = (Button) findViewById(R.id.btn_a);
        Button btnB = (Button) findViewById(R.id.btn_b);
        Button btnC = (Button) findViewById(R.id.btn_c);

        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        final int id = view.getId();
        Intent intent = null;
        if (id == R.id.btn_a) {
            intent = new Intent(this, SampleActivityA.class);
        } else if (id == R.id.btn_b) {
            intent = new Intent(this, SampleActivityB.class);
        } else if (id == R.id.btn_c) {
            intent = new Intent(this, SampleActivityC.class);
        }
        startActivity(intent);
    }
}
