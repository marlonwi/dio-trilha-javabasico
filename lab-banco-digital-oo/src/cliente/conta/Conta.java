package cliente.conta;

import cliente.Cliente;

public class Conta {
    private static final int AGENCIA = 1;
    private static int CONTADOR = 1;

    protected Cliente cliente;
    protected int agencia;
    protected int numeroConta;
    protected double saldo;

    public Conta(Cliente cliente){
        setAgencia(AGENCIA);
        setCliente(cliente);
        setSaldo(0);
        setNumeroConta(CONTADOR);
        CONTADOR++;
    }
    public Conta(Cliente cliente, int numeroConta, int agencia){
        setAgencia(agencia);
        setCliente(cliente);
        setSaldo(0);
        setNumeroConta(numeroConta);
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }
    public int sacar(double valor){
        if(valor > saldo)
            return 0;
        saldo -= valor;
        return 1;
    }
    public int depositar(double valor){
        saldo += valor;
        return 1;
    }
    public int transferir(double valor, Conta contaDeposito){
        if(valor > this.saldo)
            return 0;
        contaDeposito.saldo = contaDeposito.getSaldo() + valor;
        return 1;
    }

    public String toString(){
        return "\nNome titular: " + getCliente().getNome() + "\nNumero da conta: " + getNumeroConta() +
                "\nAgencia da conta: " + getAgencia() + "\nSaldo em conta: " + getSaldo() + "\n";
    }
    public void imprimirExtrato(){
        String extrato = this.toString();
        System.out.println(extrato);
    }
}