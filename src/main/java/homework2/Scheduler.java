package homework2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scheduler {

    public static void scheduleAndRun(ArrayList<Process> processes) {
        ProcessQueue pq = new ProcessQueue();
        int currentTime = 0;
        List<String> timeline = new ArrayList<>();
        Map<String, Integer> finishTimes = new HashMap<>();

        while (!processes.isEmpty() || !pq.isEmpty()) {
            for (Process p : new ArrayList<>(processes)) {
                if (p.arrivalTime <= currentTime) {
                    pq.addProcess(p);
                    processes.remove(p);
                }
            }
            if (!pq.isEmpty()) {
                Process currentProcess = pq.runNextProcess();
                timeline.add("t: " + currentTime + " | " + currentProcess.name );
                currentProcess.remainingTime--;
                if (currentProcess.remainingTime > 0) {
                    pq.addProcess(currentProcess);
                } else {
                    finishTimes.put(currentProcess.name, currentTime + 1);
                }
            } else {
                timeline.add("t: " + currentTime + " | no process");
            }

            currentTime++;
        }
        for (String event : timeline) {
            System.out.println(event);
        }
        System.out.println("Total time: " + (currentTime ));
    }

    public static void main(String[] args) {
        ArrayList<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 2, 4, 1));
        processes.add(new Process("P2", 1, 1, 2));
        processes.add(new Process("P3", 3, 2, 8));
        scheduleAndRun(processes);
    }
}