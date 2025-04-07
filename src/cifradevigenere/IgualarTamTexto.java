package cifradevigenere;

/**
 * Classe responsável por ajustar o tamanho de um texto repetindo-o até atingir o comprimento desejado.
 * Útil para igualar o tamanho da chave ao tamanho do texto na cifra de Vigenère.
 * 
 * @author Jorge Paulo Santos
 */
public class IgualarTamTexto {

    /**
     * Ajusta o texto para o tamanho especificado repetindo seus caracteres ciclicamente.
     * 
     * @param texto Texto original a ser ajustado
     * @param tamanho Tamanho desejado para o texto resultante
     * @return Novo texto com o comprimento especificado
     * @throws IllegalArgumentException Se o texto de entrada for vazio
     * 
     * @Exemplo
     * igualar("ABC", 5) → "ABCAB"
     * igualar("XYZ", 3) → "XYZ"
     */
    public String igualar(String texto, int tamanho) {
        // Validação de entrada básica
        if (texto.isEmpty()) {
            throw new IllegalArgumentException("O texto não pode ser vazio");
        }

        final int comprimentoOriginal = texto.length();
        StringBuilder novoTexto = new StringBuilder(tamanho);

        // Preenche o texto novo usando caracteres cíclicos do original
        for (int i = 0; i < tamanho; i++) {
            int indiceAtual = i % comprimentoOriginal;
            novoTexto.append(texto.charAt(indiceAtual));
        }

        return novoTexto.toString();
    }
}