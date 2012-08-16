/*
 * Copyright (C) 2009 University of Washington
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package sedpackagename.androidextra;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>Trivial stub replacement for getLog() interface of Apache commons LogFactory
 * to replace that logging system with a simple wrapper for Android native logging.
 */

public class LogFactory {

    // ------------------------------------------------------- Static Variables

    /**
     * The previously constructed <code>LogFactory</code> instances, keyed by
     * the <code>ClassLoader</code> with which it was created.
     */
    private static LogFactory factory = new LogFactory();

    // --------------------------------------------------------- Static Methods

    /**
	 * Get the logging factory singleton.
     */
    public static LogFactory getFactory() {
        return factory;
    }

    /**
     * Convenience method to return a named logger, without the application
     * having to care about factories.
     *
     * @param clazz Class from which a log name will be derived
     *
     * @exception LogConfigurationException if a suitable <code>Log</code>
     *  instance cannot be returned
     */
    public static Log getLog(Class clazz) {

        return (getFactory().getInstance(clazz));
    }


    /**
     * Convenience method to return a named logger, without the application
     * having to care about factories.
     *
     * @param name Logical name of the <code>Log</code> instance to be
     *  returned (the meaning of this name is only known to the underlying
     *  logging implementation that is being wrapped)
     */
    public static Log getLog(String name) {

        return (getFactory().getInstance(name));
    }

    // ----------------------------------------------------- Instance Variables

    /**
     * The {@link org.apache.commons.logging.Log} instances that have
     * already been created, keyed by logger name.
     */
    private ConcurrentHashMap<String,Log> instances = new ConcurrentHashMap<String,Log>();

    // ----------------------------------------------------------- Constructors

    /**
     * Protected constructor that is not available for public use.
     */
    protected LogFactory() {
    }

    // --------------------------------------------------------- Public Methods

    /**
     * Convenience method to derive a name from the specified class and
     * call <code>getInstance(String)</code> with it.
     *
     * @param clazz Class for which a suitable Log name will be derived
     */
    public Log getInstance(Class clazz) {

        return (getInstance(clazz.getName()));

    }

    /**
     * <p>Construct (if necessary) and return a <code>Log</code> instance,
     * using the factory's current set of configuration attributes.</p>
     *
     * <p><strong>NOTE</strong> - Depending upon the implementation of
     * the <code>LogFactory</code> you are using, the <code>Log</code>
     * instance you are returned may or may not be local to the current
     * application, and may or may not be returned again on a subsequent
     * call with the same name argument.</p>
     *
     * @param name Logical name of the <code>Log</code> instance to be
     *  returned (the meaning of this name is only known to the underlying
     *  logging implementation that is being wrapped)
     */
    public synchronized Log getInstance(String name) {

        Log instance = instances.get(name);
        if (instance == null) {
			String immediateParent = "";
			for ( String key : instances.keySet() ) {
				if ( name.startsWith(key) ) {
					if ( immediateParent.length() < key.length() ) {
						immediateParent = key;
					}
				}
			}
			Log parent = instances.get(immediateParent);
            instance = new Log(name, parent);
            instances.put(name, instance);
        }
        return (instance);
    }
}
