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
            int resultado = conta(parametroUm, parametroDois);
            System.out.println(resultado);
        }catch(ParametrosInvalidosException e){
            System.out.println("O primeiro parâmetro deve ser maior que o segundo!!!");
        }

    }
    static int conta(int parametroUm, int parametroDois) throws ParametrosInvalidosException{
        if(parametroDois > parametroUm)
            throw new ParametrosInvalidosException();
        return parametroUm - parametroDois;
    }
}
