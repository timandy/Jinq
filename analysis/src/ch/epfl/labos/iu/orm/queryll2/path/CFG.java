/**
 * 
 */
package ch.epfl.labos.iu.orm.queryll2.path;

import jdk.internal.org.objectweb.asm.tree.MethodNode;
import jdk.internal.org.objectweb.asm.tree.analysis.Analyzer;
import jdk.internal.org.objectweb.asm.tree.analysis.AnalyzerException;
import jdk.internal.org.objectweb.asm.tree.analysis.BasicInterpreter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

class CFG
{
   List<Integer> succsOf(int from)
   {
      return fromto.get(from);
   }
   
   Map<Integer, List<Integer>> fromto = new HashMap<Integer, List<Integer>>();
   CFG(String internalName, MethodNode m) throws AnalyzerException
   {
      Analyzer a = new Analyzer(new BasicInterpreter()){
         @Override protected void newControlFlowEdge(final int insn, final int successor) {
            if (!fromto.containsKey(insn))
               fromto.put(insn, new Vector<Integer>());
            fromto.get(insn).add(successor);
         }
      };
      a.analyze(internalName, m);
   }
}