package funcionalidades;

public class FuncionalidadesIphone implements AparelhoTelefonico, NavegadorInternet, ReprodutorMusical{
	public void ligar() {
		System.out.println("Ligando para o numero discado");
	}
	public void atender() {
		System.out.println("Atendendo a ligação");
	}
	public void inciarCorreioVoz() {
		System.out.println("Iniciando correio de voz");
	}
	public void exibirPagina() {
		System.out.println("Exibindo a página");
	}
	public void adicionarNovaAba() {
		System.out.println("Nova aba adicionada");
	}
	public void atualizarPagina() {
		System.out.println("Página atualizada");
	}
	public void tocar() {
		System.out.println("Tocando música");
	}
	public void pausar() {
		System.out.println("Música pausada");
	}
	public void selecinarMusica() {
		System.out.println("Tocando a musica selecionada");
	}
}

