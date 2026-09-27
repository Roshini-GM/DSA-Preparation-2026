import java.util.*;
class AuthenticationManager {
    int timeToLive;
    HashMap<String, Integer> map = new HashMap<>();
    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }
    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + timeToLive);
    }
    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId) && map.get(tokenId) > currentTime) {
            map.put(tokenId, currentTime + timeToLive);
        }
    }
    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (int expiry : map.values()) {
            if (expiry > currentTime) {
                count++;
            }
        }
        return count;
    }
}