class Twitter {
    int timestamp =0;
     public class Tweet{
        int tweetid;
        int time ;
        public Tweet next;
        public Tweet(int tweetid){
            this.tweetid =tweetid;
            this.next =null;
            this.time =timestamp++;
        }
    }
    public class User{
        int userid;
        HashSet<Integer> followed;
        Tweet tweethead; //points to recent tweet
        public User(int userid){
            followed =new HashSet<>();
            this.userid =userid;
            followed.add(userid);
            tweethead =null;
        }
        public void follow(int id){
            this.followed.add(id);
        }
        public void unfollow(int id){
            this.followed.remove(id);
        }
        public void post(int postid){
            Tweet t =new Tweet(postid);
            t.next =tweethead;
            tweethead =t;
        }
        
    }
    Map<Integer,User> usermap;
    public Twitter() {
        usermap =new HashMap<Integer,User>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!usermap.containsKey(userId)){
            User u1 =new User(userId);
            usermap.put(userId,u1);
        }
        usermap.get(userId).post(tweetId);
    }
        
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res =new ArrayList<>();
        if(!usermap.containsKey(userId))return res;
        Set<Integer> followingusers =usermap.get(userId).followed;
        PriorityQueue<Tweet> pq =new PriorityQueue<Tweet>(10,(a,b)->b.time-a.time);
        for(int id :followingusers){
            Tweet  t = usermap.get(id).tweethead;
            if(t!=null){
                pq.add(t); //only add heads first
            }
        }
        int n =0;
        while(!pq.isEmpty()&& n<10){
            Tweet t = pq.poll();
            res.add(t.tweetid);
            n++;
            if(t.next!=null){
                pq.add(t.next);
            }
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!usermap.containsKey(followerId)){
            User u1 =new User(followerId);
            usermap.put(followerId,u1);
        }
        if(!usermap.containsKey(followeeId)){
            User u2 =new User(followeeId);
            usermap.put(followeeId,u2);
        }
        usermap.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!usermap.containsKey(followerId)||followerId==followeeId)
            return;
        usermap.get(followerId).unfollow(followeeId);        
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
