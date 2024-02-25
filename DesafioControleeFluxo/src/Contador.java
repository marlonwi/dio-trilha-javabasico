import java.util.Locale;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Contador {
    public static void main(String[] args) throws Exception {
        contador();
    }
    static void contador(){
        try{
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Digite o primeiro parâmetro:");
        int parametroUm = scanner.nextInt();
        System.out.println("Digite o segundo parâmetro:");
        int parametroDois = scanner.nextInt();
        scanner.close();
        try{
            int resultado = conta(parametroUm, parametroDois);
            System.out.println(resultado);
        }catch(ParametrosInvalidosException exception){
            System.out.println("O primeiro parâmetro deve ser maior que o segundo!!!");
        }
        }catch(InputMismatchException e){
            System.out.println("Os parâmetros devem ser um número inteiro!!!");
        }
    }
    static int conta(int parametroUm, int parametroDois) throws ParametrosInvalidosException{
        if(parametroDois > parametroUm)
            throw new ParametrosInvalidosException();
        return parametroUm - parametroDois;
    }
}
