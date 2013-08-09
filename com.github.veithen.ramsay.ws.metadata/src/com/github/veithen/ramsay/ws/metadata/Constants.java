package com.github.veithen.ramsay.ws.metadata;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

public final class Constants {
    public static final String PLUGIN_ID = "com.github.veithen.ramsay.ws.metadata";
    
    public static final String METADATA_EXTENSIONS_ID = "com.github.veithen.ramsay.ws.metadata.metadataExtensions";
    
    public static final IPath RAW_PATH = new Path("raw");
    
    public static final IPath TRANSFORMATIONS_PATH = new Path("transformations");
    
    public static final IPath TRANSFORMED_PATH = new Path("transformed");
    
    /**
     * The name of the preferences node where the project configuration is stored.
     */
    public static final String PREFERENCES_NODE = PLUGIN_ID;
    
    /**
     * The key for the preference that specifies the WebSphere installation directory.
     */
    public static final String PREF_INSTALL_DIR = "installDir";
    
    /**
     * The key for the preference that specifies the WebSphere profile directory.
     */
    public static final String PREF_PROFILE_DIR = "profileDir";
    
    private Constants() {}
}
