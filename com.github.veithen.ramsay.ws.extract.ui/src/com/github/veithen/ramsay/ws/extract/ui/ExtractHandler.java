package com.github.veithen.ramsay.ws.extract.ui;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.statushandlers.StatusManager;

import com.github.veithen.ramsay.ws.extract.Constants;
import com.github.veithen.ramsay.ws.extract.ExtractionProject;

public class ExtractHandler extends AbstractHandler {
	public Object execute(ExecutionEvent event) throws ExecutionException {
	    IStructuredSelection selection = (IStructuredSelection)HandlerUtil.getActiveMenuSelectionChecked(event);
	    for (Iterator it = selection.iterator(); it.hasNext(); ) {
            IProject project = (IProject)it.next();
            IFile outFile = project.getFile("wsconfig.xmi");
            final ExtractionProject extractionProject = (ExtractionProject)project.getAdapter(ExtractionProject.class);
            try {
                PlatformUI.getWorkbench().getProgressService().busyCursorWhile(new IRunnableWithProgress() {
                    @Override
                    public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                        try {
                            extractionProject.extractRaw(monitor);
                        } catch (CoreException ex) {
                            throw new InvocationTargetException(ex);
                        }
                    }
                });
            } catch (InvocationTargetException ex) {
                Throwable cause = ex.getCause();
                IStatus status;
                if (cause instanceof CoreException) {
                    status = ((CoreException)cause).getStatus();
                } else {
                    status = new Status(IStatus.ERROR, Constants.PLUGIN_ID, "Extraction failed", cause);
                }
                StatusManager.getManager().handle(status, StatusManager.SHOW);
            } catch (InterruptedException ex) {
                return null;
            }
	    }
		return null;
	}
}
