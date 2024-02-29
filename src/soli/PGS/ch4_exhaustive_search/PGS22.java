package soli.PGS.ch4_exhaustive_search;

import java.util.HashSet;
import java.util.Set;

public class PGS22 {

    private static Set<Set<String>> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {

        HashSet<String> set = new HashSet<>();
        dfs(user_id, banned_id, set, 0);

        return result.size();
    }

    private static void dfs(String[] user_id, String[] banned_id, HashSet<String> set, int depth){

        if(depth == banned_id.length) {
            result.add(new HashSet<>(set));
            return;
        }

        for(int i = 0 ; i < user_id.length ; i++) {
            if(user_id[i].matches(banned_id[depth].replace("*",".")) && !set.contains(user_id[i])){
                set.add(user_id[i]);
                dfs(user_id, banned_id, set, depth +1);
                set.remove(user_id[i]);
            }
        }


    }


}
