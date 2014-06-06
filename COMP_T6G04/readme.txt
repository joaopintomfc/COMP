**PROJECT TITLE: EMatJav
**GROUP: T6G4

Jo�o Carlos Costa Pinto - 201109288 - ei11091@fe.up.pt - GRADE: 17 - CONTRIBUTION: 25%

Luis Filipe Ferreira Ara�jo - 201100659 - ei11059@fe.up.pt - GRADE: 19 - CONTRIBUTION: 25%

Miguel Ferreira da Cunha Poeira - 201109134 - ei11143@fe.up.pt - GRADE: 17 - CONTRIBUTION: 25%

Mike Santos Pinto - 201103127 - ei11050@fe.up.pt - GRADE: 19 - CONTRIBUTION: 25%


**SUMMARY: O EMatJav permite aos programadores fazerem opera��es com matrizes de for�a f�cil e sem complica��es. Esse c�digo deve ser escrito num coment�rio identificado com a tag @mat. Est�o dispon�veis as quatro opera��es b�sicas: somar, subtrair, multiplicar e dividir.

**DEALING WITH SYNTACTIC ERRORS: Existindo um erro sint�tico, o parser lan�a uma excep��o indicando qual � o erro e onde se encontra esse erro.

**SEMANTIC ANALYSIS: * Verifica se os tamanhos das matrizes est�o em concord�ncia
             	     * Verifica se os tipos de dados est�o em concord�ncia
                     * Verifica se a precis�o n�o � perdida (por exemplo: input do tipo float e output do tipo int), lan�ando um warning
                     * Verifica se as matrizes s�o quadradas
                     * Verifica se as matrizes s�o utilizadas para o fim declarado
                       (output apenas guarda resultados, input serve apenas como operando de c�lculos)

**INTERMEDIATE REPRESENTATIONS (IRs): 
	* AST:
		Root: Com N filhos correspondentes a N opera��es, a N n�s atribui��o (=)
		N�s atribui��o: 1� filho com a vari�vel resultado; outros filhos s�o n�s par�nteses (pode ter ou n�o) e um n� opera��o ou vari�vel; todos os filhos s�o ordenados por ordem de leitura.
		N�s par�nteses (n�s folha): Representamos na AST os par�nteses que lemos na gram�tica, porque podem alterar a preced�ncia de opera��es.
		N�s opera��o (*,/,+,-): T�m sempre 2 filhos opera��o/vari�vel e, podem ter n�s par�nteses como filhos tamb�m.
		N�s vari�vel (n�s folha): Representa a vari�vel usada, caso os indices de range sejam usados, s�o representados neste n�.
	* Tabela de s�mbolos: Cont�m todos os s�mbolos (vari�veis) lidos dentro da tag. Cada s�mbolo cont�m a informa��o referente ao tipo de vari�vel (int, double, float), do seu range, do seu s�mbolo e se � uma vari�vel para input ou output. A ordem na tabela representa a ordem em que as vari�veis s�o declaradas.

**CODE GENERATION: A gera��o de c�digo � feita de forma a respeitar as prioridades das opera��es (quando n�o existem par�nteses), da mesma forma que respeita as prioridades definidas pelos par�nteses. O c�digo gerado utiliza uma biblioteca de opera��es de matrizes (jama). Quando estamos num n� +,- a gera��o de c�digo � feita dando prioridade ao filho � esquerda. Quando estamos num n� *,/ a gera��o j� � feita dando prioridade ao pr�prio n�. Isto para garantir a preced�ncia de opera��es *,/ sobre as outras.

**TESTSUITE AND TEST INFRASTRUCTURE: Os testes realizados cobrem os casos de utiliza��o poss�veis. Foram gerados testes que sucedem
(validam, portanto, a DSL) e testes que n�o sucedem (validando o tratamento de erros). Estes teste produzem o respectivo output na consola.
O programa recebe pela linha de comandos o caminho do ficheiro a fazer parse originando o ficheiro convertido numa pasta 'output' no mesmo diret�rio do execut�vel. Para testar v�rios testes em simult�neo foram criados 2 scripts (bash para linux ou batch para windows) que executam o programa com cada ficheiro no diret�rio espeficado (runExamples.* -> examples e runSuite.* -> testsuite).

**TASK DISTRIBUTION: * Gram�tica: todos
                     * Representa��o Interm�dia: Luis e Mike
                     * Gera��o de C�digo: Jo�o e Miguel

**PROS: * Simplifica o c�lculo com matrizes
        * Suporta prioridade de opera��es com par�ntesis
        * Suporta prioridade de multiplica��o sobre a soma

**CONS: * N�o utiliza a tabela de s�mbolos do java
        * Apenas suporta matrizes quadradas (devido � especifica��o do projeto)
