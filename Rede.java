package projeto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import projeto.excepcoes.CasaException;
import projeto.imports.RedBlackBST_AED2;
import projeto.imports.SeparateChainingHashST_AED2;
import projeto.excepcoes.PostoTransformacaoException;
import projeto.excepcoes.ProdutorEnergiaException;
import projeto.excepcoes.EquipamentosDomesticosException;
import projeto.imports.Date;
import projeto.imports.Digraph;
import projeto.imports.DijkstraSP;
import projeto.imports.DirectedEdge;
import projeto.imports.Edge;
import projeto.imports.EdgeWeightedDigraph;
import projeto.imports.EdgeWeightedGraph;
import projeto.imports.FlowEdge;
import projeto.imports.FlowNetwork;
import projeto.imports.GraphNode;
import projeto.imports.In;
import projeto.imports.KosarajuSharirSCC;
import projeto.imports.KruskalMST;
import projeto.imports.Out;

/**
 *
 * @author Diogo Miranda & Miguel Silva
 */
public class Rede extends FlowNetwork implements Serializable {
    /**
     * R2
     */
    private RedBlackBST_AED2<Integer, GraphNode> nosGrafoST = new RedBlackBST_AED2<>();
    /**
     * RedBlacks
     */
    private RedBlackBST_AED2<Integer, PostoTransformacao> postosTransformacaoST = new RedBlackBST_AED2<>();
    private RedBlackBST_AED2<Integer, Casa> casasST = new RedBlackBST_AED2<>();
    /**
     * Hash Table
     */
    private SeparateChainingHashST_AED2<Integer, ProdutorEnergia> produtoresEnergiaST = new SeparateChainingHashST_AED2<>();
    /**
     * Redblacks Auxiliares
     */
    private RedBlackBST_AED2<Integer, EquipamentoDomestico> equipamentosDomesticosST = new RedBlackBST_AED2<>();
    private RedBlackBST_AED2<Integer, EquipamentoProdutor> equipamentosProdutoresST = new RedBlackBST_AED2<>();
    private RedBlackBST_AED2<Integer, HistoricoUtilizacao> historicoUtilizacaoST = new RedBlackBST_AED2<>();

    /**
     * @return the postosTransformacaoST
     */
    public RedBlackBST_AED2<Integer, PostoTransformacao> getPostosTransformacaoST() {
        return postosTransformacaoST;
    }

    /**
     * @param postosTransformacaoST the postosTransformacaoST to set
     */
    public void setPostosTransformacaoST(RedBlackBST_AED2<Integer, PostoTransformacao> postosTransformacaoST) {
        this.postosTransformacaoST = postosTransformacaoST;
    }

    /**
     * @return the casasST
     */
    public RedBlackBST_AED2<Integer, Casa> getCasasST() {
        return casasST;
    }

    /**
     * @param casasST the casasST to set
     */
    public void setCasasST(RedBlackBST_AED2<Integer, Casa> casasST) {
        this.casasST = casasST;
    }

    /**
     * @return the produtoresEnergiaST
     */
    public SeparateChainingHashST_AED2<Integer, ProdutorEnergia> getProdutoresEnergiaST() {
        return produtoresEnergiaST;
    }

    /**
     * @param produtoresEnergiaST the produtoresEnergiaST to set
     */
    public void setProdutoresEnergiaST(SeparateChainingHashST_AED2<Integer, ProdutorEnergia> produtoresEnergiaST) {
        this.produtoresEnergiaST = produtoresEnergiaST;
    }

    /**
     * @return the equipamentosDomesticosST
     */
    public RedBlackBST_AED2<Integer, EquipamentoDomestico> getEquipamentosDomesticosST() {
        return equipamentosDomesticosST;
    }

    /**
     * @param equipamentosDomesticosST the equipamentosDomesticosST to set
     */
    public void setEquipamentosDomesticosST(RedBlackBST_AED2<Integer, EquipamentoDomestico> equipamentosDomesticosST) {
        this.equipamentosDomesticosST = equipamentosDomesticosST;
    }

    /**
     * @return the equipamentosProdutoresST
     */
    public RedBlackBST_AED2<Integer, EquipamentoProdutor> getEquipamentosProdutoresST() {
        return equipamentosProdutoresST;
    }

    /**
     * @param equipamentosProdutoresST the equipamentosProdutoresST to set
     */
    public void setEquipamentosProdutoresST(RedBlackBST_AED2<Integer, EquipamentoProdutor> equipamentosProdutoresST) {
        this.equipamentosProdutoresST = equipamentosProdutoresST;
    }

    /**
     * @return the historicoUtilizacaoST
     */
    public RedBlackBST_AED2<Integer, HistoricoUtilizacao> getHistoricoUtilizacaoST() {
        return historicoUtilizacaoST;
    }

