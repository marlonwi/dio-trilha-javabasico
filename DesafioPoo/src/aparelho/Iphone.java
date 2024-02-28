package aparelho;
import funcionalidades.FuncionalidadesIphone;

public class Iphone {
	public static void main(String[] args) {
		FuncionalidadesIphone iphone = new FuncionalidadesIphone();
		iphone.atender();
		iphone.adicionarNovaAba();
		iphone.atualizarPagina();
		iphone.exibirPagina();
		iphone.inciarCorreioVoz();
		iphone.ligar();
		iphone.pausar();
		iphone.selecinarMusica();
		iphone.tocar();
	}
}
