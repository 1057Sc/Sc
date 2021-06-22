package scagent;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.util.List;

/**
 * @author zhuqingxin
 * @date 2021/6/21
 */
public class AgentmainAttachMain {

    public static void main(String[] args) throws Exception {

        String path = "/Users/zhuqingxin/sc/Sc/sc-agent-main/target/sc-agent-main-1.0-SNAPSHOT.jar";

        List<VirtualMachineDescriptor> list = VirtualMachine.list();
        for (VirtualMachineDescriptor descriptor : list) {
            if (descriptor.displayName().endsWith("AgentMainDemoStart")) {
                VirtualMachine virtualMachine = VirtualMachine.attach(descriptor.id());
                virtualMachine.loadAgent(path, "agent main");
                virtualMachine.detach();
            }
        }
    }
}
