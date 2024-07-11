package oops.generic.inheritance.nongenericsubclass;

public class Print<T> {
    T value;
    public T getPrintValues(){
        return value;
    }

    public void setPrintValues(T value) {
        this.value = value;
    }
}
