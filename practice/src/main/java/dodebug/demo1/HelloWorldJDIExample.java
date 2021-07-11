package dodebug.demo1;

import java.util.Map;

import com.sun.jdi.Bootstrap;
import com.sun.jdi.ClassType;
import com.sun.jdi.LocalVariable;
import com.sun.jdi.Location;
import com.sun.jdi.StackFrame;
import com.sun.jdi.VMDisconnectedException;
import com.sun.jdi.Value;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.connect.Connector;
import com.sun.jdi.connect.LaunchingConnector;
import com.sun.jdi.event.BreakpointEvent;
import com.sun.jdi.event.ClassPrepareEvent;
import com.sun.jdi.event.Event;
import com.sun.jdi.event.EventSet;
import com.sun.jdi.request.BreakpointRequest;
import com.sun.jdi.request.ClassPrepareRequest;

/**
 * Hello world example for Java Debugging API i.e. JDI. Very basic & simple
 * example.
 *
 * @author ravik
 *
 */
public class HelloWorldJDIExample {

    public static void main(String[] args) throws Exception {

        Class classToDebug = HelloWorld.class;
        int lineNumberToPutBreakpoint = 18;

        /*
         * Prepare connector, set class to debug & launch VM.
         */
        LaunchingConnector launchingConnector = Bootstrap.virtualMachineManager().defaultConnector();
        Map<String, Connector.Argument> env = launchingConnector.defaultArguments();
        env.get("main").setValue(classToDebug.getName());
        VirtualMachine vm = launchingConnector.launch(env);

        /*
         * Request VM to trigger event when HelloWorld class is prepared.
         */
        ClassPrepareRequest classPrepareRequest = vm.eventRequestManager().createClassPrepareRequest();
        classPrepareRequest.addClassFilter(classToDebug.getName());
        classPrepareRequest.enable();

        EventSet eventSet = null;

        try {
            while ((eventSet = vm.eventQueue().remove(100)) != null) {

                for (Event event : eventSet) {

                    /*
                     * If this is ClassPrepareEvent, then set breakpoint
                     */
                    if (event instanceof ClassPrepareEvent) {
                        ClassPrepareEvent evt = (ClassPrepareEvent) event;
                        ClassType classType = (ClassType) evt.referenceType();

                        Location location = classType.locationsOfLine(lineNumberToPutBreakpoint).get(0);
                        BreakpointRequest bpReq = vm.eventRequestManager().createBreakpointRequest(location);
                        bpReq.enable();

                    }

                    /*
                     * If this is BreakpointEvent, then read & print variables.
                     */
                    if (event instanceof BreakpointEvent) {
                        // disable the breakpoint event
                        event.request().disable();

                        // Get values of all variables that are visible and print
                        StackFrame stackFrame = ((BreakpointEvent) event).thread().frame(0);
                        Map<LocalVariable, Value> visibleVariables = (Map<LocalVariable, Value>) stackFrame
                                .getValues(stackFrame.visibleVariables());
                        System.out.println("Local Variables =");
                        for (Map.Entry<LocalVariable, Value> entry : visibleVariables.entrySet()) {
                            System.out.println("	" + entry.getKey().name() + " = " + entry.getValue());
                        }

                    }
                    vm.resume();

                }

            }
        } catch (VMDisconnectedException e) {
            System.out.println("VM is now disconnected.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}