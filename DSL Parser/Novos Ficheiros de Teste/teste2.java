/*@mat
	in int A[];
	in int B[];
	in float C[];
	out int resultado[];
	out int resultado2[];
	
	resultado = A + B - (A * B);
	
	resultado2 = (resultado * C) / (1 - C);
*/

/* Tem que dar erro de sem�ntica
 * resultado2 � INT e um dos seus
 * operandos, C, � float, perdendo-se
 * precisao
 */