package edu.uci.ccai6;

import java.util.Map;

import alias.Util;
import soot.PackManager;
import soot.Scene;
import soot.SceneTransformer;
import soot.SootClass;
import soot.Transform;
import soot.options.Options;
import soot.util.Chain;

public class Slicer extends SceneTransformer{
	private static Slicer __slicer;
	@Override
	protected void internalTransform(String arg0, Map arg1) {
		// TODO Auto-generated method stub
		System.out.println("Slicing starts!");
		Chain<SootClass> classChain = Scene.v().getApplicationClasses();
		
		// First we do the intra-analysis for each class, should return some useful information, and then combine them together
		for (SootClass aClass : classChain) {
			InterSlicer interS = new InterSlicer(aClass);
		}
	}
	public static Slicer v() {
		__slicer = __slicer == null ? new Slicer() : __slicer;
		return __slicer;
	}
	public static void main(String[] args) {
		Slicer slicer = Slicer.v();
		
		String phaseName = "wjtp.slicer";
		Transform t = new Transform(phaseName, slicer);
		PackManager.v().getPack("wjtp").add(t);
		
		System.setProperty("MayAlias", "spa");
		boolean isPaddle = Util.MAY_ALIAS.equals("paddle");
		//String classpath = "C:\\Program Files\\Java\\jdk1.8.0_65\\jre\\lib\\"; // Windows
		String classFolder = "./test";
		String mainClass = "IntraTest3";
		//classpath = classpath.replaceAll("\\", "/");
		
		Options.v().set_whole_program(true);
		Options.v().setPhaseOption("cg", "enabled:false");
		Options.v().setPhaseOption("wjpp", "enabled:false");
		Options.v().setPhaseOption("wjap", "enabled:false");
		
		Options.v().setPhaseOption("jap", "enabled:false");
		Options.v().setPhaseOption("jb", "use-original-names:true");
		
		Options.v().set_keep_line_number(true);
		Options.v().set_output_format(Options.output_format_jimple);
		
		//Important: you need to add rt.jar of jre to your CLASSPATH
		Options.v().set_prepend_classpath(true);
		
		/**args should be in the following format: "-cp path_of_classes_analyzed class_names"
		 * e.g., -cp E:\Workspace\ws_program\taintanalysis\bin\ InterTest HelloWorld
		 */
		String[] args2 = {"-cp", classFolder, "-main-class", mainClass, mainClass};
		soot.Main.main(args2);
	}
	
}
