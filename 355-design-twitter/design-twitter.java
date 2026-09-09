class Twitter {
    Map<Integer, List<int[]>> tweet;
    Map<Integer, Set<Integer>> follow;
    int time;

    public Twitter() {
        tweet=new HashMap<>();
        follow=new HashMap<>();
        time=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweet.putIfAbsent(userId, new ArrayList<>());
        tweet.get(userId).add(new int[]{time++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> a[0]-b[0]);

        if(tweet.containsKey(userId)){
            for(int[] tt:tweet.get(userId)){
                pq.offer(tt);

                if(pq.size()>10){
                    pq.poll();
                }
            }
        }

        if(follow.containsKey(userId)){
            for(int ff:follow.get(userId)){

                if(tweet.containsKey(ff)){
                    for(int[] tt:tweet.get(ff)){
                        pq.offer(tt);

                        if(pq.size()>10){
                            pq.poll();
                        }
                    }
                }
            }
        }

        LinkedList<Integer> res=new LinkedList<>();
        while(!pq.isEmpty()){
            res.addFirst(pq.poll()[1]);
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        follow.putIfAbsent(followerId, new HashSet<>());
        follow.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(follow.containsKey(followerId)){
            follow.get(followerId).remove(followeeId);
        }

    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */