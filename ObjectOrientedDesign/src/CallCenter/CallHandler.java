package CallCenter;

import java.util.ArrayList;
import java.util.List;

public class CallHandler {
    private final int LEVELS = 3;
    private final int NUM_RESPONDENTS = 10;
    private final int NUM_MANAGERS = 4;
    private final int NUM_DIRECTORS = 2;

    List<List<Employee>> employeeLevels;
    List<List<Call>> callQueues;

    public CallHandler() {
        this.employeeLevels = new ArrayList<>();
        this.callQueues = new ArrayList<>();
    }

    public void dispatchCall(Caller caller) {
        Call call = new Call(caller);
        dispatchCall(call);
    }

    public void dispatchCall(Call call) {
        Employee emp = getHandlerForCall(call);
        if (emp != null) {
            emp.receiveCall(call);
            call.setHandler(emp);
        } else {
            call.reply("Please wait for free employee to reply");
            callQueues.get(call.getRank().getValue()).add(call);
        }
    }

    private Employee getHandlerForCall(Call call) {
        for (int level = call.getRank(); level < LEVELS - 1; level++) {
            List<Employee> employeeLevel = employeeLevels.get(level);
            for (Employee emp : employeeLevel) {
                if (emp.isFree()) {
                    return emp;
                }
            }
        }
        return null;
    }

    public boolean assignCall(Employee emp) {
        return true;
    }
}
