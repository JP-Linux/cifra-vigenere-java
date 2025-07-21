package cifradevigenere;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe que representa a tabela de Vigenère personalizada, incluindo espaço (' ').
 * Os caracteres são mapeados na seguinte ordem: A-Z seguido por espaço.
 * 
 * @author Jorge Paulo Santos
 */
public class TabelaVigenere {
    
    // Tabela personalizada (A-Z + espaço)
    private final char[] tabela = { 
        'A','B','C','D','E','F','G','H','I','J','K',
        'L','M','N','O','P','Q','R','S','T','U','V',
        'W','X','Y','Z',' ' 
    };
    
    // Mapa para busca rápida de índices (caractere -> posição na tabela)
    private final Map<Character, Integer> charParaIndice = new HashMap<>();
    private final int tamanho;

    public TabelaVigenere() {
        // Preenche o mapa de índices
        for (int i = 0; i < tabela.length; i++) {
            charParaIndice.put(tabela[i], i);
        }
        this.tamanho = tabela.length;
    }

    /**
     * Criptografa um caractere usando a cifra de Vigenère.
     * 
     * @param indiceMensagem Índice do caractere da mensagem na tabela
     * @param indiceChave Índice do caractere da chave na tabela
     * @return Caractere criptografado
     */
    public char criptografar(int indiceMensagem, int indiceChave) {
        int indiceCifrado = (indiceMensagem + indiceChave) % tamanho;
        return tabela[Math.floorMod(indiceCifrado, tamanho)];
    }

    /**
     * Descriptografa um caractere usando a cifra de Vigenère.
     * 
     * @param indiceCriptografado Índice do caractere criptografado na tabela
     * @param indiceChave Índice do caractere da chave na tabela
     * @return Caractere descriptografado
     */
    public char descriptografar(int indiceCriptografado, int indiceChave) {
        int indiceOriginal = (indiceCriptografado - indiceChave) % tamanho;
        return tabela[Math.floorMod(indiceOriginal, tamanho)];
    }

    /**
     * Obtém o índice de um caractere na tabela.
     * 
     * @param caractere Caractere a ser buscado
     * @return Índice do caractere
     * @throws IllegalArgumentException Se o caractere não existir na tabela
     */
    public int getIndice(char caractere) {
        Integer indice = charParaIndice.get(Character.toUpperCase(caractere));
        if (indice == null) {
            throw new IllegalArgumentException("Caractere inválido: " + caractere);
        }
        return indice;
    }

    /**
     * @return Cópia da tabela de caracteres
     */
    public char[] getTabela() {
        return tabela.clone();
    }

    /**
     * @return Tamanho da tabela (número de caracteres)
     */
    public int getTamanho() {
        return tamanho;
    }
}