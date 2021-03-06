package comodo2.templates.elt.yaml;

import com.google.common.collect.Iterables;
import comodo2.queries.QClass;
import comodo2.queries.QInterface;
import comodo2.queries.QSignal;
import comodo2.queries.QStereotype;
import comodo2.queries.QTransition;
import comodo2.utils.FilesHelper;
import comodo2.utils.SignalComparator;

import java.util.TreeSet;

import javax.inject.Inject;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;

public class RadEv implements IGenerator {
	@Inject
	private QClass mQClass;

	@Inject
	private QTransition mQTransition;

	@Inject
	private QStereotype mQStereotype;

	@Inject
	private QSignal mQSignal;

	@Inject
	private QInterface mQInterface;

	@Inject
	private Types mTypes;

	@Inject
	private FilesHelper mFilesHelper;

	/**
	 * Transform UML State Machine associated to a class (classifier behavior)
	 * into an RAD Events DSL.
	 */
	@Override
	public void doGenerate(final Resource input, final IFileSystemAccess fsa) {
		/*
		Iterable<org.eclipse.uml2.uml.Class> _filter = Iterables.<org.eclipse.uml2.uml.Class>filter(IteratorExtensions.<EObject>toIterable(input.getAllContents()), org.eclipse.uml2.uml.Class.class);
		for (final org.eclipse.uml2.uml.Class e : _filter) {
			if (mQClass.isToBeGenerated(e)) {
				for (final Interface i : e.allRealizedInterfaces()) {
					mFilesHelper.makeBackup(mFilesHelper.toAbsolutePath(mFilesHelper.toRadEvFilePath(i.getName())));
					fsa.generateFile(mFilesHelper.toRadEvFilePath(i.getName()), this.generate(e, i));
				}
			}
		}
		*/
		final TreeIterator<EObject> allContents = input.getAllContents();
		while (allContents.hasNext()) {
			EObject e = allContents.next();
			if (e instanceof org.eclipse.uml2.uml.Class) {
				org.eclipse.uml2.uml.Class c = (org.eclipse.uml2.uml.Class)e; 
				if (mQClass.isToBeGenerated(c)) {
					for (final Interface i : c.allRealizedInterfaces()) {
						mFilesHelper.makeBackup(mFilesHelper.toAbsolutePath(mFilesHelper.toRadEvFilePath(i.getName())));
						fsa.generateFile(mFilesHelper.toRadEvFilePath(i.getName()), this.generate(c, i));
					}
				}
			}
		}
	}

	public CharSequence generate(final org.eclipse.uml2.uml.Class c, final Interface i) {
		StringConcatenation str = new StringConcatenation();
		str.append("# Events definitions for " + c.getName() + " application." + StringConcatenation.DEFAULT_LINE_DELIMITER);
		str.append("version: \"1.0\"" + StringConcatenation.DEFAULT_LINE_DELIMITER);
		str.append("namespace: " + i.getName() + StringConcatenation.DEFAULT_LINE_DELIMITER);
		if (mQInterface.hasRequests(i)) {
			str.append("includes:" + StringConcatenation.DEFAULT_LINE_DELIMITER);
			str.append("    " + "- boost/exception_ptr.hpp" + StringConcatenation.DEFAULT_LINE_DELIMITER);
			str.append("    " + "- rad/mal/request.hpp" + StringConcatenation.DEFAULT_LINE_DELIMITER);
			str.append("    " + "- " + mFilesHelper.title(mQInterface.getContainerPackage(i).getName()) + ".hpp" + StringConcatenation.DEFAULT_LINE_DELIMITER);
		}
		str.newLine();
		str.append("events:" + StringConcatenation.DEFAULT_LINE_DELIMITER);
		str.append("    " + exploreEvents(getAllSignals(i), mQInterface.getContainerPackage(i).getName()), "    ");
		str.newLine();
		return str;
	}

	/**
	 * This function finds all signals of an Interfaces.
	 */
	public TreeSet<Signal> getAllSignals(final Interface i) {
		TreeSet<Signal> allSignals = new TreeSet<Signal>(new SignalComparator());
		/*
		final Function1<Reception, String> _function = (Reception e) -> {
			return e.getName();
		};
		List<Reception> _sortBy = IterableExtensions.<Reception, String>sortBy(i.getOwnedReceptions(), _function);
		for (final Reception r : _sortBy) {
			allSignals.add(r.getSignal());
		}
		*/
		for (final Reception r : i.getOwnedReceptions()) {
			allSignals.add(r.getSignal());
		}
		
		return allSignals;
	}

