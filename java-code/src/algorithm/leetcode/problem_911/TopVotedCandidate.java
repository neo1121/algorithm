package algorithm.leetcode.problem_911;

import java.util.*;

public class TopVotedCandidate {
    // key: person, value: cur vote
    private final HashMap<Integer, Integer> votesMap;
    // key: time, value: leader
    private final TreeMap<Integer, Integer> timesMap;

    public TopVotedCandidate(int[] persons, int[] times) {
        votesMap = new HashMap<>();
        timesMap = new TreeMap<>();
        votesMap.put(persons[0], 1);
        timesMap.put(times[0], persons[0]);
        for (int i = 1; i < times.length; i++) {
            // 投票给 person[i]
            int curVote = votesMap.getOrDefault(persons[i], 0) + 1;
            votesMap.put(persons[i], curVote);
            // 上一时刻的领先者
            int preLeader = timesMap.get(times[i - 1]);
            if (votesMap.get(preLeader) <= curVote) {
                // 此刻的被投票人领先
                timesMap.put(times[i], persons[i]);
            } else {
                // 上一时刻的领先者依然领先
                timesMap.put(times[i], preLeader);
            }
        }
    }

    public int q(int t) {
        if (timesMap.containsKey(t)) {
            return timesMap.get(t);
        }
        Set<Integer> times = timesMap.keySet();
        int fitTime = 0;
        for (Integer time : times) {
            if (time > t) {
                break;
            }
            fitTime = time;
        }
        return timesMap.get(fitTime);
    }
}
