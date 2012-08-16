package sedpackagename.androidextra;

public class Log {

	private String logTag;
	private boolean debugEnabled;
	private boolean errorEnabled;
	private boolean traceEnabled;
	private boolean warnEnabled;
	private boolean infoEnabled;

	public Log(String name, Log parent) {
		logTag=name;
		if ( parent != null ) {
			debugEnabled=parent.debugEnabled;
			errorEnabled=parent.errorEnabled;
			traceEnabled=parent.traceEnabled;
			warnEnabled=parent.warnEnabled;
			infoEnabled=parent.infoEnabled;
		} else {
			debugEnabled=false;
			errorEnabled=false;
			traceEnabled=false;
			warnEnabled=false;
			infoEnabled=false;
		}
	}

	public void enableDebug(boolean enable) {
		debugEnabled=enable;
	}

	public boolean isDebugEnabled() {
		return debugEnabled;
	}

	public void debug(Object message) {
		if(isDebugEnabled())
			android.util.Log.d(logTag, message.toString());
	}

	public void debug(Object message, Throwable t) {
		if(isDebugEnabled())
			android.util.Log.d(logTag, message.toString(), t);
	}

	public void enableError(boolean enable) {
		errorEnabled=enable;
	}

	public boolean isErrorEnabled() {
		return errorEnabled;
	}

	public void error(Object message) {
		if(isErrorEnabled())
			android.util.Log.e(logTag, message.toString());
	}

	public void error(Object message, Throwable t) {
		if(isErrorEnabled())
			android.util.Log.e(logTag, message.toString(), t);
	}

	public void enableWarn(boolean enable) {
		warnEnabled=enable;
	}

	public boolean isWarnEnabled() {
		return warnEnabled;
	}

	public void warn(Object message) {
		if(isWarnEnabled())
			android.util.Log.w(logTag, message.toString());
	}

	public void warn(Object message, Throwable t) {
		if(isWarnEnabled())
			android.util.Log.w(logTag, message.toString(), t);
	}

	public void enableInfo(boolean enable) {
		infoEnabled=enable;
	}

	public boolean isInfoEnabled() {
		return infoEnabled;
	}

	public void info(Object message) {
		if(isInfoEnabled())
			android.util.Log.i(logTag, message.toString());
	}

	public void info(Object message, Throwable t) {
		if(isInfoEnabled())
			android.util.Log.i(logTag, message.toString(), t);
	}

	public void enableTrace(boolean enable) {
		traceEnabled=enable;
	}

	public boolean isTraceEnabled() {
		return traceEnabled;
	}

	public void trace(Object message) {
		if(isTraceEnabled())
			android.util.Log.i(logTag, message.toString());
	}

	public void trace(Object message, Throwable t) {
		if(isTraceEnabled())
			android.util.Log.i(logTag, message.toString(), t);
	}

}