package listaEstatica;

import interfaces.Lista;

/**
 * 
 * @author maria
 *
 */
public class ListaEstatica implements Lista 
{
	private int[] info;
	private int tamanho;
	
	public ListaEstatica() 
	{
		info = new int[10];
		tamanho = 0;
	}	
	
	// arrayList.size() -> equivalente
	@Override
	public int getTamanho() {
		return tamanho;
	}

	@Override
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int[] getInfo() {
		return info;
	}

	public void setInfo(int[] info) {
		this.info = info;
	}

	private void redimensionar()
	{
		// declara novo vetor
		int[] novo;
		// declara o novo tamanho
		int novoTamanho = info.length + 10;
		
		// determina o tamanho do novo vetor
		novo = new int[novoTamanho];
		
		// processo de c�pia de um vetor para outro
		for (int i = 0; i < tamanho; i++) 
		{
			novo[i] = info[i];
		}
		
		info = novo;
	}
	
	@Override
	public void inserir(int valor)
	{
		if (tamanho == info.length)
		{
			this.redimensionar();
		}
		
		this.info[tamanho] = valor;
		tamanho++;
	}
	
	@Override
	public String exibir()
	{
		String retorno = "[";
		for (int i = 0; i < tamanho; i++)
		{
			retorno += info[i] + ", ";
		}
		return retorno + "]";
	}
	
	@Override
	public int buscar(int valor)
	{
		// percorrer somente as posi��es usadas
		for (int posicao = 0; posicao < tamanho; posicao++)
		{
			if (info[posicao] == valor)
			{
				return posicao;
			}
		}
		return -1;
	}
	

	@Override
	public void retirar(int valor) {
		int posicao = buscar(valor);
		if (posicao != -1) {
			for (int i = posicao; i < tamanho - 1; i++) {
				info[i] = info[i + 1];
			}
			tamanho--;
		}
	}
	
	@Override
	public boolean estaVazia()
	{
		// para estar vazio, o array deve ter tamanho 0
		return (tamanho == 0);
	}
	
	@Override
	public void concatenar(Lista outra)
	{	
		for (int i = 0; i < outra.getTamanho(); i++)
		{
			inserir(outra.pegar(i));
		}
	}
	
	@Override
	public Lista dividir()
	{
		int metade = this.getTamanho()/2;

		Lista listaRetornada = new ListaEstatica();
		
		for (int i = metade; i < this.getTamanho(); i++)
		{
			listaRetornada.inserir(this.info[i]);
		} 
		tamanho = metade;
		return listaRetornada;
	} 
	
	@Override
	public Lista copiar()
	{
		Lista listaCopiada = new ListaEstatica();
		
		for (int i = 0; i < info.length; i++)
		{
			listaCopiada.inserir(this.info[i]);
		}
		
		return listaCopiada;
	}

	@Override
	public int pegar(int posicao) {
		return info[posicao];
	}
	
}