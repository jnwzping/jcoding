package hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * hashMap 遍历的方式
 */
public class main {

  public static void main(String[] args) {
    HashMap<String, String> hashMap = new HashMap();
    hashMap.put("key_11", "value_11");
    hashMap.put("key_12", "value_12");
    hashMap.put("key_13", "value_13");
    hashMap.put("key_14", "value_14");

    Iterator<Entry<String, String>> iterable = hashMap.entrySet().iterator();

    //第一种遍历方式
    while (iterable.hasNext()) {
      Entry entry = iterable.next();
      System.out.println(entry.getKey() + "" + "" + entry.getValue());
    }

    //第二种遍历方式
    hashMap.forEach((key, value) -> {
      System.out.println(key + "-" + value);
    });

    //第三种遍历方式
    for (Map.Entry entry : hashMap.entrySet()) {
      System.out.println(entry.getKey() + "-" + "-" + entry.getValue());
    }

    //遍历key
    for (String key : hashMap.keySet()) {
      System.out.println("key = " + key);
    }

    //遍历key
    for (String key : hashMap.values()) {
      System.out.println("value = " + key);
    }

  }

}
