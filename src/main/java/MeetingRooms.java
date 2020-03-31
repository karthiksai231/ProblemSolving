import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// LeetCode 253 Medium
/* Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...],
 find the minimum number of conference rooms required.*/
//https://l...content-available-to-author-only...e.com/problems/meeting-rooms-ii
public class MeetingRooms {
    /*Idea:
    1. Sort meetings by start time
    2. Push the first meeting in a min heap of end times.
    3. Iterate through meetings. If the earliest ending meeting has ended when the current meeting starts,
    i.e. heap.root.end <= current meeting's start, pop from heap.
    4. Push this meeting in the heap
    5. Required number of rooms = Heap size at the end
    * */
    public int minMeetingRooms(int[][] meetings) {
        if (meetings.length == 0)
            return 0;
        Arrays.sort(meetings, Comparator.comparingInt(meeting -> meeting[0]));
        Queue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(meetings[0][1]);
        for (int i = 1; i < meetings.length; i++) {
            int meetingVal = meetings[i][0];
            int peek = minHeap.peek();
            if (peek <= meetingVal)
                minHeap.poll();
            minHeap.add(meetings[i][1]);
        }
        return minHeap.size();
    }

    public static void main(String[] args) {
        MeetingRooms ob = new MeetingRooms();
        //System.out.println(ob.minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}) == 2);
        //System.out.println(ob.minMeetingRooms(new int[][]{{7, 10}, {2, 4}}) == 1);
        System.out.println(ob.minMeetingRooms(new int[][]{{2, 15}, {36, 45}, {9, 29}, {16, 23}, {4, 9}}) == 2);
        //System.out.println(ob.minMeetingRooms(new int[][]{{10, 16}, {11, 13}, {14, 17}}) == 2);
        //System.out.println(ob.minMeetingRooms(new int[][]{}) == 0);
        //System.out.println(ob.minMeetingRooms(new int[][]{{10,16}}) == 1);
    }
}
