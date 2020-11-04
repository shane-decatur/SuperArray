public class SuperArray{
  private String[] data;
  private int size;

  public SuperArray(){
    data = new String[10];
    size = 0;
  }

  public SuperArray(int initialCapacity){
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
    return data[index];
  }

  public String set(int index, String element){
    String tempElement = data[index];
    data[index] = element;
    return tempElement;
  }

  private void resize(){
    String[] arr =  new String[data.length * 2];
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
    strData += data[size-1] + "]";
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
    if (size >= data.length) resize();
    for (int i = size; i > index; i--){
      data[i] = data[i-1];
    }
    data[index] = element;
  }

  public void remove(int index){
    for (int i = index; i < size - 1; i++) {
      data[i] = data[i+1];
    }
    data[size - 1] = null;
  }
}
