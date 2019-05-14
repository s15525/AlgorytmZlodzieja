import java.util.LinkedList;
import java.util.List;

public class Thief {
    int capacity = 40;
    List<String> data;

    public Thief(List<String> data) {
        this.data = data;
        ThiefSomething();
    }

    private void ThiefSomething() {

        int n = 0;
        String sum = "";
//        strategy1();
//        strategy2();
        forceMetod();
//        for (int i = 0; i <= data.size()-1; i++) {
//            String element = data.get(i);
//            String[] split = element.split("/");
//            if (SumThief + Integer.parseInt(split[1]) <= capacity) {
//                sum += " " + element;
//                SumThief = SumThief + Integer.parseInt(split[1]);
//            } else {
//                System.out.println("Plecak: " + n + "{ " + sum + " } ");
//                n++;
//                sum = "";
//                SumThief = 0;
//            }
        }

    private String strategy1() {
        String result = "";
        List<String> pom = data;
        List<String> maxValuesThings = new LinkedList<>();
        int sumThief = 0;

        while(sumThief < capacity){
            String elementPomMax = "";
            int max = 0;
            int size = 0;
            for (String element: pom) {
                String[] split = element.split("/");
                if (max < Integer.parseInt(split[0])){
                    size = Integer.parseInt(split[1]);
                    max = Integer.parseInt(split[0]);
                    elementPomMax = element;
                }
            }
            if (sumThief + size >= capacity){
                System.out.println(maxValuesThings);
                break;
            }else {
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

            if (sumThief + min >= capacity){
                System.out.println(minSizeThings);
                break;
            }else {
                minSizeThings.add(elementPomMin);
                pom.remove(elementPomMin);
                sumThief += min;
            }

        }
        return result;
    }

    private void forceMetod(){
        List<String> pom = data;

        printCombination(data,data.size(),5);
    }

    static void combinationUtil(List<String> arr, String data[], int start,
                                int end, int index, int r)
    {
        if (index == r)
        {
            for (int j=0; j<r; j++)
                System.out.print(data[j]+" ");
            System.out.println("");
            return;
        }
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr.get(i);
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }
    static void printCombination(List<String> arr, int n, int r)
    {
        String data[]=new String[r];
        combinationUtil(arr, data, 0, n-1, 0, r);
    }
}

