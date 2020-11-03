public class SuperArray{
  private String[] data;
  private int size;

  public SuperArray(){
    data = new String[10];
    size = 0;
  }

  public int size(){
    return size;
  }

  public boolean add(String element){
    if (size > data.length) resize();
    data[size] = element;
    size++;
    return true;
  }

  public String get(int index){
    return data[index];
  }

  public String set(int index, String element){
    data[index] = element;
    return data[index];
  }

  public void resize(){
    String[] arr;
    arr = new String[data.length + 10];
    for (int i = 0; i < data.length; i++){
      arr[i] = data[i];
    }
    data = arr;
  }
}
