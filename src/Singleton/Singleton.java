package Singleton;

import java.util.HashMap;
import java.util.Map;

public final class Singleton {

  private static Map<String, Object> instances = new HashMap<String, Object>();

  public static void init(String instanceName, Object instance) {
    if (instances.get(instanceName) == null)
      instances.put(instanceName, instance);
    else
      instances.replace(instanceName, instance);
  }

  @SuppressWarnings("unchecked")
  public static <T> T getInstance(String instanceName) {
    if (instances.containsKey(instanceName)) {
      return (T) instances.get(instanceName);
    }
    return null;
  }
}
