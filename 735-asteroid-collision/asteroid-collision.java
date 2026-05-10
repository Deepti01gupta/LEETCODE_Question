class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int r : asteroids) {
            boolean destroyed = false;

            while (!st.isEmpty() && r < 0 && st.peek() > 0) {
                if (st.peek() < -r) {
                    st.pop(); // top asteroid is smaller, so it explodes
                    continue;
                } else if (st.peek() == -r) {
                    st.pop(); // both explode
                }
                destroyed = true;
                break;
            }

            if (!destroyed) {
                st.push(r);
            }
        }
        int[] result = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            result[i] = st.pop();
        }

        return result;
    }
}