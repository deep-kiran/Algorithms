class MeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        int r =intervals.length;
        int start[] =new int[r];
        int end[] =new int[r];
        int i=0;
        for(int[] interval:intervals){
            start[i] =interval[0];
            end[i]=interval[1];
            i++;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms=0;
        int itr =0;
        for(int j=0;j<r;j++){
            if(start[j]<end[itr]){
                rooms++;
            }else{
                itr++;
            }
        }
        return rooms;
    }
}
