import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    private static class Music implements Comparable<Music> {
        int index;
        int play;
        String genre;

        public Music(int index, int play, String genre) {
            this.index = index;
            this.play = play;
            this.genre = genre;
        }

        @Override
        public int compareTo(Music o) {
            if(this.play == o.play) {
                return this.index - o.index;
            }
            return o.play - this.play;
        }

    }

    static class Song implements Comparable<Song>{
        String genre;
        List<Music> musics;
        int totalPlay;

        public Song(String genre) {
            this.genre = genre;
            this.musics = new ArrayList<>();
        }

        @Override
        public int compareTo(Song o) {
            return o.totalPlay - this.totalPlay;
        }

 
    }

    public static int[] solution(String[] genres, int[] plays) {
        List<Song> songs = new ArrayList<>();

        Set<String> set = Arrays.stream(genres).collect(Collectors.toSet());
        for (String genre : set) {
            songs.add(new Song(genre));
        }

        for(Song song : songs) {
            for (int i = 0; i < plays.length; i++) {
                if(genres[i].equals(song.genre)) {
                    song.musics.add(new Music(i, plays[i], genres[i]));
                    song.totalPlay += plays[i];
                }
            }
        }

        Collections.sort(songs);
        for(Song song : songs) {
            Collections.sort(song.musics);
        }
        List<Integer> answer = new ArrayList<>();
        for(Song song : songs) {
            for (int i = 0; i < 2 && i < song.musics.size(); i++) {
                answer.add(song.musics.get(i).index);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
