package xdean.jex.log;

/**
 * Convenient interface to get {@link Log} in instance methods. We don't need to define LOGGER any more.
 * 
 * Previously you may use the following code:
 * 
 * <pre>
 * <code>
 * class A {
 *   public static final Log LOGGER = LogFactory.from(A.class);
 *   
 *   public void func(){
 *     LOGGER.debug("log");
 *   }
 * }
 * </code>
 * </pre>
 * 
 * Now use {@link Logable}, you can do:
 * 
 * <pre>
 * <code>
 * class A implements Logable {
 *   public void func(){
 *     log().debug("log");
 *   }
 * }
 * </code>
 * </pre>
 * 
 * @author Dean Xu (XDean@github.com)
 */
public interface Logable extends Log {
  default Log log() {
    return LogFactory.from(this);
  }

  @Override
  default SubLog trace() {
    return log().trace();
  }

  @Override
  default SubLog debug() {
    return log().debug();
  }

  @Override
  default SubLog info() {
    return log().info();
  }

  @Override
  default SubLog warn() {
    return log().warn();
  }

  @Override
  default SubLog error() {
    return log().error();
  }
}
