package br.com.jjp.rockpaperscissors;

import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.rockpaperscissors.jjp.exceptions.NoSuchStrategyError;
import br.com.rockpaperscissors.jjp.exceptions.WrongNumberOfPlayersError;

/**
 * 
 * @author Jorge
 *
 */

public class RockPaperScissors {
	
	/**
	 * 
	 * @param args the command line arguments
	 */

	public static void main(String[] args) {
		Object[] jogada = new Object[]{new String[]{"Armando", "P"}, new String[]{"Dave", "S"}};
        Object[] jogadas = new Object[]{
            new Object[]{
                new Object[]{new String[]{"Armando", "P"}, new String[]{"Dave", "S"}},
                new Object[]{new String[]{"Richard", "R"}, new String[]{"Michael", "S"}}
            },
            new Object[]{
                new Object[]{new String[]{"Allen", "S"}, new String[]{"Omer", "P"}},
                new Object[]{new String[]{"David E.", "R"}, new String[]{"Richard X.", "P"}}
            }
        };

        Regras regras = new Regras();

        try {
            String[] vencedor = regras.rps_game_winner(jogada);
            System.out.println("Jogo rock-paper-scissors - Vencedor [" + vencedor[0] + ", " + vencedor[1] + "]");

            vencedor = regras.rps_tournament_winner(jogadas);
            System.out.println("Torneio rock-paper-scissors  - Vencedor [" + vencedor[0] + ", " + vencedor[1] + "]");

        } catch (WrongNumberOfPlayersError ex) {
            Logger.getLogger(RockPaperScissors.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchStrategyError ex) {
            Logger.getLogger(RockPaperScissors.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
