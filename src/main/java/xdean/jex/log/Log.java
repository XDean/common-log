package xdean.jex.log;

import java.util.function.Supplier;

/**
 * A common log interface
 * <p>
 * There are 5 logging levels used by <code>Log</code> are (from fine to serious):
 * <ol>
 * <li>trace</li>
 * <li>debug</li>
 * <li>info</li>
 * <li>warn</li>
 * <li>error</li>
 * </ol>
 * 
 * @author Dean Xu (XDean@github.com)
 *
 */
public interface Log {

  /**
   * Get {@link SubLog} of trace level.
   */
  SubLog trace();

  /**
   * Is trace logging enabled.
   * 
   * @see SubLog#isEnable()
   */
  default boolean isTraceEnable() {
    return trace().isEnable();
  }

  /**
   * @see SubLog#log(String)
   */
  default void trace(String msg) {
    trace().log(msg);
  }

  /**
   * @see SubLog#log(Supplier)
   */
  default void trace(Supplier<String> msgSupplier) {
    trace().log(msgSupplier);
  }

  /**
   * @see SubLog#log(String, Object)
   */
  default void trace(String msg, Object param1) {
    trace().log(msg, param1);
  }

  /**
   * @see SubLog#log(String, Object...)
   */
  default void trace(String msg, Object... params) {
    trace().log(msg, params);
  }

  /**
   * @see SubLog#log(String, Throwable)
   */
  default void trace(String msg, Throwable thrown) {
    trace().log(msg, thrown);
  }

  /**
   * @see SubLog#log(Throwable)
   */
  default void trace(Throwable thrown) {
    trace().log(thrown);
  }

  /**
   * Get {@link SubLog} of debug level.
   */
  SubLog debug();

  /**
   * Is debug logging enabled.
   * 
   * @see SubLog#isEnable()
   */
  default boolean isDebugEnable() {
    return debug().isEnable();
  }

  /**
   * @see SubLog#log(String)
   */
  default void debug(String msg) {
    debug().log(msg);
  }

  /**
   * @see SubLog#log(Supplier)
   */
  default void debug(Supplier<String> msgSupplier) {
    debug().log(msgSupplier);
  }

  /**
   * @see SubLog#log(String, Object)
   */
  default void debug(String msg, Object param1) {
    debug().log(msg, param1);
  }

  /**
   * @see SubLog#log(String, Object...)
   */
  default void debug(String msg, Object... params) {
    debug().log(msg, params);
  }

  /**
   * @see SubLog#log(String, Throwable)
   */
  default void debug(String msg, Throwable thrown) {
    debug().log(msg, thrown);
  }

  /**
   * @see SubLog#log(Throwable)
   */
  default void debug(Throwable thrown) {
    debug().log(thrown);
  }

  /**
   * Get {@link SubLog} of info level.
   */
  SubLog info();

  /**
   * Is info logging enabled.
   * 
   * @see SubLog#isEnable()
   */
  default boolean isInfoEnable() {
    return info().isEnable();
  }

  /**
   * @see SubLog#log(String)
   */
  default void info(String msg) {
    info().log(msg);
  }

  /**
   * @see SubLog#log(Supplier)
   */
  default void info(Supplier<String> msgSupplier) {
    info().log(msgSupplier);
  }

  /**
   * @see SubLog#log(String, Object)
   */
  default void info(String msg, Object param1) {
    info().log(msg, param1);
  }

  /**
   * @see SubLog#log(String, Object...)
   */
  default void info(String msg, Object... params) {
    info().log(msg, params);
  }

  /**
   * @see SubLog#log(String, Throwable)
   */
  default void info(String msg, Throwable thrown) {
    info().log(msg, thrown);
  }

  /**
   * @see SubLog#log(Throwable)
   */
  default void info(Throwable thrown) {
    info().log(thrown);
  }

  /**
   * Get {@link SubLog} of warn level.
   */
  SubLog warn();

  /**
   * Is warn logging enabled.
   * 
   * @see SubLog#isEnable()
   */
  default boolean isWarnEnable() {
    return warn().isEnable();
  }

  /**
   * @see SubLog#log(String)
   */
  default void warn(String msg) {
    warn().log(msg);
  }

  /**
   * @see SubLog#log(Supplier)
   */
  default void warn(Supplier<String> msgSupplier) {
    warn().log(msgSupplier);
  }

  /**
   * @see SubLog#log(String, Object)
   */
  default void warn(String msg, Object param1) {
    warn().log(msg, param1);
  }

  /**
   * @see SubLog#log(String, Object...)
   */
  default void warn(String msg, Object... params) {
    warn().log(msg, params);
  }

  /**
   * @see SubLog#log(String, Throwable)
   */
  default void warn(String msg, Throwable thrown) {
    warn().log(msg, thrown);
  }

  /**
   * @see SubLog#log(Throwable)
   */
  default void warn(Throwable thrown) {
    warn().log(thrown);
  }

  /**
   * Get {@link SubLog} of error level.
   */
  SubLog error();

  /**
   * Is error logging enabled.
   * 
   * @see SubLog#isEnable()
   */
  default boolean isErrorEnable() {
    return error().isEnable();
  }

  /**
   * @see SubLog#log(String)
   */
  default void error(String msg) {
    error().log(msg);
  }

  /**
   * @see SubLog#log(Supplier)
   */
  default void error(Supplier<String> msgSupplier) {
    error().log(msgSupplier);
  }

  /**
   * @see SubLog#log(String, Object)
   */
  default void error(String msg, Object param1) {
    error().log(msg, param1);
  }

  /**
   * @see SubLog#log(String, Object...)
   */
  default void error(String msg, Object... params) {
    error().log(msg, params);
  }

  /**
   * @see SubLog#log(String, Throwable)
   */
  default void error(String msg, Throwable thrown) {
    error().log(msg, thrown);
  }

  /**
   * @see SubLog#log(Throwable)
   */
  default void error(Throwable thrown) {
    error().log(thrown);
  }

  /**
   * Sub-logging interface for specific logging level.
   * 
   * @author Dean Xu (XDean@github.com)
   */
  public interface SubLog {
    /**
     * Is this sub-log enable
     */
    boolean isEnable();

    /**
     * Log message.
     */
    void log(String msg);

    /**
     * Log message with a object parameter.
     */
    void log(String msg, Object param1);

    /**
     * 
     * Log message with an array of object parameter.
     */
    void log(String msg, Object... params);

    /**
     * Log message with associated Throwable information.
     */
    void log(String msg, Throwable thrown);

    /**
     * Log message by a message supplier only if it's enable. It can reduce performance effect.
     */
    default void log(Supplier<String> msgSupplier) {
      if (isEnable()) {
        log(msgSupplier.get());
      }
    }

    /**
     * Log {@link Throwable}, use its message as the log message.
     */
    default void log(Throwable thrown) {
      log(thrown.getMessage(), thrown);
    }
  }
}
