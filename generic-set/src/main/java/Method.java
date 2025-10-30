import java.util.Iterator;

public class Method {
    public <E extends Comparable<E>> E findMin(SetList <E> setList){
       Iterator <E> iterator = setList.iterator();
       E minElement =  iterator.next();
       while (iterator.hasNext()){
           E currentElement = iterator.next();
           if (currentElement.compareTo(minElement) < 0) {
               minElement = currentElement;
           }
       }
        return minElement;
    }
}
