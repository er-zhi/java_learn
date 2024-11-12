package problem_solving.Search_Binary;
// https://leetcode.com/problems/first-bad-version/
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
class VersionControl {
    private int badVersion = 4; // Simulate the first bad version

    // public VersionControl(int badVersion) {
    //     this.badVersion = badVersion;
    // }

    public boolean isBadVersion(int version) {
        return version >= badVersion; // Simulate API: returns true if version is bad
    }
}


public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {

        int low = 1, high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if(isBadVersion(mid)) high = mid; // The first bad version could be mid or before.
            else low = mid + 1; // The first bad version could be mid or before.
        }

        return low; // At the end, first will be the first bad version.
    }
}

