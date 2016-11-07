package com.thoughtworks.ketsu.support;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

public class ApiForTest extends ResourceConfig {
  public ApiForTest() {
    property(org.glassfish.jersey.server.ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true);
    packages("com.thoughtworks.ketsu.web");
    register(new AbstractBinder() {
      @Override
      protected void configure() {
      }
    });
  }
}
