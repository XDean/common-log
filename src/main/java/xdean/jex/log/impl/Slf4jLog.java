package xdean.jex.log.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xdean.jex.log.Log;

public class Slf4jLog implements Log {

  private final Logger logger;

  public Slf4jLog(String name) {
    logger = LoggerFactory.getLogger(name);
  }

  @Override
  public SubLog trace() {
    return new SubLog() {
      @Override
      public boolean isEnable() {
        return logger.isTraceEnabled();
      }

      @Override
      public void log(String msg) {
        logger.trace(msg);
      }

      @Override
      public void log(String msg, Throwable thrown) {
        logger.trace(msg, thrown);
      }

      @Override
      public void log(String msg, Object param1) {
        logger.trace(msg, param1);
      }

      @Override
      public void log(String msg, Object... params) {
        logger.trace(msg, params);
      }
    };
  }

  @Override
  public SubLog debug() {
    return new SubLog() {
      @Override
      public boolean isEnable() {
        return logger.isDebugEnabled();
      }

      @Override
      public void log(String msg) {
        logger.debug(msg);
      }

      @Override
      public void log(String msg, Throwable thrown) {
        logger.debug(msg, thrown);
      }

      @Override
      public void log(String msg, Object param1) {
        logger.debug(msg, param1);
      }

      @Override
      public void log(String msg, Object... params) {
        logger.debug(msg, params);
      }
    };
  }

  @Override
  public SubLog info() {
    return new SubLog() {
      @Override
      public boolean isEnable() {
        return logger.isInfoEnabled();
      }

      @Override
      public void log(String msg) {
        logger.info(msg);
      }

      @Override
      public void log(String msg, Throwable thrown) {
        logger.info(msg, thrown);
      }

      @Override
      public void log(String msg, Object param1) {
        logger.info(msg, param1);
      }

      @Override
      public void log(String msg, Object... params) {
        logger.info(msg, params);
      }
    };
  }

  @Override
  public SubLog warn() {
    return new SubLog() {
      @Override
      public boolean isEnable() {
        return logger.isWarnEnabled();
      }

      @Override
      public void log(String msg) {
        logger.warn(msg);
      }

      @Override
      public void log(String msg, Throwable thrown) {
        logger.warn(msg, thrown);
      }

      @Override
      public void log(String msg, Object param1) {
        logger.warn(msg, param1);
      }

      @Override
      public void log(String msg, Object... params) {
        logger.warn(msg, params);
      }
    };
  }

  @Override
  public SubLog error() {
    return new SubLog() {
      @Override
      public boolean isEnable() {
        return logger.isErrorEnabled();
      }

      @Override
      public void log(String msg) {
        logger.error(msg);
      }

      @Override
      public void log(String msg, Throwable thrown) {
        logger.error(msg, thrown);
      }

      @Override
      public void log(String msg, Object param1) {
        logger.error(msg, param1);
      }

      @Override
      public void log(String msg, Object... params) {
        logger.error(msg, params);
      }
    };
  }
}
