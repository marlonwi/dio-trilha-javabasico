package banco;

import cliente.conta.Conta;

import java.util.ArrayList;
import java.util.List;

import static java.lang.constant.ConstantDescs.NULL;

public class Banco {
    protected List<Conta> listaContas;
    private String nome;

    public Banco(String nome){

        setNome(nome);
        setListaContas();
    }

    public void setListaContas() {
        listaContas = new ArrayList<>();
    }

    public List<Conta> getListaContas() {
        return listaContas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    protected Conta buscaConta(int numeroConta, int agenciaConta, Conta contaAcessada) {
        contaAcessada.setNumeroConta(0);
        for(Conta c : listaContas) {
            if (c.getNumeroConta() == numeroConta && c.getAgencia() == agenciaConta)
                contaAcessada = c;
        }
        return contaAcessada;
    }
}

