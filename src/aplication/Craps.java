package aplication;

import java.security.SecureRandom;

public class Craps {
	
	private static final SecureRandom sr = new SecureRandom(); //Criando o gerador seguro de numeros aleatorios
	
	private enum Status{CONTINUE, WIN, LOST}; //tipo enum com constantes que representa o status do jogo.
	
	//Constantes que representam lançamentos comuns dos dados.
	private static final int SNAKE_EYES = 2;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int YO_ELEVEN = 11;
	private static final int BOX_CARS = 12;
	
	
	// Joga uma partida de craps
	public static void main(String[] args) {
		
		
		int myPoint = 0; //Pontos se não ganhar ou perder na primeira rolagem
		Status gameStatus; //Contem o que tem dentro do ENUM.
		
		int sumOfDice = rollDice(); //Primeira roalgem do jogo.
		
		switch(sumOfDice) {
		
		case SEVEN: //Ganha com 7 no primeiro lançamento
		case YO_ELEVEN: //ganha com 11 no primeiro lançamento
			gameStatus = Status.WIN;
			break;
		case SNAKE_EYES: //Perde com 2 no primeiro lançamento
		case TREY: //Perde com 3 no primeiro lançamento
		case BOX_CARS: //Perde com 12 no primeiro lançamento
			gameStatus = Status.LOST;
			break;
		default: //Não ganhou e nem perdeu no primeiro lançamento
			gameStatus = Status.CONTINUE;
			myPoint = sumOfDice;
			System.out.printf("Point is %d%n", myPoint);
			break;
		
		}
		
		while(gameStatus == Status.CONTINUE) {
			sumOfDice = rollDice();
			
			if(sumOfDice == myPoint) {
				gameStatus = Status.WIN;
			}else {
				if(sumOfDice == SEVEN) {
					gameStatus = Status.LOST;
				}
			}
				
		}
		
		if(gameStatus == Status.WIN) {
			System.out.println("Players won");
		}else {
			System.out.println("Players loses");
		}
		

	}
	
	
	public static int rollDice() {
		
		int die1 = 1 + sr.nextInt(6);
		int die2 = 1 + sr.nextInt(6);
		
		int sum = die1 + die2;
		
		System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);
		return sum;
	}
	

}
