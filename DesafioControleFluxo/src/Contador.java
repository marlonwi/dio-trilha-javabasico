import java.util.Locale;
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        contador();
    }
    static void contador(){
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Forneça o primeiro parâmetro:");
        int parametroUm = scanner.nextInt();
        System.out.println("Forneça o segundo parâmetro:");
        int parametroDois = scanner.nextInt();
        scanner.close();
        try{
            int resultado = contar(parametroUm, parametroDois);
            System.out.println(resultado);
        }catch(ParametrosInvalidosExceptions e){
            System.out.println("O segundo parâmetro não deve ser maior que o primeiro");
        }
    }
    static int contar(int parametroUm, int parametroDois) throws ParametrosInvalidosExceptions{
        if(parametroDois > parametroUm)
            throw new ParametrosInvalidosExceptions();
        return parametroUm - parametroDois;
    }
}
