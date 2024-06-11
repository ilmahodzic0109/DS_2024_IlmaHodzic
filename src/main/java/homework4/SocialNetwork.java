package homework4;

import java.util.*;

public class SocialNetwork {
    private int V;
    private int E;
    private HashMap<String, ArrayList<Friendship>> adj;

    public SocialNetwork() {
        this.V = 0;
        this.E = 0;
        this.adj = new HashMap<>();
    }

    public SocialNetwork(Scanner in) {
        this();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.startsWith("friend1")) {
                continue;
            }
            String[] parts = line.split(";");
            String friend1 = parts[0];
            String friend2 = parts[1];
            int strength = Integer.parseInt(parts[2]);
            Friendship friendship = new Friendship(friend1, friend2, strength);
            addFriendship(friendship);
        }
    }

    public void addUser(String user) {
        if (!adj.containsKey(user)) {
            adj.put(user, new ArrayList<>());
            V++;
        }
    }

    public void addFriendship(Friendship f) {
        String friend1 = f.getFriend1();
        String friend2 = f.getFriend2();
        int strength = f.getFriendshipStrength();

        addUser(friend1);
        addUser(friend2);

        adj.get(friend1).add(f);
        adj.get(friend2).add(new Friendship(friend2, friend1, strength));
        E++;
    }

    public ArrayList<FriendshipRecommendation> recommendFriends(String user) {
        if (!adj.containsKey(user)) {
            return new ArrayList<>();
        }

        Map<String, Integer> potentialFriends = new HashMap<>();
        List<Friendship> friends = adj.get(user);

        for (Friendship f : friends) {
            String friend = f.getFriend2();
            List<Friendship> friendsOfFriend = adj.get(friend);

            for (Friendship ff : friendsOfFriend) {
                String potentialFriend = ff.getFriend2();
                if (!potentialFriend.equals(user) && friends.stream().noneMatch(fr -> fr.getFriend2().equals(potentialFriend))) {
                    int weight = Math.min(f.getFriendshipStrength(), ff.getFriendshipStrength());
                    potentialFriends.put(potentialFriend, potentialFriends.getOrDefault(potentialFriend, 0) + weight);
                }
            }
        }

        ArrayList<FriendshipRecommendation> recommendations = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : potentialFriends.entrySet()) {
            recommendations.add(new FriendshipRecommendation(entry.getKey(), entry.getValue()));
        }

        Collections.sort(recommendations);
        return recommendations;
    }


    public int getTotalUsers() {
        return V;
    }


    public int getTotalFriendships() {
        return E;
    }


    public boolean userExists(String user) {
        return adj.containsKey(user);
    }
}
