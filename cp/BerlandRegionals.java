package cp;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class BerlandRegionals {

    static void sendTeams(ArrayList<ArrayList<Long>> skills, long sums[]) {
        for (int i = 1; i < skills.size(); i++) {
            ArrayList<Long> sList = skills.get(i);
            Collections.sort(sList);
            skills.set(i, sList);
        }
        
        // prefix sums of skills
        for (int i = 1; i < skills.size(); i++) {
            for (int j = 1; j < skills.get(i).size(); j++) {
                long pSum = skills.get(i).get(j) + skills.get(i).get(j-1);
                skills.get(i).set(j, pSum);
            }
        }

        long result[] = new long[sums.length];
        for (int i = 1; i < skills.size(); i++) {
            int d = skills.get(i).size();
            for (int j = 1; j <= d; j++) {
                if (d % j == 0)
                    result[j] += sums[i];
                else
                    result[j] += (sums[i] - skills.get(i).get(d%j -1));
            }
        }

        StringBuilder s = new StringBuilder();
        for (int i = 1; i < result.length; i++) s.append(result[i]).append(" ");
        System.out.println(s);
    } 

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine());
                ArrayList<ArrayList<Long>> list = new ArrayList<>(n + 1);
                for (int i = 0; i <= n; i++) list.add(new ArrayList<Long>());

                String u[] = br.readLine().split(" ");
                String s[] = br.readLine().split(" ");

                long sums[] = new long[n + 1];
                for (int i = 0; i < n; i++) {
                    int univ = Integer.parseInt(u[i]);
                    Long skill = Long.parseLong(s[i]);
                    list.get(univ).add(skill);
                    sums[univ] += skill;
                }

                sendTeams(list, sums);
            }
        }
    }
}
