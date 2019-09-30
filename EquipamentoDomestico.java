package projeto;

import java.io.Serializable;
import projeto.imports.Date;
import projeto.imports.RedBlackBST_AED2;

/**
 *
 * @author Diogo Miranda & Miguel Silva
 */
public class EquipamentoDomestico implements Serializable {

    private int idEquipamentoDomestico;
    private String tipoEquipamentoDomestico;
    private float potenciaNecessaria;
    private boolean ligado;
    private Date dataLigado;
    private int casaAQuePertence;

    /**
     * RedBlack Historico
     */
    private RedBlackBST_AED2<Integer, HistoricoUtilizacao> historicoUtilizacaoST = new RedBlackBST_AED2<>();

    /**
     * @return the idEquipamentoDomestico
     */
    public int getIdEquipamentoDomestico() {
        return idEquipamentoDomestico;
    }

    /**
     * @param idEquipamentoDomestico the idEquipamentoDomestico to set
     */
    public void setIdEquipamentoDomestico(int idEquipamentoDomestico) {
        this.idEquipamentoDomestico = idEquipamentoDomestico;
    }

    public String getTipoEquipamentoDomestico() {
        return tipoEquipamentoDomestico;
    }

    public void setTipoEquipamentoDomestico(String tipoEquipamentoDomestico) {
        this.tipoEquipamentoDomestico = tipoEquipamentoDomestico;
    }

    /**
     * @return the potenciaNecessaria
     */
    public float getPotenciaNecessaria() {
        return potenciaNecessaria;
    }

    /**
     * @param potenciaNecessaria the potenciaNecessaria to set
     */
    public void setPotenciaNecessaria(float potenciaNecessaria) {
        this.potenciaNecessaria = potenciaNecessaria;
    }

    /**
     * @return the ligado
     */
    public boolean isLigado() {
        return ligado;
    }

    /**
     * @param ligado the ligado to set
     */
    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    /**
     * @return the dataLigado
     */
    public Date getDataLigado() {
        return dataLigado;
    }

    /**
     * @param dataLigado the dataLigado to set
     */
    public void setDataLigado(Date dataLigado) {
        this.dataLigado = dataLigado;
    }

    /**
     * @return the casaAQuePertence
     */
    public int getCasaAQuePertence() {
        return casaAQuePertence;
    }

    /**
     * @param casaAQuePertence the casaAQuePertence to set
     */
    public void setCasaAQuePertence(int casaAQuePertence) {
        this.casaAQuePertence = casaAQuePertence;
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

    public EquipamentoDomestico() {
    }

    /**
     * Construtor Equipamento Domestico
     *
     * @param idEquipamentoDomestico
     * @param tipoEquipamentoDomestico
     * @param potenciaNecessaria
     * @param ligado
     * @param dataLigado
     * @param casaAQuePertence
     */
    public EquipamentoDomestico(int idEquipamentoDomestico, String tipoEquipamentoDomestico, float potenciaNecessaria, boolean ligado, Date dataLigado, int casaAQuePertence) {
        this.idEquipamentoDomestico = idEquipamentoDomestico;
        this.tipoEquipamentoDomestico = tipoEquipamentoDomestico;
        this.potenciaNecessaria = potenciaNecessaria;
        this.ligado = ligado;
        this.dataLigado = dataLigado;
        this.casaAQuePertence = casaAQuePertence;
    }

    /**
     * Liga/Desliga o equipamento
     *
     * @param ligar
     */
    public void ligarDesligar(boolean ligar) {
        if (!this.isLigado()) {
            if (ligar) {
                this.setLigado(true);
                Date ligadoAgora = new Date();
                this.setDataLigado(ligadoAgora);
            }
            else{
                System.out.println("Erro: este EquipamentoDomestico ja esta desligado!");
            }
        }
        else  {
            if (ligar == true) {
                System.out.println("Erro: este EquipamentoDomestico ja esta ligado!");
            }
            if (ligar == false) {
                this.setLigado(false);
                Date desligadoAgora = new Date();
                if (this.getHistoricoUtilizacaoST().isEmpty() == true) {
                    HistoricoUtilizacao huVazio = new HistoricoUtilizacao(0, this.getDataLigado(), desligadoAgora, this.getIdEquipamentoDomestico());
                    this.getHistoricoUtilizacaoST().put(0, huVazio);
                }
                if (this.getHistoricoUtilizacaoST().isEmpty() == false) {
                    int idHistoricoUtilizacao = this.getHistoricoUtilizacaoST().max() + 1;
                    HistoricoUtilizacao hu = new HistoricoUtilizacao(idHistoricoUtilizacao, this.getDataLigado(), desligadoAgora, this.getIdEquipamentoDomestico());
                    this.getHistoricoUtilizacaoST().put(idHistoricoUtilizacao, hu);
                }
            }
        }
    }

    /**
     * R9 Permite consultar o historico
     */
    public void consultarHistoricoUtilizacao() {
        for (Integer i : getHistoricoUtilizacaoST().keys()) {
            HistoricoUtilizacao hu = getHistoricoUtilizacaoST().get(i);
            System.out.println(hu.toString());
        }
    }

    @Override
    public String toString() {
        return "Equipamento Domestico " + getIdEquipamentoDomestico() + ":\n" 
                + "Tipo equipamento domestico = " + tipoEquipamentoDomestico
                + ",\n Potencia Necessária = " + potenciaNecessaria
                + ",\n Estado Equipamento = " + ligado
                + ",\n Id casa a que pertence = " + casaAQuePertence;
    }
}
