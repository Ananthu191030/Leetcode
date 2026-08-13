class Solution {
    public int findContentChildren(int[] student, int[] cookie) {
         Arrays.sort(student);
        Arrays.sort(cookie);
        int studentIndex = 0;
        int cookieIndex = 0;
        while (studentIndex < student.length && cookieIndex < cookie.length) {
            if (cookie[cookieIndex] >= student[studentIndex]) {
                studentIndex++;
            }
            cookieIndex++;
        }
        return studentIndex;
    }
}