    /**
     * @param historicoUtilizacaoST the historicoUtilizacaoST to set
     */
    public void setHistoricoUtilizacaoST(RedBlackBST_AED2<Integer, HistoricoUtilizacao> historicoUtilizacaoST) {
        this.historicoUtilizacaoST = historicoUtilizacaoST;
    }

    /**
     * @return the nosGrafoST
     */
    public RedBlackBST_AED2<Integer, GraphNode> getNosGrafoST() {
        return nosGrafoST;
    }

    /**
     * @param nosGrafoST the nosGrafoST to set
     */
    public void setNosGrafoST(RedBlackBST_AED2<Integer, GraphNode> nosGrafoST) {
        this.nosGrafoST = nosGrafoST;
    }

    /**
     * Construtor por defeito cria grafo para 50 nós
     */
    public Rede() {
        super(50);
    }

    /**
     * Construtor cria grafo para V nós
     *
     * @param V
     */
    public Rede(int V) {
        super(V);
    }

    //R3
    /**
     * Recebe um Produtor de Energia e insere na ST
     *
     * @param pe
     * @throws ProdutorEnergiaException
     */
    public void inserirProdutorEnergia(ProdutorEnergia pe) throws ProdutorEnergiaException {
        if (getProdutoresEnergiaST().contains(pe.getIdProdutorEnergia())) {
            throw new ProdutorEnergiaException("Já existe um produtor energia com esse id.");
        } else {
            getProdutoresEnergiaST().put(pe.getIdProdutorEnergia(), pe);
        }
    }

    //R3
    /**
     * Recebe um PostoTransformacao e insere na ST
     *
     * @param pt
     * @throws PostoTransformacaoException
     */
    public void inserirPostoTransformacao(PostoTransformacao pt) throws PostoTransformacaoException {
        if (getPostosTransformacaoST().contains(pt.getIdPostoTransformacao())) {
            throw new PostoTransformacaoException("Já existe um Posto de Transformacao com esse id.");
        } else {
            getPostosTransformacaoST().put(pt.getIdPostoTransformacao(), pt);
        }
    }

    //R3
    /**
     * Recebe uma Casa e insere na ST
     *
     * @param c
     * @throws CasaException
     * @throws projeto.excepcoes.PostoTransformacaoException
     */
    public void inserirCasa(Casa c) throws CasaException, PostoTransformacaoException {
        for (Integer i : this.getPostosTransformacaoST().keys()) {
            PostoTransformacao pt = this.getPostosTransformacaoST().get(i);
            if (pt.getEnergiaEmUtilizacao() + c.getPotenciaContador() > pt.getEnergiaDisponivel()) {
                throw new PostoTransformacaoException("Já existe uma casa com esse id.");
            }
        }
        if (getCasasST().contains(c.getIdCasa())) { //Caso exista uma casa com um id igual
            throw new CasaException("Já existe uma casa com esse id.");
        } else { //Caso não exista, adiciona
            getCasasST().put(c.getIdCasa(), c);
        }
    }

    //R3
    /**
     * Lista os Produtores de Energia da ST
     */
    public void listarProdutoresEnergia() {
        for (Integer pe : getProdutoresEnergiaST().keys()) {
            System.out.println(getProdutoresEnergiaST().get(pe).getIdProdutorEnergia() + " "
                    + getProdutoresEnergiaST().get(pe).getPotenciaProduzida() + " "
                    + getProdutoresEnergiaST().get(pe).getTipoProdutorEnergia());
        }
    }

    //R3
    /**
     * Lista os Postos de Transformaçao da ST
     */
    public void listarPostosTransformacao() {
        for (Integer pt : getPostosTransformacaoST().keys()) {
            System.out.println(getPostosTransformacaoST().get(pt).getIdPostoTransformacao() + " "
                    + getPostosTransformacaoST().get(pt).getEnergiaDisponivel() + " "
                    + getPostosTransformacaoST().get(pt).getEnergiaEmUtilizacao());
        }
    }

    //R3
    /**
     * Lista as Casas da ST
     */
    public void listarCasas() {
        for (Integer c : getCasasST().keys()) {
            System.out.println(getCasasST().get(c).getIdCasa() + " "
                    + getCasasST().get(c).getPotenciaContador() + " "
                    + getCasasST().get(c).getSomaPotenciasEquipamentosDomesticos() + " "
                    + getCasasST().get(c).getSomaEnergiaEquipamentosProdutores() + " "
                    + getCasasST().get(c).getIdZona());
        }
    }

