
public class Pessoa 
{
	private String nomeCompleto;
	private int anoNascimento;
	private String endere�o;
	private String sexo;
	
	@Override
	public int hashCode() 
	{
		int n = this.nomeCompleto.length() - 1;
		int h = 0;
		
		for (int c = n; c > -1; c--)
		{
			int asciiCode = (int) this.nomeCompleto.charAt(c);
			h += (int) (h + (asciiCode * (Math.pow(31, c))));
		}
		
		return h;
	}
	
	public String getNome() {
		return nomeCompleto;
	}
	public int getAnoNascimento() {
		return anoNascimento;
	}
	public String getEndere�o() {
		return endere�o;
	}
	public String getSexo() {
		return sexo;
	}
	public void setNome(String nome) {
		this.nomeCompleto = nome;
	}
	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}
	public void setEndere�o(String endere�o) {
		this.endere�o = endere�o;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
}
