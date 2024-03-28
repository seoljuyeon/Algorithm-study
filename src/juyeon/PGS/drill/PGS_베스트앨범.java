package juyeon.PGS.drill;

import java.util.*;

class Music implements Comparable<Music> {
    int idx;
    String genre;
    int play;

    public Music(int idx, String genre, int play) {
        this.idx = idx;
        this.genre = genre;
        this.play = play;
    }

    @Override
    public int compareTo(Music o) {
        return o.play - this.play;
    }
}

// 틀림 ㅎㅎ;
public class PGS_베스트앨범 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500})));
        // [4, 1, 3, 0]
    }

    private static int[] solution(String[] genres, int[] plays) {
        ArrayList<Music> music = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            music.add(new Music(i, genres[i], plays[i]));
        }

        Collections.sort(music);

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();

        for (Music m : music) {
            map.put(m.genre, map.getOrDefault(m.genre, 0) + m.play);
            count.put(m.genre, map.getOrDefault(m.genre, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1))); // classic, pop

        List<Integer> answer = new ArrayList<>();

        for (String g : list) {
            int e = 0;
            for (Music m : music) {
                if (m.genre == g) {
                    answer.add(m.idx);
                    e++;
                    if (count.get(g) == 1 || e == 2) break;
                }
            }
        }

        return answer.stream().mapToInt(e -> e).toArray();
    }
}
