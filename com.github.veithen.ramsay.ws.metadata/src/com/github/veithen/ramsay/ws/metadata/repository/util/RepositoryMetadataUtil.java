package com.github.veithen.ramsay.ws.metadata.repository.util;

public final class RepositoryMetadataUtil {
    private RepositoryMetadataUtil() {}
    
    public static String toIdentifier(String name, boolean startWithUpper) {
        int len = name.length();
        StringBuilder buffer = new StringBuilder(len);
        boolean upperNext = startWithUpper;
        for (int i=0; i<len; i++) {
            char c = name.charAt(i);
            if (c == '-') {
                upperNext = true;
            } else {
                if (upperNext) {
                    c = Character.toUpperCase(c);
                    upperNext = false;
                }
                buffer.append(c);
            }
        }
        return buffer.toString();
    }
}
