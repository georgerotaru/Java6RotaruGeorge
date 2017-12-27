/*
 * Display the existance of a man who uses a vaccum cleanner and sees that a 
 * certain show begins on TV so he wakes up the woman
 */
package multithreading;

/**
 *
 * @author George
 */
public class Bob extends Thread {
private VacuumCleaner vc;
private Marleen femeie;
private Television tv;

    public Bob(VacuumCleaner v, Marleen w,Television televizor) {
        vc = v;
        femeie = w;
        tv = televizor;
        
    }

    @Override
    public synchronized void run() {
        cleaning(vc);
        System.out.println("Bob is using the vacuum cleaner");
        watchingTv(tv, femeie);
    }
    
    private void cleaning(VacuumCleaner vc){
        vc.setIsCleaning(Boolean.TRUE);
    }
    
    private void watchingTv(Television tv, Marleen femeie){
        System.out.println("Bob keeps an eye on the TV");
        while(true) {
            System.out.print(""); // if no instructions before the if statement, it is never executed. WHY ??
            if (tv.getIsFavoriteShow()==true) {
                femeie.setIsSleeping(Boolean.FALSE);
                System.out.println("Bob woke up Marleen");
                break;
            }
        }
    }
}
