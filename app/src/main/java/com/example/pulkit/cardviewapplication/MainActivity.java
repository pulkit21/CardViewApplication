package com.example.pulkit.cardviewapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import retrofit.RestAdapter;


public class MainActivity extends AppCompatActivity {

    RecyclerView rvGitUser;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter adapter;
    List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        rvGitUser = (RecyclerView) findViewById(R.id.rvGitUser);
        rvGitUser.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        rvGitUser.setLayoutManager(mLayoutManager);
        users = new ArrayList<>();
        adapter = new GitUserAdapter(getBaseContext(), users);
        rvGitUser.setAdapter(adapter);
        new FetchUserTask().execute();
    }

    public class FetchUserTask extends AsyncTask<Void, Void, List<User>> {

        @Override
        protected List<User> doInBackground(Void... params) {
            RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://api.github.com").build();
            GitHubService gitHubService= restAdapter.create(GitHubService.class);
            return gitHubService.getUser();
        }

        @Override
        protected void onPostExecute(List<User> userList) {
            users.addAll(userList);
            adapter.notifyDataSetChanged();
        }
    }


}
