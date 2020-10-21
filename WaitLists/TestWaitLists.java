package WaitLists;

public class TestWaitLists { 
    public static final Integer[] values = {8, 5, 12345, null, 8, 5};
    public static final boolean detailedReport = true;

    /*public static boolean TestWaitList(String listName, boolean detailedReport){
        WaitList<Integer> intWL;
        switch (listName) {
            case ("WaitList") -> intWL = new WaitList<>();
            case ("BoundedWaitList") -> intWL = new BoundedWaitList<>(4);
            case ("UnfairWaitList") -> intWL = new UnfairWaitList<>();
            default -> intWL = new WaitList<>();
        }
    }*/

    public static void main(String[] args) {
        boolean result;
        String underline = "________________________________________\n\n";
        WaitList<Integer> intWL = new WaitList<>();
        String listName = intWL.getClass().getSimpleName();
        result = setWaitList(intWL, listName);
        intWL.remove();
        intWL.remove();
        intWL.remove();
        if(detailedReport)
            System.out.println(intWL);
        result = result && (intWL.remove() == null);
        System.out.println(listName + " testing result: " +
                (result ? "OK" : "ERROR") + "!\n" + underline);


        BoundedWaitList<Integer> intBWL = new BoundedWaitList<>(4);
        listName = intBWL.getClass().getSimpleName();
        result = setWaitList(intBWL, listName);
        intBWL.remove();
        intBWL.remove();
        if(detailedReport)
            System.out.println(intBWL);
        result = result && intBWL.isEmpty();
        System.out.println(listName + " testing result: " +
                (result ? "OK" : "ERROR") + "!\n" + underline);


        UnfairWaitList<Integer> intUWL = new UnfairWaitList<>();
        listName = intUWL.getClass().getSimpleName();
        result = setWaitList(intUWL, listName);
        result = result && intUWL.remove(values[4]);
        result = result &&
                !(intUWL.contains(values[4]) || !intUWL.contains(values[5]));
        result = result && intUWL.moveToBack(values[2]);
        if(detailedReport)
            System.out.println(intUWL.toString() + '\n');
        intUWL.remove();
        result = result && !(intUWL.moveToBack(values[5]));
        intUWL.remove();
        result = result && intUWL.isEmpty();
        if(detailedReport) {
            System.out.println(intUWL);
            System.out.println(listName + " empty == " +
                    intUWL.isEmpty() + '\n');
        }
        System.out.println(listName + " testing result: " +
                (result ? "OK" : "ERROR") + "!\n" + underline);
    }


    public static boolean setWaitList(WaitList<Integer> intWL,
            String listName) {
        if(detailedReport)
            System.out.println("Testing " + listName + ':');
        if(detailedReport) {
            System.out.println(intWL);
            System.out.println(
                    listName + " empty == " + intWL.isEmpty() + '\n');
        }
        if(!intWL.isEmpty())
            return false;

        for(int i = 0; i < values.length; i++) {
            intWL.add(values[i]);
            if(i == 0 || i == 3) {
                if(detailedReport) {
                    System.out.println(intWL);
                    System.out.println(listName + " contains " +
                            values[0] + " == " + intWL.contains(values[0]));
                    System.out.println(listName + " contains " +
                            values[3] + " == " + intWL.contains(values[3]));
                    System.out.println(listName + " contains " +
                            values[1] + " == " + intWL.contains(values[1]) +
                            '\n');
                }
                if(!intWL.contains(values[0]) ||
                        (!intWL.contains(values[1]) && i == 3))
                    return false;
            }
        }
        if(detailedReport) {
            System.out.println(intWL);
            System.out.println(listName + " empty == " + intWL.isEmpty() + '\n');
        }

        if(!intWL.remove().equals(values[0]))
            return false;
        if(!intWL.remove().equals(values[1]))
            return false;
        if(detailedReport) {
            System.out.println(intWL);
            System.out.println(listName + " contains " +
                    values[4] + " == " + intWL.contains(values[4]));
            System.out.println(listName + " contains " +
                    values[5] + " == " + intWL.contains(values[5]) + '\n');
        }
        return true;
    }
}
