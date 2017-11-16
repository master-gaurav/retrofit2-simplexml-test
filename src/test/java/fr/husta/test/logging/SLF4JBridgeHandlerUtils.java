package fr.husta.test.logging;

import org.slf4j.bridge.SLF4JBridgeHandler;

import java.util.concurrent.atomic.AtomicBoolean;

public class SLF4JBridgeHandlerUtils
{

    private static AtomicBoolean isAlreadyInit = new AtomicBoolean(false);

    public static synchronized void initSLF4JBridgeHandler()
    {
        if (!isAlreadyInit.get())
        {
            // Optionally remove existing handlers attached to j.u.l root logger
            SLF4JBridgeHandler.removeHandlersForRootLogger();  // (since SLF4J 1.6.5)

            // add SLF4JBridgeHandler to j.u.l's root logger, should be done once during
            // the initialization phase of your application
            SLF4JBridgeHandler.install();

            isAlreadyInit.set(true);
        }
    }

}