	/**
	 * This function finds all signals of the class's realized Interfaces.
	 */
	public TreeSet<Signal> getAllSignals(final org.eclipse.uml2.uml.Class c) {
		TreeSet<Signal> allSignals = new TreeSet<Signal>(new SignalComparator());
		/*
		final Function1<Interface, Boolean> _function = (Interface e) -> {
			return Boolean.valueOf(mQInterface.isToBeGenerated(e));
		};
		Iterable<Interface> _filter = IterableExtensions.<Interface>filter(c.allRealizedInterfaces(), _function);
		for (final Interface i : _filter) {
			final Function1<Reception, String> _function_1 = (Reception e) -> {
				return e.getName();
			};
			List<Reception> _sortBy = IterableExtensions.<Reception, String>sortBy(i.getOwnedReceptions(), _function_1);
			for (final Reception r : _sortBy) {
				allSignals.add(r.getSignal());
			}
		}
		*/
		for (final Interface i : c.allRealizedInterfaces()) {
			if (mQInterface.isToBeGenerated(i)) {
				for (final Reception r : i.getOwnedReceptions()) {
					allSignals.add(r.getSignal());
				}
			}
		}
		return allSignals;
	}

	/**
	 * This function finds all signals of a State Machine.
	 */
	public TreeSet<Signal> getAllSignals(final StateMachine sm) {
		TreeSet<Signal> allSignals = new TreeSet<Signal>(new SignalComparator());
		Iterable<Transition> _filter = Iterables.<Transition>filter(sm.allOwnedElements(), Transition.class);
		for (final Transition t : _filter) {
			if (mQTransition.getFirstEvent(t) != null) {
				allSignals.add(mQTransition.getFirstEvent(t));
			}
		}
		return allSignals;
	}

	/**
	 * Looks for events in the state machine.
	 */
	public CharSequence exploreEvents(final TreeSet<Signal> allSignals, final String ifModName) {
		StringConcatenation str = new StringConcatenation();
		for(final Signal s : allSignals) {
			str.append(mQSignal.nameWithoutPrefix(s) + ":" + StringConcatenation.DEFAULT_LINE_DELIMITER);
			if ((mQStereotype.isComodoCommand(((Element) s)) && mQSignal.hasReply(s))) {
				str.append("    " + "payload: " + explorePayload(s, ifModName), "    ");
				str.newLineIfNotEmpty();
			}
			str.append("    " + "doc: event documentation to be added" + StringConcatenation.DEFAULT_LINE_DELIMITER);
		}
		return str;
	}

	public CharSequence explorePayload(final Signal s, final String ifModName) {
		StringConcatenation str = new StringConcatenation();
		if (mQSignal.hasParam(s)) {
			str.append(printPayload(mQSignal.isReplyTypePrimitive(s), mTypes.typeName(mQSignal.getReplyType(s)), mQSignal.isFirstParamTypePrimitive(s), mTypes.typeName(mQSignal.getFirstParamType(s)), ifModName));
		} else {
			str.append(printPayload(mQSignal.isReplyTypePrimitive(s), mTypes.typeName(mQSignal.getReplyType(s)), false, "", ifModName));
		}
		str.newLineIfNotEmpty();
		return str;
	}

	public CharSequence printPayload(final boolean isReplyTypePrimitive, final String replyTypeName, final boolean isParamTypePrimitive, final String paramTypeName, final String ifModName) {
		String str = "rad::cii::Request<";
		if (replyTypeName.isEmpty() == false) {
			if (isReplyTypePrimitive) {
				str += replyTypeName;
			} else {
				str += "std::shared_ptr<" + ifModName + "::" + replyTypeName + ">";
			}
		}
		if (paramTypeName.isEmpty() == false) {
			str += ", ";
			if (isParamTypePrimitive) {
				str += paramTypeName;
			} else {
				str += "std::shared_ptr<" + ifModName + "::" + paramTypeName + ">";
			}
		}
		str += ">";
		return str;
	}
}
