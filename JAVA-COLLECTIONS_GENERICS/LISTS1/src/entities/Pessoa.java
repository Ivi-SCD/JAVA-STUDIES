package entities;

import java.util.Objects;

import Exceptions.EntitieException;

public class Pessoa {

	private String nome;
	private Integer idade;
	private Double altura;
	private Double peso;
	private char sexo;

	public Pessoa() {
	}

	public Pessoa(String name, Integer idade, Double altura,  Double peso, char sexo) {
		try {
			this.nome = name;
			this.idade = idade;
			this.altura = altura;
			this.peso = peso;
			this.sexo = sexo;
		} catch (Exception execption) {
			throw new EntitieException("\n Verificar as seguintes etapas \n"
					+ "1. Valor da altura precisa ser do tipo Double. \n"
					+ "2. O nome precisa ser dado em String. \n"
					+ "3. A idade precisa ser do tipo Integer."
					+ "4. O genero precisa ser do tipo char.");
		}
		if(sexo != 'H' && sexo != 'M') {
			throw new EntitieException("Favor utilizar um gênero válido (H, M)");
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}
	
	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(idade, other.idade);
	}

	private double pesoIdeal() {
		if (sexo == 'H') {
			return (72.7 * altura) - 58;
		} else if (sexo == 'M') {
			return (62.1 * altura) - 44.7;
		} else {
			throw new EntitieException("Unexpected Error");
		}
	}
	
	public String mostrarResultadoPeso () {
		
		Double pesoIdeal = pesoIdeal();
		
		if(peso == pesoIdeal) {
			return "Voce esta dentro do peso";
		} else if(peso > pesoIdeal) {
			return "Voce esta acima do peso";
		} else if(peso < pesoIdeal) {
			return "Voce esta abaixo do peso";
		} else {
			throw new EntitieException("Unexpected Error");
		}
	}
	
}