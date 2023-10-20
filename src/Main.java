import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main{
    public static int[] noteInsuficiente(int[] note){
        List<Integer> noteInsuficiente = new ArrayList<>();
        for(int nota : note) {
            if(nota<40){
                noteInsuficiente.add(nota);
            }
        }
        int[]rezultat=new int [noteInsuficiente.size()];
        for(int i =0; i<noteInsuficiente.size(); i++){
            rezultat[i]=noteInsuficiente.get(i);
        }
        return rezultat;
    }
    public static double valoareMedie(int[] note){
        if(note.length==0){
            return 0;
        }
        int suma=Arrays.stream(note).sum();
        return (double) suma/note.length;
    }
    public static int[]noteRotunjite(int[] note){
        int[] noteRotunjite = new int[note.length];
        for(int i=0; i<note.length; i++){
            int nota=note[i];
            if (nota<38){
                noteRotunjite[i]=nota;
            }else{
                int multipluDe5=(int)Math.ceil(nota/5.0)*5;
                if (multipluDe5-nota<3){
                    noteRotunjite[i]=multipluDe5;
                }else{
                    noteRotunjite[i]=nota;
                }
            }
        }
        return noteRotunjite;
    }
    public static int notaMaximaRotunjita(int[]note){
        int maxNotaRotunjita=0;
        for(int nota:note){
            if (nota>maxNotaRotunjita){
                maxNotaRotunjita=nota;
            }
        }
        return maxNotaRotunjita;
    }
    public static void testNoteInsuficiente(){
        int[]note={84, 29, 38, 42, 51};
        int[]expected={29, 38};
        int[]result = noteInsuficiente(note);
        assert Arrays.equals(expected, result);

        int[]unexpected={84, 42, 51};
        int[]resultUnexpected=noteInsuficiente(note);
        assert !Arrays.equals(unexpected, resultUnexpected);
    }
    public static void testValoareMedie(){
        int[]note={84, 29, 38, 42, 51};
        double expected=48.8;
        double result = valoareMedie(note);
        assert Math.abs(expected-result)<0.001;

        int[]noteEmpty={};
        double unexpected=0.0;
        double resultUnexpected=valoareMedie(noteEmpty);
        assert Math.abs(unexpected-resultUnexpected)<0.001;
    }
    public static void testNoteRotunjite(){
        int[]note={84, 29, 38, 42, 51};
        int[]expected={85, 29, 40, 42, 50};
        int[]result=noteRotunjite(note);
        assert Arrays.equals(expected, result);

        int[]unexpected={84, 29, 38, 42, 51};
        int[]resultUnexpected=noteRotunjite(note);
        assert !Arrays.equals(unexpected, resultUnexpected);
    }
    public static void testNotaMaximaRotunjita(){
        int[]note={84, 29, 38, 42, 51};
        int expected=85;
        int result=notaMaximaRotunjita(note);
        assert expected==result;

        int[] notaEmpty={};
        int unexpected=0;
        int resultUnexpected=notaMaximaRotunjita(notaEmpty);
        assert unexpected!= resultUnexpected;
    }


    public static void main(String[]args){

        testNoteInsuficiente();
        testValoareMedie();
        testNoteRotunjite();
        testNotaMaximaRotunjita();
        int[] note={84, 29, 38, 42, 51};
        int[] noteInsuf=noteInsuficiente(note);
        System.out.println("Note insuficiente: " + Arrays.toString(noteInsuf));

        double medie=valoareMedie(note);
        System.out.println("Valoare medie: " + medie);

        int[] noteRotunj=noteRotunjite(note);
        System.out.println("Note rotunjite: " + Arrays.toString(noteRotunj));

        int notaMaxRotunjita=notaMaximaRotunjita(note);
        System.out.println("Nota maxima rotunjita: "+ notaMaxRotunjita);
    }
}