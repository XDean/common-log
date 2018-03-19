package xdean.jex.log.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.spi.ExtendedLogger;
import org.apache.logging.log4j.spi.LoggerContext;

import xdean.jex.log.Log;

public class Log4jLog implements Log {

  private static final LoggerContext LOGGER_CONTEXT = LogManager.getContext(Log4jLog.class.getClassLoader(), false);

  private final ExtendedLogger logger;

  public Log4jLog(String name) {
    this.logger = LOGGER_CONTEXT.getLogger(name);
  }

  @Override
  public SubLog trace() {
    return new Log4jSubLog(Level.TRACE);
  }

  @Override
  public SubLog debug() {
    return new Log4jSubLog(Level.DEBUG);
  }

  @Override
  public SubLog info() {
    return new Log4jSubLog(Level.INFO);
  }

  @Override
  public SubLog warn() {
    return new Log4jSubLog(Level.WARN);
  }

  @Override
  public SubLog error() {
    return new Log4jSubLog(Level.ERROR);
  }

  private class Log4jSubLog implements SubLog {
    private final Level level;

    public Log4jSubLog(Level level) {
      this.level = level;
    }

    @Override
    public boolean isEnable() {
      return logger.isEnabled(level);
    }

    @Override
    public void log(String msg) {
      logger.log(level, msg);
    }

    @Override
    public void log(String msg, Object param1) {
      logger.log(level, msg, param1);
    }

    @Override
    public void log(String msg, Object... params) {
      logger.log(level, msg, params);
    }

    @Override
    public void log(String msg, Throwable thrown) {
      logger.log(level, msg, thrown);
    }

  }
}
