public class Main {
    public static void main(String[] args) {
        User user1 = new User("Илья", "Иванов", 24, 'М');
        User user2 = new User();
        user2.setFirstName("Петя");
        user2.setLastName("Петров");
        user2.setAge(35);
        user2.setSex('М');
        System.out.println(user1.toString() + "\n");
        System.out.println(user2.toString() + "\n");
        user1.grownUp();
        user2.grownUp();
        System.out.println(user1.toString() + "\n");
        System.out.println(user2.toString() + "\n");
        user1.changeName();
        System.out.println(user1.toString());
    }

}
