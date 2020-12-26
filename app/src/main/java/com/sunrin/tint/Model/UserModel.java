package com.sunrin.tint.Model;

import com.sunrin.tint.Filter;

import java.util.ArrayList;
import java.util.List;

public class UserModel {

    private String name, email, profile;
    private List<String> postID, storageID;
    private List<Filter> userFilters;

    public UserModel() {}

    // TODO: Add Profile Image
    public UserModel(String name, String email) {
        this.name = name;
        this.email = email;
        this.profile = null;
        postID = new ArrayList<>();
        storageID = new ArrayList<>();
        userFilters = new ArrayList<>();
    }

    public UserModel(String name, String email, List<String> postID, List<String> storageID, List<Filter> userFilters) {
        this.name = name;
        this.email = email;
        this.postID = postID;
        this.storageID = storageID;
        this.userFilters = userFilters;
    }

    // add IDs
    public void addPostID(String id) {
        this.postID.add(id);
    }

    public void addStorageID(String id) {
        this.storageID.add(id);
    }

    // delete IDs
    public void deletePostID(String id) {
        this.postID.remove(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public List<String> getPostID() {
        return postID;
    }

    public void setPostID(List<String> postID) {
        this.postID = postID;
    }

    public List<String> getStorageID() {
        return storageID;
    }

    public void setStorageID(List<String> storageID) {
        this.storageID = storageID;
    }

    public List<Filter> getUserFilters() {
        return userFilters;
    }

    public void setUserFilters(List<Filter> userFilters) {
        this.userFilters = userFilters;
    }
}
