package ch.epfl.labos.iu.orm.queryll2.symbolic;

import jdk.internal.org.objectweb.asm.Handle;
import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.Type;

import java.util.List;

public class LambdaFactory extends TypedValue
{
   Handle lambdaMethod;
   List<TypedValue> capturedArgs;
   
   // TODO: Handle parameters passed in to the lambda 
   public LambdaFactory(Type functionalInterface, Handle lambdaMethod, List<TypedValue> capturedArgs)
   {
      super(functionalInterface);
      this.lambdaMethod = lambdaMethod;
      this.capturedArgs = capturedArgs;
   }
   
   public String toString()
   {
      return "LambdaFactory(" + lambdaMethod.getOwner() + "." 
            + lambdaMethod.getName() + lambdaMethod.getDesc() + ")";
   }

   public Handle getLambdaMethod()
   {
      return lambdaMethod;
   }
   
   public boolean isInvokeStatic()
   {
      return lambdaMethod.getTag() == Opcodes.H_INVOKESTATIC;
   }

   public boolean isInvokeVirtual()
   {
      return lambdaMethod.getTag() == Opcodes.H_INVOKEVIRTUAL;
   }

   public List<TypedValue> getCapturedArgs()
   {
      return capturedArgs;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = super.hashCode();
      result = prime * result
            + ((capturedArgs == null) ? 0 : capturedArgs.hashCode());
      result = prime * result
            + ((lambdaMethod == null) ? 0 : lambdaMethod.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;
      if (!super.equals(obj))
         return false;
      if (getClass() != obj.getClass())
         return false;
      LambdaFactory other = (LambdaFactory) obj;
      if (capturedArgs == null)
      {
         if (other.capturedArgs != null)
            return false;
      } else if (!capturedArgs.equals(other.capturedArgs))
         return false;
      return lambdaMethod == null
              ? other.lambdaMethod == null
              : lambdaMethod.equals(other.lambdaMethod);
   }
}
