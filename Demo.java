public class Demo{

  public static void removeDuplicates(SuperArray s){
    for (int i = s.size() - 1; i >= 0; i--){
      String tempStr = s.get(i);
      if (s.indexOf(tempStr) < i){
        s.remove(i);
      }
    }
  }

  public static SuperArray findOverlap(SuperArray a, SuperArray b){
    SuperArray c = new SuperArray();
    for (int i = 0; i < a.size(); i++){
      for (int j = 0; j < b.size(); j++){
        if (a.get(i) == b.get(j)) c.add(a.get(i));
      }
    }
    removeDuplicates(c);
    return c;
  }

  public static SuperArray zip(SuperArray a, SuperArray b){
    SuperArray c = new SuperArray();
    for (int i = 0; i < a.size() + b.size(); i++){
      if (i < a.size()) c.add(a.get(i));
      if (i < b.size()) c.add(b.get(i));
    }
    return c;
  }

  public static void main(String[]args){
    SuperArray words = new SuperArray();
    //grouped to save vertical space
    words.add("kani");   words.add("uni");     words.add("ebi");     words.add("una");
    words.add("una");    words.add("ebi");     words.add("kani");    words.add("una");
    words.add("una");    words.add("ebi");     words.add("toro");

    SuperArray nums1 = new SuperArray();
    SuperArray nums2 = new SuperArray();

    nums1.add("9"); nums1.add("1"); nums1.add("2");
    nums1.add("2"); nums1.add("3"); nums1.add("4");

    nums2.add("0"); nums2.add("4"); nums2.add("2");
    nums2.add("2"); nums2.add("9");

    System.out.println();
    System.out.println("removeDuplicates() test");
    System.out.println(words);
    removeDuplicates(words);
    System.out.println(words);

    System.out.println();
    System.out.println("findOverlap() test");
    System.out.println(findOverlap(nums1, nums2));

    System.out.println();
    System.out.println("zip() test 1");
    SuperArray words1 = new SuperArray();
    words1.add("a");   words1.add("b");   words1.add("c");
    words1.add("d");  words1.add("e");  words1.add("f");
    SuperArray numbers1 = new SuperArray();
    numbers1.add("0");   numbers1.add("1");
    numbers1.add("2");   numbers1.add("3");
    System.out.println(Demo.zip(words1,numbers1));

    System.out.println();
    System.out.println("zip() test 2");
    SuperArray words2 = new SuperArray();
    words2.add("a");   words2.add("b");   words2.add("c");
    SuperArray numbers2 = new SuperArray();
    numbers2.add("0");   numbers2.add("1");
    numbers2.add("2");   numbers2.add("3");  numbers2.add("4");
    System.out.println(Demo.zip(words2,numbers2));
  }
}
