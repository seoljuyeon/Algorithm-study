package soli.PGS.ch7_hash;

import java.util.*;

public class PGS_hash42597 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCount = new HashMap<>();
        Map<String, PriorityQueue<Song>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);

            genreSongs.putIfAbsent(genre, new PriorityQueue<>((a, b) -> {
                if (a.plays == b.plays) return a.index - b.index;
                return b.plays - a.plays;
            }));
            genreSongs.get(genre).add(new Song(i, play));
        }

        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));

        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            PriorityQueue<Song> songs = genreSongs.get(genre);
            int count = 0;
            while (!songs.isEmpty() && count < 2) {
                result.add(songs.poll().index);
                count++;
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    class Song {
        int index;
        int plays;

        Song(int index, int plays) {
            this.index = index;
            this.plays = plays;
        }
    }

}
