package org.jinq.jpa.transform;

import ch.epfl.labos.iu.orm.queryll2.symbolic.TypedValueVisitorException;
import jdk.internal.org.objectweb.asm.Type;
import org.jinq.jpa.jpqlquery.JPQLQuery;
import org.jinq.jpa.jpqlquery.SelectOnly;

/**
 * Handles the lookup of parameters passed to a lambda. Parameters can
 * be used to represent query parameters or references to the data stream.
 * This class handles the lookup of a data stream of the result of a 
 * Select..From..Where query.
 */
public class AggregateStreamLambdaArgumentHandler extends LambdaParameterArgumentHandler
{
   SelectOnly<?> select;
   
   public AggregateStreamLambdaArgumentHandler(SelectOnly<?> select, LambdaAnalysis lambda, MetamodelUtil metamodel, SymbExArgumentHandler parentArgumentScope, boolean hasInQueryStreamSource)
   {
      super(lambda, metamodel, parentArgumentScope, hasInQueryStreamSource);
      this.select = select;
   }
   
   @Override
   protected JPQLQuery<?> handleLambdaSubQueryArg(int argIndex, Type argType) 
         throws TypedValueVisitorException
   {
      if (argIndex == 0)
         return select;
      throw new TypedValueVisitorException("Lambda trying to access unknown lambda parameter");
   }
}
