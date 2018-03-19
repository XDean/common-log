package xdean.jex.log.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import xdean.jex.log.Log;

public class JulLog implements Log {
  private final Logger logger;

  public JulLog(String name) {
    this.logger = Logger.getLogger(name);
  }

  @Override
  public SubLog trace() {
    return new JulSubLog(Level.FINEST);
  }

  @Override
  public SubLog debug() {
    return new JulSubLog(Level.FINER);
  }

  @Override
  public SubLog info() {
    return new JulSubLog(Level.INFO);
  }

  @Override
  public SubLog warn() {
    return new JulSubLog(Level.WARNING);
  }

  @Override
  public SubLog error() {
    return new JulSubLog(Level.SEVERE);
  }

  private class JulSubLog implements SubLog {
    private final Level level;

    public JulSubLog(Level level) {
      this.level = level;
    }

    @Override
    public boolean isEnable() {
      return logger.isLoggable(level);
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
