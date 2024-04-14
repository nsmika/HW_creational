import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = -1;
    protected String city;
    protected boolean hasAddress = false;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    public boolean hasAge() {
        return age != -1;
    }

    public boolean hasAddress() {
        return hasAddress;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge(int age) {
        if (!hasAge()) {
            throw new IllegalStateException("Возраст не указан");
        }
        return age;
    }

    public String getAddress(String city) {
        if (hasAddress()) {
            throw new IllegalStateException("Адрес не указан");
        }
        return this.city;
    }

    public void setAddress(String city) {
        this.city = city;
        this.hasAddress = true;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        child.setSurname(surname);
        child.setAddress(city);
        return child;
    }

    @Override
    public String toString() {
        return name + " " + surname + " (" + "Полных лет: " + age + " , проживает в " + city + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, city);
    }
}
