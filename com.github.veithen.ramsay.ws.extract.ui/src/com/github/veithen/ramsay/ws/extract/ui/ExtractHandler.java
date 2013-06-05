package com.github.veithen.ramsay.ws.extract.ui;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
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
                ((ExtractionProject)project.getAdapter(ExtractionProject.class)).extract(project.getFile("wsconfig.xmi"));
            } catch (CoreException ex) {
                // TODO
                throw new ExecutionException("FAILED", ex);
            }
	    }
		return null;
	}
}