package org.jinq.jpa.transform;

import ch.epfl.labos.iu.orm.queryll2.symbolic.TypedValueVisitorException;
import jdk.internal.org.objectweb.asm.Type;
import org.jinq.jpa.jpqlquery.ColumnExpressions;
import org.jinq.jpa.jpqlquery.JPQLQuery;

// TODO: Creating a whole interface for handling arguments might be overkill. I'm not sure
//    how many variants there actually are

public interface SymbExArgumentHandler
{
   ColumnExpressions<?> handleArg(int argIndex, Type argType) throws TypedValueVisitorException;
   JPQLQuery<?> handleSubQueryArg(int argIndex, Type argType) throws TypedValueVisitorException;
   boolean checkIsInQueryStreamSource(int argIndex);
   ColumnExpressions<?> handleThisFieldRead(String name, Type argType) throws TypedValueVisitorException;
   JPQLQuery<?> handleSubQueryThisFieldRead(String name, Type argType) throws TypedValueVisitorException;
}
