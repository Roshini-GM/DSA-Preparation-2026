class Twitter {
    HashMap<Integer, Set<Integer>> follow = new HashMap<>();
    HashMap<Integer, List<int[]>> tweets = new HashMap<>();
    int time = 0;
    public Twitter() {
    }
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{++time, tweetId});
    }
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );
        Set<Integer> users = new HashSet<>();
        users.add(userId);
        if (follow.containsKey(userId)) {
            users.addAll(follow.get(userId));
        }
        for (int user : users) {
            if (tweets.containsKey(user)) {
                pq.addAll(tweets.get(user));
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty() && ans.size() < 10) {
            ans.add(pq.poll()[1]);
        }
        return ans;
    }
    public void follow(int followerId, int followeeId) {
        follow.putIfAbsent(followerId, new HashSet<>());
        follow.get(followerId).add(followeeId);
    }
    public void unfollow(int followerId, int followeeId) {
        if (follow.containsKey(followerId)) {
            follow.get(followerId).remove(followeeId);
        }
    }
}