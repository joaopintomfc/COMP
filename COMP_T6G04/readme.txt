**PROJECT TITLE: EMatJav
**GROUP: T6G4

João Carlos Costa Pinto - 201109288 - ei11091@fe.up.pt - GRADE: 17 - CONTRIBUTION: 25%

Luis Filipe Ferreira Araújo - 201100659 - ei11059@fe.up.pt - GRADE: 19 - CONTRIBUTION: 25%

Miguel Ferreira da Cunha Poeira - 201109134 - ei11143@fe.up.pt - GRADE: 17 - CONTRIBUTION: 25%

Mike Santos Pinto - 201103127 - ei11050@fe.up.pt - GRADE: 19 - CONTRIBUTION: 25%


**SUMMARY: O EMatJav permite aos programadores fazerem operações com matrizes de força fácil e sem complicações. Esse código deve ser escrito num comentário identificado com a tag @mat. Estão disponíveis as quatro operações básicas: somar, subtrair, multiplicar e dividir.

**DEALING WITH SYNTACTIC ERRORS: Existindo um erro sintático, o parser lança uma excepção indicando qual é o erro e onde se encontra esse erro.

**SEMANTIC ANALYSIS: * Verifica se os tamanhos das matrizes estão em concordância
             	     * Verifica se os tipos de dados estão em concordância
                     * Verifica se a precisão não é perdida (por exemplo: input do tipo float e output do tipo int), lançando um warning
                     * Verifica se as matrizes são quadradas
                     * Verifica se as matrizes são utilizadas para o fim declarado
                       (output apenas guarda resultados, input serve apenas como operando de cálculos)

**INTERMEDIATE REPRESENTATIONS (IRs): 
	* AST:
		Root: Com N filhos correspondentes a N operações, a N nós atribuição (=)
		Nós atribuição: 1º filho com a variável resultado; outros filhos são nós parênteses (pode ter ou não) e um nó operação ou variável; todos os filhos são ordenados por ordem de leitura.
		Nós parênteses (nós folha): Representamos na AST os parênteses que lemos na gramática, porque podem alterar a precedência de operações.
		Nós operação (*,/,+,-): Têm sempre 2 filhos operação/variável e, podem ter nós parênteses como filhos também.
		Nós variável (nós folha): Representa a variável usada, caso os indices de range sejam usados, são representados neste nó.
	* Tabela de símbolos: Contém todos os símbolos (variáveis) lidos dentro da tag. Cada símbolo contém a informação referente ao tipo de variável (int, double, float), do seu range, do seu símbolo e se é uma variável para input ou output. A ordem na tabela representa a ordem em que as variáveis são declaradas.

**CODE GENERATION: A geração de código é feita de forma a respeitar as prioridades das operações (quando não existem parênteses), da mesma forma que respeita as prioridades definidas pelos parênteses. O código gerado utiliza uma biblioteca de operações de matrizes (jama). Quando estamos num nó +,- a geração de código é feita dando prioridade ao filho à esquerda. Quando estamos num nó *,/ a geração já é feita dando prioridade ao próprio nó. Isto para garantir a precedência de operações *,/ sobre as outras.

**TESTSUITE AND TEST INFRASTRUCTURE: Os testes realizados cobrem os casos de utilização possíveis. Foram gerados testes que sucedem
(validam, portanto, a DSL) e testes que não sucedem (validando o tratamento de erros). Estes teste produzem o respectivo output na consola.
O programa recebe pela linha de comandos o caminho do ficheiro a fazer parse originando o ficheiro convertido numa pasta 'output' no mesmo diretório do executável. Para testar vários testes em simultâneo foram criados 2 scripts (bash para linux ou batch para windows) que executam o programa com cada ficheiro no diretório espeficado (runExamples.* -> examples e runSuite.* -> testsuite).

**TASK DISTRIBUTION: * Gramática: todos
                     * Representação Intermédia: Luis e Mike
                     * Geração de Código: João e Miguel

**PROS: * Simplifica o cálculo com matrizes
        * Suporta prioridade de operações com parêntesis
        * Suporta prioridade de multiplicação sobre a soma

**CONS: * Não utiliza a tabela de símbolos do java
        * Apenas suporta matrizes quadradas (devido à especificação do projeto)
