package com.comcast.ace;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbaker216 on 3/30/17.
 */
public class ProxyServerConfiguration extends Configuration {
    @JsonProperty
    List<Proxy> proxy = new ArrayList<>();

    public static class Proxy {
        public String prefix;
        public String proxyTo;
    }
}
