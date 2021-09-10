package context._6_5_paginacao;

import domain.model.Veiculo;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class Context {
    public static void main(String[] args) throws Exception {
//        Context.paginacaoSimples();
        Context.paginacaoPersonalizadaScanner();


        JpaUtil.close();
    }
    public static void paginacaoPersonalizadaScanner() throws Exception{
        /**
         * 1 - Pegar o número da página
         * 2 - Pegar o número de registros por página
         * 3 - Calcular os registros da página que o úsuario especificou.
         *     'Na página 1 teremos registros de 1 até 5 para caso o usuario tiver escolhico cinco registros por página, na página 2 teremos registros de 6 até 10 e por assim em diante. Verificamos que cada página tem o produto do numero de registros e a página, onde se eu selecionar página 3 terei 3 x 5, registros de 15 até 20, temos um problema aqui, eu não quero página 4 mas sim três logo quero os registros do produto da página selecionada - 1 e o numero de registros'.
         */

        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira o numero de registros apresentado por página: ");
        String _numeroRegistrosPorPagina = scanner.next();

        System.out.printf("Insira o numero da página ]0-*] a apresentar: ");
        String _paginaSelecionada = scanner.nextLine();

        Integer numeroRegistrosPorPagina = Integer.parseInt(_numeroRegistrosPorPagina);
        Integer paginaSelecionada = Integer.parseInt(_paginaSelecionada);
        if(paginaSelecionada.equals(0)){
            JOptionPane.showMessageDialog(null, "Página 0 não exite!", "Página errada!", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Valor para página inválido!");
        }

        EntityManager entityManager = JpaUtil.getEntityManager();

        TypedQuery<Veiculo> veiculoTypedQuery = entityManager.createQuery("select v from Veiculo v", Veiculo.class);

        Integer primeiraPagina = (paginaSelecionada-1) * numeroRegistrosPorPagina;
        ((TypedQuery) veiculoTypedQuery).setFirstResult(primeiraPagina);
        veiculoTypedQuery.setMaxResults(numeroRegistrosPorPagina);

        List<Veiculo> veiculoList = veiculoTypedQuery.getResultList();

        for(Veiculo veiculo: veiculoList){
            System.out.printf("ID - %d%nModelo - %s%n%n", veiculo.getId(), veiculo.getModelo());
        }

        entityManager.close();
    }

    public static void paginacaoPersonalizada() throws Exception{
        /**
         * 1 - Pegar o número da página
         * 2 - Pegar o número de registros por página
         * 3 - Calcular os registros da página que o úsuario especificou.
         *     'Na página 1 teremos registros de 1 até 5 para caso o usuario tiver escolhico cinco registros por página, na página 2 teremos registros de 6 até 10 e por assim em diante. Verificamos que cada página tem o produto do numero de registros e a página, onde se eu selecionar página 3 terei 3 x 5, registros de 15 até 20, temos um problema aqui, eu não quero página 4 mas sim três logo quero os registros do produto da página selecionada - 1 e o numero de registros'.
         */

        String _numeroRegistrosPorPagina = JOptionPane.showInputDialog("Insira o numero de registros apresentado por página: ");
        String _paginaSelecionada = JOptionPane.showInputDialog("Insira o numero da página ]0-*] a apresentar: ");

        Integer numeroRegistrosPorPagina = Integer.parseInt(_numeroRegistrosPorPagina);
        Integer paginaSelecionada = Integer.parseInt(_paginaSelecionada);
        if(paginaSelecionada.equals(0)){
            JOptionPane.showMessageDialog(null, "Página 0 não exite!", "Página errada!", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Valor para página inválido!");
        }

        EntityManager entityManager = JpaUtil.getEntityManager();

        TypedQuery<Veiculo> veiculoTypedQuery = entityManager.createQuery("select v from Veiculo v", Veiculo.class);

        Integer primeiraPagina = (paginaSelecionada-1) * numeroRegistrosPorPagina;
        ((TypedQuery) veiculoTypedQuery).setFirstResult(primeiraPagina);
        veiculoTypedQuery.setMaxResults(numeroRegistrosPorPagina);

        List<Veiculo> veiculoList = veiculoTypedQuery.getResultList();

        for(Veiculo veiculo: veiculoList){
            System.out.printf("ID - %d%nModelo - %s%n%n", veiculo.getId(), veiculo.getModelo());
        }

        entityManager.close();
    }

    public static void paginacaoSimples(){
        EntityManager entityManager = JpaUtil.getEntityManager();

        TypedQuery<Veiculo> veiculoTypedQuery = entityManager.createQuery("select v from Veiculo v", Veiculo.class);
        ((TypedQuery) veiculoTypedQuery).setFirstResult(0);
        veiculoTypedQuery.setMaxResults(10);

        List<Veiculo> veiculoList = veiculoTypedQuery.getResultList();

        for(Veiculo veiculo: veiculoList){
            System.out.printf("ID - %d%nModelo - %s%n%n", veiculo.getId(), veiculo.getModelo());
        }

        entityManager.close();
    }
}