    //R3
    /**
     * Edita um Produtor de Energia
     *
     * @param idProdutorEnergia
     * @param novoTipoProdutorEnergia
     * @param novaPotenciaProduzida
     */
    public void editarProdutorEnergia(int idProdutorEnergia, String novoTipoProdutorEnergia, float novaPotenciaProduzida) {
        for (Integer pe : getProdutoresEnergiaST().keys()) {
            if (getProdutoresEnergiaST().get(pe).getIdProdutorEnergia() == (idProdutorEnergia)) {
                getProdutoresEnergiaST().get(pe).setTipoProdutorEnergia(novoTipoProdutorEnergia);
                getProdutoresEnergiaST().get(pe).setPotenciaProduzida(novaPotenciaProduzida);
            }
        }
    }

    //R3
    /**
     * Edita um Posto de Transformaçao
     *
     * @param idPostoTransformacao
     * @param novaEnergiaDisponivel
     * @throws projeto.excepcoes.PostoTransformacaoException
     */
    public void editarPostoTransformacao(int idPostoTransformacao, int novaEnergiaDisponivel) throws PostoTransformacaoException {
        for (Integer i : getPostosTransformacaoST().keys()) {
            if (getPostosTransformacaoST().get(i).getIdPostoTransformacao() == (idPostoTransformacao)) {
                PostoTransformacao pt = this.getPostosTransformacaoST().get(i);
                if (novaEnergiaDisponivel < pt.getEnergiaEmUtilizacao()) {
                    throw new PostoTransformacaoException("Já existe uma casa com esse id.");
                } else {
                    getPostosTransformacaoST().get(i).setEnergiaDisponivel(novaEnergiaDisponivel);
                }
            }
        }
    }

    //R3
    /**
     * Edita uma Casa
     *
     * @param idCasa
     * @param novaPotenciaContador
     * @param novoIdZona
     */
    public void editarCasa(int idCasa, float novaPotenciaContador, int novoIdZona) {
        for (Integer c : getCasasST().keys()) {
            if (getCasasST().get(c).getIdCasa() == (idCasa)) {
                getCasasST().get(c).setPotenciaContador(novaPotenciaContador);
                getCasasST().get(c).setIdZona(novoIdZona);
            }
        }
    }

    //R3
    //R5
    /**
     * Remove um Produtor de Energia
     *
     * @param idProdutorEnergia
     */
    public void removerProdutorEnergia(int idProdutorEnergia) {
        for (Integer p : getProdutoresEnergiaST().keys()) {
            if (getProdutoresEnergiaST().get(p).getIdProdutorEnergia() == (idProdutorEnergia)) {
                getProdutoresEnergiaST().delete(p);
            }
        }
    }

    //R3
    //R5
    /**
     * Remove um Posto de Transformaçao
     *
     * @param idPostoTransformacao
     */
    public void removerPostoTransformacao(int idPostoTransformacao) {
        for (Integer pt : getPostosTransformacaoST().keys()) {
            if (getPostosTransformacaoST().get(pt).getIdPostoTransformacao() == (idPostoTransformacao)) {
                getPostosTransformacaoST().delete(pt);
            }
        }
    }

    //R3
    //R5
    /**
     * Remove uma Casa
     *
     * @param idCasa
     */
    public void removerCasa(int idCasa) {
        for (Integer c : getCasasST().keys()) {
            if (getCasasST().get(c).getIdCasa() == (idCasa)) {
                //Remover Equipamento Domesticos desta Casa
                for (Integer ed : getCasasST().get(c).getEquipamentosDomesticosST().keys()) {
                    getCasasST().get(c).removerEquipamentoDomestico(ed);
                }
                //Remover Equipamento Produtores desta Casa
                for (Integer ep : getCasasST().get(c).getEquipamentosProdutoresST().keys()) {
                    getCasasST().get(c).removerEquipamentoProdutor(ep);
                }
                //Remover Casa
                getCasasST().delete(c);
            }
        }
    }

    //R6
    /**
     * Carragega Produtores de Energia a partir de um ficheiro
     *
     * @param caminho
     */
    public void carregarProdutoresEnergiaFicheiro(String caminho) {
        In in = new In(caminho);
        while (!in.isEmpty()) {
            /**
             * array de strings separaddas por ";"
             * in.readLine() lê toda a linha
             * split() separa as strings
             */
            String[] texto = in.readLine().split(";");

            /**
             * passa para "int" a string que está na posição 0
            */
            int idProdutorEnergia = Integer.parseInt(texto[0]);
            String tipoProdutorEnergia = texto[1];
            float potenciaProduzida = Float.parseFloat(texto[2]);

            /**
             * cria o novo ProdutorEnergia através do seu construtor
             */
            ProdutorEnergia pe = new ProdutorEnergia(idProdutorEnergia, tipoProdutorEnergia, potenciaProduzida);
            /**
             * guarda o ProdutorEnergia na ST
             */
            getProdutoresEnergiaST().put(idProdutorEnergia, pe);
        }
    }

