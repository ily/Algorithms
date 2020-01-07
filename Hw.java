
// Java code for adding elements in Set 
import java.util.*;
import java.nio.file.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Hw {


 public static LinkedHashMap<Integer, String> sortHashMapByValues(HashMap<Integer, String> passedMap) {
    List<Integer> mapKeys = new ArrayList<>(passedMap.keySet());
    List<String> mapValues = new ArrayList<>(passedMap.values());
    Collections.sort(mapValues);
    Collections.sort(mapKeys);

    LinkedHashMap<Integer, String> sortedMap = new LinkedHashMap<>();

    Iterator<String> valueIt = mapValues.iterator();
    while (valueIt.hasNext()) {
      String val = valueIt.next();
      Iterator<Integer> keyIt = mapKeys.iterator();

      while (keyIt.hasNext()) {
        Integer key = keyIt.next();
        String comp1 = passedMap.get(key);
        String comp2 = val;

        if (comp1.equals(comp2)) {
          keyIt.remove();
          sortedMap.put(key, val);
          break;
        }
      }
    }
    return sortedMap; 
  }

  public static void main(String[] args) {
    Set<String> sset = new HashSet<String>();

    try {
      Scanner scanner = new Scanner(new File(args[0]));
      while (scanner.hasNextLine()) {
        sset.add(scanner.nextLine());
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    
    long start =System.currentTimeMillis();

    List<String> list = new ArrayList<String>(sset);
    Collections.sort(list);
    //System.out.println(list);

    long finish =System.currentTimeMillis();
    System.out.println("Set data structure sort took " + (finish-start) + "ms");


    /*************************************************************** */

    HashMap<Integer, String> map = new HashMap<Integer, String>();

    try {
      Scanner scannerh = new Scanner(new File(args[1]));
      int i = 1;
      while (scannerh.hasNextLine()) {
        map.put(i, scannerh.nextLine());
        //System.out.println(map);
        i = i + 1;
      }
      scannerh.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();

    }
    long starth =System.currentTimeMillis();
    sortHashMapByValues(map);

    //System.out.println(sortHashMapByValues(map));
    long finishh =System.currentTimeMillis();
    System.out.println("Hash data structure sort took " + (finishh - starth) + "ms");
  
  }}
