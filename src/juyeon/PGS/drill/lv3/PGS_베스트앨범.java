package juyeon.PGS.drill.lv3;

import java.util.*;

class Track implements Comparable<Track> {
    int idx;
    int play;

    public Track(int idx, int play) {
        this.idx = idx;
        this.play = play;
    }

    @Override
    public int compareTo(Track o) {
        return o.play - this.play;
    }
}

public class PGS_베스트앨범 {
    public static void main(String[] args) {
        PGS_베스트앨범 pgs_베스트앨범_ = new PGS_베스트앨범();

        // [4, 1, 3, 0]
        System.out.println(Arrays.toString(pgs_베스트앨범_.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})));
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> count = new HashMap<>();
        Map<String, List<Track>> list = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            Track track = new Track(i, plays[i]);
            count.put(genres[i], count.getOrDefault(genres[i], 0) + plays[i]);
            list.putIfAbsent(genres[i], new ArrayList<>());
            list.get(genres[i]).add(track);
        }

        for (List<Track> tracks : list.values()) {
            Collections.sort(tracks);
        }

        List<String> genre = new ArrayList<>(count.keySet());

        genre.sort((o1, o2) -> count.get(o2).compareTo(count.get(o1)));

        List<Integer> answer = new ArrayList<>();

        for (String g : genre) {
            answer.add(list.get(g).get(0).idx);
            if (list.get(g).size() >= 2) answer.add(list.get(g).get(1).idx);
        }

        return answer.stream().mapToInt(e -> e).toArray();
    }
}
