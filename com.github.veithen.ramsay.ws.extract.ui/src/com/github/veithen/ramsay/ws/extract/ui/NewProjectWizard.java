package com.github.veithen.ramsay.ws.extract.ui;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

import com.github.veithen.ramsay.ws.extract.ProjectNature;

// TODO: use BasicNewProjectResourceWizard here
public class NewProjectWizard extends Wizard implements INewWizard {
    private WizardNewProjectCreationPage page1;

    public NewProjectWizard() {
        setWindowTitle("New WebSphere Configuration Extraction Project");
    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addPages() {
        page1 = new WizardNewProjectCreationPage("basicNewProjectPage");
        page1.setTitle("WebSphere Configuration Extraction Project");
        page1.setDescription("Create a new project to extract configuration data from a WebSphere stand-alone server or Network Deployment cell");
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
