public class Person implements Comparable <Person>{
    private String name;
    private String lastName;
    private String id;
    private int yearOfBirth;

    public  Person(String _name, String _lastName, String _id, int _yaerOfBirth){
        name = _name;
        lastName = _lastName;
        id = _id;
        yearOfBirth = _yaerOfBirth;
    }

    public int compareTo(Person other) {
        return id.compareTo(other.id);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return id.equals(person.id);
    }

    public int hashCode() {
        return id.hashCode();
    }

    public String toString(){
        return "\n{name: " + name +  lastName + ", id: " + id + ", year of birth: " + yearOfBirth + "}";
    }


}
