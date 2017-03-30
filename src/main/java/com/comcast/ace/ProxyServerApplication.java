package com.comcast.ace;

import com.comcast.ace.resources.BaseResource;
import io.dropwizard.Application;
import io.dropwizard.jetty.setup.ServletEnvironment;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.proxy.ProxyServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletRegistration;

/**
 * Created by rbaker216 on 3/30/17.
 */
public class ProxyServerApplication extends Application<ProxyServerConfiguration> {
    public static void main(String[] args) throws Exception {
        System.out.println("Inside Main class");
        new ProxyServerApplication().run(args);
    }

    @Override
    public String getName() {
        return "proxy-server-test";
    }

    @Override
    public void initialize(final Bootstrap<ProxyServerConfiguration> bootstrap) {

    }


    @Override
    public void run(ProxyServerConfiguration config, Environment environment) throws Exception {
        System.out.println("Inside run method of application");
        final BaseResource baseResource = new BaseResource();
        environment.jersey().register(baseResource);

        addProxyServlets(config, environment);
    }

    void addProxyServlets(ProxyServerConfiguration configuration, Environment environment) {
        int[] idx = {0};
        configuration.proxy.forEach(p -> addProxyServlet(environment.servlets(), "ProxyServlet-" + (idx[0]++), p.prefix, p.proxyTo));
    }

    void addProxyServlet(ServletEnvironment servlets, String servletName, String prefix, String proxyTo) {
        System.out.println("Adding " + servletName + ": " + prefix + " -> " + proxyTo);

//        ServletRegistration.Dynamic servlet = servlets.addServlet(servletName, ProxyServlet.Transparent.class);
        ServletRegistration.Dynamic servlet = servlets.addServlet(servletName, new ProxyServlet.Transparent());
        servlet.setInitParameter("prefix", prefix);
        servlet.setInitParameter("proxyTo", proxyTo);
        servlet.addMapping(prefix + "/*");
    }
}
