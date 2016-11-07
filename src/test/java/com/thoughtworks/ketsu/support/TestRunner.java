package com.thoughtworks.ketsu.support;

import com.google.inject.AbstractModule;
import org.jongo.Jongo;
import org.junit.rules.TestRule;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestRunner extends InjectBasedRunner {

  @Inject
  Jongo jongo;

  public TestRunner(Class<?> klass) throws InitializationError {
    super(klass);
  }

  private final TestRule removeAllData = (base, description) -> new Statement() {

    @Override
    public void evaluate() throws Throwable {
      try {
        base.evaluate();
      } finally {
        jongo.getCollection("products").remove();
        jongo.getCollection("users").remove();
//        jongo.getCollection("orders").remove();
      }
    }
  };

  @Override
  protected List<AbstractModule> getModules() {
    return Arrays.asList(new AbstractModule() {

      @Override
      protected void configure() {
      }
    });
  }

  @Override
  protected List<TestRule> getTestRules(Object target) {
    List<TestRule> rules = new ArrayList<>();
    rules.add(removeAllData);
    rules.addAll(super.getTestRules(target));
    return rules;
  }
}
