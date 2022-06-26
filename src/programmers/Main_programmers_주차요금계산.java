package programmers;

import java.util.*;

public class Main_programmers_주차요금계산 {
    public static int calculTime(String inTime, String outTime) {
        int hour, minute;
        StringTokenizer st = new StringTokenizer(outTime, ":");
        hour = Integer.parseInt(st.nextToken());
        minute = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(inTime, ":");
        hour -= Integer.parseInt(st.nextToken());
        minute -= Integer.parseInt(st.nextToken());
        hour *= 60;
        return hour + minute;
    }

    public static int calculFee(int minute, int[] fees){
        int fee = fees[1];
        minute -= fees[0];
        if(minute <=0) return fee;
        if(minute%fees[2]==0)
            fee += minute/fees[2] * fees[3];
        else
            fee += minute/fees[2] * fees[3] + fees[3];

        return fee;
    }

    public static int[] solution(int[] fees, String[] records) {
        int[] answer;
        PriorityQueue<Fee> pq = new PriorityQueue<>();
        HashMap<String, String> parkHM = new HashMap<>();
        HashMap<String, Integer> timeHM = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            StringTokenizer st = new StringTokenizer(records[i]);
            String time = st.nextToken();
            String carNum = st.nextToken();
            String type = st.nextToken();

            if (type.equals("IN")) {
                parkHM.put(carNum, time);
            } else {
                String inTime = parkHM.get(carNum);
                parkHM.remove(carNum);
                int minute = calculTime(inTime, time);
                if(timeHM.containsKey(carNum))
                    timeHM.put(carNum, minute + timeHM.get(carNum));
                else
                    timeHM.put(carNum, minute);
            }
        }

        if (!parkHM.isEmpty()) {
            Set<String> keys = parkHM.keySet();
            for (String key : keys) {
                String inTime = parkHM.get(key);
                int minute = calculTime(inTime, "23:59");
                if(timeHM.containsKey(key))
                    timeHM.put(key, minute + timeHM.get(key));
                else
                    timeHM.put(key, minute);
            }
        }

        Set<String> keys = timeHM.keySet();
        for(String key : keys){
            pq.add(new Fee(key, calculFee(timeHM.get(key), fees)));
        }

        answer = new int[pq.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = pq.poll().fee;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
                "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
                "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] answer = solution(fees, records);
        for (int a : answer)
            System.out.print(a + " ");
    }

    static class Fee implements Comparable<Fee> {
        String carNum;
        int fee;

        Fee(String carNum, int fee) {
            this.carNum = carNum;
            this.fee = fee;
        }

        @Override
        public int compareTo(Fee o) {
            return carNum.compareTo(o.carNum);
        }
    }
}
