package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MergeSorting {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int i1 = new Random().nextInt(20);
            list.add(i1);
        }

        List<Integer> sort = sort(list);
        System.out.println(sort.toString());
    }

    private static List<Integer> sort(List<Integer> list) {
        if (list.size() < 2) return list;

        List<Integer> sub1 = list.subList(0, list.size() >> 1);
        List<Integer> sub2 = list.subList(list.size() >> 1, list.size());

        List<Integer> sort = sort(sub1);
        List<Integer> sort1 = sort(sub2);

        return merge(sort, sort1);
    }

    private static List<Integer> merge(List<Integer> sort, List<Integer> sort1) {
        List<Integer> tmp = new ArrayList<>();

        if (sort1.size() > sort.size()) {
            List<Integer> tp = sort;
            sort = sort1;
            sort1 = tp;
        }

        System.out.println(sort.toString() + " << " + sort1.toString());

        for (int i = 0; i < sort.size(); i++) {
            if (sort.size() == 1 && sort1.size() == 1) {
                if (sort1.get(0) < sort.get(0)) {
                    tmp.add(sort1.get(0));
                    tmp.add(sort.get(0));
                } else {
                    tmp.add(sort.get(0));
                    tmp.add(sort1.get(0));
                }
                break;
            } else {
                if (i < sort1.size()) {
                    Integer left = sort.get(i);
                    Integer right = sort1.get(i);

                    tmp.add(right < left ? right : left);
                    if (right < left) {
                        sort.set(i, right);
                        sort1.set(i, left);
                    }

                    tmp.add(sort1.get(i) < sort.get(i + 1)
                            ? sort1.get(i) : sort.get(i + 1));

                    if (sort1.get(i) < sort.get(i + 1)) {
                        int tm = sort.get(i + 1);
                        sort.set(i + 1, sort1.get(i));
                        sort1.set(i, tm);
                    }

                    tmp.add(sort1.get(i) < sort.get(i + 1)
                            ? sort.get(i + 1) : sort1.get(i));

                    i++;

                    if (sort1.size() > i)
                        tmp.add(sort1.get(i));
                }
                else
                    tmp.add(sort.get(i));
            }
        }
        System.out.println(sort.toString() + " <<  result " + sort1.toString() + "  " + tmp);
        return tmp;
    }
}
