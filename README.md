# chatbot-ia

### Assistente inteligente para equipes ágeis

O chatbot-ia é um assistente inteligente projetado para auxiliar equipes ágeis. Ele utiliza inteligência artificial para otimizar diversas práticas e cerimônias do Scrum, como a priorização de backlog, a criação de user stories e a identificação de impedimentos.

---

### Funcionalidades

* **Scrum Master Virtual**: Guia a equipe, sugere melhorias no processo e detecta possíveis obstáculos.
* **Gerador de User Stories**: Transforma requisitos em histórias de usuário claras, incluindo critérios de aceitação.
* **Priorizador de Backlog**: Organiza funcionalidades com base no método **MoSCoW** (Must have, Should have, Could have, Won't have).
* **Sprint Planning**: Ajuda na estimativa de pontos para cada história.
* **Detector de Impedimentos**: Analisa os relatos da Daily Scrum para identificar e sugerir soluções para impedimentos.
* **Facilitador de Retrospectiva**: Organiza feedbacks no formato **Start, Stop, Continue** e propõe planos de ação.
* **Product Owner Virtual**: Simula interações e valida as entregas da equipe.
* **Gerador de Kanban**: Cria automaticamente um quadro Kanban para organizar tarefas.

---

### Tecnologias Utilizadas

* Java 24
* Maven 3.5.5
* Ollama 3.2
* Spring Boot
* Spring AI
* Spring Web

---

### Instalação

Para começar a usar o **chatbot-ia**, siga estes passos:

1.  **Clone o repositório:**
    ```bash
    git clone git@github.com:cassimirodev/chatbot-ia.git
    cd chatbot-ia
    ```

2.  **Instale e configure o Ollama:**

    Baixe e instale o **Ollama** no seu sistema operacional.

    2.1. **Para Windows**:

    Basta baixar no site [clicando aqui](https://ollama.com/download/windows)

    2.2. **Para Linux**:

        curl -fsSL https://ollama.com/install.sh | sh

        ollama run llama3.2:1b

3.  **Execute a aplicação:**
    * Compile o projeto usando Maven:
        ```bash
        mvn clean install
        ```
    * Inicie a aplicação Spring Boot:
        ```bash
        mvn spring-boot:run
        ```

---

### Como Usar

Acesse os endpoints em `http://localhost:8080`.

**Endpoints disponíveis:**

* `GET /scrum-master`
* `GET /user-story-generator`
* `GET /backlog-prioritizer`
* `GET /sprint-planning`
* `GET /impediment-detector`
* `GET /retrospective-facilitator`
* `GET /virtual-po`
* `GET /kanban-generator`

Para a requisição é necessário passar o parâmetro atráves do ```?userInput=```, veja o exemplo abaixo:

**Exemplo de requisição**
```bash
curl "http://localhost:8080/scrum-master?userInput=Quais impedimentos temos hoje?"
```

## Licença

Este projeto está sob a licença [MIT](https://choosealicense.com/licenses/mit/). 