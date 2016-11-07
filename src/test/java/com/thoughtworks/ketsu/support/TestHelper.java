package com.thoughtworks.ketsu.support;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestHelper {


  public static Map<String, Object> productMap() {
    return new HashMap<String, Object>() {{
      put("name", "desk");
      put("description", "black");
      put("price", 611);
    }};
  }

  public static Map<String, Object> userMap() {
    return new HashMap<String, Object>() {{
      put("name", "firstUser");
    }};
  }

  public static Map<String, Object> orderMap(ObjectId productId) {
    return new HashMap<String, Object>() {{
      put("name", "firstOrder");
      put("address", "Beijing");
      put("phone", "13099999999");
      put("order_items", orderItemMapList(productId));
    }};
  }
//
  public static List<Map<String, Object>> orderItemMapList(ObjectId productId) {
    Map<String, Object> item = new HashMap<String, Object>() {{
      put("product_id", productId.toString());
      put("quantity", 2);
    }};

    return new ArrayList<Map<String, Object>>() {{
      add(item);
    }};
  }

  public static Map<String, Object> paymentMap() {
    return new HashMap<String, Object>() {{
      put("pay_type", "CASH");
      put("amount", 1400);
    }};
  }
}
