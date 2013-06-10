package com.github.veithen.ramsay.ws.metadata;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

public final class Constants {
    public static final String PLUGIN_ID = "com.github.veithen.ramsay.ws.metadata";
    
    public static final IPath MODELS_PATH = new Path("models");
    
    public static final IPath TRANSFORMATIONS_PATH = new Path("transformations");
    
    public static final IPath TRANSFORMED_PATH = new Path("transformed");
    
    public static final IPath METADATA_FILE = new Path("wsconfig.ecore");
    
    private Constants() {}
}
