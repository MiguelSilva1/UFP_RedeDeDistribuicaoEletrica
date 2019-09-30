package projeto;

import java.io.Serializable;
import projeto.imports.GraphNode;

/**
 *
 * @author Diogo Miranda & Miguel Silva
 */
public class PostoTransformacao extends GraphNode implements Serializable {

    private float energiaDisponivel;
    private float energiaEmUtilizacao;

    /**
     * @return the idPostoTransformacao
     */
    public int getIdPostoTransformacao() {
        return super.getId();
    }

    /**
     * @return the energiaDisponivel
     */
    public float getEnergiaDisponivel() {
        return energiaDisponivel;
    }

    /**
     * @param energiaDisponivel the energiaDisponivel to set
     */
    public void setEnergiaDisponivel(float energiaDisponivel) {
        this.energiaDisponivel = energiaDisponivel;
    }

    /**
     * @return the energiaEmUtilizacao
     */
    public float getEnergiaEmUtilizacao() {
        return energiaEmUtilizacao;
    }

    /**
     * @param energiaEmUtilizacao the energiaEmUtilizacao to set
     */
    public void setEnergiaEmUtilizacao(float energiaEmUtilizacao) {
        this.energiaEmUtilizacao = energiaEmUtilizacao;
    }

    public PostoTransformacao() {
    }

    /**
     * Quando insere um posto de transformaçao manualmente, incrementar o ID
     * automaticamente
     *
     * @param energiaDisponivel
     * @param energiaEmUtilizacao
     */
    public PostoTransformacao(float energiaDisponivel, float energiaEmUtilizacao) {
        super();
        this.energiaDisponivel = energiaDisponivel;
        this.energiaEmUtilizacao = energiaEmUtilizacao;
    }

    /**
     * Quando lê de um ficheiro, preencher o ID
     *
     * @param idPostoTransformacao
     * @param energiaDisponivel
     * @param energiaEmUtilizacao
     */
    public PostoTransformacao(int idPostoTransformacao, float energiaDisponivel, float energiaEmUtilizacao) {
        super();
        this.energiaDisponivel = energiaDisponivel;
        this.energiaEmUtilizacao = energiaEmUtilizacao;
    }

    @Override
    public String toString() {
        return "Posto Transformação " + getIdPostoTransformacao() + ":\n" 
                + "Energia Disponivel = " + energiaDisponivel
                + ",\nidZona=" + energiaEmUtilizacao;
    }
}
