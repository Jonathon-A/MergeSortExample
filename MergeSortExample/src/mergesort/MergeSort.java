
package mergesort;

import java.util.ArrayList;


class MergeSort {

    public static void main(String[] args) {

        MergeSort MergeSort3 = new MergeSort();
        MergeSort3.main2();

    }

    public void main2() {
        ArrayList<LeaderboardEntry> LeaderboardEntriesArray = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            LeaderboardEntriesArray.add(new LeaderboardEntry("player " + i, (int) (Math.random() * 50 + 1)));
        }

        System.out.println("Original List:");
        for (LeaderboardEntry p : LeaderboardEntriesArray) {
            System.out.println(p.getUsername() + " " + p.getScore());
        }
        System.out.println();

        //Merge Sort
        MergeSort(LeaderboardEntriesArray);

        System.out.println("\nSorted List:");
        for (LeaderboardEntry p : LeaderboardEntriesArray) {
            System.out.println(p.getUsername() + " " + p.getScore());
        }
        System.out.println();
    }

    private void MergeSort(ArrayList<LeaderboardEntry> UnsortedLeaderboardEntriesArray) {
        /*
        This method uses a merge sort to sort the leaderboard entry score into descending order
        It recursively repeates until the array has been divided into single elements
         */

        //Creates two subarrays
        ArrayList<LeaderboardEntry> LeftSubarray = new ArrayList<>();
        ArrayList<LeaderboardEntry> RightSubarray = new ArrayList<>();
        //If the unsorted array contains more then one element
        if (UnsortedLeaderboardEntriesArray.size() > 1) {
            //Finds the midpoint of the unsorted array
            int MidPoint = UnsortedLeaderboardEntriesArray.size() / 2;

            //Splits and copies the values between the two subbarys
            LeftSubarray.addAll(UnsortedLeaderboardEntriesArray.subList(0, MidPoint));
            RightSubarray.addAll(UnsortedLeaderboardEntriesArray.subList(MidPoint, UnsortedLeaderboardEntriesArray.size()));
            //Recursively repeates the merge sort method
            MergeSort(LeftSubarray);
            MergeSort(RightSubarray);
            //Merges the two subarrays
            Merge(UnsortedLeaderboardEntriesArray, LeftSubarray, RightSubarray);
        }
    }

    private void Merge(ArrayList<LeaderboardEntry> SortedLeaderboardEntriesArray, ArrayList<LeaderboardEntry> LeftSubarray, ArrayList<LeaderboardEntry> RightSubarray) {
        /*
        This method merges the two subbarys into a sorted array
         */

        //Initial index pointer for merged array
        int LeaderboardEntriesArrayIndex = 0;
        //Initial index pointer for two subarrays
        int LeftSubarrayIndex = 0;
        int RightSubarrayIndex = 0;
        //While loop until all values of one subbaray are merged
        while (LeftSubarrayIndex < LeftSubarray.size() && RightSubarrayIndex < RightSubarray.size()) {
            //Merges the left and right subarrays
            if (LeftSubarray.get(LeftSubarrayIndex).getScore() > RightSubarray.get(RightSubarrayIndex).getScore()) {
                SortedLeaderboardEntriesArray.set(LeaderboardEntriesArrayIndex, LeftSubarray.get(LeftSubarrayIndex));
                //Increments the left subarray index pointer
                LeftSubarrayIndex++;
            } else {
                SortedLeaderboardEntriesArray.set(LeaderboardEntriesArrayIndex, RightSubarray.get(RightSubarrayIndex));
                //Increments the right subarray index pointer
                RightSubarrayIndex++;
            }
            //Increments the merged array index pointer
            LeaderboardEntriesArrayIndex++;
        }
        //Loops through any remaining elements in the left subarray and adds them to the end of the merged array
        while (LeftSubarrayIndex < LeftSubarray.size()) {
            SortedLeaderboardEntriesArray.set(LeaderboardEntriesArrayIndex, LeftSubarray.get(LeftSubarrayIndex));
            //Increments both the left subarray and merged array index pointer
            LeftSubarrayIndex++;
            LeaderboardEntriesArrayIndex++;
        }
        //Loops through any remaining elements in the right subarray and adds them to the end of the merged array
        while (RightSubarrayIndex < RightSubarray.size()) {
            SortedLeaderboardEntriesArray.set(LeaderboardEntriesArrayIndex, RightSubarray.get(RightSubarrayIndex));
            //Increments both the right subarray and merged array index pointer
            RightSubarrayIndex++;
            LeaderboardEntriesArrayIndex++;
        }

    }
}
