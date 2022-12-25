import java.util.*;

public class User {
    int age;
    String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(15, "Петя"));
        users.add(new User(25, "Полина"));
        users.add(new User(25, "Полина"));
        users.add(new User(13, "Арсений"));
        users.add(new User(27, "Андрей"));
        users.add(new User(15, "Петя"));
        users.add(new User(27, "Андрей"));
        System.out.println("Начальный список" + users);
// Создаю новую коллекцию списков для хранения дедуплицированных элементов
        List deletedUsers = new ArrayList<>();
// Обхожу коллекцию списков
        for (int i = 0; i < users.size(); i++) {
// Определяю, содержит ли коллекция deletedUsers элементы в списке
            if (!deletedUsers.contains(users.get(i))) {
// Добавляем несодержащие элементы в коллекцию deletedUsers
                deletedUsers.add(users.get(i));
            }
        }
        System.out.println("Удалены дубликаты " + deletedUsers);
//Если нужно отсортировать коллекцию, то применяем метод Collections.sort().
        Collections.sort(deletedUsers, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
        System.out.println("Отсортированный список " + deletedUsers);
// у отсортированного списка взять последний элемент
        System.out.println("Самый старый пользователь " + deletedUsers.get((deletedUsers.size() - 1)));
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
