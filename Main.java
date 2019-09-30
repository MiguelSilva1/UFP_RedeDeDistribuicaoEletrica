/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import projeto.excepcoes.CasaException;
import projeto.excepcoes.EquipamentosDomesticosException;
import projeto.imports.Date;
import projeto.imports.In;

/**
 *
 * @author Diogo Miranda & Miguel Silva
 */
public class Main {

    //R14
    /**
     * Retorna um Grafo a partir de um ficheiro binário
     *
     * @return grafo
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Rede carregaGrafoDeFicheiroBinario() throws FileNotFoundException, IOException, ClassNotFoundException {
        String filename = "Grafo.bin";
        File f = new File(filename);
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Rede grafo = (Rede) ois.readObject();
        return grafo;
    }
    
    /*
    //R14
    public Rede carregaGrafoDeFicheiroTexto(){
        In in = new In(".//src//projeto//data//grafo.txt");
        Rede grafo = grafo.FlowNetwork(in);
        return grafo;
    }
    */
    public static void main(String[] args) throws CasaException, EquipamentosDomesticosException, IOException {
        Rede r = new Rede();
        r.carregarProdutoresEnergiaFicheiro(".//src//projeto//data//produtores_energia.txt");
        r.carregarPostosTransformacaoFicheiro(".//src//projeto//data//postos_transformacao.txt");
        r.carregarCasasFicheiro(".//src//projeto//data//casas.txt");
        r.carregarEquipamentosProdutoresFicheiro(".//src//projeto//data//equipamentos_produtores.txt");
        r.carregarEquipamentosDomesticosFicheiro(".//src//projeto//data//equipamentos_domesticos.txt");
        r.carregarHistoricosUtilizacaoFicheiro(".//src//projeto//data//historicos_utilizacao.txt");
        /*
        //Auto sustentavel
        for(Integer i : r.getCasasST().keys()){
            Casa c = r.getCasasST().get(i);
            if(c.getIdCasa() == 6)
            {
                for(Integer j : c.getEquipamentosDomesticosST().keys()){
                    EquipamentoDomestico ed = c.getEquipamentosDomesticosST().get(j);
                    ed.ligarDesligar(true);
                    c.casaAutoSustentavel();
                    System.out.println(c.toString());
                    ed.ligarDesligar(false);
                    ed.consultarHistoricoUtilizacao();
                }
            }
        }
        */
        /*
        r.criaGrafo();
        r.imprimeGrafoParaFicheiroTexto();
        */
        /*
        for(Integer i : r.getEquipamentosProdutoresST().keys()){
            EquipamentoProdutor ep = r.getEquipamentosProdutoresST().get(i);
            System.out.println(ep.toString());
        }
        */
        /*
        Rede rede = new Rede();
         */
        /*
        rede.carregarCasasFicheiro(".//src//projeto//data//casas.txt");
        rede.listarCasas();
         */
        /*
        Rede grafo = new Rede();
        grafo.addEdge(new FlowEdge(0, 2, 26));
        grafo.addEdge(new FlowEdge(0, 4, 38));
        grafo.addEdge(new FlowEdge(1, 3, 29));
        grafo.addEdge(new FlowEdge(2, 7, 34));
        grafo.addEdge(new FlowEdge(3, 6, 52));
        grafo.addEdge(new FlowEdge(4, 5, 35));
        grafo.addEdge(new FlowEdge(4, 7, 37));
        grafo.addEdge(new FlowEdge(5, 1, 32));
        grafo.addEdge(new FlowEdge(5, 4, 35));
        grafo.addEdge(new FlowEdge(5, 7, 28));
        grafo.addEdge(new FlowEdge(6, 0, 58));
        grafo.addEdge(new FlowEdge(6, 2, 40));
        grafo.addEdge(new FlowEdge(6, 4, 93));
        grafo.addEdge(new FlowEdge(7, 3, 39));
        grafo.addEdge(new FlowEdge(7, 5, 28));        
        //grafo.calcularMST();
        //grafo.caminhoMaisCurto(2, 4);
         */
        /*
        rede.addEdge(new FlowEdge(0, 1, 1));
        rede.addEdge(new FlowEdge(1, 0, 1));
        System.out.println(rede.verificarSeEConexo());
         */
        /*
        Rede r = new Rede();
        Casa c = new Casa(250, (float) 50, 5);
        Date d = new Date();
        EquipamentoDomestico ed = new EquipamentoDomestico(1, "tipo", (float) 3.5, true, d, 5);
        try {
            c.inserirEquipamentoDomestico(ed);
        } catch (EquipamentosDomesticosException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        r.getEquipamentosDomesticosST().put(ed.getIdEquipamentoDomestico(), ed);
        c.listarEquipamentoDomestico();
         */
 /*
        Date d1 = new Date();
        Date d2 = new Date();
        HistoricoUtilizacao hu = new HistoricoUtilizacao(0, d1, d2, 3);
        System.out.println(hu.toString());
         */
    }
}
