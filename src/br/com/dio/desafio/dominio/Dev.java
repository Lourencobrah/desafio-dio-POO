package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {

    private String nome;
    private Set<Conteudo> conteudo_inscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudo_concluidos = new LinkedHashSet<>();

    public void inscrever_bootcamp(Bootcamp bootcamp){
        this.conteudo_inscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir(){
        Optional<Conteudo> conteudo = this.conteudo_inscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudo_concluidos.add(conteudo.get());
            this.conteudo_inscritos.remove(conteudo.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo");
        }
    }

    public double calcularXp(){
        return this.conteudo_concluidos.stream().mapToDouble(conteudo -> conteudo.calcularXp()).sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudo_inscritos() {
        return conteudo_inscritos;
    }

    public void setConteudo_inscritos(Set<Conteudo> conteudo_inscritos) {
        this.conteudo_inscritos = conteudo_inscritos;
    }

    public Set<Conteudo> getConteudo_concluidos() {
        return conteudo_concluidos;
    }

    public void setConteudo_concluidos(Set<Conteudo> conteudo_concluidos) {
        this.conteudo_concluidos = conteudo_concluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudo_inscritos, dev.conteudo_inscritos) && Objects.equals(conteudo_concluidos, dev.conteudo_concluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudo_inscritos, conteudo_concluidos);
    }
}