    //R6
    /**
     * Carrega Postos de Transformação a partir de um ficheiro
     *
     * @param caminho
     */
    public void carregarPostosTransformacaoFicheiro(String caminho) {
        In in = new In(caminho);
        while (!in.isEmpty()) {
            String[] texto = in.readLine().split(";");

            int idPostoTransformacao = Integer.parseInt(texto[0]);
            float energiaDisponivel = Float.parseFloat(texto[1]);
            float energiaEmUtilizacao = Float.parseFloat(texto[2]);

            PostoTransformacao pt = new PostoTransformacao(idPostoTransformacao, energiaDisponivel, energiaEmUtilizacao);
            getPostosTransformacaoST().put(idPostoTransformacao, pt);
        }
    }

    //R6
    /**
     * Carrega Casas a partir de um ficheiro
     *
     * @param caminho
     */
    public void carregarCasasFicheiro(String caminho) {
        In in = new In(caminho);
        while (!in.isEmpty()) {
            String[] texto = in.readLine().split(";");

            int idCasa = Integer.parseInt(texto[0]);
            float potenciaContador = Float.parseFloat(texto[1]);
            float somaPotenciasEquipamentosDomesticos = Float.parseFloat(texto[2]);
            float somaEnergiaEquipamentosProdutores = Float.parseFloat(texto[3]);
            int zonaAQuePertence = Integer.parseInt(texto[4]);

            Casa c = new Casa(idCasa, potenciaContador, somaPotenciasEquipamentosDomesticos,
                    somaEnergiaEquipamentosProdutores, zonaAQuePertence);
            getCasasST().put(idCasa, c);
        }
    }

    //R6
    /**
     * Carrega Equipamentos Produtores a partir de um ficheiro
     *
     * @param caminho
     * @throws CasaException
     */
    public void carregarEquipamentosProdutoresFicheiro(String caminho) throws CasaException {
        In in = new In(caminho);
        while (!in.isEmpty()) {
            String[] texto = in.readLine().split(";");

            int idEquipamentoProdutor = Integer.parseInt(texto[0]);
            String tipoEquipamentoProdutor = texto[1];
            float potenciaProduzida = Float.parseFloat(texto[2]);
            int casaAQuePertence = Integer.parseInt(texto[3]);

            EquipamentoProdutor ep = new EquipamentoProdutor(idEquipamentoProdutor, tipoEquipamentoProdutor, potenciaProduzida, casaAQuePertence);

            if (getCasasST().contains(casaAQuePertence)) {
                getCasasST().get(casaAQuePertence).getEquipamentosProdutoresST().put(idEquipamentoProdutor, ep);
                //RedBlack auxiliar
                getEquipamentosProdutoresST().put(idEquipamentoProdutor, ep);
            } else {
                throw new CasaException("\nNao existe uma casa com o id:" + casaAQuePertence + "\n");
            }
        }
    }

    //R6
    /**
     * Carrega Equipamentos Domésticos a partir de um ficheiro
     *
     * @param caminho
     * @throws CasaException
     */
    public void carregarEquipamentosDomesticosFicheiro(String caminho) throws CasaException {
        In in = new In(caminho);
        while (!in.isEmpty()) {
            String[] texto = in.readLine().split(";");

            int idEquipamentoDomestico = Integer.parseInt(texto[0]);
            String tipoEquipamentoDomestico = texto[1];
            float potenciaNecessaria = Float.parseFloat(texto[2]);
            boolean ligado = Boolean.parseBoolean(texto[3]);
            int yearLigado = Integer.parseInt(texto[4]);
            int monthLigado = Integer.parseInt(texto[5]);
            int dayLigado = Integer.parseInt(texto[6]);
            int hourLigado = Integer.parseInt(texto[7]);
            int minuteLigado = Integer.parseInt(texto[8]);
            int secondLigado = Integer.parseInt(texto[9]);
            int casaAQuePertence = Integer.parseInt(texto[10]);

            Date d = new Date(yearLigado, monthLigado, dayLigado, hourLigado, minuteLigado, secondLigado);
            EquipamentoDomestico ed = new EquipamentoDomestico(idEquipamentoDomestico, tipoEquipamentoDomestico, potenciaNecessaria, ligado, d, casaAQuePertence);

            if (getCasasST().contains(casaAQuePertence)) {
                getCasasST().get(casaAQuePertence).getEquipamentosDomesticosST().put(idEquipamentoDomestico, ed);
                //RedBlack auxiliar
                getEquipamentosDomesticosST().put(idEquipamentoDomestico, ed);
            } else {
                throw new CasaException("\nNao existe uma Casa com o id:" + casaAQuePertence + "\n");
            }
        }
    }

