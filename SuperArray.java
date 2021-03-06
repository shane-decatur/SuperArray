public class SuperArray{
  private String[] data;
  private int size;

  public SuperArray(){
    data = new String[10];
    size = 0;
  }

  public SuperArray(int initialCapacity){
    if (initialCapacity < 0){
      throw new IllegalArgumentException("SuperArray capacity " + initialCapacity
        + " cannot be negative.");
    }
    data = new String[initialCapacity];
    size = 0;
  }

  public int size(){
    return size;
  }

  public boolean add(String element){
    if (size >= data.length) resize();
    data[size] = element;
    size++;
    return true;
  }

  public String get(int index){
    if (index < 0){
      throw new IndexOutOfBoundsException("Cannot get value with index "+index
        +"; index cannot be negative");
    }
    if (index >= size){
      throw new IndexOutOfBoundsException("Cannot get value with index " + index
        + "; index cannot be greater than size of SuperArray");
    }
    if (data[index] != null) {
        return data[index];
    }
    return "";
  }

  public String set(int index, String element){
    if (index < 0){
      throw new IndexOutOfBoundsException("Cannot set value with index" + index
        + "; index cannot be negative");
    }
    if (index >= size){
      throw new IndexOutOfBoundsException("Cannot set value with index " + index
        + "; index cannot be greater than size of SuperArray");
    }
    String tempElement = data[index];
    data[index] = element;
    return tempElement;
  }

  private void resize(){
    String[] arr =  new String[data.length * 2 + 1];
    for (int i = 0; i < data.length; i++){
      arr[i] = data[i];
    }
    data = arr;
  }

  public boolean isEmpty(){
    return size == 0;
  }

  public void clear(){
    for (int i = 0; i < size; i++){
      data[i] = null;
    }
    size = 0;
  }

  public String toString(){
    String strData = "[";
    for (int i = 0; i < size-1; i++){
      strData += data[i] + ", ";
    }
    if (size > 0) strData += data[size-1] + "]";
    else strData += "]";
    return strData;
  }

  public boolean contains(String s){
    for (int i = 0; i < size; i++){
      if (data[i].equals(s)){
        return true;
      }
    }
    return false;
  }

  public void add(int index, String element){
    if (index < 0){
      throw new IndexOutOfBoundsException("Cannot add to index " + index
        + "; index cannot be negative");
    }
    if (index > size){
      throw new IndexOutOfBoundsException("Cannot add to index " + index
        + "; index cannot be greater than size of SuperArray");
    }
    if (size >= data.length - 1) resize();
    for (int i = size+1; i > index; i--){
      data[i] = data[i-1];
    }
    data[index] = element;
    size++;
  }

  public String remove(int index){
    if (index < 0){
      throw new IndexOutOfBoundsException("Cannot remove from index " + index
        + "; index cannot be negative");
    }
    if (index >= size){
      throw new IndexOutOfBoundsException("Cannot remove from index " + index
        + "; index cannot be greater than size of SuperArray");
    }
    String returnVal = data[index];
    for (int i = index; i < size - 1; i++) {
      data[i] = data[i+1];
    }
    data[size - 1] = null;
    size--;
    return returnVal;
  }

  public int indexOf(String s){
    for (int i = 0; i < size; i++){
      if (data[i] != null && data[i].equals(s)) {
        return i;
      }
    }
    return -1;
  }

  public String[] toArray(){
    String[] newArr = new String[size];
    for (int i = 0; i < size; i++){
      newArr[i] = get(i);
    }
    return newArr;
  }

  public int lastIndexOf(String s){
    for (int i = size-1; i >= 0; i--){
      if (data[i] != null && data[i].equals(s)) {
        return i;
      }
    }
    return -1;
  }

  public boolean equals(SuperArray other){
    if (size != other.size()){
      return false;
    }
    for (int i = 0; i < size; i++){
      if (!get(i).equals(other.get(i))) {
        return false;
      }
    }
    return true;
  }
}
