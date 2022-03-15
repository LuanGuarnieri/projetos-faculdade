package listaEncadeada;

import interfaces.Lista;

public class ListaEncadeada implements Lista {
	private NoLista primeiro;
	private NoLista ultimo;
	private int qtdElem;

	public ListaEncadeada() 
	{
		primeiro = null;
	}

	@Override
	public int getTamanho() {
		return qtdElem;
	}

	@Override
	public void setTamanho(int tamanho) {
		this.qtdElem = tamanho;
	}


	@Override
	public void inserir(int valor) {
		// cria um novo objeto de N�
		NoLista novoNo = new NoLista();

		// se a lista est� vazia, o primeiro elemento ser� adicionado
		if (this.estaVazia())
		{
			primeiro = novoNo;
		}
		// se n�o est� vazia, faz o �ltimo objeto adicionado apontar para o novo objeto de n�
		else
		{
			ultimo.setProx(novoNo);
		}
		// faz com que o �ltimo adicionado seja o novo n�
		ultimo = novoNo;
		// aumenta qtd elementos
		qtdElem++;
	}

	@Override
	public String exibir() 
	{
		// cria objeto N� "p" e iguala ele ao primeiro objeto da lista
		NoLista p = primeiro;
		String exibeInformacao = "[ ";
		
		// enquanto a refer�ncia do pr�ximo objeto n�o for nula, ou seja, n�o chegar ao fim da lista
		while (p != null)
		{
			exibeInformacao += p.getInfo() + " ,";
			// pega o pr�ximo objeto da lista
			p = p.getProx();
		}
		return exibeInformacao + " ]";
	}

	@Override
	public int buscar(int valor) {
		NoLista p = primeiro;
		int posicao = 0;
		
		while (p != null)
		{
			if (p.getInfo() == valor)
			{
				return posicao;
			}
			p = p.getProx();
			posicao++;
		}
		return -1;
	}

	@Override
	public void retirar(int valor) {
		NoLista anterior = null;
		NoLista p = primeiro;
		// enquanto n�o encontrar o valor a ser retirado
		while ((p != null) && (p.getInfo() != valor))
		{
			// vai percorrendo a lista
			// o atual vai ser o anterior
			anterior = p;
			// o novo vai ser o pr�ximo
			p = p.getProx();
		}
		// se achou o valor
		// garante que n�o chegou no fim da lista
		if (p != null)
		{
			// se for o primeiro elemento
			if (anterior == null)
			{
				// se o meu primeiro elemento for o que eu desejo retirar, faz com que agora o primeiro elemento
				// se torne o pr�ximo da lista, j� que tem que remover
				this.primeiro = p.getProx();
			}
			else
			{
				// faz com que o objeto anterior do deletado tenha como refer�ncia de pr�ximo o pr�ximo elemento do objeto deletado
				anterior.setProx(p.getProx());
			}
			qtdElem--;
			// atualizar a vari�vel ultimo
			// se deletei o �ltimo objeto, o �ltimo passa a ser o anterior deste
			if (ultimo == p)
			{
				ultimo = anterior;
			}
		}
	}

	@Override
	public boolean estaVazia() {
		return (qtdElem == 0);
	}

	@Override
	public void concatenar(Lista outra) {
		
	}

	@Override
	public Lista dividir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lista copiar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int pegar(int posicao) {
		// TODO Auto-generated method stub
		return 0;
	}

}