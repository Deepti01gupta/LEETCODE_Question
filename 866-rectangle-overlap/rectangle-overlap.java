class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        
        if(rec1[2] <= rec2[0]) return false; // rec1 left
        if(rec1[0] >= rec2[2]) return false; // rec1 right
        if(rec1[3] <= rec2[1]) return false; // rec1 below
        if(rec1[1] >= rec2[3]) return false; // rec1 above
        
        return true;
    }
}