package banco;

import cliente.Cliente;
import cliente.conta.Conta;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static int opcao;
    static Scanner scanner = new Scanner(System.in);
    static String nomeBanco;
    static Banco banco;

    public static void main(String[] args) {
        System.out.println("Qual o nome do banco: ");
        nomeBanco = scanner.nextLine();
        banco = new Banco(nomeBanco);

        menu();
        }
        static void menu(){
            System.out.println("-------Bem-vindo ao banco " + nomeBanco + "-------");
            do{

                System.out.println("-----------Menu de opções-----------");
                System.out.println("Opção 1: Abrir conta");
                System.out.println("Opção 2: Acessar a conta");
                System.out.println("Opção 3: Sair");
                System.out.println("Digite sua opção: ");
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        scanner.nextLine();
                        criarConta();
                        break;
                    case 2:
                        acessarConta();
                        break;
                    case 3:
                        System.out.println("O banco " + nomeBanco + " agradece sua preferencia, volte sempre");
                        System.exit(0);
                }
            }while(opcao != 3);
        }
    public static void criarConta(){
        System.out.println("Digite seu nome completo: ");
        String nomeCliente = scanner.nextLine();
        Cliente novoCliente = new Cliente (nomeCliente);
        Conta novaConta = new Conta(novoCliente);
        banco.listaContas.add(novaConta);
        System.out.println("Nova conta aberta, segue seus dados: ");
        novaConta.imprimirExtrato();
    }
    public static void acessarConta(){
        System.out.println("Digite sua conta: ");
        int conta = scanner.nextInt();
        System.out.println("Digite sua agência: ");
        int agencia = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o nome do titular da conta: ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = new Cliente (nomeCliente);
        Conta contaAcessada = new Conta(cliente, conta, agencia);
        contaAcessada = banco.buscaConta(conta, agencia, contaAcessada);
        if(contaAcessada.getNumeroConta() == 0)
            System.out.println("Conta não cadastrada no banco!!!");
        else {
            do {
                System.out.println("Opção 1: Depositar");
                System.out.println("Opção 2: Sacar");
                System.out.println("Opção 3: Transferir");
                System.out.println("Opção 4: Imprimir Extrato");
                System.out.println("Opção 5: Sair");
                System.out.println("Digite sua opção: ");
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.println("Valor a ser depositado: ");
                        double valor = scanner.nextDouble();
                        contaAcessada.depositar(valor);
                        break;
                    case 2:
                        int resultado;
                        System.out.println("Valor a ser sacado: ");
                        double valorSaque = scanner.nextDouble();
                        resultado = contaAcessada.sacar(valorSaque);
                        if (resultado == 0)
                            System.out.println("Saldo insuficiente!!!");
                        else {
                            System.out.println("O saque de " + valorSaque + " foi efetuado com sucesso");
                        }
                        break;
                    case 3:
                        System.out.println("Digite a conta destino: ");
                        int numeroContaDestino = scanner.nextInt();
                        System.out.println("Digite agência da conta destino: ");
                        int agenciaDestino = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Digite o nome do titular da conta destino: ");
                        String nomeClienteDestino = scanner.nextLine();
                        Cliente clienteDestino = new Cliente(nomeClienteDestino);
                        Conta contaDestino = new Conta(clienteDestino, numeroContaDestino, agenciaDestino);
                        contaDestino = banco.buscaConta(conta, agencia, contaDestino);
                        if (contaDestino.getNumeroConta() == 0)
                            System.out.println("Conta não cadastrada no banco!!!");
                        else {
                            System.out.println("Qual valor da transferencia: ");
                            double valorTransferencia = scanner.nextDouble();
                            if (contaAcessada.sacar(valorTransferencia) == 0)
                                System.out.println("Saldo indisponível!!!");
                            else {
                                contaDestino.depositar(valorTransferencia);
                                System.out.println("Transferencia realizada com sucesso!!!");
                            }

                        }
                        break;
                    case 4:
                        contaAcessada.imprimirExtrato();
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Opção inválida!!!");
                }
            } while (opcao != 5);
           }
        }
}
