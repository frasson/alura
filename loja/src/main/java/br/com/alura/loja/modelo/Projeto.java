package br.com.alura.loja.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.XStream;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Projeto {
	private Long id;
	private String name;
	private int ano;

	public Projeto(long l, String string, int i) {
		this.id = l;
		this.name = string;
		this.ano = i;
	}

	public Projeto() {
	}

	public String toXML() {
		return new XStream().toXML(this);
	}

	public void setId(long id2) {
		this.id = id2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
}
