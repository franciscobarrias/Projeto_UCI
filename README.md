Monitorização de Pacientes internados numa UCI (Orientado a Objetos)

Introdução
Este documento fornece uma explicação detalhada sobre a implementação de um sistema de monitorização de pacientes internados numa Unidade de Cuidados Intensivos (UCI). O objetivo principal do sistema é permitir a recolha, armazenamento e análise contínua de sinais vitais dos pacientes, possibilitando a deteção precoce de condições críticas e garantindo uma resposta rápida por parte da equipa médica.
Os conceitos fundamentais aplicados incluem herança, encapsulamento, interfaces, persistência de dados, manipulação de coleções, tratamento de dados estatísticos e validação de dados. Cada componente foi projetado para desempenhar uma função específica, permitindo que o software seja facilmente escalável e adaptável a novas necessidades.
Estrutura do Sistema
O sistema é constituído por diversas classes e interfaces organizadas segundo as suas responsabilidades e funções específicas. A estrutura do código é dividida nas seguintes secções:
Interface:
•	Monitorizacao: Define um contrato para todas as classes que implementam a funcionalidade de registo e monitorização de sinais vitais, garantindo uniformidade na manipulação dos dados de saúde dos pacientes.
Classes Principais:
•	Pessoa: Superclasse que define atributos comuns a todas as entidades do sistema que representam indivíduos, como nome, data de nascimento, altura e peso.
•	Paciente: Especialização de Pessoa, adicionando atributos para armazenar e atualizar sinais vitais, incluindo frequência cardíaca, temperatura corporal e saturação de oxigénio. Implementa a interface Monitorizacao.
•	TecnicoSaude: Especialização de Pessoa, adicionando um atributo que identifica a categoria profissional do técnico de saúde e as suas funções na monitorização dos pacientes.
Gestão de Dados:
•	GestorPacientes: Classe que gere listas de pacientes e técnicos de saúde. Fornece métodos para adicionar, ordenar e listar informações, além de extrair dados para análises estatísticas detalhadas.
•	FicheiroPacientes: Implementa métodos para leitura e escrita de dados em ficheiros, garantindo a persistência da informação e evitando perda de dados entre diferentes execuções do programa.
Processamento e Estatísticas:
•	Estatisticas: Classe responsável pelo cálculo de medidas estatísticas sobre os sinais vitais, incluindo média, desvio padrão, valores mínimos e máximos, além da percentagem de pacientes classificados como críticos.
Execução do Programa:
•	Main: Classe principal que contém o ponto de entrada do programa e gere a interação com o utilizador através de um menu interativo, permitindo a execução de ações como adicionar pacientes, atualizar sinais vitais, visualizar estatísticas e guardar dados.
Explicação Minuciosa das Classes
Interface Monitorizacao
A interface Monitorizacao é utilizada para definir um método obrigatório que todas as classes que a implementam devem possuir. Esse método permite o registo e atualização dos sinais vitais dos pacientes. A interface promove a extensibilidade do sistema, permitindo que futuras classes possam integrar a funcionalidade de monitorização sem modificar a estrutura do código base.
Classe Pessoa
A classe Pessoa é a superclasse genérica do sistema, contendo atributos essenciais para representar qualquer indivíduo dentro do programa:
•	Nome: Identificação única de cada pessoa.
•	Data de nascimento: Informação utilizada para ordenação e cálculos relacionados à idade.
•	Altura: Medida em metros, relevante para análises médicas e cálculos de saúde.
•	Peso: Informação em quilogramas, utilizada para determinar índices de saúde e possíveis riscos clínicos.
A classe fornece métodos de acesso seguros (getters), garantindo encapsulamento e evitando modificações indevidas nos dados.
Classe Paciente
A classe Paciente herda de Pessoa e adiciona atributos diretamente relacionados com a monitorização da saúde:
•	Frequência cardíaca: Mede o número de batimentos cardíacos por minuto (bpm).
•	Temperatura corporal: Mede a temperatura do paciente em graus Celsius.
•	Saturação de oxigénio: Percentagem de oxigénio presente no sangue.
A classe Paciente implementa um mecanismo de classificação do estado do paciente, categorizando-os em:
•	Normal: Todos os sinais vitais dentro dos intervalos considerados saudáveis.
•	Atenção: Pelo menos um dos sinais vitais apresenta um pequeno desvio dos valores ideais.
•	Crítico: Valores que indicam um risco elevado para a saúde do paciente, exigindo atenção médica imediata.
Além disso, a classe contém métodos de validação que garantem que os valores dos sinais vitais registados estão dentro de intervalos aceitáveis.
Classe TecnicoSaude
A classe TecnicoSaude representa um profissional de saúde que acompanha e monitoriza os pacientes. Além dos atributos herdados de Pessoa, contém um atributo adicional:
•	Categoria profissional: Especifica o papel do técnico dentro da unidade hospitalar.
Este atributo é fundamental para diferenciar os técnicos de acordo com as suas especializações e responsabilidades.
Classe GestorPacientes
A classe GestorPacientes gere as listas de pacientes e técnicos de saúde, oferecendo funcionalidades como:
•	Adição de novos pacientes e técnicos.
•	Ordenação de pacientes por data de nascimento.
•	Ordenação de técnicos alfabeticamente.
•	Geração de listas de sinais vitais para análises estatísticas.
Essa classe centraliza e organiza os dados, garantindo eficiência na gestão da informação.
Classe Estatisticas
A classe Estatisticas é responsável pelo processamento dos sinais vitais e execução de cálculos estatísticos, tais como:
•	Média dos sinais vitais.
•	Determinação dos valores mínimos e máximos.
•	Cálculo do desvio padrão.
•	Percentagem de pacientes críticos.
Essa funcionalidade é essencial para auxiliar na tomada de decisões médicas baseadas em dados concretos.
Classe FicheiroPacientes
A classe FicheiroPacientes garante a persistência dos dados do sistema, evitando a perda de informações. Suas principais funcionalidades incluem:
•	Leitura de pacientes e técnicos de saúde a partir de ficheiros.
•	Gravação dos dados em ficheiros para armazenamento seguro.
•	Validação dos dados carregados para garantir a integridade das informações.
Classe Main
A classe Main é o ponto de entrada do programa e fornece um menu interativo para o utilizador. As opções disponíveis incluem:
•	Adicionar novos pacientes e técnicos.
•	Listar pacientes e técnicos.
•	Atualizar sinais vitais de um paciente.
•	Exibir estatísticas detalhadas.
•	Guardar os dados antes de encerrar o programa.
Conclusão
O sistema desenvolvido proporciona uma gestão eficiente e precisa dos pacientes internados numa UCI, garantindo que os sinais vitais sejam corretamente analisados e armazenados. A abordagem estatística complementa o trabalho da equipa médica, fornecendo insights valiosos sobre o estado de saúde dos pacientes e auxiliando na tomada de decisões estratégicas.
