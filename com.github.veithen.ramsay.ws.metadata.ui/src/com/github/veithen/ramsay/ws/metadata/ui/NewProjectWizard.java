package com.github.veithen.ramsay.ws.metadata.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

import com.github.veithen.ramsay.ws.metadata.ProjectHelper;

public class NewProjectWizard extends Wizard implements INewWizard {
    private WizardNewProjectCreationPage page1;

    public NewProjectWizard() {
        setWindowTitle("New WebSphere Configuration Metadata Project");
    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addPages() {
        page1 = new WizardNewProjectCreationPage("basicNewProjectPage");
        page1.setTitle("WebSphere Configuration Metadata Project");
        page1.setDescription("Create a new project containing the configuration metadata model for a given WebSphere product and version");
        addPage(page1);
    }

    @Override
    public boolean performFinish() {
        try {
            ProjectHelper.createProject(page1.getProjectHandle(), null);
        } catch (CoreException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }
}
