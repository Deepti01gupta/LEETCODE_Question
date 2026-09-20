class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int x=Math.min(Math.max(xCenter,x1),x2);
        int y=Math.min(Math.max(yCenter,y1),y2);

        int dx=Math.abs(x-xCenter);
        int dy=Math.abs(y-yCenter);

        int d=(dx*dx)+(dy*dy);
        if(d<=radius*radius){
            return true;
        }
        return false;
    }
}