package Chapter_11_a_19;

/*
Write a method called rarest that accepts a map whose keys are strings and whose values are integers as a parameter
and returns the integer value that occurs the fewest times in the map. If there is a tie, return the smaller integer value. If
If the map is empty, throw an exception
 */

import java.util.*;

public class Exercise_19
{
    public static void main(String[] args)
    {
        Map<String, Integer> map = new HashMap<>();

        map.put("uha", 1);
        map.put("uhada", 2);
        map.put("uhadada", 3);
        map.put("uhadadada", 4);
        map.put("uha", 5);
        map.put("uhada", 6);

        System.out.println(rarest(map));

    }

    public static int rarest (Map<String, Integer> map)
    {
        Map<Integer, Integer> tempM = new HashMap<>();

        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            int number = map.get(entry.getKey());

            if (tempM.containsKey(number))
            {
                tempM.put(number, tempM.get(number)+1);
            }
            else
            {
            tempM.put(number, 1);

            }

        }
        Set<Integer> tempS = tempM.keySet();
        Iterator<Integer> itr = tempS.iterator();
        Integer min =  itr.next();

        while(itr.hasNext())
        {
            Integer cur = itr.next();
            if (tempM.get(cur) < tempM.get(min))
            {
                min = cur;

            }
        }
        return min;
    }

}
