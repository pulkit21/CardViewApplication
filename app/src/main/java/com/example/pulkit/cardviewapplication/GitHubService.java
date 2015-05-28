package com.example.pulkit.cardviewapplication;

import java.util.List;

import retrofit.http.GET;

/**
 * Created by pulkit on 5/28/15.
 */
public interface GitHubService {
    @GET("/users")
    public List<User> getUser();
}
