package com.jql.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Registry {
    private static HashMap<String,Object> registry = new HashMap<>();
    public static  <T> T get(String key){
        return (T)registry.get(key);
    }

    public static HashMap<String, Object> getRegistry() {
        return registry;
    }

    static {
        registry.put("arrayList",new ArrayList<>());
        registry.put("hashSet",new HashSet<>());
        registry.put("hashMap",new HashMap<>());
    }

    public static void main(String[] args) {
//        ArrayList arrayList = Registry.get("arrayList");
        List arrayList = Registry.get("arrayList");

        HashSet hashSet = Registry.get("hashSet");
        HashMap hashMap = Registry.get("hashMap");
        System.out.println(arrayList.getClass());
        System.out.println(hashSet.getClass());
        System.out.println(hashMap.getClass());
        System.out.println("--------------------------");
        System.out.println(false||false&&true);
        System.out.println(true|false&false);
    }
}
