package xdean.jex.log;


import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;

import org.apache.logging.log4j.spi.ExtendedLogger;
import org.junit.Test;
import org.slf4j.Logger;

import javassist.ClassPool;
import xdean.jex.log.impl.JulLog;
import xdean.jex.log.impl.Log4jLog;
import xdean.jex.log.impl.Slf4jLog;

public class LogTest implements Logable {

  private static final String SLF4J = Logger.class.getName();
  private static final String LOG4J = ExtendedLogger.class.getName();

  @Test
  public void testSlf4j() throws Exception {
    ClassLoader cl = new Loader(this.getClass().getClassLoader(), SLF4J);
    Class<?> lf = loadLogFactoryClass(cl);
    Log log = getLogFrom(lf);
    assertTrue(log instanceof Slf4jLog);
    testLog(log);
  }

  @Test
  public void testLog4j() throws Exception {
    ClassLoader cl = new Loader(this.getClass().getClassLoader(), LOG4J);
    Class<?> lf = loadLogFactoryClass(cl);
    Log log = getLogFrom(lf);
    assertTrue(log instanceof Log4jLog);
    testLog(log);
  }

  @Test
  public void testJul() throws Exception {
    ClassLoader cl = new Loader(this.getClass().getClassLoader(), null);
    Class<?> lf = loadLogFactoryClass(cl);
    Log log = getLogFrom(lf);
    assertTrue(log instanceof JulLog);
    testLog(log);
  }

  @Test
  public void testLogable() throws Exception {
    testLog(this);
  }

  /**
   * This method is to improve code coverage. We should get the log's output and compare to do the actual test.
   */
  public void testLog(Log log) {
    log.isTraceEnable();
    log.trace("msg");
    log.trace(() -> "msg");
    log.trace(new Exception());
    log.trace("msg %s", 1);
    log.trace("msg %d %d", 1, 2);
    log.trace("msg", new Exception());

    log.isDebugEnable();
    log.debug("msg");
    log.debug(() -> "msg");
    log.debug(new Exception());
    log.debug("msg %s", 1);
    log.debug("msg %d %d", 1, 2);
    log.debug("msg", new Exception());

    log.isInfoEnable();
    log.info("msg");
    log.info(() -> "msg");
    log.info(new Exception());
    log.info("msg %s", 1);
    log.info("msg %d %d", 1, 2);
    log.info("msg", new Exception());

    log.isWarnEnable();
    log.warn("msg");
    log.warn(() -> "msg");
    log.warn(new Exception());
    log.warn("msg %s", 1);
    log.warn("msg %d %d", 1, 2);
    log.warn("msg", new Exception());

    log.isErrorEnable();
    log.error("msg");
    log.error(() -> "msg");
    log.error(new Exception());
    log.error("msg %s", 1);
    log.error("msg %d %d", 1, 2);
    log.error("msg", new Exception());
  }

  private Class<?> loadLogFactoryClass(ClassLoader cl) throws Exception {
    return ClassPool.getDefault().get(LogFactory.class.getName()).toClass(cl, null);
  }

  private Log getLogFrom(Class<?> logFactory) throws Exception {
    Method fromMethod = logFactory.getMethod("from", String.class);
    return (Log) fromMethod.invoke(null, "test");
  }

  private final class Loader extends ClassLoader {
    private final String pass;

    private Loader(ClassLoader parent, String pass) {
      super(parent);
      this.pass = pass;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
      if (name.equals(SLF4J)) {
        if (pass == SLF4J) {
          return Logger.class;
        } else {
          throw new ClassNotFoundException(name);
        }
      } else if (name.equals(LOG4J)) {
        if (pass == LOG4J) {
          return ExtendedLogger.class;
        } else {
          throw new ClassNotFoundException(name);
        }
      }
      return super.loadClass(name);
    }
  }
}