    //R6
    /**
     * Carrega Historicos de Utilização de Equipamentos Domésticos a partir de
     * um ficheiro
     *
     * @param caminho
     * @throws EquipamentosDomesticosException
     */
    public void carregarHistoricosUtilizacaoFicheiro(String caminho) throws EquipamentosDomesticosException {
        In in = new In(caminho);
        while (!in.isEmpty()) {
            String[] texto = in.readLine().split(";");

            int idHistoricoUtilizacao = Integer.parseInt(texto[0]);
            int yearLigado = Integer.parseInt(texto[1]);
            int monthLigado = Integer.parseInt(texto[2]);
            int dayLigado = Integer.parseInt(texto[3]);
            int hourLigado = Integer.parseInt(texto[4]);
            int minuteLigado = Integer.parseInt(texto[5]);
            int secondLigado = Integer.parseInt(texto[6]);
            int yearDesligado = Integer.parseInt(texto[7]);
            int monthDesligado = Integer.parseInt(texto[8]);
            int dayDesligado = Integer.parseInt(texto[9]);
            int hourDesligado = Integer.parseInt(texto[10]);
            int minuteDesligado = Integer.parseInt(texto[11]);
            int secondDesligado = Integer.parseInt(texto[12]);
            int equipamentoDomesticoAQuePertence = Integer.parseInt(texto[13]);

            Date d1 = new Date(yearLigado, monthLigado, dayLigado, hourLigado, minuteLigado, secondLigado);
            Date d2 = new Date(yearDesligado, monthDesligado, dayDesligado, hourDesligado, minuteDesligado, secondDesligado);
            HistoricoUtilizacao hu = new HistoricoUtilizacao(idHistoricoUtilizacao, d1, d2, equipamentoDomesticoAQuePertence);

            if (getEquipamentosDomesticosST().contains(equipamentoDomesticoAQuePertence)) {
                getEquipamentosDomesticosST().get(equipamentoDomesticoAQuePertence).getHistoricoUtilizacaoST().put(idHistoricoUtilizacao, hu);
                //RedBlack auxiliar
                getHistoricoUtilizacaoST().put(idHistoricoUtilizacao, hu);
            } else {
                throw new EquipamentosDomesticosException("\nNao existe um EquipamentoDomestico com o id:" + equipamentoDomesticoAQuePertence + "\n");
            }
        }
    }

    /**
     * Imprime Casas e respectivos Equipamentos de uma determinada zona
     *
     * @param idZona
     */
    public void casasEEquipamentosDeterminadaZona(int idZona) {
        for (Integer c : getCasasST().keys()) {
            if (getCasasST().get(c).getIdZona() == idZona) {
                System.out.println("ID Casa: " + getCasasST().get(c).getIdCasa() + "\n");
                RedBlackBST_AED2<Integer, EquipamentoProdutor> epST = getCasasST().get(c).getEquipamentosProdutoresST();
                RedBlackBST_AED2<Integer, EquipamentoDomestico> edST = getCasasST().get(c).getEquipamentosDomesticosST();
                if (epST.isEmpty() == false) {
                    for (Integer ep : epST.keys()) {
                        System.out.println("Tipo Equipamento Produtor: " + epST.get(ep).getTipoEquipamentoProdutor() + "\n");
                    }
                }
                if (edST.isEmpty() == false) {
                    for (Integer ed : edST.keys()) {
                        System.out.println("Tipo Equipamento Domestico: " + edST.get(ed).getTipoEquipamentoDomestico() + "\n");
                    }
                }
                System.out.println("\n");
            }
        }
    }

    /**
     * Imprime Casas com Equipamentos Produtores
     */
    public void casasEquipamentosProdutores() {
        for (Integer c : getCasasST().keys()) {
            if (getCasasST().get(c).getEquipamentosProdutoresST().isEmpty() == false) {
                System.out.println("ID Casa: " + getCasasST().get(c).getIdCasa() + "\n");
            }
        }
    }

