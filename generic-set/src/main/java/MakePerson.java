public class MakePerson {
    public static void main (String [] args){
        SetList <Person> personList = new SetList <Person>();
        personList.insert(new Person("Moshe ","Cohen","305269847", 1995));
        personList.insert(new Person("Chaim ","Levi","369852365", 1993));
        personList.insert(new Person("Aharon ","Afik","201458789", 2001));
        personList.insert(new Person("Yosef ","Porat","302569856", 1985));
        personList.insert(new Person("Dan ","Eshel","314785201", 2015));
        System.out.println(personList.toString());

        Method method = new Method();
        Person smallest = method.findMin(personList);
        System.out.println("The smallest person by ID is: " + smallest);
    }
}
