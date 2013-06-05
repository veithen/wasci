package com.github.veithen.ramsay.ws.metadata.ui;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

import com.github.veithen.ramsay.ws.metadata.ProjectNature;

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
        IProject project = page1.getProjectHandle();
        IProjectDescription desc = project.getWorkspace().newProjectDescription(project.getName());
        desc.setLocationURI(project.getLocationURI());
        try {
            project.create(desc, null);
            project.open(null);
            // Now set the project nature. Note that if we do that before project creation, then
            // the builder will not be configured.
            desc = project.getDescription();
            desc.setNatureIds(new String[] { ProjectNature.ID });
            project.setDescription(desc, null);
        } catch (CoreException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }
}
