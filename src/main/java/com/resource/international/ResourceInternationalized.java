/**
* ClassName : ResourceInternationalized.java
* Create on : 2016年8月15日
* Author : guanfl
* Email : guanfl@ifeng.com
* Copyright 2016 ifeng.com All Rights Reserved
*/
package com.resource.international;

import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

public class ResourceInternationalized {
    // how to use resourceBundle to get international information;
    public static void main(String[] args) {
        //使用指定的基本名称、默认的语言环境和资源包基本名称，来获取资源包；
        ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n/messages"/*,new Locale("en")*/);
        /// ResourceBundleMessageSource resourceBundleMessageSource;
        String email = resourceBundle.getString("LOGIN_FAIL");//根据指定的key获取国际化数据
        System.out.println(email);
    }
}

// default (English language, United States)
class MyResources extends ResourceBundle {
    public Object handleGetObject(String key) {
        if (key.equals("okKey"))
            return "Ok";
        if (key.equals("cancelKey"))
            return "Cancel";
        return null;
    }

    public Enumeration<String> getKeys() {
        return Collections.enumeration(keySet());
    }

    // Overrides handleKeySet() so that the getKeys() implementation
    // can rely on the keySet() value.
    protected Set<String> handleKeySet() {
        return new HashSet<String>(Arrays.asList("okKey", "cancelKey"));
    }
}

// German language
class MyResources_de extends MyResources {
    public Object handleGetObject(String key) {
        // don't need okKey, since parent level handles it.
        if (key.equals("cancelKey"))
            return "Abbrechen";
        return null;
    }

    protected Set<String> handleKeySet() {
        return new HashSet<String>(Arrays.asList("cancelKey"));
    }
}
