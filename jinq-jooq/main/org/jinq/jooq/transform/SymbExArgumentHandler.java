package org.jinq.jooq.transform;

import ch.epfl.labos.iu.orm.queryll2.symbolic.TypedValueVisitorException;
import jdk.internal.org.objectweb.asm.Type;
import org.jinq.jooq.querygen.ColumnExpressions;

// TODO: Creating a whole interface for handling arguments might be overkill. I'm not sure
//    how many variants there actually are

public interface SymbExArgumentHandler
{
   ColumnExpressions<?> handleArg(int argIndex, Type argType) throws TypedValueVisitorException;
}
