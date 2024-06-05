import java.util.*;

public class Solution {

    static class Genre {

        String genre;
        int total;
        PriorityQueue<Music> musics;

        public Genre(String genre) {
            this.genre = genre;
            this.musics = new PriorityQueue<>();
        }

        public void addMusic(Music music) {
            this.total += music.playTime;
            this.musics.add(music);
        }
    }

    static class Music implements Comparable<Music> {

        int idx;
        String genre;
        int playTime;

        public Music(int idx, String genre, int playTime) {
            this.idx = idx;
            this.genre = genre;
            this.playTime = playTime;
        }

        @Override
        public int compareTo(Music o) {
            if (this.playTime == o.playTime) {
                return this.idx - o.idx;
            }

            return o.playTime - this.playTime;
        }

    }

    public static Map<String, Genre> album = new HashMap<>();

    public static int[] solution(String[] genres, int[] plays) {
        for (int i = 0; i < genres.length; i++) {
            album.putIfAbsent(genres[i], new Genre(genres[i]));
            album.get(genres[i]).addMusic(new Music(i, genres[i], plays[i]));
        }

        List<Genre> list = new ArrayList<>();
        list.addAll(album.values());
        list.sort((o1, o2) -> o2.total - o1.total);

        List<Integer> answer = new ArrayList<>();
        for(Genre genre : list) {
            int count = 0;
            while(!genre.musics.isEmpty())
            {
                answer.add(genre.musics.poll().idx);
                count++;

                if(count >= 2) break;
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