    /**
     * R6
     * R7
     * Guarda todos os dados de todas as STs em ficheiros de texto
     */
    public void dump() {
        Out ficheiro = new Out(".//src//projeto//data//produtores_energia.txt");

        for (Integer pe : getProdutoresEnergiaST().keys()) {
            ProdutorEnergia produtorEnergia = getProdutoresEnergiaST().get(pe);
            ficheiro.println(produtorEnergia.getIdProdutorEnergia() + ";"
                    + produtorEnergia.getTipoProdutorEnergia() + ";"
                    + produtorEnergia.getPotenciaProduzida() + ";");
        }
        ficheiro.close();

        ficheiro = new Out(".//src//projeto//data//postos_transformacao.txt");
        for (Integer pt : getPostosTransformacaoST().keys()) {
            PostoTransformacao postoTransformacao = getPostosTransformacaoST().get(pt);
            ficheiro.println(postoTransformacao.getIdPostoTransformacao() + ";"
                    + postoTransformacao.getEnergiaDisponivel() + ";"
                    + postoTransformacao.getEnergiaEmUtilizacao() + ";");
        }
        ficheiro.close();

        ficheiro = new Out(".//src//projeto//data//casas.txt");
        for (Integer c : getCasasST().keys()) {
            Casa casa = getCasasST().get(c);
            ficheiro.println(casa.getIdCasa() + ";"
                    + casa.getPotenciaContador() + ";"
                    + casa.getSomaPotenciasEquipamentosDomesticos() + ";"
                    + casa.getSomaEnergiaEquipamentosProdutores() + ";"
                    + casa.getIdZona() + ";");
        }
        ficheiro.close();

        ficheiro = new Out(".//src//projeto//data//equipamentos_produtores.txt");
        for (Integer i : getCasasST().keys()) {
            Casa c = getCasasST().get(i);
            for (Integer ep : c.getEquipamentosProdutoresST().keys()) {
                EquipamentoProdutor equipamentoprodutor = c.getEquipamentosProdutoresST().get(ep);
                ficheiro.println(equipamentoprodutor.getIdEquipamentoProdutor() + ";"
                        + equipamentoprodutor.getTipoEquipamentoProdutor() + ";"
                        + equipamentoprodutor.getPotenciaProduzida() + ";"
                        + equipamentoprodutor.getCasaAQuePertence());
            }
        }
        ficheiro.close();

        ficheiro = new Out(".//src//projeto//data//equipamentos_domesticos.txt");
        for (Integer i : getCasasST().keys()) {
            Casa c = getCasasST().get(i);
            for (Integer ed : c.getEquipamentosDomesticosST().keys()) {
                EquipamentoDomestico equipamentodomestico = getEquipamentosDomesticosST().get(ed);
                ficheiro.println(equipamentodomestico.getIdEquipamentoDomestico() + ";"
                        + equipamentodomestico.getTipoEquipamentoDomestico() + ";"
                        + equipamentodomestico.getPotenciaNecessaria() + ";"
                        + equipamentodomestico.isLigado() + ";"
                        + equipamentodomestico.getDataLigado().getYear() + ";"
                        + equipamentodomestico.getDataLigado().getMonth() + ";"
                        + equipamentodomestico.getDataLigado().getDay() + ";"
                        + equipamentodomestico.getDataLigado().getHour() + ";"
                        + equipamentodomestico.getDataLigado().getMinute() + ";"
                        + equipamentodomestico.getDataLigado().getSecond() + ";"
                        + equipamentodomestico.getCasaAQuePertence() + ";");
            }
        }
        ficheiro.close();

        ficheiro = new Out(".//src//projeto//data//historicos_utilizacao.txt");
        for (Integer i : getCasasST().keys()) {
            Casa c = getCasasST().get(i);
            for (Integer ed : c.getEquipamentosDomesticosST().keys()) {
                EquipamentoDomestico equipamentodomestico = getEquipamentosDomesticosST().get(ed);
                for (Integer k : equipamentodomestico.getHistoricoUtilizacaoST().keys()) {
                    HistoricoUtilizacao hu = equipamentodomestico.getHistoricoUtilizacaoST().get(k);
                    ficheiro.println(hu.getIdHistoricoUtilizacao() + ";"
                            + hu.getDataLigado().getYear() + ";"
                            + hu.getDataLigado().getMonth() + ";"
                            + hu.getDataLigado().getDay() + ";"
                            + hu.getDataLigado().getHour() + ";"
                            + hu.getDataLigado().getMinute() + ";"
                            + hu.getDataLigado().getSecond() + ";"
                            + hu.getDataDesligado().getYear() + ";"
                            + hu.getDataDesligado().getMonth() + ";"
                            + hu.getDataDesligado().getDay() + ";"
                            + hu.getDataDesligado().getHour() + ";"
                            + hu.getDataDesligado().getMinute() + ";"
                            + hu.getDataDesligado().getSecond() + ";"
                            + hu.getEquipamentoDomesticoAQuePertence() + ";");
                }
            }
        }
        ficheiro.close();
    }

