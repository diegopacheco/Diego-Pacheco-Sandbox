package com.github.diegopacheco.sandbox.java.caseclasses;

public class CaseClassMain {
	
	static class Pessoa{
		private String  nome;
		private String  endereco = "centro";
		private Integer telefone = 0;
		
		public Pessoa(String name) {
			this.nome = name;
		}

		public Pessoa(String name, String endereco, Integer telefone) {
			this.nome = name;
			this.endereco = endereco;
			this.telefone = telefone;
		}

		public String getName() {
			return nome;
		}
		public void setName(String name) {
			this.nome = name;
		}

		public String getEndereco() {
			return endereco;
		}
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

		public Integer getTelefone() {
			return telefone;
		}
		public void setTelefone(Integer telefone) {
			this.telefone = telefone;
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println( new Pessoa("Diego").getName() );
	}
	
}
