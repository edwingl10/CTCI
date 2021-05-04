package ObjectOrientedDesign;

import java.util.List;

public class CallCenter {
    /**
     * Imagine you have a call center with three levels of employees:
     * respondent, manager, and director. An incoming telephone call must be first allocated
     * to a respondent who is free. If the respondent can't handle the call, he or she must
     * escalate the call to a manager. If the manager is not free or not able to handle it,
     * then the call should be escalated to a director. Design the classes and data structures for
     * this problem. Implement a method dispatchCall ()  which assigns a call to the first available employee
     */
}
/*
1. Core objects:
- Employee
    - Respondent, Manager, Director
- Call
- CallHandler

2. Relationships:
- Call -> Employee
- Employee -> CallHandler

3. Actions:
- Respondent can pass Call -> Manager
- Manager can pass Call -> Director



// super class for Director, Manager & Respondent.
abstract class Employee {
    private Call currentCall;
    protected Rank rank;

    public Employee(CallHandler handler){}
    // start the conversation
    public void receiveCall(Call call){}
    // issue is resolved, finish call
    public void callCompleted(){}
    // issue not resolved. Escalate call & assign a new call to Employee
    public void escalateAndReassign(){}
    //assign new call to an employee, if free
    public boolean assignNewCall(){}
    // returns if the employee is free
    public boolean isFree(){return  currentCall == null;}
    public Rank getRank(){return rank;}
}
class Director extends Employee{
    public Director(){rank = Rank.Director;}
}
class Manager extends Employee{
    public Manager(){rank = Rank.Manager;}
}
class Respondent extends Employee{
    public Responden(){rank = Rank.Respondent;}
}

// represents a call from a user. A call has a minimum rank and is assigned to the first employee who can handle it
class Call{
    // minimal rank of employee who can handle this call
    private Rank rank;
    // person who is calling
    private Caller caller;
    // employee who is handling call
    private Employee handler;

    public Call(Caller c){
        rank = Rank.Responder;
        this.caller = c;
    }
    // set employee who is handling call
    public void setHandler(Employee e){handler = e;}
    public void reply(String message){}
    public Rank getRank(){return rank;}
    public void setRank(Rank r){rank=r;}
    public Rank incrementRank(){}
    public void Disconnect(){}
}

class Rank{

}
// represents the body of the program, and all calls are funneled first through it
class CallHandler{
    private final int LEVELS = 3;

    /// initialized 10 respondents, 4 managers, 2 directors
    private final int NUM_RESPONDENTS = 10;
    private final int NUM_MANAGERS = 4;
    private final int NUM_DIRECTORS = 2;

    List<List<Employee>> employeeLevels;
    List<List<Call>> callQueues;
    public CallHandler(){}

    // gets first available employee who can handle this call
    public Employee getHandlerForCall(Call call){}
    // routes the call to an available employee, or saves in a queue if no employee is available
    public void dispatchCall(Caller caller){
        Call call = new Call(caller);
        dispatchCall(call);
    }
    public void dispatchCall(Call call){
        // try to route call to employee with minimal rank
        Employee emp = getHandlerForCall(call);
        if(emp != null){
            emp.receiveCall(call);
            call.setHandler(emp);
        } else{
            call.reply("Please wait for free employee to reply");
            callQueues.get(call.getRank().getValue()).add(call);
        }

    }
    public boolean assignCall(Employee emp){}
}
*/