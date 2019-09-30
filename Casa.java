package projeto;

import java.io.Serializable;
import projeto.imports.RedBlackBST_AED2;
import projeto.excepcoes.EquipamentoProdutoresException;
import projeto.excepcoes.EquipamentosDomesticosException;
import projeto.imports.Date;
import projeto.imports.GraphNode;

/**
 *
 * @author Diogo Miranda & Miguel Silva
 */
public class Casa extends GraphNode implements Serializable {

    private float potenciaContador;
    private float somaPotenciasEquipamentosDomesticos;
    private float somaEnergiaEquipamentosProdutores;
    private int idZona;

    /**
     * RedBlack's Equipamento Produtor e Equpamento Domestico
     */
    private RedBlackBST_AED2<Integer, EquipamentoProdutor> equipamentosProdutoresST = new RedBlackBST_AED2<>();
    private RedBlackBST_AED2<Integer, EquipamentoDomestico> equipamentosDomesticosST = new RedBlackBST_AED2<>();

    /**
     * @return the idCasa
     */
    public int getIdCasa() {
        return super.getId();
    }

    /**
     * @return the potenciaContador
     */
    public float getPotenciaContador() {
        return potenciaContador;
    }

    /**
     * @param potenciaContador the potenciaContador to set
     */
    public void setPotenciaContador(float potenciaContador) {
        this.potenciaContador = potenciaContador;
    }

    /**
     * @return the somaPotenciaEquipamentosDomesticos
     */
    public float getSomaPotenciasEquipamentosDomesticos() {
        return somaPotenciasEquipamentosDomesticos;
    }

    /**
     * @param somaPotenciasEquipamentosDomesticos the
     * somaPotenciasEquipamentosDomesticos to set
     */
    public void setSomaPotenciasEquipamentosDomesticos(float somaPotenciasEquipamentosDomesticos) {
        this.somaPotenciasEquipamentosDomesticos = somaPotenciasEquipamentosDomesticos;
    }

    /**
     * @return the somaEnergiaEquipamentosProdutores
     */
    public float getSomaEnergiaEquipamentosProdutores() {
        return somaEnergiaEquipamentosProdutores;
    }

    /**
     * @param somaEnergiaEquipamentosProdutores the
     * somaEnergiaEquipamentosProdutores to set
     */
    public void setSomaEnergiaEquipamentosProdutores(float somaEnergiaEquipamentosProdutores) {
        this.somaEnergiaEquipamentosProdutores = somaEnergiaEquipamentosProdutores;
    }

    /**
     * @return the idZona
     */
    public int getIdZona() {
        return idZona;
    }

