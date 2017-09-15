package br.com.alura.livraria.bean;

import br.com.alura.alura_lib.dao.DAO;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.alura.livraria.modelo.Autor;
import br.com.alura.livraria.modelo.Livro;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class LivroBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Livro livro = new Livro();
    private Integer autorId;
    private DAO<Autor> autorDao;
    private DAO<Livro> livroDao;

    @Inject
    public LivroBean(DAO<Livro> livroDao, DAO<Autor> autorDao) {
        this.livroDao = livroDao;
        this.autorDao = autorDao;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }

    public Integer getAutorId() {
        return autorId;
    }

    public Livro getLivro() {
        return livro;
    }

    public List<Livro> getLivros() {
        return this.livroDao.listaTodos();
    }

    public List<Autor> getAutores() {
        return this.autorDao.listaTodos();
    }

    public List<Autor> getAutoresDoLivro() {
        return this.livro.getAutores();
    }

    public void carregarLivroPelaId() {
        this.livro = this.livroDao.buscaPorId(this.livro.getId());
    }

    public void gravarAutor() {
        Autor autor = this.autorDao.buscaPorId(this.autorId);
        this.livro.adicionaAutor(autor);
        System.out.println("Escrito por: " + autor.getNome());
    }

    public void gravar() {
        System.out.println("Gravando livro " + this.livro.getTitulo());

        if (livro.getAutores().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage("autor",
                    new FacesMessage("Livro deve ter pelo menos um Autor."));
            return;
        }

        if (this.livro.getId() == null) {
            this.livroDao.adiciona(this.livro);
        } else {
            this.livroDao.atualiza(this.livro);
        }

        this.livro = new Livro();
    }

    public void remover(Livro livro) {
        System.out.println("Removendo livro");
        this.livroDao.remove(livro);
    }

    public void removerAutorDoLivro(Autor autor) {
        this.livro.removeAutor(autor);
    }

    public void carregar(Livro livro) {
        System.out.println("Carregando livro");
        this.livro = livro;
    }

    public String formAutor() {
        System.out.println("Chamanda do formulário do Autor.");
        return "autor?faces-redirect=true";
    }

    public void comecaComDigitoUm(FacesContext fc, UIComponent component,
            Object value) throws ValidatorException {

        String valor = value.toString();
        if (!valor.startsWith("1")) {
            throw new ValidatorException(new FacesMessage(
                    "ISBN deveria começar com 1"));
        }

    }
}
