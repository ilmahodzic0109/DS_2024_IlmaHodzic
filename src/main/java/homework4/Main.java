package homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {

        String filePath = "social_network.csv";

        SocialNetwork socialNetwork = null;
        try {
            Scanner fileScanner = new Scanner(new File(filePath));
            socialNetwork = new SocialNetwork(fileScanner);
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please make sure the file path is correct.");
            System.exit(1);
        }

        System.out.println("Loading in the social network...");
        System.out.println("Network successfully loaded.");
        System.out.println("Total users: " + socialNetwork.getTotalUsers());
        System.out.println("Total friendships: " + socialNetwork.getTotalFriendships());
        System.out.println("=================================");

        Scanner inputScanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a name to recommend for, or -1 to exit:");
            String userInput = inputScanner.nextLine();
            if (userInput.equals("-1")) {
                break;
            }

            if (!socialNetwork.userExists(userInput)) {
                System.out.println("User not found in the social network.");
                continue;
            }

            ArrayList<FriendshipRecommendation> recommendations = socialNetwork.recommendFriends(userInput);

            if (recommendations.isEmpty()) {
                System.out.println("No recommendations available.");
            } else {
                System.out.println("Total recommendations: " + recommendations.size());
                System.out.println("Top 10 recommendations based on friendship strength:");
                for (int i = 0; i < Math.min(10, recommendations.size()); i++) {
                    FriendshipRecommendation recommendation = recommendations.get(i);
                    System.out.println(recommendation.getUser() + ": " + recommendation.getRecommendationStrength());
                }
            }
        }

        inputScanner.close();
    }
}
