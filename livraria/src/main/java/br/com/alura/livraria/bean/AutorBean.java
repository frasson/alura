package br.com.alura.livraria.bean;

import br.com.alura.alura_lib.dao.DAO;
import java.io.Serializable;
import java.util.List;

import br.com.alura.livraria.modelo.Autor;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AutorBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Autor autor = new Autor();
    private Integer autorId;
    private DAO<Autor> autorDao;
    
    @Inject
    public AutorBean(DAO<Autor> autorDao) {
        this.autorDao = autorDao;
    }

    public Integer getAutorId() {
        return autorId;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }

    public void carregarAutorPelaId() {
        this.autor = this.autorDao.buscaPorId(autorId);
    }

    public String gravar() {
        System.out.println("Gravando autor " + this.autor.getNome());

        if (this.autor.getId() == null) {
            this.autorDao.adiciona(this.autor);
        } else {
            this.autorDao.atualiza(this.autor);
        }

        this.autor = new Autor();

        return "livro?faces-redirect=true";
    }

    public void remover(Autor autor) {
        System.out.println("Removendo autor " + autor.getNome());
        this.autorDao.remove(autor);
    }

    public List<Autor> getAutores() {
        return this.autorDao.listaTodos();
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
