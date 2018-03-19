package xdean.jex.log.impl;

import java.util.function.Supplier;

import xdean.jex.log.Log;
import xdean.jex.log.Log.SubLog;

public class NoLog implements Log, SubLog {

  @Override
  public SubLog trace() {
    return this;
  }

  @Override
  public SubLog debug() {
    return this;
  }

  @Override
  public SubLog info() {
    return this;
  }

  @Override
  public SubLog warn() {
    return this;
  }

  @Override
  public SubLog error() {
    return this;
  }

  @Override
  public boolean isEnable() {
    return false;
  }

  @Override
  public void log(String msg) {
  }

  @Override
  public void log(Supplier<String> msgSupplier) {
  }

  @Override
  public void log(String msg, Object param1) {
  }

  @Override
  public void log(String msg, Object... params) {
  }

  @Override
  public void log(String msg, Throwable thrown) {
  }
}
