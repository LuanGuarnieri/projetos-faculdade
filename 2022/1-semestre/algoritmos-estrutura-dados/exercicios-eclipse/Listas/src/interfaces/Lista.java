package interfaces;

public interface Lista 
{

	// arrayList.size() -> equivalente
	int getTamanho();

	void setTamanho(int tamanho);

	void inserir(int valor);

	String exibir();

	int buscar(int valor);

	void retirar(int valor);

	boolean estaVazia();

	void concatenar(Lista outra);

	Lista dividir();

	Lista copiar();
	
	int pegar(int posicao);
}