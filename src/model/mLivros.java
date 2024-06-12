package model;

public class mLivros {
    private int id_livro;
    private String Titulo;
    private String Descricao;
    private int Ano;
    private mEditoras Editora;
    private mAutores Autor;

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public int getAno() {
        return Ano;
    }

    public void setAno(int Ano) {
        this.Ano = Ano;
    }

    public mEditoras getEditora() {
        return Editora;
    }

    public void setEditora(mEditoras Editora) {
        this.Editora = Editora;
    }

    public mAutores getAutor() {
        return Autor;
    }

    public void setAutor(mAutores Autor) {
        this.Autor = Autor;
    }
    
}
