package gts.weightd.Activities;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import gts.weightd.Adapters.ListAdapter;
import gts.weightd.Adapters.UserRecyclerAdapter;
import gts.weightd.DbHelper;
import gts.weightd.Listener;
import gts.weightd.R;

 import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

    public class UserListActivity extends AppCompatActivity implements Listener {
        RecyclerView recyclerView;
        DbHelper dbHelper;
        ListAdapter adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user_list);


            dbHelper = DbHelper.getInstance(getApplicationContext());

            recyclerView = (RecyclerView) findViewById(R.id.user_recycler_view);
            adapter = new ListAdapter(this, dbHelper.getAllUser());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

        }

        @Override
        public void onBackPressed() {
            super.onBackPressed();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        @Override
        public void nameToChnge(String name) {
            dbHelper.deleteRow(name);

            adapter = new ListAdapter(this, dbHelper.getAllUser());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }
