package me.christylam.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * <p>
 *     This is a hard question provided by LeetCode:
 *     <a href="https://leetcode.com/problems/robot-collisions">Robot Collisions</a>
 * </p>
 * <p>
 *     The aim is to first align robots in the correct position, then taking into account the direction they are moving towards to determine which robots will collide with each other.
 *     The robot with lower health will disappear and the health of the other robot decreases by one.
 *     Determine the remaining robots (after no further collisions can occur) and return their health in the order of they were given in the input.
 * </p>
 *
 * @author Christy Lam
 */
public class RobotCollisions {
    /**
     * Function to find the remaining robots after their collisions, returning their health in the order of their original positions.
     *
     * @param positions the positions of the robots
     * @param healths the healths of the robots
     * @param directions the string of the robots' directions, associated with the index. 'L' = left; 'R' = right
     * @return The array list of the survived robots' health, in the order of their original positions
     */
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Robot> robots = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            robots.add(new Robot(i, positions[i], healths[i], directions.charAt(i)));
        }
        Collections.sort(robots);

        Stack<Robot> stack = new Stack<>();
        for (int i = robots.size() - 1; i >= 0; i--) {
            if (robots.get(i).direction == 'R') {
                Robot currentRobot = robots.get(i);
                while (!stack.isEmpty()) {
                    Robot leftRobot = stack.pop();
                    if (currentRobot.health > leftRobot.health) {
                        currentRobot.health--;
                    } else if (currentRobot.health < leftRobot.health) {
                        robots.remove(i);
                        leftRobot.health--;
                        stack.add(leftRobot);
                        break;
                    } else { // currentRobot.health == leftRobot.health
                        robots.remove(i);
                        break;
                    }
                }
            } else { // Robots moving towards the left added to the stack
                stack.add(robots.remove(i));
            }
        }

        List<Robot> survival = new ArrayList<>(stack);
        survival.addAll(robots);

        Comparator<Robot> comparator = Comparator.comparingInt(x -> x.originalPosition);
        return survival.stream().sorted(comparator).mapToInt(robot -> robot.health).boxed().collect(Collectors.toList());
    }
}

class Robot implements Comparable<Robot>{
    int originalPosition;
    int position;
    int health;
    char direction;

    Robot(int originalPosition, int position, int health, char direction) {
        this.originalPosition = originalPosition;
        this.position = position;
        this.health = health;
        this.direction = direction;
    }

    @Override
    public int compareTo(Robot robot) {
        return Integer.compare(this.position, robot.position);
    }
}
