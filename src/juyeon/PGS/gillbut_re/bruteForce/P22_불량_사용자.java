package juyeon.PGS.gillbut_re.bruteForce;

import java.util.*;

public class P22_불량_사용자 {
    public static void main(String[] args) {
        P22_불량_사용자 p22 = new P22_불량_사용자();

        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};

        System.out.println(p22.solution(user_id, new String[]{"fr*d*", "abc1**"})); // 2
        System.out.println(p22.solution(user_id, new String[]{"*rodo", "*rodo", "******"})); // 2
        System.out.println(p22.solution(user_id, new String[]{"fr*d*", "*rodo", "******", "******"})); // 3
    }

    Set<Set<String>> set;

    boolean[] visited;

    public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();
        visited = new boolean[user_id.length];

        DFS(user_id, banned_id, 0, new HashSet<>());

        return set.size();
    }

    private void DFS(String[] userId, String[] banId, int idx, Set<String> curSet) {
        if (idx == banId.length) {
            set.add(new HashSet<>(curSet));
            return;
        }

        for (int i = 0; i < userId.length; i++) {
            if (!visited[i] && check(userId[i], banId[idx])) {
                visited[i] = true;
                curSet.add(userId[i]);

                DFS(userId, banId, idx + 1, curSet);

                // 백트래킹
                curSet.remove(userId[i]);
                visited[i] = false;
            }
        }
    }

    private boolean check(String userId, String banId) {
        if (userId.length() != banId.length()) return false;

        for (int i = 0; i < userId.length(); i++) {
            if (banId.charAt(i) != '*' && banId.charAt(i) != userId.charAt(i)) return false;
        }

        return true;
    }
}