    /**
     * @param idZona the idZona to set
     */
    public void setIdZona(int idZona) {
        this.idZona = idZona;
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

    public Casa() {
    }

    /**
     * Quando insere uma casa manualmente, incrementar o ID automaticamente
     *
     * @param potenciaContador
     * @param somaPotenciasEquipamentosDomesticos
     * @param somaEnergiaEquipamentosProdutores
     * @param idZona
     */
    public Casa(float potenciaContador, float somaPotenciasEquipamentosDomesticos, float somaEnergiaEquipamentosProdutores, int idZona) {
        super();
        this.potenciaContador = potenciaContador;
        this.somaPotenciasEquipamentosDomesticos = somaPotenciasEquipamentosDomesticos;
        this.somaEnergiaEquipamentosProdutores = somaEnergiaEquipamentosProdutores;
        this.idZona = idZona;
    }

    /**
     * Quando lê de um ficheiro, preencher o ID
     *
     * @param idCasa
     * @param potenciaContador
     * @param somaPotenciasEquipamentosDomesticos
     * @param somaEnergiaEquipamentosProdutores
     * @param idZona
     */
    public Casa(int idCasa, float potenciaContador, float somaPotenciasEquipamentosDomesticos, 
            float somaEnergiaEquipamentosProdutores, int idZona) {
        super();
        this.potenciaContador = potenciaContador;
        this.somaPotenciasEquipamentosDomesticos = somaPotenciasEquipamentosDomesticos;
        this.somaEnergiaEquipamentosProdutores = somaEnergiaEquipamentosProdutores;
        this.idZona = idZona;
    }

    /**
     * R3 Percorre a ST dos equipamentos Produtores e começa por verificar se
     * existe algum equipamento Produtor com o id inserido Caso exista é lançada
     * uma excepção a avisar que já existe um equipamento produtor com esse id
     * Se não existir é inserido um novo equipamento produtor
     *
     * @param ep
     * @throws EquipamentoProdutoresException
     */
    public void inserirEquipamentoProdutor(EquipamentoProdutor ep) throws EquipamentoProdutoresException {
        float somaEnergia = this.getSomaEnergiaEquipamentosProdutores() + ep.getPotenciaProduzida();
        if (this.getEquipamentosProdutoresST().contains(ep.getIdEquipamentoProdutor())) {
            throw new EquipamentoProdutoresException("Já existe um equipamento produtor com esse id.");
        } else {
            getEquipamentosProdutoresST().put(ep.getIdEquipamentoProdutor(), ep);
            this.setSomaEnergiaEquipamentosProdutores(somaEnergia);
        }
    }

    /**
     * R3 R4 R12 d) Faz uma verificação, se a soma das potências for maior à
     * soma que o contador suporta, é lançada uma mensagem a avisar que não
     * suporta tanta potência Percorre a ST dos equipamentos domesticos e
     * verifica se existe algum equipamento domestico com o id inserido Caso
     * exista é lançada uma excepção a avisar que já existe um equipamento
     * domestico com esse id Se não existir é inserido um novo equipamento
     * domestico
     *
     * @param ed
     * @throws EquipamentosDomesticosException
     */
    public void inserirEquipamentoDomestico(EquipamentoDomestico ed) throws EquipamentosDomesticosException {
        float somaPotencias = this.getSomaPotenciasEquipamentosDomesticos() + ed.getPotenciaNecessaria();
        if (somaPotencias > (this.getPotenciaContador() + this.getSomaEnergiaEquipamentosProdutores())) {
            System.out.println("Esta Casa não suporta a potencia de todos estes Equipamentos, considere inserir um Equipamento Produtor");
        }
        if (this.getEquipamentosDomesticosST().contains(ed.getIdEquipamentoDomestico())) {
            throw new EquipamentosDomesticosException("Já existe um Equipamento Domestico com esse id.");
        } else {
            getEquipamentosDomesticosST().put(ed.getIdEquipamentoDomestico(), ed);
            this.setSomaPotenciasEquipamentosDomesticos(somaPotencias);
        }
    }

    /**
     * R3 Lista todos os equipamentos produtores 
     * Percorre a ST dos equipamentos produtores e imprime toda a informação referente a estes equipamentos
     */
    public void listarEquipamentoProdutor() {
        for (Integer ep : getEquipamentosProdutoresST().keys()) {
            System.out.println(this.getEquipamentosProdutoresST().get(ep).getIdEquipamentoProdutor() + " "
                    + this.getEquipamentosProdutoresST().get(ep).getTipoEquipamentoProdutor() + " "
                    + this.getEquipamentosProdutoresST().get(ep).getPotenciaProduzida());
        }
    }

    /**
     * R3 Lista todos os equipamentos domesticos Percorre a ST dos equipamentos
     * domesticos e imprime toda a informação referente a estes equipamentos
     */
    public void listarEquipamentoDomestico() {
        for (Integer ed : getEquipamentosDomesticosST().keys()) {
            System.out.println(this.getEquipamentosDomesticosST().get(ed).getIdEquipamentoDomestico() + " "
                    + this.getEquipamentosDomesticosST().get(ed).getTipoEquipamentoDomestico() + " "
                    + this.getEquipamentosDomesticosST().get(ed).getPotenciaNecessaria());
        }
    }

    /**
     * R3 R5 Permite editar/alterar alguns campos dos equipamentos produtores
     *
     * @param idEquipamentoProdutor
     * @param novoTipoEquipamentoProdutor
     * @param novaPotenciaProduzida
     */
    public void editarEquipamentoProdutor(int idEquipamentoProdutor, String novoTipoEquipamentoProdutor, float novaPotenciaProduzida) {
        for (Integer ep : getEquipamentosProdutoresST().keys()) {
            if (getEquipamentosProdutoresST().get(ep).getIdEquipamentoProdutor() == (idEquipamentoProdutor)) {
                float energia = getEquipamentosProdutoresST().get(ep).getPotenciaProduzida();
                getEquipamentosProdutoresST().get(ep).setTipoEquipamentoProdutor(novoTipoEquipamentoProdutor);
                getEquipamentosProdutoresST().get(ep).setPotenciaProduzida(novaPotenciaProduzida);
                this.setSomaEnergiaEquipamentosProdutores(this.getSomaEnergiaEquipamentosProdutores() - energia + novaPotenciaProduzida);
            }
        }
    }

    /**
     * R3 R5 Permite editar/alterar alguns campos dos equipamentos domesticos
     *
     * @param idEquipamentoDomestico
     * @param novoTipoEquipamentoDomestico
     * @param novaPotenciaNecessaria
     */
    public void editarEquipamentoDomestico(int idEquipamentoDomestico, String novoTipoEquipamentoDomestico, float novaPotenciaNecessaria) {
        for (Integer ed : getEquipamentosDomesticosST().keys()) {
            if (getEquipamentosDomesticosST().get(ed).getIdEquipamentoDomestico() == (idEquipamentoDomestico)) {
                float atualPotenciaNecessaria = getEquipamentosDomesticosST().get(ed).getPotenciaNecessaria();
                float novaSomaPotenciasEquipamentosDomesticos = this.getSomaPotenciasEquipamentosDomesticos() - atualPotenciaNecessaria + novaPotenciaNecessaria;
                if (novaSomaPotenciasEquipamentosDomesticos > this.getPotenciaContador()) {
                    System.out.println("Esta casa nao suporta a nova potencia deste equipamento.");
                    return;
                }
                getEquipamentosDomesticosST().get(ed).setTipoEquipamentoDomestico(novoTipoEquipamentoDomestico);
                getEquipamentosDomesticosST().get(ed).setPotenciaNecessaria(novaPotenciaNecessaria);
                this.setSomaPotenciasEquipamentosDomesticos(novaSomaPotenciasEquipamentosDomesticos);
            }
        }
    }

    /**
     * R3 R5 Remove um equipamento produtor pelo seu id
     *
     * @param idEquipamentoProdutor
     */
    public void removerEquipamentoProdutor(int idEquipamentoProdutor) {
        for (Integer ep : getEquipamentosProdutoresST().keys()) {
            if (getEquipamentosProdutoresST().get(ep).getIdEquipamentoProdutor() == (idEquipamentoProdutor)) {
                float energia = getEquipamentosProdutoresST().get(ep).getPotenciaProduzida();
                getEquipamentosProdutoresST().delete(ep);
                this.setSomaEnergiaEquipamentosProdutores(this.getSomaEnergiaEquipamentosProdutores() - energia);
            }
        }
    }

    /**
     * R3 R5 Remove um equipamento domestico pelo seu id
     *
     * @param idEquipamentoDomestico
     */
    public void removerEquipamentoDomestico(int idEquipamentoDomestico) {
        for (Integer ed : getEquipamentosDomesticosST().keys()) {
            if (getEquipamentosDomesticosST().get(ed).getIdEquipamentoDomestico() == (idEquipamentoDomestico)) {
                this.setSomaPotenciasEquipamentosDomesticos(this.getSomaPotenciasEquipamentosDomesticos() - this.getEquipamentosProdutoresST().get(ed).getPotenciaProduzida());
                for (Integer hu : getEquipamentosDomesticosST().get(ed).getHistoricoUtilizacaoST().keys()) {
                    getEquipamentosDomesticosST().get(ed).getHistoricoUtilizacaoST().delete(hu);
                }
                getEquipamentosDomesticosST().delete(ed);
            }
        }
    }

    /**
     * R15 Verifica se a casa gera energia suficiente Caso gere essa energia
     * significa que é auto sustentavel
     *
     * @return
     */
    public boolean casaAutoSustentavel() {
        float energiaUtilizada = 0;
        for (Integer i : getEquipamentosDomesticosST().keys()) {
            EquipamentoDomestico ed = getEquipamentosDomesticosST().get(i);
            if (ed.isLigado()) {
                energiaUtilizada = energiaUtilizada + ed.getPotenciaNecessaria();
            }
        }
        if (this.somaEnergiaEquipamentosProdutores > energiaUtilizada) {
            return true;
        }
        float energiaNecessaria = energiaUtilizada - this.somaEnergiaEquipamentosProdutores;
        System.out.println("Necessita de produzir " + energiaNecessaria + " para ser autosustentavel.");
        return false;
    }

    /**
     * R12 a) Lista todo o consumo de todos os equipamentos domesticos
     *
     * @param inicio
     * @param fim
     */
    public void listarConsumoPeriodoTempo(Date inicio, Date fim) {
        for (Integer i : getEquipamentosDomesticosST().keys()) {
            EquipamentoDomestico ed = getEquipamentosDomesticosST().get(i);
            for (Integer j : ed.getHistoricoUtilizacaoST().keys()) {
                HistoricoUtilizacao h = ed.getHistoricoUtilizacaoST().get(j);
                if (h.getDataLigado().afterDate(inicio) && h.getDataLigado().beforeDate(fim)) {
                    System.out.println("Equipamento " + ed.getIdEquipamentoDomestico() + " ligado");
                    System.out.println("Energia Necessaria: " + ed.getPotenciaNecessaria());
                    System.out.println("");
                }
                if (h.getDataDesligado().afterDate(inicio) && h.getDataDesligado().beforeDate(fim)) {
                    System.out.println("Equipamento " + ed.getIdEquipamentoDomestico() + " desligado");
                    System.out.println("Energia Necessaria: " + ed.getPotenciaNecessaria());
                    System.out.println("");
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Casa " + getIdCasa() + ":\n" 
                + "potenciaContador=" + potenciaContador
                + ",\nsomaPotenciasEquipamentosDomesticos=" + somaPotenciasEquipamentosDomesticos
                + ",\nsomaEnergiaEquipamentosProdutores=" + somaEnergiaEquipamentosProdutores
                + ",\nidZona=" + idZona;
    }
}
