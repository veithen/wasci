package com.github.veithen.ramsay.ws.extract;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

public final class Constants {
    public static final String PLUGIN_ID = "com.github.veithen.ramsay.ws.extract";
    
    public static final IPath RAW_PATH = new Path("raw");
    
    public static final IPath TRANSFORMED_PATH = new Path("transformed");
    
    /**
     * The name of the preferences node where the project configuration is stored.
     */
    public static final String PREFERENCES_NODE = PLUGIN_ID;

    /**
     * The key for the preference that specifies the WebSphere host.
     */
    public static final String PREF_HOST = "host";
    
    /**
     * The key for the preference that specifies the WebSphere SOAP connector port.
     */
    public static final String PREF_PORT = "port";
    
    /**
     * The key for the preference that specifies the user name for the connection to WebSphere.
     */
    public static final String PREF_USERNAME = "username";
    
    /**
     * The key for the preference that specifies the password for the connection to WebSphere.
     */
    public static final String PREF_PASSWORD = "password";
    
    private Constants() {}
}
