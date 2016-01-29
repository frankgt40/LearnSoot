package edu.uci.ccai6;

import java.util.List;

import soot.PatchingChain;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.UnitBox;
import soot.jimple.Stmt;
import soot.toolkits.graph.BriefUnitGraph;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.pdg.PDGNode;
import soot.util.Chain;

public class InterSlicer {
	private DirectedGraph<PDGNode> __graph;

	final SootClass __class;
	public InterSlicer(SootClass  cls) {
		__class = cls;
		//__graph = new DirectedGraph<PDGNode>;
		doInterSlicing();
	}
	public void doInterSlicing() {
		List<SootMethod> methods = __class.getMethods();
		for (SootMethod method : methods) {
			sliceInMethod(method);
		}
	}
	public void sliceInMethod(SootMethod method) {
		BriefUnitGraph graph = new BriefUnitGraph(method.getActiveBody());
		System.out.println("In method: " + method.toString());
		System.out.println("BriefUnitGraph: " );
		
//		PatchingChain<Unit> units = method.getActiveBody().getUnits();
//		for (Unit oneLine : units) {
//			Stmt statement = (Stmt)oneLine;
//			if (statement.containsFieldRef()) {
//				System.out.println("\tREF: " + statement.toString());
//			} else if (statement.containsInvokeExpr()) {
//				System.out.println("\tInvoke: " + statement.toString());
//			} 
//
//			System.out.println("Statement " + statement.toString() + " used: " + statement.getUseBoxes());
//			List<UnitBox> lub = statement.getBoxesPointingToThis();
//			System.out.println("List of pointing to this boxes: " + statement.toString() );
//			for (UnitBox ub : lub) {
//				System.out.println("\t" + ub.toString());
//			}
//			
//		}
	}
}
