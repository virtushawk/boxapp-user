package com.virtushawk.boxappuser.model.dto;

import java.util.List;

public class UserDataBulkRequest {

   private List<String> usernames;

    public List<String> getUsernames() {
        return usernames;
    }

    public void setUsernames(List<String> usernames) {
        this.usernames = usernames;
    }
}
