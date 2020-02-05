package CallCenter;

public class Employee {

    protected Rank rank;
    private Call currentCall = null;

    public Employee(CallHandler handler) {
        rank = handler;
    }

    public void receiveCall(Call call) {

    }

    public void callCompleted() {

    }

    public void escalateAndReassign() {

    }

    public boolean assignNewCall() {
        return true;
    }

    public boolean isFree() {
        return currentCall == null;
    }

    public Rank getRank() {
        return rank;
    }
}
