package by.tms.robot;

import by.tms.robot.hands.SamsungHand;
import by.tms.robot.hands.ToshibaHand;
import by.tms.robot.heads.SamsungHead;
import by.tms.robot.heads.SonyHead;
import by.tms.robot.heads.ToshibaHead;
import by.tms.robot.legs.SamsungLeg;
import by.tms.robot.legs.SonyLeg;

public class Run {

  public static void main(String[] args) {
    Robot robot = new Robot(new SamsungHead(250), new ToshibaHand(90), new SonyLeg(400));
    Robot robot1 = new Robot(new SonyHead(900), new SamsungHand(130), new SamsungLeg(80));
    Robot robot2 = new Robot(new ToshibaHead(360), new ToshibaHand(90), new SonyLeg(500));
    System.out.println("экспериментальная модель robot");
    robot.action();
    System.out.println("\n" + "экспериментальная модель robot1");
    robot1.action();
    System.out.println("\n" + "экспериментальная модель robot2");
    robot2.action();
    System.out.println("\n" + "Самый дорогой робот " + dearest(robot, dearest(robot1, robot2)));
  }

  public static Robot dearest(Robot robot, Robot robot1) {
    if (robot.getPrice() > robot1.getPrice()) {
      return robot;
    } else {
      return robot1;
    }
  }
}
