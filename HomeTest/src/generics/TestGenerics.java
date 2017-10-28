/*
 * Test Generics classes
 */
package generics;

/**
 *
 * @author George
 */
public class TestGenerics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String sir = "Sirul de pus in cutie";
        // create a new Box for Strings
        Box<String> cutiuta = new Box<>();
        cutiuta.setVolume(sir);
        
        // create a Box of Double
        Double numarCuVirgula = 223.882;
        Box<Double> cutioaie = new Box();
        cutioaie.setVolume(numarCuVirgula);
        
        // create a Box for Bocanc
        Bocanc bocanc = new Bocanc();
        Box<Bocanc> cutieDeBocanci = new Box<>();
        cutieDeBocanci.setVolume(bocanc);
        
        System.out.println("Cutiuta de siruri contine: " + cutiuta.getVolume());
        System.out.println("Cutioaia cu Double contine: " + cutioaie.getVolume());
        System.out.println("Cutia de bocanci contine: " + cutieDeBocanci.getVolume());
        
        // create Urna for Integer
        Integer numarIntreg = 12;
        Urna<Integer> urnaCuIntregi = new Urna<>();
        urnaCuIntregi.setMyNumber(numarIntreg);
        System.out.println("Urna contine: " +urnaCuIntregi.getMyNumber());
        
        Integer i = 10;
        String s = "Aha!";
        OrderedPair<Integer, String> perechiOrdonate = new OrderedPair<>(i, s);
        System.out.println("Perechea ordonata este: (" + perechiOrdonate.getKey()+","+ perechiOrdonate.getValue()+")");
        
        // test generic method
        // call a generyc type method
        OrderedPair<Integer, String> p1 = new OrderedPair<>(1, "apple");
        OrderedPair<Integer, String> p2 = new OrderedPair<>(2, "pear");
        OrderedPair<Integer, String> p3 = new OrderedPair<>(1, "apple");
        boolean same;
        same = Util.<Integer, String>compare(p1, p2);
        System.out.println("("+p1.getKey()+","+p1.getValue()+") is equal with ("+p2.getKey()+","+p2.getValue()+") is "+same);
        same = Util.<Integer, String>compare(p1, p3);
        System.out.println("("+p1.getKey()+","+p1.getValue()+") is equal with ("+p3.getKey()+","+p3.getValue()+") is "+same);
    }
}