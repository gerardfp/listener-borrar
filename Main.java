import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BadScanner {

    interface BadWordListener {
        void haDichoUnaPalabrota();
    }

    List<BadWordListener> listeners = new ArrayList<>();


    String nextLine(){
        Scanner scanner = new Scanner(System.in);
        String texto = scanner.nextLine();

        if ("caca".equals(texto)){
            for (BadWordListener listener: listeners) {
                listener.haDichoUnaPalabrota();
            }

        }

        return texto;
    }
    void addBadWordListener(BadWordListener badWordListener) {
        listeners.add(badWordListener);
    }

}


class MotherMailer implements BadScanner.BadWordListener {
    void enviarUnMailAlaMadre(){
        System.out.println("He enviado una mail a tu jmadre.");
    }

    @Override
    public void haDichoUnaPalabrota() {
        enviarUnMailAlaMadre();
    }
}

class MouthWasher implements BadScanner.BadWordListener {
    void lavarLaBoca(){
        System.out.println("Te lavo la boca con jamon.");
    }

    @Override
    public void haDichoUnaPalabrota() {
        lavarLaBoca();
    }
}





class Main {
    public static void main(String[] args) {
        BadScanner badScanner = new BadScanner();

        MotherMailer motherMailer = new MotherMailer();
        MouthWasher mouthWasher = new MouthWasher();

        badScanner.addBadWordListener(motherMailer);
        badScanner.addBadWordListener(mouthWasher);



        while(true) {
            System.out.println("introduce un texto:");

            String texto = badScanner.nextLine();


            System.out.println(texto);
        }
    }
}
