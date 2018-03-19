package xdean.jex.log;

import xdean.jex.log.impl.JulLog;
import xdean.jex.log.impl.Log4jLog;
import xdean.jex.log.impl.NoLog;
import xdean.jex.log.impl.Slf4jLog;

/**
 * Class to provide common {@link Log} lookup methods. Auto adapt to founded Log framework.
 * 
 * @see LogImpl
 * 
 * @author dxu
 *
 */
public enum LogFactory {
  ;

  private static final LogImpl LOG_IMPL;
  static {
    ClassLoader cl = LogFactory.class.getClassLoader();
    LogImpl impl = LogImpl.JUL;
    try {
      cl.loadClass("org.slf4j.Logger");
      impl = LogImpl.SLF4J;
    } catch (ClassNotFoundException e) {
      try {
        cl.loadClass("org.apache.logging.log4j.spi.ExtendedLogger");
        impl = LogImpl.LOG4J;
      } catch (ClassNotFoundException e1) {
      }
    }
    LOG_IMPL = impl;
  }

  /**
   * Supported Log framework.
   */
  public enum LogImpl {
    SLF4J, LOG4J, JUL
  }

  /**
   * Get {@link Log} from given object.
   */
  public static Log from(Object o) {
    return from(o.getClass());
  }

  /**
   * Get {@link Log} from given class.
   */
  public static Log from(Class<?> clz) {
    return from(clz.getName());
  }

  /**
   * Get {@link Log} from given name.
   */
  public static Log from(String name) {
    if (LOG_IMPL == LogImpl.SLF4J) {
      return new Slf4jLog(name);
    } else if (LOG_IMPL == LogImpl.LOG4J) {
      return new Log4jLog(name);
    } else if (LOG_IMPL == LogImpl.JUL) {
      return new JulLog(name);
    } else {
      return new NoLog();
    }
  }
}
