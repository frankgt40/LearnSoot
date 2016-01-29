package edu.uci.ccai6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import edu.osu.cse.pa.Main;
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
	private BriefUnitGraph __graph;
	final SootClass __class;
	private PrintWriter __out;
	private int __node = 0;
	private SootMethod __currMtd;
	public InterSlicer(SootClass  cls) {
		__class = cls;
		//__graph = new DirectedGraph<PDGNode>;
		try {

			String file = "sootOutput/graph.gv";
			__out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
			__out.println("digraph G {\n");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		doInterSlicing();
		__out.println("\n}");
		__out.flush();
		__out.close();
	}
	public void doInterSlicing() {
		List<SootMethod> methods = __class.getMethods();
//		for (SootMethod method : methods) {
//			sliceInMethod(method);
//		}
		SootMethod method = methods.get(0);
		__currMtd = method;
		sliceInMethod(method);
	}
	public String printGraph(Unit curr, int depth) {
		if (__graph.getSuccsOf(curr).isEmpty() ) 
			return null;
		String rsl = "";
		List<Unit> successor = __graph.getSuccsOf(curr);
		for (Unit one : successor) {
			String name = one.toString();
			for (int n = 0; n < depth; n++) rsl += '\t';
			rsl += name + "\n";
			
			String tmpRSL = printGraph(one, depth+1);
			if (tmpRSL != null) rsl += tmpRSL; 
		}
		return rsl;
	}
	public void convertGraphToPNG(Unit curr, int node) {
		if (__graph.getSuccsOf(curr).isEmpty() ) 
			return;
		List<Unit> ul = __graph.getSuccsOf(curr);
		Main maa = Main.v();
		for (Unit one : ul) {
			String rsl = "";
			int currNode = getANewNode();
			rsl = new Integer(currNode).toString() + " [label=\"" + one.toString() + "\"];";
			__out.println(rsl);
			rsl = new Integer(node).toString() + " -> " + new Integer(currNode).toString() + ";";
			__out.println(rsl);
			convertGraphToPNG(one, currNode); 
			rsl = maa.mayAlias(one.getUseBoxes().iterator().next(), __currMtd, curr.getUseBoxes().iterator().next(), __currMtd) ? "YES" : "NO";
		}
		
	}
	public int getANewNode() {
		return __node++;
	}
	public void sliceInMethod(SootMethod method) {
		__graph = new BriefUnitGraph(method.getActiveBody());
		System.out.println("In method: " + method.toString());
		System.out.println("BriefUnitGraph: " );
		
		String rsl = "";
		int depth = 1;
		for (Unit heads : __graph.getHeads()) {
			rsl += heads.toString() + "\n";
			rsl += printGraph(heads, depth);
			
			convertGraphToPNG(heads, getANewNode());
		}
		System.out.println("Graph: \n" + rsl);
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