    /**
     * Percorre postosTransformacaoST, casasST e produtoresEnergiaST e insere-os no nosGrafosST
     * Preenche a ST de nós do grafo a partir das STs
     */
    public void acrescentarNos() {
        for (Integer pe : this.getProdutoresEnergiaST().keys()) {
            this.getNosGrafoST().put(this.getProdutoresEnergiaST().get(pe).getId(),
                    this.getProdutoresEnergiaST().get(pe));
        }
        for (Integer pt : this.getPostosTransformacaoST().keys()) {
            this.getNosGrafoST().put(this.getPostosTransformacaoST().get(pt).getId(),
                    this.getPostosTransformacaoST().get(pt));
        }
        for (Integer c : this.getCasasST().keys()) {
            this.getNosGrafoST().put(this.getCasasST().get(c).getId(),
                    this.getCasasST().get(c));
        }
    }

    /**
     * R12 b)
     * Lista o Histórico de Equipamentos Domésticos de uma determinada Casa
     *
     * @param idCasa
     */
    public void listarEquipamentosHistoricoCasa(int idCasa) {
        for (Integer i : getCasasST().keys()) {
            Casa c = getCasasST().get(i);
            if (c.getId() == idCasa) {
                c.listarEquipamentoProdutor();
                System.out.println("");
                c.listarEquipamentoDomestico();
                System.out.println("");

                for (Integer j : c.getEquipamentosDomesticosST().keys()) {
                    EquipamentoDomestico ed = c.getEquipamentosDomesticosST().get(j);
                    ed.consultarHistoricoUtilizacao();
                }
                return;
            }
        }
    }

    /**
     * R12 b)
     * Lista o Histórico de Equipamentos Domésticos das Casas de uma determinada Zona
     *
     * @param idZona
     */
    public void listarEquipamentosHistoricoZona(int idZona) {
        for (Integer i : getCasasST().keys()) {
            Casa c = getCasasST().get(i);
            if (c.getIdZona() == idZona) {
                c.listarEquipamentoProdutor();
                System.out.println("");
                c.listarEquipamentoDomestico();
                System.out.println("");

                for (Integer j : c.getEquipamentosDomesticosST().keys()) {
                    EquipamentoDomestico ed = c.getEquipamentosDomesticosST().get(j);
                    ed.consultarHistoricoUtilizacao();
                }
            }
        }
    }

    /**
     * R12 c)
     * Imprime a casa com o maior consumo
     */
    public void listarCasaMaiorConsumo() {
        float maiorConsumo = 0;
        Casa mc = new Casa();
        for (Integer i : getCasasST().keys()) {
            Casa c = getCasasST().get(i);
            if (c.getSomaPotenciasEquipamentosDomesticos() > maiorConsumo) {
                maiorConsumo = c.getSomaPotenciasEquipamentosDomesticos();
                mc = getCasasST().get(i);
            }
        }
        System.out.println("Casa com maior consumo: " + mc.getId() + " com o consumo de: " + maiorConsumo);
    }

    /**
     * R12 g)
     * Imprime as Casas que consumiram mais do que um determinado valor de
     * energia numa determinada Data
     *
     * @param d
     * @param potencia
     */
    public void casaMaisPotenciaData(Date d, int potencia) {
        float consumo = 0;
        for (Integer i : getCasasST().keys()) {
            Casa c = getCasasST().get(i);
            for (Integer j : c.getEquipamentosDomesticosST().keys()) {
                EquipamentoDomestico ed = getEquipamentosDomesticosST().get(j);
                for (Integer k : ed.getHistoricoUtilizacaoST().keys()) {
                    HistoricoUtilizacao h = ed.getHistoricoUtilizacaoST().get(k);
                    if (h.getDataLigado().beforeDate(d) && h.getDataDesligado().afterDate(d)) {
                        consumo = consumo + ed.getPotenciaNecessaria();
                    }
                }
            }
            if (consumo > potencia) {
                System.out.println("Casa: " + c.getId());
            }
        }
    }

