package br.inatel.myrestapi.model;

public class Curso {
	
	private Long id;
	
	private String descricao;
	
	private Integer cargaHoraria;

	//construtor gerado com Ctrl + 3 > 'gcuf' (Generate Constructor Using Fields)
	
	public Curso() {}
	
	public Curso(Long id, String descricao, Integer cargaHoraria) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.cargaHoraria = cargaHoraria;
	}

	//getters e setters gerados com Ctrl + 3 > 'ggas' (Generate Getters And Setters)

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	
	@Override
	public String toString() {
		return "Curso [id=" + id + ", descricao=" + descricao + ", cargaHoraria=" + cargaHoraria + "]";
	}

	
}
