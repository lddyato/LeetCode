import java.util.HashMap;

/**
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
 * <p>
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * <p>
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 * You need to return whether the student could be rewarded according to his attendance record.
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * <p>
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */

public class Student_Attendance_Record_I {
    public boolean checkRecord(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int countA = 0;
        int countL = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == 'L') {
                countL = map.getOrDefault(temp, 0);
                if (countL == 3) {
                    return false;
                } else {
                    if (i > 0) {
                        if (s.charAt(i - 1) == 'L') {
                            map.put(temp, map.getOrDefault(temp, 0) + 1);
                        } else {
                            map.put(temp, 1);
                        }

                    } else {
                        map.put(temp, 1);
                    }
                }
            } else if (temp == 'A') {
                countA = map.getOrDefault(temp, 0);
                if (countA > 1) {
                    return false;
                }
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        countL = map.getOrDefault('L', 0);
        if (countL == 3) {
            return false;
        }
        countA = map.getOrDefault('A', 0);
        if (countA > 1) {
            return false;
        }
        return true;
    }

    public boolean checkRecord1(String s) {
        return !s.matches(".*LLL.*|.*A.*A.*");
    }

    public boolean checkRecord2(String s) {
        if (s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL"))
            return false;
        return true;
    }

    public boolean checkRecord3(String s) {
        int countA = 0;
        int continuosL = 0;
        int charA = 'A';
        int charL = 'L';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == charA) {
                countA++;
                continuosL = 0;
            } else if (s.charAt(i) == charL) {
                continuosL++;
            } else {
                continuosL = 0;
            }
            if (countA > 1 || continuosL > 2) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        Student_Attendance_Record_I student_attendance_record_i = new Student_Attendance_Record_I();
        String s = "PPALLL";
        student_attendance_record_i.checkRecord(s);
    }
}
