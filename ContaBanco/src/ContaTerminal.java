import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        //criando objeto scanner
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Digite o número da Agência: ");
        String agencia = scanner.next();

        System.out.println("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();

        System.out.println("Digite seu nome: ");
        String nome = scanner.next();

        System.out.println("Digite o saldo: ");
        double saldo = scanner.nextDouble();

        scanner.close();

        System.out.print("Olá " + nome + ", obrigado por criar uma conta em nosso banco, ");
        System.out.print("sua agência é " + agencia + ", conta " + numeroConta);
        System.out.println(" e seu saldo " + saldo + " já está disponível");
        System.out.println("para saque.");
    }
}
