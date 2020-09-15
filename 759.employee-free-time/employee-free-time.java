import java.util.ArrayList;

/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> mergedIntervals = getEmployeeFreetime(schedule, 0, schedule.size() - 1);
        List<Interval> ans = new ArrayList<>();
        for (int i = 0; i < mergedIntervals.size() - 1; i++) {
            Interval newInterval = new Interval(mergedIntervals.get(i).end, mergedIntervals.get(i + 1).start);
            ans.add(newInterval);
        }
        return ans;
    }

    private List<Interval> getEmployeeFreetime(List<List<Interval>> schedule, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return schedule.get(startIndex);
        }
        int mid = (startIndex + endIndex) / 2;
        List<Interval> firstHalf = getEmployeeFreetime(schedule, startIndex, mid);
        List<Interval> secondHalf = getEmployeeFreetime(schedule, mid + 1, endIndex);
        int first = 0, second = 0;
        List<Interval> ret = new ArrayList<>();
        while (first < firstHalf.size() && second < secondHalf.size()) {
            Interval firstInterval = firstHalf.get(first);
            Interval secondInterval = secondHalf.get(second);
            if (firstInterval.start >= secondInterval.end) {
                ret.add(secondInterval);
                second++;
            } else if (secondInterval.start >= firstInterval.end) {
                ret.add(firstInterval);
                first++;
            } else if (secondInterval.start >= firstInterval.start && secondInterval.end <= firstInterval.end) {
                second++;
            } else if (firstInterval.start >= secondInterval.start && firstInterval.end <= secondInterval.end) {
                first++;
            } else {
                Interval newInterval = new Interval(Math.min(firstInterval.start, secondInterval.start),
                        Math.max(firstInterval.end, secondInterval.end));
                ret.add(newInterval);
                first++;
                second++;
            }
        }
        while (first < firstHalf.size()) {
            ret.add(firstHalf.get(first));
            first++;
        }
        while (second < secondHalf.size()) {
            ret.add(secondHalf.get(second));
            second++;
        }
        return ret;
    }
}