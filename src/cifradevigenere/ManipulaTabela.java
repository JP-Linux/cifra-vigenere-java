package cifradevigenere;

/**
 * Classe responsável por processar textos e aplicar a cifra de Vigenère.
 * Realiza conversão entre caracteres e índices da tabela, além de executar
 * as operações de criptografia e descriptografia.
 * 
 * @author Jorge Paulo Santos
 */
public class ManipulaTabela {

    private final TabelaVigenere tabela = new TabelaVigenere();

    /**
     * Converte uma string em um array de índices conforme a tabela de Vigenère.
     * 
     * @param texto Texto original a ser convertido
     * @return Array de índices correspondentes aos caracteres na tabela
     * @throws IllegalArgumentException Se o texto contiver caracteres inválidos
     */
    public int[] tratamentoEntrada(String texto) {
        char[] caracteres = texto.toCharArray();
        int[] indices = new int[caracteres.length];
        
        for(int i = 0; i < caracteres.length; i++) {
            indices[i] = tabela.getIndice(caracteres[i]);
        }
        return indices;
    }

    /**
     * Executa a cifra de Vigenère sobre o texto fornecido.
     * 
     * @param mensagem Texto a ser processado (original ou cifrado)
     * @param chave Chave para criptografia/descriptografia
     * @param criptografar True para criptografar, False para descriptografar
     * @return Texto processado conforme a operação solicitada
     * @throws IllegalArgumentException Se mensagem ou chave contiverem caracteres inválidos
     */
    public String vigenere(String mensagem, String chave, boolean criptografar) {
        // Converte ambas as entradas para índices
        int[] indicesMensagem = tratamentoEntrada(mensagem);
        int[] indicesChave = tratamentoEntrada(chave);
        
        // Valida compatibilidade dos tamanhos
        if(indicesMensagem.length != indicesChave.length) {
            throw new IllegalArgumentException("Tamanho da mensagem e chave devem ser iguais");
        }

        // Processa cada caractere
        StringBuilder resultado = new StringBuilder();
        for(int i = 0; i < indicesMensagem.length; i++) {
            char caractereProcessado = criptografar 
                ? tabela.criptografar(indicesMensagem[i], indicesChave[i])
                : tabela.descriptografar(indicesMensagem[i], indicesChave[i]);
            
            resultado.append(caractereProcessado);
        }
        
        return resultado.toString();
    }
}