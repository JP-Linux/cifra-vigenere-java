# Cifra de Vigenère em Java

[![GitHub Pages](https://img.shields.io/badge/GitHub%20Pages-Live-brightgreen)](https://jp-linux.github.io)
[![Java](https://img.shields.io/badge/Java-17%2B-blue.svg)](https://java.com)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/licenses/MIT)

Implementação gráfica da cifra de Vigenère com interface Swing, permitindo criptografia e descriptografia de textos.

![Interface Vigenere](gif/Vigenere.gif) 

## 🚀 Funcionalidades

- Criptografia/Descriptografia de textos
- Ajuste automático do tamanho da chave
- Interface gráfica intuitiva
- Tratamento de erros e validações
- Suporte para caracteres A-Z e espaço

## 📥 Download

Baixe a versão mais recente:
- [Cifra de Vigenère (JAR)](https://github.com/JP-Linux/cifra-vigenere-java/releases/download/v1.0.0/cifra-vigenere-java-1.0.0.jar)

## 📦 Pré-requisitos

- Java 17 ou superior
- Maven (para compilação via linha de comando)
- Git (para clonar o repositório)
- IDE Java opcional (Eclipse, IntelliJ, VS Code)

## 🛠️ Como Executar

### 1. Clonar o repositório
```bash
git clone https://github.com/JP-Linux/cifra-vigenere-java.git
cd cifra-vigenere-java
```

### 2. Execução na IDE
1. Importe o projeto como projeto Maven existente
2. Localize e execute a classe principal:
   ```java
   cifradevigenere.CifraDeVigenere
   ```

### 3. Execução via linha de comando

#### Opção 1: Execução direta com Maven
```sh
mvn clean compile exec:java -Dexec.mainClass="cifradevigenere.CifraDeVigenere"
```

#### Opção 2: Construindo e executando o JAR
1. Construa o projeto:
```sh
mvn clean package
```

2. Execute o JAR gerado:
```sh
java -jar target/cifra-vigenere-java-*.jar
```

#### Opção 3: Execução simplificada (Linux/macOS)
1. Crie um arquivo `run.sh`:
```bash
#!/bin/bash
mvn clean package
java -jar target/cifra-vigenere-java-*.jar
```

2. Dê permissão de execução:
```bash
chmod +x run.sh
```

3. Execute:
```bash
./run.sh
```


## 🖥️ Como Usar

1. #### Insira a mensagem (texto claro ou cifrado)

2. #### Digite a chave (apenas letras maiúsculas e espaço)

3. #### Selecione a operação:

   - "Criptografar" para cifrar o texto
   - "Descriptografar" para decifrar

4. #### Clique em "Executar"

## 🔍 Características Técnicas

- **Arquitetura**: MVC (Model-View-Controller)
- **Componentes:**
  - `ControladorVigenere`: Lógica principal de processamento
  - `TabelaVigenere`: Tabela de substituição personalizada
  - `IgualarTamTexto`: Ajuste cíclico da chave

- **Validações**:
  - Campos obrigatórios
  - Caracteres válidos
  - Tratamento de exceções

## 📌 Notas

- #### Caracteres válidos: A-Z (maiúsculas) e espaço

- #### A chave será repetida ciclicamente para igualar ao tamanho do texto

- #### Não suporta caracteres especiais ou acentuados

## 📄 Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.

---

Desenvolvido por Jorge Paulo Santos 👨💻
