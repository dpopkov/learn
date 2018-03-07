package com.wrox.csupport.utils;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

public class HttpSessionUtils {
    public static String toString(HttpSession session) {
        StringBuilder builder = new StringBuilder();
        builder.append("Session ");
        builder.append(session.getId());
        builder.append(" [");
        Enumeration<String> attributeNames = session.getAttributeNames();
        String name;
        if (attributeNames.hasMoreElements()) {
            name = attributeNames.nextElement();
            builder.append(name);
            builder.append("=");
            builder.append(session.getAttribute(name).toString());
        }
        while (attributeNames.hasMoreElements()) {
            builder.append(", ");
            name = attributeNames.nextElement();
            builder.append(name);
            builder.append("=");
            builder.append(session.getAttribute(name).toString());
        }
        builder.append("]");
        return builder.toString();
    }
}
