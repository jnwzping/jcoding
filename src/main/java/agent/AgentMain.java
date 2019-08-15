package agent;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class AgentMain {

    public static void agentmain(String agentArgs, Instrumentation inst)
        throws ClassNotFoundException, UnmodifiableClassException,
        InterruptedException {
        inst.addTransformer(new MyProxyTransformer(), true);
        inst.retransformClasses(HelloWorld.class);
    }
}