    /**
     * R10
     * R18
     * Cria o Grafo da Rede
     *
     */
    public void criaGrafo() {
        /**
         * Liga ProdutoresEnergia aos PostosTransformação com PotenciaProduzida
         */
        for (Integer i : this.getProdutoresEnergiaST().keys()) {
            for (Integer j : this.getPostosTransformacaoST().keys()) {
                ProdutorEnergia pe = this.getProdutoresEnergiaST().get(i);
                PostoTransformacao pt = this.getPostosTransformacaoST().get(j);

                this.addEdge(new FlowEdge(pe.getId(), pt.getId(), pe.getPotenciaProduzida()));
            }
        }
        /**
         * Liga todos os PostosTransformação aos restantes PostosTransformação
         */
        for (Integer i : this.getPostosTransformacaoST().keys()) {
            for (Integer j : this.getPostosTransformacaoST().keys()) {
                PostoTransformacao pt1 = this.getPostosTransformacaoST().get(i);
                PostoTransformacao pt2 = this.getPostosTransformacaoST().get(j);

                this.addEdge(new FlowEdge(pt1.getId(), pt2.getId(), pt1.getEnergiaDisponivel()));
            }
        }
        /**
         * Liga PostosTransformação às Casas EnergiaDisponivel
         */
        for (Integer i : this.getPostosTransformacaoST().keys()) {
            for (Integer j : this.getCasasST().keys()) {
                PostoTransformacao pt = this.getPostosTransformacaoST().get(i);
                Casa c = this.getCasasST().get(j);

                if (pt.getId() == c.getIdZona()) {
                    this.addEdge(new FlowEdge(pt.getId(), c.getId(), c.getPotenciaContador()));
                }
            }
        }
        /**
         * Liga Casas autosustentaveis a PostosTransformação com energiaAMais
         */
        for (Integer i : this.getCasasST().keys()) {
            Casa c = this.getCasasST().get(i);
            if (c.casaAutoSustentavel()) {
                float energiaAMais = c.getSomaEnergiaEquipamentosProdutores() - c.getPotenciaContador();
                float energiaAMaisP = Math.abs(energiaAMais);
                this.addEdge(new FlowEdge(c.getId(), c.getIdCasa(), energiaAMaisP));
            }
        }
    }

    /**
     * R11 a)
     * R12 f)
     * Imprime o caminho mais curto entre 2 Nós de um Grafo
     *
     * @param origem
     * @param destino
     */
    public void caminhoMaisCurto(int origem, int destino) {
        DijkstraSP dijkstra = new DijkstraSP(this, origem); //g -> grafo /origem -> nós de origem
        if (dijkstra.hasPathTo(destino)) {
            for (FlowEdge e : dijkstra.pathTo(destino)) {
                System.out.print(e.from() + "->" + e.to() + "|");
            }
        } else {
            System.out.println("Nao existe ligacao");
        }
        System.out.println(" Cost:" + dijkstra.distTo(destino));
    }

    //R14
    /**
     * Imprime o Grafo para ficheiro Binário
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void imprimeGrafoParaFicheiroBinario() throws FileNotFoundException, IOException {
        String filename = "Grafo.bin";
        File f = new File(filename);
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
    }

    //R14
    /**
     * Imprime o Grafo para ficheiro de texto
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void imprimeGrafoParaFicheiroTexto() throws FileNotFoundException, IOException {
        Out ficheiro = new Out(".//src//projeto//data//grafo.txt");
        //Número de Vértices
        ficheiro.println(this.V());
        //Número de Arestas
        ficheiro.println(this.E());
        for (int i = 0; i < this.V(); i++) {
            for (FlowEdge f : this.adj(i)) {
                ficheiro.println(f.from() + " " + f.to() + " " + f.capacity());
            }
        }
        ficheiro.close();
    }

    /**
     * R11 b) Verifica se o Grafo é conexo usando o Kosaraju e para isso
     * precisamos de um digraph 
     * Para conseguir o digraph é preciso um EdgeWeightedDigraph 
     * Começa por converter o FlowNetwork em EdgeWeightedDigraph 
     * Depois passa-o para Digraph 
     * E por fim usa o Kosaraju
     *
     * @return
     */
    public boolean verificarSeEConexo() {
        EdgeWeightedDigraph ewd = new EdgeWeightedDigraph(this.V());
        for (int i = 0; i < this.V(); i++) {
            for (FlowEdge fe : this.adj(i)) {
                if (fe.from() == i) {
                    DirectedEdge de = new DirectedEdge(fe.from(), fe.to(), fe.flow());
                    ewd.addEdge(de);
                }
            }
        }
        Digraph d = new Digraph(ewd.V());
        for (int j = 0; j < ewd.V(); j++) {
            for (DirectedEdge de2 : ewd.adj(j)) {
                d.addEdge(de2.from(), de2.to());
            }
        }
        KosarajuSharirSCC scc = new KosarajuSharirSCC(d);
        return scc.count() == 1;
    }

    /**
     * R17
     */
    public void calcularMST() {
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(this.V());
        for (int i = 0; i < this.V(); i++) {
            for (FlowEdge e : this.adj(i)) {
                if (e.from() == i) {
                    Edge k = new Edge(e.from(), e.to(), e.capacity());
                    ewg.addEdge(k);
                }
            }
        }
        KruskalMST kruskal = new KruskalMST(ewg);
        for (Edge g : kruskal.edges()) {
            System.out.println(g.toString());
        }
    }
}
