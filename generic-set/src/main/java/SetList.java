import java.util.ArrayList;
import java.util.Iterator;

public class SetList<E>{
    private ArrayList <E> setList;

    public SetList(){
        setList = new ArrayList <E> ();
    }

    public SetList (E [] arr)
    {
        setList = new ArrayList <E>();
        Iterator<E> iterator = setList.iterator();
        while (iterator.hasNext()) {
            insert(iterator.next());
        }
    }

    private boolean equals ( E x, E y){
        return x.equals(y);
    }

    public void union (SetList<E> otherSet){
        Iterator<E> iterator = otherSet.iterator();
        while (iterator.hasNext()){
            insert(iterator.next());
        }
    }

    public void intersect(SetList <E> otherSet) {
        Iterator<E> iterator = setList.iterator();
        while (iterator.hasNext()){
            if (!(otherSet.isMember(iterator.next())))
                iterator.remove();
        }
    }

    public boolean isSubset (SetList <E> otherSet){
        Iterator<E> iterator = otherSet.iterator();
        while (iterator.hasNext()){
            if (!(isMember(iterator.next())))
                return false;
        }
        return true;
    }

    public boolean isMember(E element){
        Iterator<E> iterator = setList.iterator();
        while (iterator.hasNext()){
            if(equals(iterator.next(), element))
                return true;
        }
        return false;
    }

    public void insert(E element) {
        if (!isMember(element)) {
            setList.add(element);
        }
    }

    public void delete(E element){
        if(isMember(element))
            setList.remove(element);
    }

    public Iterator <E> iterator(){
        return setList.iterator();
    }

    public String toString() {
        Iterator<E> iterator = setList.iterator();
        String setString = "{";
        while (iterator.hasNext()){
            setString += iterator.next() + ", ";
        }
        if (setString.length() > 1) {
            setString = setString.substring(0, setString.length() - 2);
        }
        setString += "}";
        return setString;
    }






}
