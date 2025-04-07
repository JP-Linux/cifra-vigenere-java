package cifradevigenere;

/**
 * Controlador principal para operações de cifra de Vigenère.
 * Coordena o ajuste de tamanho entre mensagem e chave, valida dados
 * e executa o processo de criptografia/descriptografia.
 * 
 * @author Jorge Paulo Santos
 */
public class ControladorVigenere {
    private String mensagem;
    private String chave;
    private final boolean criptografar;
    private final IgualarTamTexto igualador = new IgualarTamTexto();
    private final ManipulaTabela processador = new ManipulaTabela();

    /**
     * Constrói um controlador para operação de Vigenère.
     * 
     * @param mensagem Texto a ser processado (original ou cifrado)
     * @param chave Chave de criptografia/descriptografia
     * @param criptografar True para criptografar, False para descriptografar
     * @throws IllegalArgumentException Se mensagem ou chave forem vazias
     */
    public ControladorVigenere(String mensagem, String chave, boolean criptografar) {
        validarEntradas(mensagem, chave);
        this.mensagem = mensagem;
        this.chave = chave;
        this.criptografar = criptografar;
    }

    /**
     * Executa o processo completo de cifragem/decifragem.
     * 
     * @return Texto processado conforme operação solicitada
     * @throws IllegalStateException Se ocorrer erro durante o processamento
     */
    public String cifraVigenere() {
        ajustarTamanhos();
        return processador.vigenere(this.mensagem, this.chave, this.criptografar);
    }

    /**
     * Ajusta mensagem e chave para terem o mesmo tamanho,
     * repetindo caracteres ciclicamente quando necessário.
     */
    private void ajustarTamanhos() {
        final int tamanhoMensagem = mensagem.length();
        final int tamanhoChave = chave.length();

        if(tamanhoMensagem > tamanhoChave) {
            this.chave = igualador.igualar(chave, tamanhoMensagem);
        } else if(tamanhoMensagem < tamanhoChave) {
            this.mensagem = igualador.igualar(mensagem, tamanhoChave);
        }
        // Se forem do mesmo tamanho, nenhum ajuste necessário
    }

    /**
     * Valida as entradas antes do processamento.
     * 
     * @throws IllegalArgumentException Se qualquer entrada for inválida
     */
    private void validarEntradas(String mensagem, String chave) {
        if(mensagem == null || mensagem.isEmpty()) {
            throw new IllegalArgumentException("Mensagem não pode ser vazia");
        }
        if(chave == null || chave.isEmpty()) {
            throw new IllegalArgumentException("Chave não pode ser vazia");
        }
    }
}