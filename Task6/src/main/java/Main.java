public class Main {
    public static void main(String[] args) {
        User user1 = new User("Илья", "Иванов", 24, 'М');
        User user2 = new User();
        user2.setFirstName("Петя");
        user2.setLastName("Петров");
        user2.setAge(35);
        user2.setSex('М');
        System.out.println(user1 + "\n");
        System.out.println(user2 + "\n");
        user1.increaseAge();
        user2.increaseAge();
        System.out.println(user1 + "\n");
        System.out.println(user2 + "\n");
        user1.changeSex();
        System.out.println(user1);
    }

}
