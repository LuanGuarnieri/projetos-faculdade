package pilhaVetor;

import interfacesPilha.Pilha;
/*
 * Esta pilha � limitada
 * Um vetor � utilizado para armazenar os dados da pilha
 * tamanho indica quantos elementos j� foram inseridos
 * os elementos que s�o inseridos ocupam as primeiras posi��es livres do vetor
 * 
 * CRIA��O DA PILHA -> construtor
 * Estabelece tamanho m�ximo
 * Inicializa os atributos do tamanho atual
 * 
 * INCLUS�O DE ELEMENTO
 * m�todo push -> throw exception se a pilha estiver cheia
 * 
 * OBTER O TOPO DA PILHA
 * tamanho - 1 -> posi��o do �ltimo elemento
 * 
 * REMOVER ELEMENTO DA PILHA
 * tamanho = tamanho - 1
 * se for de objetos -> deve-se colocar null na posi��o do objeto removido
 * 
 */

public class PilhaVetor <T> implements Pilha<T>
{
	private int limite;
	private int tamanho = 0;
	private T[] info;

	public PilhaVetor(int limite) 
	{
		this.info = (T[]) new Object[limite];
		this.limite = limite;
	}

	@Override
	public void push(T valor) 
	{
		if (this.tamanho == this.limite) {
			throw new RuntimeException("A pilha est� cheia!");
		}
		this.info[tamanho] = valor;
		this.tamanho++;

	}

	@Override
	public T pop()
	{
		if (estaVazia()) 
		{
			throw new RuntimeException("A pilha vazia.");
		} 
		
		T elemento = this.info[tamanho - 1];
		this.info[tamanho - 1] = null;
		this.tamanho--;
		return elemento;
	}

	@Override
	public T peek() 
	{
		if (estaVazia()) 
		{
			throw new RuntimeException("A pilha vazia.");
		}
		// -1 pois precisa da posi��o (vetor come�a em 0)
		return this.info[tamanho - 1];
	}

	@Override
	public boolean estaVazia()
	{
		return this.tamanho == 0;
	}

	@Override
	public void liberar() 
	{
		this.info = (T[]) new Object[this.limite];
		this.tamanho = 0;
	}
	@Override
	public String toString() 
	{
		String elementos = "";
		// faz do topo at� a base
		for (int i = this.tamanho - 1; i >= 0; i--)
		{
			elementos += this.info[i]+", ";
		}
		//  - 2 elementos pra tirar o ", " 
		// a partir da posi��o 0, vai pegar at� o fim da string e tirar dois elementos
		// vai de 0 at� o fim -2
		//...
		// m�todo max da classe Math -> se a string for vazia
		// passa dois valores e ele retorna o maior dos dois
		// pedindo pra ele retornar qual o maior valor entre 0 e -2 caso a string seja vazia
		//
		elementos = elementos.substring(0, Math.max(0,elementos.length()-2));
		return "topo -> [" + elementos + "] <- base";
	}
}
