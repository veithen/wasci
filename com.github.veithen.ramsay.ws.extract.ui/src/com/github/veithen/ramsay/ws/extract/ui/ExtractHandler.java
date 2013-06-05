package com.github.veithen.ramsay.ws.extract.ui;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com.github.veithen.ramsay.ws.extract.ExtractionProject;

public class ExtractHandler extends AbstractHandler {
	public Object execute(ExecutionEvent event) throws ExecutionException {
	    IStructuredSelection selection = (IStructuredSelection)HandlerUtil.getActiveMenuSelectionChecked(event);
	    for (Iterator it = selection.iterator(); it.hasNext(); ) {
	        try {
	            IProject project = (IProject)it.next();
	            IFile outFile = project.getFile("wsconfig.xmi");
                ((ExtractionProject)project.getAdapter(ExtractionProject.class)).extract(outFile);
                outFile.refreshLocal(IResource.DEPTH_ONE, null);
            } catch (CoreException ex) {
                // TODO
                throw new ExecutionException("FAILED", ex);
            }
	    }
		return null;
	}
}
