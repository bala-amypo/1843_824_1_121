// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.model.SeatingPlan;

// public interface SeatingPlanService {

//     SeatingPlan generateSeatingPlan(Long sessionId, Long roomId);

//     SeatingPlan getPlan(Long planId);

//     List<SeatingPlan> getPlansBySession(Long sessionId);
// }
package com.example.demo.service;

import java.util.List;
import com.example.demo.model.SeatingPlan;

public interface SeatingPlanService {

    SeatingPlan saveSeatingPlan(SeatingPlan seatingPlan);

    List<SeatingPlan> getAllSeatingPlans();
}
