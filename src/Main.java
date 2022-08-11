import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição curso Java");
        curso1.setCargaHoraria(8);
//        System.out.println(curso1);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JavaScript");
        curso2.setDescricao("Descrição curso JavaScript");
        curso2.setCargaHoraria(4);
//        System.out.println(curso2);

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Mentoria Java");
        mentoria1.setDescricao("Descrição mentoria Java");
        mentoria1.setData(LocalDate.now());

        Mentoria mentoria2 = new Mentoria();
        mentoria2.setTitulo("Mentoria JavaScript");
        mentoria2.setDescricao("Descrição mentoria JavaScript");
        mentoria2.setData(LocalDate.now());

        Conteudo conteudo = new Curso();
        Conteudo conteudo1 = new Mentoria();

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria1);
        bootcamp.getConteudos().add(mentoria2);

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscrever_bootcamp(bootcamp);
        System.out.println("Conteúdos inscritos Camila: " + devCamila.getConteudo_inscritos());
        devCamila.progredir();
        System.out.println("Conteúdos inscritos Camila: " + devCamila.getConteudo_concluidos());
        System.out.println("XP: " + devCamila.calcularXp());

        System.out.println("------------------------------");

        Dev devGuilherme = new Dev();
        devGuilherme.setNome("Guilherme");
        devGuilherme.inscrever_bootcamp(bootcamp);
        System.out.println("Conteúdos concluidos Guilherme: " + devGuilherme.getConteudo_inscritos());
        devGuilherme.progredir();
        System.out.println("Conteúdos concluidos Guilherme: " + devGuilherme.getConteudo_concluidos());
        System.out.println("XP: " + devGuilherme.calcularXp());

    }
}