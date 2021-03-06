import java.util.LinkedList;
import java.util.List;

public class Thief {
    int capacity = 40;
    List<String> data;
    static List<List<String>> result = new LinkedList<>();


    public Thief(List<String> data) {
        this.data = data;
        ThiefSomething();
    }

    private void ThiefSomething() {
        forceMetod();
        System.out.println(findMax(result));
    }

    private String strategy1() {
        String result = "";
        List<String> pom = data;
        List<String> maxValuesThings = new LinkedList<>();
        int sumThief = 0;

        while (sumThief < capacity) {
            String elementPomMax = "";
            int max = 0;
            int size = 0;
            for (String element : pom) {
                String[] split = element.split("/");
                if (max < Integer.parseInt(split[0])) {
                    size = Integer.parseInt(split[1]);
                    max = Integer.parseInt(split[0]);
                    elementPomMax = element;
                }
            }
            if (sumThief + size >= capacity) {
                System.out.println(maxValuesThings);
                break;
            } else {
                maxValuesThings.add(elementPomMax);
                pom.remove(elementPomMax);
                sumThief += size;
            }
        }
        return result;
    }

    private String strategy2() {
        String result = "";
        List<String> pom = data;
        List<String> minSizeThings = new LinkedList<>();
        int sumThief = 0;


        while (sumThief < capacity) {
            String elementPomMin = "";
            int min = 999;  //must be >999
            for (String element : pom) {
                String[] split = element.split("/");
                if (min > Integer.parseInt(split[1])) {
                    min = Integer.parseInt(split[1]);
                    elementPomMin = element;
                }
            }

            if (sumThief + min >= capacity) {
                System.out.println(minSizeThings);
                break;
            } else {
                minSizeThings.add(elementPomMin);
                pom.remove(elementPomMin);
                sumThief += min;
            }

        }
        return result;
    }

    private void forceMetod() {
        List<String> pom = data;
        printCombination(data, data.size());
    }

    static void combinationUtil(List<String> arr, String data[], int start,
                                int end, int index, int sumThief) {
        if (sumThief >= 40) {
            List<String> pom = new LinkedList<>();
            for (int i = 0 ; i < data.length-1 ; i++){
                pom.add(data[i]);
            }
            result.add(pom);
            return;
        }
        for (int i = start; i <= end && end - i + 1 >= index; i++) {
            data[index] = arr.get(i);
            sumThief += Integer.parseInt(arr.get(i).split("/")[1]);
            combinationUtil(arr, data, i + 1, end, index + 1, sumThief);
        }
    }

    static void printCombination(List<String> arr, int n) {
        String data[] = new String[8];
        combinationUtil(arr, data, 0, n - 1, 0, 0);
    }

    String findMax(List<List<String>> arr){
        List<String> result = null;
        int max = 0;
        for (List<String> pom:
             arr) {
            int valuesBagpack = 0;
            for (String element:
                 pom) {
                valuesBagpack += Integer.parseInt(element.split("/")[0]);
            }
            if (valuesBagpack > max){
                result = pom;
                max = valuesBagpack;
            }
        }


        return result.toString() + " " + max;
    }
}

