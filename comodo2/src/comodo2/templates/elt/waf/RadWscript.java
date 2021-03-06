package comodo2.templates.elt.waf;

import comodo2.queries.QClass;
import comodo2.queries.QInterface;
import comodo2.queries.QPackage;
import comodo2.utils.FilesHelper;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

public class RadWscript implements IGenerator {
	
	private static final Logger mLogger = Logger.getLogger(comodo2.engine.Main.class);
	
	@Inject
	private QClass mQClass;

	@Inject
	private QInterface mQInterface;

	@Inject
	private QPackage mQPackage;

	@Inject
	private FilesHelper mFilesHelper;

	/**
	 * Transform <<cmdoModule>> UML package containing <<cmdoComponent>> UML Class
	 * into the WAF wscript file for RAD applications.
	 */
	@Override
	public void doGenerate(final Resource input, final IFileSystemAccess fsa) {
		/*
		Iterable<org.eclipse.uml2.uml.Class> _filter = Iterables.<org.eclipse.uml2.uml.Class>filter(IteratorExtensions.<EObject>toIterable(input.getAllContents()), org.eclipse.uml2.uml.Class.class);
		for (final org.eclipse.uml2.uml.Class c : _filter) {
			if (mQClass.isToBeGenerated(c)) {
				String ifModules = "";
				for (final Interface i : c.allRealizedInterfaces()) {
					if (mQInterface.hasRequests(i)) {
						ifModules = (ifModules + mQInterface.getContainerPackage(i).getName() + "-cxx ");
					}
				}
				String filename = mQClass.getContainerPackage(c).getName() + "/wscript";
				mFilesHelper.makeBackup(mFilesHelper.toAbsolutePath(filename));
				fsa.generateFile(filename, this.generate(mQClass.getContainerPackage(c).getName(), mQPackage.getContainerPackage(mQClass.getContainerPackage(c)).getName(), c.getName(), ifModules));
				return;
			}
		}
		*/
		final TreeIterator<EObject> allContents = input.getAllContents();
		while (allContents.hasNext()) {
			EObject e = allContents.next();
			if (e instanceof org.eclipse.uml2.uml.Class) {
				org.eclipse.uml2.uml.Class c = (org.eclipse.uml2.uml.Class)e; 
				if (mQClass.isToBeGenerated(c)) {
					String ifModules = "";
					for (final Interface i : c.allRealizedInterfaces()) {
						if (mQInterface.hasRequests(i)) {
							ifModules = (ifModules + mQInterface.getContainerPackage(i).getName() + "-cxx ");
						}
					}
					String filename = mQClass.getContainerPackage(c).getName() + "/wscript";
					mFilesHelper.makeBackup(mFilesHelper.toAbsolutePath(filename));
					fsa.generateFile(filename, this.generate(mQClass.getContainerPackage(c).getName(), mQPackage.getContainerPackage(mQClass.getContainerPackage(c)).getName(), c.getName(), ifModules));
					return;
				}
			}
		}
	}

	public CharSequence generate(final String moduleName, final String parentName, final String appName, final String ifModulesName) {
		try {
			STGroup g = new STGroupFile("resources/tpl/EltRadWaf.stg");
			ST st = g.getInstanceOf("WscriptAppl");
			st.add("moduleName", moduleName);
			st.add("parentName", parentName);			
			st.add("appName", appName);			
			st.add("ifModulesName", ifModulesName);			
			return st.render();
		} catch(Throwable throwable) {
			mLogger.error("Generating wscript file for " + moduleName + " module (" + throwable.getMessage() + ").");			
		}
		return "";		
	}
}
