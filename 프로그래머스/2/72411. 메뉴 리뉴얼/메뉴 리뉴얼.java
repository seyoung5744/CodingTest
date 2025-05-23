import java.util.*;
import java.util.stream.*;

class Solution {
    public static Map<String, Integer> courseMap = new HashMap<>();

    public static class Course {
        String course;
        int count;

        public Course(String course, int count) {
            this.course = course;
            this.count = count;
        }
    }

    public String[] solution(String[] orders, int[] course) {
        Map<Integer, List<Course>> courses = new HashMap<>();
        Map<Integer, Integer> maxCourseSize = new HashMap<>();
        for (int i = 0; i < course.length; i++) {
            List<Course> courseList = new ArrayList<>();
            maxCourseSize.put(course[i], 0);
            courses.put(course[i], courseList);
        }

        for (String order : orders) {
            char[] charArray = order.toCharArray();
            Arrays.sort(charArray);
            for (int i = 0; i < course.length; i++) {
                if (course[i] > order.length()) continue;
                generate(0, course[i], 0, new StringBuilder(), charArray);
            }
        }

        for (String key : courseMap.keySet()) {
            int courseSize = key.length();
            int occurrences = courseMap.get(key);

            List<Course> courseList = courses.get(courseSize);
            courseList.add(new Course(key, occurrences));
            courses.put(courseSize, courseList);

            if (maxCourseSize.get(courseSize) < occurrences && occurrences >= 2) {
                maxCourseSize.put(courseSize, occurrences);
            }
        }

        List<String> result = new ArrayList<>();
        for (int courseSize : courses.keySet()) {
            List<Course> courseList = courses.get(courseSize);
            int maxCourse = maxCourseSize.get(courseSize);
            for (Course c : courseList) {
                if (c.count == maxCourse) {
                    result.add(c.course);
                }
            }
        }
        return result.stream()
                .sorted()
                .toArray(String[]::new);
    }

    public void generate(int curSize, int targetSize, int idx, StringBuilder temp, char[] charArray) {
        if (curSize == targetSize) {

            courseMap.put(temp.toString(), courseMap.getOrDefault(temp.toString(), 0) + 1);
            return;
        }

        for (int i = idx; i < charArray.length; i++) {
            temp.append(charArray[i]);
            generate(curSize + 1, targetSize, i + 1, new StringBuilder(temp), charArray);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}   