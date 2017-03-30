package com.comcast.ace.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by rbaker216 on 3/30/17.
 */
public class BaseModel {
    private long id;

    public BaseModel() {

    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public void setId(long id) {
        this.id = id;
    }
}
